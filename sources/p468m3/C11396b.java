package p468m3;

import java.util.Arrays;

/* renamed from: m3.b */
/* loaded from: classes.dex */
public final class C11396b extends AbstractC11395a {
    /* renamed from: a */
    public static boolean m68302a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    public static int m68303b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
