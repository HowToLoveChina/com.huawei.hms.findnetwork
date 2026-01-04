package p040bx;

/* renamed from: bx.i1 */
/* loaded from: classes9.dex */
public final class C1319i1 {

    /* renamed from: a */
    public static final C1319i1 f5807a = new C1319i1();

    /* renamed from: b */
    public static final ThreadLocal<AbstractC1321j0> f5808b = new ThreadLocal<>();

    /* renamed from: a */
    public final AbstractC1321j0 m7775a() {
        ThreadLocal<AbstractC1321j0> threadLocal = f5808b;
        AbstractC1321j0 abstractC1321j0 = threadLocal.get();
        if (abstractC1321j0 != null) {
            return abstractC1321j0;
        }
        AbstractC1321j0 abstractC1321j0M7818a = C1330m0.m7818a();
        threadLocal.set(abstractC1321j0M7818a);
        return abstractC1321j0M7818a;
    }

    /* renamed from: b */
    public final void m7776b() {
        f5808b.set(null);
    }

    /* renamed from: c */
    public final void m7777c(AbstractC1321j0 abstractC1321j0) {
        f5808b.set(abstractC1321j0);
    }
}
