package com.jishnu.callingatees;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    BottomNavigationView bottomNavigationView;
    private CircleImageView circleImageView;

    private LinearLayout profilelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        circleImageView=findViewById(R.id.imagepicker);
        profilelayout=findViewById(R.id.profileLayout);

       circleImageView.setOnClickListener(this);
       profilelayout.setOnClickListener(this);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.call:
                        Intent screen1 = new Intent(ProfileActivity.this,HomeActivity.class);
                        startActivity(screen1);
                        break;
                    case R.id.explore:
                        Intent screen2 = new Intent(ProfileActivity.this,ExploreActivity.class);
                        startActivity(screen2);
                        break;
                    case R.id.notification:
                        Intent screen3 = new Intent(ProfileActivity.this,NotificationActivity.class);
                        startActivity(screen3);
                        break;
                    case R.id.condacts:
                        Intent screen4 = new Intent(ProfileActivity.this,ContactsActivity.class);
                        startActivity(screen4);
                        break;



                }


                return false;
            }
        });

    }


    @Override
    public void onClick(View v) {
          switch (v.getId()){

              case  R.id.profileLayout:
                  Intent intent=new Intent(ProfileActivity.this,EditProfile.class);
                  startActivity(intent);
                  finish();
          }




    }
}