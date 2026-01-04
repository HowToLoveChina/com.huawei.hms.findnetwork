package com.huawei.hms.network.embedded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.network.embedded.b7 */
/* loaded from: classes8.dex */
public final class C5864b7 {

    /* renamed from: j */
    public static final Pattern f26496j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k */
    public static final Pattern f26497k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l */
    public static final Pattern f26498l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m */
    public static final Pattern f26499m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a */
    public final String f26500a;

    /* renamed from: b */
    public final String f26501b;

    /* renamed from: c */
    public final long f26502c;

    /* renamed from: d */
    public final String f26503d;

    /* renamed from: e */
    public final String f26504e;

    /* renamed from: f */
    public final boolean f26505f;

    /* renamed from: g */
    public final boolean f26506g;

    /* renamed from: h */
    public final boolean f26507h;

    /* renamed from: i */
    public final boolean f26508i;

    /* renamed from: com.huawei.hms.network.embedded.b7$a */
    public static final class a {

        /* renamed from: a */
        public String f26509a;

        /* renamed from: b */
        public String f26510b;

        /* renamed from: d */
        public String f26512d;

        /* renamed from: f */
        public boolean f26514f;

        /* renamed from: g */
        public boolean f26515g;

        /* renamed from: h */
        public boolean f26516h;

        /* renamed from: i */
        public boolean f26517i;

        /* renamed from: c */
        public long f26511c = C5947h9.f26960a;

        /* renamed from: e */
        public String f26513e = "/";

        /* renamed from: a */
        public a m33882a(long j10) {
            if (j10 <= 0) {
                j10 = Long.MIN_VALUE;
            }
            if (j10 > C5947h9.f26960a) {
                j10 = 253402300799999L;
            }
            this.f26511c = j10;
            this.f26516h = true;
            return this;
        }

        /* renamed from: b */
        public a m33885b() {
            this.f26515g = true;
            return this;
        }

        /* renamed from: c */
        public a m33887c() {
            this.f26514f = true;
            return this;
        }

        /* renamed from: d */
        public a m33889d(String str) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.f26513e = str;
            return this;
        }

        /* renamed from: e */
        public a m33890e(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.f26510b = str;
            return this;
        }

        /* renamed from: a */
        public a m33883a(String str) {
            return m33881a(str, false);
        }

        /* renamed from: b */
        public a m33886b(String str) {
            return m33881a(str, true);
        }

        /* renamed from: c */
        public a m33888c(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.f26509a = str;
            return this;
        }

        /* renamed from: a */
        private a m33881a(String str, boolean z10) {
            if (str == null) {
                throw new NullPointerException("domain == null");
            }
            String strM34234a = C5920f8.m34234a(str);
            if (strM34234a != null) {
                this.f26512d = strM34234a;
                this.f26517i = z10;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        /* renamed from: a */
        public C5864b7 m33884a() {
            return new C5864b7(this);
        }
    }

    public C5864b7(a aVar) {
        String str = aVar.f26509a;
        if (str == null) {
            throw new NullPointerException("builder.name == null");
        }
        String str2 = aVar.f26510b;
        if (str2 == null) {
            throw new NullPointerException("builder.value == null");
        }
        String str3 = aVar.f26512d;
        if (str3 == null) {
            throw new NullPointerException("builder.domain == null");
        }
        this.f26500a = str;
        this.f26501b = str2;
        this.f26502c = aVar.f26511c;
        this.f26503d = str3;
        this.f26504e = aVar.f26513e;
        this.f26505f = aVar.f26514f;
        this.f26506g = aVar.f26515g;
        this.f26507h = aVar.f26516h;
        this.f26508i = aVar.f26517i;
    }

    /* renamed from: a */
    public static int m33861a(String str, int i10, int i11, boolean z10) {
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
    public long m33873b() {
        return this.f26502c;
    }

    /* renamed from: c */
    public boolean m33874c() {
        return this.f26508i;
    }

    /* renamed from: d */
    public boolean m33875d() {
        return this.f26506g;
    }

    /* renamed from: e */
    public String m33876e() {
        return this.f26500a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5864b7)) {
            return false;
        }
        C5864b7 c5864b7 = (C5864b7) obj;
        return c5864b7.f26500a.equals(this.f26500a) && c5864b7.f26501b.equals(this.f26501b) && c5864b7.f26503d.equals(this.f26503d) && c5864b7.f26504e.equals(this.f26504e) && c5864b7.f26502c == this.f26502c && c5864b7.f26505f == this.f26505f && c5864b7.f26506g == this.f26506g && c5864b7.f26507h == this.f26507h && c5864b7.f26508i == this.f26508i;
    }

