package p790xw;

/* renamed from: xw.n */
/* loaded from: classes9.dex */
public class C13885n extends C13884m {
    /* renamed from: a */
    public static int m83236a(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    /* renamed from: b */
    public static long m83237b(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    /* renamed from: c */
    public static int m83238c(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    /* renamed from: d */
    public static long m83239d(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    /* renamed from: e */
    public static int m83240e(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    /* renamed from: f */
    public static C13877f m83241f(int i10, int i11) {
        return C13877f.f62170d.m83220a(i10, i11, -1);
    }

    /* renamed from: g */
    public static C13879h m83242g(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? C13879h.f62178e.m83225a() : new C13879h(i10, i11 - 1);
    }
}
