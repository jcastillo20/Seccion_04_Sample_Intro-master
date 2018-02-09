package com.example.juan.mylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchRecordar;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindUI();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=editTextEmail.getText().toString();
                String password=editTextPassword.getText().toString();
                isValidLogin(email,password);
            }
        });
    }


    private void bindUI(){

        editTextEmail=(EditText)findViewById(R.id.ediTextEmail);
        editTextPassword=(EditText)findViewById(R.id.ediTextPassword);
        switchRecordar=(Switch)findViewById(R.id.switchRecordar);
        btnLogin=(Button)findViewById(R.id.buttonLogin);
    }

    private boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isvalidPassword(String password){
        return password.length()>4;
    }
    private boolean isValidLogin(String email,String password){
        if(!isValidEmail(email)){
            Toast.makeText(this, "Email  no valido, por favor intentar denuevo", Toast.LENGTH_LONG).show();
            return false;
        }else if(!isvalidPassword(password)){
            Toast.makeText(this, "Password  no valido, por favor intentar denuevo", Toast.LENGTH_LONG).show();
            return  false;
        }else {
            return true;
        }
    }

    private void gotoMain(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
