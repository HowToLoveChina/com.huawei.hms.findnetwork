package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hms.stats.a */
/* loaded from: classes8.dex */
public class C6310a {

    /* renamed from: f */
    private static final C6310a f29739f = new C6310a();

    /* renamed from: a */
    private final Object f29740a = new Object();

    /* renamed from: b */
    private boolean f29741b = false;

    /* renamed from: c */
    private final List<Runnable> f29742c = new ArrayList();

    /* renamed from: d */
    private final Handler f29743d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final Runnable f29744e = new a();

    /* renamed from: com.huawei.hms.stats.a$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m36988i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (HiAnalyticsUtils.getInstance().getInitFlag()) {
                C6310a.this.m36624b();
            } else {
                C6310a.this.m36622a();
            }
        }
    }

    private C6310a() {
    }

    /* renamed from: c */
    public static C6310a m36621c() {
        return f29739f;
    }

    /* renamed from: a */
    public void m36623a(Runnable runnable) {
        synchronized (this.f29740a) {
            try {
                if (runnable == null) {
                    return;
                }
                if (this.f29741b) {
                    return;
                }
                if (this.f29742c.size() >= 60) {
                    return;
                }
                this.f29742c.add(runnable);
                this.f29743d.removeCallbacks(this.f29744e);
                this.f29743d.postDelayed(this.f29744e, 10000L);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m36624b() {
        synchronized (this.f29740a) {
            HMSLog.m36988i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f29742c.size());
            this.f29741b = true;
            try {
                Iterator<Runnable> it = this.f29742c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                    it.remove();
                }
            } catch (Throwable th2) {
                HMSLog.m36986e("AnalyticsCacheManager", "<execCacheBi> failed. " + th2.getMessage());
                m36622a();
            }
            this.f29741b = false;
        }
    }

    /* renamed from: a */
    public void m36622a() {
        synchronized (this.f29740a) {
            HMSLog.m36988i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f29742c.clear();
        }
    }
}
