package p049c7;

import android.animation.TypeEvaluator;

/* renamed from: c7.b */
/* loaded from: classes2.dex */
public class C1390b implements TypeEvaluator<C1389a> {
    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1389a evaluate(float f10, C1389a c1389a, C1389a c1389a2) {
        int iM7961a = c1389a.m7961a();
        int iM7962b = c1389a.m7962b();
        int iM7961a2 = c1389a2.m7961a() - iM7961a;
        int iM7962b2 = c1389a2.m7962b() - iM7962b;
        return new C1389a(iM7962b2 < 0 ? iM7962b + ((int) (iM7962b2 * f10)) : (int) (iM7962b2 * f10), iM7961a2 < 0 ? iM7961a + ((int) (iM7961a2 * f10)) : (int) (iM7961a2 * f10));
    }
}
