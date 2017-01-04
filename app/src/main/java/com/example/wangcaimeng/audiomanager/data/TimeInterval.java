package com.example.wangcaimeng.audiomanager.data;

import java.util.Calendar;

/**
 * Created by wangcaimeng on 2016/12/8.
 */

public class TimeInterval {
    private static int count;
    private  int id;
    private String startTimeText;
    private String endTimeText;
    private boolean isMute;
    private long startTime;
    private long endTime;


    public TimeInterval( String startTimeText,String endTimeText, boolean isMute) {
        this.id = count++;
        this.endTimeText = endTimeText;
        this.startTimeText = startTimeText;
        this.isMute = isMute;
    }

    public TimeInterval(int id, String startTimeText, String endTimeText, boolean isMute) {
        this.id = id;
        this.startTimeText = startTimeText;
        this.endTimeText = endTimeText;
        this.isMute = isMute;
    }

    public void upDateTime(){
        String sTime[] = startTimeText.split(":");
        String eTime[] = endTimeText.split(":");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        int hourOfDay = Integer.parseInt(sTime[0]);
        int minute = Integer.parseInt(sTime[1]);
        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
        c.set(Calendar.MINUTE,minute);
        c.set(Calendar.SECOND,0);
        startTime=c.getTimeInMillis();
        hourOfDay = Integer.parseInt(eTime[0]);
        minute = Integer.parseInt(eTime[1]);
        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
        c.set(Calendar.MINUTE,minute);
        c.set(Calendar.SECOND,0);
        endTime=c.getTimeInMillis();
    }
    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getStartTimeText() {
        return startTimeText;
    }

    public String getEndTimeText() {
        return endTimeText;
    }

    public boolean isMute() {
        return isMute;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
