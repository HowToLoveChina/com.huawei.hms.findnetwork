package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C11958y;
import sx.C12875e;

/* renamed from: okhttp3.b */
/* loaded from: classes9.dex */
public final class C11911b {

    /* renamed from: a */
    public final C11958y f55155a;

    /* renamed from: b */
    public final InterfaceC11951r f55156b;

    /* renamed from: c */
    public final SocketFactory f55157c;

    /* renamed from: d */
    public final InterfaceC11915d f55158d;

    /* renamed from: e */
    public final List<EnumC11914c0> f55159e;

    /* renamed from: f */
    public final List<C11946m> f55160f;

    /* renamed from: g */
    public final ProxySelector f55161g;

    /* renamed from: h */
    public final Proxy f55162h;

    /* renamed from: i */
    public final SSLSocketFactory f55163i;

    /* renamed from: j */
    public final HostnameVerifier f55164j;

    /* renamed from: k */
    public final C11923h f55165k;

    /* renamed from: l */
    public String f55166l;

    public C11911b(String str, int i10, InterfaceC11951r interfaceC11951r, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C11923h c11923h, InterfaceC11915d interfaceC11915d, Proxy proxy, List<EnumC11914c0> list, List<C11946m> list2, ProxySelector proxySelector) {
        this.f55155a = new C11958y.a().m71930q(sSLSocketFactory != null ? "https" : "http").m71920e(str).m71926l(i10).m71917a();
        if (interfaceC11951r == null) {
            throw new NullPointerException("dns == null");
        }
        this.f55156b = interfaceC11951r;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f55157c = socketFactory;
        if (interfaceC11915d == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f55158d = interfaceC11915d;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f55159e = C12875e.m77263t(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f55160f = C12875e.m77263t(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f55161g = proxySelector;
        this.f55162h = proxy;
        this.f55163i = sSLSocketFactory;
        this.f55164j = hostnameVerifier;
        this.f55165k = c11923h;
        this.f55166l = null;
    }

    /* renamed from: a */
    public C11923h m71448a() {
        return this.f55165k;
    }

    /* renamed from: b */
    public List<C11946m> m71449b() {
        return this.f55160f;
    }

    /* renamed from: c */
    public InterfaceC11951r m71450c() {
        return this.f55156b;
    }

    /* renamed from: d */
    public boolean m71451d(C11911b c11911b) {
        return this.f55156b.equals(c11911b.f55156b) && this.f55158d.equals(c11911b.f55158d) && this.f55159e.equals(c11911b.f55159e) && this.f55160f.equals(c11911b.f55160f) && this.f55161g.equals(c11911b.f55161g) && Objects.equals(this.f55162h, c11911b.f55162h) && Objects.equals(this.f55163i, c11911b.f55163i) && Objects.equals(this.f55164j, c11911b.f55164j) && Objects.equals(this.f55165k, c11911b.f55165k) && m71461n().m71909w() == c11911b.m71461n().m71909w();
    }

    /* renamed from: e */
    public String m71452e() {
        return this.f55166l;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C11911b) {
            C11911b c11911b = (C11911b) obj;
            if (this.f55155a.equals(c11911b.f55155a) && m71451d(c11911b)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public HostnameVerifier m71453f() {
        return this.f55164j;
    }

    /* renamed from: g */
    public List<EnumC11914c0> m71454g() {
        return this.f55159e;
    }

    /* renamed from: h */
    public Proxy m71455h() {
        return this.f55162h;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f55155a.hashCode()) * 31) + this.f55156b.hashCode()) * 31) + this.f55158d.hashCode()) * 31) + this.f55159e.hashCode()) * 31) + this.f55160f.hashCode()) * 31) + this.f55161g.hashCode()) * 31) + Objects.hashCode(this.f55162h)) * 31) + Objects.hashCode(this.f55163i)) * 31) + Objects.hashCode(this.f55164j)) * 31) + Objects.hashCode(this.f55165k);
    }

    /* renamed from: i */
    public InterfaceC11915d m71456i() {
        return this.f55158d;
    }

    /* renamed from: j */
    public ProxySelector m71457j() {
        return this.f55161g;
    }

    /* renamed from: k */
    public void m71458k(String str) {
        this.f55166l = str;
    }

    /* renamed from: l */
    public SocketFactory m71459l() {
        return this.f55157c;
    }

    /* renamed from: m */
    public SSLSocketFactory m71460m() {
        return this.f55163i;
    }

    /* renamed from: n */
    public C11958y m71461n() {
        return this.f55155a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f55155a.m71904l());
        sb2.append(":");
        sb2.append(this.f55155a.m71909w());
        if (this.f55162h != null) {
            sb2.append(", proxy=");
            sb2.append(this.f55162h);
        } else {
            sb2.append(", proxySelector=");
            sb2.append(this.f55161g);
        }
        sb2.append("}");
        return sb2.toString();
    }
}
