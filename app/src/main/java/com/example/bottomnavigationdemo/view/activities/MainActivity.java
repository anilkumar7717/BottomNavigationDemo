package com.example.bottomnavigationdemo.view.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.bottomnavigationdemo.R;
import com.example.bottomnavigationdemo.controller.AppNavigationController;
import com.example.bottomnavigationdemo.view.fragments.ActivityFragment;
import com.example.bottomnavigationdemo.view.fragments.HomeFragment;
import com.example.bottomnavigationdemo.view.fragments.NotificationFragment;

public class MainActivity extends AppCompatActivity {
    AppNavigationController navigation;

    @Override
    public void onBackPressed() {
        navigation.backPressFrag();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment(new HomeFragment());
                    return true;
                case R.id.navigation_dashboard:
                    fragment(new ActivityFragment());
                    return true;
                case R.id.navigation_notifications:
                    fragment(new NotificationFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = new AppNavigationController(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        fragment(new HomeFragment());
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void fragment(Fragment fragment) {
        navigation.fragment(R.id.frame, fragment);
    }

}
