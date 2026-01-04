package p581qk;

import android.os.Message;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: qk.b */
/* loaded from: classes6.dex */
public abstract class AbstractC12365b extends AbstractRunnableC12516b {
    public abstract void abort();

    public abstract void callback(Message message);

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.CACHE;
    }

    public abstract void pause();

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
        C12515a.m75110o().m75165a1(this);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return true;
    }
}
