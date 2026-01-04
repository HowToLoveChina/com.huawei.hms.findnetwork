package kotlinx.coroutines.scheduling;

import mw.InterfaceC11539f;
import p040bx.AbstractC1335o0;

/* renamed from: kotlinx.coroutines.scheduling.f */
/* loaded from: classes9.dex */
public class C11115f extends AbstractC1335o0 {

    /* renamed from: c */
    public final int f52373c;

    /* renamed from: d */
    public final int f52374d;

    /* renamed from: e */
    public final long f52375e;

    /* renamed from: f */
    public final String f52376f;

    /* renamed from: g */
    public ExecutorC11110a f52377g = m66878z();

    public C11115f(int i10, int i11, long j10, String str) {
        this.f52373c = i10;
        this.f52374d = i11;
        this.f52375e = j10;
        this.f52376f = str;
    }

    /* renamed from: A */
    public final void m66877A(Runnable runnable, InterfaceC11118i interfaceC11118i, boolean z10) {
        this.f52377g.m66850v(runnable, interfaceC11118i, z10);
    }

    @Override // p040bx.AbstractC1344t
    /* renamed from: c */
    public void mo7787c(InterfaceC11539f interfaceC11539f, Runnable runnable) {
        ExecutorC11110a.m66837w(this.f52377g, runnable, null, false, 6, null);
    }

    /* renamed from: z */
    public final ExecutorC11110a m66878z() {
        return new ExecutorC11110a(this.f52373c, this.f52374d, this.f52375e, this.f52376f);
    }
}
