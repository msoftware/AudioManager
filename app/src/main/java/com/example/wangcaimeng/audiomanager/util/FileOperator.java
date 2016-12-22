package com.example.wangcaimeng.audiomanager.util;

import android.os.Environment;

import com.example.wangcaimeng.audiomanager.data.TimeInterval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by wangcaimeng on 2016/12/8.
 */

public class FileOperator {
    private static String fileName = Environment.getExternalStorageDirectory().getPath()+"//dataFile.txt";
    private static File dataFile;
    private static BufferedReader fileReader;
    private static FileWriter fileWriter;
    private static ArrayList<TimeInterval> result;
    public static void getDataFromFile(){
        result = new ArrayList<>();
        String buffer;
        dataFile = new File(fileName);
        try {
            if(!dataFile.exists()){
                dataFile.createNewFile();
            }
            fileReader = new BufferedReader(new FileReader(dataFile));
            while((buffer=fileReader.readLine())!=null){
                String spiltedString[] = buffer.split("#");
                int id = Integer.parseInt(spiltedString[0]);
                String startTimeText = spiltedString[1];
                String endTimeText = spiltedString[2];
                boolean isMute = Boolean.parseBoolean(spiltedString[3]);
                long startTime = Long.parseLong(spiltedString[4]);
                long endTime = Long.parseLong(spiltedString[5]);
                result.add(new TimeInterval(id,startTimeText,endTimeText,isMute,startTime,endTime));
            }
            fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void saveDataToFile(TimeInterval timeInterval)  {
        dataFile = new File(fileName);
        try {
            if(!dataFile.exists()){
                dataFile.createNewFile();
            }
            fileWriter = new FileWriter(dataFile,true);
            StringBuffer sb = new StringBuffer();
            sb.append(timeInterval.getId()+"#");
            sb.append(timeInterval.getStartTimeText()+"#");
            sb.append(timeInterval.getEndTimeText()+"#");
            sb.append(timeInterval.isMute()+"#");
            sb.append(timeInterval.getStartTime()+"#");
            sb.append(timeInterval.getEndTime());
            sb.append("\n");
            fileWriter.write(sb.toString());
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();

        }

        return;
    }

    public static void deleteAll(){
        dataFile = new File(fileName);
        if(dataFile.exists()){
            dataFile.delete();
            result.clear();
        }
    }


    public static ArrayList<TimeInterval> getResult() {
        return result;
    }
}
