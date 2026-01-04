package com.huawei.hms.network.embedded;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* renamed from: com.huawei.hms.network.embedded.a7 */
/* loaded from: classes8.dex */
public final class C5850a7 {

    /* renamed from: e */
    public static final C6152x6[] f26356e;

    /* renamed from: f */
    public static final C6152x6[] f26357f;

    /* renamed from: g */
    public static final C5850a7 f26358g;

    /* renamed from: h */
    public static final C5850a7 f26359h;

    /* renamed from: i */
    public static final C5850a7 f26360i;

    /* renamed from: j */
    public static final C5850a7 f26361j;

    /* renamed from: a */
    public final boolean f26362a;

    /* renamed from: b */
    public final boolean f26363b;

    /* renamed from: c */
    public final String[] f26364c;

    /* renamed from: d */
    public final String[] f26365d;

    /* renamed from: com.huawei.hms.network.embedded.a7$a */
    public static final class a {

        /* renamed from: a */
        public boolean f26366a;

        /* renamed from: b */
        public String[] f26367b;

        /* renamed from: c */
        public String[] f26368c;

        /* renamed from: d */
        public boolean f26369d;

        public a(C5850a7 c5850a7) {
            this.f26366a = c5850a7.f26362a;
            this.f26367b = c5850a7.f26364c;
            this.f26368c = c5850a7.f26365d;
            this.f26369d = c5850a7.f26363b;
        }

