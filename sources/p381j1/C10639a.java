package p381j1;

import com.baidu.location.BDLocation;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.openalliance.p169ad.constant.CreativeType;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import p244e1.C9380d;
import p274f1.InterfaceC9643d;
import p305g1.C9838c;
import p305g1.C9839d;
import p305g1.C9841f;
import p305g1.C9844i;
import p305g1.C9845j;
import p305g1.InterfaceC9843h;
import p323h1.C10085i;
import p481n1.C11589a;
import p481n1.C11590b;
import p481n1.C11592d;
import p481n1.C11603o;

/* renamed from: j1.a */
/* loaded from: classes.dex */
public class C10639a {

    /* renamed from: c */
    public static final String f51113c = C11590b.m69190g(C10664i0.class);

    /* renamed from: d */
    public static final String f51114d;

    /* renamed from: e */
    public static final String f51115e;

    /* renamed from: f */
    public static final String f51116f;

    /* renamed from: g */
    public static final String f51117g;

    /* renamed from: h */
    public static final String f51118h;

    /* renamed from: i */
    public static final String f51119i;

    /* renamed from: j */
    public static final String f51120j;

    /* renamed from: k */
    public static final String f51121k;

    /* renamed from: a */
    public final C11589a f51122a = new C11589a();

    /* renamed from: b */
    public final AtomicLong f51123b = new AtomicLong();

    /* renamed from: j1.a$a */
    public static class a {

        /* renamed from: h */
        public static int f51124h = 6;

        /* renamed from: i */
        public static int f51125i = 7;

        /* renamed from: j */
        public static int f51126j = 8;

        /* renamed from: a */
        public final C11592d[] f51127a;

        /* renamed from: b */
        public final String f51128b;

        /* renamed from: c */
        public final C10698z0 f51129c;

        /* renamed from: d */
        public final boolean f51130d;

        /* renamed from: e */
        public Map<String, Integer> f51131e = new HashMap();

        /* renamed from: f */
        public int f51132f = 9;

        /* renamed from: g */
        public final boolean f51133g;

        public a(C11592d[] c11592dArr, C10698z0 c10698z0, String str, boolean z10, boolean z11) {
            this.f51127a = c11592dArr;
            this.f51128b = str;
            this.f51129c = c10698z0;
            this.f51130d = z10;
            this.f51133g = z11 || c10698z0.f51337a.isEnum();
        }

        /* renamed from: f */
        public int m65172f(String str) {
            int length = this.f51127a.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (this.f51127a[i10].f53768a.equals(str)) {
                    return i10;
                }
            }
            return -1;
        }

        /* renamed from: g */
        public int m65173g(String str) {
            if (this.f51131e.get(str) == null) {
                Map<String, Integer> map = this.f51131e;
                int i10 = this.f51132f;
                this.f51132f = i10 + 1;
                map.put(str, Integer.valueOf(i10));
            }
            return this.f51131e.get(str).intValue();
        }

