package androidx.appcompat.app;

import java.util.LinkedHashSet;
import java.util.Locale;
import p024b0.C1090f;

/* renamed from: androidx.appcompat.app.o */
/* loaded from: classes.dex */
public final class C0390o {
    /* renamed from: a */
    public static C1090f m2250a(C1090f c1090f, C1090f c1090f2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i10 = 0;
        while (i10 < c1090f.m6480f() + c1090f2.m6480f()) {
            Locale localeM6478c = i10 < c1090f.m6480f() ? c1090f.m6478c(i10) : c1090f2.m6478c(i10 - c1090f.m6480f());
            if (localeM6478c != null) {
                linkedHashSet.add(localeM6478c);
            }
            i10++;
        }
        return C1090f.m6474a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    /* renamed from: b */
    public static C1090f m2251b(C1090f c1090f, C1090f c1090f2) {
        return (c1090f == null || c1090f.m6479e()) ? C1090f.m6476d() : m2250a(c1090f, c1090f2);
    }
}
