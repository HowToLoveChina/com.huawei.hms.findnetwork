package com.huawei.openalliance.p169ad.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: com.huawei.openalliance.ad.utils.ak */
/* loaded from: classes2.dex */
public class C7737ak {

    /* renamed from: a */
    private Handler f35815a;

    public C7737ak(Handler handler) {
        this.f35815a = handler;
    }

    /* renamed from: a */
    public void m47501a(Runnable runnable) {
        m47503a(runnable, null, 0L);
    }

    /* renamed from: a */
    public void m47502a(Runnable runnable, String str) {
        if (this.f35815a == null || runnable == null) {
            return;
        }
        RunnableC7813df runnableC7813df = new RunnableC7813df(runnable);
        if (m47500a()) {
            runnableC7813df.run();
            return;
        }
        try {
            Message messageObtain = Message.obtain(this.f35815a, runnableC7813df);
            messageObtain.setAsynchronous(true);
            messageObtain.obj = str;
            this.f35815a.sendMessageAtFrontOfQueue(messageObtain);
        } catch (Throwable unused) {
            this.f35815a.postAtFrontOfQueue(runnableC7813df);
        }
    }

    /* renamed from: a */
    public void m47503a(Runnable runnable, String str, long j10) {
        if (this.f35815a == null || runnable == null) {
            return;
        }
        if (j10 < 0) {
            j10 = 0;
        }
        RunnableC7813df runnableC7813df = new RunnableC7813df(runnable);
        if (j10 == 0 && m47500a()) {
            runnableC7813df.run();
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + j10;
        try {
            Message messageObtain = Message.obtain(this.f35815a, runnableC7813df);
            messageObtain.setAsynchronous(true);
            messageObtain.obj = str;
            this.f35815a.sendMessageAtTime(messageObtain, jUptimeMillis);
        } catch (Throwable unused) {
            this.f35815a.postAtTime(runnableC7813df, str, jUptimeMillis);
        }
    }

    /* renamed from: a */
    public void m47504a(String str) {
        Handler handler = this.f35815a;
        if (handler == null || str == null) {
            return;
        }
        handler.removeCallbacksAndMessages(str);
    }

    /* renamed from: a */
    private boolean m47500a() {
        Looper looper;
        Handler handler = this.f35815a;
        if (handler == null || (looper = handler.getLooper()) == null) {
            return false;
        }
        return Thread.currentThread() == looper.getThread();
    }
}
