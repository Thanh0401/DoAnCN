package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText signuser,signpass,signemail;
    Button sign;
    String signusername,signpassword,signe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signuser = (EditText) findViewById(R.id.textsignuser);
        signpass = (EditText) findViewById(R.id.textsignpass);
        signemail = (EditText) findViewById(R.id.textsignemail);
        sign = (Button) findViewById(R.id.btnsign);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signbtn();
            }
        });
    }

    private void signbtn() {
        signusername = signuser.getText().toString().trim();
        signpassword = signpass.getText().toString().trim();
        signe = signemail.getText().toString().trim();

        //Email validation
        if (!Patterns.EMAIL_ADDRESS.matcher(signe).matches())
        {
            signuser.setError("Enter valid email");return;
        }
        //Username validation
        else if (signuser.getText().toString().length()<=2)
        {
            signuser.setError("Please set valid Username");
        }
        //Password validation
        else if (signpass.getText().toString().length()<=0)
        {
            signpass.setError("Please enter Password");
        }
        //Check password Length
        else if (signpass.getText().toString().length()<=6)
        {
            signpass.setError("Too short password\n Should 6 characters or more");
        }
        else if (signuser.equals("") || signpass.equals("") || signemail.equals(""))
        {
            Toast.makeText(RegisterActivity.this, "Empty field not allow", Toast.LENGTH_SHORT).show();
        }else {

        }

    }
}