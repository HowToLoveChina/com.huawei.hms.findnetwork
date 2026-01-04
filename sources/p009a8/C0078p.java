package p009a8;

import android.content.Context;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import p031b7.C1120a;
import p031b7.C1122c;
import p281f8.C9672i;

/* renamed from: a8.p */
/* loaded from: classes2.dex */
public class C0078p {

    /* renamed from: a */
    public long f296a;

    /* renamed from: b */
    public int f297b;

    /* renamed from: c */
    public Timer f298c;

    /* renamed from: d */
    public ArrayList<TimerTask> f299d;

    /* renamed from: a8.p$b */
    public static class b {

        /* renamed from: a */
        public static C0078p f300a = new C0078p();
    }

    /* renamed from: a8.p$c */
    public class c extends TimerTask {

        /* renamed from: a */
        public Context f301a;

        /* renamed from: b */
        public boolean f302b;

        public c(Context context) {
            this.f301a = context;
        }

        @Override // java.util.TimerTask
        public boolean cancel() {
            this.f302b = true;
            return super.cancel();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C1120a.m6677i("WakeGalleryManager", "wakeGalleryDelay");
            if (this.f302b) {
                C1120a.m6678w("WakeGalleryManager", "wakeGalleryDelay canceled");
            } else if (C0078p.this.m637b(this.f301a) && CloudAlbumSettings.m14363h().m14387w()) {
                CloudAlbumManager.m14456v().m14462F(this.f301a);
            }
        }
    }

    /* renamed from: d */
    public static C0078p m636d() {
        return b.f300a;
    }

    /* renamed from: b */
    public final boolean m637b(Context context) {
        if (context == null) {
            C1120a.m6676e("WakeGalleryManager", "canSync context is null");
            return false;
        }
        if (!C9672i.m60382b(context) && !C9672i.m60385e(context)) {
            return true;
        }
        C1120a.m6678w("WakeGalleryManager", "wakeGalleryDelay can not sync");
        return false;
    }

    /* renamed from: c */
    public final void m638c() {
        Iterator<TimerTask> it = this.f299d.iterator();
        while (it.hasNext()) {
            TimerTask next = it.next();
            if (next != null) {
                next.cancel();
            }
        }
        this.f299d.clear();
    }

    /* renamed from: e */
    public final long m639e() {
        C1120a.m6677i("WakeGalleryManager", "getUnNormalDelayTime unNormalBindCount: " + this.f297b);
        int i10 = this.f297b;
        if (i10 == 0) {
            return PreConnectManager.CONNECT_SUCCESS_INTERNAL;
        }
        if (i10 == 1) {
            return 900000L;
        }
        if (i10 == 2) {
            return 1800000L;
        }
        C1120a.m6676e("WakeGalleryManager", "selectDelayTime default: " + this.f297b);
        return -1L;
    }

    /* renamed from: f */
    public void m640f(Context context) {
        if (!m637b(context)) {
            C1120a.m6678w("WakeGalleryManager", "startWakeEngine can not sync");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1120a.m6677i("WakeGalleryManager", "startWakeEngine: " + C1122c.m6721O(jCurrentTimeMillis) + "_" + C1122c.m6721O(this.f296a));
        if (jCurrentTimeMillis - this.f296a >= 1800000) {
            this.f297b = 0;
            m642h(context, 20000L);
            return;
        }
        long jM639e = m639e();
        if (jM639e == -1) {
            return;
        }
        this.f297b++;
        m642h(context, jM639e);
    }

    /* renamed from: g */
    public void m641g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1120a.m6677i("WakeGalleryManager", "updateLatestBindTime: " + C1122c.m6721O(jCurrentTimeMillis));
        m638c();
        this.f296a = jCurrentTimeMillis;
    }

    /* renamed from: h */
    public final void m642h(Context context, long j10) {
        C1120a.m6677i("WakeGalleryManager", "wakeGalleryDelay: " + j10);
        c cVar = new c(context);
        this.f299d.add(cVar);
        this.f298c.schedule(cVar, j10);
    }

    public C0078p() {
        this.f297b = 0;
        this.f298c = new Timer();
        this.f299d = new ArrayList<>();
    }
}
