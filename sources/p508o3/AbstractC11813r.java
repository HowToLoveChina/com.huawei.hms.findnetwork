package p508o3;

import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* renamed from: o3.r */
/* loaded from: classes.dex */
public abstract class AbstractC11813r extends Number {

    /* renamed from: d */
    public static final ThreadLocal<int[]> f54696d = new ThreadLocal<>();

    /* renamed from: e */
    public static final Random f54697e = new Random();

    /* renamed from: f */
    public static final int f54698f = Runtime.getRuntime().availableProcessors();

    /* renamed from: g */
    public static final Unsafe f54699g;

    /* renamed from: h */
    public static final long f54700h;

    /* renamed from: i */
    public static final long f54701i;

    /* renamed from: a */
    public volatile transient b[] f54702a;

    /* renamed from: b */
    public volatile transient long f54703b;

    /* renamed from: c */
    public volatile transient int f54704c;

    /* renamed from: o3.r$a */
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
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* renamed from: o3.r$b */
    public static final class b {

        /* renamed from: b */
        public static final Unsafe f54705b;

        /* renamed from: c */
        public static final long f54706c;

        /* renamed from: a */
        public volatile long f54707a;

        static {
            try {
                Unsafe unsafeM70368h = AbstractC11813r.m70368h();
                f54705b = unsafeM70368h;
                f54706c = unsafeM70368h.objectFieldOffset(b.class.getDeclaredField(VideoPlayFlag.PLAY_IN_ALL));
            } catch (Exception e10) {
                throw new Error(e10);
            }
        }

        public b(long j10) {
            this.f54707a = j10;
        }

        /* renamed from: a */
        public final boolean m70373a(long j10, long j11) {
            return f54705b.compareAndSwapLong(this, f54706c, j10, j11);
        }
    }

    static {
        try {
            Unsafe unsafeM70368h = m70368h();
            f54699g = unsafeM70368h;
            f54700h = unsafeM70368h.objectFieldOffset(AbstractC11813r.class.getDeclaredField("b"));
            f54701i = unsafeM70368h.objectFieldOffset(AbstractC11813r.class.getDeclaredField("c"));
        } catch (Exception e10) {
            throw new Error(e10);
        }
    }

    /* renamed from: h */
    public static Unsafe m70368h() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new a());
            }
        } catch (PrivilegedActionException e10) {
            throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
        }
    }

    /* renamed from: e */
    public final boolean m70369e(long j10, long j11) {
        return f54699g.compareAndSwapLong(this, f54700h, j10, j11);
    }

    /* renamed from: f */
    public final boolean m70370f() {
        return f54699g.compareAndSwapInt(this, f54701i, 0, 1);
    }

    /* renamed from: g */
    public abstract long mo70361g(long j10, long j11);

    /* JADX WARN: Removed duplicated region for block: B:120:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f1 A[SYNTHETIC] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m70371j(long r17, int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p508o3.AbstractC11813r.m70371j(long, int[], boolean):void");
    }
}
