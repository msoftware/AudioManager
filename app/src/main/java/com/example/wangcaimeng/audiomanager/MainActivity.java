package com.example.wangcaimeng.audiomanager;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ToggleButton;

import com.example.wangcaimeng.audiomanager.data.TimeInterval;
import com.example.wangcaimeng.audiomanager.util.FileOperator;
import com.example.wangcaimeng.audiomanager.util.TimeIntervalListViewAdapter;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {
    private Button addTimeIntervalBtn;
    private ToggleButton startServiceBtn;
    private Button deleteAllBtn;
    private ListView timeIntervalListView;
    private TimeIntervalListViewAdapter timeIntervalListViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTimeIntervalBtn = (Button) findViewById(R.id.addTimeIntervalBtn);
        startServiceBtn = (ToggleButton) findViewById(R.id.startService);
        deleteAllBtn = (Button) findViewById(R.id.deleteAll);
        timeIntervalListView = (ListView) findViewById(R.id.timeIntervalListView);

        //声音控制服务启动与关闭

        startServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(TimeInterval timeInterval:FileOperator.getResult()){
                    AlarmManager sAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    AlarmManager eAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    if(timeInterval.isMute()){
                        Intent intent = new Intent(MainActivity.this,AddTimeIntervalAty.class);
                        PendingIntent pi = PendingIntent.getService(MainActivity.this,0,intent,0);
                        sAlarmManager.set(AlarmManager.RTC_WAKEUP,timeInterval.getStartTime(),pi);
                        intent = new Intent(MainActivity.this,RingService.class);
                        pi = PendingIntent.getService(MainActivity.this,0,intent,0);
                        eAlarmManager.set(AlarmManager.RTC_WAKEUP,timeInterval.getStartTime(),pi);

                    }

                }
            }
        });

        //绑定适配器
        //从文件获取数据
        FileOperator.getDataFromFile();
        //更新时间数据
        for(TimeInterval timeInterval : FileOperator.getResult()){
            timeInterval.upDateTime();
            Log.i("###->",Long.toString(timeInterval.getStartTime()));
            Log.i("###->",Long.toString(timeInterval.getEndTime()));

        }
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

        deleteAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setTitle("确定删除全部数据吗？").setMessage("点击确定将删除全部数据").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FileOperator.deleteAll();
                    }
                }).setNegativeButton("返回", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
            }
        });
    }

    private boolean isServiceRunning(String serviceName) {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceName.equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }


}
