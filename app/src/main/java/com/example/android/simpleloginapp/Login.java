package com.example.android.simpleloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter = 5;

    public void LoginButton(){
        username = (EditText)findViewById(R.id.textUserName);
        password = (EditText)findViewById(R.id.textPW);
        attempts = (TextView) findViewById(R.id.textViewAttempts);
        login_btn = (Button)findViewById(R.id.button);
        attempts.setText(Integer.toString(attempt_counter));
        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(username.getText().toString().equals("user") &&
                                password.getText().toString().equals("password")){
                            Toast.makeText(Login.this, "User and password is correct", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.example.android.simpleloginapp.UserActivity");
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Login.this, "User and password is NOT correct", Toast.LENGTH_SHORT).show();
                            attempt_counter--;
                            attempts.setText(Integer.toString(attempt_counter));
                            //we are through!
                            if(attempt_counter == 0) login_btn.setEnabled(false);
                        }
                    }
                }
        );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }
}
