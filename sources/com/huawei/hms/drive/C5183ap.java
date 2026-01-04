package com.huawei.hms.drive;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* renamed from: com.huawei.hms.drive.ap */
/* loaded from: classes8.dex */
public final class C5183ap {

    /* renamed from: a */
    public static final C5183ap f23738a;

    /* renamed from: b */
    public static final C5183ap f23739b;

    /* renamed from: c */
    public static final C5183ap f23740c;

    /* renamed from: d */
    public static final C5183ap f23741d;

    /* renamed from: i */
    private static final C5180am[] f23742i;

    /* renamed from: j */
    private static final C5180am[] f23743j;

    /* renamed from: e */
    final boolean f23744e;

    /* renamed from: f */
    final boolean f23745f;

    /* renamed from: g */
    final String[] f23746g;

    /* renamed from: h */
    final String[] f23747h;

    static {
        C5180am c5180am = C5180am.f23706bl;
        C5180am c5180am2 = C5180am.f23707bm;
        C5180am c5180am3 = C5180am.f23708bn;
        C5180am c5180am4 = C5180am.f23665aX;
        C5180am c5180am5 = C5180am.f23696bb;
        C5180am c5180am6 = C5180am.f23666aY;
        C5180am c5180am7 = C5180am.f23697bc;
        C5180am c5180am8 = C5180am.f23703bi;
        C5180am c5180am9 = C5180am.f23702bh;
        C5180am[] c5180amArr = {c5180am, c5180am2, c5180am3, c5180am4, c5180am5, c5180am6, c5180am7, c5180am8, c5180am9};
        f23742i = c5180amArr;
        C5180am[] c5180amArr2 = {c5180am, c5180am2, c5180am3, c5180am4, c5180am5, c5180am6, c5180am7, c5180am8, c5180am9, C5180am.f23650aI, C5180am.f23651aJ, C5180am.f23674ag, C5180am.f23675ah, C5180am.f23619E, C5180am.f23623I, C5180am.f23718i};
        f23743j = c5180amArr2;
        a aVarM30863a = new a(true).m30863a(c5180amArr);
        EnumC5206bk enumC5206bk = EnumC5206bk.TLS_1_3;
        EnumC5206bk enumC5206bk2 = EnumC5206bk.TLS_1_2;
        f23738a = aVarM30863a.m30864a(enumC5206bk, enumC5206bk2).m30862a(true).m30866a();
        f23739b = new a(true).m30863a(c5180amArr2).m30864a(enumC5206bk, enumC5206bk2).m30862a(true).m30866a();
        f23740c = new a(true).m30863a(c5180amArr2).m30864a(enumC5206bk, enumC5206bk2, EnumC5206bk.TLS_1_1, EnumC5206bk.TLS_1_0).m30862a(true).m30866a();
        f23741d = new a(false).m30866a();
    }

    public C5183ap(a aVar) {
        this.f23744e = aVar.f23748a;
        this.f23746g = aVar.f23749b;
        this.f23747h = aVar.f23750c;
        this.f23745f = aVar.f23751d;
    }

    /* renamed from: a */
    public boolean m30857a() {
        return this.f23744e;
    }

    /* renamed from: b */
    public List<C5180am> m30859b() {
        String[] strArr = this.f23746g;
        if (strArr != null) {
            return C5180am.m30849a(strArr);
        }
        return null;
    }

    /* renamed from: c */
    public List<EnumC5206bk> m30860c() {
        String[] strArr = this.f23747h;
        if (strArr != null) {
            return EnumC5206bk.m31167a(strArr);
        }
        return null;
    }

    /* renamed from: d */
    public boolean m30861d() {
        return this.f23745f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5183ap)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C5183ap c5183ap = (C5183ap) obj;
        boolean z10 = this.f23744e;
        if (z10 != c5183ap.f23744e) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f23746g, c5183ap.f23746g) && Arrays.equals(this.f23747h, c5183ap.f23747h) && this.f23745f == c5183ap.f23745f);
    }

    public int hashCode() {
        if (this.f23744e) {
            return ((((527 + Arrays.hashCode(this.f23746g)) * 31) + Arrays.hashCode(this.f23747h)) * 31) + (!this.f23745f ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f23744e) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(m30859b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(m30860c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f23745f + ")";
    }

    /* renamed from: com.huawei.hms.drive.ap$a */
    public static final class a {

        /* renamed from: a */
        boolean f23748a;

        /* renamed from: b */
        String[] f23749b;

        /* renamed from: c */
        String[] f23750c;

        /* renamed from: d */
        boolean f23751d;

        public a(boolean z10) {
            this.f23748a = z10;
        }

        /* renamed from: a */
        public a m30863a(C5180am... c5180amArr) {
            if (!this.f23748a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[c5180amArr.length];
            for (int i10 = 0; i10 < c5180amArr.length; i10++) {
                strArr[i10] = c5180amArr[i10].f23736bq;
            }
            return m30865a(strArr);
        }

        /* renamed from: b */
        public a m30867b(String... strArr) {
            if (!this.f23748a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f23750c = (String[]) strArr.clone();
            return this;
        }

        public a(C5183ap c5183ap) {
            this.f23748a = c5183ap.f23744e;
            this.f23749b = c5183ap.f23746g;
            this.f23750c = c5183ap.f23747h;
            this.f23751d = c5183ap.f23745f;
        }

        /* renamed from: a */
        public a m30865a(String... strArr) {
            if (this.f23748a) {
                if (strArr.length != 0) {
                    this.f23749b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public a m30864a(EnumC5206bk... enumC5206bkArr) {
            if (this.f23748a) {
                String[] strArr = new String[enumC5206bkArr.length];
                for (int i10 = 0; i10 < enumC5206bkArr.length; i10++) {
                    strArr[i10] = enumC5206bkArr[i10].f23982f;
                }
                return m30867b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: a */
        public a m30862a(boolean z10) {
            if (this.f23748a) {
                this.f23751d = z10;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public C5183ap m30866a() {
            return new C5183ap(this);
        }
    }

    /* renamed from: b */
    private C5183ap m30855b(SSLSocket sSLSocket, boolean z10) {
        String[] strArrM31198a = this.f23746g != null ? C5210bo.m31198a(C5180am.f23641a, sSLSocket.getEnabledCipherSuites(), this.f23746g) : sSLSocket.getEnabledCipherSuites();
        String[] strArrM31198a2 = this.f23747h != null ? C5210bo.m31198a(C5210bo.f23994g, sSLSocket.getEnabledProtocols(), this.f23747h) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iM31177a = C5210bo.m31177a(C5180am.f23641a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z10 && iM31177a != -1) {
            strArrM31198a = C5210bo.m31199a(strArrM31198a, supportedCipherSuites[iM31177a]);
        }
        return new a(this).m30865a(strArrM31198a).m30867b(strArrM31198a2).m30866a();
    }

    /* renamed from: a */
    public void m30856a(SSLSocket sSLSocket, boolean z10) {
        C5183ap c5183apM30855b = m30855b(sSLSocket, z10);
        String[] strArr = c5183apM30855b.f23747h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = c5183apM30855b.f23746g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: a */
    public boolean m30858a(SSLSocket sSLSocket) {
        if (!this.f23744e) {
            return false;
        }
        String[] strArr = this.f23747h;
        if (strArr != null && !C5210bo.m31205b(C5210bo.f23994g, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f23746g;
        return strArr2 == null || C5210bo.m31205b(C5180am.f23641a, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
