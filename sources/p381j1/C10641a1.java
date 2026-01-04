package p381j1;

import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p244e1.EnumC9389m;
import p274f1.InterfaceC9641b;
import p414k1.InterfaceC10971a;
import p481n1.C11590b;
import p481n1.C11596h;
import p481n1.C11603o;

/* renamed from: j1.a1 */
/* loaded from: classes.dex */
public class C10641a1 {

    /* renamed from: j */
    public static final C10641a1 f51151j = new C10641a1();

    /* renamed from: k */
    public static boolean f51152k = false;

    /* renamed from: l */
    public static boolean f51153l = false;

    /* renamed from: m */
    public static boolean f51154m = false;

    /* renamed from: n */
    public static boolean f51155n = false;

    /* renamed from: o */
    public static boolean f51156o = false;

    /* renamed from: p */
    public static boolean f51157p = false;

    /* renamed from: a */
    public boolean f51158a;

    /* renamed from: b */
    public C10639a f51159b;

    /* renamed from: c */
    public String f51160c;

    /* renamed from: d */
    public EnumC9389m f51161d;

    /* renamed from: e */
    public final C11596h<Type, InterfaceC10686t0> f51162e;

    /* renamed from: f */
    public final C11596h<Type, C11596h<Type, InterfaceC10686t0>> f51163f;

    /* renamed from: g */
    public final boolean f51164g;

    /* renamed from: h */
    public long[] f51165h;

    /* renamed from: i */
    public List<InterfaceC10971a> f51166i;

    public C10641a1() {
        this(8192);
    }

    /* renamed from: f */
    public static Member m65180f(Class cls) throws SecurityException {
        Method method = null;
        for (Method method2 : cls.getMethods()) {
            if (method2.getReturnType() != Void.class && ((InterfaceC9641b) method2.getAnnotation(InterfaceC9641b.class)) != null) {
                if (method != null) {
                    return null;
                }
                method = method2;
            }
        }
        for (Field field : cls.getFields()) {
            if (((InterfaceC9641b) field.getAnnotation(InterfaceC9641b.class)) != null) {
                if (method != null) {
                    return null;
                }
                method = field;
            }
        }
        return method;
    }

    /* renamed from: g */
    public static C10641a1 m65181g() {
        return f51151j;
    }

