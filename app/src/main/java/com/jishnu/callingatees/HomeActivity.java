package com.jishnu.callingatees;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jishnu.callingatees.Adapter.CustomAdapter;
import com.jishnu.callingatees.Model.ApiClient;
import com.jishnu.callingatees.Model.ApiInterface;
import com.jishnu.callingatees.Model.DataList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        progressDialog = new ProgressDialog(HomeActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        recyclerView = findViewById(R.id.recycle);
        bottomNavigationView=findViewById(R.id.bottom_navigation);

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<DataList>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<DataList>>() {
            @Override
            public void onResponse(Call<List<DataList>> call, Response<List<DataList>> response) {
              progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<DataList>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(HomeActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();


            }
        });
       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.condacts:
                       Intent screen1 = new Intent(HomeActivity.this,ContactsActivity.class);
                       startActivity(screen1);
                       break;
                   case R.id.explore:
                       Intent screen2 = new Intent(HomeActivity.this,ExploreActivity.class);
                       startActivity(screen2);
                       break;
                   case R.id.notification:
                       Intent screen3 = new Intent(HomeActivity.this,NotificationActivity.class);
                       startActivity(screen3);
                       break;
                   case R.id.profile:
                       Intent screen4 = new Intent(HomeActivity.this,ProfileActivity.class);
                       startActivity(screen4);
                       break;



               }

               return false;
           }
       });

    }


    private void generateDataList(List<DataList> body) {

        recyclerView = findViewById(R.id.recycle);
        adapter = new CustomAdapter(this,body);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}