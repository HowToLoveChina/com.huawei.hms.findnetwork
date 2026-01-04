package p802y8;

import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: y8.c */
/* loaded from: classes2.dex */
public abstract class AbstractC13919c extends AbstractRunnableC12516b {
    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.WISH_LIST_FIX;
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
