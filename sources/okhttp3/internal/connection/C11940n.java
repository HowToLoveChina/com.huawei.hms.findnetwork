package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.AbstractC11953t;
import okhttp3.C11911b;
import okhttp3.HttpRequestBuilder;
import okhttp3.C11926i0;
import okhttp3.C11958y;
import okhttp3.InterfaceC11919f;
import sx.C12875e;

/* renamed from: okhttp3.internal.connection.n */
/* loaded from: classes9.dex */
public final class C11940n {

    /* renamed from: a */
    public final C11911b f55435a;

    /* renamed from: b */
    public final C11938l f55436b;

    /* renamed from: c */
    public final InterfaceC11919f f55437c;

    /* renamed from: d */
    public final AbstractC11953t f55438d;

    /* renamed from: f */
    public int f55440f;

    /* renamed from: i */
    public boolean f55443i;

    /* renamed from: j */
    public List<InetAddress> f55444j;

    /* renamed from: e */
    public List<Proxy> f55439e = Collections.emptyList();

    /* renamed from: g */
    public List<InetSocketAddress> f55441g = Collections.emptyList();

    /* renamed from: h */
    public final List<C11926i0> f55442h = new ArrayList();

    /* renamed from: okhttp3.internal.connection.n$a */
    public static final class a {

        /* renamed from: a */
        public final CopyOnWriteArrayList<C11926i0> f55445a;

        /* renamed from: c */
        public C11926i0 f55447c;

        /* renamed from: e */
        public int f55449e;

        /* renamed from: f */
        public final C11938l f55450f;

        /* renamed from: g */
        public boolean f55451g;

        /* renamed from: b */
        public int f55446b = 0;

        /* renamed from: d */
        public int f55448d = 0;

        /* renamed from: h */
        public InetSocketAddress f55452h = null;

        public a(CopyOnWriteArrayList<C11926i0> copyOnWriteArrayList, C11938l c11938l, boolean z10) {
            this.f55449e = 0;
            this.f55445a = copyOnWriteArrayList;
            if (copyOnWriteArrayList != null) {
                this.f55449e = copyOnWriteArrayList.size();
            }
            this.f55450f = c11938l;
            this.f55451g = z10;
        }

        /* renamed from: a */
        public boolean m71767a() {
            return this.f55451g;
        }

        /* renamed from: b */
        public CopyOnWriteArrayList<InetSocketAddress> m71768b() {
            CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            Iterator<C11926i0> it = this.f55445a.iterator();
            while (it.hasNext()) {
                copyOnWriteArrayList.add(it.next().m71641d());
            }
            return copyOnWriteArrayList;
        }

        /* renamed from: c */
        public void m71769c(C11926i0 c11926i0) {
            if (!this.f55451g) {
                this.f55450f.m71752a(c11926i0);
            } else {
                if (this.f55452h == null) {
                    return;
                }
                this.f55450f.m71752a(c11926i0);
                this.f55452h = null;
            }
        }

        /* renamed from: d */
        public List<C11926i0> m71770d() {
            return new ArrayList(this.f55445a);
        }

        /* renamed from: e */
        public C11926i0 m71771e() {
            return this.f55447c;
        }

        /* renamed from: f */
        public boolean m71772f() {
            return this.f55451g ? this.f55445a.size() > 0 && this.f55448d < this.f55449e : this.f55446b < this.f55445a.size();
        }

        /* renamed from: g */
        public C11926i0 m71773g() {
            if (!m71772f()) {
                throw new NoSuchElementException();
            }
            if (this.f55451g) {
                C11926i0 c11926i0 = this.f55445a.get(0);
                this.f55447c = c11926i0;
                this.f55448d++;
                return c11926i0;
            }
            CopyOnWriteArrayList<C11926i0> copyOnWriteArrayList = this.f55445a;
            int i10 = this.f55446b;
            this.f55446b = i10 + 1;
            return copyOnWriteArrayList.get(i10);
        }

        /* renamed from: h */
        public void m71774h() {
            if (this.f55451g) {
                Iterator<C11926i0> it = this.f55445a.iterator();
                while (it.hasNext()) {
                    C11926i0 next = it.next();
                    if (this.f55447c != null && next.m71641d().equals(this.f55447c.m71641d())) {
                        this.f55445a.remove(next);
                        return;
                    }
                }
            }
        }

        /* renamed from: i */
        public final C11926i0 m71775i(InetSocketAddress inetSocketAddress) {
            Iterator<C11926i0> it = this.f55445a.iterator();
            while (it.hasNext()) {
                C11926i0 next = it.next();
                if (next.m71641d().equals(inetSocketAddress)) {
                    this.f55445a.remove(next);
                    return next;
                }
            }
            return null;
        }

        /* renamed from: j */
        public void m71776j(InetSocketAddress inetSocketAddress) {
            if (this.f55451g) {
                this.f55452h = inetSocketAddress;
            }
        }

