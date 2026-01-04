package com.google.crypto.tink.shaded.protobuf;

import com.huawei.hms.network.p129ai.C5799g0;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: com.google.crypto.tink.shaded.protobuf.s1 */
/* loaded from: classes.dex */
public final class C1952s1 {

    /* renamed from: a */
    public static final Logger f9255a = Logger.getLogger(C1952s1.class.getName());

    /* renamed from: b */
    public static final Unsafe f9256b = m12145B();

    /* renamed from: c */
    public static final Class<?> f9257c = C1905d.m11513b();

    /* renamed from: d */
    public static final boolean f9258d = m12173m(Long.TYPE);

    /* renamed from: e */
    public static final boolean f9259e = m12173m(Integer.TYPE);

    /* renamed from: f */
    public static final e f9260f = m12186z();

    /* renamed from: g */
    public static final boolean f9261g = m12160Q();

    /* renamed from: h */
    public static final boolean f9262h = m12159P();

    /* renamed from: i */
    public static final long f9263i;

    /* renamed from: j */
    public static final long f9264j;

    /* renamed from: k */
    public static final long f9265k;

    /* renamed from: l */
    public static final long f9266l;

    /* renamed from: m */
    public static final long f9267m;

    /* renamed from: n */
    public static final long f9268n;

    /* renamed from: o */
    public static final long f9269o;

    /* renamed from: p */
    public static final long f9270p;

    /* renamed from: q */
    public static final long f9271q;

    /* renamed from: r */
    public static final long f9272r;

    /* renamed from: s */
    public static final long f9273s;

    /* renamed from: t */
    public static final long f9274t;

    /* renamed from: u */
    public static final long f9275u;

    /* renamed from: v */
    public static final long f9276v;

    /* renamed from: w */
    public static final int f9277w;

