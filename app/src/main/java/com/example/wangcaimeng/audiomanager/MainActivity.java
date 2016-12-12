package com.example.wangcaimeng.audiomanager;

import android.animation.TimeAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.wangcaimeng.audiomanager.util.FileOperator;
import com.example.wangcaimeng.audiomanager.util.TimeIntervalListViewAdapter;

public class MainActivity extends AppCompatActivity {
    private Button addTimeIntervalBtn;
    private ListView timeIntervalListView;
    private TimeIntervalListViewAdapter timeIntervalListViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTimeIntervalBtn = (Button) findViewById(R.id.addTimeIntervalBtn);
        timeIntervalListView = (ListView) findViewById(R.id.timeIntervalListView);

        //绑定适配器
        FileOperator.getDataFromFile();
        timeIntervalListViewAdapter = new TimeIntervalListViewAdapter(MainActivity.this);
        timeIntervalListViewAdapter.notifyDataSetChanged();
        timeIntervalListView.setAdapter(timeIntervalListViewAdapter);

        //添加时间按钮事件处理
        addTimeIntervalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //页面跳转
                Intent i = new Intent(MainActivity.this,AddTimeIntervalAty.class);
                startActivity(i);
            }
        });
    }
}
