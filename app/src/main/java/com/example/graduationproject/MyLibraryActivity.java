package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyLibraryActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_library);
        Toolbar toolbar = findViewById(R.id.home_toolBar);
        setSupportActionBar(toolbar);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
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

}