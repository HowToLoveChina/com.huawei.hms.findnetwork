package com.huawei.location.lite.common.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public abstract class SafeService extends Service {

    /* renamed from: a */
    public volatile Looper f31343a;

    /* renamed from: b */
    public volatile HandlerC6774a f31344b;

    /* renamed from: c */
    public boolean f31345c;

    /* renamed from: com.huawei.location.lite.common.android.service.SafeService$a */
    public final class HandlerC6774a extends Handler {
        public HandlerC6774a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 101) {
                SafeService.this.m38393d();
                return;
            }
            SafeService.this.m38392c((Intent) message.obj);
            removeMessages(101);
            sendEmptyMessageDelayed(101, SafeService.this.m38395f() > 0 ? SafeService.this.m38395f() : 0L);
        }
    }

    /* renamed from: b */
    public boolean m38391b() {
        return true;
    }

    /* renamed from: c */
    public abstract void m38392c(Intent intent);

    /* renamed from: d */
    public final void m38393d() {
        if (this.f31343a != null) {
            this.f31343a.quitSafely();
            this.f31343a = null;
        }
    }

    /* renamed from: e */
    public String m38394e() {
        return "Loc-Safe-Service";
    }

    /* renamed from: f */
    public int m38395f() {
        return 0;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread(!TextUtils.isEmpty(m38394e()) ? m38394e() : "Loc-Safe-Service");
        handlerThread.start();
        this.f31343a = handlerThread.getLooper();
        this.f31344b = new HandlerC6774a(this.f31343a);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f31344b != null) {
            this.f31344b.removeMessages(101);
            this.f31344b = null;
        }
        m38393d();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        if (!m38391b() || this.f31344b == null) {
            super.onStart(intent, i10);
            return;
        }
        Message messageObtainMessage = this.f31344b.obtainMessage();
        messageObtainMessage.arg1 = i10;
        messageObtainMessage.obj = intent;
        this.f31344b.sendMessage(messageObtainMessage);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (m38391b()) {
            onStart(intent, i11);
        } else {
            m38392c(intent);
        }
        return this.f31345c ? 3 : 2;
    }
}
