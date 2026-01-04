package p323h1;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;
import p244e1.AbstractC9377a;
import p244e1.C9378b;
import p244e1.C9380d;
import p244e1.C9381e;
import p244e1.C9382f;
import p244e1.C9383g;
import p244e1.C9390n;
import p244e1.EnumC9389m;
import p274f1.InterfaceC9640a;
import p274f1.InterfaceC9641b;
import p274f1.InterfaceC9643d;
import p354i1.AbstractC10400l;
import p354i1.C10386a;
import p354i1.C10387a0;
import p354i1.C10389b0;
import p354i1.C10390c;
import p354i1.C10391c0;
import p354i1.C10394f;
import p354i1.C10395g;
import p354i1.C10396h;
import p354i1.C10402n;
import p354i1.C10403o;
import p354i1.C10404p;
import p354i1.C10405q;
import p354i1.C10406r;
import p354i1.C10407s;
import p354i1.C10409u;
import p354i1.C10412x;
import p354i1.C10414z;
import p354i1.InterfaceC10392d;
import p354i1.InterfaceC10408t;
import p354i1.InterfaceC10411w;
import p381j1.C10643b0;
import p381j1.C10646c0;
import p381j1.C10649d0;
import p381j1.C10656f1;
import p381j1.C10657g;
import p381j1.C10663i;
import p381j1.C10668k0;
import p381j1.C10669l;
import p381j1.C10671m;
import p381j1.C10673n;
import p381j1.C10675o;
import p381j1.C10676o0;
import p381j1.C10677p;
import p381j1.C10679q;
import p381j1.C10680q0;
import p381j1.C10681r;
import p381j1.C10684s0;
import p381j1.C10685t;
import p381j1.C10691w;
import p381j1.C10694x0;
import p414k1.InterfaceC10971a;
import p440l1.C11221a;
import p481n1.C11589a;
import p481n1.C11590b;
import p481n1.C11592d;
import p481n1.C11595g;
import p481n1.C11596h;
import p481n1.C11597i;
import p481n1.C11598j;
import p481n1.C11599k;
import p481n1.C11602n;
import p481n1.C11603o;
import p481n1.InterfaceC11593e;

/* renamed from: h1.i */
/* loaded from: classes.dex */
public class C10085i {

    /* renamed from: A */
    public static boolean f49228A;

    /* renamed from: B */
    public static boolean f49229B;

    /* renamed from: C */
    public static boolean f49230C;

    /* renamed from: D */
    public static boolean f49231D;

    /* renamed from: E */
    public static InterfaceC11593e<Class<?>, Boolean> f49232E;

    /* renamed from: v */
    public static final String[] f49235v;

    /* renamed from: y */
    public static final long[] f49238y;

    /* renamed from: z */
    public static C10085i f49239z;

    /* renamed from: a */
    public final C11596h<Type, InterfaceC10408t> f49240a;

    /* renamed from: b */
    public final C11596h<Type, C11596h<Type, InterfaceC10408t>> f49241b;

    /* renamed from: c */
    public final ConcurrentMap<String, Class<?>> f49242c;

    /* renamed from: d */
    public boolean f49243d;

    /* renamed from: e */
    public final C10086j f49244e;

    /* renamed from: f */
    public EnumC9389m f49245f;

    /* renamed from: g */
    public ClassLoader f49246g;

    /* renamed from: h */
    public C10386a f49247h;

    /* renamed from: i */
    public boolean f49248i;

    /* renamed from: j */
    public long[] f49249j;

    /* renamed from: k */
    public long[] f49250k;

    /* renamed from: l */
    public long[] f49251l;

    /* renamed from: m */
    public final boolean f49252m;

    /* renamed from: n */
    public boolean f49253n;

    /* renamed from: o */
    public boolean f49254o;

    /* renamed from: p */
    public List<InterfaceC10971a> f49255p;

    /* renamed from: q */
    public volatile List<c> f49256q;

    /* renamed from: r */
    public boolean f49257r;

    /* renamed from: s */
    public final Callable<Void> f49258s;

    /* renamed from: t */
    public static final String[] f49233t = m62845B(C11595g.m69213h("fastjson.parser.deny.internal"));

    /* renamed from: u */
    public static final String[] f49234u = m62845B(C11595g.m69213h("fastjson.parser.deny"));

    /* renamed from: w */
    public static final boolean f49236w = FaqConstants.DISABLE_HA_REPORT.equals(C11595g.m69213h("fastjson.parser.autoTypeSupport"));

    /* renamed from: x */
    public static final boolean f49237x = FaqConstants.DISABLE_HA_REPORT.equals(C11595g.m69213h("fastjson.parser.safeMode"));

