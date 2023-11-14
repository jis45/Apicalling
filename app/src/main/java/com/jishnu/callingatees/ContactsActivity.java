package com.jishnu.callingatees;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContactsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        bottomNavigationView=findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.call:
                        Intent screen1 = new Intent(ContactsActivity.this,HomeActivity.class);
                        startActivity(screen1);
                        break;
                    case R.id.explore:
                        Intent screen2 = new Intent(ContactsActivity.this,ExploreActivity.class);
                        startActivity(screen2);
                        break;
                    case R.id.notification:
                        Intent screen3 = new Intent(ContactsActivity.this,NotificationActivity.class);
                        startActivity(screen3);
                        break;
                    case R.id.profile:
                        Intent screen4 = new Intent(ContactsActivity.this,ProfileActivity.class);
                        startActivity(screen4);
                        break;



                }

                return false;
            }
        });
    }
}