package p468m3;

/* renamed from: m3.c */
/* loaded from: classes.dex */
public final class C11397c {
    /* renamed from: a */
    public static void m68304a(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: b */
    public static void m68305b(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: c */
    public static void m68306c(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalArgumentException(C11398d.m68313a(str, Integer.valueOf(i10)));
        }
    }

    /* renamed from: d */
    public static void m68307d(boolean z10, String str, int i10, int i11) {
        if (!z10) {
            throw new IllegalArgumentException(C11398d.m68313a(str, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    /* renamed from: e */
    public static void m68308e(boolean z10, String str, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(C11398d.m68313a(str, Long.valueOf(j10)));
        }
    }

    /* renamed from: f */
    public static void m68309f(boolean z10, String str, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(C11398d.m68313a(str, obj));
        }
    }

    /* renamed from: g */
    public static <T> T m68310g(T t10) {
        t10.getClass();
        return t10;
    }

    /* renamed from: h */
    public static void m68311h(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: i */
    public static void m68312i(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalStateException(C11398d.m68313a(str, Integer.valueOf(i10)));
        }
    }
}
