package com.huawei.feedback.log;

import android.content.Context;
import android.util.Log;
import com.huawei.feedback.mail.bean.AppLog;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import p015ak.C0209d;

/* loaded from: classes5.dex */
public final class AppLogManager {
    private static final String TAG = "AppLogManager";
    private BlockingQueue<AppLog> blockingQueue;
    private boolean isStarted;
    private String logPath;
    private PrintWorker worker;

    public static class AppLogManagerHolder {
        public static AppLogManager mInstance = new AppLogManager();

        private AppLogManagerHolder() {
        }
    }

    public static AppLogManager getInstance() {
        return AppLogManagerHolder.mInstance;
    }

    private void start(Context context) {
        try {
            if (this.isStarted || !C0209d.m1309t1(context)) {
                return;
            }
            Log.i(TAG, "worker start");
            this.isStarted = true;
            this.worker.setName("PrintWorker");
            this.worker.start();
        } catch (IllegalThreadStateException unused) {
            Log.i(TAG, "worker IllegalThreadStateException");
            this.isStarted = false;
        } catch (Exception unused2) {
            Log.i(TAG, "worker IllegalThreadStateException");
            this.isStarted = false;
        }
    }

    public boolean appendLog(AppLog appLog) {
        return this.blockingQueue.offer(appLog);
    }

    public BlockingQueue<AppLog> getBlockingQueue() {
        return this.blockingQueue;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public void init(Context context) {
        this.logPath = context.getFilesDir().getPath() + File.separator + "hicloud";
        start(context);
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void setBlockingQueue(BlockingQueue<AppLog> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void setLogPath(String str) {
        this.logPath = str;
    }

    public void setStarted(boolean z10) {
        this.isStarted = z10;
    }

    public void stop() {
        this.isStarted = false;
        appendLog(new AppLog("I", TAG, "printWorker is stop"));
    }

    private AppLogManager() {
        this.blockingQueue = new ArrayBlockingQueue(256);
        this.worker = new PrintWorker();
        this.isStarted = false;
    }
}
