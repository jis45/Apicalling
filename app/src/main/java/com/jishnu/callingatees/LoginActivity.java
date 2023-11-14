package com.jishnu.callingatees;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jishnu.callingatees.Fragment.Login_Tab_Fragment;
import com.jishnu.callingatees.Fragment.Signup_Tab_Fragment;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    public static ViewPagerAdapter adapter;


    float v=0;

    private String[] tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabs = new String[]{getString(R.string.login), getString(R.string.signup)};
        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.Viewpaper);


        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);


//        Window window = this.getWindow();
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setStatusBarColor(ContextCompat.getColor(this,R.color.white));


    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Login_Tab_Fragment(), tabs[0]);
        adapter.addFrag(new Signup_Tab_Fragment(), tabs[1]);

        viewPager.setAdapter(adapter);



    }
    class ViewPagerAdapter extends FragmentStatePagerAdapter{

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(@NonNull FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {

            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
        public boolean onSupportNavigateUp() {
            finish();
            return true;
        }
    }
}