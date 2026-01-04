package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import p693ux.C13279d;
import sx.C12875e;

/* renamed from: okhttp3.n */
/* loaded from: classes9.dex */
public final class C11947n {

    /* renamed from: j */
    public static final Pattern f55622j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k */
    public static final Pattern f55623k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l */
    public static final Pattern f55624l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m */
    public static final Pattern f55625m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a */
    public final String f55626a;

    /* renamed from: b */
    public final String f55627b;

    /* renamed from: c */
    public final long f55628c;

    /* renamed from: d */
    public final String f55629d;

    /* renamed from: e */
    public final String f55630e;

    /* renamed from: f */
    public final boolean f55631f;

    /* renamed from: g */
    public final boolean f55632g;

    /* renamed from: h */
    public final boolean f55633h;

    /* renamed from: i */
    public final boolean f55634i;

    public C11947n(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f55626a = str;
        this.f55627b = str2;
        this.f55628c = j10;
        this.f55629d = str3;
        this.f55630e = str4;
        this.f55631f = z10;
        this.f55632g = z11;
        this.f55634i = z12;
        this.f55633h = z13;
    }

    /* renamed from: a */
    public static int m71811a(String str, int i10, int i11, boolean z10) {
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z10)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: b */
    public static boolean m71812b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !C12875e.m77243N(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1 A[PHI: r0
  0x00c1: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:41:0x00bf, B:52:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static okhttp3.C11947n m71813d(long r23, okhttp3.C11958y r25, java.lang.String r26) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C11947n.m71813d(long, okhttp3.y, java.lang.String):okhttp3.n");
    }

    /* renamed from: e */
    public static C11947n m71814e(C11958y c11958y, String str) {
        return m71813d(System.currentTimeMillis(), c11958y, str);
    }

    /* renamed from: f */
    public static List<C11947n> m71815f(C11958y c11958y, C11955v c11955v) {
        List<String> listM71860m = c11955v.m71860m("Set-Cookie");
        int size = listM71860m.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            C11947n c11947nM71814e = m71814e(c11958y, listM71860m.get(i10));
            if (c11947nM71814e != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c11947nM71814e);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    /* renamed from: g */
    public static String m71816g(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strM77247d = C12875e.m77247d(str);
        if (strM77247d != null) {
            return strM77247d;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long m71817h(java.lang.String r12, int r13, int r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C11947n.m71817h(java.lang.String, int, int):long");
    }

    /* renamed from: i */
    public static long m71818i(String str) throws NumberFormatException {
        try {
            long j10 = Long.parseLong(str);
            if (j10 <= 0) {
                return Long.MIN_VALUE;
            }
            return j10;
        } catch (NumberFormatException e10) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e10;
        }
    }

    /* renamed from: c */
    public String m71819c() {
        return this.f55626a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C11947n)) {
            return false;
        }
        C11947n c11947n = (C11947n) obj;
        return c11947n.f55626a.equals(this.f55626a) && c11947n.f55627b.equals(this.f55627b) && c11947n.f55629d.equals(this.f55629d) && c11947n.f55630e.equals(this.f55630e) && c11947n.f55628c == this.f55628c && c11947n.f55631f == this.f55631f && c11947n.f55632g == this.f55632g && c11947n.f55633h == this.f55633h && c11947n.f55634i == this.f55634i;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.f55626a.hashCode()) * 31) + this.f55627b.hashCode()) * 31) + this.f55629d.hashCode()) * 31) + this.f55630e.hashCode()) * 31;
        long j10 = this.f55628c;
        return ((((((((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (!this.f55631f ? 1 : 0)) * 31) + (!this.f55632g ? 1 : 0)) * 31) + (!this.f55633h ? 1 : 0)) * 31) + (!this.f55634i ? 1 : 0);
    }

    /* renamed from: j */
    public String m71820j(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f55626a);
        sb2.append('=');
        sb2.append(this.f55627b);
        if (this.f55633h) {
            if (this.f55628c == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(C13279d.m79709a(new Date(this.f55628c)));
            }
        }
        if (!this.f55634i) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(this.f55629d);
        }
        sb2.append("; path=");
        sb2.append(this.f55630e);
        if (this.f55631f) {
            sb2.append("; secure");
        }
        if (this.f55632g) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }

    /* renamed from: k */
    public String m71821k() {
        return this.f55627b;
    }

    public String toString() {
        return m71820j(false);
    }
}
