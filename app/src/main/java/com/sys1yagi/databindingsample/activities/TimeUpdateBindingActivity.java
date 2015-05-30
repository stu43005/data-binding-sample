package com.sys1yagi.databindingsample.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityAutoUpdateTimeBinding;
import com.sys1yagi.databindingsample.models.MyTime;

import java.util.Date;

public class TimeUpdateBindingActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, TimeUpdateBindingActivity.class);
    }

    ActivityAutoUpdateTimeBinding binding;
    MyTime time;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auto_update_time);

        time = new MyTime(new Date());
        binding.setTime(time);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                time.setTime(new Date());
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }
}
