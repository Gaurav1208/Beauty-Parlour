package com.example.beautyparlour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity implements View.OnClickListener{

    Button signup;
    EditText email,password;
    TextView tw;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(),welcome.class));
        }

        progressDialog = new ProgressDialog(this);
        signup =  findViewById(R.id.b);
        email = findViewById(R.id.t8);
        password = findViewById(R.id.t6);
        tw = findViewById(R.id.tv);
        signup.setOnClickListener(this);

    }

    private void registerUser(){
        String name = email.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Enter your mail id",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pwd)){
            Toast.makeText(this,"Enter your password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering User ...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(name,pwd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                        finish();
                        startActivity(new Intent(getApplicationContext(),welcome.class));
                }
                else{
                    Toast.makeText(signUp.this,"Something went wrong! Check Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == signup){
            registerUser();
        }
        if(v == tw){
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
