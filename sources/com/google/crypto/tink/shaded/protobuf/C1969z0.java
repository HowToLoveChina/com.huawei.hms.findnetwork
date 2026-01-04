package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.z0 */
/* loaded from: classes.dex */
public final class C1969z0 {

    /* renamed from: a */
    public static final InterfaceC1965x0 f9441a = m12418c();

    /* renamed from: b */
    public static final InterfaceC1965x0 f9442b = new C1967y0();

    /* renamed from: a */
    public static InterfaceC1965x0 m12416a() {
        return f9441a;
    }

    /* renamed from: b */
    public static InterfaceC1965x0 m12417b() {
        return f9442b;
    }

    /* renamed from: c */
    public static InterfaceC1965x0 m12418c() {
        try {
            return (InterfaceC1965x0) Class.forName("com.google.crypto.tink.shaded.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
