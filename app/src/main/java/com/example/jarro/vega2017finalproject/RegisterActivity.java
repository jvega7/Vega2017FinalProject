package com.example.jarro.vega2017finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        final EditText name = (EditText)findViewById(R.id.reg_name);
        final EditText password = (EditText)findViewById(R.id.reg_password);
        final EditText age = (EditText)findViewById(R.id.reg_age);
        final EditText nickname = (EditText)findViewById(R.id.reg_nickname);



    }
}
