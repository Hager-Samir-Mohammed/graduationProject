package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recycler1 , recycler2 , recycler3 , recycler4 , recycler5;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Toolbar toolbar = findViewById(R.id.home_toolBar);
        //setSupportActionBar(toolbar);
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

        Toolbar toolbar = findViewById(R.id.home_toolBar);
        setSupportActionBar(toolbar);
        List<Integer> super_book_fairList = new ArrayList<>();



        recycler1 = findViewById(R.id.RV_1);
        recycler1.setHasFixedSize(true);
        recycler1.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<MainBooks> booksList = new ArrayList<>();
        booksList.add(new MainBooks(R.drawable.book_interface3));
        booksList.add(new MainBooks(R.drawable.book_interface5));
        booksList.add(new MainBooks(R.drawable.book_interface2));
        booksList.add(new MainBooks(R.drawable.book_interface));
        booksList.add(new MainBooks(R.drawable.book_interface4));

        RV_AdapterOfMain rv_adapter = new RV_AdapterOfMain(booksList);
        recycler1.setAdapter(rv_adapter);



        recycler2 = findViewById(R.id.RV_2);
        recycler2.setHasFixedSize(true);
        recycler2.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<FirstBooks> books2List = new ArrayList<>();

        books2List.add(new FirstBooks(R.drawable.book9 ,"إضاءات فلسطينية" ,"رشا عبدالله سلامة" , 4.5F));
        books2List.add(new FirstBooks(R.drawable.book12 ,"إضاءات في المخارج و الصفات" ,"هدى العمروسي" , 4.5F));
        books2List.add(new FirstBooks(R.drawable.book11 ,"إضاءات في طريق العلم" ,"مؤسسة الدرر السنية" , 4.5F));
        books2List.add(new FirstBooks(R.drawable.book10 , "إضاءات أدبية" , "محمد فتحي المقداد" , 4.3F ));
        books2List.add(new FirstBooks(R.drawable.book8 ,"لا أنام" ,"إحسان عبد القدوس" , 3.5F));

        RV_AdapterOfFirst rv2_adapter = new RV_AdapterOfFirst(books2List);
        recycler2.setAdapter(rv2_adapter);



        recycler3 = findViewById(R.id.RV_3);
        recycler3.setHasFixedSize(true);
        recycler3.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<SecondBooks> books3List = new ArrayList<>();

        books3List.add(new SecondBooks(R.drawable.book3 , "نظرية الفستق 2" , "فهد عامر الأحمدي" , 3.6F ));
        books3List.add(new SecondBooks(R.drawable.book4 , "جمهورية أفلاطون" , "أحمد المنياوي" , 4.3F ));
        books3List.add(new SecondBooks(R.drawable.book1 , "KLARA AND THE SUN" , "KAZUO ISHIGURO" , 4F ));
        books3List.add(new SecondBooks(R.drawable.book10 , "إضاءات أدبية" , "محمد فتحي المقداد" , 4.3F ));
        books3List.add(new SecondBooks(R.drawable.book6 , "كيف نفهم الإسلام؟" , "محمد الغزالي" , 4.3F ));

        RV_AdapterOfSecond rv3_adapter = new RV_AdapterOfSecond(books3List);
        recycler3.setAdapter(rv3_adapter);



        recycler4 = findViewById(R.id.RV_4);
        recycler4.setHasFixedSize(true);
        recycler4.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<ThirdBooks> thirdBooksList = new ArrayList<>();

        thirdBooksList.add(new ThirdBooks(R.drawable.book9 ,"إضاءات فلسطينية" ,"رشا عبدالله سلامة"));
        thirdBooksList.add(new ThirdBooks(R.drawable.book12 ,"إضاءات في المخارج و الصفات" ,"هدى العمروسي"));
        thirdBooksList.add(new ThirdBooks(R.drawable.book11 ,"إضاءات في طريق العلم" ,"مؤسسة الدرر السنية"));
        thirdBooksList.add(new ThirdBooks(R.drawable.book10 , "إضاءات أدبية" , "محمد فتحي المقداد"));
        thirdBooksList.add(new ThirdBooks(R.drawable.book8 ,"لا أنام" ,"إحسان عبد القدوس"));

        RV_AdapterOfThird rv3_3_adapter = new RV_AdapterOfThird(thirdBooksList);
        recycler4.setAdapter(rv3_3_adapter);


        recycler5 = findViewById(R.id.RV_5);
        recycler5.setHasFixedSize(true);
        recycler5.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<FourthBooks> fourthBooksList = new ArrayList<>();

        fourthBooksList.add(new FourthBooks(R.drawable.book3 , "نظرية الفستق 2" , "فهد عامر الأحمدي"));
        fourthBooksList.add(new FourthBooks(R.drawable.book4 , "جمهورية أفلاطون" , "أحمد المنياوي"));
        fourthBooksList.add(new FourthBooks(R.drawable.book1 , "KLARA AND THE SUN" , "KAZUO ISHIGURO"));
        fourthBooksList.add(new FourthBooks(R.drawable.book10 , "إضاءات أدبية" , "محمد فتحي المقداد"));
        fourthBooksList.add(new FourthBooks(R.drawable.book6 , "كيف نفهم الإسلام؟" , "محمد الغزالي"));

        RV_AdapterOfFourth rv4_adapter = new RV_AdapterOfFourth(fourthBooksList);
        recycler5.setAdapter(rv4_adapter);



        super_book_fairList.add(R.drawable.book_interface2);
        super_book_fairList.add(R.drawable.book_interface3);
        super_book_fairList.add(R.drawable.book_interface4);

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