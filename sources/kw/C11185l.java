package kw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p692uw.C13267j;

/* renamed from: kw.l */
/* loaded from: classes9.dex */
public class C11185l {
    /* renamed from: a */
    public static final <T> Object[] m67171a(T[] tArr, boolean z10) {
        C13267j.m79677e(tArr, "<this>");
        if (z10 && C13267j.m79673a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        C13267j.m79676d(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    /* renamed from: b */
    public static <T> List<T> m67172b(T t10) {
        List<T> listSingletonList = Collections.singletonList(t10);
        C13267j.m79676d(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }
}
