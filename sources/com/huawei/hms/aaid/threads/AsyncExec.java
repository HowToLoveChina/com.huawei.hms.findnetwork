package com.huawei.hms.aaid.threads;

import android.util.Log;
import com.huawei.hms.opendevice.RunnableC6277o;
import com.huawei.hms.opendevice.ThreadFactoryC6265c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public abstract class AsyncExec {

    /* renamed from: a */
    private static final ThreadPoolExecutor f23041a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC6265c("SeqIO"), new ThreadPoolExecutor.AbortPolicy());

    public static void submitSeqIO(Runnable runnable) {
        try {
            f23041a.execute(new RunnableC6277o(runnable));
        } catch (Exception e10) {
            Log.e("HmsPushThreads", "submit seq io task failed, Exception:" + e10);
        }
    }
}
