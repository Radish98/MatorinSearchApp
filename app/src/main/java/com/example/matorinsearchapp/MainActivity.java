package com.example.matorinsearchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment home = new Home();
        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();

        fT.add(R.id.home, home);
        fT.commit();
    }
}