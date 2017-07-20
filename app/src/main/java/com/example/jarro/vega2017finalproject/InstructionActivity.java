package com.example.jarro.vega2017finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.jarro.vega2017finalproject.adapter.BaseViewPagerAdapter;
import com.example.jarro.vega2017finalproject.fragment.Instruction1Fragment;
import com.example.jarro.vega2017finalproject.fragment.Instruction2Fragment;
import com.example.jarro.vega2017finalproject.fragment.Instruction3Fragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InstructionActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        viewPager = (ViewPager)findViewById(R.id.activity_instruction_vp);
        list.add(new Instruction1Fragment());
        list.add(new Instruction2Fragment());
        list.add(new Instruction3Fragment());
        BaseViewPagerAdapter pagerAdapter =
                new BaseViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);
        //viewPager.setCurrentItem(1);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.activity_instruction_bt)
    public void cont(){
        Intent intent = new Intent(this,MoleActivity.class);
        startActivity(intent);
    }

    public InstructionActivity(){
        super();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