        /* renamed from: h */
        public int m65174h(String str, int i10) {
            if (this.f51131e.get(str) == null) {
                this.f51131e.put(str, Integer.valueOf(this.f51132f));
                this.f51132f += i10;
            }
            return this.f51131e.get(str).intValue();
        }
    }

    static {
        String strM69190g = C11590b.m69190g(InterfaceC10686t0.class);
        f51114d = strM69190g;
        f51115e = "L" + strM69190g + ";";
        String strM69190g2 = C11590b.m69190g(C10650d1.class);
        f51116f = strM69190g2;
        f51117g = "L" + strM69190g2 + ";";
        f51118h = C11590b.m69190g(C10666j0.class);
        f51119i = "L" + C11590b.m69190g(C10666j0.class) + ";";
        f51120j = C11590b.m69185b(C10696y0.class);
        f51121k = C11590b.m69185b(AbstractC10647c1.class);
    }

    /* renamed from: A */
    public final void m65139A(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d[] c11592dArr, a aVar) throws Exception {
        String str;
        int i10;
        int i11;
        String str2;
        String str3;
        char c10;
        boolean z10;
        C10639a c10639a;
        char c11;
        String str4;
        int i12;
        Class<?> cls2;
        int i13;
        C9841f c9841f;
        C9841f c9841f2;
        C9841f c9841f3;
        String str5;
        C9841f c9841f4;
        int i14;
        int i15;
        String str6;
        int i16;
        C9841f c9841f5;
        C9841f c9841f6;
        char c12;
        C10639a c10639a2 = this;
        C11592d[] c11592dArr2 = c11592dArr;
        C9841f c9841f7 = new C9841f();
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, 0);
        String str7 = f51113c;
        interfaceC9843h.mo61189i(182, str7, "hasPropertyFilters", "(" + f51121k + ")Z");
        interfaceC9843h.mo61188h(154, c9841f7);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, 2);
        interfaceC9843h.mo61187g(25, 3);
        interfaceC9843h.mo61187g(25, 4);
        interfaceC9843h.mo61187g(21, 5);
        String str8 = f51118h;
        StringBuilder sb2 = new StringBuilder();
        String str9 = "(L";
        sb2.append("(L");
        sb2.append(str7);
        String str10 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
        sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        interfaceC9843h.mo61189i(183, str8, "writeNoneASM", sb2.toString());
        interfaceC9843h.mo61185e(177);
        interfaceC9843h.mo61192l(c9841f7);
        String str11 = "out";
        interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
        interfaceC9843h.mo61187g(16, 91);
        String str12 = f51116f;
        String str13 = "(I)V";
        interfaceC9843h.mo61189i(182, str12, "write", "(I)V");
        int length = c11592dArr2.length;
        if (length == 0) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(16, 93);
            interfaceC9843h.mo61189i(182, str12, "write", "(I)V");
            return;
        }
        int i17 = 0;
        while (i17 < length) {
            int i18 = i17 == length + (-1) ? 93 : 44;
            C11592d c11592d = c11592dArr2[i17];
            Class<?> cls3 = c11592d.f53772e;
            interfaceC9843h.mo61191k(c11592d.f53768a);
            interfaceC9843h.mo61187g(58, a.f51124h);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str = str11;
                i10 = length;
                i11 = i17;
                str2 = str9;
                str3 = str13;
                c10 = 25;
                z10 = false;
                interfaceC9843h.mo61187g(25, aVar.m65173g(str));
                interfaceC9843h.mo61185e(89);
                c10639a = this;
                c10639a.m65149i(interfaceC9843h, aVar, c11592d);
                String str14 = f51116f;
                interfaceC9843h.mo61189i(182, str14, "writeInt", str3);
                c11 = 16;
                interfaceC9843h.mo61187g(16, i18);
                interfaceC9843h.mo61189i(182, str14, "write", str3);
            } else {
                if (cls3 == Long.TYPE) {
                    interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                    interfaceC9843h.mo61185e(89);
                    c10639a2.m65149i(interfaceC9843h, aVar, c11592d);
                    String str15 = f51116f;
                    c12 = 182;
                    interfaceC9843h.mo61189i(182, str15, "writeLong", "(J)V");
                    interfaceC9843h.mo61187g(16, i18);
                    interfaceC9843h.mo61189i(182, str15, "write", str13);
                } else if (cls3 == Float.TYPE) {
                    interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                    interfaceC9843h.mo61185e(89);
                    c10639a2.m65149i(interfaceC9843h, aVar, c11592d);
                    interfaceC9843h.mo61185e(4);
                    String str16 = f51116f;
                    c12 = 182;
                    interfaceC9843h.mo61189i(182, str16, "writeFloat", "(FZ)V");
                    interfaceC9843h.mo61187g(16, i18);
                    interfaceC9843h.mo61189i(182, str16, "write", str13);
                } else if (cls3 == Double.TYPE) {
                    interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                    interfaceC9843h.mo61185e(89);
                    c10639a2.m65149i(interfaceC9843h, aVar, c11592d);
                    interfaceC9843h.mo61185e(4);
                    String str17 = f51116f;
                    c12 = 182;
                    interfaceC9843h.mo61189i(182, str17, "writeDouble", "(DZ)V");
                    interfaceC9843h.mo61187g(16, i18);
                    interfaceC9843h.mo61189i(182, str17, "write", str13);
                } else {
                    if (cls3 == Boolean.TYPE) {
                        interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                        interfaceC9843h.mo61185e(89);
                        c10639a2.m65149i(interfaceC9843h, aVar, c11592d);
                        String str18 = f51116f;
                        interfaceC9843h.mo61189i(182, str18, "write", "(Z)V");
                        interfaceC9843h.mo61187g(16, i18);
                        interfaceC9843h.mo61189i(182, str18, "write", str13);
                    } else if (cls3 == Character.TYPE) {
                        interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                        c10639a2.m65149i(interfaceC9843h, aVar, c11592d);
                        interfaceC9843h.mo61189i(184, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                        interfaceC9843h.mo61187g(16, i18);
                        interfaceC9843h.mo61189i(182, f51116f, "writeString", "(Ljava/lang/String;C)V");
                        i10 = length;
                        i11 = i17;
                        str2 = str9;
                        str3 = str13;
                        z10 = false;
                        c11 = 16;
                        c10639a = c10639a2;
                        str = str11;
                        c10 = 25;
                    } else if (cls3 == String.class) {
                        interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                        c10639a2.m65149i(interfaceC9843h, aVar, c11592d);
                        interfaceC9843h.mo61187g(16, i18);
                        interfaceC9843h.mo61189i(182, f51116f, "writeString", "(Ljava/lang/String;C)V");
                        i10 = length;
                        i11 = i17;
                        str2 = str9;
                        str3 = str13;
                        z10 = false;
                        c11 = 16;
                        c10639a = c10639a2;
                        str = str11;
                        c10 = 25;
                    } else if (cls3.isEnum()) {
                        interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                        interfaceC9843h.mo61185e(89);
                        c10639a2.m65149i(interfaceC9843h, aVar, c11592d);
                        String str19 = f51116f;
                        interfaceC9843h.mo61189i(182, str19, "writeEnum", "(Ljava/lang/Enum;)V");
                        interfaceC9843h.mo61187g(16, i18);
                        interfaceC9843h.mo61189i(182, str19, "write", str13);
                    } else if (List.class.isAssignableFrom(cls3)) {
                        Type type = c11592d.f53773f;
                        Type type2 = type instanceof Class ? Object.class : ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (!(type2 instanceof Class) || (cls2 = (Class) type2) == Object.class) {
                            cls2 = null;
                        }
                        c10639a2.m65149i(interfaceC9843h, aVar, c11592d);
                        i10 = length;
                        interfaceC9843h.mo61182b(192, "java/util/List");
                        i11 = i17;
                        interfaceC9843h.mo61187g(58, aVar.m65173g("list"));
                        if (cls2 == String.class && aVar.f51130d) {
                            interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
                            interfaceC9843h.mo61189i(182, f51116f, "write", "(Ljava/util/List;)V");
                            str = str11;
                            i16 = 182;
                            i13 = i18;
                            str2 = str9;
                            str6 = str13;
                            i14 = 25;
                            i15 = 16;
                        } else {
                            C9841f c9841f8 = new C9841f();
                            C9841f c9841f9 = new C9841f();
                            i13 = i18;
                            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
                            interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f9);
                            interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                            String str20 = f51116f;
                            Type type3 = type2;
                            String str21 = str10;
                            interfaceC9843h.mo61189i(182, str20, "writeNull", "()V");
                            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f8);
                            interfaceC9843h.mo61192l(c9841f9);
                            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
                            interfaceC9843h.mo61189i(185, "java/util/List", "size", "()I");
                            interfaceC9843h.mo61187g(54, aVar.m65173g("size"));
                            interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                            interfaceC9843h.mo61187g(16, 91);
                            interfaceC9843h.mo61189i(182, str20, "write", str13);
                            C9841f c9841f10 = new C9841f();
                            C9841f c9841f11 = new C9841f();
                            C9841f c9841f12 = new C9841f();
                            interfaceC9843h.mo61185e(3);
                            String str22 = str9;
                            interfaceC9843h.mo61187g(54, aVar.m65173g("i"));
                            interfaceC9843h.mo61192l(c9841f10);
                            interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
                            interfaceC9843h.mo61187g(21, aVar.m65173g("size"));
                            interfaceC9843h.mo61188h(162, c9841f12);
                            interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
                            interfaceC9843h.mo61188h(153, c9841f11);
                            interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                            interfaceC9843h.mo61187g(16, 44);
                            interfaceC9843h.mo61189i(182, str20, "write", str13);
                            interfaceC9843h.mo61192l(c9841f11);
                            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
                            interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
                            interfaceC9843h.mo61189i(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
                            interfaceC9843h.mo61187g(58, aVar.m65173g("list_item"));
                            C9841f c9841f13 = new C9841f();
                            C9841f c9841f14 = new C9841f();
                            String str23 = str13;
                            interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
                            interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f14);
                            interfaceC9843h.mo61187g(25, aVar.m65173g(str11));
                            String str24 = str11;
                            interfaceC9843h.mo61189i(182, str20, "writeNull", "()V");
                            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f13);
                            interfaceC9843h.mo61192l(c9841f14);
                            C9841f c9841f15 = new C9841f();
                            C9841f c9841f16 = new C9841f();
                            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                c9841f = c9841f10;
                                c9841f2 = c9841f13;
                                c9841f3 = c9841f12;
                                str5 = str20;
                                str10 = str21;
                                str2 = str22;
                                c9841f4 = c9841f16;
                            } else {
                                interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
                                str5 = str20;
                                c9841f3 = c9841f12;
                                interfaceC9843h.mo61189i(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                                interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls2)));
                                interfaceC9843h.mo61188h(166, c9841f16);
                                c10639a2.m65151k(aVar, interfaceC9843h, c11592d, cls2);
                                interfaceC9843h.mo61187g(58, aVar.m65173g("list_item_desc"));
                                C9841f c9841f17 = new C9841f();
                                C9841f c9841f18 = new C9841f();
                                if (aVar.f51130d) {
                                    interfaceC9843h.mo61187g(25, aVar.m65173g("list_item_desc"));
                                    String str25 = f51118h;
                                    interfaceC9843h.mo61182b(193, str25);
                                    interfaceC9843h.mo61188h(153, c9841f17);
                                    c9841f = c9841f10;
                                    interfaceC9843h.mo61187g(25, aVar.m65173g("list_item_desc"));
                                    interfaceC9843h.mo61182b(192, str25);
                                    interfaceC9843h.mo61187g(25, 1);
                                    interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
                                    if (aVar.f51133g) {
                                        interfaceC9843h.mo61185e(1);
                                        c9841f2 = c9841f13;
                                        c9841f5 = c9841f16;
                                    } else {
                                        interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
                                        c9841f2 = c9841f13;
                                        c9841f5 = c9841f16;
                                        interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    }
                                    interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls2)));
                                    interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
                                    StringBuilder sb3 = new StringBuilder();
                                    str2 = str22;
                                    sb3.append(str2);
                                    sb3.append(f51113c);
                                    str10 = str21;
                                    sb3.append(str10);
                                    c9841f6 = c9841f15;
                                    interfaceC9843h.mo61189i(182, str25, "writeAsArrayNonContext", sb3.toString());
                                    interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f18);
                                    interfaceC9843h.mo61192l(c9841f17);
                                } else {
                                    c9841f = c9841f10;
                                    c9841f2 = c9841f13;
                                    c9841f5 = c9841f16;
                                    str10 = str21;
                                    str2 = str22;
                                    c9841f6 = c9841f15;
                                }
                                interfaceC9843h.mo61187g(25, aVar.m65173g("list_item_desc"));
                                interfaceC9843h.mo61187g(25, 1);
                                interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
                                if (aVar.f51133g) {
                                    interfaceC9843h.mo61185e(1);
                                } else {
                                    interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
                                    interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls2)));
                                interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
                                interfaceC9843h.mo61189i(185, f51114d, "write", str2 + f51113c + str10);
                                interfaceC9843h.mo61192l(c9841f18);
                                c9841f15 = c9841f6;
                                interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f15);
                                c9841f4 = c9841f5;
                            }
                            interfaceC9843h.mo61192l(c9841f4);
                            interfaceC9843h.mo61187g(25, 1);
                            interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
                            if (aVar.f51133g) {
                                interfaceC9843h.mo61185e(1);
                            } else {
                                interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
                                interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            }
                            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                interfaceC9843h.mo61189i(182, f51113c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            } else {
                                interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b((Class) type3)));
                                interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
                                interfaceC9843h.mo61189i(182, f51113c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            }
                            interfaceC9843h.mo61192l(c9841f15);
                            interfaceC9843h.mo61192l(c9841f2);
                            interfaceC9843h.mo61181a(aVar.m65173g("i"), 1);
                            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f);
                            interfaceC9843h.mo61192l(c9841f3);
                            str = str24;
                            i14 = 25;
                            interfaceC9843h.mo61187g(25, aVar.m65173g(str));
                            i15 = 16;
                            interfaceC9843h.mo61187g(16, 93);
                            str6 = str23;
                            i16 = 182;
                            interfaceC9843h.mo61189i(182, str5, "write", str6);
                            interfaceC9843h.mo61192l(c9841f8);
                        }
                        interfaceC9843h.mo61187g(i14, aVar.m65173g(str));
                        interfaceC9843h.mo61187g(i15, i13);
                        interfaceC9843h.mo61189i(i16, f51116f, "write", str6);
                        c10639a = this;
                        str3 = str6;
                        c10 = 25;
                        z10 = false;
                        c11 = 16;
                    } else {
                        String str26 = str11;
                        i10 = length;
                        i11 = i17;
                        str2 = str9;
                        String str27 = str13;
                        C9841f c9841f19 = new C9841f();
                        C9841f c9841f20 = new C9841f();
                        m65149i(interfaceC9843h, aVar, c11592d);
                        interfaceC9843h.mo61185e(89);
                        interfaceC9843h.mo61187g(58, aVar.m65173g("field_" + c11592d.f53772e.getName()));
                        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f20);
                        interfaceC9843h.mo61187g(25, aVar.m65173g(str26));
                        String str28 = f51116f;
                        int i19 = i18;
                        interfaceC9843h.mo61189i(182, str28, "writeNull", "()V");
                        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f19);
                        interfaceC9843h.mo61192l(c9841f20);
                        C9841f c9841f21 = new C9841f();
                        C9841f c9841f22 = new C9841f();
                        interfaceC9843h.mo61187g(25, aVar.m65173g("field_" + c11592d.f53772e.getName()));
                        interfaceC9843h.mo61189i(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                        interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls3)));
                        interfaceC9843h.mo61188h(166, c9841f22);
                        m65150j(aVar, interfaceC9843h, c11592d);
                        interfaceC9843h.mo61187g(58, aVar.m65173g("fied_ser"));
                        C9841f c9841f23 = new C9841f();
                        C9841f c9841f24 = new C9841f();
                        if (aVar.f51130d && Modifier.isPublic(cls3.getModifiers())) {
                            interfaceC9843h.mo61187g(25, aVar.m65173g("fied_ser"));
                            String str29 = f51118h;
                            interfaceC9843h.mo61182b(193, str29);
                            interfaceC9843h.mo61188h(153, c9841f23);
                            interfaceC9843h.mo61187g(25, aVar.m65173g("fied_ser"));
                            interfaceC9843h.mo61182b(192, str29);
                            interfaceC9843h.mo61187g(25, 1);
                            interfaceC9843h.mo61187g(25, aVar.m65173g("field_" + c11592d.f53772e.getName()));
                            interfaceC9843h.mo61187g(25, a.f51124h);
                            interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls3)));
                            interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
                            str4 = "writeWithFieldName";
                            interfaceC9843h.mo61189i(182, str29, "writeAsArrayNonContext", str2 + f51113c + str10);
                            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f24);
                            interfaceC9843h.mo61192l(c9841f23);
                        } else {
                            str4 = "writeWithFieldName";
                        }
                        interfaceC9843h.mo61187g(25, aVar.m65173g("fied_ser"));
                        interfaceC9843h.mo61187g(25, 1);
                        interfaceC9843h.mo61187g(25, aVar.m65173g("field_" + c11592d.f53772e.getName()));
                        interfaceC9843h.mo61187g(25, a.f51124h);
                        interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls3)));
                        interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
                        String str30 = f51114d;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str2);
                        String str31 = f51113c;
                        sb4.append(str31);
                        sb4.append(str10);
                        interfaceC9843h.mo61189i(185, str30, "write", sb4.toString());
                        interfaceC9843h.mo61192l(c9841f24);
                        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f21);
                        interfaceC9843h.mo61192l(c9841f22);
                        String strM69201r = c11592d.m69201r();
                        interfaceC9843h.mo61187g(25, 1);
                        interfaceC9843h.mo61187g(25, aVar.m65173g("field_" + c11592d.f53772e.getName()));
                        if (strM69201r != null) {
                            interfaceC9843h.mo61191k(strM69201r);
                            i12 = 182;
                            interfaceC9843h.mo61189i(182, str31, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                        } else {
                            i12 = 182;
                            interfaceC9843h.mo61187g(25, a.f51124h);
                            Type type4 = c11592d.f53773f;
                            if ((type4 instanceof Class) && ((Class) type4).isPrimitive()) {
                                interfaceC9843h.mo61189i(182, str31, str4, "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            } else {
                                z10 = false;
                                interfaceC9843h.mo61187g(25, 0);
                                interfaceC9843h.mo61183c(180, aVar.f51128b, c11592d.f53768a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                                interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
                                i12 = 182;
                                interfaceC9843h.mo61189i(182, str31, str4, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                                interfaceC9843h.mo61192l(c9841f21);
                                interfaceC9843h.mo61192l(c9841f19);
                                str = str26;
                                c10 = 25;
                                interfaceC9843h.mo61187g(25, aVar.m65173g(str));
                                interfaceC9843h.mo61187g(16, i19);
                                str3 = str27;
                                interfaceC9843h.mo61189i(i12, str28, "write", str3);
                                c10639a = this;
                                c11 = 16;
                            }
                        }
                        z10 = false;
                        interfaceC9843h.mo61192l(c9841f21);
                        interfaceC9843h.mo61192l(c9841f19);
                        str = str26;
                        c10 = 25;
                        interfaceC9843h.mo61187g(25, aVar.m65173g(str));
                        interfaceC9843h.mo61187g(16, i19);
                        str3 = str27;
                        interfaceC9843h.mo61189i(i12, str28, "write", str3);
                        c10639a = this;
                        c11 = 16;
                    }
                    c10639a = c10639a2;
                    str = str11;
                    i10 = length;
                    i11 = i17;
                    str2 = str9;
                    str3 = str13;
                    c10 = 25;
                    z10 = false;
                    c11 = 16;
                }
                i10 = length;
                i11 = i17;
                str2 = str9;
                str3 = str13;
                z10 = false;
                c11 = 16;
                c10639a = c10639a2;
                str = str11;
                c10 = 25;
            }
            str13 = str3;
            i17 = i11 + 1;
            c11592dArr2 = c11592dArr;
            length = i10;
            str11 = str;
            c10639a2 = c10639a;
            str9 = str2;
        }
    }

    /* renamed from: B */
    public final void m65140B(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d[] c11592dArr, a aVar) throws Exception {
        C9841f c9841f;
        String str;
        int i10;
        int i11;
        String str2;
        Class<?> cls2;
        C11592d[] c11592dArr2 = c11592dArr;
        C9841f c9841f2 = new C9841f();
        int length = c11592dArr2.length;
        String str3 = "out";
        if (aVar.f51130d) {
            c9841f = c9841f2;
        } else {
            C9841f c9841f3 = new C9841f();
            C9841f c9841f4 = new C9841f();
            c9841f = c9841f2;
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61191k(Integer.valueOf(EnumC10653e1.PrettyFormat.f51248a));
            interfaceC9843h.mo61189i(182, f51116f, "isEnabled", "(I)Z");
            interfaceC9843h.mo61188h(154, c9841f4);
            int length2 = c11592dArr2.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length2) {
                    interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f3);
                    break;
                }
                int i13 = length2;
                if (c11592dArr2[i12].f53769b != null) {
                    interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
                    interfaceC9843h.mo61191k(Integer.valueOf(EnumC10653e1.IgnoreErrorGetter.f51248a));
                    interfaceC9843h.mo61189i(182, f51116f, "isEnabled", "(I)Z");
                    interfaceC9843h.mo61188h(153, c9841f3);
                    break;
                }
                i12++;
                length2 = i13;
            }
            interfaceC9843h.mo61192l(c9841f4);
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, 2);
            interfaceC9843h.mo61187g(25, 3);
            interfaceC9843h.mo61187g(25, 4);
            interfaceC9843h.mo61187g(21, 5);
            interfaceC9843h.mo61189i(183, f51118h, "write", "(L" + f51113c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            interfaceC9843h.mo61185e(177);
            interfaceC9843h.mo61192l(c9841f3);
        }
        if (!aVar.f51133g) {
            C9841f c9841f5 = new C9841f();
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, 2);
            interfaceC9843h.mo61187g(21, 5);
            interfaceC9843h.mo61189i(182, f51118h, "writeReference", "(L" + f51113c + ";Ljava/lang/Object;I)Z");
            interfaceC9843h.mo61188h(153, c9841f5);
            interfaceC9843h.mo61185e(177);
            interfaceC9843h.mo61192l(c9841f5);
        }
        String str4 = aVar.f51130d ? aVar.f51133g ? "writeAsArrayNonContext" : "writeAsArray" : "writeAsArrayNormal";
        int i14 = aVar.f51129c.f51343g;
        EnumC10653e1 enumC10653e1 = EnumC10653e1.BeanToArray;
        if ((i14 & enumC10653e1.f51248a) == 0) {
            C9841f c9841f6 = new C9841f();
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61191k(Integer.valueOf(enumC10653e1.f51248a));
            interfaceC9843h.mo61189i(182, f51116f, "isEnabled", "(I)Z");
            interfaceC9843h.mo61188h(153, c9841f6);
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, 2);
            interfaceC9843h.mo61187g(25, 3);
            interfaceC9843h.mo61187g(25, 4);
            interfaceC9843h.mo61187g(21, 5);
            interfaceC9843h.mo61189i(182, aVar.f51128b, str4, "(L" + f51113c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            interfaceC9843h.mo61185e(177);
            interfaceC9843h.mo61192l(c9841f6);
        } else {
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, 2);
            interfaceC9843h.mo61187g(25, 3);
            interfaceC9843h.mo61187g(25, 4);
            interfaceC9843h.mo61187g(21, 5);
            interfaceC9843h.mo61189i(182, aVar.f51128b, str4, "(L" + f51113c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            interfaceC9843h.mo61185e(177);
        }
        if (!aVar.f51133g) {
            interfaceC9843h.mo61187g(25, 1);
            String str5 = f51113c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("()");
            String str6 = f51120j;
            sb2.append(str6);
            interfaceC9843h.mo61189i(182, str5, "getContext", sb2.toString());
            interfaceC9843h.mo61187g(58, aVar.m65173g("parent"));
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, aVar.m65173g("parent"));
            interfaceC9843h.mo61187g(25, 2);
            interfaceC9843h.mo61187g(25, 3);
            interfaceC9843h.mo61191k(Integer.valueOf(aVar.f51129c.f51343g));
            interfaceC9843h.mo61189i(182, str5, "setContext", "(" + str6 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        boolean z10 = (aVar.f51129c.f51343g & EnumC10653e1.WriteClassName.f51248a) != 0;
        if (z10 || !aVar.f51130d) {
            C9841f c9841f7 = new C9841f();
            C9841f c9841f8 = new C9841f();
            C9841f c9841f9 = new C9841f();
            if (z10) {
                str = "parent";
                i10 = 182;
            } else {
                interfaceC9843h.mo61187g(25, 1);
                interfaceC9843h.mo61187g(25, 4);
                interfaceC9843h.mo61187g(25, 2);
                str = "parent";
                i10 = 182;
                interfaceC9843h.mo61189i(182, f51113c, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                interfaceC9843h.mo61188h(153, c9841f8);
            }
            interfaceC9843h.mo61187g(25, 4);
            interfaceC9843h.mo61187g(25, 2);
            interfaceC9843h.mo61189i(i10, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            interfaceC9843h.mo61188h(165, c9841f8);
            interfaceC9843h.mo61192l(c9841f9);
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(16, 123);
            interfaceC9843h.mo61189i(i10, f51116f, "write", "(I)V");
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61187g(25, 1);
            if (aVar.f51129c.f51339c != null) {
                interfaceC9843h.mo61191k(aVar.f51129c.f51339c);
            } else {
                interfaceC9843h.mo61185e(1);
            }
            interfaceC9843h.mo61187g(25, 2);
            interfaceC9843h.mo61189i(182, f51118h, "writeClassName", "(L" + f51113c + ";Ljava/lang/String;Ljava/lang/Object;)V");
            interfaceC9843h.mo61187g(16, 44);
            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f7);
            interfaceC9843h.mo61192l(c9841f8);
            interfaceC9843h.mo61187g(16, 123);
            interfaceC9843h.mo61192l(c9841f7);
        } else {
            interfaceC9843h.mo61187g(16, 123);
            str = "parent";
        }
        interfaceC9843h.mo61187g(54, aVar.m65173g("seperator"));
        if (!aVar.f51130d) {
            m65143c(interfaceC9843h, aVar);
        }
        if (aVar.f51130d) {
            i11 = 0;
        } else {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61189i(182, f51116f, "isNotWriteDefaultValue", "()Z");
            interfaceC9843h.mo61187g(54, aVar.m65173g("notWriteDefaultValue"));
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, 0);
            String str7 = f51113c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(");
            String str8 = f51121k;
            sb3.append(str8);
            sb3.append(")Z");
            interfaceC9843h.mo61189i(182, str7, "checkValue", sb3.toString());
            interfaceC9843h.mo61187g(54, aVar.m65173g("checkValue"));
            interfaceC9843h.mo61187g(25, 1);
            i11 = 0;
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61189i(182, str7, "hasNameFilters", "(" + str8 + ")Z");
            interfaceC9843h.mo61187g(54, aVar.m65173g("hasNameFilters"));
        }
        while (i11 < length) {
            C11592d c11592d = c11592dArr2[i11];
            Class<?> cls3 = c11592d.f53772e;
            interfaceC9843h.mo61191k(c11592d.f53768a);
            interfaceC9843h.mo61187g(58, a.f51124h);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str2 = str3;
                m65153m(cls, interfaceC9843h, c11592d, aVar, aVar.m65173g(cls3.getName()), 'I');
            } else {
                if (cls3 == Long.TYPE) {
                    cls2 = cls;
                    m65156p(cls2, interfaceC9843h, c11592d, aVar);
                } else {
                    cls2 = cls;
                    if (cls3 == Float.TYPE) {
                        m65148h(cls2, interfaceC9843h, c11592d, aVar);
                    } else if (cls3 == Double.TYPE) {
                        m65145e(cls2, interfaceC9843h, c11592d, aVar);
                    } else if (cls3 == Boolean.TYPE) {
                        str2 = str3;
                        m65153m(cls, interfaceC9843h, c11592d, aVar, aVar.m65173g("boolean"), 'Z');
                    } else {
                        str2 = str3;
                        if (cls3 == Character.TYPE) {
                            m65153m(cls, interfaceC9843h, c11592d, aVar, aVar.m65173g("char"), 'C');
                        } else if (cls3 == String.class) {
                            m65163w(cls2, interfaceC9843h, c11592d, aVar);
                        } else if (cls3 == BigDecimal.class) {
                            m65144d(cls2, interfaceC9843h, c11592d, aVar);
                        } else if (List.class.isAssignableFrom(cls3)) {
                            m65155o(cls2, interfaceC9843h, c11592d, aVar);
                        } else if (cls3.isEnum()) {
                            m65146f(cls2, interfaceC9843h, c11592d, aVar);
                        } else {
                            m65159s(cls2, interfaceC9843h, c11592d, aVar);
                        }
                    }
                }
                str2 = str3;
            }
            i11++;
            c11592dArr2 = c11592dArr;
            str3 = str2;
        }
        String str9 = str3;
        if (!aVar.f51130d) {
            m65141a(interfaceC9843h, aVar);
        }
        C9841f c9841f10 = new C9841f();
        C9841f c9841f11 = new C9841f();
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        interfaceC9843h.mo61184d(16, 123);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f10);
        interfaceC9843h.mo61187g(25, aVar.m65173g(str9));
        interfaceC9843h.mo61187g(16, 123);
        String str10 = f51116f;
        interfaceC9843h.mo61189i(182, str10, "write", "(I)V");
        interfaceC9843h.mo61192l(c9841f10);
        interfaceC9843h.mo61187g(25, aVar.m65173g(str9));
        interfaceC9843h.mo61187g(16, 125);
        interfaceC9843h.mo61189i(182, str10, "write", "(I)V");
        interfaceC9843h.mo61192l(c9841f11);
        interfaceC9843h.mo61192l(c9841f);
        if (aVar.f51133g) {
            return;
        }
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, aVar.m65173g(str));
        interfaceC9843h.mo61189i(182, f51113c, "setContext", "(" + f51120j + ")V");
    }

    /* renamed from: a */
    public final void m65141a(InterfaceC9843h interfaceC9843h, a aVar) {
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, 2);
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        interfaceC9843h.mo61189i(182, f51118h, "writeAfter", "(L" + f51113c + ";Ljava/lang/Object;C)C");
        interfaceC9843h.mo61187g(54, aVar.m65173g("seperator"));
    }

    /* renamed from: b */
    public final void m65142b(InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        Class<?> cls = c11592d.f53772e;
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, 2);
        interfaceC9843h.mo61187g(25, a.f51124h);
        if (cls == Byte.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("byte"));
            interfaceC9843h.mo61189i(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("short"));
            interfaceC9843h.mo61189i(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("int"));
            interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("char"));
            interfaceC9843h.mo61189i(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            interfaceC9843h.mo61187g(22, aVar.m65174h("long", 2));
            interfaceC9843h.mo61189i(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            interfaceC9843h.mo61187g(23, aVar.m65173g("float"));
            interfaceC9843h.mo61189i(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            interfaceC9843h.mo61187g(24, aVar.m65174h("double", 2));
            interfaceC9843h.mo61189i(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("boolean"));
            interfaceC9843h.mo61189i(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("decimal"));
        } else if (cls == String.class) {
            interfaceC9843h.mo61187g(25, aVar.m65173g(ExtractOWiFiHelper.STING_NODE));
        } else if (cls.isEnum()) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
        } else {
            interfaceC9843h.mo61187g(25, aVar.m65173g("object"));
        }
        interfaceC9843h.mo61189i(182, f51118h, "apply", "(L" + f51113c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    /* renamed from: c */
    public final void m65143c(InterfaceC9843h interfaceC9843h, a aVar) {
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, 2);
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        interfaceC9843h.mo61189i(182, f51118h, "writeBefore", "(L" + f51113c + ";Ljava/lang/Object;C)C");
        interfaceC9843h.mo61187g(54, aVar.m65173g("seperator"));
    }

    /* renamed from: d */
    public final void m65144d(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        C9841f c9841f = new C9841f();
        m65157q(interfaceC9843h, c11592d, aVar, c9841f);
        m65149i(interfaceC9843h, aVar, c11592d);
        interfaceC9843h.mo61187g(58, aVar.m65173g("decimal"));
        m65147g(interfaceC9843h, c11592d, aVar, c9841f);
        C9841f c9841f2 = new C9841f();
        C9841f c9841f3 = new C9841f();
        C9841f c9841f4 = new C9841f();
        interfaceC9843h.mo61192l(c9841f2);
        interfaceC9843h.mo61187g(25, aVar.m65173g("decimal"));
        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f3);
        m65152l(interfaceC9843h, c11592d, aVar);
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f4);
        interfaceC9843h.mo61192l(c9841f3);
        interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        interfaceC9843h.mo61187g(25, a.f51124h);
        interfaceC9843h.mo61187g(25, aVar.m65173g("decimal"));
        interfaceC9843h.mo61189i(182, f51116f, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        m65162v(interfaceC9843h, aVar);
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f4);
        interfaceC9843h.mo61192l(c9841f4);
        interfaceC9843h.mo61192l(c9841f);
    }

    /* renamed from: e */
    public final void m65145e(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        C9841f c9841f = new C9841f();
        m65157q(interfaceC9843h, c11592d, aVar, c9841f);
        m65149i(interfaceC9843h, aVar, c11592d);
        interfaceC9843h.mo61187g(57, aVar.m65174h("double", 2));
        m65147g(interfaceC9843h, c11592d, aVar, c9841f);
        interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        interfaceC9843h.mo61187g(25, a.f51124h);
        interfaceC9843h.mo61187g(24, aVar.m65174h("double", 2));
        interfaceC9843h.mo61189i(182, f51116f, "writeFieldValue", "(CLjava/lang/String;D)V");
        m65162v(interfaceC9843h, aVar);
        interfaceC9843h.mo61192l(c9841f);
    }

    /* renamed from: f */
    public final void m65146f(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        C9841f c9841f = new C9841f();
        C9841f c9841f2 = new C9841f();
        C9841f c9841f3 = new C9841f();
        m65157q(interfaceC9843h, c11592d, aVar, c9841f3);
        m65149i(interfaceC9843h, aVar, c11592d);
        interfaceC9843h.mo61182b(192, "java/lang/Enum");
        interfaceC9843h.mo61187g(58, aVar.m65173g("enum"));
        m65147g(interfaceC9843h, c11592d, aVar, c9841f3);
        interfaceC9843h.mo61187g(25, aVar.m65173g("enum"));
        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f);
        m65152l(interfaceC9843h, c11592d, aVar);
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f2);
        interfaceC9843h.mo61192l(c9841f);
        if (aVar.f51130d) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61187g(25, aVar.m65173g("enum"));
            interfaceC9843h.mo61189i(182, "java/lang/Enum", "name", "()Ljava/lang/String;");
            interfaceC9843h.mo61189i(182, f51116f, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
            String str = f51116f;
            interfaceC9843h.mo61189i(182, str, "write", "(I)V");
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61185e(3);
            interfaceC9843h.mo61189i(182, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, aVar.m65173g("enum"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(c11592d.f53772e)));
            interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
            interfaceC9843h.mo61189i(182, f51113c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        m65162v(interfaceC9843h, aVar);
        interfaceC9843h.mo61192l(c9841f2);
        interfaceC9843h.mo61192l(c9841f3);
    }

    /* renamed from: g */
    public final void m65147g(InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar, C9841f c9841f) {
        if (c11592d.f53782o) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61191k(Integer.valueOf(EnumC10653e1.SkipTransientField.f51248a));
            interfaceC9843h.mo61189i(182, f51116f, "isEnabled", "(I)Z");
            interfaceC9843h.mo61188h(154, c9841f);
        }
        m65158r(interfaceC9843h, c11592d, aVar, c9841f);
        if (aVar.f51130d) {
            return;
        }
        m65142b(interfaceC9843h, c11592d, aVar);
        interfaceC9843h.mo61188h(153, c9841f);
        m65160t(interfaceC9843h, c11592d, aVar);
        m65161u(interfaceC9843h, c11592d, aVar, c9841f);
    }

    /* renamed from: h */
    public final void m65148h(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        C9841f c9841f = new C9841f();
        m65157q(interfaceC9843h, c11592d, aVar, c9841f);
        m65149i(interfaceC9843h, aVar, c11592d);
        interfaceC9843h.mo61187g(56, aVar.m65173g("float"));
        m65147g(interfaceC9843h, c11592d, aVar, c9841f);
        interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        interfaceC9843h.mo61187g(25, a.f51124h);
        interfaceC9843h.mo61187g(23, aVar.m65173g("float"));
        interfaceC9843h.mo61189i(182, f51116f, "writeFieldValue", "(CLjava/lang/String;F)V");
        m65162v(interfaceC9843h, aVar);
        interfaceC9843h.mo61192l(c9841f);
    }

    /* renamed from: i */
    public final void m65149i(InterfaceC9843h interfaceC9843h, a aVar, C11592d c11592d) {
        Method method = c11592d.f53769b;
        if (method != null) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            interfaceC9843h.mo61189i(declaringClass.isInterface() ? 185 : 182, C11590b.m69190g(declaringClass), method.getName(), C11590b.m69186c(method));
            if (method.getReturnType().equals(c11592d.f53772e)) {
                return;
            }
            interfaceC9843h.mo61182b(192, C11590b.m69190g(c11592d.f53772e));
            return;
        }
        interfaceC9843h.mo61187g(25, aVar.m65173g("entity"));
        Field field = c11592d.f53770c;
        interfaceC9843h.mo61183c(180, C11590b.m69190g(c11592d.f53774g), field.getName(), C11590b.m69185b(field.getType()));
        if (field.getType().equals(c11592d.f53772e)) {
            return;
        }
        interfaceC9843h.mo61182b(192, C11590b.m69190g(c11592d.f53772e));
    }

    /* renamed from: j */
    public final void m65150j(a aVar, InterfaceC9843h interfaceC9843h, C11592d c11592d) {
        C9841f c9841f = new C9841f();
        interfaceC9843h.mo61187g(25, 0);
        String str = aVar.f51128b;
        String str2 = c11592d.f53768a + "_asm_ser_";
        String str3 = f51115e;
        interfaceC9843h.mo61183c(180, str, str2, str3);
        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(c11592d.f53772e)));
        interfaceC9843h.mo61189i(182, f51113c, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        interfaceC9843h.mo61183c(181, aVar.f51128b, c11592d.f53768a + "_asm_ser_", str3);
        interfaceC9843h.mo61192l(c9841f);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61183c(180, aVar.f51128b, c11592d.f53768a + "_asm_ser_", str3);
    }

    /* renamed from: k */
    public final void m65151k(a aVar, InterfaceC9843h interfaceC9843h, C11592d c11592d, Class<?> cls) {
        C9841f c9841f = new C9841f();
        interfaceC9843h.mo61187g(25, 0);
        String str = aVar.f51128b;
        String str2 = c11592d.f53768a + "_asm_list_item_ser_";
        String str3 = f51115e;
        interfaceC9843h.mo61183c(180, str, str2, str3);
        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls)));
        interfaceC9843h.mo61189i(182, f51113c, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        interfaceC9843h.mo61183c(181, aVar.f51128b, c11592d.f53768a + "_asm_list_item_ser_", str3);
        interfaceC9843h.mo61192l(c9841f);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61183c(180, aVar.f51128b, c11592d.f53768a + "_asm_list_item_ser_", str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0138  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m65152l(p305g1.InterfaceC9843h r18, p481n1.C11592d r19, p381j1.C10639a.a r20) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p381j1.C10639a.m65152l(g1.h, n1.d, j1.a$a):void");
    }

    /* renamed from: m */
    public final void m65153m(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar, int i10, char c10) {
        C9841f c9841f = new C9841f();
        m65157q(interfaceC9843h, c11592d, aVar, c9841f);
        m65149i(interfaceC9843h, aVar, c11592d);
        interfaceC9843h.mo61187g(54, i10);
        m65147g(interfaceC9843h, c11592d, aVar, c9841f);
        interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        interfaceC9843h.mo61187g(25, a.f51124h);
        interfaceC9843h.mo61187g(21, i10);
        interfaceC9843h.mo61189i(182, f51116f, "writeFieldValue", "(CLjava/lang/String;" + c10 + ")V");
        m65162v(interfaceC9843h, aVar);
        interfaceC9843h.mo61192l(c9841f);
    }

    /* renamed from: n */
    public final void m65154n(InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar, C9841f c9841f) {
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61191k(c11592d.f53778k);
        interfaceC9843h.mo61189i(182, f51118h, "applyLabel", "(L" + f51113c + ";Ljava/lang/String;)Z");
        interfaceC9843h.mo61188h(153, c9841f);
    }

    /* renamed from: o */
    public final void m65155o(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        C9841f c9841f;
        C9841f c9841f2;
        C9841f c9841f3;
        String str;
        C9841f c9841f4;
        String str2;
        C9841f c9841f5;
        C11592d c11592d2;
        C9841f c9841f6;
        int i10;
        int i11;
        int i12;
        C9841f c9841f7;
        C9841f c9841f8;
        String str3;
        String str4;
        Type typeM69276U = C11603o.m69276U(c11592d.f53773f);
        Class<?> cls2 = null;
        Class<?> cls3 = typeM69276U instanceof Class ? (Class) typeM69276U : null;
        if (cls3 != Object.class && cls3 != Serializable.class) {
            cls2 = cls3;
        }
        C9841f c9841f9 = new C9841f();
        C9841f c9841f10 = new C9841f();
        C9841f c9841f11 = new C9841f();
        m65157q(interfaceC9843h, c11592d, aVar, c9841f9);
        m65149i(interfaceC9843h, aVar, c11592d);
        interfaceC9843h.mo61182b(192, "java/util/List");
        interfaceC9843h.mo61187g(58, aVar.m65173g("list"));
        m65147g(interfaceC9843h, c11592d, aVar, c9841f9);
        interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f10);
        m65152l(interfaceC9843h, c11592d, aVar);
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f11);
        interfaceC9843h.mo61192l(c9841f10);
        interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        String str5 = f51116f;
        interfaceC9843h.mo61189i(182, str5, "write", "(I)V");
        m65164x(interfaceC9843h, aVar);
        interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
        interfaceC9843h.mo61189i(185, "java/util/List", "size", "()I");
        interfaceC9843h.mo61187g(54, aVar.m65173g("size"));
        C9841f c9841f12 = new C9841f();
        C9841f c9841f13 = new C9841f();
        interfaceC9843h.mo61187g(21, aVar.m65173g("size"));
        interfaceC9843h.mo61185e(3);
        interfaceC9843h.mo61188h(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE, c9841f12);
        interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
        interfaceC9843h.mo61191k(C6010m7.f27500n);
        interfaceC9843h.mo61189i(182, str5, "write", "(Ljava/lang/String;)V");
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f13);
        interfaceC9843h.mo61192l(c9841f12);
        if (aVar.f51133g) {
            c9841f = c9841f13;
        } else {
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            c9841f = c9841f13;
            interfaceC9843h.mo61189i(182, f51113c, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (typeM69276U == String.class && aVar.f51130d) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
            interfaceC9843h.mo61189i(182, str5, "write", "(Ljava/util/List;)V");
            i11 = 25;
            i12 = 182;
            i10 = 1;
        } else {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(16, 91);
            interfaceC9843h.mo61189i(182, str5, "write", "(I)V");
            C9841f c9841f14 = new C9841f();
            C9841f c9841f15 = new C9841f();
            C9841f c9841f16 = new C9841f();
            interfaceC9843h.mo61185e(3);
            interfaceC9843h.mo61187g(54, aVar.m65173g("i"));
            interfaceC9843h.mo61192l(c9841f14);
            interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
            interfaceC9843h.mo61187g(21, aVar.m65173g("size"));
            interfaceC9843h.mo61188h(162, c9841f16);
            interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
            interfaceC9843h.mo61188h(153, c9841f15);
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(16, 44);
            interfaceC9843h.mo61189i(182, str5, "write", "(I)V");
            interfaceC9843h.mo61192l(c9841f15);
            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
            interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
            interfaceC9843h.mo61189i(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            interfaceC9843h.mo61187g(58, aVar.m65173g("list_item"));
            C9841f c9841f17 = new C9841f();
            C9841f c9841f18 = new C9841f();
            interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
            interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f18);
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61189i(182, str5, "writeNull", "()V");
            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f17);
            interfaceC9843h.mo61192l(c9841f18);
            C9841f c9841f19 = new C9841f();
            C9841f c9841f20 = new C9841f();
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                c9841f2 = c9841f14;
                c9841f3 = c9841f17;
                str = "out";
                c9841f4 = c9841f19;
                str2 = "write";
                c9841f5 = c9841f16;
                c11592d2 = c11592d;
                c9841f6 = c9841f20;
            } else {
                str = "out";
                interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
                c9841f5 = c9841f16;
                c9841f2 = c9841f14;
                interfaceC9843h.mo61189i(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls2)));
                interfaceC9843h.mo61188h(166, c9841f20);
                c11592d2 = c11592d;
                m65151k(aVar, interfaceC9843h, c11592d2, cls2);
                interfaceC9843h.mo61187g(58, aVar.m65173g("list_item_desc"));
                C9841f c9841f21 = new C9841f();
                C9841f c9841f22 = new C9841f();
                if (aVar.f51130d) {
                    if (aVar.f51133g && aVar.f51130d) {
                        c9841f3 = c9841f17;
                        str4 = "writeDirectNonContext";
                        c9841f8 = c9841f20;
                    } else {
                        c9841f3 = c9841f17;
                        c9841f8 = c9841f20;
                        str4 = "write";
                    }
                    c9841f7 = c9841f19;
                    interfaceC9843h.mo61187g(25, aVar.m65173g("list_item_desc"));
                    String str6 = f51118h;
                    interfaceC9843h.mo61182b(193, str6);
                    interfaceC9843h.mo61188h(153, c9841f21);
                    str3 = "write";
                    interfaceC9843h.mo61187g(25, aVar.m65173g("list_item_desc"));
                    interfaceC9843h.mo61182b(192, str6);
                    interfaceC9843h.mo61187g(25, 1);
                    interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
                    if (aVar.f51133g) {
                        interfaceC9843h.mo61185e(1);
                    } else {
                        interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
                        interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls2)));
                    interfaceC9843h.mo61191k(Integer.valueOf(c11592d2.f53776i));
                    interfaceC9843h.mo61189i(182, str6, str4, "(L" + f51113c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f22);
                    interfaceC9843h.mo61192l(c9841f21);
                } else {
                    c9841f3 = c9841f17;
                    c9841f7 = c9841f19;
                    c9841f8 = c9841f20;
                    str3 = "write";
                }
                interfaceC9843h.mo61187g(25, aVar.m65173g("list_item_desc"));
                interfaceC9843h.mo61187g(25, 1);
                interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
                if (aVar.f51133g) {
                    interfaceC9843h.mo61185e(1);
                } else {
                    interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
                    interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls2)));
                interfaceC9843h.mo61191k(Integer.valueOf(c11592d2.f53776i));
                str2 = str3;
                interfaceC9843h.mo61189i(185, f51114d, str2, "(L" + f51113c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                interfaceC9843h.mo61192l(c9841f22);
                c9841f4 = c9841f7;
                interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f4);
                c9841f6 = c9841f8;
            }
            interfaceC9843h.mo61192l(c9841f6);
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, aVar.m65173g("list_item"));
            if (aVar.f51133g) {
                interfaceC9843h.mo61185e(1);
            } else {
                interfaceC9843h.mo61187g(21, aVar.m65173g("i"));
                interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                interfaceC9843h.mo61189i(182, f51113c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b((Class) typeM69276U)));
                interfaceC9843h.mo61191k(Integer.valueOf(c11592d2.f53776i));
                interfaceC9843h.mo61189i(182, f51113c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            interfaceC9843h.mo61192l(c9841f4);
            interfaceC9843h.mo61192l(c9841f3);
            i10 = 1;
            interfaceC9843h.mo61181a(aVar.m65173g("i"), 1);
            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f2);
            interfaceC9843h.mo61192l(c9841f5);
            i11 = 25;
            interfaceC9843h.mo61187g(25, aVar.m65173g(str));
            interfaceC9843h.mo61187g(16, 93);
            i12 = 182;
            interfaceC9843h.mo61189i(182, str5, str2, "(I)V");
        }
        interfaceC9843h.mo61187g(i11, i10);
        interfaceC9843h.mo61189i(i12, f51113c, "popContext", "()V");
        interfaceC9843h.mo61192l(c9841f);
        m65162v(interfaceC9843h, aVar);
        interfaceC9843h.mo61192l(c9841f11);
        interfaceC9843h.mo61192l(c9841f9);
    }

    /* renamed from: p */
    public final void m65156p(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        C9841f c9841f = new C9841f();
        m65157q(interfaceC9843h, c11592d, aVar, c9841f);
        m65149i(interfaceC9843h, aVar, c11592d);
        interfaceC9843h.mo61187g(55, aVar.m65174h("long", 2));
        m65147g(interfaceC9843h, c11592d, aVar, c9841f);
        interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        interfaceC9843h.mo61187g(25, a.f51124h);
        interfaceC9843h.mo61187g(22, aVar.m65174h("long", 2));
        interfaceC9843h.mo61189i(182, f51116f, "writeFieldValue", "(CLjava/lang/String;J)V");
        m65162v(interfaceC9843h, aVar);
        interfaceC9843h.mo61192l(c9841f);
    }

    /* renamed from: q */
    public final void m65157q(InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar, C9841f c9841f) {
        if (!aVar.f51130d) {
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, 2);
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61189i(182, f51118h, "applyName", "(L" + f51113c + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            interfaceC9843h.mo61188h(153, c9841f);
            m65154n(interfaceC9843h, c11592d, aVar, c9841f);
        }
        if (c11592d.f53770c == null) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61191k(Integer.valueOf(EnumC10653e1.IgnoreNonFieldGetter.f51248a));
            interfaceC9843h.mo61189i(182, f51116f, "isEnabled", "(I)Z");
            interfaceC9843h.mo61188h(154, c9841f);
        }
    }

    /* renamed from: r */
    public final void m65158r(InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar, C9841f c9841f) {
        if (aVar.f51130d) {
            return;
        }
        C9841f c9841f2 = new C9841f();
        interfaceC9843h.mo61187g(21, aVar.m65173g("notWriteDefaultValue"));
        interfaceC9843h.mo61188h(153, c9841f2);
        Class<?> cls = c11592d.f53772e;
        if (cls == Boolean.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("boolean"));
            interfaceC9843h.mo61188h(153, c9841f);
        } else if (cls == Byte.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("byte"));
            interfaceC9843h.mo61188h(153, c9841f);
        } else if (cls == Short.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("short"));
            interfaceC9843h.mo61188h(153, c9841f);
        } else if (cls == Integer.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("int"));
            interfaceC9843h.mo61188h(153, c9841f);
        } else if (cls == Long.TYPE) {
            interfaceC9843h.mo61187g(22, aVar.m65173g("long"));
            interfaceC9843h.mo61185e(9);
            interfaceC9843h.mo61185e(148);
            interfaceC9843h.mo61188h(153, c9841f);
        } else if (cls == Float.TYPE) {
            interfaceC9843h.mo61187g(23, aVar.m65173g("float"));
            interfaceC9843h.mo61185e(11);
            interfaceC9843h.mo61185e(149);
            interfaceC9843h.mo61188h(153, c9841f);
        } else if (cls == Double.TYPE) {
            interfaceC9843h.mo61187g(24, aVar.m65173g("double"));
            interfaceC9843h.mo61185e(14);
            interfaceC9843h.mo61185e(151);
            interfaceC9843h.mo61188h(153, c9841f);
        }
        interfaceC9843h.mo61192l(c9841f2);
    }

    /* renamed from: s */
    public final void m65159s(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        C9841f c9841f = new C9841f();
        m65157q(interfaceC9843h, c11592d, aVar, c9841f);
        m65149i(interfaceC9843h, aVar, c11592d);
        interfaceC9843h.mo61187g(58, aVar.m65173g("object"));
        m65147g(interfaceC9843h, c11592d, aVar, c9841f);
        m65165y(interfaceC9843h, c11592d, aVar, c9841f);
        interfaceC9843h.mo61192l(c9841f);
    }

    /* renamed from: t */
    public final void m65160t(InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        C9841f c9841f = new C9841f();
        interfaceC9843h.mo61187g(21, aVar.m65173g("hasNameFilters"));
        interfaceC9843h.mo61188h(153, c9841f);
        Class<?> cls = c11592d.f53772e;
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, 2);
        interfaceC9843h.mo61187g(25, a.f51124h);
        if (cls == Byte.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("byte"));
            interfaceC9843h.mo61189i(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("short"));
            interfaceC9843h.mo61189i(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("int"));
            interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("char"));
            interfaceC9843h.mo61189i(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            interfaceC9843h.mo61187g(22, aVar.m65174h("long", 2));
            interfaceC9843h.mo61189i(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            interfaceC9843h.mo61187g(23, aVar.m65173g("float"));
            interfaceC9843h.mo61189i(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            interfaceC9843h.mo61187g(24, aVar.m65174h("double", 2));
            interfaceC9843h.mo61189i(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("boolean"));
            interfaceC9843h.mo61189i(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("decimal"));
        } else if (cls == String.class) {
            interfaceC9843h.mo61187g(25, aVar.m65173g(ExtractOWiFiHelper.STING_NODE));
        } else if (cls.isEnum()) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
        } else {
            interfaceC9843h.mo61187g(25, aVar.m65173g("object"));
        }
        interfaceC9843h.mo61189i(182, f51118h, "processKey", "(L" + f51113c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        interfaceC9843h.mo61187g(58, a.f51124h);
        interfaceC9843h.mo61192l(c9841f);
    }

    /* renamed from: u */
    public final void m65161u(InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar, C9841f c9841f) {
        C9841f c9841f2 = new C9841f();
        Class<?> cls = c11592d.f53772e;
        if (cls.isPrimitive()) {
            C9841f c9841f3 = new C9841f();
            interfaceC9843h.mo61187g(21, aVar.m65173g("checkValue"));
            interfaceC9843h.mo61188h(154, c9841f3);
            interfaceC9843h.mo61185e(1);
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61187g(58, a.f51125i);
            interfaceC9843h.mo61187g(58, a.f51126j);
            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f2);
            interfaceC9843h.mo61192l(c9841f3);
        }
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61187g(25, 1);
        interfaceC9843h.mo61187g(25, 0);
        interfaceC9843h.mo61191k(Integer.valueOf(aVar.m65172f(c11592d.f53768a)));
        String str = f51118h;
        interfaceC9843h.mo61189i(182, str, "getBeanContext", "(I)" + C11590b.m69185b(C10665j.class));
        interfaceC9843h.mo61187g(25, 2);
        interfaceC9843h.mo61187g(25, a.f51124h);
        if (cls == Byte.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("byte"));
            interfaceC9843h.mo61189i(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61187g(58, a.f51125i);
        } else if (cls == Short.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("short"));
            interfaceC9843h.mo61189i(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61187g(58, a.f51125i);
        } else if (cls == Integer.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("int"));
            interfaceC9843h.mo61189i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61187g(58, a.f51125i);
        } else if (cls == Character.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("char"));
            interfaceC9843h.mo61189i(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61187g(58, a.f51125i);
        } else if (cls == Long.TYPE) {
            interfaceC9843h.mo61187g(22, aVar.m65174h("long", 2));
            interfaceC9843h.mo61189i(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61187g(58, a.f51125i);
        } else if (cls == Float.TYPE) {
            interfaceC9843h.mo61187g(23, aVar.m65173g("float"));
            interfaceC9843h.mo61189i(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61187g(58, a.f51125i);
        } else if (cls == Double.TYPE) {
            interfaceC9843h.mo61187g(24, aVar.m65174h("double", 2));
            interfaceC9843h.mo61189i(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61187g(58, a.f51125i);
        } else if (cls == Boolean.TYPE) {
            interfaceC9843h.mo61187g(21, aVar.m65173g("boolean"));
            interfaceC9843h.mo61189i(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            interfaceC9843h.mo61185e(89);
            interfaceC9843h.mo61187g(58, a.f51125i);
        } else if (cls == BigDecimal.class) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("decimal"));
            interfaceC9843h.mo61187g(58, a.f51125i);
            interfaceC9843h.mo61187g(25, a.f51125i);
        } else if (cls == String.class) {
            interfaceC9843h.mo61187g(25, aVar.m65173g(ExtractOWiFiHelper.STING_NODE));
            interfaceC9843h.mo61187g(58, a.f51125i);
            interfaceC9843h.mo61187g(25, a.f51125i);
        } else if (cls.isEnum()) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("enum"));
            interfaceC9843h.mo61187g(58, a.f51125i);
            interfaceC9843h.mo61187g(25, a.f51125i);
        } else if (List.class.isAssignableFrom(cls)) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("list"));
            interfaceC9843h.mo61187g(58, a.f51125i);
            interfaceC9843h.mo61187g(25, a.f51125i);
        } else {
            interfaceC9843h.mo61187g(25, aVar.m65173g("object"));
            interfaceC9843h.mo61187g(58, a.f51125i);
            interfaceC9843h.mo61187g(25, a.f51125i);
        }
        interfaceC9843h.mo61189i(182, str, "processValue", "(L" + f51113c + ";" + C11590b.m69185b(C10665j.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        interfaceC9843h.mo61187g(58, a.f51126j);
        interfaceC9843h.mo61187g(25, a.f51125i);
        interfaceC9843h.mo61187g(25, a.f51126j);
        interfaceC9843h.mo61188h(165, c9841f2);
        m65165y(interfaceC9843h, c11592d, aVar, c9841f);
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f);
        interfaceC9843h.mo61192l(c9841f2);
    }

    /* renamed from: v */
    public final void m65162v(InterfaceC9843h interfaceC9843h, a aVar) {
        interfaceC9843h.mo61187g(16, 44);
        interfaceC9843h.mo61187g(54, aVar.m65173g("seperator"));
    }

    /* renamed from: w */
    public final void m65163w(Class<?> cls, InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar) {
        C9841f c9841f = new C9841f();
        if (c11592d.f53768a.equals(aVar.f51129c.f51339c)) {
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, 4);
            interfaceC9843h.mo61187g(25, 2);
            interfaceC9843h.mo61189i(182, f51113c, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            interfaceC9843h.mo61188h(154, c9841f);
        }
        m65157q(interfaceC9843h, c11592d, aVar, c9841f);
        m65149i(interfaceC9843h, aVar, c11592d);
        interfaceC9843h.mo61187g(58, aVar.m65173g(ExtractOWiFiHelper.STING_NODE));
        m65147g(interfaceC9843h, c11592d, aVar, c9841f);
        C9841f c9841f2 = new C9841f();
        C9841f c9841f3 = new C9841f();
        interfaceC9843h.mo61187g(25, aVar.m65173g(ExtractOWiFiHelper.STING_NODE));
        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f2);
        m65152l(interfaceC9843h, c11592d, aVar);
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f3);
        interfaceC9843h.mo61192l(c9841f2);
        if ("trim".equals(c11592d.f53787t)) {
            interfaceC9843h.mo61187g(25, aVar.m65173g(ExtractOWiFiHelper.STING_NODE));
            interfaceC9843h.mo61189i(182, "java/lang/String", "trim", "()Ljava/lang/String;");
            interfaceC9843h.mo61187g(58, aVar.m65173g(ExtractOWiFiHelper.STING_NODE));
        }
        if (aVar.f51130d) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61187g(25, aVar.m65173g(ExtractOWiFiHelper.STING_NODE));
            interfaceC9843h.mo61189i(182, f51116f, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61187g(25, aVar.m65173g(ExtractOWiFiHelper.STING_NODE));
            interfaceC9843h.mo61189i(182, f51116f, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        m65162v(interfaceC9843h, aVar);
        interfaceC9843h.mo61192l(c9841f3);
        interfaceC9843h.mo61192l(c9841f);
    }

    /* renamed from: x */
    public final void m65164x(InterfaceC9843h interfaceC9843h, a aVar) {
        if (aVar.f51130d) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61189i(182, f51116f, "writeFieldNameDirect", "(Ljava/lang/String;)V");
        } else {
            interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61185e(3);
            interfaceC9843h.mo61189i(182, f51116f, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }

    /* renamed from: y */
    public final void m65165y(InterfaceC9843h interfaceC9843h, C11592d c11592d, a aVar, C9841f c9841f) {
        String str;
        C9841f c9841f2;
        C9841f c9841f3;
        String strM69201r = c11592d.m69201r();
        Class<?> cls = c11592d.f53772e;
        C9841f c9841f4 = new C9841f();
        if (aVar.f51130d) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("object"));
        } else {
            interfaceC9843h.mo61187g(25, a.f51126j);
        }
        interfaceC9843h.mo61185e(89);
        interfaceC9843h.mo61187g(58, aVar.m65173g("object"));
        interfaceC9843h.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f4);
        m65152l(interfaceC9843h, c11592d, aVar);
        interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f);
        interfaceC9843h.mo61192l(c9841f4);
        interfaceC9843h.mo61187g(25, aVar.m65173g("out"));
        interfaceC9843h.mo61187g(21, aVar.m65173g("seperator"));
        interfaceC9843h.mo61189i(182, f51116f, "write", "(I)V");
        m65164x(interfaceC9843h, aVar);
        C9841f c9841f5 = new C9841f();
        C9841f c9841f6 = new C9841f();
        if (!Modifier.isPublic(cls.getModifiers()) || C10085i.m62850w(cls)) {
            str = strM69201r;
            c9841f2 = c9841f5;
            c9841f3 = c9841f6;
        } else {
            interfaceC9843h.mo61187g(25, aVar.m65173g("object"));
            interfaceC9843h.mo61189i(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(cls)));
            interfaceC9843h.mo61188h(166, c9841f6);
            m65150j(aVar, interfaceC9843h, c11592d);
            interfaceC9843h.mo61187g(58, aVar.m65173g("fied_ser"));
            C9841f c9841f7 = new C9841f();
            C9841f c9841f8 = new C9841f();
            interfaceC9843h.mo61187g(25, aVar.m65173g("fied_ser"));
            String str2 = f51118h;
            interfaceC9843h.mo61182b(193, str2);
            interfaceC9843h.mo61188h(153, c9841f7);
            int i10 = c11592d.f53776i;
            str = strM69201r;
            boolean z10 = (EnumC10653e1.DisableCircularReferenceDetect.f51248a & i10) != 0;
            boolean z11 = (EnumC10653e1.BeanToArray.f51248a & i10) != 0;
            String str3 = (z10 || (aVar.f51133g && aVar.f51130d)) ? z11 ? "writeAsArrayNonContext" : "writeDirectNonContext" : z11 ? "writeAsArray" : "write";
            interfaceC9843h.mo61187g(25, aVar.m65173g("fied_ser"));
            interfaceC9843h.mo61182b(192, str2);
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, aVar.m65173g("object"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61183c(180, aVar.f51128b, c11592d.f53768a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(L");
            String str4 = f51113c;
            sb2.append(str4);
            sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            interfaceC9843h.mo61189i(182, str2, str3, sb2.toString());
            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f8);
            interfaceC9843h.mo61192l(c9841f7);
            interfaceC9843h.mo61187g(25, aVar.m65173g("fied_ser"));
            interfaceC9843h.mo61187g(25, 1);
            interfaceC9843h.mo61187g(25, aVar.m65173g("object"));
            interfaceC9843h.mo61187g(25, a.f51124h);
            interfaceC9843h.mo61187g(25, 0);
            interfaceC9843h.mo61183c(180, aVar.f51128b, c11592d.f53768a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
            interfaceC9843h.mo61189i(185, f51114d, "write", "(L" + str4 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            interfaceC9843h.mo61192l(c9841f8);
            c9841f2 = c9841f5;
            interfaceC9843h.mo61188h(BDLocation.TypeServerError, c9841f2);
            c9841f3 = c9841f6;
        }
        interfaceC9843h.mo61192l(c9841f3);
        interfaceC9843h.mo61187g(25, 1);
        if (aVar.f51130d) {
            interfaceC9843h.mo61187g(25, aVar.m65173g("object"));
        } else {
            interfaceC9843h.mo61187g(25, a.f51126j);
        }
        if (str != null) {
            interfaceC9843h.mo61191k(str);
            interfaceC9843h.mo61189i(182, f51113c, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            interfaceC9843h.mo61187g(25, a.f51124h);
            Type type = c11592d.f53773f;
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                interfaceC9843h.mo61189i(182, f51113c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                if (c11592d.f53772e == String.class) {
                    interfaceC9843h.mo61191k(C9845j.m61197g(C11590b.m69185b(String.class)));
                } else {
                    interfaceC9843h.mo61187g(25, 0);
                    interfaceC9843h.mo61183c(180, aVar.f51128b, c11592d.f53768a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                interfaceC9843h.mo61191k(Integer.valueOf(c11592d.f53776i));
                interfaceC9843h.mo61189i(182, f51113c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        interfaceC9843h.mo61192l(c9841f2);
        m65162v(interfaceC9843h, aVar);
    }

    /* renamed from: z */
    public C10666j0 m65166z(C10698z0 c10698z0) throws Exception {
        String str;
        String str2;
        boolean z10;
        Class<C10698z0> cls;
        C11592d[] c11592dArr;
        String str3;
        String str4;
        String str5;
        boolean z11;
        boolean z12;
        String str6;
        boolean z13;
        boolean z14;
        InterfaceC9643d interfaceC9643d;
        int i10;
        boolean z15;
        int i11;
        char c10;
        Class<?> cls2;
        int i12;
        Method method;
        Class<?> cls3 = c10698z0.f51337a;
        if (cls3.isPrimitive()) {
            throw new C9380d("unsupportd class " + cls3.getName());
        }
        InterfaceC9643d interfaceC9643d2 = (InterfaceC9643d) C11603o.m69265M(cls3, InterfaceC9643d.class);
        C11592d[] c11592dArr2 = c10698z0.f51341e;
        for (C11592d c11592d : c11592dArr2) {
            if (c11592d.f53770c == null && (method = c11592d.f53769b) != null && method.getDeclaringClass().isInterface()) {
                return new C10666j0(c10698z0);
            }
        }
        C11592d[] c11592dArr3 = c10698z0.f51342f;
        boolean z16 = c11592dArr3 == c10698z0.f51341e;
        if (c11592dArr3.length > 256) {
            return new C10666j0(c10698z0);
        }
        for (C11592d c11592d2 : c11592dArr3) {
            if (!C11590b.m69184a(c11592d2.m69202t().getName())) {
                return new C10666j0(c10698z0);
            }
        }
        String str7 = "ASMSerializer_" + this.f51123b.incrementAndGet() + "_" + cls3.getSimpleName();
        Package r22 = C10639a.class.getPackage();
        if (r22 != null) {
            String name = r22.getName();
            str = name + "." + str7;
            str2 = name.replace('.', C5929g4.f26852n) + "/" + str7;
        } else {
            str = str7;
            str2 = str;
        }
        C9838c c9838c = new C9838c();
        c9838c.m61169k(49, 33, str2, f51118h, new String[]{f51114d});
        int length = c11592dArr3.length;
        int i13 = 0;
        while (i13 < length) {
            C11592d c11592d3 = c11592dArr3[i13];
            if (c11592d3.f53772e.isPrimitive() || c11592d3.f53772e == String.class) {
                i12 = length;
            } else {
                StringBuilder sb2 = new StringBuilder();
                i12 = length;
                sb2.append(c11592d3.f53768a);
                sb2.append("_asm_fieldType");
                new C9839d(c9838c, 1, sb2.toString(), "Ljava/lang/reflect/Type;").m61172c();
                if (List.class.isAssignableFrom(c11592d3.f53772e)) {
                    new C9839d(c9838c, 1, c11592d3.f53768a + "_asm_list_item_ser_", f51115e).m61172c();
                }
                new C9839d(c9838c, 1, c11592d3.f53768a + "_asm_ser_", f51115e).m61172c();
            }
            i13++;
            length = i12;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(");
        Class<C10698z0> cls4 = C10698z0.class;
        sb3.append(C11590b.m69185b(cls4));
        sb3.append(")V");
        String string = sb3.toString();
        Class<?> cls5 = String.class;
        C9838c c9838c2 = c9838c;
        C9844i c9844i = new C9844i(c9838c2, 1, "<init>", string, null, null);
        c9844i.mo61187g(25, 0);
        c9844i.mo61187g(25, 1);
        String str8 = str;
        c9844i.mo61189i(183, f51118h, "<init>", "(" + C11590b.m69185b(cls4) + ")V");
        int i14 = 0;
        while (i14 < c11592dArr3.length) {
            C11592d c11592d4 = c11592dArr3[i14];
            if (c11592d4.f53772e.isPrimitive() || c11592d4.f53772e == cls5) {
                cls2 = cls5;
            } else {
                c9844i.mo61187g(25, 0);
                if (c11592d4.f53769b != null) {
                    c9844i.mo61191k(C9845j.m61197g(C11590b.m69185b(c11592d4.f53774g)));
                    c9844i.mo61191k(c11592d4.f53769b.getName());
                    cls2 = cls5;
                    c9844i.mo61189i(184, C11590b.m69190g(C11590b.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                } else {
                    cls2 = cls5;
                    c9844i.mo61187g(25, 0);
                    c9844i.mo61191k(Integer.valueOf(i14));
                    c9844i.mo61189i(183, f51118h, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                }
                c9844i.mo61183c(181, str2, c11592d4.f53768a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            }
            i14++;
            cls5 = cls2;
        }
        c9844i.mo61185e(177);
        c9844i.mo61186f(4, 4);
        c9844i.mo61190j();
        if (interfaceC9643d2 != null) {
            for (EnumC10653e1 enumC10653e1 : interfaceC9643d2.serialzeFeatures()) {
                if (enumC10653e1 == EnumC10653e1.DisableCircularReferenceDetect) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        int i15 = 0;
        while (true) {
            cls = cls4;
            c11592dArr = c11592dArr2;
            if (i15 >= 3) {
                break;
            }
            if (i15 == 0) {
                str6 = "write";
                z14 = z10;
                z13 = true;
            } else if (i15 == 1) {
                str6 = "writeNormal";
                z14 = z10;
                z13 = false;
            } else {
                str6 = "writeDirectNonContext";
                z13 = true;
                z14 = true;
            }
            C9838c c9838c3 = c9838c2;
            String str9 = str8;
            String str10 = str2;
            a aVar = new a(c11592dArr3, c10698z0, str2, z13, z14);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("(L");
            String str11 = f51113c;
            sb4.append(str11);
            sb4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            int i16 = i15;
            C9844i c9844i2 = new C9844i(c9838c2, 1, str6, sb4.toString(), null, new String[]{"java/io/IOException"});
            C9841f c9841f = new C9841f();
            c9844i2.mo61187g(25, 2);
            c9844i2.mo61188h(CreativeType.SPLASH_TEMPLATE_AD, c9841f);
            c9844i2.mo61187g(25, 1);
            c9844i2.mo61189i(182, str11, "writeNull", "()V");
            c9844i2.mo61185e(177);
            c9844i2.mo61192l(c9841f);
            c9844i2.mo61187g(25, 1);
            c9844i2.mo61183c(180, str11, "out", f51117g);
            c9844i2.mo61187g(58, aVar.m65173g("out"));
            if (z16 || aVar.f51130d || !(interfaceC9643d2 == null || interfaceC9643d2.alphabetic())) {
                interfaceC9643d = interfaceC9643d2;
                str2 = str10;
            } else {
                C9841f c9841f2 = new C9841f();
                c9844i2.mo61187g(25, aVar.m65173g("out"));
                interfaceC9643d = interfaceC9643d2;
                c9844i2.mo61189i(182, f51116f, "isSortField", "()Z");
                c9844i2.mo61188h(154, c9841f2);
                c9844i2.mo61187g(25, 0);
                c9844i2.mo61187g(25, 1);
                c9844i2.mo61187g(25, 2);
                c9844i2.mo61187g(25, 3);
                c9844i2.mo61187g(25, 4);
                c9844i2.mo61187g(21, 5);
                str2 = str10;
                c9844i2.mo61189i(182, str2, "writeUnsorted", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                c9844i2.mo61185e(177);
                c9844i2.mo61192l(c9841f2);
            }
            if (!aVar.f51130d || z14) {
                i10 = i16;
                z15 = z16;
                i11 = 177;
                c10 = 4;
            } else {
                C9841f c9841f3 = new C9841f();
                C9841f c9841f4 = new C9841f();
                c9844i2.mo61187g(25, 0);
                c9844i2.mo61187g(25, 1);
                String str12 = f51118h;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("(L");
                sb5.append(str11);
                z15 = z16;
                sb5.append(";)Z");
                i10 = i16;
                c9844i2.mo61189i(182, str12, "writeDirect", sb5.toString());
                c9844i2.mo61188h(154, c9841f4);
                c9844i2.mo61187g(25, 0);
                c9844i2.mo61187g(25, 1);
                c9844i2.mo61187g(25, 2);
                c9844i2.mo61187g(25, 3);
                c9844i2.mo61187g(25, 4);
                c9844i2.mo61187g(21, 5);
                c9844i2.mo61189i(182, str2, "writeNormal", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                c9844i2.mo61185e(177);
                c9844i2.mo61192l(c9841f4);
                c9844i2.mo61187g(25, aVar.m65173g("out"));
                c9844i2.mo61191k(Integer.valueOf(EnumC10653e1.DisableCircularReferenceDetect.f51248a));
                c9844i2.mo61189i(182, f51116f, "isEnabled", "(I)Z");
                c9844i2.mo61188h(153, c9841f3);
                c9844i2.mo61187g(25, 0);
                c9844i2.mo61187g(25, 1);
                c9844i2.mo61187g(25, 2);
                c9844i2.mo61187g(25, 3);
                c10 = 4;
                c9844i2.mo61187g(25, 4);
                c9844i2.mo61187g(21, 5);
                c9844i2.mo61189i(182, str2, "writeDirectNonContext", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                i11 = 177;
                c9844i2.mo61185e(177);
                c9844i2.mo61192l(c9841f3);
            }
            c9844i2.mo61187g(25, 2);
            c9844i2.mo61182b(192, C11590b.m69190g(cls3));
            c9844i2.mo61187g(58, aVar.m65173g("entity"));
            m65140B(cls3, c9844i2, c11592dArr3, aVar);
            c9844i2.mo61185e(i11);
            c9844i2.mo61186f(7, aVar.f51132f + 2);
            c9844i2.mo61190j();
            i15 = i10 + 1;
            interfaceC9643d2 = interfaceC9643d;
            z16 = z15;
            cls4 = cls;
            c11592dArr2 = c11592dArr;
            c9838c2 = c9838c3;
            str8 = str9;
        }
        C9838c c9838c4 = c9838c2;
        String str13 = str8;
        if (z16) {
            str3 = str2;
            str4 = "entity";
        } else {
            str3 = str2;
            a aVar2 = new a(c11592dArr3, c10698z0, str2, false, z10);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("(L");
            String str14 = f51113c;
            sb6.append(str14);
            sb6.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            str4 = "entity";
            C9844i c9844i3 = new C9844i(c9838c4, 1, "writeUnsorted", sb6.toString(), null, new String[]{"java/io/IOException"});
            c9844i3.mo61187g(25, 1);
            c9844i3.mo61183c(180, str14, "out", f51117g);
            c9844i3.mo61187g(58, aVar2.m65173g("out"));
            c9844i3.mo61187g(25, 2);
            c9844i3.mo61182b(192, C11590b.m69190g(cls3));
            c9844i3.mo61187g(58, aVar2.m65173g(str4));
            m65140B(cls3, c9844i3, c11592dArr, aVar2);
            c9844i3.mo61185e(177);
            c9844i3.mo61186f(7, aVar2.f51132f + 2);
            c9844i3.mo61190j();
        }
        int i17 = 3;
        for (int i18 = 0; i18 < i17; i18++) {
            if (i18 == 0) {
                str5 = "writeAsArray";
                z12 = z10;
                z11 = true;
            } else if (i18 == 1) {
                str5 = "writeAsArrayNormal";
                z12 = z10;
                z11 = false;
            } else {
                str5 = "writeAsArrayNonContext";
                z11 = true;
                z12 = true;
            }
            String str15 = str4;
            a aVar3 = new a(c11592dArr3, c10698z0, str3, z11, z12);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("(L");
            String str16 = f51113c;
            sb7.append(str16);
            sb7.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            C9844i c9844i4 = new C9844i(c9838c4, 1, str5, sb7.toString(), null, new String[]{"java/io/IOException"});
            c9844i4.mo61187g(25, 1);
            c9844i4.mo61183c(180, str16, "out", f51117g);
            c9844i4.mo61187g(58, aVar3.m65173g("out"));
            c9844i4.mo61187g(25, 2);
            c9844i4.mo61182b(192, C11590b.m69190g(cls3));
            c9844i4.mo61187g(58, aVar3.m65173g(str15));
            m65139A(cls3, c9844i4, c11592dArr3, aVar3);
            c9844i4.mo61185e(177);
            c9844i4.mo61186f(7, aVar3.f51132f + 2);
            c9844i4.mo61190j();
            str4 = str15;
            i17 = i17;
        }
        byte[] bArrM61168j = c9838c4.m61168j();
        return (C10666j0) this.f51122a.m69182a(str13, bArrM61168j, 0, bArrM61168j.length).getConstructor(cls).newInstance(c10698z0);
    }
}
