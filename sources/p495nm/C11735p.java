package p495nm;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: nm.p */
/* loaded from: classes6.dex */
public class C11735p {

    /* renamed from: a */
    public int f54281a;

    /* renamed from: b */
    public AtomicInteger f54282b = new AtomicInteger(0);

    /* renamed from: c */
    public AtomicInteger f54283c = new AtomicInteger(0);

    /* renamed from: d */
    public AtomicLong f54284d = new AtomicLong(0);

    /* renamed from: e */
    public AtomicLong f54285e = new AtomicLong(0);

    /* renamed from: f */
    public AtomicLong f54286f = new AtomicLong(0);

    /* renamed from: a */
    public void m70028a(long j10) {
        this.f54286f.addAndGet(j10);
    }

    /* renamed from: b */
    public void m70029b(long j10) {
        this.f54285e.addAndGet(j10);
    }

    /* renamed from: c */
    public void m70030c(long j10) {
        this.f54284d.addAndGet(j10);
    }

    /* renamed from: d */
    public int m70031d() {
        return this.f54282b.get();
    }

    /* renamed from: e */
    public void m70032e() {
        this.f54283c.incrementAndGet();
    }

    /* renamed from: f */
    public void m70033f() {
        this.f54282b.incrementAndGet();
    }

    /* renamed from: g */
    public void m70034g(int i10) {
        this.f54281a = i10;
    }

    public String toString() {
        return "SparseReport{compressionRateConfigured:" + this.f54281a + ",totalCheckNum:" + this.f54282b + ",satisfyRateNum:" + this.f54283c + ",totalCheckSize:" + this.f54284d + ",satisfyRateTotalSize:" + this.f54285e + ",compressedTotalSize:" + this.f54286f + "}";
    }
}
