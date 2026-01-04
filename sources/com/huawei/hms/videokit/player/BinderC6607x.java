package com.huawei.hms.videokit.player;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.videokit.player.internal.InterfaceC6569d;

/* renamed from: com.huawei.hms.videokit.player.x */
/* loaded from: classes8.dex */
public class BinderC6607x extends InterfaceC6569d.a {

    /* renamed from: a */
    private String f30703a = "OMReporter_Thread:";

    /* renamed from: b */
    private C6541a0 f30704b = null;

    /* renamed from: c */
    private b f30705c = null;

    /* renamed from: d */
    private HandlerThread f30706d;

    /* renamed from: com.huawei.hms.videokit.player.x$b */
    public class b extends Handler {
        private b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 0) {
                return;
            }
            Object obj = message.obj;
            BinderC6607x.this.f30704b.m37195b(obj instanceof OperationData ? (OperationData) obj : null);
        }

        public /* synthetic */ b(BinderC6607x binderC6607x, Looper looper, a aVar) {
            this(looper);
        }
    }

    public BinderC6607x() {
        HandlerThread handlerThread = new HandlerThread(this.f30703a);
        this.f30706d = handlerThread;
        handlerThread.start();
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6569d
    /* renamed from: b */
    public void mo37409b(IObjectWrapper iObjectWrapper) throws RemoteException {
        C6550c1.m37264c("OMReporter", "init");
        try {
            this.f30704b = new C6541a0((Context) ObjectWrapper.unwrap(iObjectWrapper));
            Looper looper = this.f30706d.getLooper();
            if (looper != null) {
                this.f30705c = new b(looper);
            } else {
                Log.e("OMReporter", "init: failed to getLooper.");
            }
        } catch (Exception e10) {
            C6550c1.m37258a("OMReporter", "context unwrap error:", e10);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6569d
    /* renamed from: a */
    public void mo37408a(OperationData operationData) throws RemoteException {
        b bVar = this.f30705c;
        if (bVar != null) {
            Message messageObtainMessage = bVar.obtainMessage();
            messageObtainMessage.what = 0;
            messageObtainMessage.obj = operationData;
            this.f30705c.sendMessage(messageObtainMessage);
        }
    }
}
