package com.example.wangcaimeng.audiomanager;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;

public class RingService extends Service {
    public RingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AudioManager aManager = (AudioManager) getSystemService(Service.AUDIO_SERVICE);
        aManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_UNMUTE,AudioManager.FLAG_SHOW_UI);
        return START_STICKY;
    }
}
