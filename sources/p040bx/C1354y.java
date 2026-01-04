package p040bx;

import kotlinx.coroutines.internal.C11087d;
import mw.InterfaceC11537d;
import p408jw.C10945k;
import p408jw.C10946l;

/* renamed from: bx.y */
/* loaded from: classes9.dex */
public final class C1354y {
    /* renamed from: a */
    public static final String m7844a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    /* renamed from: b */
    public static final String m7845b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /* renamed from: c */
    public static final String m7846c(InterfaceC11537d<?> interfaceC11537d) {
        Object objM66070b;
        if (interfaceC11537d instanceof C11087d) {
            return interfaceC11537d.toString();
        }
        try {
            C10945k.a aVar = C10945k.f51855a;
            objM66070b = C10945k.m66070b(interfaceC11537d + '@' + m7845b(interfaceC11537d));
        } catch (Throwable th2) {
            C10945k.a aVar2 = C10945k.f51855a;
            objM66070b = C10945k.m66070b(C10946l.m66073a(th2));
        }
        if (C10945k.m66071c(objM66070b) != null) {
            objM66070b = ((Object) interfaceC11537d.getClass().getName()) + '@' + m7845b(interfaceC11537d);
        }
        return (String) objM66070b;
    }
}