        /* renamed from: k */
        public void m71777k(C11926i0 c11926i0) {
            this.f55447c = c11926i0;
        }

        /* renamed from: l */
        public void m71778l(List<InetSocketAddress> list) {
            if (this.f55451g) {
                Iterator<InetSocketAddress> it = list.iterator();
                while (it.hasNext()) {
                    m71775i(it.next());
                }
            }
        }
    }

    public C11940n(C11911b c11911b, C11938l c11938l, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t) {
        this.f55435a = c11911b;
        this.f55436b = c11938l;
        this.f55437c = interfaceC11919f;
        this.f55438d = abstractC11953t;
        m71766i(c11911b.m71461n(), c11911b.m71455h());
    }

    /* renamed from: a */
    public static String m71758a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    /* renamed from: b */
    public boolean m71759b() {
        return m71760c() || !this.f55442h.isEmpty();
    }

    /* renamed from: c */
    public final boolean m71760c() {
        return this.f55440f < this.f55439e.size();
    }

    /* renamed from: d */
    public a m71761d() throws IOException {
        if (!m71759b()) {
            throw new NoSuchElementException();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        while (m71760c()) {
            Proxy proxyM71762e = m71762e();
            int size = this.f55441g.size();
            for (int i10 = 0; i10 < size; i10++) {
                C11926i0 c11926i0 = new C11926i0(this.f55435a, proxyM71762e, this.f55441g.get(i10));
                if (this.f55436b.m71754c(c11926i0)) {
                    this.f55442h.add(c11926i0);
                } else {
                    copyOnWriteArrayList.add(c11926i0);
                }
            }
            if (!copyOnWriteArrayList.isEmpty()) {
                break;
            }
        }
        if (this.f55443i || copyOnWriteArrayList.isEmpty()) {
            copyOnWriteArrayList.addAll(this.f55442h);
            this.f55442h.clear();
        }
        return new a(copyOnWriteArrayList, this.f55436b, this.f55443i);
    }

    /* renamed from: e */
    public final Proxy m71762e() throws IOException {
        if (m71760c()) {
            List<Proxy> list = this.f55439e;
            int i10 = this.f55440f;
            this.f55440f = i10 + 1;
            Proxy proxy = list.get(i10);
            m71765h(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f55435a.m71461n().m71904l() + "; exhausted proxy configurations: " + this.f55439e);
    }

    /* renamed from: f */
    public final void m71763f(int i10) {
        if (this.f55443i) {
            List<InetAddress> list = this.f55444j;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f55444j.get(size), i10);
                    if (this.f55441g.contains(inetSocketAddress)) {
                        this.f55441g.remove(inetSocketAddress);
                    }
                    this.f55441g.add(0, inetSocketAddress);
                }
            }
            if (this.f55441g.size() == 1) {
                this.f55443i = false;
            }
        }
    }

    /* renamed from: g */
    public C11940n m71764g(HttpRequestBuilder HttpRequestBuilder) {
        this.f55443i = HttpRequestBuilder.m71564d();
        this.f55444j = HttpRequestBuilder.m71561a();
        if (this.f55443i && (this.f55439e.size() > 1 || (this.f55439e.size() == 1 && this.f55439e.get(0).type() != Proxy.Type.DIRECT))) {
            this.f55443i = false;
        }
        return this;
    }

    /* renamed from: h */
    public final void m71765h(Proxy proxy) throws IOException {
        String strM71904l;
        int iM71909w;
        this.f55441g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strM71904l = this.f55435a.m71461n().m71904l();
            iM71909w = this.f55435a.m71461n().m71909w();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strM71904l = m71758a(inetSocketAddress);
            iM71909w = inetSocketAddress.getPort();
        }
        if (iM71909w < 1 || iM71909w > 65535) {
            throw new SocketException("No route to " + strM71904l + ":" + iM71909w + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f55441g.add(InetSocketAddress.createUnresolved(strM71904l, iM71909w));
        } else if (!this.f55443i || this.f55444j.isEmpty()) {
            this.f55438d.dnsStart(this.f55437c, strM71904l);
            List<InetAddress> listLookup = this.f55435a.m71450c().lookup(strM71904l);
            if (listLookup.isEmpty()) {
                throw new UnknownHostException(this.f55435a.m71450c() + " returned no addresses for " + strM71904l);
            }
            this.f55438d.dnsEnd(this.f55437c, strM71904l, listLookup);
            int size = listLookup.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f55441g.add(new InetSocketAddress(listLookup.get(i10), iM71909w));
            }
        }
        m71763f(iM71909w);
    }

    /* renamed from: i */
    public final void m71766i(C11958y c11958y, Proxy proxy) {
        if (proxy != null) {
            this.f55439e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f55435a.m71457j().select(c11958y.m71897C());
            this.f55439e = (listSelect == null || listSelect.isEmpty()) ? C12875e.m77264u(Proxy.NO_PROXY) : C12875e.m77263t(listSelect);
        }
        this.f55440f = 0;
    }
}
