package kotlinx.coroutines.internal;

import kw.C11175g;

/* renamed from: kotlinx.coroutines.internal.a */
/* loaded from: classes9.dex */
public class C11082a<T> {

    /* renamed from: a */
    public Object[] f52289a = new Object[16];

    /* renamed from: b */
    public int f52290b;

    /* renamed from: c */
    public int f52291c;

    /* renamed from: a */
    public final void m66737a(T t10) {
        Object[] objArr = this.f52289a;
        int i10 = this.f52291c;
        objArr[i10] = t10;
        int length = (objArr.length - 1) & (i10 + 1);
        this.f52291c = length;
        if (length == this.f52290b) {
            m66738b();
        }
    }

    /* renamed from: b */
    public final void m66738b() {
        Object[] objArr = this.f52289a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        C11175g.m67146f(objArr, objArr2, 0, this.f52290b, 0, 10, null);
        Object[] objArr3 = this.f52289a;
        int length2 = objArr3.length;
        int i10 = this.f52290b;
        C11175g.m67146f(objArr3, objArr2, length2 - i10, 0, i10, 4, null);
        this.f52289a = objArr2;
        this.f52290b = 0;
        this.f52291c = length;
    }

    /* renamed from: c */
    public final boolean m66739c() {
        return this.f52290b == this.f52291c;
    }

    /* renamed from: d */
    public final T m66740d() {
        int i10 = this.f52290b;
        if (i10 == this.f52291c) {
            return null;
        }
        Object[] objArr = this.f52289a;
        T t10 = (T) objArr[i10];
        objArr[i10] = null;
        this.f52290b = (i10 + 1) & (objArr.length - 1);
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
