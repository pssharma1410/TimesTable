package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar sb = (SeekBar) findViewById(R.id.sb);
        ListView lv = (ListView) findViewById(R.id.list);
        //setting limits for seekbar
        sb.setMax(20);
        sb.setMin(1);
        //For starting position of tables till notified
        ArrayList<String> l = new ArrayList<>();
        ArrayAdapter<String> aa = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,l);
        lv.setAdapter(aa);
        for(int i = 1; i <= 10; i++){
            l.add(10+" into "+i+" = "+i*10);
        }
        aa.notifyDataSetChanged();
        //starting position end here
        //for starting seekbar progress
        sb.setProgress(10);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                ArrayList<String> l = new ArrayList<>();
                ArrayAdapter<String> aa = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,l);
                lv.setAdapter(aa);
                for(int i = 1; i <= 10; i++){
                    l.add(progress+" into "+i+" = "+i*progress);
                }
                aa.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}