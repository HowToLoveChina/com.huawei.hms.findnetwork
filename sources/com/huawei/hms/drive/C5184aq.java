package com.huawei.hms.drive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.drive.aq */
/* loaded from: classes8.dex */
public final class C5184aq {

    /* renamed from: a */
    private static final Pattern f23752a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b */
    private static final Pattern f23753b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c */
    private static final Pattern f23754c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d */
    private static final Pattern f23755d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e */
    private final String f23756e;

    /* renamed from: f */
    private final String f23757f;

    /* renamed from: g */
    private final long f23758g;

    /* renamed from: h */
    private final String f23759h;

    /* renamed from: i */
    private final String f23760i;

    /* renamed from: j */
    private final boolean f23761j;

    /* renamed from: k */
    private final boolean f23762k;

    /* renamed from: l */
    private final boolean f23763l;

    /* renamed from: m */
    private final boolean f23764m;

    private C5184aq(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f23756e = str;
        this.f23757f = str2;
        this.f23758g = j10;
        this.f23759h = str3;
        this.f23760i = str4;
        this.f23761j = z10;
        this.f23762k = z11;
        this.f23764m = z12;
        this.f23763l = z13;
    }

    /* renamed from: a */
    public String m30876a() {
        return this.f23756e;
    }

    /* renamed from: b */
    public String m30878b() {
        return this.f23757f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5184aq)) {
            return false;
        }
        C5184aq c5184aq = (C5184aq) obj;
        return c5184aq.f23756e.equals(this.f23756e) && c5184aq.f23757f.equals(this.f23757f) && c5184aq.f23759h.equals(this.f23759h) && c5184aq.f23760i.equals(this.f23760i) && c5184aq.f23758g == this.f23758g && c5184aq.f23761j == this.f23761j && c5184aq.f23762k == this.f23762k && c5184aq.f23763l == this.f23763l && c5184aq.f23764m == this.f23764m;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.f23756e.hashCode()) * 31) + this.f23757f.hashCode()) * 31) + this.f23759h.hashCode()) * 31) + this.f23760i.hashCode()) * 31;
        long j10 = this.f23758g;
        return ((((((((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (!this.f23761j ? 1 : 0)) * 31) + (!this.f23762k ? 1 : 0)) * 31) + (!this.f23763l ? 1 : 0)) * 31) + (!this.f23764m ? 1 : 0);
    }

    public String toString() {
        return m30877a(false);
    }

    /* renamed from: a */
    private static boolean m30874a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !C5210bo.m31207c(str);
    }

    /* renamed from: b */
    private static String m30875b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strM31179a = C5210bo.m31179a(str);
        if (strM31179a != null) {
            return strM31179a;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static C5184aq m30872a(C5193az c5193az, String str) {
        return m30871a(System.currentTimeMillis(), c5193az, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1 A[PHI: r0
  0x00c1: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:41:0x00bf, B:52:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.drive.C5184aq m30871a(long r23, com.huawei.hms.drive.C5193az r25, java.lang.String r26) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5184aq.m30871a(long, com.huawei.hms.drive.az, java.lang.String):com.huawei.hms.drive.aq");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long m30870a(java.lang.String r12, int r13, int r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5184aq.m30870a(java.lang.String, int, int):long");
    }

    /* renamed from: a */
    private static int m30868a(String str, int i10, int i11, boolean z10) {
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z10)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: a */
    private static long m30869a(String str) throws NumberFormatException {
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

    /* renamed from: a */
    public static List<C5184aq> m30873a(C5193az c5193az, C5190aw c5190aw) {
        List<String> listM30926b = c5190aw.m30926b("Set-Cookie");
        int size = listM30926b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            C5184aq c5184aqM30872a = m30872a(c5193az, listM30926b.get(i10));
            if (c5184aqM30872a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c5184aqM30872a);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    public String m30877a(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f23756e);
        sb2.append('=');
        sb2.append(this.f23757f);
        if (this.f23763l) {
            if (this.f23758g == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(C5236cm.m31405a(new Date(this.f23758g)));
            }
        }
        if (!this.f23764m) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(this.f23759h);
        }
        sb2.append("; path=");
        sb2.append(this.f23760i);
        if (this.f23761j) {
            sb2.append("; secure");
        }
        if (this.f23762k) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }
}
