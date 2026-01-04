package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.u1 */
/* loaded from: classes.dex */
public final class C1958u1 {

    /* renamed from: a */
    public static final int f9283a = m12259c(1, 3);

    /* renamed from: b */
    public static final int f9284b = m12259c(1, 4);

    /* renamed from: c */
    public static final int f9285c = m12259c(2, 0);

    /* renamed from: d */
    public static final int f9286d = m12259c(3, 2);

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
    /* renamed from: com.google.crypto.tink.shaded.protobuf.u1$b */
    public static class b {

        /* renamed from: c */
        public static final b f9287c;

        /* renamed from: d */
        public static final b f9288d;

        /* renamed from: e */
        public static final b f9289e;

        /* renamed from: f */
        public static final b f9290f;

        /* renamed from: g */
        public static final b f9291g;

        /* renamed from: h */
        public static final b f9292h;

        /* renamed from: i */
        public static final b f9293i;

        /* renamed from: j */
        public static final b f9294j;

        /* renamed from: k */
        public static final b f9295k;

        /* renamed from: l */
        public static final b f9296l;

        /* renamed from: m */
        public static final b f9297m;

        /* renamed from: n */
        public static final b f9298n;

        /* renamed from: o */
        public static final b f9299o;

        /* renamed from: p */
        public static final b f9300p;

        /* renamed from: q */
        public static final b f9301q;

        /* renamed from: r */
        public static final b f9302r;

        /* renamed from: s */
        public static final b f9303s;

        /* renamed from: t */
        public static final b f9304t;

        /* renamed from: u */
        public static final /* synthetic */ b[] f9305u;

        /* renamed from: a */
        public final c f9306a;

        /* renamed from: b */
        public final int f9307b;

        /* renamed from: com.google.crypto.tink.shaded.protobuf.u1$b$a */
        public enum a extends b {
            public a(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        /* renamed from: com.google.crypto.tink.shaded.protobuf.u1$b$b, reason: collision with other inner class name */
        public enum C14420b extends b {
            public C14420b(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        /* renamed from: com.google.crypto.tink.shaded.protobuf.u1$b$c */
        public enum c extends b {
            public c(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        /* renamed from: com.google.crypto.tink.shaded.protobuf.u1$b$d */
        public enum d extends b {
            public d(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f9287c = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f9288d = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f9289e = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f9290f = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f9291g = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f9292h = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f9293i = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f9294j = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f9295k = aVar;
            c cVar3 = c.MESSAGE;
            C14420b c14420b = new C14420b("GROUP", 9, cVar3, 3);
            f9296l = c14420b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f9297m = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f9298n = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f9299o = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f9300p = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f9301q = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f9302r = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f9303s = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f9304t = bVar14;
            f9305u = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c14420b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f9305u.clone();
        }

        /* renamed from: b */
        public c m12260b() {
            return this.f9306a;
        }

        public b(String str, int i10, c cVar, int i11) {
            this.f9306a = cVar;
            this.f9307b = i11;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.u1$c */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(AbstractC1920i.f9147b),
        ENUM(null),
        MESSAGE(null);


        /* renamed from: a */
        public final Object f9318a;

        c(Object obj) {
            this.f9318a = obj;
        }
    }

    /* renamed from: a */
    public static int m12257a(int i10) {
        return i10 >>> 3;
    }

    /* renamed from: b */
    public static int m12258b(int i10) {
        return i10 & 7;
    }

    /* renamed from: c */
    public static int m12259c(int i10, int i11) {
        return (i10 << 3) | i11;
    }
}
