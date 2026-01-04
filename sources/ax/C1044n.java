package ax;

import p692uw.C13267j;

/* renamed from: ax.n */
/* loaded from: classes9.dex */
public class C1044n extends C1043m {
    /* renamed from: b */
    public static Long m6257b(String str) {
        C13267j.m79677e(str, "<this>");
        return m6258c(str, 10);
    }

    /* renamed from: c */
    public static final Long m6258c(String str, int i10) {
        boolean z10;
        C13267j.m79677e(str, "<this>");
        C1032b.m6238a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        long j10 = -9223372036854775807L;
        if (C13267j.m79678f(cCharAt, 48) < 0) {
            z10 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j10 = Long.MIN_VALUE;
                i11 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z10 = false;
                i11 = 1;
            }
        } else {
            z10 = false;
        }
        long j11 = -256204778801521550L;
        long j12 = 0;
        long j13 = -256204778801521550L;
        while (i11 < length) {
            int iM6239b = C1032b.m6239b(str.charAt(i11), i10);
            if (iM6239b < 0) {
                return null;
            }
            if (j12 < j13) {
                if (j13 == j11) {
                    j13 = j10 / i10;
                    if (j12 < j13) {
                    }
                }
                return null;
            }
            long j14 = j12 * i10;
            long j15 = iM6239b;
            if (j14 < j10 + j15) {
                return null;
            }
            j12 = j14 - j15;
            i11++;
            j11 = -256204778801521550L;
        }
        return z10 ? Long.valueOf(j12) : Long.valueOf(-j12);
    }
}
