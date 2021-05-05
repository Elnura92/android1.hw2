package com.androidlessons.android1hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.InteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_container, FirstFragment.newInstance("first", "fragment"));
        transaction.commit();


    }

    @Override
    public void dayOfWeekClicked(String dayOfWeek) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, SecondFragment.newInstance(dayOfWeek));
        transaction.commit();


    }


}