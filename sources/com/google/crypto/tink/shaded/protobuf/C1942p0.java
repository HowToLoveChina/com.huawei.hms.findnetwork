package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.p0 */
/* loaded from: classes.dex */
public final class C1942p0 {

    /* renamed from: a */
    public static final InterfaceC1936n0 f9234a = m12085c();

    /* renamed from: b */
    public static final InterfaceC1936n0 f9235b = new C1939o0();

    /* renamed from: a */
    public static InterfaceC1936n0 m12083a() {
        return f9234a;
    }

    /* renamed from: b */
    public static InterfaceC1936n0 m12084b() {
        return f9235b;
    }

    /* renamed from: c */
    public static InterfaceC1936n0 m12085c() {
        try {
            return (InterfaceC1936n0) Class.forName("com.google.crypto.tink.shaded.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
