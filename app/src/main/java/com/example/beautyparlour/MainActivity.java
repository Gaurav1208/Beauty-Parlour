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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private EditText email,password;
    private TextView signup;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(),welcome.class));
        }
        email = findViewById(R.id.t4);
        password = findViewById(R.id.t6);
        login = findViewById(R.id.b);
        signup = findViewById(R.id.tv);
        progressDialog = new ProgressDialog(this);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);

    }

    private void userLogin(){
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
        progressDialog.setMessage("Logging you in");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(name,pwd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(),welcome.class));
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == login){
            userLogin();
        }
        if(v == signup){
            finish();
            startActivity(new Intent(this,signUp.class));
        }
    }
}
