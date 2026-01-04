package com.huawei.hms.drive;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* renamed from: com.huawei.hms.drive.bj */
/* loaded from: classes8.dex */
public final class C5205bj {

    /* renamed from: a */
    final C5173af f23973a;

    /* renamed from: b */
    final Proxy f23974b;

    /* renamed from: c */
    final InetSocketAddress f23975c;

    public C5205bj(C5173af c5173af, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c5173af == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f23973a = c5173af;
        this.f23974b = proxy;
        this.f23975c = inetSocketAddress;
    }

    /* renamed from: a */
    public C5173af m31162a() {
        return this.f23973a;
    }

    /* renamed from: b */
    public Proxy m31163b() {
        return this.f23974b;
    }

    /* renamed from: c */
    public InetSocketAddress m31164c() {
        return this.f23975c;
    }

    /* renamed from: d */
    public boolean m31165d() {
        return this.f23973a.f23577i != null && this.f23974b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C5205bj) {
            C5205bj c5205bj = (C5205bj) obj;
            if (c5205bj.f23973a.equals(this.f23973a) && c5205bj.f23974b.equals(this.f23974b) && c5205bj.f23975c.equals(this.f23975c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f23973a.hashCode()) * 31) + this.f23974b.hashCode()) * 31) + this.f23975c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f23975c + "}";
    }
}
