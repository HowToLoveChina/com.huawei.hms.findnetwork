package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlinx.coroutines.internal.C11105v;
import kotlinx.coroutines.internal.C11107x;
import mw.C11540g;
import mw.InterfaceC11539f;
import p040bx.AbstractC1335o0;
import p040bx.AbstractC1344t;
import p790xw.C13885n;

/* renamed from: kotlinx.coroutines.scheduling.b */
/* loaded from: classes9.dex */
public final class ExecutorC11111b extends AbstractC1335o0 implements Executor {

    /* renamed from: c */
    public static final ExecutorC11111b f52369c = new ExecutorC11111b();

    /* renamed from: d */
    public static final AbstractC1344t f52370d = C11122m.f52389b.m7833i(C11107x.m66815d("kotlinx.coroutines.io.parallelism", C13885n.m83236a(64, C11105v.m66803a()), 0, 0, 12, null));

    @Override // p040bx.AbstractC1344t
    /* renamed from: c */
    public void mo7787c(InterfaceC11539f interfaceC11539f, Runnable runnable) {
        f52370d.mo7787c(interfaceC11539f, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        mo7787c(C11540g.f53497a, runnable);
    }

    @Override // p040bx.AbstractC1344t
    public String toString() {
        return "Dispatchers.IO";
    }
}
