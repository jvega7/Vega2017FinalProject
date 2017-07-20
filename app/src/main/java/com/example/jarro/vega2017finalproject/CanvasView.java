package com.example.jarro.vega2017finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.util.EventListener;
import java.util.Random;
import java.util.Timer;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static android.content.ContentValues.TAG;
import static com.example.jarro.vega2017finalproject.R.mipmap.ic_mole;

/**
 * Created by jarro on 7/15/2017.
 */

class CanvasView extends View {

    Bitmap mole_bm;
    int mole_x,mole_y;
    int x_dir,y_dir;
    int moleHeight, moleWidth;
    int count  = 0;
    public CanvasView(Context context) {
        super(context);
        mole_x=320;
        mole_y=470;
        x_dir=1;
        y_dir=1;
        timer();
        //Intent myIntent =  new Intent(CanvasView.this,CustomDialogScore.class);
    }




    @Override protected void onDraw(Canvas canvas) {
        ButterKnife.bind(this);
        //custom drawing
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        // make the entire canvas white
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
//
        //Import bitmap
        mole_bm = BitmapFactory.decodeResource(getResources(),R.drawable.ic_mole);
////        //make image move
        mole_x = getRandomNumberInRange(-2,canvas.getWidth()-moleWidth);
        mole_y = getRandomNumberInRange(-2,canvas.getHeight()-moleHeight);
        //check border
        //Width and height
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),R.drawable.ic_mole,option);
        moleHeight = option.outHeight;
        moleWidth = option.outWidth;
        if(mole_x>= canvas.getWidth()){
            x_dir=-1;
            mole_x=x_dir;
        }
        if(mole_x<= 0){
            x_dir=1;
            mole_x=x_dir;
        }
        if(mole_y>= canvas.getHeight()){
            y_dir=-1;
            mole_y=y_dir;
        }
        if(mole_y<= 0){
            y_dir=+1;
            mole_y=y_dir;
        }
        //old timer
        canvas.drawBitmap(mole_bm,mole_x,mole_y,null);
    }

    //find out if bit was touched
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x=(int)event.getX();
        float y=(int)event.getY();

            //Click the image
            if (x >= mole_x && x < (mole_x + mole_bm.getWidth())
                    && y >= mole_y && y < (mole_y + mole_bm.getHeight())) {
                //if this is true, you've started your click inside your bitmap
                //Log.e(TAG, "onTouchEvent: drawable touched ");
                count++;
                invalidate();

                return true;
            }
        return false;
    }

    //generate random number
    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    //timer to display score
    public void timer(){
        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {

                CustomDialogScore customDialog =
                        new CustomDialogScore(getContext(), new CustomDialogScore.ICustomDialogListener() {
                            @Override
                            public void onOKClicked(String msg) {
                                //Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();

                            }
                        });
                //count

                //
                customDialog.setCanceledOnTouchOutside(true);
                customDialog.show();
                //System.exit(0);
            }
        }.start();
    }

}
