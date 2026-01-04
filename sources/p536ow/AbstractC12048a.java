package p536ow;

import java.io.Serializable;
import mw.InterfaceC11537d;
import p408jw.C10945k;
import p408jw.C10946l;
import p501nw.C11760d;
import p692uw.C13267j;

/* renamed from: ow.a */
/* loaded from: classes9.dex */
public abstract class AbstractC12048a implements InterfaceC11537d<Object>, InterfaceC12051d, Serializable {

    /* renamed from: a */
    public final InterfaceC11537d<Object> f55801a;

    /* renamed from: b */
    public StackTraceElement m72177b() {
        return C12053f.m72189d(this);
    }

    @Override // p536ow.InterfaceC12051d
    /* renamed from: c */
    public InterfaceC12051d mo7759c() {
        InterfaceC11537d<Object> interfaceC11537d = this.f55801a;
        if (interfaceC11537d instanceof InterfaceC12051d) {
            return (InterfaceC12051d) interfaceC11537d;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, mw.d, mw.d<java.lang.Object>] */
    @Override // mw.InterfaceC11537d
    /* renamed from: d */
    public final void mo7657d(Object obj) {
        Object objM72178e;
        while (true) {
            C12054g.m72190a(this);
            AbstractC12048a abstractC12048a = this;
            ?? r02 = abstractC12048a.f55801a;
            C13267j.m79674b(r02);
            try {
                objM72178e = abstractC12048a.m72178e(obj);
            } catch (Throwable th2) {
                C10945k.a aVar = C10945k.f51855a;
                obj = C10945k.m66070b(C10946l.m66073a(th2));
            }
            if (objM72178e == C11760d.m70084b()) {
                return;
            }
            obj = C10945k.m66070b(objM72178e);
            abstractC12048a.mo72179f();
            if (!(r02 instanceof AbstractC12048a)) {
                r02.mo7657d(obj);
                return;
            }
            this = r02;
        }
    }

    /* renamed from: e */
    public abstract Object m72178e(Object obj);

    /* renamed from: f */
    public void mo72179f() {
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object objM72177b = m72177b();
        if (objM72177b == null) {
            objM72177b = getClass().getName();
        }
        sb2.append(objM72177b);
        return sb2.toString();
    }
}
