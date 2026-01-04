package com.huawei.cloud.base.util;

/* renamed from: com.huawei.cloud.base.util.e0 */
/* loaded from: classes.dex */
public final class C4635e0 {
    /* renamed from: a */
    public static RuntimeException m28408a(Throwable th2) {
        m28411d(th2);
        throw new RuntimeException(th2);
    }

    /* renamed from: b */
    public static void m28409b(Throwable th2) {
        if (th2 != null) {
            m28411d(th2);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    /* renamed from: c */
    public static <X extends Throwable> void m28410c(Throwable th2, Class<X> cls) throws Throwable {
        if (th2 != null && cls.isInstance(th2)) {
            throw cls.cast(th2);
        }
        m28409b(th2);
    }

    /* renamed from: d */
    public static void m28411d(Throwable th2) {
        C4627a0.m28391d(th2);
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
    }
}
