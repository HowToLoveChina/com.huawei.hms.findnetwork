package com.huawei.android.remotecontrol.track;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;

/* renamed from: com.huawei.android.remotecontrol.track.g */
/* loaded from: classes4.dex */
public class C4445g {

    /* renamed from: c */
    public static C4445g f20390c = new C4445g();

    /* renamed from: a */
    public HandlerThread f20391a;

    /* renamed from: b */
    public Handler f20392b;

    /* renamed from: b */
    public static C4445g m26987b() {
        return f20390c;
    }

    /* renamed from: a */
    public void m26988a() {
        Handler handler = this.f20392b;
        if (handler == null && this.f20391a == null) {
            return;
        }
        if (handler == null) {
            this.f20391a.quit();
            this.f20391a = null;
        } else if (this.f20391a == null) {
            handler.removeCallbacksAndMessages(null);
            this.f20392b = null;
        } else {
            handler.removeCallbacksAndMessages(null);
            this.f20392b = null;
            this.f20391a.quit();
            this.f20391a = null;
        }
    }

    /* renamed from: c */
    public HandlerThread m26989c() {
        if (this.f20391a == null) {
            HandlerThread handlerThread = new HandlerThread("phonefinder_locate_track_work_thread");
            this.f20391a = handlerThread;
            handlerThread.start();
        }
        return this.f20391a;
    }

    /* renamed from: d */
    public void m26990d(Runnable runnable) {
        if (this.f20391a == null) {
            HandlerThread handlerThread = new HandlerThread("phonefinder_locate_track_work_thread");
            this.f20391a = handlerThread;
            handlerThread.start();
        }
        if (this.f20392b == null) {
            this.f20392b = new Handler(this.f20391a.getLooper());
        }
        m26991e(runnable, 0, 5);
    }

    /* renamed from: e */
    public final void m26991e(Runnable runnable, int i10, int i11) {
        HandlerThread handlerThread = this.f20391a;
        if (handlerThread == null || this.f20392b == null) {
            return;
        }
        handlerThread.setPriority(i11);
        if (this.f20391a.getThreadId() == Process.myPid()) {
            runnable.run();
        } else {
            this.f20392b.postDelayed(runnable, i10);
        }
    }
}
