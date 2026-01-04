package p243e0;

import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import java.io.PrintWriter;

/* renamed from: e0.k */
/* loaded from: classes.dex */
public final class C9376k {

    /* renamed from: a */
    public static final Object f46776a = new Object();

    /* renamed from: b */
    public static char[] f46777b = new char[24];

    /* renamed from: a */
    public static int m58752a(int i10, int i11, boolean z10, int i12) {
        if (i10 > 99 || (z10 && i12 >= 3)) {
            return i11 + 3;
        }
        if (i10 > 9 || (z10 && i12 >= 2)) {
            return i11 + 2;
        }
        if (z10 || i10 > 0) {
            return i11 + 1;
        }
        return 0;
    }

    /* renamed from: b */
    public static void m58753b(long j10, long j11, PrintWriter printWriter) {
        if (j10 == 0) {
            printWriter.print("--");
        } else {
            m58755d(j10 - j11, printWriter, 0);
        }
    }

    /* renamed from: c */
    public static void m58754c(long j10, PrintWriter printWriter) {
        m58755d(j10, printWriter, 0);
    }

    /* renamed from: d */
    public static void m58755d(long j10, PrintWriter printWriter, int i10) {
        synchronized (f46776a) {
            printWriter.print(new String(f46777b, 0, m58756e(j10, i10)));
        }
    }

    /* renamed from: e */
    public static int m58756e(long j10, int i10) {
        char c10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long j11 = j10;
        if (f46777b.length < i10) {
            f46777b = new char[i10];
        }
        char[] cArr = f46777b;
        if (j11 == 0) {
            int i16 = i10 - 1;
            while (i16 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j11 > 0) {
            c10 = '+';
        } else {
            j11 = -j11;
            c10 = '-';
        }
        int i17 = (int) (j11 % 1000);
        int iFloor = (int) Math.floor(j11 / 1000);
        if (iFloor > 86400) {
            i11 = iFloor / 86400;
            iFloor -= 86400 * i11;
        } else {
            i11 = 0;
        }
        if (iFloor > 3600) {
            i12 = iFloor / AsCache.TIME_HOUR;
            iFloor -= i12 * AsCache.TIME_HOUR;
        } else {
            i12 = 0;
        }
        if (iFloor > 60) {
            int i18 = iFloor / 60;
            i13 = iFloor - (i18 * 60);
            i14 = i18;
        } else {
            i13 = iFloor;
            i14 = 0;
        }
        if (i10 != 0) {
            int iM58752a = m58752a(i11, 1, false, 0);
            int iM58752a2 = iM58752a + m58752a(i12, 1, iM58752a > 0, 2);
            int iM58752a3 = iM58752a2 + m58752a(i14, 1, iM58752a2 > 0, 2);
            int iM58752a4 = iM58752a3 + m58752a(i13, 1, iM58752a3 > 0, 2);
            i15 = 0;
            for (int iM58752a5 = iM58752a4 + m58752a(i17, 2, true, iM58752a4 > 0 ? 3 : 0) + 1; iM58752a5 < i10; iM58752a5++) {
                cArr[i15] = ' ';
                i15++;
            }
        } else {
            i15 = 0;
        }
        cArr[i15] = c10;
        int i19 = i15 + 1;
        boolean z10 = i10 != 0;
        int iM58757f = m58757f(cArr, i11, 'd', i19, false, 0);
        int iM58757f2 = m58757f(cArr, i12, 'h', iM58757f, iM58757f != i19, z10 ? 2 : 0);
        int iM58757f3 = m58757f(cArr, i14, 'm', iM58757f2, iM58757f2 != i19, z10 ? 2 : 0);
        int iM58757f4 = m58757f(cArr, i13, 's', iM58757f3, iM58757f3 != i19, z10 ? 2 : 0);
        int iM58757f5 = m58757f(cArr, i17, 'm', iM58757f4, true, (!z10 || iM58757f4 == i19) ? 0 : 3);
        cArr[iM58757f5] = 's';
        return iM58757f5 + 1;
    }

    /* renamed from: f */
    public static int m58757f(char[] cArr, int i10, char c10, int i11, boolean z10, int i12) {
        int i13;
        if (!z10 && i10 <= 0) {
            return i11;
        }
        if ((!z10 || i12 < 3) && i10 <= 99) {
            i13 = i11;
        } else {
            int i14 = i10 / 100;
            cArr[i11] = (char) (i14 + 48);
            i13 = i11 + 1;
            i10 -= i14 * 100;
        }
        if ((z10 && i12 >= 2) || i10 > 9 || i11 != i13) {
            int i15 = i10 / 10;
            cArr[i13] = (char) (i15 + 48);
            i13++;
            i10 -= i15 * 10;
        }
        cArr[i13] = (char) (i10 + 48);
        cArr[i13 + 1] = c10;
        return i13 + 2;
    }
}
