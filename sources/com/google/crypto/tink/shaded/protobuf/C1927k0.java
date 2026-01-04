package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.k0 */
/* loaded from: classes.dex */
public final class C1927k0 implements InterfaceC1922i1 {

    /* renamed from: b */
    public static final InterfaceC1948r0 f9187b = new a();

    /* renamed from: a */
    public final InterfaceC1948r0 f9188a;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.k0$a */
    public class a implements InterfaceC1948r0 {
        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1948r0
        /* renamed from: a */
        public InterfaceC1945q0 mo11842a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1948r0
        /* renamed from: b */
        public boolean mo11843b(Class<?> cls) {
            return false;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.k0$b */
    public static class b implements InterfaceC1948r0 {

        /* renamed from: a */
        public InterfaceC1948r0[] f9189a;

        public b(InterfaceC1948r0... interfaceC1948r0Arr) {
            this.f9189a = interfaceC1948r0Arr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1948r0
        /* renamed from: a */
        public InterfaceC1945q0 mo11842a(Class<?> cls) {
            for (InterfaceC1948r0 interfaceC1948r0 : this.f9189a) {
                if (interfaceC1948r0.mo11843b(cls)) {
                    return interfaceC1948r0.mo11842a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1948r0
        /* renamed from: b */
        public boolean mo11843b(Class<?> cls) {
            for (InterfaceC1948r0 interfaceC1948r0 : this.f9189a) {
                if (interfaceC1948r0.mo11843b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public C1927k0() {
        this(m11838b());
    }

    /* renamed from: b */
    public static InterfaceC1948r0 m11838b() {
        return new b(C1966y.m12376c(), m11839c());
    }

    /* renamed from: c */
    public static InterfaceC1948r0 m11839c() {
        try {
            return (InterfaceC1948r0) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f9187b;
        }
    }

    /* renamed from: d */
    public static boolean m11840d(InterfaceC1945q0 interfaceC1945q0) {
        return interfaceC1945q0.mo11641c() == EnumC1904c1.PROTO2;
    }

    /* renamed from: e */
    public static <T> InterfaceC1919h1<T> m11841e(Class<T> cls, InterfaceC1945q0 interfaceC1945q0) {
        return AbstractC1968z.class.isAssignableFrom(cls) ? m11840d(interfaceC1945q0) ? C1960v0.m12296Q(cls, interfaceC1945q0, C1969z0.m12417b(), AbstractC1921i0.m11711b(), C1925j1.m11785M(), C1953t.m12206b(), C1942p0.m12084b()) : C1960v0.m12296Q(cls, interfaceC1945q0, C1969z0.m12417b(), AbstractC1921i0.m11711b(), C1925j1.m11785M(), null, C1942p0.m12084b()) : m11840d(interfaceC1945q0) ? C1960v0.m12296Q(cls, interfaceC1945q0, C1969z0.m12416a(), AbstractC1921i0.m11710a(), C1925j1.m11780H(), C1953t.m12205a(), C1942p0.m12083a()) : C1960v0.m12296Q(cls, interfaceC1945q0, C1969z0.m12416a(), AbstractC1921i0.m11710a(), C1925j1.m11781I(), null, C1942p0.m12083a());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1922i1
    /* renamed from: a */
    public <T> InterfaceC1919h1<T> mo11718a(Class<T> cls) {
        C1925j1.m11782J(cls);
        InterfaceC1945q0 interfaceC1945q0Mo11842a = this.f9188a.mo11842a(cls);
        return interfaceC1945q0Mo11842a.mo11639a() ? AbstractC1968z.class.isAssignableFrom(cls) ? C1963w0.m12360m(C1925j1.m11785M(), C1953t.m12206b(), interfaceC1945q0Mo11842a.mo11640b()) : C1963w0.m12360m(C1925j1.m11780H(), C1953t.m12205a(), interfaceC1945q0Mo11842a.mo11640b()) : m11841e(cls, interfaceC1945q0Mo11842a);
    }

    public C1927k0(InterfaceC1948r0 interfaceC1948r0) {
        this.f9188a = (InterfaceC1948r0) C1900b0.m11487b(interfaceC1948r0, "messageInfoFactory");
    }
}
