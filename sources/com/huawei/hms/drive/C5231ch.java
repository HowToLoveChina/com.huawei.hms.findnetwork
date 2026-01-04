package com.huawei.hms.drive;

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

/* renamed from: com.huawei.hms.drive.ch */
/* loaded from: classes8.dex */
final class C5231ch {

    /* renamed from: a */
    private final C5173af f24170a;

    /* renamed from: b */
    private final C5229cf f24171b;

    /* renamed from: c */
    private final InterfaceC5177aj f24172c;

    /* renamed from: d */
    private final AbstractC5188au f24173d;

    /* renamed from: f */
    private int f24175f;

    /* renamed from: i */
    private boolean f24178i;

    /* renamed from: j */
    private List<InetAddress> f24179j;

    /* renamed from: e */
    private List<Proxy> f24174e = Collections.emptyList();

    /* renamed from: g */
    private List<InetSocketAddress> f24176g = Collections.emptyList();

    /* renamed from: h */
    private final List<C5205bj> f24177h = new ArrayList();

    public C5231ch(C5173af c5173af, C5229cf c5229cf, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au) {
        this.f24170a = c5173af;
        this.f24171b = c5229cf;
        this.f24172c = interfaceC5177aj;
        this.f24173d = abstractC5188au;
        m31356a(c5173af.m30808b(), c5173af.m30815i());
    }

    /* renamed from: c */
    private boolean m31358c() {
        return this.f24175f < this.f24174e.size();
    }

    /* renamed from: d */
    private Proxy m31359d() throws IOException {
        if (m31358c()) {
            List<Proxy> list = this.f24174e;
            int i10 = this.f24175f;
            this.f24175f = i10 + 1;
            Proxy proxy = list.get(i10);
            m31357a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f24170a.m30808b().m30970f() + "; exhausted proxy configurations: " + this.f24174e);
    }

    /* renamed from: a */
    public C5231ch m31360a(C5201bf c5201bf) {
        this.f24178i = c5201bf.m31112e();
        this.f24179j = c5201bf.m31113f();
        if (this.f24178i && (this.f24174e.size() > 1 || (this.f24174e.size() == 1 && this.f24174e.get(0).type() != Proxy.Type.DIRECT))) {
            this.f24178i = false;
        }
        return this;
    }

