package com.huawei.hms.drive;

import com.huawei.hms.drive.C5193az;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.huawei.hms.drive.af */
/* loaded from: classes8.dex */
public final class C5173af {

    /* renamed from: a */
    final C5193az f23569a;

    /* renamed from: b */
    final InterfaceC5187at f23570b;

    /* renamed from: c */
    final SocketFactory f23571c;

    /* renamed from: d */
    final InterfaceC5174ag f23572d;

    /* renamed from: e */
    final List<EnumC5199bd> f23573e;

    /* renamed from: f */
    final List<C5183ap> f23574f;

    /* renamed from: g */
    final ProxySelector f23575g;

    /* renamed from: h */
    final Proxy f23576h;

    /* renamed from: i */
    final SSLSocketFactory f23577i;

    /* renamed from: j */
    final HostnameVerifier f23578j;

    /* renamed from: k */
    final C5179al f23579k;

    /* renamed from: l */
    private String f23580l;

    public C5173af(String str, int i10, InterfaceC5187at interfaceC5187at, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C5179al c5179al, InterfaceC5174ag interfaceC5174ag, Proxy proxy, List<EnumC5199bd> list, List<C5183ap> list2, ProxySelector proxySelector) {
        this.f23569a = new C5193az.a().m30992a(sSLSocketFactory != null ? "https" : "http").m30997d(str).m30990a(i10).m30996c();
        if (interfaceC5187at == null) {
            throw new NullPointerException("dns == null");
        }
        this.f23570b = interfaceC5187at;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f23571c = socketFactory;
        if (interfaceC5174ag == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f23572d = interfaceC5174ag;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f23573e = C5210bo.m31185a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f23574f = C5210bo.m31185a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f23575g = proxySelector;
        this.f23576h = proxy;
        this.f23577i = sSLSocketFactory;
        this.f23578j = hostnameVerifier;
        this.f23579k = c5179al;
        this.f23580l = null;
    }

    /* renamed from: a */
    public String m30805a() {
        return this.f23580l;
    }

    /* renamed from: b */
    public C5193az m30808b() {
        return this.f23569a;
    }

    /* renamed from: c */
    public InterfaceC5187at m30809c() {
        return this.f23570b;
    }

    /* renamed from: d */
    public SocketFactory m30810d() {
        return this.f23571c;
    }

    /* renamed from: e */
    public InterfaceC5174ag m30811e() {
        return this.f23572d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C5173af) {
            C5173af c5173af = (C5173af) obj;
            if (this.f23569a.equals(c5173af.f23569a) && m30807a(c5173af)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public List<EnumC5199bd> m30812f() {
        return this.f23573e;
    }

    /* renamed from: g */
    public List<C5183ap> m30813g() {
        return this.f23574f;
    }

    /* renamed from: h */
    public ProxySelector m30814h() {
        return this.f23575g;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f23569a.hashCode()) * 31) + this.f23570b.hashCode()) * 31) + this.f23572d.hashCode()) * 31) + this.f23573e.hashCode()) * 31) + this.f23574f.hashCode()) * 31) + this.f23575g.hashCode()) * 31) + Objects.hashCode(this.f23576h)) * 31) + Objects.hashCode(this.f23577i)) * 31) + Objects.hashCode(this.f23578j)) * 31) + Objects.hashCode(this.f23579k);
    }

    /* renamed from: i */
    public Proxy m30815i() {
        return this.f23576h;
    }

    /* renamed from: j */
    public SSLSocketFactory m30816j() {
        return this.f23577i;
    }

    /* renamed from: k */
    public HostnameVerifier m30817k() {
        return this.f23578j;
    }

    /* renamed from: l */
    public C5179al m30818l() {
        return this.f23579k;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f23569a.m30970f());
        sb2.append(":");
        sb2.append(this.f23569a.m30971g());
        if (this.f23576h != null) {
            sb2.append(", proxy=");
            sb2.append(this.f23576h);
        } else {
            sb2.append(", proxySelector=");
            sb2.append(this.f23575g);
        }
        sb2.append("}");
        return sb2.toString();
    }

    /* renamed from: a */
    public void m30806a(String str) {
        this.f23580l = str;
    }

    /* renamed from: a */
    public boolean m30807a(C5173af c5173af) {
        return this.f23570b.equals(c5173af.f23570b) && this.f23572d.equals(c5173af.f23572d) && this.f23573e.equals(c5173af.f23573e) && this.f23574f.equals(c5173af.f23574f) && this.f23575g.equals(c5173af.f23575g) && Objects.equals(this.f23576h, c5173af.f23576h) && Objects.equals(this.f23577i, c5173af.f23577i) && Objects.equals(this.f23578j, c5173af.f23578j) && Objects.equals(this.f23579k, c5173af.f23579k) && m30808b().m30971g() == c5173af.m30808b().m30971g();
    }
}