    /* renamed from: h1.i$a */
    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            C10085i.this.f49240a.m69221c(Timestamp.class, C10414z.f50244c);
            C10085i.this.f49240a.m69221c(Date.class, C10414z.f50243b);
            C10085i.this.f49240a.m69221c(Time.class, C10391c0.f50189a);
            C10085i.this.f49240a.m69221c(java.util.Date.class, C10691w.f51326a);
            return null;
        }
    }

    /* renamed from: h1.i$b */
    public static class b implements InterfaceC11593e<Class<?>, Boolean> {
        @Override // p481n1.InterfaceC11593e
        /* renamed from: a */
        public Boolean apply(Class<?> cls) {
            return Boolean.valueOf(cls == Date.class || cls == Time.class || cls == Timestamp.class);
        }
    }

    /* renamed from: h1.i$c */
    public interface c {
        /* renamed from: a */
        Class<?> m62875a(String str, Class<?> cls, int i10);
    }

    static {
        String[] strArrM62845B = m62845B(C11595g.m69213h("fastjson.parser.autoTypeAccept"));
        if (strArrM62845B == null) {
            strArrM62845B = new String[0];
        }
        f49235v = strArrM62845B;
        f49238y = new long[]{-6976602508726000783L, -6293031534589903644L, 59775428743665658L, 7267793227937552092L};
        f49239z = new C10085i();
        f49228A = false;
        f49229B = false;
        f49230C = false;
        f49231D = false;
        f49232E = new b();
    }

    public C10085i() {
        this(false);
    }

    /* renamed from: B */
    public static String[] m62845B(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(",");
    }

    /* renamed from: q */
    public static Method m62847q(Class cls, Class cls2) throws SecurityException {
        for (Method method : cls.getMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getReturnType() == cls2 && method.getParameterTypes().length == 1 && ((InterfaceC9640a) method.getAnnotation(InterfaceC9640a.class)) != null) {
                return method;
            }
        }
        return null;
    }

    /* renamed from: s */
    public static Field m62848s(String str, Map<String, Field> map) {
        Field field = map.get(str);
        if (field == null) {
            field = map.get("_" + str);
        }
        if (field == null) {
            field = map.get("m_" + str);
        }
        if (field != null) {
            return field;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            field = map.get(new String(charArray));
        }
        if (str.length() <= 2) {
            return field;
        }
        char cCharAt2 = str.charAt(1);
        if (cCharAt < 'a' || cCharAt > 'z' || cCharAt2 < 'A' || cCharAt2 > 'Z') {
            return field;
        }
        for (Map.Entry<String, Field> entry : map.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return field;
    }

    /* renamed from: t */
    public static C10085i m62849t() {
        return f49239z;
    }

    /* renamed from: w */
    public static boolean m62850w(Class<?> cls) {
        boolean z10 = cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls.isEnum();
        Boolean boolValueOf = Boolean.valueOf(z10);
        if (!z10) {
            boolValueOf = (Boolean) C11598j.m69234c(f49232E, cls);
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    /* renamed from: y */
    public static void m62851y(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
            return;
        }
        m62851y(cls.getSuperclass(), map);
    }

    /* renamed from: A */
    public void m62852A(boolean z10) {
        this.f49243d = z10;
    }

    /* renamed from: b */
    public void m62853b(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long jM69257I = C11603o.m69257I(str);
        if (Arrays.binarySearch(this.f49251l, jM69257I) >= 0) {
            return;
        }
        long[] jArr = this.f49251l;
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        jArr2[length] = jM69257I;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.f49251l = jArr2;
    }

    /* renamed from: c */
    public void m62854c(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long jM69257I = C11603o.m69257I(str);
        if (Arrays.binarySearch(this.f49250k, jM69257I) >= 0) {
            return;
        }
        long[] jArr = this.f49250k;
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        jArr2[length] = jM69257I;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.f49250k = jArr2;
    }

    /* renamed from: d */
    public void m62855d(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long jM69257I = C11603o.m69257I(str);
        long[] jArr = this.f49249j;
        if (jArr == null) {
            this.f49249j = new long[]{jM69257I};
            return;
        }
        if (Arrays.binarySearch(jArr, jM69257I) >= 0) {
            return;
        }
        long[] jArr2 = this.f49249j;
        int length = jArr2.length;
        long[] jArr3 = new long[1 + length];
        jArr3[length] = jM69257I;
        System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
        Arrays.sort(jArr3);
        this.f49249j = jArr3;
    }

    /* renamed from: e */
    public final void m62856e(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            m62853b(str);
        }
    }

    /* renamed from: f */
    public final void m62857f(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            m62854c(str);
        }
    }

    /* renamed from: g */
    public final void m62858g(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            m62855d(str);
        }
    }

    /* renamed from: h */
    public Class<?> m62859h(Class cls) {
        return m62864m(cls) != null ? cls : m62861j(cls.getName(), null, AbstractC9377a.f46783f);
    }

    /* renamed from: i */
    public Class<?> m62860i(String str, Class<?> cls) {
        return m62861j(str, cls, AbstractC9377a.f46783f);
    }

    /* JADX WARN: Removed duplicated region for block: B:287:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0311 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x03cf  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Class<?> m62861j(java.lang.String r25, java.lang.Class<?> r26, int r27) {
        /*
            Method dump skipped, instructions count: 1069
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p323h1.C10085i.m62861j(java.lang.String, java.lang.Class, int):java.lang.Class");
    }

    /* renamed from: k */
    public AbstractC10400l m62862k(C10085i c10085i, C11597i c11597i, C11592d c11592d) {
        Class<?> clsDeserializeUsing;
        Class<?> cls = c11597i.f53814a;
        Class<?> cls2 = c11592d.f53772e;
        InterfaceC9641b interfaceC9641bM69199f = c11592d.m69199f();
        Class<?> cls3 = null;
        if (interfaceC9641bM69199f != null && (clsDeserializeUsing = interfaceC9641bM69199f.deserializeUsing()) != Void.class) {
            cls3 = clsDeserializeUsing;
        }
        return (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) ? new C10390c(c10085i, cls, c11592d) : new C10394f(c10085i, cls, c11592d);
    }

    /* renamed from: l */
    public InterfaceC10408t m62863l(Class<?> cls, Type type) {
        InterfaceC9641b interfaceC9641bM69199f;
        Method method;
        C10386a c10386a;
        boolean zM69184a = this.f49243d & (!this.f49252m);
        if (zM69184a) {
            InterfaceC9643d interfaceC9643d = (InterfaceC9643d) C11603o.m69265M(cls, InterfaceC9643d.class);
            if (interfaceC9643d != null) {
                Class<?> clsDeserializer = interfaceC9643d.deserializer();
                if (clsDeserializer != Void.class) {
                    try {
                        Object objNewInstance = clsDeserializer.newInstance();
                        if (objNewInstance instanceof InterfaceC10408t) {
                            return (InterfaceC10408t) objNewInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                zM69184a = interfaceC9643d.asm() && interfaceC9643d.parseFeatures().length == 0;
            }
            if (zM69184a) {
                Class<?> clsM69227f = C11597i.m69227f(cls, interfaceC9643d);
                if (clsM69227f == null) {
                    clsM69227f = cls;
                }
                while (true) {
                    if (!Modifier.isPublic(clsM69227f.getModifiers())) {
                        zM69184a = false;
                        break;
                    }
                    clsM69227f = clsM69227f.getSuperclass();
                    if (clsM69227f == Object.class || clsM69227f == null) {
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            zM69184a = false;
        }
        if (zM69184a && (c10386a = this.f49247h) != null && c10386a.f50177a.m69183c(cls)) {
            zM69184a = false;
        }
        if (zM69184a) {
            zM69184a = C11590b.m69184a(cls.getSimpleName());
        }
        if (zM69184a) {
            if (cls.isInterface()) {
                zM69184a = false;
            }
            C11597i c11597iM69224c = C11597i.m69224c(cls, type, this.f49245f, false, C11603o.f53866b, this.f49253n);
            if (zM69184a && c11597iM69224c.f53821h.length > 200) {
                zM69184a = false;
            }
            Constructor<?> constructor = c11597iM69224c.f53816c;
            if (zM69184a && constructor == null && !cls.isInterface()) {
                zM69184a = false;
            }
            for (C11592d c11592d : c11597iM69224c.f53821h) {
                if (!c11592d.f53775h) {
                    Class<?> cls2 = c11592d.f53772e;
                    if (Modifier.isPublic(cls2.getModifiers()) && ((!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) && ((c11592d.m69202t() == null || C11590b.m69184a(c11592d.m69202t().getName())) && (((interfaceC9641bM69199f = c11592d.m69199f()) == null || (C11590b.m69184a(interfaceC9641bM69199f.name()) && interfaceC9641bM69199f.format().length() == 0 && interfaceC9641bM69199f.deserializeUsing() == Void.class && interfaceC9641bM69199f.parseFeatures().length == 0 && !interfaceC9641bM69199f.unwrapped())) && (((method = c11592d.f53769b) == null || method.getParameterTypes().length <= 1) && (!cls2.isEnum() || (m62867p(cls2) instanceof C10396h))))))) {
                    }
                }
                zM69184a = false;
                break;
            }
        }
        boolean z10 = (zM69184a && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) ? false : zM69184a;
        if ((z10 && C11603o.m69331y0(cls)) || !z10) {
            return new C10403o(this, cls, type);
        }
        C11597i c11597iM69223b = C11597i.m69223b(cls, type, this.f49245f);
        try {
            return this.f49247h.m63875v(this, c11597iM69223b);
        } catch (C9380d unused2) {
            return new C10403o(this, c11597iM69223b);
        } catch (NoSuchMethodException unused3) {
            return new C10403o(this, cls, type);
        } catch (Exception e10) {
            throw new C9380d("create asm deserializer error, " + cls.getName(), e10);
        }
    }

    /* renamed from: m */
    public InterfaceC10408t m62864m(Type type) {
        Type typeM58761f = AbstractC9377a.m58761f(type);
        if (typeM58761f == null) {
            return this.f49240a.m69220b(type);
        }
        C11596h<Type, InterfaceC10408t> c11596hM69220b = this.f49241b.m69220b(type);
        if (c11596hM69220b == null) {
            return null;
        }
        return c11596hM69220b.m69220b(typeM58761f);
    }

    /* renamed from: n */
    public ClassLoader m62865n() {
        return this.f49246g;
    }

    /* renamed from: o */
    public InterfaceC10408t m62866o(Class<?> cls, Type type) {
        InterfaceC10408t interfaceC10408tM62863l;
        InterfaceC10408t c10412x;
        Method methodM62847q;
        Class<?> clsMappingTo;
        Type type2 = type;
        InterfaceC10408t interfaceC10408tM62864m = m62864m(type2);
        if (interfaceC10408tM62864m == null && (type2 instanceof C11599k)) {
            interfaceC10408tM62864m = m62864m(C9390n.m58849b((C11599k) type2));
        }
        if (interfaceC10408tM62864m != null) {
            return interfaceC10408tM62864m;
        }
        if (type2 == null) {
            type2 = cls;
        }
        InterfaceC10408t interfaceC10408tM62864m2 = m62864m(type2);
        if (interfaceC10408tM62864m2 != null) {
            return interfaceC10408tM62864m2;
        }
        InterfaceC9643d interfaceC9643d = (InterfaceC9643d) C11603o.m69265M(cls, InterfaceC9643d.class);
        if (interfaceC9643d != null && (clsMappingTo = interfaceC9643d.mappingTo()) != Void.class) {
            return m62866o(clsMappingTo, clsMappingTo);
        }
        if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable) || (type2 instanceof ParameterizedType)) {
            interfaceC10408tM62864m2 = m62864m(cls);
        }
        if (interfaceC10408tM62864m2 != null) {
            return interfaceC10408tM62864m2;
        }
        Iterator<InterfaceC10971a> it = this.f49255p.iterator();
        while (it.hasNext()) {
            interfaceC10408tM62864m2 = it.next().m66295a(this, cls);
            if (interfaceC10408tM62864m2 != null) {
                m62872z(type2, interfaceC10408tM62864m2);
                return interfaceC10408tM62864m2;
            }
        }
        String strReplace = cls.getName().replace('$', '.');
        if (strReplace.startsWith("java.awt.") && C10663i.m65249k(cls) && !f49228A) {
            String[] strArr = {"java.awt.Point", "java.awt.Font", "java.awt.Rectangle", "java.awt.Color"};
            for (int i10 = 0; i10 < 4; i10++) {
                try {
                    String str = strArr[i10];
                    if (str.equals(strReplace)) {
                        Type cls2 = Class.forName(str);
                        InterfaceC10408t interfaceC10408t = C10663i.f51256a;
                        m62872z(cls2, interfaceC10408t);
                        return interfaceC10408t;
                    }
                } catch (Throwable unused) {
                    f49228A = true;
                }
            }
            interfaceC10408tM62864m2 = C10663i.f51256a;
        }
        if (!f49229B) {
            try {
                if (strReplace.startsWith("java.time.")) {
                    String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.ZoneId", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                    int i11 = 0;
                    for (int i12 = 12; i11 < i12; i12 = 12) {
                        String str2 = strArr2[i11];
                        if (str2.equals(strReplace)) {
                            Type cls3 = Class.forName(str2);
                            InterfaceC10408t interfaceC10408t2 = C10405q.f50212a;
                            m62872z(cls3, interfaceC10408t2);
                            return interfaceC10408t2;
                        }
                        i11++;
                    }
                } else if (strReplace.startsWith("java.util.Optional")) {
                    String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                    for (int i13 = 0; i13 < 4; i13++) {
                        String str3 = strArr3[i13];
                        if (str3.equals(strReplace)) {
                            Type cls4 = Class.forName(str3);
                            InterfaceC10408t interfaceC10408t3 = C10409u.f50235a;
                            m62872z(cls4, interfaceC10408t3);
                            return interfaceC10408t3;
                        }
                    }
                }
            } catch (Throwable unused2) {
                f49229B = true;
            }
        }
        if (!f49230C) {
            try {
                if (strReplace.startsWith("org.joda.time.")) {
                    String[] strArr4 = {"org.joda.time.DateTime", "org.joda.time.LocalDate", "org.joda.time.LocalDateTime", "org.joda.time.LocalTime", "org.joda.time.Instant", "org.joda.time.Period", "org.joda.time.Duration", "org.joda.time.DateTimeZone", "org.joda.time.format.DateTimeFormatter"};
                    for (int i14 = 0; i14 < 9; i14++) {
                        String str4 = strArr4[i14];
                        if (str4.equals(strReplace)) {
                            Type cls5 = Class.forName(str4);
                            interfaceC10408tM62864m2 = C10668k0.f51279a;
                            m62872z(cls5, interfaceC10408tM62864m2);
                            return interfaceC10408tM62864m2;
                        }
                    }
                }
            } catch (Throwable unused3) {
                f49230C = true;
            }
        }
        if (!f49231D && strReplace.startsWith("com.google.common.collect.")) {
            try {
                String[] strArr5 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.LinkedHashMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};
                for (int i15 = 0; i15 < 5; i15++) {
                    String str5 = strArr5[i15];
                    if (str5.equals(strReplace)) {
                        Type cls6 = Class.forName(str5);
                        interfaceC10408tM62864m2 = C10646c0.f51173a;
                        m62872z(cls6, interfaceC10408tM62864m2);
                        return interfaceC10408tM62864m2;
                    }
                }
            } catch (ClassNotFoundException unused4) {
                f49231D = true;
            }
        }
        if (strReplace.equals("java.nio.ByteBuffer")) {
            interfaceC10408tM62864m2 = C10675o.f51308a;
            m62872z(cls, interfaceC10408tM62864m2);
        }
        if (strReplace.equals("java.nio.file.Path")) {
            interfaceC10408tM62864m2 = C10680q0.f51318b;
            m62872z(cls, interfaceC10408tM62864m2);
        }
        if (cls == Map.Entry.class) {
            interfaceC10408tM62864m2 = C10680q0.f51318b;
            m62872z(cls, interfaceC10408tM62864m2);
        }
        if (strReplace.equals("org.javamoney.moneta.Money")) {
            interfaceC10408tM62864m2 = C11221a.f52708a;
            m62872z(cls, interfaceC10408tM62864m2);
        }
        try {
            for (InterfaceC10392d interfaceC10392d : C11602n.m69239a(InterfaceC10392d.class, Thread.currentThread().getContextClassLoader())) {
                Iterator<Type> it2 = interfaceC10392d.m63899a().iterator();
                while (it2.hasNext()) {
                    m62872z(it2.next(), interfaceC10392d);
                }
            }
        } catch (Exception unused5) {
        }
        if (interfaceC10408tM62864m2 == null) {
            interfaceC10408tM62864m2 = m62864m(type2);
        }
        if (interfaceC10408tM62864m2 != null) {
            return interfaceC10408tM62864m2;
        }
        if (cls.isEnum()) {
            if (this.f49253n) {
                for (Method method : cls.getMethods()) {
                    if (C11603o.m69317r0(method)) {
                        InterfaceC10408t interfaceC10408tM62863l2 = m62863l(cls, type2);
                        m62872z(type2, interfaceC10408tM62863l2);
                        return interfaceC10408tM62863l2;
                    }
                }
            }
            Class<?> cls7 = (Class) AbstractC9377a.m58761f(cls);
            InterfaceC9643d interfaceC9643d2 = (InterfaceC9643d) C11603o.m69265M(cls7 != null ? cls7 : cls, InterfaceC9643d.class);
            if (interfaceC9643d2 != null) {
                try {
                    InterfaceC10408t interfaceC10408t4 = (InterfaceC10408t) interfaceC9643d2.deserializer().newInstance();
                    m62872z(cls, interfaceC10408t4);
                    return interfaceC10408t4;
                } catch (Throwable unused6) {
                }
            }
            if (cls7 != null) {
                Method methodM62847q2 = m62847q(cls7, cls);
                if (methodM62847q2 != null) {
                    try {
                        methodM62847q = cls.getMethod(methodM62847q2.getName(), methodM62847q2.getParameterTypes());
                    } catch (Exception unused7) {
                    }
                } else {
                    methodM62847q = null;
                }
            } else {
                methodM62847q = m62847q(cls, cls);
            }
            if (methodM62847q != null) {
                InterfaceC10408t c10395g = new C10395g(methodM62847q);
                m62872z(cls, c10395g);
                return c10395g;
            }
            interfaceC10408tM62863l = m62868r(cls);
        } else if (cls.isArray()) {
            interfaceC10408tM62863l = C10684s0.f51323a;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) {
            interfaceC10408tM62863l = C10685t.f51324a;
        } else if (Map.class.isAssignableFrom(cls)) {
            interfaceC10408tM62863l = C10406r.f50233a;
        } else {
            if (Throwable.class.isAssignableFrom(cls)) {
                c10412x = new C10389b0(this, cls);
            } else if (InterfaceC10411w.class.isAssignableFrom(cls)) {
                c10412x = new C10412x(cls);
            } else {
                interfaceC10408tM62863l = cls == InetAddress.class ? C10680q0.f51318b : m62863l(cls, type2);
            }
            interfaceC10408tM62863l = c10412x;
        }
        m62872z(type2, interfaceC10408tM62863l);
        return interfaceC10408tM62863l;
    }

    /* renamed from: p */
    public InterfaceC10408t m62867p(Type type) {
        InterfaceC10408t interfaceC10408tM62864m = m62864m(type);
        if (interfaceC10408tM62864m != null) {
            return interfaceC10408tM62864m;
        }
        if (type instanceof Class) {
            return m62866o((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            return rawType instanceof Class ? m62866o((Class) rawType, type) : m62867p(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return m62867p(upperBounds[0]);
            }
        }
        return C10404p.f50211a;
    }

    /* renamed from: r */
    public InterfaceC10408t m62868r(Class<?> cls) {
        return new C10396h(cls);
    }

    /* renamed from: u */
    public final void m62869u() {
        C11596h<Type, InterfaceC10408t> c11596h = this.f49240a;
        C10680q0 c10680q0 = C10680q0.f51318b;
        c11596h.m69221c(SimpleDateFormat.class, c10680q0);
        C11596h<Type, InterfaceC10408t> c11596h2 = this.f49240a;
        C10677p c10677p = C10677p.f51313b;
        c11596h2.m69221c(Calendar.class, c10677p);
        this.f49240a.m69221c(XMLGregorianCalendar.class, c10677p);
        this.f49240a.m69221c(C9381e.class, C10406r.f50233a);
        C11596h<Type, InterfaceC10408t> c11596h3 = this.f49240a;
        C10685t c10685t = C10685t.f51324a;
        c11596h3.m69221c(C9378b.class, c10685t);
        this.f49240a.m69221c(Map.class, C10406r.f50233a);
        this.f49240a.m69221c(HashMap.class, C10406r.f50233a);
        this.f49240a.m69221c(LinkedHashMap.class, C10406r.f50233a);
        this.f49240a.m69221c(TreeMap.class, C10406r.f50233a);
        this.f49240a.m69221c(ConcurrentMap.class, C10406r.f50233a);
        this.f49240a.m69221c(ConcurrentHashMap.class, C10406r.f50233a);
        this.f49240a.m69221c(Collection.class, c10685t);
        this.f49240a.m69221c(List.class, c10685t);
        this.f49240a.m69221c(ArrayList.class, c10685t);
        C11596h<Type, InterfaceC10408t> c11596h4 = this.f49240a;
        C10404p c10404p = C10404p.f50211a;
        c11596h4.m69221c(Object.class, c10404p);
        this.f49240a.m69221c(String.class, C10656f1.f51252a);
        this.f49240a.m69221c(StringBuffer.class, C10656f1.f51252a);
        this.f49240a.m69221c(StringBuilder.class, C10656f1.f51252a);
        C11596h<Type, InterfaceC10408t> c11596h5 = this.f49240a;
        Class cls = Character.TYPE;
        C10681r c10681r = C10681r.f51321a;
        c11596h5.m69221c(cls, c10681r);
        this.f49240a.m69221c(Character.class, c10681r);
        C11596h<Type, InterfaceC10408t> c11596h6 = this.f49240a;
        Class cls2 = Byte.TYPE;
        C10407s c10407s = C10407s.f50234a;
        c11596h6.m69221c(cls2, c10407s);
        this.f49240a.m69221c(Byte.class, c10407s);
        this.f49240a.m69221c(Short.TYPE, c10407s);
        this.f49240a.m69221c(Short.class, c10407s);
        this.f49240a.m69221c(Integer.TYPE, C10649d0.f51188a);
        this.f49240a.m69221c(Integer.class, C10649d0.f51188a);
        this.f49240a.m69221c(Long.TYPE, C10676o0.f51312a);
        this.f49240a.m69221c(Long.class, C10676o0.f51312a);
        this.f49240a.m69221c(BigInteger.class, C10671m.f51305c);
        this.f49240a.m69221c(BigDecimal.class, C10669l.f51302c);
        this.f49240a.m69221c(Float.TYPE, C10643b0.f51168b);
        this.f49240a.m69221c(Float.class, C10643b0.f51168b);
        this.f49240a.m69221c(Double.TYPE, c10407s);
        this.f49240a.m69221c(Double.class, c10407s);
        C11596h<Type, InterfaceC10408t> c11596h7 = this.f49240a;
        Class cls3 = Boolean.TYPE;
        C10673n c10673n = C10673n.f51306a;
        c11596h7.m69221c(cls3, c10673n);
        this.f49240a.m69221c(Boolean.class, c10673n);
        this.f49240a.m69221c(Class.class, c10680q0);
        this.f49240a.m69221c(char[].class, new C10679q());
        this.f49240a.m69221c(AtomicBoolean.class, c10673n);
        this.f49240a.m69221c(AtomicInteger.class, C10649d0.f51188a);
        this.f49240a.m69221c(AtomicLong.class, C10676o0.f51312a);
        C11596h<Type, InterfaceC10408t> c11596h8 = this.f49240a;
        C10694x0 c10694x0 = C10694x0.f51329a;
        c11596h8.m69221c(AtomicReference.class, c10694x0);
        this.f49240a.m69221c(WeakReference.class, c10694x0);
        this.f49240a.m69221c(SoftReference.class, c10694x0);
        this.f49240a.m69221c(UUID.class, c10680q0);
        this.f49240a.m69221c(TimeZone.class, c10680q0);
        this.f49240a.m69221c(Locale.class, c10680q0);
        this.f49240a.m69221c(Currency.class, c10680q0);
        this.f49240a.m69221c(Inet4Address.class, c10680q0);
        this.f49240a.m69221c(Inet6Address.class, c10680q0);
        this.f49240a.m69221c(InetSocketAddress.class, c10680q0);
        this.f49240a.m69221c(File.class, c10680q0);
        this.f49240a.m69221c(URI.class, c10680q0);
        this.f49240a.m69221c(URL.class, c10680q0);
        this.f49240a.m69221c(Pattern.class, c10680q0);
        this.f49240a.m69221c(Charset.class, c10680q0);
        this.f49240a.m69221c(C9383g.class, c10680q0);
        this.f49240a.m69221c(Number.class, c10407s);
        C11596h<Type, InterfaceC10408t> c11596h9 = this.f49240a;
        C10657g c10657g = C10657g.f51253a;
        c11596h9.m69221c(AtomicIntegerArray.class, c10657g);
        this.f49240a.m69221c(AtomicLongArray.class, c10657g);
        this.f49240a.m69221c(StackTraceElement.class, C10387a0.f50185a);
        this.f49240a.m69221c(Serializable.class, c10404p);
        this.f49240a.m69221c(Cloneable.class, c10404p);
        this.f49240a.m69221c(Comparable.class, c10404p);
        this.f49240a.m69221c(Closeable.class, c10404p);
        this.f49240a.m69221c(C9382f.class, new C10402n());
        C11598j.m69232a(this.f49258s);
    }

    /* renamed from: v */
    public boolean m62870v() {
        return this.f49253n;
    }

    /* renamed from: x */
    public boolean m62871x() {
        return this.f49257r;
    }

    /* renamed from: z */
    public void m62872z(Type type, InterfaceC10408t interfaceC10408t) {
        Type typeM58761f = AbstractC9377a.m58761f(type);
        if (typeM58761f == null) {
            this.f49240a.m69221c(type, interfaceC10408t);
            return;
        }
        C11596h<Type, InterfaceC10408t> c11596hM69220b = this.f49241b.m69220b(type);
        if (c11596hM69220b == null) {
            c11596hM69220b = new C11596h<>(4);
            this.f49241b.m69221c(type, c11596hM69220b);
        }
        c11596hM69220b.m69221c(typeM58761f, interfaceC10408t);
    }

    public C10085i(boolean z10) {
        this(null, null, z10);
    }

    public C10085i(C10386a c10386a, ClassLoader classLoader, boolean z10) {
        this.f49240a = new C11596h<>();
        this.f49241b = new C11596h<>(16);
        this.f49242c = new ConcurrentHashMap(16, 0.75f, 1);
        this.f49243d = !C11590b.f53767b;
        this.f49244e = new C10086j(4096);
        this.f49248i = f49236w;
        this.f49253n = false;
        this.f49254o = C11603o.f53866b;
        this.f49255p = new ArrayList();
        this.f49257r = f49237x;
        this.f49250k = new long[]{-9164606388214699518L, -8754006975464705441L, -8720046426850100497L, -8649961213709896794L, -8614556368991373401L, -8382625455832334425L, -8165637398350707645L, -8109300701639721088L, -7966123100503199569L, -7921218830998286408L, -7775351613326101303L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6316154655839304624L, -6179589609550493385L, -6149130139291498841L, -6149093380703242441L, -6088208984980396913L, -6025144546313590215L, -5939269048541779808L, -5885964883385605994L, -5767141746063564198L, -5764804792063216819L, -5472097725414717105L, -5194641081268104286L, -5076846148177416215L, -4837536971810737970L, -4836620931940850535L, -4733542790109620528L, -4703320437989596122L, -4608341446948126581L, -4537258998789938600L, -4438775680185074100L, -4314457471973557243L, -4150995715611818742L, -4082057040235125754L, -3975378478825053783L, -3967588558552655563L, -3935185854875733362L, -3750763034362895579L, -3319207949486691020L, -3077205613010077203L, -3053747177772160511L, -2995060141064716555L, -2825378362173150292L, -2533039401923731906L, -2439930098895578154L, -2378990704010641148L, -2364987994247679115L, -2262244760619952081L, -2192804397019347313L, -2095516571388852610L, -1872417015366588117L, -1800035667138631116L, -1650485814983027158L, -1589194880214235129L, -1363634950764737555L, -965955008570215305L, -905177026366752536L, -831789045734283466L, -803541446955902575L, -731978084025273882L, -666475508176557463L, -582813228520337988L, -254670111376247151L, -219577392946377768L, -190281065685395680L, -26639035867733124L, -9822483067882491L, 4750336058574309L, 33238344207745342L, 156405680656087946L, 218512992947536312L, 313864100207897507L, 386461436234701831L, 744602970950881621L, 823641066473609950L, 860052378298585747L, 1073634739308289776L, 1153291637701043748L, 1203232727967308606L, 1214780596910349029L, 1268707909007641340L, 1459860845934817624L, 1502845958873959152L, 1534439610567445754L, 1698504441317515818L, 1818089308493370394L, 2078113382421334967L, 2164696723069287854L, 2622551729063269307L, 2653453629929770569L, 2660670623866180977L, 2731823439467737506L, 2836431254737891113L, 2930861374593775110L, 3058452313624178956L, 3085473968517218653L, 3089451460101527857L, 3114862868117605599L, 3129395579983849527L, 3256258368248066264L, 3452379460455804429L, 3547627781654598988L, 3637939656440441093L, 3688179072722109200L, 3718352661124136681L, 3730752432285826863L, 3740226159580918099L, 3794316665763266033L, 3977090344859527316L, 4000049462512838776L, 4046190361520671643L, 4147696707147271408L, 4193204392725694463L, 4215053018660518963L, 4241163808635564644L, 4254584350247334433L, 4319304524795015394L, 4814658433570175913L, 4841947709850912914L, 4904007817188630457L, 5100336081510080343L, 5120543992130540564L, 5274044858141538265L, 5347909877633654828L, 5450448828334921485L, 5474268165959054640L, 5545425291794704408L, 5596129856135573697L, 5688200883751798389L, 5751393439502795295L, 5916409771425455946L, 5944107969236155580L, 6007332606592876737L, 6090377589998869205L, 6280357960959217660L, 6456855723474196908L, 6511035576063254270L, 6534946468240507089L, 6584624952928234050L, 6734240326434096246L, 6742705432718011780L, 6800727078373023163L, 6854854816081053523L, 7045245923763966215L, 7123326897294507060L, 7164889056054194741L, 7179336928365889465L, 7240293012336844478L, 7347653049056829645L, 7375862386996623731L, 7442624256860549330L, 7617522210483516279L, 7658177784286215602L, 8055461369741094911L, 8064026652676081192L, 8389032537095247355L, 8409640769019589119L, 8488266005336625107L, 8537233257283452655L, 8711531061028787095L, 8735538376409180149L, 8838294710098435315L, 8861402923078831179L, 9140390920032557669L, 9140416208800006522L, 9144212112462101475L};
        long[] jArr = new long[f49235v.length];
        int i10 = 0;
        while (true) {
            String[] strArr = f49235v;
            if (i10 >= strArr.length) {
                break;
            }
            jArr[i10] = C11603o.m69257I(strArr[i10]);
            i10++;
        }
        Arrays.sort(jArr);
        this.f49251l = jArr;
        this.f49258s = new a();
        this.f49252m = z10;
        if (c10386a == null && !C11590b.f53767b) {
            try {
                if (classLoader == null) {
                    c10386a = new C10386a(new C11589a());
                } else {
                    c10386a = new C10386a(classLoader);
                }
            } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
            }
        }
        this.f49247h = c10386a;
        if (c10386a == null) {
            this.f49243d = false;
        }
        m62869u();
        m62857f(f49234u);
        m62858g(f49233t);
        m62856e(f49235v);
    }
}
