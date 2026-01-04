package com.huawei.hms.network.embedded;

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

/* renamed from: com.huawei.hms.network.embedded.c9 */
/* loaded from: classes8.dex */
public final class C5880c9 {

    /* renamed from: a */
    public final C6048p6 f26568a;

    /* renamed from: b */
    public final C5852a9 f26569b;

    /* renamed from: c */
    public final InterfaceC6100t6 f26570c;

    /* renamed from: d */
    public final AbstractC5932g7 f26571d;

    /* renamed from: f */
    public int f26573f;

    /* renamed from: i */
    public boolean f26576i;

    /* renamed from: j */
    public List<InetAddress> f26577j;

    /* renamed from: e */
    public List<Proxy> f26572e = Collections.emptyList();

    /* renamed from: g */
    public List<InetSocketAddress> f26574g = Collections.emptyList();

    /* renamed from: h */
    public final List<C6153x7> f26575h = new ArrayList();

    /* renamed from: com.huawei.hms.network.embedded.c9$a */
    public static final class a {

        /* renamed from: a */
        public final CopyOnWriteArrayList<C6153x7> f26578a;

        /* renamed from: b */
        public int f26579b;

        /* renamed from: c */
        public C6153x7 f26580c;

        /* renamed from: d */
        public int f26581d;

        /* renamed from: e */
        public int f26582e;

        /* renamed from: f */
        public final C5852a9 f26583f;

        /* renamed from: g */
        public boolean f26584g;

        /* renamed from: h */
        public InetSocketAddress f26585h;

        public a(CopyOnWriteArrayList<C6153x7> copyOnWriteArrayList) {
            this.f26579b = 0;
            this.f26581d = 0;
            this.f26582e = 0;
            this.f26585h = null;
            this.f26578a = copyOnWriteArrayList;
            this.f26584g = false;
            this.f26583f = null;
        }

        /* renamed from: b */
        private C6153x7 m34060b(InetSocketAddress inetSocketAddress) {
            Iterator<C6153x7> it = this.f26578a.iterator();
            while (it.hasNext()) {
                C6153x7 next = it.next();
                if (next.m35790d().equals(inetSocketAddress)) {
                    this.f26578a.remove(next);
                    return next;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void m34061a(C6153x7 c6153x7) {
            if (!this.f26584g) {
                this.f26583f.m33827a(c6153x7);
            } else {
                if (this.f26585h == null) {
                    return;
                }
                this.f26583f.m33827a(c6153x7);
                this.f26585h = null;
            }
        }

        /* renamed from: c */
        public void m34067c() {
            InetSocketAddress inetSocketAddress;
            if (!this.f26584g || (inetSocketAddress = this.f26585h) == null) {
                return;
            }
            C6153x7 c6153x7M34060b = m34060b(inetSocketAddress);
            if (c6153x7M34060b != null) {
                this.f26583f.m33828b(c6153x7M34060b);
            }
            this.f26585h = null;
        }

        /* renamed from: d */
        public List<C6153x7> m34068d() {
            return new ArrayList(this.f26578a);
        }

        /* renamed from: e */
        public C6153x7 m34069e() {
            return this.f26580c;
        }

        /* renamed from: f */
        public boolean m34070f() {
            return this.f26584g ? this.f26578a.size() > 0 && this.f26581d < this.f26582e : this.f26579b < this.f26578a.size();
        }

        /* renamed from: g */
        public C6153x7 m34071g() {
            if (!m34070f()) {
                throw new NoSuchElementException();
            }
            if (this.f26584g) {
                C6153x7 c6153x7 = this.f26578a.get(0);
                this.f26580c = c6153x7;
                this.f26581d++;
                return c6153x7;
            }
            CopyOnWriteArrayList<C6153x7> copyOnWriteArrayList = this.f26578a;
            int i10 = this.f26579b;
            this.f26579b = i10 + 1;
            return copyOnWriteArrayList.get(i10);
        }

        /* renamed from: h */
        public void m34072h() {
            if (this.f26584g) {
                Iterator<C6153x7> it = this.f26578a.iterator();
                while (it.hasNext()) {
                    C6153x7 next = it.next();
                    if (this.f26580c != null && next.m35790d().equals(this.f26580c.m35790d())) {
                        this.f26578a.remove(next);
                        return;
                    }
                }
            }
        }

        public a(CopyOnWriteArrayList<C6153x7> copyOnWriteArrayList, C5852a9 c5852a9, boolean z10) {
            this.f26579b = 0;
            this.f26581d = 0;
            this.f26582e = 0;
            this.f26585h = null;
            this.f26578a = copyOnWriteArrayList;
            if (copyOnWriteArrayList != null) {
                this.f26582e = copyOnWriteArrayList.size();
            }
            this.f26583f = c5852a9;
            this.f26584g = z10;
        }

        /* renamed from: a */
        public void m34062a(InetSocketAddress inetSocketAddress) {
            if (this.f26584g) {
                this.f26585h = inetSocketAddress;
            }
        }

        /* renamed from: b */
        public CopyOnWriteArrayList<InetSocketAddress> m34065b() {
            CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            Iterator<C6153x7> it = this.f26578a.iterator();
            while (it.hasNext()) {
                copyOnWriteArrayList.add(it.next().m35790d());
            }
            return copyOnWriteArrayList;
        }

        /* renamed from: a */
        public void m34063a(List<InetSocketAddress> list) {
            if (this.f26584g) {
                Iterator<InetSocketAddress> it = list.iterator();
                while (it.hasNext()) {
                    m34060b(it.next());
                }
            }
        }

        /* renamed from: b */
        public void m34066b(C6153x7 c6153x7) {
            this.f26580c = c6153x7;
        }

        /* renamed from: a */
        public boolean m34064a() {
            return this.f26584g;
        }
    }

    public C5880c9(C6048p6 c6048p6, C5852a9 c5852a9, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7) {
        this.f26568a = c6048p6;
        this.f26569b = c5852a9;
        this.f26570c = interfaceC6100t6;
        this.f26571d = abstractC5932g7;
        m34053a(c6048p6.m34990l(), c6048p6.m34985g());
    }

    /* renamed from: c */
    private boolean m34055c() {
        return this.f26573f < this.f26572e.size();
    }

    /* renamed from: d */
    private Proxy m34056d() throws IOException {
        if (m34055c()) {
            List<Proxy> list = this.f26572e;
            int i10 = this.f26573f;
            this.f26573f = i10 + 1;
            Proxy proxy = list.get(i10);
            m34054a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f26568a.m34990l().m34797h() + "; exhausted proxy configurations: " + this.f26572e);
    }

    /* renamed from: a */
    public C5880c9 m34057a(C6101t7 c6101t7) {
        this.f26576i = c6101t7.m35416d();
        this.f26577j = c6101t7.m35412a();
        if (this.f26576i && (this.f26572e.size() > 1 || (this.f26572e.size() == 1 && this.f26572e.get(0).type() != Proxy.Type.DIRECT))) {
            this.f26576i = false;
        }
        return this;
    }

    /* renamed from: b */
    public a m34059b() throws IOException {
        if (!m34058a()) {
            throw new NoSuchElementException();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        while (m34055c()) {
            Proxy proxyM34056d = m34056d();
            int size = this.f26574g.size();
            for (int i10 = 0; i10 < size; i10++) {
                C6153x7 c6153x7 = new C6153x7(this.f26568a, proxyM34056d, this.f26574g.get(i10));
                if (this.f26569b.m33829c(c6153x7)) {
                    this.f26575h.add(c6153x7);
                } else {
                    copyOnWriteArrayList.add(c6153x7);
                }
            }
            if (!copyOnWriteArrayList.isEmpty()) {
                break;
            }
        }
        if (this.f26576i || copyOnWriteArrayList.isEmpty()) {
            copyOnWriteArrayList.addAll(this.f26575h);
            this.f26575h.clear();
        }
        return new a(copyOnWriteArrayList, this.f26569b, this.f26576i);
    }

    /* renamed from: a */
    public static String m34051a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    /* renamed from: a */
    private void m34052a(int i10) {
        if (this.f26576i) {
            List<InetAddress> list = this.f26577j;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f26577j.get(size), i10);
                    if (this.f26574g.contains(inetSocketAddress)) {
                        this.f26574g.remove(inetSocketAddress);
                    }
                    this.f26574g.add(0, inetSocketAddress);
                }
            }
            if (this.f26574g.size() == 1) {
                this.f26576i = false;
            }
        }
    }

