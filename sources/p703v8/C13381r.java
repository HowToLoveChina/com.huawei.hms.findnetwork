package p703v8;

import p454lj.C11296s;
import p514o9.C11839m;

/* renamed from: v8.r */
/* loaded from: classes2.dex */
public class C13381r {

    /* renamed from: b */
    public static final C13381r f60323b = new C13381r();

    /* renamed from: a */
    public volatile long f60324a;

    /* renamed from: a */
    public static C13381r m80356a() {
        return f60323b;
    }

    /* renamed from: b */
    public final boolean m80357b() {
        if (System.currentTimeMillis() - this.f60324a <= 1800000 && !C11296s.m67790N()) {
            C11839m.m70688i("StorageRequestBarrier", "isBarrageInternal: true");
            return true;
        }
        C11839m.m70688i("StorageRequestBarrier", "isBarrageInternal: false");
        C11296s.m67824k0(false);
        return false;
    }

    /* renamed from: c */
    public void m80358c() {
        synchronized (f60323b) {
            try {
                if (!m80357b()) {
                    C13368e.m80184F().m80253r0();
                    C13368e.m80184F().m80250o0();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m80359d() {
        this.f60324a = 0L;
    }

    /* renamed from: e */
    public void m80360e() {
        synchronized (f60323b) {
            this.f60324a = System.currentTimeMillis();
        }
    }
}