        /* renamed from: a */
        public a m33819a() {
            if (!this.f26366a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            this.f26367b = null;
            return this;
        }

        /* renamed from: b */
        public a m33824b() {
            if (!this.f26366a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            this.f26368c = null;
            return this;
        }

        /* renamed from: c */
        public C5850a7 m33826c() {
            return new C5850a7(this);
        }

        public a(boolean z10) {
            this.f26366a = z10;
        }

        /* renamed from: a */
        public a m33820a(boolean z10) {
            if (!this.f26366a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f26369d = z10;
            return this;
        }

        /* renamed from: b */
        public a m33825b(String... strArr) {
            if (!this.f26366a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f26368c = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: a */
        public a m33821a(C6152x6... c6152x6Arr) {
            if (!this.f26366a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[c6152x6Arr.length];
            for (int i10 = 0; i10 < c6152x6Arr.length; i10++) {
                strArr[i10] = c6152x6Arr[i10].f29072a;
            }
            return m33823a(strArr);
        }

        /* renamed from: a */
        public a m33822a(EnumC6166y7... enumC6166y7Arr) {
            if (!this.f26366a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[enumC6166y7Arr.length];
            for (int i10 = 0; i10 < enumC6166y7Arr.length; i10++) {
                strArr[i10] = enumC6166y7Arr[i10].f29145a;
            }
            return m33825b(strArr);
        }

        /* renamed from: a */
        public a m33823a(String... strArr) {
            if (!this.f26366a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f26367b = (String[]) strArr.clone();
            return this;
        }
    }

    static {
        C6152x6 c6152x6 = C6152x6.f29043n1;
        C6152x6 c6152x62 = C6152x6.f29046o1;
        C6152x6 c6152x63 = C6152x6.f29049p1;
        C6152x6 c6152x64 = C6152x6.f29002Z0;
        C6152x6 c6152x65 = C6152x6.f29013d1;
        C6152x6 c6152x66 = C6152x6.f29004a1;
        C6152x6 c6152x67 = C6152x6.f29016e1;
        C6152x6 c6152x68 = C6152x6.f29034k1;
        C6152x6 c6152x69 = C6152x6.f29031j1;
        C6152x6[] c6152x6Arr = {c6152x6, c6152x62, c6152x63, c6152x64, c6152x65, c6152x66, c6152x67, c6152x68, c6152x69};
        f26356e = c6152x6Arr;
        C6152x6[] c6152x6Arr2 = {c6152x6, c6152x62, c6152x63, c6152x64, c6152x65, c6152x66, c6152x67, c6152x68, c6152x69, C6152x6.f28972K0, C6152x6.f28974L0, C6152x6.f29027i0, C6152x6.f29030j0, C6152x6.f28963G, C6152x6.f28971K, C6152x6.f29032k};
        f26357f = c6152x6Arr2;
        a aVarM33821a = new a(true).m33821a(c6152x6Arr);
        EnumC6166y7 enumC6166y7 = EnumC6166y7.TLS_1_3;
        EnumC6166y7 enumC6166y72 = EnumC6166y7.TLS_1_2;
        f26358g = aVarM33821a.m33822a(enumC6166y7, enumC6166y72).m33820a(true).m33826c();
        f26359h = new a(true).m33821a(c6152x6Arr2).m33822a(enumC6166y7, enumC6166y72).m33820a(true).m33826c();
        f26360i = new a(true).m33821a(c6152x6Arr2).m33822a(enumC6166y7, enumC6166y72, EnumC6166y7.TLS_1_1, EnumC6166y7.TLS_1_0).m33820a(true).m33826c();
        f26361j = new a(false).m33826c();
    }

    public C5850a7(a aVar) {
        this.f26362a = aVar.f26366a;
        this.f26364c = aVar.f26367b;
        this.f26365d = aVar.f26368c;
        this.f26363b = aVar.f26369d;
    }

    /* renamed from: b */
    private C5850a7 m33812b(SSLSocket sSLSocket, boolean z10) {
        String[] strArrM34256a = this.f26364c != null ? C5920f8.m34256a(C6152x6.f29005b, sSLSocket.getEnabledCipherSuites(), this.f26364c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrM34256a2 = this.f26365d != null ? C5920f8.m34256a(C5920f8.f26778j, sSLSocket.getEnabledProtocols(), this.f26365d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iM34232a = C5920f8.m34232a(C6152x6.f29005b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z10 && iM34232a != -1) {
            strArrM34256a = C5920f8.m34257a(strArrM34256a, supportedCipherSuites[iM34232a]);
        }
        return new a(this).m33823a(strArrM34256a).m33825b(strArrM34256a2).m33826c();
    }

    /* renamed from: a */
    public List<C6152x6> m33813a() {
        String[] strArr = this.f26364c;
        if (strArr != null) {
            return C6152x6.m35784a(strArr);
        }
        return null;
    }

    /* renamed from: c */
    public boolean m33817c() {
        return this.f26363b;
    }

    /* renamed from: d */
    public List<EnumC6166y7> m33818d() {
        String[] strArr = this.f26365d;
        if (strArr != null) {
            return EnumC6166y7.m35841a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5850a7)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C5850a7 c5850a7 = (C5850a7) obj;
        boolean z10 = this.f26362a;
        if (z10 != c5850a7.f26362a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f26364c, c5850a7.f26364c) && Arrays.equals(this.f26365d, c5850a7.f26365d) && this.f26363b == c5850a7.f26363b);
    }

    public int hashCode() {
        if (this.f26362a) {
            return ((((Arrays.hashCode(this.f26364c) + 527) * 31) + Arrays.hashCode(this.f26365d)) * 31) + (!this.f26363b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f26362a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(m33813a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(m33818d(), "[all enabled]") + ", supportsTlsExtensions=" + this.f26363b + ")";
    }

    /* renamed from: a */
    public void m33814a(SSLSocket sSLSocket, boolean z10) {
        C5850a7 c5850a7M33812b = m33812b(sSLSocket, z10);
        String[] strArr = c5850a7M33812b.f26365d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = c5850a7M33812b.f26364c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    public boolean m33816b() {
        return this.f26362a;
    }

    /* renamed from: a */
    public boolean m33815a(SSLSocket sSLSocket) {
        if (!this.f26362a) {
            return false;
        }
        String[] strArr = this.f26365d;
        if (strArr != null && !C5920f8.m34262b(C5920f8.f26778j, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f26364c;
        return strArr2 == null || C5920f8.m34262b(C6152x6.f29005b, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
