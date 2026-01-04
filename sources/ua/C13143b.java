package ua;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import p514o9.C11839m;
import qa.C12296a;
import sa.C12766a;

/* renamed from: ua.b */
/* loaded from: classes3.dex */
public class C13143b {

    /* renamed from: b */
    public static C13143b f59638b;

    /* renamed from: a */
    public a f59639a;

    /* renamed from: ua.b$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            super.handleMessage(message);
            if (message.what != 39) {
                return;
            }
            int iM73902d = C12296a.m73898e().m73902d();
            if (System.currentTimeMillis() - C12766a.m76614c() > 120000) {
                C11839m.m70686d("SyncTaskManager", "no flow error, reset pool size");
                C13143b.this.m79050f(iM73902d);
            } else {
                C13143b.this.m79049e(iM73902d);
                C11839m.m70686d("SyncTaskManager", "flow error send msg.");
                C13143b.this.m79048c();
            }
        }
    }

    public C13143b() {
        HandlerThread handlerThread = new HandlerThread("SyncTaskHandler");
        handlerThread.start();
        this.f59639a = new a(handlerThread.getLooper());
    }

    /* renamed from: d */
    public static synchronized C13143b m79047d() {
        try {
            if (f59638b == null) {
                f59638b = new C13143b();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f59638b;
    }

    /* renamed from: c */
    public void m79048c() {
        a aVar = this.f59639a;
        if (aVar != null) {
            aVar.removeMessages(39);
            Message messageObtainMessage = this.f59639a.obtainMessage();
            messageObtainMessage.what = 39;
            this.f59639a.sendMessageDelayed(messageObtainMessage, 125000L);
        }
    }

    /* renamed from: e */
    public final void m79049e(int i10) {
        if (i10 > 5) {
            C11839m.m70688i("SyncTaskManager", "flow error reset pool size to 5");
            C12296a.m73898e().m73906i(5);
        } else if (i10 > 3) {
            C11839m.m70688i("SyncTaskManager", "flow error reset pool size to 3");
            C12296a.m73898e().m73906i(3);
        }
    }

    /* renamed from: f */
    public final void m79050f(int i10) {
        if (i10 >= 5 && i10 < 10) {
            C11839m.m70688i("SyncTaskManager", "no flow error reset pool size to 10");
            C12296a.m73898e().m73906i(10);
        } else if (i10 < 5) {
            C11839m.m70688i("SyncTaskManager", "no flow error reset pool size to 5");
            C12296a.m73898e().m73906i(5);
            C11839m.m70686d("SyncTaskManager", "no flow error send msg.");
            m79048c();
        }
    }
}
