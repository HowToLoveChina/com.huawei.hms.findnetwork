package com.huawei.fastengine.fastview.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public final class ThreadUtil {
    public static final ThreadUtil INST = new ThreadUtil();
    private ExecutorService executors;

    private ThreadUtil() {
    }

    private ExecutorService getExecutorService() {
        if (this.executors == null) {
            try {
                this.executors = Executors.newCachedThreadPool();
            } catch (Exception unused) {
                Log.e("FastSDKEngine", "create thread service failed.");
            }
        }
        return this.executors;
    }

    public void excute(Runnable runnable) {
        excute(runnable, null);
    }

    public void excuteInMainThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void excute(Runnable runnable, String str) {
        ExecutorService executorService = getExecutorService();
        if (executorService != null) {
            executorService.execute(runnable);
        } else {
            (str != null ? new Thread(runnable, str) : new Thread(runnable)).start();
        }
    }
}