    /* renamed from: f */
    public String m33877f() {
        return this.f26504e;
    }

    /* renamed from: g */
    public boolean m33878g() {
        return this.f26507h;
    }

    /* renamed from: h */
    public boolean m33879h() {
        return this.f26505f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f26500a.hashCode() + 527) * 31) + this.f26501b.hashCode()) * 31) + this.f26503d.hashCode()) * 31) + this.f26504e.hashCode()) * 31;
        long j10 = this.f26502c;
        return ((((((((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (!this.f26505f ? 1 : 0)) * 31) + (!this.f26506g ? 1 : 0)) * 31) + (!this.f26507h ? 1 : 0)) * 31) + (!this.f26508i ? 1 : 0);
    }

    /* renamed from: i */
    public String m33880i() {
        return this.f26501b;
    }

    public String toString() {
        return m33871a(false);
    }

    public C5864b7(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f26500a = str;
        this.f26501b = str2;
        this.f26502c = j10;
        this.f26503d = str3;
        this.f26504e = str4;
        this.f26505f = z10;
        this.f26506g = z11;
        this.f26508i = z12;
        this.f26507h = z13;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long m33862a(java.lang.String r12, int r13, int r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5864b7.m33862a(java.lang.String, int, int):long");
    }

    /* renamed from: b */
    public static long m33868b(String str) throws NumberFormatException {
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

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1 A[PHI: r0
  0x00c1: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:42:0x00bf, B:53:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.network.embedded.C5864b7 m33863a(long r23, com.huawei.hms.network.embedded.C6010m7 r25, java.lang.String r26) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5864b7.m33863a(long, com.huawei.hms.network.embedded.m7, java.lang.String):com.huawei.hms.network.embedded.b7");
    }

    /* renamed from: b */
    public static boolean m33869b(C6010m7 c6010m7, String str) {
        String strM34790c = c6010m7.m34790c();
        if (strM34790c.equals(str)) {
            return true;
        }
        if (strM34790c.startsWith(str)) {
            return str.endsWith("/") || strM34790c.charAt(str.length()) == '/';
        }
        return false;
    }

    /* renamed from: a */
    public static C5864b7 m33864a(C6010m7 c6010m7, String str) {
        return m33863a(System.currentTimeMillis(), c6010m7, str);
    }

    /* renamed from: a */
    public String m33870a() {
        return this.f26503d;
    }

    /* renamed from: a */
    public static String m33865a(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strM34234a = C5920f8.m34234a(str);
        if (strM34234a != null) {
            return strM34234a;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public String m33871a(boolean z10) {
        String strM34365a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f26500a);
        sb2.append('=');
        sb2.append(this.f26501b);
        if (this.f26507h) {
            if (this.f26502c == Long.MIN_VALUE) {
                strM34365a = "; max-age=0";
            } else {
                sb2.append("; expires=");
                strM34365a = C5947h9.m34365a(new Date(this.f26502c));
            }
            sb2.append(strM34365a);
        }
        if (!this.f26508i) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(this.f26503d);
        }
        sb2.append("; path=");
        sb2.append(this.f26504e);
        if (this.f26505f) {
            sb2.append("; secure");
        }
        if (this.f26506g) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public static List<C5864b7> m33866a(C6010m7 c6010m7, C5971j7 c5971j7) {
        List<String> listM34528d = c5971j7.m34528d("Set-Cookie");
        int size = listM34528d.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            C5864b7 c5864b7M33864a = m33864a(c6010m7, listM34528d.get(i10));
            if (c5864b7M33864a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c5864b7M33864a);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    /* renamed from: a */
    public boolean m33872a(C6010m7 c6010m7) {
        if ((this.f26508i ? c6010m7.m34797h().equals(this.f26503d) : m33867a(c6010m7.m34797h(), this.f26503d)) && m33869b(c6010m7, this.f26504e)) {
            return !this.f26505f || c6010m7.m34798i();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m33867a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !C5920f8.m34267e(str);
    }
}
