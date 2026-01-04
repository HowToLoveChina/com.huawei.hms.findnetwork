package p009a8;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import p031b7.C1120a;
import p031b7.C1122c;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* renamed from: a8.a */
/* loaded from: classes2.dex */
public class C0063a {

    /* renamed from: a */
    public Context f202a;

    /* renamed from: b */
    public CallbackHandler f203b;

    /* renamed from: c */
    public long f204c = -1;

    /* renamed from: d */
    public long f205d = -1;

    /* renamed from: e */
    public boolean f206e;

    /* renamed from: f */
    public Handler f207f;

    /* renamed from: g */
    public HandlerThread f208g;

    /* renamed from: a8.a$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f209a;

        public a(String str) {
            this.f209a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            CommonOpsReport commonOpsReport = new CommonOpsReport(C0063a.this.f202a);
            String str = this.f209a + "_" + C1122c.m6721O(C0063a.this.f204c) + "_" + C1122c.m6721O(C0063a.this.f205d);
            String strM15201z = SyncSessionManager.m15153t().m15201z();
            C1120a.m6677i("ActiveDetector", "reportGalleryFrozen sessionId: " + strM15201z + ", " + str);
            commonOpsReport.m15209C(strM15201z, "gallery_frozen", 0, str);
        }
    }

    /* renamed from: a8.a$b */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                C1120a.m6677i("ActiveDetector", "startDetectTask run: " + C1122c.m6721O(C0063a.this.f204c) + ", " + C1122c.m6721O(C0063a.this.f205d));
                if (!C0063a.this.f206e) {
                    C0063a.this.m414g("first");
                }
                C0063a.this.m418k();
                Message messageObtain = Message.obtain();
                messageObtain.what = 0;
                sendMessageDelayed(messageObtain, 120000L);
            }
        }
    }

    public C0063a(Context context, CallbackHandler callbackHandler) {
        this.f202a = context;
        this.f203b = callbackHandler;
    }

    /* renamed from: g */
    public final void m414g(String str) {
        if (this.f204c - this.f205d > 60000) {
            m416i(str);
        }
    }

    /* renamed from: h */
    public final void m415h() {
        HandlerThread handlerThread = new HandlerThread("ActiveDetector");
        this.f208g = handlerThread;
        handlerThread.start();
        this.f207f = new b(this.f208g.getLooper());
    }

    /* renamed from: i */
    public final void m416i(String str) {
        C12515a.m75110o().m75168b1(new a(str));
        this.f206e = true;
    }

    /* renamed from: j */
    public final void m417j() {
        this.f204c = -1L;
        this.f205d = -1L;
    }

    /* renamed from: k */
    public final void m418k() {
        this.f204c = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", 2);
        bundle.putString("sessionId", SyncSessionManager.m15153t().m15201z());
        this.f203b.sendMessage(9019, bundle);
    }

    /* renamed from: l */
    public synchronized void m419l() {
        try {
            C1120a.m6677i("ActiveDetector", "startDetectTask");
            if (this.f207f == null) {
                m415h();
            }
            this.f207f.removeMessages(0);
            m417j();
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            this.f207f.sendMessage(messageObtain);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: m */
    public synchronized void m420m() {
        try {
            C1120a.m6677i("ActiveDetector", "stopDetect");
            if (this.f206e) {
                m416i("end");
            }
            Handler handler = this.f207f;
            if (handler != null) {
                handler.removeMessages(0);
            }
            this.f207f = null;
            HandlerThread handlerThread = this.f208g;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.f208g = null;
            this.f204c = -1L;
            this.f205d = -1L;
            this.f206e = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: n */
    public void m421n(long j10) {
        this.f205d = j10;
    }
}
