package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.AbstractC11953t;
import okhttp3.InterfaceC11919f;
import p791xx.C13893h;

/* renamed from: okhttp3.internal.connection.c */
/* loaded from: classes9.dex */
public class C11929c {

    /* renamed from: a */
    public final CopyOnWriteArrayList<InetSocketAddress> f55357a;

    /* renamed from: d */
    public final int f55360d;

    /* renamed from: e */
    public int f55361e;

    /* renamed from: f */
    public int f55362f;

    /* renamed from: g */
    public int f55363g;

    /* renamed from: h */
    public boolean f55364h;

    /* renamed from: i */
    public Selector f55365i;

    /* renamed from: l */
    public InetSocketAddress f55368l;

    /* renamed from: m */
    public int f55369m;

    /* renamed from: b */
    public final CopyOnWriteArrayList<InetSocketAddress> f55358b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    public final CopyOnWriteArrayList<b> f55359c = new CopyOnWriteArrayList<>();

    /* renamed from: j */
    public Object f55366j = new Object();

    /* renamed from: k */
    public volatile boolean f55367k = false;

    /* renamed from: okhttp3.internal.connection.c$b */
    public final class b {

        /* renamed from: a */
        public SocketChannel f55370a;

        /* renamed from: b */
        public InetSocketAddress f55371b;

        /* renamed from: c */
        public long f55372c;

        public b() {
            this.f55370a = null;
            this.f55371b = null;
            this.f55372c = 0L;
        }

        /* renamed from: a */
        public void m71673a() {
            SocketChannel socketChannel = this.f55370a;
            if (socketChannel == null) {
                return;
            }
            try {
                try {
                    socketChannel.close();
                } catch (IOException unused) {
                    C11929c.this.m71667k("Socket channel close error", null);
                }
            } finally {
                this.f55370a = null;
            }
        }

        /* renamed from: b */
        public long m71674b() {
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            long j10 = this.f55372c;
            if (millis >= j10) {
                return 0L;
            }
            return j10 - millis;
        }

        /* renamed from: c */
        public boolean m71675c() {
            return TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) >= this.f55372c;
        }

