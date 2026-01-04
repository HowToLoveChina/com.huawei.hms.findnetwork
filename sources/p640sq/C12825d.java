package p640sq;

import java.util.Collection;

/* renamed from: sq.d */
/* loaded from: classes8.dex */
public class C12825d {
    /* renamed from: a */
    public static Boolean m77024a(Collection collection) {
        return (collection == null || collection.size() == 0) ? Boolean.TRUE : Boolean.FALSE;
    }

    /* renamed from: b */
    public static Boolean m77025b(Collection collection) {
        return Boolean.valueOf(!m77024a(collection).booleanValue());
    }
}
