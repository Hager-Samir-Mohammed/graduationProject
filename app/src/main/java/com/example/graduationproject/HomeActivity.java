package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.home_toolBar);
        setSupportActionBar(toolbar);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                if(auth.getCurrentUser()==null){
                    finish();
                }
            }
        });

    }
    BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_nav_home:
                    //Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.bottom_nav_publishing_houses:
                    //Toast.makeText(getApplicationContext(), "Publishing Houses", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), PublishingHousesActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.bottom_nav_my_library:
                    //Toast.makeText(getApplicationContext(), "My Library", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MyLibraryActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.bottom_nav_cart:
                    Toast.makeText(getApplicationContext(), "Cart", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(getApplicationContext(), CartActivity.class));
                    overridePendingTransition(0,0);
                    break;
            }
                return false;
            }

    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem item = menu.findItem(R.id.menu_notification);
        View v = item.getActionView();
        TextView notificationNum_tv = findViewById(R.id.custom_notification_tv);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_settings:
                Intent i = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_logout:
                auth.signOut();
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
      Intent home = new Intent(Intent.ACTION_MAIN);
      home.addCategory(Intent.CATEGORY_HOME);
      home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      startActivity(home);
    }
}