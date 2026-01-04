package p630s2;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import p214d2.InterfaceC8992f;

/* renamed from: s2.l */
/* loaded from: classes.dex */
public final class C12677l {

    /* renamed from: a */
    public static final char[] f58188a = "0123456789abcdef".toCharArray();

    /* renamed from: b */
    public static final char[] f58189b = new char[64];

    /* renamed from: c */
    public static volatile Handler f58190c;

    /* renamed from: s2.l$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f58191a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f58191a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58191a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f58191a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f58191a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f58191a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: a */
    public static void m76278a() {
        if (!m76294q()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /* renamed from: b */
    public static boolean m76279b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj instanceof InterfaceC8992f ? ((InterfaceC8992f) obj).m56836a(obj2) : obj.equals(obj2);
    }

    /* renamed from: c */
    public static boolean m76280c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: d */
    public static String m76281d(byte[] bArr, char[] cArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            char[] cArr2 = f58188a;
            cArr[i11] = cArr2[(b10 & 255) >>> 4];
            cArr[i11 + 1] = cArr2[b10 & BaseType.Obj];
        }
        return new String(cArr);
    }

    /* renamed from: e */
    public static <T> Queue<T> m76282e(int i10) {
        return new ArrayDeque(i10);
    }

    /* renamed from: f */
    public static int m76283f(int i10, int i11, Bitmap.Config config) {
        return i10 * i11 * m76285h(config);
    }

    @TargetApi(19)
    /* renamed from: g */
    public static int m76284g(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + Constants.MULTIPLE_SIGN + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    /* renamed from: h */
    public static int m76285h(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i10 = a.f58191a[config.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2 || i10 == 3) {
            return 2;
        }
        return i10 != 4 ? 4 : 8;
    }

    /* renamed from: i */
    public static <T> List<T> m76286i(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t10 : collection) {
            if (t10 != null) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    public static Handler m76287j() {
        if (f58190c == null) {
            synchronized (C12677l.class) {
                try {
                    if (f58190c == null) {
                        f58190c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f58190c;
    }

    /* renamed from: k */
    public static int m76288k(float f10) {
        return m76289l(f10, 17);
    }

    /* renamed from: l */
    public static int m76289l(float f10, int i10) {
        return m76290m(Float.floatToIntBits(f10), i10);
    }

    /* renamed from: m */
    public static int m76290m(int i10, int i11) {
        return (i11 * 31) + i10;
    }

    /* renamed from: n */
    public static int m76291n(Object obj, int i10) {
        return m76290m(obj == null ? 0 : obj.hashCode(), i10);
    }

    /* renamed from: o */
    public static int m76292o(boolean z10, int i10) {
        return m76290m(z10 ? 1 : 0, i10);
    }

    /* renamed from: p */
    public static boolean m76293p() {
        return !m76294q();
    }

    /* renamed from: q */
    public static boolean m76294q() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: r */
    public static boolean m76295r(int i10) {
        return i10 > 0 || i10 == Integer.MIN_VALUE;
    }

    /* renamed from: s */
    public static boolean m76296s(int i10, int i11) {
        return m76295r(i10) && m76295r(i11);
    }

    /* renamed from: t */
    public static void m76297t(Runnable runnable) {
        m76287j().post(runnable);
    }

    /* renamed from: u */
    public static void m76298u(Runnable runnable) {
        m76287j().removeCallbacks(runnable);
    }

    /* renamed from: v */
    public static String m76299v(byte[] bArr) {
        String strM76281d;
        char[] cArr = f58189b;
        synchronized (cArr) {
            strM76281d = m76281d(bArr, cArr);
        }
        return strM76281d;
    }
}