    /* renamed from: b */
    public a m31362b() throws IOException {
        if (!m31361a()) {
            throw new NoSuchElementException();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        while (m31358c()) {
            Proxy proxyM31359d = m31359d();
            int size = this.f24176g.size();
            for (int i10 = 0; i10 < size; i10++) {
                C5205bj c5205bj = new C5205bj(this.f24170a, proxyM31359d, this.f24176g.get(i10));
                if (this.f24171b.m31350c(c5205bj)) {
                    this.f24177h.add(c5205bj);
                } else {
                    copyOnWriteArrayList.add(c5205bj);
                }
            }
            if (!copyOnWriteArrayList.isEmpty()) {
                break;
            }
        }
        if (this.f24178i || copyOnWriteArrayList.isEmpty()) {
            copyOnWriteArrayList.addAll(this.f24177h);
            this.f24177h.clear();
        }
        return new a(copyOnWriteArrayList, this.f24171b, this.f24178i);
    }

    /* renamed from: com.huawei.hms.drive.ch$a */
    public static final class a {

        /* renamed from: a */
        private final CopyOnWriteArrayList<C5205bj> f24180a;

        /* renamed from: c */
        private C5205bj f24182c;

        /* renamed from: e */
        private int f24184e;

        /* renamed from: f */
        private final C5229cf f24185f;

        /* renamed from: g */
        private boolean f24186g;

        /* renamed from: b */
        private int f24181b = 0;

        /* renamed from: d */
        private int f24183d = 0;

        /* renamed from: h */
        private InetSocketAddress f24187h = null;

        public a(CopyOnWriteArrayList<C5205bj> copyOnWriteArrayList, C5229cf c5229cf, boolean z10) {
            this.f24184e = 0;
            this.f24180a = copyOnWriteArrayList;
            if (copyOnWriteArrayList != null) {
                this.f24184e = copyOnWriteArrayList.size();
            }
            this.f24185f = c5229cf;
            this.f24186g = z10;
        }

        /* renamed from: a */
        public boolean m31367a() {
            return this.f24186g ? this.f24180a.size() > 0 && this.f24183d < this.f24184e : this.f24181b < this.f24180a.size();
        }

        /* renamed from: b */
        public C5205bj m31368b() {
            if (!m31367a()) {
                throw new NoSuchElementException();
            }
            if (this.f24186g) {
                C5205bj c5205bj = this.f24180a.get(0);
                this.f24182c = c5205bj;
                this.f24183d++;
                return c5205bj;
            }
            CopyOnWriteArrayList<C5205bj> copyOnWriteArrayList = this.f24180a;
            int i10 = this.f24181b;
            this.f24181b = i10 + 1;
            return copyOnWriteArrayList.get(i10);
        }

        /* renamed from: c */
        public List<C5205bj> m31370c() {
            return new ArrayList(this.f24180a);
        }

        /* renamed from: d */
        public boolean m31371d() {
            return this.f24186g;
        }

        /* renamed from: e */
        public CopyOnWriteArrayList<InetSocketAddress> m31372e() {
            CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            Iterator<C5205bj> it = this.f24180a.iterator();
            while (it.hasNext()) {
                copyOnWriteArrayList.add(it.next().m31164c());
            }
            return copyOnWriteArrayList;
        }

        /* renamed from: f */
        public void m31373f() {
            if (this.f24186g) {
                Iterator<C5205bj> it = this.f24180a.iterator();
                while (it.hasNext()) {
                    C5205bj next = it.next();
                    if (this.f24182c != null && next.m31164c().equals(this.f24182c.m31164c())) {
                        this.f24180a.remove(next);
                        return;
                    }
                }
            }
        }

        /* renamed from: g */
        public C5205bj m31374g() {
            return this.f24182c;
        }

        /* renamed from: a */
        public void m31364a(C5205bj c5205bj) {
            if (!this.f24186g) {
                this.f24185f.m31349b(c5205bj);
            } else {
                if (this.f24187h == null) {
                    return;
                }
                this.f24185f.m31349b(c5205bj);
                this.f24187h = null;
            }
        }

        /* renamed from: b */
        private C5205bj m31363b(InetSocketAddress inetSocketAddress) {
            Iterator<C5205bj> it = this.f24180a.iterator();
            while (it.hasNext()) {
                C5205bj next = it.next();
                if (next.m31164c().equals(inetSocketAddress)) {
                    this.f24180a.remove(next);
                    return next;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void m31365a(InetSocketAddress inetSocketAddress) {
            if (this.f24186g) {
                this.f24187h = inetSocketAddress;
            }
        }

        /* renamed from: a */
        public void m31366a(List<InetSocketAddress> list) {
            if (this.f24186g) {
                Iterator<InetSocketAddress> it = list.iterator();
                while (it.hasNext()) {
                    m31363b(it.next());
                }
            }
        }

        /* renamed from: b */
        public void m31369b(C5205bj c5205bj) {
            this.f24182c = c5205bj;
        }
    }

    /* renamed from: a */
    public boolean m31361a() {
        return m31358c() || !this.f24177h.isEmpty();
    }

    /* renamed from: a */
    private void m31356a(C5193az c5193az, Proxy proxy) {
        List<Proxy> listM31186a;
        if (proxy != null) {
            this.f24174e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f24170a.m30814h().select(c5193az.m30963a());
            if (listSelect != null && !listSelect.isEmpty()) {
                listM31186a = C5210bo.m31185a(listSelect);
            } else {
                listM31186a = C5210bo.m31186a(Proxy.NO_PROXY);
            }
            this.f24174e = listM31186a;
        }
        this.f24175f = 0;
    }

    /* renamed from: a */
    private void m31357a(Proxy proxy) throws IOException {
        String strM30970f;
        int iM30971g;
        this.f24176g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress socketAddressAddress = proxy.address();
            if (socketAddressAddress instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                strM30970f = m31354a(inetSocketAddress);
                iM30971g = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
        } else {
            strM30970f = this.f24170a.m30808b().m30970f();
            iM30971g = this.f24170a.m30808b().m30971g();
        }
        if (iM30971g >= 1 && iM30971g <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f24176g.add(InetSocketAddress.createUnresolved(strM30970f, iM30971g));
            } else if (!this.f24178i || this.f24179j.isEmpty()) {
                this.f24173d.m30898a(this.f24172c, strM30970f);
                List<InetAddress> listLookup = this.f24170a.m30809c().lookup(strM30970f);
                if (!listLookup.isEmpty()) {
                    this.f24173d.m30899a(this.f24172c, strM30970f, listLookup);
                    int size = listLookup.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        this.f24176g.add(new InetSocketAddress(listLookup.get(i10), iM30971g));
                    }
                } else {
                    throw new UnknownHostException(this.f24170a.m30809c() + " returned no addresses for " + strM30970f);
                }
            }
            m31355a(iM30971g);
            return;
        }
        throw new SocketException("No route to " + strM30970f + ":" + iM30971g + "; port is out of range");
    }

    /* renamed from: a */
    private void m31355a(int i10) {
        if (this.f24178i) {
            List<InetAddress> list = this.f24179j;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f24179j.get(size), i10);
                    if (this.f24176g.contains(inetSocketAddress)) {
                        this.f24176g.remove(inetSocketAddress);
                    }
                    this.f24176g.add(0, inetSocketAddress);
                }
            }
            if (this.f24176g.size() == 1) {
                this.f24178i = false;
            }
        }
    }

    /* renamed from: a */
    public static String m31354a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
