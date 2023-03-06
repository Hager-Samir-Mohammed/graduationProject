package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

public class FirstPageActivity extends AppCompatActivity {
     Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }
               else{ Intent i = new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(i);
            }
            }
        }, 3500);


    }
}
