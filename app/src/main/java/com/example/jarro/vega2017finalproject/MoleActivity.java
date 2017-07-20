package com.example.jarro.vega2017finalproject;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MoleActivity extends AppCompatActivity {

    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customCanvas = new CanvasView(this);
        setContentView(customCanvas);
    }
}
