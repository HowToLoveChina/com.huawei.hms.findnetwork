package p354i1;

import com.baidu.location.BDLocation;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.openalliance.p169ad.constant.CreativeType;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import p305g1.C9838c;
import p305g1.C9839d;
import p305g1.C9841f;
import p305g1.C9844i;
import p305g1.C9845j;
import p305g1.InterfaceC9843h;
import p323h1.AbstractC10080d;
import p323h1.C10077a;
import p323h1.C10084h;
import p323h1.C10085i;
import p323h1.C10086j;
import p323h1.EnumC10078b;
import p323h1.InterfaceC10079c;
import p481n1.C11589a;
import p481n1.C11590b;
import p481n1.C11592d;
import p481n1.C11595g;
import p481n1.C11597i;
import p481n1.C11603o;

/* renamed from: i1.a */
/* loaded from: classes.dex */
public class C10386a {

    /* renamed from: c */
    public static final String f50175c = C11590b.m69190g(C10077a.class);

    /* renamed from: d */
    public static final String f50176d = C11590b.m69190g(AbstractC10080d.class);

    /* renamed from: a */
    public final C11589a f50177a;

    /* renamed from: b */
    public final AtomicLong f50178b = new AtomicLong();

    /* renamed from: i1.a$a */
    public static class a {

        /* renamed from: a */
        public int f50179a;

        /* renamed from: b */
        public final Map<String, Integer> f50180b = new HashMap();

        /* renamed from: c */
        public final Class<?> f50181c;

        /* renamed from: d */
        public final C11597i f50182d;

        /* renamed from: e */
        public final String f50183e;

        /* renamed from: f */
        public C11592d[] f50184f;

        public a(String str, C10085i c10085i, C11597i c11597i, int i10) {
            this.f50179a = -1;
            this.f50183e = str;
            this.f50181c = c11597i.f53814a;
            this.f50179a = i10;
            this.f50182d = c11597i;
            this.f50184f = c11597i.f53821h;
        }

        /* renamed from: g */
        public String m63883g(C11592d c11592d) {
            if (m63886j(c11592d.f53768a)) {
                return c11592d.f53768a + "_asm_deser__";
            }
            return "_asm_deser__" + C11603o.m69259J(c11592d.f53768a);
        }

        /* renamed from: h */
        public String m63884h(C11592d c11592d) {
            if (m63886j(c11592d.f53768a)) {
                return c11592d.f53768a + "_asm_prefix__";
            }
            return "asm_field_" + C11603o.m69259J(c11592d.f53768a);
        }

        /* renamed from: i */
        public Class<?> m63885i() {
            Class<?> cls = this.f50182d.f53815b;
            return cls == null ? this.f50181c : cls;
        }

