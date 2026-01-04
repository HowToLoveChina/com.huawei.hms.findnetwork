package cn.com.miaozhen.mobile.tracking.util;

import com.baidu.location.BDLocation;
import ijiami_release01.NCall;
import java.util.concurrent.ExecutorService;

/* renamed from: cn.com.miaozhen.mobile.tracking.util.k */
/* loaded from: classes.dex */
public class C1494k {

    /* renamed from: a */
    private static C1494k f6379a;

    /* renamed from: b */
    private ExecutorService f6380b = m8495a(4);

    /* renamed from: cn.com.miaozhen.mobile.tracking.util.k$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private final Runnable f6381a;

        public a(Runnable runnable) {
            this.f6381a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.m64618IV(new Object[]{153, this});
        }
    }

    private C1494k() {
    }

    /* renamed from: a */
    public static synchronized C1494k m8494a() {
        return (C1494k) NCall.m64616IL(new Object[]{163});
    }

    /* renamed from: b */
    private void m8496b() {
        NCall.m64618IV(new Object[]{165, this});
    }

    /* renamed from: c */
    public void m8498c() {
        NCall.m64618IV(new Object[]{Integer.valueOf(BDLocation.TypeServerError), this});
    }

    /* renamed from: a */
    private ExecutorService m8495a(int i10) {
        return (ExecutorService) NCall.m64616IL(new Object[]{164, this, Integer.valueOf(i10)});
    }

    /* renamed from: a */
    public synchronized void m8497a(Runnable runnable) {
        NCall.m64618IV(new Object[]{166, this, runnable});
    }
}
