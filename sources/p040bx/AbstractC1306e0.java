package p040bx;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.internal.C11087d;
import kotlinx.coroutines.internal.C11108y;
import kotlinx.coroutines.scheduling.AbstractRunnableC11117h;
import kotlinx.coroutines.scheduling.InterfaceC11118i;
import mw.InterfaceC11537d;
import mw.InterfaceC11539f;
import p408jw.C10936b;
import p408jw.C10945k;
import p408jw.C10946l;
import p408jw.C10951q;
import p692uw.C13267j;

/* renamed from: bx.e0 */
/* loaded from: classes9.dex */
public abstract class AbstractC1306e0<T> extends AbstractRunnableC11117h {

    /* renamed from: c */
    public int f5794c;

    public AbstractC1306e0(int i10) {
        this.f5794c = i10;
    }

    /* renamed from: a */
    public void mo7741a(Object obj, Throwable th2) {
    }

    /* renamed from: e */
    public abstract InterfaceC11537d<T> mo7742e();

    /* renamed from: f */
    public Throwable mo7743f(Object obj) {
        C1332n c1332n = obj instanceof C1332n ? (C1332n) obj : null;
        if (c1332n == null) {
            return null;
        }
        return c1332n.f5830a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public <T> T mo7744g(Object obj) {
        return obj;
    }

    /* renamed from: h */
    public final void m7745h(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th2 == null && th3 == null) {
            return;
        }
        if (th2 != null && th3 != null) {
            C10936b.m66063a(th2, th3);
        }
        if (th2 == null) {
            th2 = th3;
        }
        C13267j.m79674b(th2);
        C1350w.m7841a(mo7742e().getContext(), new C1352x("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
    }

    /* renamed from: i */
    public abstract Object mo7746i();

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objM66070b;
        Object objM66070b2;
        InterfaceC11118i interfaceC11118i = this.f52379b;
        try {
            C11087d c11087d = (C11087d) mo7742e();
            InterfaceC11537d<T> interfaceC11537d = c11087d.f52301e;
            Object obj = c11087d.f52303g;
            InterfaceC11539f context = interfaceC11537d.getContext();
            Object objM66819c = C11108y.m66819c(context, obj);
            C1325k1<?> c1325k1M7830c = objM66819c != C11108y.f52334a ? C1342s.m7830c(interfaceC11537d, context, objM66819c) : null;
            try {
                InterfaceC11539f context2 = interfaceC11537d.getContext();
                Object objMo7746i = mo7746i();
                Throwable thMo7743f = mo7743f(objMo7746i);
                InterfaceC1347u0 interfaceC1347u0 = (thMo7743f == null && C1309f0.m7751b(this.f5794c)) ? (InterfaceC1347u0) context2.get(InterfaceC1347u0.f5846g2) : null;
                if (interfaceC1347u0 != null && !interfaceC1347u0.mo7662s()) {
                    CancellationException cancellationExceptionMo7707t = interfaceC1347u0.mo7707t();
                    mo7741a(objMo7746i, cancellationExceptionMo7707t);
                    C10945k.a aVar = C10945k.f51855a;
                    interfaceC11537d.mo7657d(C10945k.m66070b(C10946l.m66073a(cancellationExceptionMo7707t)));
                } else if (thMo7743f != null) {
                    C10945k.a aVar2 = C10945k.f51855a;
                    interfaceC11537d.mo7657d(C10945k.m66070b(C10946l.m66073a(thMo7743f)));
                } else {
                    interfaceC11537d.mo7657d(C10945k.m66070b(mo7744g(objMo7746i)));
                }
                C10951q c10951q = C10951q.f51861a;
                if (c1325k1M7830c == null || c1325k1M7830c.m7810l0()) {
                    C11108y.m66817a(context, objM66819c);
                }
                try {
                    interfaceC11118i.mo66879a();
                    objM66070b2 = C10945k.m66070b(C10951q.f51861a);
                } catch (Throwable th2) {
                    C10945k.a aVar3 = C10945k.f51855a;
                    objM66070b2 = C10945k.m66070b(C10946l.m66073a(th2));
                }
                m7745h(null, C10945k.m66071c(objM66070b2));
            } catch (Throwable th3) {
                if (c1325k1M7830c == null || c1325k1M7830c.m7810l0()) {
                    C11108y.m66817a(context, objM66819c);
                }
                throw th3;
            }
        } catch (Throwable th4) {
            try {
                C10945k.a aVar4 = C10945k.f51855a;
                interfaceC11118i.mo66879a();
                objM66070b = C10945k.m66070b(C10951q.f51861a);
            } catch (Throwable th5) {
                C10945k.a aVar5 = C10945k.f51855a;
                objM66070b = C10945k.m66070b(C10946l.m66073a(th5));
            }
            m7745h(th4, C10945k.m66071c(objM66070b));
        }
    }
}
