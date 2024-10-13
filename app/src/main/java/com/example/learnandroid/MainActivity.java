package com.example.learnandroid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=(FrameLayout)findViewById(R.id.frameLayout);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new FirstFragment()).addToBackStack(null).commit();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment=null;
                switch(tab.getPosition()){
                    case 0:
                        fragment= new FirstFragment();
                        break;
                    case 1:
                        fragment= new SecondFragment();
                        break;
                    case 2:
                        fragment=new ThirdFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        EdgeToEdge.enable(this);
    }
}