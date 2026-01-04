package p040bx;

import mw.InterfaceC11537d;
import mw.InterfaceC11539f;
import p536ow.InterfaceC12051d;

/* renamed from: bx.s */
/* loaded from: classes9.dex */
public final class C1342s {
    /* renamed from: a */
    public static final String m7828a(InterfaceC11539f interfaceC11539f) {
        return null;
    }

    /* renamed from: b */
    public static final C1325k1<?> m7829b(InterfaceC12051d interfaceC12051d) {
        while (!(interfaceC12051d instanceof C1303d0) && (interfaceC12051d = interfaceC12051d.mo7759c()) != null) {
            if (interfaceC12051d instanceof C1325k1) {
                return (C1325k1) interfaceC12051d;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static final C1325k1<?> m7830c(InterfaceC11537d<?> interfaceC11537d, InterfaceC11539f interfaceC11539f, Object obj) {
        if (!(interfaceC11537d instanceof InterfaceC12051d) || interfaceC11539f.get(C1328l1.f5821a) == null) {
            return null;
        }
        C1325k1<?> c1325k1M7829b = m7829b((InterfaceC12051d) interfaceC11537d);
        if (c1325k1M7829b != null) {
            c1325k1M7829b.m7811m0(interfaceC11539f, obj);
        }
        return c1325k1M7829b;
    }
}
