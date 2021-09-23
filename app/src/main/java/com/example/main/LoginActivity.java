package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtusername,edtpassword;
    Button register,login;
    String Username,Password;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        //Button,EditText
        edtusername = (EditText) findViewById(R.id.textusername);
        edtpassword = (EditText) findViewById(R.id.textpassword);
        register = (Button) findViewById(R.id.btnregister);
        login = (Button) findViewById(R.id.btnlogin);
        //OnClick
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        //Create Database
        db = new Database(this, "DACN.sqlite",null,1);
        //Create database table
        db.QueryData("CREATE TABLE IF NOT IF EXITS DACN(Id INTEGER PRIMARY KEY AUTOINCREMENT, CONTENT NAME VARCHAR(200))");

        //MORE DATA

    }
    //Login
    private void signin() {
        Username = edtusername.getText().toString().trim();
        Password = edtpassword.getText().toString().trim();
        if (edtusername.getText().length() !=0 && edtpassword.getText().length() !=0)
        {
            if (edtusername.getText().toString().equals(Username) && edtpassword.getText().toString().equals(Password)) {
                Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, Main.class);
                startActivity(intent);
            }else if (edtusername.getText().toString().equals("Username") && edtpassword.getText().toString().equals("Password")){
                Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, Main.class);
                startActivity(intent);
            }else {
                Toast.makeText(LoginActivity.this,"The account is not registerd or the information is wrong",Toast.LENGTH_SHORT).show();
            }
        }else
            {
                Toast.makeText(LoginActivity.this,"Please do not leave the box empty",Toast.LENGTH_SHORT).show();
            }

    }
    //Register
    private void signup() {
        Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);
    }

}