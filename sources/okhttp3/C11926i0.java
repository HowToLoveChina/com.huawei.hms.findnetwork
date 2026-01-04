package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* renamed from: okhttp3.i0 */
/* loaded from: classes9.dex */
public final class C11926i0 {

    /* renamed from: a */
    public final C11911b f55330a;

    /* renamed from: b */
    public final Proxy f55331b;

    /* renamed from: c */
    public final InetSocketAddress f55332c;

    public C11926i0(C11911b c11911b, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c11911b == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f55330a = c11911b;
        this.f55331b = proxy;
        this.f55332c = inetSocketAddress;
    }

    /* renamed from: a */
    public C11911b m71638a() {
        return this.f55330a;
    }

    /* renamed from: b */
    public Proxy m71639b() {
        return this.f55331b;
    }

    /* renamed from: c */
    public boolean m71640c() {
        return this.f55330a.f55163i != null && this.f55331b.type() == Proxy.Type.HTTP;
    }

    /* renamed from: d */
    public InetSocketAddress m71641d() {
        return this.f55332c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C11926i0) {
            C11926i0 c11926i0 = (C11926i0) obj;
            if (c11926i0.f55330a.equals(this.f55330a) && c11926i0.f55331b.equals(this.f55331b) && c11926i0.f55332c.equals(this.f55332c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f55330a.hashCode()) * 31) + this.f55331b.hashCode()) * 31) + this.f55332c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f55332c + "}";
    }
}
