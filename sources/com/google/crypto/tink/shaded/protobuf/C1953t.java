package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.t */
/* loaded from: classes.dex */
public final class C1953t {

    /* renamed from: a */
    public static final AbstractC1947r<?> f9280a = new C1950s();

    /* renamed from: b */
    public static final AbstractC1947r<?> f9281b = m12207c();

    /* renamed from: a */
    public static AbstractC1947r<?> m12205a() {
        AbstractC1947r<?> abstractC1947r = f9281b;
        if (abstractC1947r != null) {
            return abstractC1947r;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* renamed from: b */
    public static AbstractC1947r<?> m12206b() {
        return f9280a;
    }

    /* renamed from: c */
    public static AbstractC1947r<?> m12207c() {
        try {
            return (AbstractC1947r) Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
