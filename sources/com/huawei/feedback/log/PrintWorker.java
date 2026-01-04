package com.huawei.feedback.log;

import android.util.Log;
import com.huawei.feedback.mail.bean.AppLog;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class PrintWorker extends Thread {
    private static final int MAX_WAIT_TIMEOUT = 60;
    private static final String TAG = "PrintWorker";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        AppLogManager appLogManager = AppLogManager.getInstance();
        if (appLogManager == null) {
            Log.i(TAG, "parent is null.");
            return;
        }
        try {
            Log.i(TAG, "start init LogWrite");
            LogWrite.init(appLogManager.getLogPath(), true);
        } catch (IOException unused) {
            Log.i(TAG, "LogWrite init IOException");
        }
        while (appLogManager.isStarted()) {
            try {
                AppLog appLogPoll = appLogManager.getBlockingQueue().poll(60L, TimeUnit.SECONDS);
                if (appLogPoll != null) {
                    LogWrite.wtf(appLogPoll.getLevel(), appLogPoll.getTag(), appLogPoll.getMsg(), null);
                } else {
                    Log.i(TAG, "PrintWoker poll timeout , shutdown");
                    LogWrite.wtf("I", TAG, "PrintWoker poll timeout , shutdown", null);
                    LogWrite.shutdown();
                    AppLog appLogTake = appLogManager.getBlockingQueue().take();
                    LogWrite.wtf(appLogTake.getLevel(), appLogTake.getTag(), appLogTake.getMsg(), null);
                }
            } catch (InterruptedException unused2) {
                Log.i(TAG, "PrintWoker InterruptedException");
            } catch (Exception unused3) {
                Log.i(TAG, "PrintWoker IllegalMonitorStateException");
            }
        }
        Log.i(TAG, "PrintWoker will flush remaining logs before exiting.");
        LogWrite.wtf("I", TAG, "PrintWoker will flush remaining logs before exiting.", null);
        for (AppLog appLog : appLogManager.getBlockingQueue()) {
            LogWrite.wtf(appLog.getLevel(), appLog.getTag(), appLog.getMsg(), null);
        }
        Log.i(TAG, "PrintWoker end.");
        LogWrite.wtf("I", TAG, "PrintWoker end.", null);
        LogWrite.shutdown();
        appLogManager.setStarted(false);
    }
}
