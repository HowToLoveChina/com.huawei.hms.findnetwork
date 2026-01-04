package com.huawei.hiar;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.huawei.hiar.annotations.UsedByNative;

@UsedByNative("ar_callback_thread.cpp")
/* loaded from: classes5.dex */
class ArCallbackThread {

    /* renamed from: d */
    public static final String f22031d = "ArCallbackThread";

    /* renamed from: e */
    public static volatile ArCallbackThread f22032e;

    /* renamed from: a */
    public HandlerThread f22033a;

    /* renamed from: b */
    public long f22034b;

    /* renamed from: c */
    public final Object f22035c = new Object();

    /* renamed from: com.huawei.hiar.ArCallbackThread$a */
    public class RunnableC4832a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ long f22036a;

        /* renamed from: b */
        public final /* synthetic */ int f22037b;

        /* renamed from: c */
        public final /* synthetic */ int f22038c;

        /* renamed from: d */
        public final /* synthetic */ long f22039d;

        public RunnableC4832a(long j10, int i10, int i11, long j11) {
            this.f22036a = j10;
            this.f22037b = i10;
            this.f22038c = i11;
            this.f22039d = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(ArCallbackThread.f22031d, "begin to do user callback");
            ArCallbackThread.this.doUserCallback(this.f22036a, this.f22037b, this.f22038c, this.f22039d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void doUserCallback(long j10, int i10, int i11, long j11);

    @UsedByNative("ar_callback_thread.cpp")
    public static ArCallbackThread getInstance() {
        if (f22032e == null) {
            synchronized (ArCallbackThread.class) {
                try {
                    if (f22032e == null) {
                        f22032e = new ArCallbackThread();
                    }
                } finally {
                }
            }
        }
        return f22032e;
    }

    /* renamed from: c */
    public final void m29079c() {
        HandlerThread handlerThread = new HandlerThread("ArCallbackThread");
        this.f22033a = handlerThread;
        handlerThread.start();
        Log.i(f22031d, "start a new thread for call back.");
    }

    @UsedByNative("ar_callback_thread.cpp")
    public void postData(int i10, int i11, long j10) {
        String str = f22031d;
        Log.i(str, "post to callback thread");
        synchronized (this.f22035c) {
            try {
                if (this.f22033a == null) {
                    m29079c();
                }
                if (this.f22033a.getLooper() != null) {
                    new Handler(this.f22033a.getLooper()).post(new RunnableC4832a(this.f22034b, i10, i11, j10));
                } else {
                    Log.e(str, "postData create handler failed!");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @UsedByNative("ar_callback_thread.cpp")
    public void setCallbackHandler(long j10) {
        synchronized (this.f22035c) {
            this.f22034b = j10;
        }
    }

    @UsedByNative("ar_callback_thread.cpp")
    public void stop() {
        synchronized (this.f22035c) {
            try {
                HandlerThread handlerThread = this.f22033a;
                if (handlerThread != null && handlerThread.isAlive()) {
                    this.f22033a.quitSafely();
                }
                this.f22033a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
