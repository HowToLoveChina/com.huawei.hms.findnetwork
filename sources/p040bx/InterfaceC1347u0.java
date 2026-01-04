package p040bx;

import java.util.concurrent.CancellationException;
import mw.InterfaceC11539f;
import p408jw.C10951q;
import tw.InterfaceC13086l;
import tw.InterfaceC13090p;

/* renamed from: bx.u0 */
/* loaded from: classes9.dex */
public interface InterfaceC1347u0 extends InterfaceC11539f.b {

    /* renamed from: g2 */
    public static final b f5846g2 = b.f5847a;

    /* renamed from: bx.u0$a */
    public static final class a {
        /* renamed from: a */
        public static <R> R m7835a(InterfaceC1347u0 interfaceC1347u0, R r10, InterfaceC13090p<? super R, ? super InterfaceC11539f.b, ? extends R> interfaceC13090p) {
            return (R) InterfaceC11539f.b.a.m68839a(interfaceC1347u0, r10, interfaceC13090p);
        }

        /* renamed from: b */
        public static <E extends InterfaceC11539f.b> E m7836b(InterfaceC1347u0 interfaceC1347u0, InterfaceC11539f.c<E> cVar) {
            return (E) InterfaceC11539f.b.a.m68840b(interfaceC1347u0, cVar);
        }

        /* renamed from: c */
        public static /* synthetic */ InterfaceC1315h0 m7837c(InterfaceC1347u0 interfaceC1347u0, boolean z10, boolean z11, InterfaceC13086l interfaceC13086l, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return interfaceC1347u0.mo7708u(z10, z11, interfaceC13086l);
        }

        /* renamed from: d */
        public static InterfaceC11539f m7838d(InterfaceC1347u0 interfaceC1347u0, InterfaceC11539f.c<?> cVar) {
            return InterfaceC11539f.b.a.m68841c(interfaceC1347u0, cVar);
        }

        /* renamed from: e */
        public static InterfaceC11539f m7839e(InterfaceC1347u0 interfaceC1347u0, InterfaceC11539f interfaceC11539f) {
            return InterfaceC11539f.b.a.m68842d(interfaceC1347u0, interfaceC11539f);
        }
    }

    /* renamed from: bx.u0$b */
    public static final class b implements InterfaceC11539f.c<InterfaceC1347u0> {

        /* renamed from: a */
        public static final /* synthetic */ b f5847a = new b();
    }

    /* renamed from: s */
    boolean mo7662s();

    /* renamed from: t */
    CancellationException mo7707t();

    /* renamed from: u */
    InterfaceC1315h0 mo7708u(boolean z10, boolean z11, InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l);

    /* renamed from: y */
    void mo7712y(CancellationException cancellationException);
}
