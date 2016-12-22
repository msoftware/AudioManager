package com.example.wangcaimeng.audiomanager.data;

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


    public TimeInterval(String endTimeText, String startTimeText, boolean isMute,long startTime,long endTime) {
        this.id = count++;
        this.endTimeText = endTimeText;
        this.startTimeText = startTimeText;
        this.isMute = isMute;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeInterval(int id, String startTimeText, String endTimeText, boolean isMute,long startTime,long endTime) {
        this.id = id;
        this.startTimeText = startTimeText;
        this.endTimeText = endTimeText;
        this.isMute = isMute;
        this.startTime = startTime;
        this.endTime = endTime;
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
