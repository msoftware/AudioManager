package com.example.wangcaimeng.audiomanager.data;

/**
 * Created by wangcaimeng on 2016/12/8.
 */

public class TimeInterval {
    private static int count;
    private  int id;
    private String startTime;
    private String endTime;
    private boolean isMute;

    public TimeInterval(String endTime, String startTime, boolean isMute) {
        this.id = count++;
        this.endTime = endTime;
        this.startTime = startTime;
        this.isMute = isMute;
    }

    public TimeInterval(int id, String startTime, String endTime, boolean isMute) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isMute = isMute;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public boolean isMute() {
        return isMute;
    }
}
