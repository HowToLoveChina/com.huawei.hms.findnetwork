package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.p */
/* loaded from: classes.dex */
public final class C1941p {

    /* renamed from: a */
    public static final Class<?> f9233a = m12082c();

    /* renamed from: a */
    public static C1944q m12080a() {
        C1944q c1944qM12081b = m12081b("getEmptyRegistry");
        return c1944qM12081b != null ? c1944qM12081b : C1944q.f9244d;
    }

    /* renamed from: b */
    public static final C1944q m12081b(String str) {
        Class<?> cls = f9233a;
        if (cls == null) {
            return null;
        }
        try {
            return (C1944q) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static Class<?> m12082c() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
