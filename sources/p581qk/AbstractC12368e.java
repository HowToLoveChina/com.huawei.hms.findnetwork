package p581qk;

import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: qk.e */
/* loaded from: classes6.dex */
public abstract class AbstractC12368e extends AbstractRunnableC12516b {
    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SINGLE;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
        C12515a.m75110o().m75165a1(this);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return true;
    }
}
