package p581qk;

import p616rk.AbstractRunnableC12516b;

/* renamed from: qk.f */
/* loaded from: classes6.dex */
public abstract class AbstractC12369f extends AbstractRunnableC12516b {
    private long delay;
    private long period;

    public AbstractC12369f(long j10, long j11) {
        this.delay = j10;
        this.period = j11;
    }

    public long getDelay() {
        return this.delay;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SCHEDULE;
    }

    public long getPeriod() {
        return this.period;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
    }

    public void setPeriod(long j10) {
        this.period = j10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
