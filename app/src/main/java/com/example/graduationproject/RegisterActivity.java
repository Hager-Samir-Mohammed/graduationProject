package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
private EditText firstName_et, lastName_et, email_et, password_et;
private Button register_btn;
private TextView login_tv;
private FirebaseAuth mAuth;
private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstName_et = findViewById(R.id.register_et_fn);
        lastName_et = findViewById(R.id.register_et_ln);
        email_et = findViewById(R.id.register_et_email);
        password_et = findViewById(R.id.register_et_password);
        register_btn = findViewById(R.id.register_btn_register);
        login_tv = findViewById(R.id.register_tv_login);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.register_bp);


        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LogInActivity.class);
                startActivity(intent);
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerWithEmail(email_et.getText().toString(), password_et.getText().toString());
            }
        });
    }

    private void registerWithEmail(String email, String password){
        if(email.length()>5&&password.length()>6){
            progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                FirebaseAuth auth = FirebaseAuth.getInstance();
                                FirebaseUser user2 = auth.getCurrentUser();
                                user.sendEmailVerification()
                                        .addOnCompleteListener(new OnCompleteListener() {
                                            @Override
                                            public void onComplete(@NonNull Task task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(RegisterActivity.this, "Check your email, verified message sent", Toast.LENGTH_SHORT).show();
                                                }else{
                                                    Toast.makeText(RegisterActivity.this, "There is an error", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            } else {
                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        } else {
            if (email.length()<5){
            email_et.setError("Email not valid");
        } if(password.length()<=6){
            password_et.setError("Password should be more 6 chars");
        }
    }
}
}