    /* renamed from: a */
    private void m34053a(C6010m7 c6010m7, Proxy proxy) {
        List<Proxy> listM34243a;
        if (proxy != null) {
            listM34243a = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f26568a.m34987i().select(c6010m7.m34810u());
            listM34243a = (listSelect == null || listSelect.isEmpty()) ? C5920f8.m34243a(Proxy.NO_PROXY) : C5920f8.m34242a(listSelect);
        }
        this.f26572e = listM34243a;
        this.f26573f = 0;
    }

    /* renamed from: a */
    private void m34054a(Proxy proxy) throws IOException {
        String strM34797h;
        int iM34803n;
        this.f26574g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strM34797h = this.f26568a.m34990l().m34797h();
            iM34803n = this.f26568a.m34990l().m34803n();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strM34797h = m34051a(inetSocketAddress);
            iM34803n = inetSocketAddress.getPort();
        }
        if (iM34803n < 1 || iM34803n > 65535) {
            throw new SocketException("No route to " + strM34797h + ":" + iM34803n + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f26574g.add(InetSocketAddress.createUnresolved(strM34797h, iM34803n));
        } else if (!this.f26576i || this.f26577j.isEmpty()) {
            this.f26571d.dnsStart(this.f26570c, strM34797h);
            List<InetAddress> listLookup = this.f26568a.m34981c().lookup(strM34797h);
            if (listLookup.isEmpty()) {
                throw new UnknownHostException(this.f26568a.m34981c() + " returned no addresses for " + strM34797h);
            }
            this.f26571d.dnsEnd(this.f26570c, strM34797h, listLookup);
            int size = listLookup.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f26574g.add(new InetSocketAddress(listLookup.get(i10), iM34803n));
            }
        }
        m34052a(iM34803n);
    }

    /* renamed from: a */
    public boolean m34058a() {
        return m34055c() || !this.f26575h.isEmpty();
    }
}