        /* renamed from: j */
        public boolean m63886j(String str) {
            for (int i10 = 0; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (cCharAt == 0) {
                    if (!C11595g.m69210e(cCharAt)) {
                        return false;
                    }
                } else if (!C11595g.m69214i(cCharAt)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: k */
        public int m63887k(String str) {
            if (this.f50180b.get(str) == null) {
                Map<String, Integer> map = this.f50180b;
                int i10 = this.f50179a;
                this.f50179a = i10 + 1;
                map.put(str, Integer.valueOf(i10));
            }
            return this.f50180b.get(str).intValue();
        }

        /* renamed from: l */
        public int m63888l(String str, int i10) {
            if (this.f50180b.get(str) == null) {
                this.f50180b.put(str, Integer.valueOf(this.f50179a));
                this.f50179a += i10;
            }
            return this.f50180b.get(str).intValue();
        }

        /* renamed from: m */
        public int m63889m(C11592d c11592d) {
            return m63887k(c11592d.f53768a + "_asm");
        }

        /* renamed from: n */
        public int m63890n(C11592d c11592d, int i10) {
            return m63888l(c11592d.f53768a + "_asm", i10);
        }
    }

    public C10386a(ClassLoader classLoader) {
        this.f50177a = classLoader instanceof C11589a ? (C11589a) classLoader : new C11589a(classLoader);
    }

    /* renamed from: a */
    public final void m63854a(a aVar, InterfaceC9843h interfaceC9843h) {
        m63855b(aVar, interfaceC9843h, true);
    }

    /* renamed from: b */
    public final void m63855b(a aVar, InterfaceC9843h interfaceC9843h, boolean z10) {
        int length = aVar.f50184f.length;
        for (int i10 = 0; i10 < length; i10++) {
            C9841f c9841f = new C9841f();
            if (z10) {
                m63867n(interfaceC9843h, aVar, i10, c9841f);
            }
            m63868o(aVar, interfaceC9843h, aVar.f50184f[i10]);
            if (z10) {
                interfaceC9843h.mo61192l(c9841f);
            }
        }
    }

    /* renamed from: c */
    public final void m63856c(C9838c c9838c, a aVar) {
        if (Modifier.isPublic(aVar.f50182d.f53816c.getModifiers())) {
            C9844i c9844i = new C9844i(c9838c, 1, "createInstance", "(L" + f50175c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
            c9844i.mo61182b(187, C11590b.m69190g(aVar.m63885i()));
            c9844i.mo61185e(89);
            c9844i.mo61189i(183, C11590b.m69190g(aVar.m63885i()), "<init>", "()V");
            c9844i.mo61185e(176);
            c9844i.mo61186f(3, 3);
            c9844i.mo61190j();
        }
    }

    /* renamed from: d */
    public final void m63857d(a aVar, InterfaceC9843h interfaceC9843h) {
        Constructor<?> constructor = aVar.f50182d.f53816c;
        if (Modifier.isPublic(constructor.getModifiers())) {
            interfaceC9843h.mo61182b(187, C11590b.m69190g(aVar.m63885i()));
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61189i(183, C11590b.m69190g(constructor.getDeclaringClass()), "<init>", "()V");
        } else {
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61183c(180, C11590b.m69190g(C10403o.class), "clazz", "Ljava/lang/Class;");
            interfaceC9843h.mo61189i(183, C11590b.m69190g(C10403o.class), "createInstance", "(L" + f50175c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            interfaceC9843h.mo61182b(192, C11590b.m69190g(aVar.m63885i()));
        }
        interfaceC9843h.mo61187g(58, aVar.m63887k("instance"));
    }

    /* renamed from: e */
    public final void m63858e(a aVar, InterfaceC9843h interfaceC9843h, C11592d c11592d, Class<?> cls, int i10) {
        m63865l(aVar, interfaceC9843h, c11592d);
        C9841f c9841f = new C9841f();
        C9841f c9841f2 = new C9841f();
        if ((c11592d.f53777j & EnumC10078b.SupportArrayToBean.f49196a) != 0) {
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61182b(193, C11590b.m69190g(C10403o.class));
            interfaceC9843h.mo61188h(153, c9841f);
            interfaceC9843h.mo61182b(192, C11590b.m69190g(C10403o.class));
            interfaceC9843h.mo61187g(25, 1);
            if (c11592d.f53773f instanceof Class) {
                interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(c11592d.f53772e)));
            } else {
                interfaceC9843h.mo61187g(25, 0);
                interfaceC9843h.mo61191k(Integer.valueOf(i10));
                interfaceC9843h.mo61189i(182, C11590b.m69190g(C10403o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            interfaceC9843h.mo61191k(c11592d.f53768a);
            interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53777j));
            interfaceC9843h.mo61189i(182, C11590b.m69190g(C10403o.class), "deserialze", "(L" + f50175c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            interfaceC9843h.mo61182b(192, C11590b.m69190g(cls));
            interfaceC9843h.mo61187g(58, aVar.m63889m(c11592d));
            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f2);
            interfaceC9843h.mo61192l(c9841f);
        }
        interfaceC9843h.mo61187g(25, 1);
        if (c11592d.f53773f instanceof Class) {
            interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(c11592d.f53772e)));
        } else {
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61191k(Integer.valueOf(i10));
            interfaceC9843h.mo61189i(182, C11590b.m69190g(C10403o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        interfaceC9843h.mo61191k(c11592d.f53768a);
        interfaceC9843h.mo61189i(185, C11590b.m69190g(InterfaceC10408t.class), "deserialze", "(L" + f50175c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        interfaceC9843h.mo61182b(192, C11590b.m69190g(cls));
        interfaceC9843h.mo61187g(58, aVar.m63889m(c11592d));
        interfaceC9843h.mo61192l(c9841f2);
    }

    /* renamed from: f */
    public final void m63859f(a aVar, InterfaceC9843h interfaceC9843h, C9841f c9841f) {
        interfaceC9843h.mo61184d(21, aVar.m63887k("matchedCount"));
        interfaceC9843h.mo61188h(158, c9841f);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, f50176d, "token", "()I");
        interfaceC9843h.mo61191k(13);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f);
        m63871r(aVar, interfaceC9843h);
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0ac5  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m63860g(p305g1.C9838c r31, p354i1.C10386a.a r32) {
        /*
            Method dump skipped, instructions count: 3268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10386a.m63860g(g1.c, i1.a$a):void");
    }

    /* renamed from: h */
    public final void m63861h(C9838c c9838c, a aVar) {
        int i10;
        Class<C10403o> cls;
        int i11;
        char c10;
        char c11;
        boolean z10;
        char c12;
        int i12;
        int i13;
        char c13;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(L");
        String str = f50175c;
        sb2.append(str);
        sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        C9844i c9844i = new C9844i(c9838c, 1, "deserialzeArrayMapping", sb2.toString(), null, null);
        m63876w(aVar, c9844i);
        c9844i.mo61187g(25, aVar.m63887k("lexer"));
        c9844i.mo61187g(25, 1);
        c9844i.mo61189i(182, str, "getSymbolTable", "()" + C11590b.m69185b(C10086j.class));
        c9844i.mo61189i(182, f50176d, "scanTypeName", "(" + C11590b.m69185b(C10086j.class) + ")Ljava/lang/String;");
        c9844i.mo61187g(58, aVar.m63887k("typeName"));
        C9841f c9841f = new C9841f();
        c9844i.mo61187g(25, aVar.m63887k("typeName"));
        c9844i.mo61188h(198, c9841f);
        c9844i.mo61187g(25, 1);
        c9844i.mo61189i(182, str, C5963j.f27044m, "()" + C11590b.m69185b(C10085i.class));
        c9844i.mo61187g(25, 0);
        Class<C10403o> cls2 = C10403o.class;
        c9844i.mo61183c(180, C11590b.m69190g(cls2), "beanInfo", C11590b.m69185b(C11597i.class));
        c9844i.mo61187g(25, aVar.m63887k("typeName"));
        c9844i.mo61189i(184, C11590b.m69190g(cls2), "getSeeAlso", "(" + C11590b.m69185b(C10085i.class) + C11590b.m69185b(C11597i.class) + "Ljava/lang/String;)" + C11590b.m69185b(cls2));
        c9844i.mo61187g(58, aVar.m63887k("userTypeDeser"));
        c9844i.mo61187g(25, aVar.m63887k("userTypeDeser"));
        c9844i.mo61182b(193, C11590b.m69190g(cls2));
        c9844i.mo61188h(153, c9841f);
        c9844i.mo61187g(25, aVar.m63887k("userTypeDeser"));
        c9844i.mo61187g(25, 1);
        c9844i.mo61187g(25, 2);
        c9844i.mo61187g(25, 3);
        c9844i.mo61187g(25, 4);
        c9844i.mo61189i(182, C11590b.m69190g(cls2), "deserialzeArrayMapping", "(L" + str + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        c9844i.mo61185e(176);
        c9844i.mo61192l(c9841f);
        m63857d(aVar, c9844i);
        C11592d[] c11592dArr = aVar.f50182d.f53822i;
        int length = c11592dArr.length;
        int i14 = 0;
        while (i14 < length) {
            boolean z11 = i14 == length + (-1);
            int i15 = z11 ? 93 : 44;
            C11592d c11592d = c11592dArr[i14];
            Class<?> cls3 = c11592d.f53772e;
            Type type = c11592d.f53773f;
            int i16 = length;
            C11592d[] c11592dArr2 = c11592dArr;
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                i10 = i14;
                cls = cls2;
                i11 = i16;
                c10 = 184;
                c11 = ':';
                z10 = true;
                c12 = 180;
                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                c9844i.mo61187g(16, i15);
                c9844i.mo61189i(182, f50176d, "scanInt", "(C)I");
                c9844i.mo61187g(54, aVar.m63889m(c11592d));
            } else {
                boolean z12 = z11;
                int i17 = i14;
                if (cls3 == Byte.class) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    String str2 = f50176d;
                    c9844i.mo61189i(182, str2, "scanInt", "(C)I");
                    c9844i.mo61189i(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    C9841f c9841f2 = new C9841f();
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61183c(180, str2, "matchStat", "I");
                    c9844i.mo61191k(5);
                    c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f2);
                    c9844i.mo61185e(1);
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    c9844i.mo61192l(c9841f2);
                } else if (cls3 == Short.class) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    String str3 = f50176d;
                    c9844i.mo61189i(182, str3, "scanInt", "(C)I");
                    c9844i.mo61189i(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    C9841f c9841f3 = new C9841f();
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61183c(180, str3, "matchStat", "I");
                    c9844i.mo61191k(5);
                    c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f3);
                    c9844i.mo61185e(1);
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    c9844i.mo61192l(c9841f3);
                } else if (cls3 == Integer.class) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    String str4 = f50176d;
                    c9844i.mo61189i(182, str4, "scanInt", "(C)I");
                    c9844i.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    C9841f c9841f4 = new C9841f();
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61183c(180, str4, "matchStat", "I");
                    c9844i.mo61191k(5);
                    c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f4);
                    c9844i.mo61185e(1);
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    c9844i.mo61192l(c9841f4);
                } else if (cls3 == Long.TYPE) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    c9844i.mo61189i(182, f50176d, "scanLong", "(C)J");
                    c9844i.mo61187g(55, aVar.m63890n(c11592d, 2));
                } else if (cls3 == Long.class) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    String str5 = f50176d;
                    c9844i.mo61189i(182, str5, "scanLong", "(C)J");
                    c9844i.mo61189i(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    C9841f c9841f5 = new C9841f();
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61183c(180, str5, "matchStat", "I");
                    c9844i.mo61191k(5);
                    c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f5);
                    c9844i.mo61185e(1);
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    c9844i.mo61192l(c9841f5);
                } else if (cls3 == Boolean.TYPE) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    c9844i.mo61189i(182, f50176d, "scanBoolean", "(C)Z");
                    c9844i.mo61187g(54, aVar.m63889m(c11592d));
                } else if (cls3 == Float.TYPE) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    c9844i.mo61189i(182, f50176d, "scanFloat", "(C)F");
                    c9844i.mo61187g(56, aVar.m63889m(c11592d));
                } else if (cls3 == Float.class) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    String str6 = f50176d;
                    c9844i.mo61189i(182, str6, "scanFloat", "(C)F");
                    c9844i.mo61189i(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    C9841f c9841f6 = new C9841f();
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61183c(180, str6, "matchStat", "I");
                    c9844i.mo61191k(5);
                    c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f6);
                    c9844i.mo61185e(1);
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    c9844i.mo61192l(c9841f6);
                } else if (cls3 == Double.TYPE) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    c9844i.mo61189i(182, f50176d, "scanDouble", "(C)D");
                    c9844i.mo61187g(57, aVar.m63890n(c11592d, 2));
                } else if (cls3 == Double.class) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    String str7 = f50176d;
                    c9844i.mo61189i(182, str7, "scanDouble", "(C)D");
                    c9844i.mo61189i(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    C9841f c9841f7 = new C9841f();
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61183c(180, str7, "matchStat", "I");
                    c9844i.mo61191k(5);
                    c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f7);
                    c9844i.mo61185e(1);
                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    c9844i.mo61192l(c9841f7);
                } else if (cls3 == Character.TYPE) {
                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                    c9844i.mo61187g(16, i15);
                    c9844i.mo61189i(182, f50176d, "scanString", "(C)Ljava/lang/String;");
                    c9844i.mo61185e(3);
                    c9844i.mo61189i(182, "java/lang/String", "charAt", "(I)C");
                    c9844i.mo61187g(54, aVar.m63889m(c11592d));
                } else {
                    if (cls3 == String.class) {
                        c9844i.mo61187g(25, aVar.m63887k("lexer"));
                        c9844i.mo61187g(16, i15);
                        c9844i.mo61189i(182, f50176d, "scanString", "(C)Ljava/lang/String;");
                        c13 = ':';
                        c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    } else if (cls3 == BigDecimal.class) {
                        c9844i.mo61187g(25, aVar.m63887k("lexer"));
                        c9844i.mo61187g(16, i15);
                        c9844i.mo61189i(182, f50176d, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                        c13 = ':';
                        c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    } else if (cls3 == Date.class) {
                        c9844i.mo61187g(25, aVar.m63887k("lexer"));
                        c9844i.mo61187g(16, i15);
                        c9844i.mo61189i(182, f50176d, "scanDate", "(C)Ljava/util/Date;");
                        c13 = ':';
                        c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    } else if (cls3 == UUID.class) {
                        c9844i.mo61187g(25, aVar.m63887k("lexer"));
                        c9844i.mo61187g(16, i15);
                        c9844i.mo61189i(182, f50176d, "scanUUID", "(C)Ljava/util/UUID;");
                        c13 = ':';
                        c9844i.mo61187g(58, aVar.m63889m(c11592d));
                    } else if (cls3.isEnum()) {
                        C9841f c9841f8 = new C9841f();
                        C9841f c9841f9 = new C9841f();
                        C9841f c9841f10 = new C9841f();
                        C9841f c9841f11 = new C9841f();
                        cls = cls2;
                        c9844i.mo61187g(25, aVar.m63887k("lexer"));
                        String str8 = f50176d;
                        c9844i.mo61189i(182, str8, "getCurrent", "()C");
                        c9844i.mo61185e(89);
                        c9844i.mo61187g(54, aVar.m63887k("ch"));
                        c9844i.mo61191k(110);
                        c9844i.mo61188h(159, c9841f11);
                        c9844i.mo61187g(21, aVar.m63887k("ch"));
                        c9844i.mo61191k(34);
                        c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f8);
                        c9844i.mo61192l(c9841f11);
                        c9844i.mo61187g(25, aVar.m63887k("lexer"));
                        c9844i.mo61191k(C9845j.m61197g(C11590b.m69185b(cls3)));
                        c9844i.mo61187g(25, 1);
                        c9844i.mo61189i(182, f50175c, "getSymbolTable", "()" + C11590b.m69185b(C10086j.class));
                        c9844i.mo61187g(16, i15);
                        c9844i.mo61189i(182, str8, "scanEnum", "(Ljava/lang/Class;" + C11590b.m69185b(C10086j.class) + "C)Ljava/lang/Enum;");
                        c9844i.mo61188h(BDLocation.TypeServerError, c9841f10);
                        c9844i.mo61192l(c9841f8);
                        c9844i.mo61187g(21, aVar.m63887k("ch"));
                        c9844i.mo61191k(48);
                        c9844i.mo61188h(BDLocation.TypeNetWorkLocation, c9841f9);
                        c9844i.mo61187g(21, aVar.m63887k("ch"));
                        c9844i.mo61191k(57);
                        c9844i.mo61188h(163, c9841f9);
                        m63865l(aVar, c9844i, c11592d);
                        c9844i.mo61182b(192, C11590b.m69190g(C10396h.class));
                        c9844i.mo61187g(25, aVar.m63887k("lexer"));
                        c9844i.mo61187g(16, i15);
                        c9844i.mo61189i(182, str8, "scanInt", "(C)I");
                        c9844i.mo61189i(182, C11590b.m69190g(C10396h.class), "valueOf", "(I)Ljava/lang/Enum;");
                        c9844i.mo61188h(BDLocation.TypeServerError, c9841f10);
                        c9844i.mo61192l(c9841f9);
                        c9844i.mo61187g(25, 0);
                        c9844i.mo61187g(25, aVar.m63887k("lexer"));
                        c9844i.mo61187g(16, i15);
                        c9844i.mo61189i(182, C11590b.m69190g(cls), "scanEnum", "(L" + str8 + ";C)Ljava/lang/Enum;");
                        c9844i.mo61192l(c9841f10);
                        c9844i.mo61182b(192, C11590b.m69190g(cls3));
                        c9844i.mo61187g(58, aVar.m63889m(c11592d));
                        c11 = ':';
                        i11 = i16;
                        i10 = i17;
                        c10 = 184;
                        z10 = true;
                        c12 = 180;
                    } else {
                        cls = cls2;
                        if (Collection.class.isAssignableFrom(cls3)) {
                            Class<?> clsM69273R = C11603o.m69273R(type);
                            if (clsM69273R == String.class) {
                                if (cls3 == List.class || cls3 == Collections.class || cls3 == ArrayList.class) {
                                    c9844i.mo61182b(187, C11590b.m69190g(ArrayList.class));
                                    c9844i.mo61185e(89);
                                    c9844i.mo61189i(183, C11590b.m69190g(ArrayList.class), "<init>", "()V");
                                } else {
                                    c9844i.mo61191k(C9845j.m61197g(C11590b.m69185b(cls3)));
                                    c9844i.mo61189i(184, C11590b.m69190g(C11603o.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                                }
                                c9844i.mo61187g(58, aVar.m63889m(c11592d));
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                c9844i.mo61187g(25, aVar.m63889m(c11592d));
                                c9844i.mo61187g(16, i15);
                                String str9 = f50176d;
                                c9844i.mo61189i(182, str9, "scanStringArray", "(Ljava/util/Collection;C)V");
                                C9841f c9841f12 = new C9841f();
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                c9844i.mo61183c(180, str9, "matchStat", "I");
                                c9844i.mo61191k(5);
                                c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f12);
                                c9844i.mo61185e(1);
                                c9844i.mo61187g(58, aVar.m63889m(c11592d));
                                c9844i.mo61192l(c9841f12);
                                i13 = i17;
                                c10 = 184;
                            } else {
                                C9841f c9841f13 = new C9841f();
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                String str10 = f50176d;
                                c9844i.mo61189i(182, str10, "token", "()I");
                                c9844i.mo61187g(54, aVar.m63887k("token"));
                                c9844i.mo61187g(21, aVar.m63887k("token"));
                                int i18 = i17 == 0 ? 14 : 16;
                                c9844i.mo61191k(Integer.valueOf(i18));
                                c9844i.mo61188h(159, c9841f13);
                                c9844i.mo61187g(25, 1);
                                c9844i.mo61191k(Integer.valueOf(i18));
                                String str11 = f50175c;
                                c9844i.mo61189i(182, str11, "throwException", "(I)V");
                                c9844i.mo61192l(c9841f13);
                                C9841f c9841f14 = new C9841f();
                                C9841f c9841f15 = new C9841f();
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                c9844i.mo61189i(182, str10, "getCurrent", "()C");
                                c9844i.mo61187g(16, 91);
                                c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f14);
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                c9844i.mo61189i(182, str10, "next", "()C");
                                c9844i.mo61185e(87);
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                c9844i.mo61191k(14);
                                c9844i.mo61189i(182, str10, "setToken", "(I)V");
                                c9844i.mo61188h(BDLocation.TypeServerError, c9841f15);
                                c9844i.mo61192l(c9841f14);
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                c9844i.mo61191k(14);
                                c9844i.mo61189i(182, str10, "nextToken", "(I)V");
                                c9844i.mo61192l(c9841f15);
                                i13 = i17;
                                m63869p(c9844i, cls3, i13, false);
                                c9844i.mo61185e(89);
                                c9844i.mo61187g(58, aVar.m63889m(c11592d));
                                m63864k(aVar, c9844i, c11592d, clsM69273R);
                                c9844i.mo61187g(25, 1);
                                c9844i.mo61191k(C9845j.m61197g(C11590b.m69185b(clsM69273R)));
                                c9844i.mo61187g(25, 3);
                                c10 = 184;
                                c9844i.mo61189i(184, C11590b.m69190g(cls), "parseArray", "(Ljava/util/Collection;" + C11590b.m69185b(InterfaceC10408t.class) + "L" + str11 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                            }
                            i10 = i13;
                            i11 = i16;
                            c11 = ':';
                            z10 = true;
                            c12 = 180;
                        } else {
                            c10 = 184;
                            if (cls3.isArray()) {
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                c9844i.mo61191k(14);
                                c9844i.mo61189i(182, f50176d, "nextToken", "(I)V");
                                z10 = true;
                                c9844i.mo61187g(25, 1);
                                c9844i.mo61187g(25, 0);
                                c9844i.mo61191k(Integer.valueOf(i17));
                                c9844i.mo61189i(182, C11590b.m69190g(cls), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                                c9844i.mo61189i(182, f50175c, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                                c9844i.mo61182b(192, C11590b.m69190g(cls3));
                                c9844i.mo61187g(58, aVar.m63889m(c11592d));
                                c11 = ':';
                                i10 = i17;
                                i11 = i16;
                                c12 = 180;
                            } else {
                                z10 = true;
                                C9841f c9841f16 = new C9841f();
                                C9841f c9841f17 = new C9841f();
                                if (cls3 == Date.class) {
                                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                    String str12 = f50176d;
                                    c9844i.mo61189i(182, str12, "getCurrent", "()C");
                                    c9844i.mo61191k(49);
                                    c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f16);
                                    c9844i.mo61182b(187, C11590b.m69190g(Date.class));
                                    c9844i.mo61185e(89);
                                    c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                    i12 = 16;
                                    c9844i.mo61187g(16, i15);
                                    c9844i.mo61189i(182, str12, "scanLong", "(C)J");
                                    c9844i.mo61189i(183, C11590b.m69190g(Date.class), "<init>", "(J)V");
                                    c11 = ':';
                                    c9844i.mo61187g(58, aVar.m63889m(c11592d));
                                    c9844i.mo61188h(BDLocation.TypeServerError, c9841f17);
                                } else {
                                    i12 = 16;
                                    c11 = ':';
                                }
                                c9844i.mo61192l(c9841f16);
                                m63870q(aVar, c9844i, 14);
                                i10 = i17;
                                i11 = i16;
                                c12 = 180;
                                m63858e(aVar, c9844i, c11592d, cls3, i10);
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                c9844i.mo61189i(182, f50176d, "token", "()I");
                                c9844i.mo61191k(15);
                                c9844i.mo61188h(159, c9841f17);
                                c9844i.mo61187g(25, 0);
                                c9844i.mo61187g(25, aVar.m63887k("lexer"));
                                if (z12) {
                                    c9844i.mo61191k(15);
                                } else {
                                    c9844i.mo61191k(Integer.valueOf(i12));
                                }
                                c9844i.mo61189i(183, C11590b.m69190g(cls), "check", "(" + C11590b.m69185b(InterfaceC10079c.class) + "I)V");
                                c9844i.mo61192l(c9841f17);
                            }
                        }
                    }
                    c11 = c13;
                    cls = cls2;
                    i11 = i16;
                    i10 = i17;
                    c10 = 184;
                    z10 = true;
                    c12 = 180;
                }
                cls = cls2;
                i11 = i16;
                i10 = i17;
                c10 = 184;
                c11 = ':';
                z10 = true;
                c12 = 180;
            }
            i14 = i10 + 1;
            length = i11;
            c11592dArr = c11592dArr2;
            cls2 = cls;
        }
        m63855b(aVar, c9844i, false);
        C9841f c9841f18 = new C9841f();
        C9841f c9841f19 = new C9841f();
        C9841f c9841f20 = new C9841f();
        C9841f c9841f21 = new C9841f();
        c9844i.mo61187g(25, aVar.m63887k("lexer"));
        String str13 = f50176d;
        c9844i.mo61189i(182, str13, "getCurrent", "()C");
        c9844i.mo61185e(89);
        c9844i.mo61187g(54, aVar.m63887k("ch"));
        c9844i.mo61187g(16, 44);
        c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f19);
        c9844i.mo61187g(25, aVar.m63887k("lexer"));
        c9844i.mo61189i(182, str13, "next", "()C");
        c9844i.mo61185e(87);
        c9844i.mo61187g(25, aVar.m63887k("lexer"));
        c9844i.mo61191k(16);
        c9844i.mo61189i(182, str13, "setToken", "(I)V");
        c9844i.mo61188h(BDLocation.TypeServerError, c9841f21);
        c9844i.mo61192l(c9841f19);
        c9844i.mo61187g(21, aVar.m63887k("ch"));
        c9844i.mo61187g(16, 93);
        c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f20);
        c9844i.mo61187g(25, aVar.m63887k("lexer"));
        c9844i.mo61189i(182, str13, "next", "()C");
        c9844i.mo61185e(87);
        c9844i.mo61187g(25, aVar.m63887k("lexer"));
        c9844i.mo61191k(15);
        c9844i.mo61189i(182, str13, "setToken", "(I)V");
        c9844i.mo61188h(BDLocation.TypeServerError, c9841f21);
        c9844i.mo61192l(c9841f20);
        c9844i.mo61187g(21, aVar.m63887k("ch"));
        c9844i.mo61187g(16, 26);
        c9844i.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f18);
        c9844i.mo61187g(25, aVar.m63887k("lexer"));
        c9844i.mo61189i(182, str13, "next", "()C");
        c9844i.mo61185e(87);
        c9844i.mo61187g(25, aVar.m63887k("lexer"));
        c9844i.mo61191k(20);
        c9844i.mo61189i(182, str13, "setToken", "(I)V");
        c9844i.mo61188h(BDLocation.TypeServerError, c9841f21);
        c9844i.mo61192l(c9841f18);
        c9844i.mo61187g(25, aVar.m63887k("lexer"));
        c9844i.mo61191k(16);
        c9844i.mo61189i(182, str13, "nextToken", "(I)V");
        c9844i.mo61192l(c9841f21);
        c9844i.mo61187g(25, aVar.m63887k("instance"));
        c9844i.mo61185e(176);
        c9844i.mo61186f(5, aVar.f50179a);
        c9844i.mo61190j();
    }

    /* renamed from: i */
    public final void m63862i(a aVar, InterfaceC9843h interfaceC9843h, C9841f c9841f, C11592d c11592d, Class<?> cls, Class<?> cls2, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        C9841f c9841f2;
        int i11;
        int i12;
        int i13;
        C9841f c9841f3 = new C9841f();
        String str5 = f50176d;
        interfaceC9843h.mo61189i(182, str5, "matchField", "([C)Z");
        interfaceC9843h.mo61188h(153, c9841f3);
        m63874u(interfaceC9843h, aVar, i10);
        C9841f c9841f4 = new C9841f();
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str5, "token", "()I");
        interfaceC9843h.mo61191k(8);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f4);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61191k(16);
        interfaceC9843h.mo61189i(182, str5, "nextToken", "(I)V");
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f3);
        interfaceC9843h.mo61192l(c9841f4);
        C9841f c9841f5 = new C9841f();
        C9841f c9841f6 = new C9841f();
        C9841f c9841f7 = new C9841f();
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str5, "token", "()I");
        interfaceC9843h.mo61191k(21);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f6);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61191k(14);
        interfaceC9843h.mo61189i(182, str5, "nextToken", "(I)V");
        m63869p(interfaceC9843h, cls, i10, true);
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f5);
        interfaceC9843h.mo61192l(c9841f6);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str5, "token", "()I");
        interfaceC9843h.mo61191k(14);
        interfaceC9843h.mo61188h(159, c9841f7);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str5, "token", "()I");
        interfaceC9843h.mo61191k(12);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f);
        m63869p(interfaceC9843h, cls, i10, false);
        interfaceC9843h.mo61187g(58, aVar.m63889m(c11592d));
        m63864k(aVar, interfaceC9843h, c11592d, cls2);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls2)));
        interfaceC9843h.mo61185e(3);
        interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String strM69190g = C11590b.m69190g(InterfaceC10408t.class);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(L");
        String str6 = f50175c;
        sb2.append(str6);
        sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        interfaceC9843h.mo61189i(185, strM69190g, "deserialze", sb2.toString());
        interfaceC9843h.mo61187g(58, aVar.m63887k("list_item_value"));
        interfaceC9843h.mo61187g(25, aVar.m63889m(c11592d));
        interfaceC9843h.mo61187g(25, aVar.m63887k("list_item_value"));
        if (cls.isInterface()) {
            str = "list_item_value";
            interfaceC9843h.mo61189i(185, C11590b.m69190g(cls), SyncProtocol.Constant.ADD, "(Ljava/lang/Object;)Z");
        } else {
            str = "list_item_value";
            interfaceC9843h.mo61189i(182, C11590b.m69190g(cls), SyncProtocol.Constant.ADD, "(Ljava/lang/Object;)Z");
        }
        interfaceC9843h.mo61185e(87);
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f3);
        interfaceC9843h.mo61192l(c9841f7);
        m63869p(interfaceC9843h, cls, i10, false);
        interfaceC9843h.mo61192l(c9841f5);
        interfaceC9843h.mo61187g(58, aVar.m63889m(c11592d));
        boolean zM62850w = C10085i.m62850w(c11592d.f53772e);
        m63864k(aVar, interfaceC9843h, c11592d, cls2);
        if (zM62850w) {
            interfaceC9843h.mo61189i(185, C11590b.m69190g(InterfaceC10408t.class), "getFastMatchToken", "()I");
            interfaceC9843h.mo61187g(54, aVar.m63887k("fastMatchToken"));
            interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
            interfaceC9843h.mo61187g(21, aVar.m63887k("fastMatchToken"));
            str2 = str5;
            str3 = "nextToken";
            str4 = "(I)V";
            interfaceC9843h.mo61189i(182, str2, str3, str4);
            c9841f2 = c9841f3;
        } else {
            str2 = str5;
            str3 = "nextToken";
            str4 = "(I)V";
            interfaceC9843h.mo61185e(87);
            interfaceC9843h.mo61191k(12);
            c9841f2 = c9841f3;
            interfaceC9843h.mo61187g(54, aVar.m63887k("fastMatchToken"));
            m63870q(aVar, interfaceC9843h, 12);
        }
        interfaceC9843h.mo61187g(25, 1);
        String str7 = str4;
        interfaceC9843h.mo61189i(182, str6, "getContext", "()" + C11590b.m69185b(C10084h.class));
        interfaceC9843h.mo61187g(58, aVar.m63887k("listContext"));
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, aVar.m63889m(c11592d));
        interfaceC9843h.mo61191k(c11592d.f53768a);
        interfaceC9843h.mo61189i(182, str6, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + C11590b.m69185b(C10084h.class));
        interfaceC9843h.mo61185e(87);
        C9841f c9841f8 = new C9841f();
        C9841f c9841f9 = new C9841f();
        interfaceC9843h.mo61185e(3);
        String str8 = str3;
        interfaceC9843h.mo61187g(54, aVar.m63887k("i"));
        interfaceC9843h.mo61192l(c9841f8);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str2, "token", "()I");
        interfaceC9843h.mo61191k(15);
        interfaceC9843h.mo61188h(159, c9841f9);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61183c(180, aVar.f50183e, c11592d.f53768a + "_asm_list_item_deser__", C11590b.m69185b(InterfaceC10408t.class));
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls2)));
        interfaceC9843h.mo61187g(21, aVar.m63887k("i"));
        interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        interfaceC9843h.mo61189i(185, C11590b.m69190g(InterfaceC10408t.class), "deserialze", "(L" + str6 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str9 = str;
        interfaceC9843h.mo61187g(58, aVar.m63887k(str9));
        interfaceC9843h.mo61181a(aVar.m63887k("i"), 1);
        interfaceC9843h.mo61187g(25, aVar.m63889m(c11592d));
        interfaceC9843h.mo61187g(25, aVar.m63887k(str9));
        if (cls.isInterface()) {
            interfaceC9843h.mo61189i(185, C11590b.m69190g(cls), SyncProtocol.Constant.ADD, "(Ljava/lang/Object;)Z");
            i12 = 87;
            i11 = 182;
        } else {
            i11 = 182;
            interfaceC9843h.mo61189i(182, C11590b.m69190g(cls), SyncProtocol.Constant.ADD, "(Ljava/lang/Object;)Z");
            i12 = 87;
        }
        interfaceC9843h.mo61185e(i12);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, aVar.m63889m(c11592d));
        interfaceC9843h.mo61189i(i11, str6, "checkListResolve", "(Ljava/util/Collection;)V");
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(i11, str2, "token", "()I");
        interfaceC9843h.mo61191k(16);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f8);
        if (zM62850w) {
            interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
            interfaceC9843h.mo61187g(21, aVar.m63887k("fastMatchToken"));
            interfaceC9843h.mo61189i(i11, str2, str8, str7);
            i13 = BDLocation.TypeServerError;
        } else {
            m63870q(aVar, interfaceC9843h, 12);
            i13 = BDLocation.TypeServerError;
        }
        interfaceC9843h.mo61188h(i13, c9841f8);
        interfaceC9843h.mo61192l(c9841f9);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, aVar.m63887k("listContext"));
        interfaceC9843h.mo61189i(182, str6, "setContext", "(" + C11590b.m69185b(C10084h.class) + ")V");
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str2, "token", "()I");
        interfaceC9843h.mo61191k(15);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f);
        m63871r(aVar, interfaceC9843h);
        interfaceC9843h.mo61192l(c9841f2);
    }

    /* renamed from: j */
    public final void m63863j(a aVar, InterfaceC9843h interfaceC9843h, C9841f c9841f, C11592d c11592d, Class<?> cls, int i10) {
        C9841f c9841f2 = new C9841f();
        C9841f c9841f3 = new C9841f();
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61183c(180, aVar.f50183e, aVar.m63884h(c11592d), "[C");
        interfaceC9843h.mo61189i(182, f50176d, "matchField", "([C)Z");
        interfaceC9843h.mo61188h(154, c9841f2);
        interfaceC9843h.mo61185e(1);
        interfaceC9843h.mo61187g(58, aVar.m63889m(c11592d));
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f3);
        interfaceC9843h.mo61192l(c9841f2);
        m63874u(interfaceC9843h, aVar, i10);
        interfaceC9843h.mo61187g(21, aVar.m63887k("matchedCount"));
        interfaceC9843h.mo61185e(4);
        interfaceC9843h.mo61185e(96);
        interfaceC9843h.mo61187g(54, aVar.m63887k("matchedCount"));
        m63858e(aVar, interfaceC9843h, c11592d, cls, i10);
        interfaceC9843h.mo61187g(25, 1);
        String str = f50175c;
        interfaceC9843h.mo61189i(182, str, "getResolveStatus", "()I");
        interfaceC9843h.mo61191k(1);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f3);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61189i(182, str, "getLastResolveTask", "()" + C11590b.m69185b(C10077a.a.class));
        interfaceC9843h.mo61187g(58, aVar.m63887k("resolveTask"));
        interfaceC9843h.mo61187g(25, aVar.m63887k("resolveTask"));
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61189i(182, str, "getContext", "()" + C11590b.m69185b(C10084h.class));
        interfaceC9843h.mo61183c(181, C11590b.m69190g(C10077a.a.class), "ownerContext", C11590b.m69185b(C10084h.class));
        interfaceC9843h.mo61187g(25, aVar.m63887k("resolveTask"));
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61191k(c11592d.f53768a);
        interfaceC9843h.mo61189i(182, C11590b.m69190g(C10403o.class), "getFieldDeserializer", "(Ljava/lang/String;)" + C11590b.m69185b(AbstractC10400l.class));
        interfaceC9843h.mo61183c(181, C11590b.m69190g(C10077a.a.class), "fieldDeserializer", C11590b.m69185b(AbstractC10400l.class));
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61191k(0);
        interfaceC9843h.mo61189i(182, str, "setResolveStatus", "(I)V");
        interfaceC9843h.mo61192l(c9841f3);
    }

    /* renamed from: k */
    public final void m63864k(a aVar, InterfaceC9843h interfaceC9843h, C11592d c11592d, Class<?> cls) {
        C9841f c9841f = new C9841f();
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61183c(180, aVar.f50183e, c11592d.f53768a + "_asm_list_item_deser__", C11590b.m69185b(InterfaceC10408t.class));
        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61189i(182, f50175c, C5963j.f27044m, "()" + C11590b.m69185b(C10085i.class));
        interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls)));
        interfaceC9843h.mo61189i(182, C11590b.m69190g(C10085i.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + C11590b.m69185b(InterfaceC10408t.class));
        interfaceC9843h.mo61183c(181, aVar.f50183e, c11592d.f53768a + "_asm_list_item_deser__", C11590b.m69185b(InterfaceC10408t.class));
        interfaceC9843h.mo61192l(c9841f);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61183c(180, aVar.f50183e, c11592d.f53768a + "_asm_list_item_deser__", C11590b.m69185b(InterfaceC10408t.class));
    }

    /* renamed from: l */
    public final void m63865l(a aVar, InterfaceC9843h interfaceC9843h, C11592d c11592d) {
        C9841f c9841f = new C9841f();
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61183c(180, aVar.f50183e, aVar.m63883g(c11592d), C11590b.m69185b(InterfaceC10408t.class));
        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61189i(182, f50175c, C5963j.f27044m, "()" + C11590b.m69185b(C10085i.class));
        interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(c11592d.f53772e)));
        interfaceC9843h.mo61189i(182, C11590b.m69190g(C10085i.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + C11590b.m69185b(InterfaceC10408t.class));
        interfaceC9843h.mo61183c(181, aVar.f50183e, aVar.m63883g(c11592d), C11590b.m69185b(InterfaceC10408t.class));
        interfaceC9843h.mo61192l(c9841f);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61183c(180, aVar.f50183e, aVar.m63883g(c11592d), C11590b.m69185b(InterfaceC10408t.class));
    }

    /* renamed from: m */
    public final void m63866m(C9838c c9838c, a aVar) {
        int length = aVar.f50184f.length;
        for (int i10 = 0; i10 < length; i10++) {
            new C9839d(c9838c, 1, aVar.m63884h(aVar.f50184f[i10]), "[C").m61172c();
        }
        int length2 = aVar.f50184f.length;
        for (int i11 = 0; i11 < length2; i11++) {
            C11592d c11592d = aVar.f50184f[i11];
            Class<?> cls = c11592d.f53772e;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new C9839d(c9838c, 1, c11592d.f53768a + "_asm_list_item_deser__", C11590b.m69185b(InterfaceC10408t.class)).m61172c();
                } else {
                    new C9839d(c9838c, 1, aVar.m63883g(c11592d), C11590b.m69185b(InterfaceC10408t.class)).m61172c();
                }
            }
        }
        C9844i c9844i = new C9844i(c9838c, 1, "<init>", "(" + C11590b.m69185b(C10085i.class) + C11590b.m69185b(C11597i.class) + ")V", null, null);
        c9844i.mo61187g(25, 0);
        c9844i.mo61187g(25, 1);
        c9844i.mo61187g(25, 2);
        c9844i.mo61189i(183, C11590b.m69190g(C10403o.class), "<init>", "(" + C11590b.m69185b(C10085i.class) + C11590b.m69185b(C11597i.class) + ")V");
        int length3 = aVar.f50184f.length;
        for (int i12 = 0; i12 < length3; i12++) {
            C11592d c11592d2 = aVar.f50184f[i12];
            c9844i.mo61187g(25, 0);
            c9844i.mo61191k("\"" + c11592d2.f53768a + "\":");
            c9844i.mo61189i(182, "java/lang/String", "toCharArray", "()[C");
            c9844i.mo61183c(181, aVar.f50183e, aVar.m63884h(c11592d2), "[C");
        }
        c9844i.mo61185e(177);
        c9844i.mo61186f(4, 4);
        c9844i.mo61190j();
    }

    /* renamed from: n */
    public final void m63867n(InterfaceC9843h interfaceC9843h, a aVar, int i10, C9841f c9841f) {
        interfaceC9843h.mo61187g(21, aVar.m63887k("_asm_flag_" + (i10 / 32)));
        interfaceC9843h.mo61191k(Integer.valueOf(1 << i10));
        interfaceC9843h.mo61185e(126);
        interfaceC9843h.mo61188h(153, c9841f);
    }

    /* renamed from: o */
    public final void m63868o(a aVar, InterfaceC9843h interfaceC9843h, C11592d c11592d) {
        Class<?> cls = c11592d.f53772e;
        Type type = c11592d.f53773f;
        if (cls == Boolean.TYPE) {
            interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
            interfaceC9843h.mo61187g(21, aVar.m63889m(c11592d));
            m63872s(aVar, interfaceC9843h, c11592d);
            return;
        }
        if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
            interfaceC9843h.mo61187g(21, aVar.m63889m(c11592d));
            m63872s(aVar, interfaceC9843h, c11592d);
            return;
        }
        if (cls == Long.TYPE) {
            interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
            interfaceC9843h.mo61187g(22, aVar.m63890n(c11592d, 2));
            if (c11592d.f53769b == null) {
                interfaceC9843h.mo61183c(181, C11590b.m69190g(c11592d.f53774g), c11592d.f53770c.getName(), C11590b.m69185b(c11592d.f53772e));
                return;
            }
            interfaceC9843h.mo61189i(182, C11590b.m69190g(aVar.m63885i()), c11592d.f53769b.getName(), C11590b.m69186c(c11592d.f53769b));
            if (c11592d.f53769b.getReturnType().equals(Void.TYPE)) {
                return;
            }
            interfaceC9843h.mo61185e(87);
            return;
        }
        if (cls == Float.TYPE) {
            interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
            interfaceC9843h.mo61187g(23, aVar.m63889m(c11592d));
            m63872s(aVar, interfaceC9843h, c11592d);
            return;
        }
        if (cls == Double.TYPE) {
            interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
            interfaceC9843h.mo61187g(24, aVar.m63890n(c11592d, 2));
            m63872s(aVar, interfaceC9843h, c11592d);
            return;
        }
        if (cls == String.class) {
            interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
            interfaceC9843h.mo61187g(25, aVar.m63889m(c11592d));
            m63872s(aVar, interfaceC9843h, c11592d);
            return;
        }
        if (cls.isEnum()) {
            interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
            interfaceC9843h.mo61187g(25, aVar.m63889m(c11592d));
            m63872s(aVar, interfaceC9843h, c11592d);
        } else if (!Collection.class.isAssignableFrom(cls)) {
            interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
            interfaceC9843h.mo61187g(25, aVar.m63889m(c11592d));
            m63872s(aVar, interfaceC9843h, c11592d);
        } else {
            interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
            if (C11603o.m69273R(type) == String.class) {
                interfaceC9843h.mo61187g(25, aVar.m63889m(c11592d));
                interfaceC9843h.mo61182b(192, C11590b.m69190g(cls));
            } else {
                interfaceC9843h.mo61187g(25, aVar.m63889m(c11592d));
            }
            m63872s(aVar, interfaceC9843h, c11592d);
        }
    }

    /* renamed from: p */
    public final void m63869p(InterfaceC9843h interfaceC9843h, Class<?> cls, int i10, boolean z10) {
        if (cls.isAssignableFrom(ArrayList.class) && !z10) {
            interfaceC9843h.mo61182b(187, "java/util/ArrayList");
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61189i(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z10) {
            interfaceC9843h.mo61182b(187, C11590b.m69190g(LinkedList.class));
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61189i(183, C11590b.m69190g(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            interfaceC9843h.mo61182b(187, C11590b.m69190g(HashSet.class));
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61189i(183, C11590b.m69190g(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            interfaceC9843h.mo61182b(187, C11590b.m69190g(TreeSet.class));
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61189i(183, C11590b.m69190g(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            interfaceC9843h.mo61182b(187, C11590b.m69190g(LinkedHashSet.class));
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61189i(183, C11590b.m69190g(LinkedHashSet.class), "<init>", "()V");
        } else if (z10) {
            interfaceC9843h.mo61182b(187, C11590b.m69190g(HashSet.class));
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61189i(183, C11590b.m69190g(HashSet.class), "<init>", "()V");
        } else {
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61191k(Integer.valueOf(i10));
            interfaceC9843h.mo61189i(182, C11590b.m69190g(C10403o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            interfaceC9843h.mo61189i(184, C11590b.m69190g(C11603o.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        interfaceC9843h.mo61182b(192, C11590b.m69190g(cls));
    }

    /* renamed from: q */
    public final void m63870q(a aVar, InterfaceC9843h interfaceC9843h, int i10) {
        C9841f c9841f = new C9841f();
        C9841f c9841f2 = new C9841f();
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        String str = f50176d;
        interfaceC9843h.mo61189i(182, str, "getCurrent", "()C");
        if (i10 == 12) {
            interfaceC9843h.mo61187g(16, 123);
        } else {
            if (i10 != 14) {
                throw new IllegalStateException();
            }
            interfaceC9843h.mo61187g(16, 91);
        }
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str, "next", "()C");
        interfaceC9843h.mo61185e(87);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61191k(Integer.valueOf(i10));
        interfaceC9843h.mo61189i(182, str, "setToken", "(I)V");
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f2);
        interfaceC9843h.mo61192l(c9841f);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61191k(Integer.valueOf(i10));
        interfaceC9843h.mo61189i(182, str, "nextToken", "(I)V");
        interfaceC9843h.mo61192l(c9841f2);
    }

    /* renamed from: r */
    public final void m63871r(a aVar, InterfaceC9843h interfaceC9843h) {
        C9841f c9841f = new C9841f();
        C9841f c9841f2 = new C9841f();
        C9841f c9841f3 = new C9841f();
        C9841f c9841f4 = new C9841f();
        C9841f c9841f5 = new C9841f();
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        String str = f50176d;
        interfaceC9843h.mo61189i(182, str, "getCurrent", "()C");
        interfaceC9843h.mo61185e(89);
        interfaceC9843h.mo61187g(54, aVar.m63887k("ch"));
        interfaceC9843h.mo61187g(16, 44);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f2);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str, "next", "()C");
        interfaceC9843h.mo61185e(87);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61191k(16);
        interfaceC9843h.mo61189i(182, str, "setToken", "(I)V");
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f5);
        interfaceC9843h.mo61192l(c9841f2);
        interfaceC9843h.mo61187g(21, aVar.m63887k("ch"));
        interfaceC9843h.mo61187g(16, 125);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f3);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str, "next", "()C");
        interfaceC9843h.mo61185e(87);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61191k(13);
        interfaceC9843h.mo61189i(182, str, "setToken", "(I)V");
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f5);
        interfaceC9843h.mo61192l(c9841f3);
        interfaceC9843h.mo61187g(21, aVar.m63887k("ch"));
        interfaceC9843h.mo61187g(16, 93);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f4);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str, "next", "()C");
        interfaceC9843h.mo61185e(87);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61191k(15);
        interfaceC9843h.mo61189i(182, str, "setToken", "(I)V");
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f5);
        interfaceC9843h.mo61192l(c9841f4);
        interfaceC9843h.mo61187g(21, aVar.m63887k("ch"));
        interfaceC9843h.mo61187g(16, 26);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61191k(20);
        interfaceC9843h.mo61189i(182, str, "setToken", "(I)V");
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f5);
        interfaceC9843h.mo61192l(c9841f);
        interfaceC9843h.mo61187g(25, aVar.m63887k("lexer"));
        interfaceC9843h.mo61189i(182, str, "nextToken", "()V");
        interfaceC9843h.mo61192l(c9841f5);
    }

    /* renamed from: s */
    public final void m63872s(a aVar, InterfaceC9843h interfaceC9843h, C11592d c11592d) {
        Method method = c11592d.f53769b;
        if (method == null) {
            interfaceC9843h.mo61183c(181, C11590b.m69190g(c11592d.f53774g), c11592d.f53770c.getName(), C11590b.m69185b(c11592d.f53772e));
            return;
        }
        interfaceC9843h.mo61189i(method.getDeclaringClass().isInterface() ? 185 : 182, C11590b.m69190g(c11592d.f53774g), method.getName(), C11590b.m69186c(method));
        if (c11592d.f53769b.getReturnType().equals(Void.TYPE)) {
            return;
        }
        interfaceC9843h.mo61185e(87);
    }

    /* renamed from: t */
    public final void m63873t(a aVar, InterfaceC9843h interfaceC9843h) {
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, aVar.m63887k(ParamConstants.Param.CONTEXT));
        interfaceC9843h.mo61189i(182, f50175c, "setContext", "(" + C11590b.m69185b(C10084h.class) + ")V");
        C9841f c9841f = new C9841f();
        interfaceC9843h.mo61187g(25, aVar.m63887k("childContext"));
        interfaceC9843h.mo61188h(198, c9841f);
        interfaceC9843h.mo61187g(25, aVar.m63887k("childContext"));
        interfaceC9843h.mo61187g(25, aVar.m63887k("instance"));
        interfaceC9843h.mo61183c(181, C11590b.m69190g(C10084h.class), "object", "Ljava/lang/Object;");
        interfaceC9843h.mo61192l(c9841f);
    }

    /* renamed from: u */
    public final void m63874u(InterfaceC9843h interfaceC9843h, a aVar, int i10) {
        String str = "_asm_flag_" + (i10 / 32);
        interfaceC9843h.mo61187g(21, aVar.m63887k(str));
        interfaceC9843h.mo61191k(Integer.valueOf(1 << i10));
        interfaceC9843h.mo61185e(128);
        interfaceC9843h.mo61187g(54, aVar.m63887k(str));
    }

    /* renamed from: v */
    public InterfaceC10408t m63875v(C10085i c10085i, C11597i c11597i) throws Exception {
        String str;
        Class<?> cls = c11597i.f53814a;
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("not support type :" + cls.getName());
        }
        String str2 = "FastjsonASMDeserializer_" + this.f50178b.incrementAndGet() + "_" + cls.getSimpleName();
        Package r12 = C10386a.class.getPackage();
        if (r12 != null) {
            String name = r12.getName();
            String str3 = name.replace('.', C5929g4.f26852n) + "/" + str2;
            str = name + "." + str2;
            str2 = str3;
        } else {
            str = str2;
        }
        C9838c c9838c = new C9838c();
        c9838c.m61169k(49, 33, str2, C11590b.m69190g(C10403o.class), null);
        m63866m(c9838c, new a(str2, c10085i, c11597i, 3));
        m63856c(c9838c, new a(str2, c10085i, c11597i, 3));
        m63860g(c9838c, new a(str2, c10085i, c11597i, 5));
        m63861h(c9838c, new a(str2, c10085i, c11597i, 4));
        byte[] bArrM61168j = c9838c.m61168j();
        return (InterfaceC10408t) this.f50177a.m69182a(str, bArrM61168j, 0, bArrM61168j.length).getConstructor(C10085i.class, C11597i.class).newInstance(c10085i, c11597i);
    }

    /* renamed from: w */
    public final void m63876w(a aVar, InterfaceC9843h interfaceC9843h) {
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61183c(180, f50175c, "lexer", C11590b.m69185b(InterfaceC10079c.class));
        interfaceC9843h.mo61182b(192, f50176d);
        interfaceC9843h.mo61187g(58, aVar.m63887k("lexer"));
    }
}
