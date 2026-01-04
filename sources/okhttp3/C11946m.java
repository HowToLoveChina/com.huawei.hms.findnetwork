package okhttp3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import sx.C12875e;

/* renamed from: okhttp3.m */
/* loaded from: classes9.dex */
public final class C11946m {

    /* renamed from: e */
    public static final C11942j[] f55608e;

    /* renamed from: f */
    public static final C11942j[] f55609f;

    /* renamed from: g */
    public static final C11946m f55610g;

    /* renamed from: h */
    public static final C11946m f55611h;

    /* renamed from: i */
    public static final C11946m f55612i;

    /* renamed from: j */
    public static final C11946m f55613j;

    /* renamed from: a */
    public final boolean f55614a;

    /* renamed from: b */
    public final boolean f55615b;

    /* renamed from: c */
    public final String[] f55616c;

    /* renamed from: d */
    public final String[] f55617d;

    static {
        C11942j c11942j = C11942j.f55571n1;
        C11942j c11942j2 = C11942j.f55574o1;
        C11942j c11942j3 = C11942j.f55577p1;
        C11942j c11942j4 = C11942j.f55530Z0;
        C11942j c11942j5 = C11942j.f55541d1;
        C11942j c11942j6 = C11942j.f55532a1;
        C11942j c11942j7 = C11942j.f55544e1;
        C11942j c11942j8 = C11942j.f55562k1;
        C11942j c11942j9 = C11942j.f55559j1;
        C11942j[] c11942jArr = {c11942j, c11942j2, c11942j3, c11942j4, c11942j5, c11942j6, c11942j7, c11942j8, c11942j9};
        f55608e = c11942jArr;
        C11942j[] c11942jArr2 = {c11942j, c11942j2, c11942j3, c11942j4, c11942j5, c11942j6, c11942j7, c11942j8, c11942j9, C11942j.f55500K0, C11942j.f55502L0, C11942j.f55555i0, C11942j.f55558j0, C11942j.f55491G, C11942j.f55499K, C11942j.f55560k};
        f55609f = c11942jArr2;
        a aVarM71807c = new a(true).m71807c(c11942jArr);
        EnumC11943j0 enumC11943j0 = EnumC11943j0.TLS_1_3;
        EnumC11943j0 enumC11943j02 = EnumC11943j0.TLS_1_2;
        f55610g = aVarM71807c.m71810f(enumC11943j0, enumC11943j02).m71808d(true).m71805a();
        f55611h = new a(true).m71807c(c11942jArr2).m71810f(enumC11943j0, enumC11943j02).m71808d(true).m71805a();
        f55612i = new a(true).m71807c(c11942jArr2).m71810f(enumC11943j0, enumC11943j02, EnumC11943j0.TLS_1_1, EnumC11943j0.TLS_1_0).m71808d(true).m71805a();
        f55613j = new a(false).m71805a();
    }

    public C11946m(a aVar) {
        this.f55614a = aVar.f55618a;
        this.f55616c = aVar.f55619b;
        this.f55617d = aVar.f55620c;
        this.f55615b = aVar.f55621d;
    }

    /* renamed from: a */
    public void m71798a(SSLSocket sSLSocket, boolean z10) {
        C11946m c11946mM71802e = m71802e(sSLSocket, z10);
        String[] strArr = c11946mM71802e.f55617d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = c11946mM71802e.f55616c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    public List<C11942j> m71799b() {
        String[] strArr = this.f55616c;
        if (strArr != null) {
            return C11942j.m71787c(strArr);
        }
        return null;
    }

    /* renamed from: c */
    public boolean m71800c(SSLSocket sSLSocket) {
        if (!this.f55614a) {
            return false;
        }
        String[] strArr = this.f55617d;
        if (strArr != null && !C12875e.m77233D(C12875e.f58649j, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f55616c;
        return strArr2 == null || C12875e.m77233D(C11942j.f55533b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    /* renamed from: d */
    public boolean m71801d() {
        return this.f55614a;
    }

    /* renamed from: e */
    public final C11946m m71802e(SSLSocket sSLSocket, boolean z10) {
        String[] strArrM77269z = this.f55616c != null ? C12875e.m77269z(C11942j.f55533b, sSLSocket.getEnabledCipherSuites(), this.f55616c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrM77269z2 = this.f55617d != null ? C12875e.m77269z(C12875e.f58649j, sSLSocket.getEnabledProtocols(), this.f55617d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iM77266w = C12875e.m77266w(C11942j.f55533b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z10 && iM77266w != -1) {
            strArrM77269z = C12875e.m77252i(strArrM77269z, supportedCipherSuites[iM77266w]);
        }
        return new a(this).m71806b(strArrM77269z).m71809e(strArrM77269z2).m71805a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C11946m)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C11946m c11946m = (C11946m) obj;
        boolean z10 = this.f55614a;
        if (z10 != c11946m.f55614a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f55616c, c11946m.f55616c) && Arrays.equals(this.f55617d, c11946m.f55617d) && this.f55615b == c11946m.f55615b);
    }

    /* renamed from: f */
    public boolean m71803f() {
        return this.f55615b;
    }

    /* renamed from: g */
    public List<EnumC11943j0> m71804g() {
        String[] strArr = this.f55617d;
        if (strArr != null) {
            return EnumC11943j0.m71793e(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f55614a) {
            return ((((527 + Arrays.hashCode(this.f55616c)) * 31) + Arrays.hashCode(this.f55617d)) * 31) + (!this.f55615b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f55614a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(m71799b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(m71804g(), "[all enabled]") + ", supportsTlsExtensions=" + this.f55615b + ")";
    }

    /* renamed from: okhttp3.m$a */
    public static final class a {

        /* renamed from: a */
        public boolean f55618a;

        /* renamed from: b */
        public String[] f55619b;

        /* renamed from: c */
        public String[] f55620c;

        /* renamed from: d */
        public boolean f55621d;

        public a(boolean z10) {
            this.f55618a = z10;
        }

        /* renamed from: a */
        public C11946m m71805a() {
            return new C11946m(this);
        }

        /* renamed from: b */
        public a m71806b(String... strArr) {
            if (!this.f55618a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f55619b = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: c */
        public a m71807c(C11942j... c11942jArr) {
            if (!this.f55618a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[c11942jArr.length];
            for (int i10 = 0; i10 < c11942jArr.length; i10++) {
                strArr[i10] = c11942jArr[i10].f55600a;
            }
            return m71806b(strArr);
        }

        /* renamed from: d */
        public a m71808d(boolean z10) {
            if (!this.f55618a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f55621d = z10;
            return this;
        }

        /* renamed from: e */
        public a m71809e(String... strArr) {
            if (!this.f55618a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f55620c = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: f */
        public a m71810f(EnumC11943j0... enumC11943j0Arr) {
            if (!this.f55618a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[enumC11943j0Arr.length];
            for (int i10 = 0; i10 < enumC11943j0Arr.length; i10++) {
                strArr[i10] = enumC11943j0Arr[i10].f55607a;
            }
            return m71809e(strArr);
        }

        public a(C11946m c11946m) {
            this.f55618a = c11946m.f55614a;
            this.f55619b = c11946m.f55616c;
            this.f55620c = c11946m.f55617d;
            this.f55621d = c11946m.f55615b;
        }
    }
}
