package com.jishnu.callingatees;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.atees);
        imageView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

//
//        API api = new API();
//
//        api.token(MainActivity.this);
//        api.storeurl(MainActivity.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }

    }