    /* renamed from: x */
    public static final boolean f9278x;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.s1$a */
    public class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.s1$b */
    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: c */
        public boolean mo12188c(Object obj, long j10) {
            return C1952s1.f9278x ? C1952s1.m12177q(obj, j10) : C1952s1.m12178r(obj, j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: d */
        public byte mo12189d(Object obj, long j10) {
            return C1952s1.f9278x ? C1952s1.m12180t(obj, j10) : C1952s1.m12181u(obj, j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: e */
        public double mo12190e(Object obj, long j10) {
            return Double.longBitsToDouble(m12199h(obj, j10));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: f */
        public float mo12191f(Object obj, long j10) {
            return Float.intBitsToFloat(m12198g(obj, j10));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: k */
        public void mo12192k(Object obj, long j10, boolean z10) {
            if (C1952s1.f9278x) {
                C1952s1.m12149F(obj, j10, z10);
            } else {
                C1952s1.m12150G(obj, j10, z10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: l */
        public void mo12193l(Object obj, long j10, byte b10) {
            if (C1952s1.f9278x) {
                C1952s1.m12152I(obj, j10, b10);
            } else {
                C1952s1.m12153J(obj, j10, b10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: m */
        public void mo12194m(Object obj, long j10, double d10) {
            m12203p(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: n */
        public void mo12195n(Object obj, long j10, float f10) {
            m12202o(obj, j10, Float.floatToIntBits(f10));
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.s1$c */
    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: c */
        public boolean mo12188c(Object obj, long j10) {
            return C1952s1.f9278x ? C1952s1.m12177q(obj, j10) : C1952s1.m12178r(obj, j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: d */
        public byte mo12189d(Object obj, long j10) {
            return C1952s1.f9278x ? C1952s1.m12180t(obj, j10) : C1952s1.m12181u(obj, j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: e */
        public double mo12190e(Object obj, long j10) {
            return Double.longBitsToDouble(m12199h(obj, j10));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: f */
        public float mo12191f(Object obj, long j10) {
            return Float.intBitsToFloat(m12198g(obj, j10));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: k */
        public void mo12192k(Object obj, long j10, boolean z10) {
            if (C1952s1.f9278x) {
                C1952s1.m12149F(obj, j10, z10);
            } else {
                C1952s1.m12150G(obj, j10, z10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: l */
        public void mo12193l(Object obj, long j10, byte b10) {
            if (C1952s1.f9278x) {
                C1952s1.m12152I(obj, j10, b10);
            } else {
                C1952s1.m12153J(obj, j10, b10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: m */
        public void mo12194m(Object obj, long j10, double d10) {
            m12203p(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: n */
        public void mo12195n(Object obj, long j10, float f10) {
            m12202o(obj, j10, Float.floatToIntBits(f10));
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.s1$d */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: c */
        public boolean mo12188c(Object obj, long j10) {
            return this.f9279a.getBoolean(obj, j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: d */
        public byte mo12189d(Object obj, long j10) {
            return this.f9279a.getByte(obj, j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: e */
        public double mo12190e(Object obj, long j10) {
            return this.f9279a.getDouble(obj, j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: f */
        public float mo12191f(Object obj, long j10) {
            return this.f9279a.getFloat(obj, j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: k */
        public void mo12192k(Object obj, long j10, boolean z10) {
            this.f9279a.putBoolean(obj, j10, z10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: l */
        public void mo12193l(Object obj, long j10, byte b10) {
            this.f9279a.putByte(obj, j10, b10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: m */
        public void mo12194m(Object obj, long j10, double d10) {
            this.f9279a.putDouble(obj, j10, d10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1952s1.e
        /* renamed from: n */
        public void mo12195n(Object obj, long j10, float f10) {
            this.f9279a.putFloat(obj, j10, f10);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.s1$e */
    public static abstract class e {

        /* renamed from: a */
        public Unsafe f9279a;

        public e(Unsafe unsafe) {
            this.f9279a = unsafe;
        }

        /* renamed from: a */
        public final int m12196a(Class<?> cls) {
            return this.f9279a.arrayBaseOffset(cls);
        }

        /* renamed from: b */
        public final int m12197b(Class<?> cls) {
            return this.f9279a.arrayIndexScale(cls);
        }

        /* renamed from: c */
        public abstract boolean mo12188c(Object obj, long j10);

        /* renamed from: d */
        public abstract byte mo12189d(Object obj, long j10);

        /* renamed from: e */
        public abstract double mo12190e(Object obj, long j10);

        /* renamed from: f */
        public abstract float mo12191f(Object obj, long j10);

        /* renamed from: g */
        public final int m12198g(Object obj, long j10) {
            return this.f9279a.getInt(obj, j10);
        }

        /* renamed from: h */
        public final long m12199h(Object obj, long j10) {
            return this.f9279a.getLong(obj, j10);
        }

        /* renamed from: i */
        public final Object m12200i(Object obj, long j10) {
            return this.f9279a.getObject(obj, j10);
        }

        /* renamed from: j */
        public final long m12201j(Field field) {
            return this.f9279a.objectFieldOffset(field);
        }

        /* renamed from: k */
        public abstract void mo12192k(Object obj, long j10, boolean z10);

        /* renamed from: l */
        public abstract void mo12193l(Object obj, long j10, byte b10);

        /* renamed from: m */
        public abstract void mo12194m(Object obj, long j10, double d10);

        /* renamed from: n */
        public abstract void mo12195n(Object obj, long j10, float f10);

        /* renamed from: o */
        public final void m12202o(Object obj, long j10, int i10) {
            this.f9279a.putInt(obj, j10, i10);
        }

        /* renamed from: p */
        public final void m12203p(Object obj, long j10, long j11) {
            this.f9279a.putLong(obj, j10, j11);
        }

        /* renamed from: q */
        public final void m12204q(Object obj, long j10, Object obj2) {
            this.f9279a.putObject(obj, j10, obj2);
        }
    }

    static {
        long jM12170j = m12170j(byte[].class);
        f9263i = jM12170j;
        f9264j = m12170j(boolean[].class);
        f9265k = m12171k(boolean[].class);
        f9266l = m12170j(int[].class);
        f9267m = m12171k(int[].class);
        f9268n = m12170j(long[].class);
        f9269o = m12171k(long[].class);
        f9270p = m12170j(float[].class);
        f9271q = m12171k(float[].class);
        f9272r = m12170j(double[].class);
        f9273s = m12171k(double[].class);
        f9274t = m12170j(Object[].class);
        f9275u = m12171k(Object[].class);
        f9276v = m12175o(m12172l());
        f9277w = (int) (jM12170j & 7);
        f9278x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* renamed from: A */
    public static Object m12144A(Object obj, long j10) {
        return f9260f.m12200i(obj, j10);
    }

    /* renamed from: B */
    public static Unsafe m12145B() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: C */
    public static boolean m12146C() {
        return f9262h;
    }

    /* renamed from: D */
    public static boolean m12147D() {
        return f9261g;
    }

    /* renamed from: E */
    public static void m12148E(Object obj, long j10, boolean z10) {
        f9260f.mo12192k(obj, j10, z10);
    }

    /* renamed from: F */
    public static void m12149F(Object obj, long j10, boolean z10) {
        m12152I(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    /* renamed from: G */
    public static void m12150G(Object obj, long j10, boolean z10) {
        m12153J(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    /* renamed from: H */
    public static void m12151H(byte[] bArr, long j10, byte b10) {
        f9260f.mo12193l(bArr, f9263i + j10, b10);
    }

    /* renamed from: I */
    public static void m12152I(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int iM12184x = m12184x(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        m12156M(obj, j11, ((255 & b10) << i10) | (iM12184x & (~(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA << i10))));
    }

    /* renamed from: J */
    public static void m12153J(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        m12156M(obj, j11, ((255 & b10) << i10) | (m12184x(obj, j11) & (~(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA << i10))));
    }

    /* renamed from: K */
    public static void m12154K(Object obj, long j10, double d10) {
        f9260f.mo12194m(obj, j10, d10);
    }

    /* renamed from: L */
    public static void m12155L(Object obj, long j10, float f10) {
        f9260f.mo12195n(obj, j10, f10);
    }

    /* renamed from: M */
    public static void m12156M(Object obj, long j10, int i10) {
        f9260f.m12202o(obj, j10, i10);
    }

    /* renamed from: N */
    public static void m12157N(Object obj, long j10, long j11) {
        f9260f.m12203p(obj, j10, j11);
    }

    /* renamed from: O */
    public static void m12158O(Object obj, long j10, Object obj2) {
        f9260f.m12204q(obj, j10, obj2);
    }

    /* renamed from: P */
    public static boolean m12159P() {
        Unsafe unsafe = f9256b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (C1905d.m11514c()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th2) {
            f9255a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    /* renamed from: Q */
    public static boolean m12160Q() {
        Unsafe unsafe = f9256b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (m12172l() == null) {
                return false;
            }
            if (C1905d.m11514c()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th2) {
            f9255a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    /* renamed from: i */
    public static <T> T m12169i(Class<T> cls) {
        try {
            return (T) f9256b.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    /* renamed from: j */
    public static int m12170j(Class<?> cls) {
        if (f9262h) {
            return f9260f.m12196a(cls);
        }
        return -1;
    }

    /* renamed from: k */
    public static int m12171k(Class<?> cls) {
        if (f9262h) {
            return f9260f.m12197b(cls);
        }
        return -1;
    }

    /* renamed from: l */
    public static Field m12172l() {
        Field fieldM12174n;
        if (C1905d.m11514c() && (fieldM12174n = m12174n(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldM12174n;
        }
        Field fieldM12174n2 = m12174n(Buffer.class, C5799g0.f25867g);
        if (fieldM12174n2 == null || fieldM12174n2.getType() != Long.TYPE) {
            return null;
        }
        return fieldM12174n2;
    }

    /* renamed from: m */
    public static boolean m12173m(Class<?> cls) {
        if (!C1905d.m11514c()) {
            return false;
        }
        try {
            Class<?> cls2 = f9257c;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: n */
    public static Field m12174n(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: o */
    public static long m12175o(Field field) {
        e eVar;
        if (field == null || (eVar = f9260f) == null) {
            return -1L;
        }
        return eVar.m12201j(field);
    }

    /* renamed from: p */
    public static boolean m12176p(Object obj, long j10) {
        return f9260f.mo12188c(obj, j10);
    }

    /* renamed from: q */
    public static boolean m12177q(Object obj, long j10) {
        return m12180t(obj, j10) != 0;
    }

    /* renamed from: r */
    public static boolean m12178r(Object obj, long j10) {
        return m12181u(obj, j10) != 0;
    }

    /* renamed from: s */
    public static byte m12179s(byte[] bArr, long j10) {
        return f9260f.mo12189d(bArr, f9263i + j10);
    }

    /* renamed from: t */
    public static byte m12180t(Object obj, long j10) {
        return (byte) ((m12184x(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: u */
    public static byte m12181u(Object obj, long j10) {
        return (byte) ((m12184x(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: v */
    public static double m12182v(Object obj, long j10) {
        return f9260f.mo12190e(obj, j10);
    }

    /* renamed from: w */
    public static float m12183w(Object obj, long j10) {
        return f9260f.mo12191f(obj, j10);
    }

    /* renamed from: x */
    public static int m12184x(Object obj, long j10) {
        return f9260f.m12198g(obj, j10);
    }

    /* renamed from: y */
    public static long m12185y(Object obj, long j10) {
        return f9260f.m12199h(obj, j10);
    }

    /* renamed from: z */
    public static e m12186z() {
        Unsafe unsafe = f9256b;
        if (unsafe == null) {
            return null;
        }
        if (!C1905d.m11514c()) {
            return new d(unsafe);
        }
        if (f9258d) {
            return new c(unsafe);
        }
        if (f9259e) {
            return new b(unsafe);
        }
        return null;
    }
}
