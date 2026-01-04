package com.huawei.hms.network.embedded;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* renamed from: com.huawei.hms.network.embedded.x7 */
/* loaded from: classes8.dex */
public final class C6153x7 {

    /* renamed from: a */
    public final C6048p6 f29073a;

    /* renamed from: b */
    public final Proxy f29074b;

    /* renamed from: c */
    public final InetSocketAddress f29075c;

    public C6153x7(C6048p6 c6048p6, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c6048p6 == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f29073a = c6048p6;
        this.f29074b = proxy;
        this.f29075c = inetSocketAddress;
    }

    /* renamed from: a */
    public C6048p6 m35787a() {
        return this.f29073a;
    }

    /* renamed from: b */
    public Proxy m35788b() {
        return this.f29074b;
    }

    /* renamed from: c */
    public boolean m35789c() {
        return this.f29073a.f27716i != null && this.f29074b.type() == Proxy.Type.HTTP;
    }

    /* renamed from: d */
    public InetSocketAddress m35790d() {
        return this.f29075c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C6153x7) {
            C6153x7 c6153x7 = (C6153x7) obj;
            if (c6153x7.f29073a.equals(this.f29073a) && c6153x7.f29074b.equals(this.f29074b) && c6153x7.f29075c.equals(this.f29075c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f29073a.hashCode() + 527) * 31) + this.f29074b.hashCode()) * 31) + this.f29075c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f29075c + "}";
    }
}
