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
    private static ArrayList<TimeInterval> result = new ArrayList<>();
    public static void getDataFromFile(){

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
                String startTime = spiltedString[1];
                String endTime = spiltedString[2];
                boolean isMute = Boolean.parseBoolean(spiltedString[3]);
                result.add(new TimeInterval(id,startTime,endTime,isMute));
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
            sb.append(timeInterval.getStartTime()+"#");
            sb.append(timeInterval.getEndTime()+"#");
            sb.append(timeInterval.isMute());
            sb.append("\n");
            fileWriter.write(sb.toString());
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();

        }

        return;
    }

    public static ArrayList<TimeInterval> getResult() {
        return result;
    }
}
