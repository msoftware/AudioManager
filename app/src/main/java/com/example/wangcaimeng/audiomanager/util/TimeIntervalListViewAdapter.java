package com.example.wangcaimeng.audiomanager.util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wangcaimeng.audiomanager.R;



/**
 * Created by wangcaimeng on 2016/12/8.
 */

public class TimeIntervalListViewAdapter extends BaseAdapter {
    private Context context;
    public TimeIntervalListViewAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return FileOperator.getResult().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
            Log.i("position",i+"");
            view = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            TextView startTimeTxt = (TextView) view.findViewById(R.id.listItemStartTimeText);
            TextView endTimeTxt = (TextView) view.findViewById(R.id.listItemEndTimeText);
            TextView isMute = (TextView) view.findViewById(R.id.listItemIsMute);
            startTimeTxt.setText(FileOperator.getResult().get(i).getStartTime());
            endTimeTxt.setText(FileOperator.getResult().get(i).getEndTime());
            isMute.setText(FileOperator.getResult().get(i).isMute()?"静音":"响铃");

        return view;
    }
}
