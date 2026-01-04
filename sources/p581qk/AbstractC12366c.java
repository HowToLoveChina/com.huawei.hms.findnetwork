package p581qk;

import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: qk.c */
/* loaded from: classes6.dex */
public abstract class AbstractC12366c extends AbstractRunnableC12516b {
    private long delay;

    public AbstractC12366c() {
    }

    public long getDelay() {
        return this.delay;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SCHEDULE;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
        C12515a.m75110o().m75165a1(this);
    }

    public void setDelay(long j10) {
        this.delay = j10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return true;
    }

    public AbstractC12366c(long j10) {
        this.delay = j10;
    }
}
