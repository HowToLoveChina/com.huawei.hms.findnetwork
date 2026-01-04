package cn.com.miaozhen.mobile.tracking.viewability.origin.p059e;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import cn.com.miaozhen.mobile.tracking.viewability.origin.InterfaceC1496a;
import cn.com.miaozhen.mobile.tracking.viewability.origin.InterfaceC1497b;
import ijiami_release01.NCall;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.e.b */
/* loaded from: classes.dex */
public class C1501b implements InterfaceC1497b {

    /* renamed from: a */
    private Context f6394a;

    /* renamed from: b */
    private a f6395b;

    /* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.e.b$a */
    public class a extends Handler {

        /* renamed from: a */
        private final Lock f6396a;

        /* renamed from: b */
        private C1504e f6397b;

        public a(Looper looper, C1506g c1506g, InterfaceC1496a interfaceC1496a) {
            super(looper);
            this.f6396a = new ReentrantLock();
            this.f6397b = new C1504e(C1501b.this.f6394a, interfaceC1496a, c1506g);
        }

        /* renamed from: a */
        private void m8532a(View view, Bundle bundle) {
            NCall.m64618IV(new Object[]{168, this, view, bundle});
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NCall.m64618IV(new Object[]{169, this, message});
        }
    }

    public C1501b(Context context, InterfaceC1496a interfaceC1496a, C1506g c1506g) {
        this.f6395b = null;
        this.f6394a = context;
        HandlerThread handlerThread = new HandlerThread(C1501b.class.getCanonicalName());
        handlerThread.setPriority(10);
        handlerThread.start();
        this.f6395b = new a(handlerThread.getLooper(), c1506g, interfaceC1496a);
    }

    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.InterfaceC1497b
    /* renamed from: a */
    public void mo8500a(Bundle bundle, View view) {
        NCall.m64618IV(new Object[]{170, this, bundle, view});
    }

    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.InterfaceC1497b
    /* renamed from: a */
    public void mo8501a(String str) {
        NCall.m64618IV(new Object[]{171, this, str});
    }

    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.InterfaceC1497b
    /* renamed from: a */
    public void mo8502a(String str, Bundle bundle) {
        NCall.m64618IV(new Object[]{172, this, str, bundle});
    }
}
