package com.google.crypto.tink.shaded.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: com.google.crypto.tink.shaded.protobuf.d0 */
/* loaded from: classes.dex */
public final class EnumC1906d0 {

    /* renamed from: d */
    public static final EnumC1906d0 f9097d;

    /* renamed from: e */
    public static final EnumC1906d0 f9098e;

    /* renamed from: f */
    public static final EnumC1906d0 f9099f;

    /* renamed from: g */
    public static final EnumC1906d0 f9100g;

    /* renamed from: h */
    public static final EnumC1906d0 f9101h;

    /* renamed from: i */
    public static final EnumC1906d0 f9102i;

    /* renamed from: j */
    public static final EnumC1906d0 f9103j;

    /* renamed from: k */
    public static final EnumC1906d0 f9104k;

    /* renamed from: l */
    public static final EnumC1906d0 f9105l;

    /* renamed from: m */
    public static final EnumC1906d0 f9106m;

    /* renamed from: n */
    public static final /* synthetic */ EnumC1906d0[] f9107n;

    /* renamed from: a */
    public final Class<?> f9108a;

    /* renamed from: b */
    public final Class<?> f9109b;

    /* renamed from: c */
    public final Object f9110c;

    static {
        EnumC1906d0 enumC1906d0 = new EnumC1906d0("VOID", 0, Void.class, Void.class, null);
        f9097d = enumC1906d0;
        Class cls = Integer.TYPE;
        EnumC1906d0 enumC1906d02 = new EnumC1906d0("INT", 1, cls, Integer.class, 0);
        f9098e = enumC1906d02;
        EnumC1906d0 enumC1906d03 = new EnumC1906d0("LONG", 2, Long.TYPE, Long.class, 0L);
        f9099f = enumC1906d03;
        EnumC1906d0 enumC1906d04 = new EnumC1906d0("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f9100g = enumC1906d04;
        EnumC1906d0 enumC1906d05 = new EnumC1906d0("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f9101h = enumC1906d05;
        EnumC1906d0 enumC1906d06 = new EnumC1906d0("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f9102i = enumC1906d06;
        EnumC1906d0 enumC1906d07 = new EnumC1906d0("STRING", 6, String.class, String.class, "");
        f9103j = enumC1906d07;
        EnumC1906d0 enumC1906d08 = new EnumC1906d0("BYTE_STRING", 7, AbstractC1920i.class, AbstractC1920i.class, AbstractC1920i.f9147b);
        f9104k = enumC1906d08;
        EnumC1906d0 enumC1906d09 = new EnumC1906d0("ENUM", 8, cls, Integer.class, null);
        f9105l = enumC1906d09;
        EnumC1906d0 enumC1906d010 = new EnumC1906d0("MESSAGE", 9, Object.class, Object.class, null);
        f9106m = enumC1906d010;
        f9107n = new EnumC1906d0[]{enumC1906d0, enumC1906d02, enumC1906d03, enumC1906d04, enumC1906d05, enumC1906d06, enumC1906d07, enumC1906d08, enumC1906d09, enumC1906d010};
    }

    public EnumC1906d0(String str, int i10, Class cls, Class cls2, Object obj) {
        this.f9108a = cls;
        this.f9109b = cls2;
        this.f9110c = obj;
    }

    public static EnumC1906d0 valueOf(String str) {
        return (EnumC1906d0) Enum.valueOf(EnumC1906d0.class, str);
    }

    public static EnumC1906d0[] values() {
        return (EnumC1906d0[]) f9107n.clone();
    }

    /* renamed from: b */
    public Class<?> m11515b() {
        return this.f9109b;
    }
}
