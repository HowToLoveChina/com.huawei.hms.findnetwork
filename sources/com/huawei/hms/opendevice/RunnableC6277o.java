package com.huawei.hms.opendevice;

import android.util.Log;

/* renamed from: com.huawei.hms.opendevice.o */
/* loaded from: classes8.dex */
public class RunnableC6277o implements Runnable {

    /* renamed from: a */
    private final Runnable f29595a;

    public RunnableC6277o(Runnable runnable) {
        this.f29595a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f29595a;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
                Log.e("HmsPushThreads", "exception in task run");
            }
        }
    }
}
