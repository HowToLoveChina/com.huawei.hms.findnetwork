package p681uj;

import com.huawei.feedback.log.BaseLogger;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: uj.d */
/* loaded from: classes5.dex */
public class C13187d {

    /* renamed from: a */
    public int f59714a = 0;

    /* renamed from: b */
    public long[] f59715b = {10000, 30000, 60000};

    /* renamed from: c */
    public Timer f59716c;

    /* renamed from: d */
    public InterfaceC13186c f59717d;

    /* renamed from: e */
    public a f59718e;

    /* renamed from: uj.d$a */
    public static class a extends TimerTask {

        /* renamed from: a */
        public WeakReference<C13187d> f59719a;

        public a(C13187d c13187d) {
            this.f59719a = new WeakReference<>(c13187d);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13187d c13187d;
            WeakReference<C13187d> weakReference = this.f59719a;
            if (weakReference == null || (c13187d = weakReference.get()) == null) {
                return;
            }
            BaseLogger.m28733i("BackoffTimer", "host execute");
            c13187d.m79238b();
            c13187d.m79240d();
        }
    }

    public C13187d(InterfaceC13186c interfaceC13186c) {
        this.f59717d = interfaceC13186c;
    }

    /* renamed from: b */
    public void m79238b() {
        InterfaceC13186c interfaceC13186c = this.f59717d;
        if (interfaceC13186c != null) {
            interfaceC13186c.execute();
        }
    }

    /* renamed from: c */
    public void m79239c() {
        int i10;
        InterfaceC13186c interfaceC13186c = this.f59717d;
        if (interfaceC13186c == null || !interfaceC13186c.mo65472a() || (i10 = this.f59714a) >= 3) {
            return;
        }
        long[] jArr = this.f59715b;
        this.f59714a = i10 + 1;
        long j10 = jArr[i10];
        StringBuilder sb2 = new StringBuilder();
        sb2.append("schedule time=");
        sb2.append(j10);
        sb2.append(", times=");
        sb2.append(this.f59714a - 1);
        BaseLogger.m28733i("BackoffTimer", sb2.toString());
        m79240d();
        this.f59716c = new Timer();
        a aVar = new a(this);
        this.f59718e = aVar;
        this.f59716c.schedule(aVar, j10);
    }

    /* renamed from: d */
    public final void m79240d() {
        Timer timer = this.f59716c;
        if (timer != null) {
            timer.cancel();
        }
    }
}
