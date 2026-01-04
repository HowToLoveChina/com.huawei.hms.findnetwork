package com.huawei.location.lite.common.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public abstract class SafeBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public volatile Looper f31335a;

    /* renamed from: b */
    public volatile HandlerC6771a f31336b;

    /* renamed from: com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver$a */
    public final class HandlerC6771a extends Handler {
        public HandlerC6771a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 101) {
                if (SafeBroadcastReceiver.this.f31335a != null) {
                    SafeBroadcastReceiver.this.f31335a.quitSafely();
                    SafeBroadcastReceiver.this.f31335a = null;
                    return;
                }
                return;
            }
            if (i10 != 102) {
                return;
            }
            SafeBroadcastReceiver.this.mo38377d((Intent) message.obj);
            removeMessages(101);
            sendEmptyMessageDelayed(101, SafeBroadcastReceiver.this.mo38379f() > 0 ? SafeBroadcastReceiver.this.mo38379f() : 0L);
        }
    }

    /* renamed from: c */
    public boolean m38384c() {
        return true;
    }

    /* renamed from: d */
    public abstract void mo38377d(Intent intent);

    /* renamed from: e */
    public String mo38378e() {
        return "Loc-Safe-Receiver";
    }

    /* renamed from: f */
    public int mo38379f() {
        return 0;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (!m38384c()) {
            mo38377d(intent);
            return;
        }
        if (this.f31335a == null || this.f31336b == null) {
            HandlerThread handlerThread = new HandlerThread(!TextUtils.isEmpty(mo38378e()) ? mo38378e() : "Loc-Safe-Receiver");
            handlerThread.start();
            this.f31335a = handlerThread.getLooper();
            this.f31336b = new HandlerC6771a(this.f31335a);
        }
        Message messageObtainMessage = this.f31336b.obtainMessage();
        messageObtainMessage.what = 102;
        messageObtainMessage.obj = intent;
        this.f31336b.sendMessage(messageObtainMessage);
    }
}
