package fk;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: fk.a */
/* loaded from: classes6.dex */
public class C9720a {
    /* renamed from: a */
    public static void m60652a(boolean z10, String str) throws C9721b {
        if (!z10) {
            throw new C9721b(4002, str, "assert");
        }
    }

    /* renamed from: b */
    public static void m60653b(String str, String str2) throws C9721b {
        if (str == null || str.isEmpty()) {
            throw new C9721b(4002, str2);
        }
    }

    /* renamed from: c */
    public static void m60654c(Collection<?> collection, String str) throws C9721b {
        if (collection == null || collection.isEmpty()) {
            throw new C9721b(4002, str);
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            m60657f(it.next(), str);
        }
    }

    /* renamed from: d */
    public static void m60655d(Map<?, ?> map, String str) throws C9721b {
        if (map == null || map.isEmpty()) {
            throw new C9721b(4002, str);
        }
    }

    /* renamed from: e */
    public static void m60656e(String[] strArr, String str) throws C9721b {
        if (strArr == null || strArr.length == 0) {
            throw new C9721b(4002, str);
        }
        for (String str2 : strArr) {
            m60653b(str2, str);
        }
    }

    /* renamed from: f */
    public static void m60657f(Object obj, String str) throws C9721b {
        if (obj == null) {
            throw new C9721b(4002, str);
        }
    }
}
