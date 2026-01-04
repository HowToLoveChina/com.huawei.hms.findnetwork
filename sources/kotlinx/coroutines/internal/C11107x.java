package kotlinx.coroutines.internal;

import ax.C1044n;

/* renamed from: kotlinx.coroutines.internal.x */
/* loaded from: classes9.dex */
public final /* synthetic */ class C11107x {
    /* renamed from: a */
    public static final int m66812a(String str, int i10, int i11, int i12) {
        return (int) C11105v.m66805c(str, i10, i11, i12);
    }

    /* renamed from: b */
    public static final long m66813b(String str, long j10, long j11, long j12) {
        String strM66806d = C11105v.m66806d(str);
        if (strM66806d == null) {
            return j10;
        }
        Long lM6257b = C1044n.m6257b(strM66806d);
        if (lM6257b == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strM66806d + '\'').toString());
        }
        long jLongValue = lM6257b.longValue();
        if (j11 <= jLongValue && jLongValue <= j12) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j11 + ".." + j12 + ", but is '" + jLongValue + '\'').toString());
    }

    /* renamed from: c */
    public static final boolean m66814c(String str, boolean z10) {
        String strM66806d = C11105v.m66806d(str);
        return strM66806d == null ? z10 : Boolean.parseBoolean(strM66806d);
    }

    /* renamed from: d */
    public static /* synthetic */ int m66815d(String str, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 1;
        }
        if ((i13 & 8) != 0) {
            i12 = Integer.MAX_VALUE;
        }
        return C11105v.m66804b(str, i10, i11, i12);
    }

    /* renamed from: e */
    public static /* synthetic */ long m66816e(String str, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j11 = 1;
        }
        long j13 = j11;
        if ((i10 & 8) != 0) {
            j12 = Long.MAX_VALUE;
        }
        return C11105v.m66805c(str, j10, j13, j12);
    }
}
