package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.d */
/* loaded from: classes.dex */
public final class C1905d {

    /* renamed from: a */
    public static final Class<?> f9095a = m11512a("libcore.io.Memory");

    /* renamed from: b */
    public static final boolean f9096b;

    static {
        f9096b = m11512a("org.robolectric.Robolectric") != null;
    }

    /* renamed from: a */
    public static <T> Class<T> m11512a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static Class<?> m11513b() {
        return f9095a;
    }

    /* renamed from: c */
    public static boolean m11514c() {
        return (f9095a == null || f9096b) ? false : true;
    }
}
