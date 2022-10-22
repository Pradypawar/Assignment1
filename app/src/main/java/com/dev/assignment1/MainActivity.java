package com.dev.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText etName,etDOB,etEmail;
    MaterialButton btnSub;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etDOB = findViewById(R.id.et_dob);
        etEmail = findViewById(R.id.et_email);
        btnSub = findViewById(R.id.btn_submit);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                HashMap<String,String> userInfo = new HashMap<>();

                userInfo.put("userName",etName.getText().toString().trim());
                userInfo.put("userDOB",etDOB.getText().toString().trim());
                userInfo.put("userEmail",etEmail.getText().toString().trim());
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
               intent.putExtra("key",userInfo);
               startActivity(intent);
            }
        });
    }




}