package p581qk;

import p616rk.AbstractRunnableC12516b;

/* renamed from: qk.a */
/* loaded from: classes6.dex */
public abstract class AbstractC12364a extends AbstractRunnableC12516b {

    /* renamed from: a */
    public long f57164a;

    /* renamed from: b */
    public long f57165b;

    public AbstractC12364a(long j10, long j11) {
        this.f57164a = j10;
        this.f57165b = j11;
    }

    public long getDelay() {
        return this.f57164a;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SCHEDULE;
    }

    public long getPeriod() {
        return this.f57165b;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
    }

    public void setPeriod(long j10) {
        this.f57165b = j10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
