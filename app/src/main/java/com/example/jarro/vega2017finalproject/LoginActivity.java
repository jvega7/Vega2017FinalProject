package com.example.jarro.vega2017finalproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);



    }
//    //onClick get the  username and passwords text using getText() and toString()
    @OnClick(R.id.sign_in_bt)
    public void login(View view){
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);

        int counter = 3;
        counter--;

        if(counter==0){
            //close the application e.t.c
            System.exit(0);
        }


        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                //correct password
                Toast toast = Toast.makeText(getApplicationContext(),"Sumbit",Toast.LENGTH_LONG);
                toast.show();
            //Move to next activity Intructions
            Intent intent = new Intent(this, InstructionActivity.class);
            startActivity(intent);
        }else{
            //wrong password
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);

            dlgAlert.setMessage("wrong password or username");
            dlgAlert.setTitle("Error Message...");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

        }
    }


}
