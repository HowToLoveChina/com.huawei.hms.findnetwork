package kw;

import java.util.Collection;
import p692uw.C13267j;

/* renamed from: kw.n */
/* loaded from: classes9.dex */
public class C11187n extends C11186m {
    /* renamed from: l */
    public static <T> int m67182l(Iterable<? extends T> iterable, int i10) {
        C13267j.m79677e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }
}
