package com.dev.assignment1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler  extends SQLiteOpenHelper {
    // DATABASE NAME
    private static final String DB_NAME = "userdb";

    // TABLE NAME
    private static final String TABLE_NAME = "userinfo";

    //DB VERSION
    private static final int DB_VERSION = 1;

    //COLUMN NAME
    private static final String ID_COL = "id";

    private static final String NAME_COL ="name";

    private static final String DOB_COL = "dob";

    private static final String EMAIL_COL = "email";



    public DBHandler (@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DOB_COL + " TEXT,"
                + EMAIL_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);

    }

    public void addUser(String name,String dob,String email){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME_COL,name);
        contentValues.put(DOB_COL,dob);
        contentValues.put(EMAIL_COL,email);

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }



    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(sqLiteDatabase);
    }
}
