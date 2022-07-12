package com.example.ur5_robot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ControlsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);

        BottomNavigationView bottomNav = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new TCP_Pos_fragment()).commit();

    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.tcp_orientation:
                    selectedFragment = new TCP_Orientation_fragment();
                    break;
                case R.id.tcp_position:
                    selectedFragment = new TCP_Pos_fragment();
                    break;
                case R.id.joint_position:
                    selectedFragment = new Joint_Pos_fragment();
                    break;
            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();
            return true;
        }
    };
}