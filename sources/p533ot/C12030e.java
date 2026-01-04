package p533ot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mt.C11518e;
import p590qt.C12410r;

/* renamed from: ot.e */
/* loaded from: classes5.dex */
public class C12030e {
    /* renamed from: c */
    public static boolean m72168c(List<C11518e> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "gnss infos == null or is empty");
        return false;
    }

    /* renamed from: d */
    public static boolean m72169d(List<C11518e> list) {
        if (!m72168c(list)) {
            return false;
        }
        if (list.size() < 2) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "checkCohesion infos.size() = %d, bypass", Integer.valueOf(list.size())));
            return false;
        }
        if (C12026a.m72162g(list) <= 30.0d) {
            return true;
        }
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "checkCohesion stdPointError(infos) = %f, bypass", Double.valueOf(C12026a.m72162g(list))));
        return false;
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m72170e(C11518e c11518e) {
        return c11518e.m68734n().m68749i() == 1 && c11518e.m68731k() >= 0.98d;
    }

    /* renamed from: f */
    public static /* synthetic */ boolean m72171f(C11518e c11518e) {
        return c11518e.m68734n().m68749i() == 1;
    }

    /* renamed from: g */
    public static int m72172g(List<C11518e> list) {
        if (m72168c(list)) {
            return (int) list.stream().filter(new Predicate() { // from class: ot.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C12030e.m72171f((C11518e) obj);
                }
            }).count();
        }
        return 0;
    }

    /* renamed from: h */
    public static List<C11518e> m72173h(List<C11518e> list) {
        return !m72168c(list) ? new ArrayList() : (List) list.stream().filter(new Predicate() { // from class: ot.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12030e.m72170e((C11518e) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: i */
    public static double m72174i(List<C11518e> list) {
        if (m72168c(list)) {
            return m72172g(list) / list.size();
        }
        return 0.0d;
    }

    /* renamed from: j */
    public static boolean m72175j(List<C11518e> list) {
        return m72174i(list) > 0.15d;
    }
}