    /* renamed from: a */
    public final C10666j0 m65182a(C10698z0 c10698z0) throws Exception {
        C10666j0 c10666j0M65166z = this.f51159b.m65166z(c10698z0);
        int i10 = 0;
        while (true) {
            C10640a0[] c10640a0Arr = c10666j0M65166z.f51272k;
            if (i10 >= c10640a0Arr.length) {
                return c10666j0M65166z;
            }
            Class<?> cls = c10640a0Arr[i10].f51134a.f53772e;
            if (cls.isEnum() && !(m65187h(cls) instanceof C10695y)) {
                c10666j0M65166z.f51182i = false;
            }
            i10++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:303:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p381j1.InterfaceC10686t0 m65183b(p381j1.C10698z0 r15) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p381j1.C10641a1.m65183b(j1.z0):j1.t0");
    }

    /* renamed from: c */
    public final InterfaceC10686t0 m65184c(Class<?> cls) {
        String name = cls.getName();
        if (Arrays.binarySearch(this.f51165h, C11603o.m69257I(name)) < 0) {
            C10698z0 c10698z0M69288d = C11603o.m69288d(cls, null, this.f51161d, this.f51164g);
            return (c10698z0M69288d.f51341e.length == 0 && Iterable.class.isAssignableFrom(cls)) ? C10680q0.f51318b : m65183b(c10698z0M69288d);
        }
        throw new C9380d("not support class : " + name);
    }

    /* renamed from: d */
    public final InterfaceC10686t0 m65185d(Type type) {
        Type typeM58761f = AbstractC9377a.m58761f(type);
        if (typeM58761f == null) {
            return this.f51162e.m69220b(type);
        }
        C11596h<Type, InterfaceC10686t0> c11596hM69220b = this.f51163f.m69220b(type);
        if (c11596hM69220b == null) {
            return null;
        }
        return c11596hM69220b.m69220b(typeM58761f);
    }

    /* renamed from: e */
    public InterfaceC10686t0 m65186e() {
        return C10695y.f51330b;
    }

    /* renamed from: h */
    public InterfaceC10686t0 m65187h(Class<?> cls) {
        return m65188i(cls, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:601:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:657:? A[RETURN, SYNTHETIC] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p381j1.InterfaceC10686t0 m65188i(java.lang.Class<?> r21, boolean r22) throws java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 1294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p381j1.C10641a1.m65188i(java.lang.Class, boolean):j1.t0");
    }

    /* renamed from: j */
    public final void m65189j() {
        m65190k(Boolean.class, C10673n.f51306a);
        m65190k(Character.class, C10681r.f51321a);
        m65190k(Byte.class, C10649d0.f51188a);
        m65190k(Short.class, C10649d0.f51188a);
        m65190k(Integer.class, C10649d0.f51188a);
        m65190k(Long.class, C10676o0.f51312a);
        m65190k(Float.class, C10643b0.f51168b);
        m65190k(Double.class, C10693x.f51327b);
        m65190k(BigDecimal.class, C10669l.f51302c);
        m65190k(BigInteger.class, C10671m.f51305c);
        m65190k(String.class, C10656f1.f51252a);
        m65190k(byte[].class, C10688u0.f51325a);
        m65190k(short[].class, C10688u0.f51325a);
        m65190k(int[].class, C10688u0.f51325a);
        m65190k(long[].class, C10688u0.f51325a);
        m65190k(float[].class, C10688u0.f51325a);
        m65190k(double[].class, C10688u0.f51325a);
        m65190k(boolean[].class, C10688u0.f51325a);
        m65190k(char[].class, C10688u0.f51325a);
        m65190k(Object[].class, C10684s0.f51323a);
        C10680q0 c10680q0 = C10680q0.f51318b;
        m65190k(Class.class, c10680q0);
        m65190k(SimpleDateFormat.class, c10680q0);
        m65190k(Currency.class, new C10680q0());
        m65190k(TimeZone.class, c10680q0);
        m65190k(InetAddress.class, c10680q0);
        m65190k(Inet4Address.class, c10680q0);
        m65190k(Inet6Address.class, c10680q0);
        m65190k(InetSocketAddress.class, c10680q0);
        m65190k(File.class, c10680q0);
        C10651e c10651e = C10651e.f51213a;
        m65190k(Appendable.class, c10651e);
        m65190k(StringBuffer.class, c10651e);
        m65190k(StringBuilder.class, c10651e);
        C10659g1 c10659g1 = C10659g1.f51254a;
        m65190k(Charset.class, c10659g1);
        m65190k(Pattern.class, c10659g1);
        m65190k(Locale.class, c10659g1);
        m65190k(URI.class, c10659g1);
        m65190k(URL.class, c10659g1);
        m65190k(UUID.class, c10659g1);
        C10657g c10657g = C10657g.f51253a;
        m65190k(AtomicBoolean.class, c10657g);
        m65190k(AtomicInteger.class, c10657g);
        m65190k(AtomicLong.class, c10657g);
        C10694x0 c10694x0 = C10694x0.f51329a;
        m65190k(AtomicReference.class, c10694x0);
        m65190k(AtomicIntegerArray.class, c10657g);
        m65190k(AtomicLongArray.class, c10657g);
        m65190k(WeakReference.class, c10694x0);
        m65190k(SoftReference.class, c10694x0);
        m65190k(LinkedList.class, C10685t.f51324a);
    }

    /* renamed from: k */
    public boolean m65190k(Type type, InterfaceC10686t0 interfaceC10686t0) {
        Type typeM58761f = AbstractC9377a.m58761f(type);
        if (typeM58761f == null) {
            return this.f51162e.m69221c(type, interfaceC10686t0);
        }
        C11596h<Type, InterfaceC10686t0> c11596hM69220b = this.f51163f.m69220b(type);
        if (c11596hM69220b == null) {
            c11596hM69220b = new C11596h<>(4);
            this.f51163f.m69221c(type, c11596hM69220b);
        }
        return c11596hM69220b.m69221c(typeM58761f, interfaceC10686t0);
    }

    /* renamed from: l */
    public void m65191l(boolean z10) {
        if (C11590b.f53767b) {
            return;
        }
        this.f51158a = z10;
    }

    public C10641a1(int i10) {
        this(i10, false);
    }

    public C10641a1(int i10, boolean z10) {
        this.f51158a = !C11590b.f53767b;
        this.f51160c = AbstractC9377a.f46780c;
        this.f51165h = new long[]{4165360493669296979L, 4446674157046724083L};
        this.f51166i = new ArrayList();
        this.f51164g = z10;
        this.f51162e = new C11596h<>(i10);
        this.f51163f = new C11596h<>(16);
        try {
            if (this.f51158a) {
                this.f51159b = new C10639a();
            }
        } catch (Throwable unused) {
            this.f51158a = false;
        }
        m65189j();
    }
}