        /* renamed from: d */
        public void m71676d(InetSocketAddress inetSocketAddress, long j10, int i10, Proxy proxy, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t) throws IOException {
            this.f55371b = inetSocketAddress;
            this.f55372c = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) + j10;
            abstractC11953t.connectStart(interfaceC11919f, inetSocketAddress, proxy);
            SocketChannel socketChannelOpen = SocketChannel.open();
            this.f55370a = socketChannelOpen;
            socketChannelOpen.configureBlocking(false);
            this.f55370a.socket().setTrafficClass(i10);
            this.f55370a.connect(inetSocketAddress);
        }
    }

    public C11929c(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        this.f55357a = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        this.f55361e = i10;
        this.f55362f = i10;
        this.f55363g = i10 / 2;
        this.f55369m = i11;
        this.f55360d = copyOnWriteArrayList.size();
    }

    /* renamed from: e */
    private void m71666e() {
        Iterator<b> it = this.f55359c.iterator();
        while (it.hasNext()) {
            it.next().m71673a();
        }
        this.f55359c.clear();
        Selector selector = this.f55365i;
        if (selector != null) {
            try {
                try {
                    selector.close();
                } catch (IOException unused) {
                    m71667k("Selector close error", null);
                } catch (Exception e10) {
                    m71667k("Selector close error", e10);
                }
            } finally {
                this.f55365i = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m71667k(String str, Throwable th2) {
        C13893h.m83291l().mo83257s(4, str, th2);
    }

    /* renamed from: b */
    public void mo71644b() {
        Selector selector;
        if (this.f55365i != null) {
            synchronized (this.f55366j) {
                try {
                    try {
                        try {
                            this.f55367k = true;
                            selector = this.f55365i;
                        } catch (IOException unused) {
                            m71667k("Selector close error", null);
                        }
                    } catch (Exception unused2) {
                        m71667k("Selector close exception", null);
                    }
                    if (selector != null) {
                        selector.close();
                    }
                } finally {
                    this.f55365i = null;
                }
            }
        }
    }

    /* renamed from: c */
    public final void m71668c(long j10) {
        while (this.f55359c.size() > 0) {
            b bVar = this.f55359c.get(0);
            if (!bVar.m71675c()) {
                return;
            } else {
                m71671j(bVar);
            }
        }
    }

    /* renamed from: d */
    public void mo71645d(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        if (inetSocketAddress2 == null) {
            this.f55364h = true;
        } else if (inetSocketAddress.getAddress().getAddress().length == inetSocketAddress2.getAddress().getAddress().length) {
            this.f55364h = true;
        } else {
            this.f55364h = false;
        }
    }

    /* renamed from: f */
    public List<InetSocketAddress> mo71647f() {
        return this.f55358b;
    }

    /* renamed from: g */
    public final SocketChannel m71669g() {
        Iterator<SelectionKey> it = this.f55365i.selectedKeys().iterator();
        SocketChannel socketChannel = null;
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            if (next.isConnectable() && next.attachment() != null) {
                b bVar = (b) next.attachment();
                try {
                    SocketChannel socketChannel2 = bVar.f55370a;
                    if (socketChannel2.finishConnect()) {
                        next.cancel();
                        try {
                            this.f55359c.remove(bVar);
                            this.f55368l = bVar.f55371b;
                            return socketChannel2;
                        } catch (IOException unused) {
                            socketChannel = socketChannel2;
                            next.cancel();
                            m71671j(bVar);
                        }
                    } else {
                        next.cancel();
                        m71671j(bVar);
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return socketChannel;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.net.Socket mo71648h(long r7, javax.net.SocketFactory r9, java.net.Proxy r10, okhttp3.InterfaceC11919f r11, okhttp3.AbstractC11953t r12) throws java.io.IOException {
        /*
            r6 = this;
            r9 = 0
            java.nio.channels.Selector r0 = java.nio.channels.Selector.open()     // Catch: java.io.IOException -> L37
            r6.f55365i = r0     // Catch: java.io.IOException -> L37
            r0 = r6
            r1 = r7
            r3 = r10
            r4 = r11
            r5 = r12
            java.nio.channels.SocketChannel r7 = r0.m71670i(r1, r3, r4, r5)     // Catch: java.nio.channels.ClosedSelectorException -> L27
            if (r7 == 0) goto L2e
            r8 = 1
            r7.configureBlocking(r8)     // Catch: java.nio.channels.ClosedSelectorException -> L17 java.io.IOException -> L19
            goto L2e
        L17:
            r8 = move-exception
            goto L29
        L19:
            r7.close()     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L20
        L1c:
            r7 = r9
            goto L2e
        L1e:
            r7 = move-exception
            goto L26
        L20:
            java.lang.String r7 = "Socket channel close error"
            r6.m71667k(r7, r9)     // Catch: java.lang.Throwable -> L1e
            goto L1c
        L26:
            throw r7     // Catch: java.nio.channels.ClosedSelectorException -> L27
        L27:
            r8 = move-exception
            r7 = r9
        L29:
            java.lang.String r10 = "Selector is already closed"
            r6.m71667k(r10, r8)
        L2e:
            r6.m71666e()
            if (r7 == 0) goto L37
            java.net.Socket r9 = r7.socket()
        L37:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C11929c.mo71648h(long, javax.net.SocketFactory, java.net.Proxy, okhttp3.f, okhttp3.t):java.net.Socket");
    }

    /* renamed from: i */
    public final SocketChannel m71670i(long j10, Proxy proxy, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t) throws IOException {
        int i10 = this.f55361e;
        long j11 = i10;
        long j12 = j10 - i10;
        SocketChannel socketChannelM71669g = null;
        boolean z10 = true;
        while (!this.f55367k) {
            if (this.f55357a.size() > 0 && z10) {
                InetSocketAddress inetSocketAddressRemove = this.f55357a.remove(0);
                if (this.f55357a.isEmpty()) {
                    mo71645d(inetSocketAddressRemove, null);
                } else {
                    mo71645d(inetSocketAddressRemove, this.f55357a.get(0));
                }
                if (this.f55364h) {
                    this.f55361e = this.f55362f;
                } else {
                    this.f55361e = this.f55363g;
                }
                int i11 = this.f55361e;
                long j13 = i11;
                long j14 = j10 - i11;
                if (m71672l(inetSocketAddressRemove, j10, proxy, interfaceC11919f, abstractC11953t)) {
                    j12 = j14 + this.f55361e;
                    z10 = false;
                    j11 = j13;
                } else {
                    j11 = j13;
                    j12 = j14;
                }
            }
            if (this.f55359c.isEmpty() && this.f55357a.isEmpty()) {
                return null;
            }
            long jM71674b = this.f55359c.size() > 0 ? this.f55359c.get(0).m71674b() : j12;
            if (this.f55357a.size() > 0 && jM71674b > j11) {
                jM71674b = j11;
            }
            long jNanoTime = System.nanoTime();
            try {
                this.f55365i.select(jM71674b);
                if (this.f55367k) {
                    return null;
                }
                long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
                socketChannelM71669g = m71669g();
                if (socketChannelM71669g != null) {
                    break;
                }
                m71668c(millis);
                if (this.f55358b.size() == this.f55360d || millis >= j12) {
                    break;
                }
                j12 -= millis;
                if (this.f55357a.size() > 0) {
                    if (millis >= j11) {
                        int i12 = this.f55361e;
                        z10 = true;
                        j11 = i12 - ((millis - j11) % i12);
                    } else {
                        j11 -= millis;
                    }
                }
            } catch (IOException unused) {
                return null;
            }
        }
        return socketChannelM71669g;
    }

    /* renamed from: j */
    public final void m71671j(b bVar) {
        this.f55358b.add(bVar.f55371b);
        this.f55359c.remove(bVar);
        bVar.m71673a();
    }

    /* renamed from: l */
    public final boolean m71672l(InetSocketAddress inetSocketAddress, long j10, Proxy proxy, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t) {
        b bVar = new b();
        try {
            bVar.m71676d(inetSocketAddress, j10, this.f55369m, proxy, interfaceC11919f, abstractC11953t);
            synchronized (this.f55366j) {
                try {
                    Selector selector = this.f55365i;
                    if (selector == null) {
                        return false;
                    }
                    bVar.f55370a.register(selector, 8).attach(bVar);
                    this.f55359c.add(bVar);
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (IOException unused) {
            m71667k("Failed to parepare socket channel for " + inetSocketAddress.toString(), null);
            this.f55358b.add(inetSocketAddress);
            bVar.m71673a();
            return false;
        }
    }
}
