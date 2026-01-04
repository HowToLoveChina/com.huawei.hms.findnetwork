package kw;

import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import p692uw.C13267j;

/* renamed from: kw.h */
/* loaded from: classes9.dex */
public class C11177h extends C11175g {
    /* renamed from: h */
    public static final <T> boolean m67148h(T[] tArr, T t10) {
        C13267j.m79677e(tArr, "<this>");
        return m67151k(tArr, t10) >= 0;
    }

    /* renamed from: i */
    public static <T> List<T> m67149i(T[] tArr) {
        C13267j.m79677e(tArr, "<this>");
        return (List) m67150j(tArr, new ArrayList());
    }

    /* renamed from: j */
    public static final <C extends Collection<? super T>, T> C m67150j(T[] tArr, C c10) {
        C13267j.m79677e(tArr, "<this>");
        C13267j.m79677e(c10, JsbMapKeyNames.H5_CLICK_DEST);
        for (T t10 : tArr) {
            if (t10 != null) {
                c10.add(t10);
            }
        }
        return c10;
    }

    /* renamed from: k */
    public static final <T> int m67151k(T[] tArr, T t10) {
        C13267j.m79677e(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (C13267j.m79673a(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* renamed from: l */
    public static char m67152l(char[] cArr) {
        C13267j.m79677e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    /* renamed from: m */
    public static <T> T m67153m(T[] tArr) {
        C13267j.m79677e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    /* renamed from: n */
    public static <T> List<T> m67154n(T[] tArr) {
        C13267j.m79677e(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? m67155o(tArr) : C11185l.m67172b(tArr[0]) : C11186m.m67176f();
    }

    /* renamed from: o */
    public static <T> List<T> m67155o(T[] tArr) {
        C13267j.m79677e(tArr, "<this>");
        return new ArrayList(C11186m.m67173c(tArr));
    }
}
