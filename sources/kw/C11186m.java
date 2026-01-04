package kw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p461lw.C11352b;
import p692uw.C13267j;

/* renamed from: kw.m */
/* loaded from: classes9.dex */
public class C11186m extends C11185l {
    /* renamed from: c */
    public static final <T> Collection<T> m67173c(T[] tArr) {
        C13267j.m79677e(tArr, "<this>");
        return new C11167c(tArr, false);
    }

    /* renamed from: d */
    public static final <T extends Comparable<? super T>> int m67174d(List<? extends T> list, T t10, int i10, int i11) {
        C13267j.m79677e(list, "<this>");
        m67180j(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iM68162a = C11352b.m68162a(list.get(i13), t10);
            if (iM68162a < 0) {
                i10 = i13 + 1;
            } else {
                if (iM68162a <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    /* renamed from: e */
    public static /* synthetic */ int m67175e(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return m67174d(list, comparable, i10, i11);
    }

    /* renamed from: f */
    public static final <T> List<T> m67176f() {
        return C11196w.f52516a;
    }

    /* renamed from: g */
    public static <T> List<T> m67177g(T... tArr) {
        C13267j.m79677e(tArr, "elements");
        return tArr.length > 0 ? C11175g.m67142b(tArr) : m67176f();
    }

    /* renamed from: h */
    public static <T> List<T> m67178h(T... tArr) {
        C13267j.m79677e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new C11167c(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public static <T> List<T> m67179i(List<? extends T> list) {
        C13267j.m79677e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : C11185l.m67172b(list.get(0)) : m67176f();
    }

    /* renamed from: j */
    public static final void m67180j(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than zero.");
        }
        if (i12 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
    }

    /* renamed from: k */
    public static void m67181k() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
