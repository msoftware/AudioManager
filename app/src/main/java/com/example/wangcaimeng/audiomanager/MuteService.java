package com.example.wangcaimeng.audiomanager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.widget.Toast;

public class MuteService extends Service {
    public MuteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AudioManager aManager = (AudioManager) getSystemService(Service.AUDIO_SERVICE);
        aManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_MUTE,AudioManager.FLAG_SHOW_UI);
        aManager.adjustStreamVolume(AudioManager.STREAM_RING,AudioManager.ADJUST_MUTE,AudioManager.FLAG_SHOW_UI);
        aManager.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION,AudioManager.ADJUST_MUTE,AudioManager.FLAG_SHOW_UI);
        return START_STICKY;
    }
}
