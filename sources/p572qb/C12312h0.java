package p572qb;

import android.os.SystemClock;
import cn.C1461a;
import java.util.concurrent.Callable;
import p015ak.C0226l0;
import p336he.C10155f;

/* renamed from: qb.h0 */
/* loaded from: classes3.dex */
public class C12312h0 {

    /* renamed from: a */
    public volatile long f57021a;

    /* renamed from: qb.h0$b */
    public static class b {

        /* renamed from: a */
        public static final C12312h0 f57022a = new C12312h0();
    }

    /* renamed from: b */
    public static C12312h0 m74027b() {
        return b.f57022a;
    }

    /* renamed from: c */
    public long m74028c() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C1461a.m8359i("ServerTimeManager", "currentRealtime: " + jElapsedRealtime);
        return this.f57021a != 0 ? this.f57021a + jElapsedRealtime : ((Long) C0226l0.m1582b(new Callable() { // from class: qb.g0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f57019a.m74029d();
            }
        }, 500L, -1L)).longValue();
    }

    /* renamed from: d */
    public final /* synthetic */ Long m74029d() throws Exception {
        try {
            long j10 = Long.parseLong(C10155f.m63283g("bc.server.time"));
            m74030e(j10);
            return Long.valueOf(j10);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* renamed from: e */
    public void m74030e(long j10) {
        C1461a.m8359i("ServerTimeManager", "setServerTime: " + j10);
        this.f57021a = j10 - SystemClock.elapsedRealtime();
        C1461a.m8359i("ServerTimeManager", "differentialTime: " + this.f57021a);
    }

    public C12312h0() {
        this.f57021a = 0L;
    }
}
