package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.y */
/* loaded from: classes.dex */
public class C1966y implements InterfaceC1948r0 {

    /* renamed from: a */
    public static final C1966y f9421a = new C1966y();

    /* renamed from: c */
    public static C1966y m12376c() {
        return f9421a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1948r0
    /* renamed from: a */
    public InterfaceC1945q0 mo11842a(Class<?> cls) {
        if (!AbstractC1968z.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (InterfaceC1945q0) AbstractC1968z.m12387w(cls.asSubclass(AbstractC1968z.class)).m12393p();
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e10);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1948r0
    /* renamed from: b */
    public boolean mo11843b(Class<?> cls) {
        return AbstractC1968z.class.isAssignableFrom(cls);
    }
}
