package kotlinx.coroutines.internal;

import p040bx.C1354y;

/* renamed from: kotlinx.coroutines.internal.q */
/* loaded from: classes9.dex */
public abstract class AbstractC11100q {
    /* renamed from: a */
    public abstract AbstractC11086c<?> mo66743a();

    /* renamed from: b */
    public final boolean m66799b(AbstractC11100q abstractC11100q) {
        AbstractC11086c<?> abstractC11086cMo66743a;
        AbstractC11086c<?> abstractC11086cMo66743a2 = mo66743a();
        return (abstractC11086cMo66743a2 == null || (abstractC11086cMo66743a = abstractC11100q.mo66743a()) == null || abstractC11086cMo66743a2.m66747f() >= abstractC11086cMo66743a.m66747f()) ? false : true;
    }

    /* renamed from: c */
    public abstract Object mo66744c(Object obj);

    public String toString() {
        return C1354y.m7844a(this) + '@' + C1354y.m7845b(this);
    }
}
