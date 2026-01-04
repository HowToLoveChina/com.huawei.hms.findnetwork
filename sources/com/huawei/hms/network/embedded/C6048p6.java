package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6010m7;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.huawei.hms.network.embedded.p6 */
/* loaded from: classes8.dex */
public final class C6048p6 {

    /* renamed from: a */
    public final C6010m7 f27708a;

    /* renamed from: b */
    public final InterfaceC5919f7 f27709b;

    /* renamed from: c */
    public final SocketFactory f27710c;

    /* renamed from: d */
    public final InterfaceC6061q6 f27711d;

    /* renamed from: e */
    public final List<EnumC6075r7> f27712e;

    /* renamed from: f */
    public final List<C5850a7> f27713f;

    /* renamed from: g */
    public final ProxySelector f27714g;

    /* renamed from: h */
    public final Proxy f27715h;

    /* renamed from: i */
    public final SSLSocketFactory f27716i;

    /* renamed from: j */
    public final HostnameVerifier f27717j;

    /* renamed from: k */
    public final C6126v6 f27718k;

    /* renamed from: l */
    public String f27719l;

    public C6048p6(String str, int i10, InterfaceC5919f7 interfaceC5919f7, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C6126v6 c6126v6, InterfaceC6061q6 interfaceC6061q6, Proxy proxy, List<EnumC6075r7> list, List<C5850a7> list2, ProxySelector proxySelector) {
        this.f27708a = new C6010m7.a().m34852p(sSLSocketFactory != null ? "https" : "http").m34847k(str).m34825a(i10).m34830a();
        if (interfaceC5919f7 == null) {
            throw new NullPointerException("dns == null");
        }
        this.f27709b = interfaceC5919f7;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f27710c = socketFactory;
        if (interfaceC6061q6 == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f27711d = interfaceC6061q6;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f27712e = C5920f8.m34242a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f27713f = C5920f8.m34242a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f27714g = proxySelector;
        this.f27715h = proxy;
        this.f27716i = sSLSocketFactory;
        this.f27717j = hostnameVerifier;
        this.f27718k = c6126v6;
        this.f27719l = null;
    }

    /* renamed from: a */
    public C6126v6 m34977a() {
        return this.f27718k;
    }

    /* renamed from: b */
    public List<C5850a7> m34980b() {
        return this.f27713f;
    }

    /* renamed from: c */
    public InterfaceC5919f7 m34981c() {
        return this.f27709b;
    }

    /* renamed from: d */
    public String m34982d() {
        return this.f27719l;
    }

    /* renamed from: e */
    public HostnameVerifier m34983e() {
        return this.f27717j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C6048p6) {
            C6048p6 c6048p6 = (C6048p6) obj;
            if (this.f27708a.equals(c6048p6.f27708a) && m34979a(c6048p6)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public List<EnumC6075r7> m34984f() {
        return this.f27712e;
    }

    /* renamed from: g */
    public Proxy m34985g() {
        return this.f27715h;
    }

    /* renamed from: h */
    public InterfaceC6061q6 m34986h() {
        return this.f27711d;
    }

    public int hashCode() {
        return ((((((((((((((((((this.f27708a.hashCode() + 527) * 31) + this.f27709b.hashCode()) * 31) + this.f27711d.hashCode()) * 31) + this.f27712e.hashCode()) * 31) + this.f27713f.hashCode()) * 31) + this.f27714g.hashCode()) * 31) + Objects.hashCode(this.f27715h)) * 31) + Objects.hashCode(this.f27716i)) * 31) + Objects.hashCode(this.f27717j)) * 31) + Objects.hashCode(this.f27718k);
    }

    /* renamed from: i */
    public ProxySelector m34987i() {
        return this.f27714g;
    }

    /* renamed from: j */
    public SocketFactory m34988j() {
        return this.f27710c;
    }

    /* renamed from: k */
    public SSLSocketFactory m34989k() {
        return this.f27716i;
    }

    /* renamed from: l */
    public C6010m7 m34990l() {
        return this.f27708a;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f27708a.m34797h());
        sb2.append(":");
        sb2.append(this.f27708a.m34803n());
        if (this.f27715h != null) {
            sb2.append(", proxy=");
            obj = this.f27715h;
        } else {
            sb2.append(", proxySelector=");
            obj = this.f27714g;
        }
        sb2.append(obj);
        sb2.append("}");
        return sb2.toString();
    }

    /* renamed from: a */
    public void m34978a(String str) {
        this.f27719l = str;
    }

    /* renamed from: a */
    public boolean m34979a(C6048p6 c6048p6) {
        return this.f27709b.equals(c6048p6.f27709b) && this.f27711d.equals(c6048p6.f27711d) && this.f27712e.equals(c6048p6.f27712e) && this.f27713f.equals(c6048p6.f27713f) && this.f27714g.equals(c6048p6.f27714g) && Objects.equals(this.f27715h, c6048p6.f27715h) && Objects.equals(this.f27716i, c6048p6.f27716i) && Objects.equals(this.f27717j, c6048p6.f27717j) && Objects.equals(this.f27718k, c6048p6.f27718k) && m34990l().m34803n() == c6048p6.m34990l().m34803n();
    }
}
