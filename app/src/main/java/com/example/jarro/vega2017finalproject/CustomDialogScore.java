package com.example.jarro.vega2017finalproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jarro on 7/16/2017.
 */

public class CustomDialogScore extends Dialog {
    //CanvasView canvvasView = new CanvasView();
    //BaseActivity base = new BaseActivity();

    private final CustomDialogScore.ICustomDialogListener listener;

    @BindView(R.id.activity_custom_score_radiogroup)
    RadioGroup radioGroup;

    //Interface for activity
    public interface ICustomDialogListener{
        public void  onOKClicked(String msg);
        // abstract void onCancelClicked();
    }

    private int checkedID = 0;
    @OnClick(R.id.activity_custom_score_ok)
    public void ok(View view){
        switch(checkedID){
            case R.id.activity_custom_score_tryagain:
                //listener.onOKClicked("You clicked yes");
                Intent intent = new Intent(getContext(),MoleActivity.class);
                getContext().startActivity(intent);

                cancel();
                break;
            case R.id.activity_custom_score_seescore:
                //listener.onOKClicked("You clicked See Score");
                Intent intent1 = new Intent(getContext(),ListViewHighScoreActivity.class);
                getContext().startActivity(intent1);

                cancel();
                break;
            case R.id.activity_custom_score_exit:
                listener.onOKClicked("GoodBye");

                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);

                break;
            default:
        }
//        listener.onOKClicked("You clicked OK");
//        cancel();
    }


    public CustomDialogScore(@NonNull final Context context, CustomDialogScore.ICustomDialogListener listener) {
        super(context,R.style.dialog);
        setContentView(R.layout.activity_custom_dialog_score);
        ButterKnife.bind(this);
        this.listener = listener;

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                //shortToast("You chose: " + checkedId);
                checkedID = checkedId;
            }
        });
        //retrieve it from bundle
//        TextView txtView = (TextView)findViewById(R.id.activity_custom_score_tv2);
//        txtView.setText("Your Score is: " + canvvasView.count);
    }


}
