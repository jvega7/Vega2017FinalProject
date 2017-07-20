package com.example.jarro.vega2017finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;

public class ListViewHighScoreActivity extends AppCompatActivity {

    //private ListAdapter adapter;
    String[] array = {"1. Adim First Score","2. Adim First Score","3. Adim First Score","4. Adim First Score"};

//    public ListViewHighScoreActivity(){
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_high_score);

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.activity_listview, array);
        ListView listView = (ListView) findViewById(R.id.listview_high_score_lv);
        listView.setAdapter(adapter);



        //ButterKnife.bind(this);
    }
}
