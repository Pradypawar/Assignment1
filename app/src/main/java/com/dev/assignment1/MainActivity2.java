package com.dev.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    TextView tvName,tvDOB,tvEmail;
    MaterialButton saveInfo;
    private DBHandler dbHandler;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvName = findViewById(R.id.tv_dum_name);
        tvDOB = findViewById(R.id.tv_dum_date);
        tvEmail= findViewById(R.id.tv_dum_mail);
        saveInfo = findViewById(R.id.btn_save);

        dbHandler = new DBHandler(this);

        Intent intent = getIntent();
        HashMap<String,String> userInfo = (HashMap<String, String>) intent.getSerializableExtra("key");
        String name = userInfo.get("userName").trim();
        String dob = userInfo.get("userDOB").trim();
        String email = userInfo.get("userEmail").trim();
        tvName.setText(name);
        tvDOB.setText(dob);
        tvEmail.setText(email);

        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

                if (name.isEmpty()||dob.isEmpty()||email.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Enter All Info", Toast.LENGTH_SHORT).show();
                    return;
                }
            dbHandler.addUser(name,dob,email);
                Toast.makeText(MainActivity2.this, "User Info Saved", Toast.LENGTH_SHORT).show();

            }
        });

    }
}