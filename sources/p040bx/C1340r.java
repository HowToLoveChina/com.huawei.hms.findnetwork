package p040bx;

import mw.InterfaceC11537d;
import p408jw.C10945k;
import p408jw.C10946l;
import p408jw.C10951q;
import tw.InterfaceC13086l;

/* renamed from: bx.r */
/* loaded from: classes9.dex */
public final class C1340r {
    /* renamed from: a */
    public static final <T> Object m7824a(Object obj, InterfaceC11537d<? super T> interfaceC11537d) {
        if (!(obj instanceof C1332n)) {
            return C10945k.m66070b(obj);
        }
        C10945k.a aVar = C10945k.f51855a;
        return C10945k.m66070b(C10946l.m66073a(((C1332n) obj).f5830a));
    }

    /* renamed from: b */
    public static final <T> Object m7825b(Object obj, InterfaceC1311g<?> interfaceC1311g) {
        Throwable thM66071c = C10945k.m66071c(obj);
        return thM66071c == null ? obj : new C1332n(thM66071c, false, 2, null);
    }

    /* renamed from: c */
    public static final <T> Object m7826c(Object obj, InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l) {
        Throwable thM66071c = C10945k.m66071c(obj);
        return thM66071c == null ? interfaceC13086l != null ? new C1334o(obj, interfaceC13086l) : obj : new C1332n(thM66071c, false, 2, null);
    }

    /* renamed from: d */
    public static /* synthetic */ Object m7827d(Object obj, InterfaceC13086l interfaceC13086l, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            interfaceC13086l = null;
        }
        return m7826c(obj, interfaceC13086l);
    }
}
