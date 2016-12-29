package com.example.wangcaimeng.audiomanager;

import android.app.TimePickerDialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.wangcaimeng.audiomanager.data.TimeInterval;
import com.example.wangcaimeng.audiomanager.util.FileOperator;

import java.util.Calendar;

public class AddTimeIntervalAty extends AppCompatActivity {
    private TextView startTimeTxt;
    private TextView endTimeTxt;
    private RadioButton isMuteBtn;
    private Button confirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time_interval_aty);
        startTimeTxt = (TextView) findViewById(R.id.addStartTimeText);
        endTimeTxt = (TextView) findViewById(R.id.addEndTimeText);
        isMuteBtn = (RadioButton) findViewById(R.id.isMuteRBtn);
        confirmBtn = (Button) findViewById(R.id.confirmBtn);


        startTimeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickTime((TextView) view);
            }
        });

        endTimeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickTime((TextView) view);
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String startTimeText = (String)startTimeTxt.getText();
                String endTimeText = (String)endTimeTxt.getText();
                boolean isMute = isMuteBtn.isChecked();
                TimeInterval timeInterval = new TimeInterval(startTimeText,endTimeText,isMute);
                FileOperator.saveDataToFile(timeInterval);
                startActivity(new Intent(AddTimeIntervalAty.this,MainActivity.class));

            }
        });
    }

    private void pickTime(final TextView textView){
        Calendar calendar = Calendar.getInstance();
        new TimePickerDialog(AddTimeIntervalAty.this,new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                textView.setText(hourOfDay+":"+minute);
            }
        },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true).show();
    }
}
