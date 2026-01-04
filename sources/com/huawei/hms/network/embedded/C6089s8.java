package com.huawei.hms.network.embedded;

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

/* renamed from: com.huawei.hms.network.embedded.s8 */
/* loaded from: classes8.dex */
public class C6089s8 {

    /* renamed from: a */
    public final CopyOnWriteArrayList<InetSocketAddress> f28215a;

    /* renamed from: d */
    public final int f28218d;

    /* renamed from: e */
    public int f28219e;

    /* renamed from: f */
    public int f28220f;

    /* renamed from: g */
    public int f28221g;

    /* renamed from: h */
    public boolean f28222h;

    /* renamed from: i */
    public Selector f28223i;

    /* renamed from: l */
    public InetSocketAddress f28226l;

    /* renamed from: m */
    public int f28227m;

    /* renamed from: b */
    public final CopyOnWriteArrayList<InetSocketAddress> f28216b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    public final CopyOnWriteArrayList<b> f28217c = new CopyOnWriteArrayList<>();

    /* renamed from: j */
    public Object f28224j = new Object();

    /* renamed from: k */
    public volatile boolean f28225k = false;

    /* renamed from: com.huawei.hms.network.embedded.s8$b */
    public final class b {

        /* renamed from: a */
        public SocketChannel f28228a;

        /* renamed from: b */
        public InetSocketAddress f28229b;

        /* renamed from: c */
        public long f28230c;

        public b() {
            this.f28228a = null;
            this.f28229b = null;
            this.f28230c = 0L;
        }

        /* renamed from: a */
        public void m35301a() {
            SocketChannel socketChannel = this.f28228a;
            if (socketChannel == null) {
                return;
            }
            try {
                try {
                    socketChannel.close();
                } catch (IOException unused) {
                    C6089s8.this.m35297a("Socket channel close error", (Throwable) null);
                }
            } finally {
                this.f28228a = null;
            }
        }

        /* renamed from: b */
        public long m35303b() {
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            long j10 = this.f28230c;
            if (millis >= j10) {
                return 0L;
            }
            return j10 - millis;
        }

        /* renamed from: c */
        public boolean m35304c() {
            return TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) >= this.f28230c;
        }

        /* renamed from: a */
        public void m35302a(InetSocketAddress inetSocketAddress, long j10, int i10, Proxy proxy, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7) throws IOException {
            this.f28229b = inetSocketAddress;
            this.f28230c = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) + j10;
            abstractC5932g7.connectStart(interfaceC6100t6, inetSocketAddress, proxy);
            SocketChannel socketChannelOpen = SocketChannel.open();
            this.f28228a = socketChannelOpen;
            socketChannelOpen.configureBlocking(false);
            this.f28228a.socket().setTrafficClass(i10);
            this.f28228a.connect(inetSocketAddress);
        }
    }

    public C6089s8(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        this.f28215a = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        this.f28219e = i10;
        this.f28220f = i10;
        this.f28221g = i10 / 2;
        this.f28227m = i11;
        this.f28218d = copyOnWriteArrayList.size();
    }

    /* renamed from: c */
    private void m35299c() {
        Iterator<b> it = this.f28217c.iterator();
        while (it.hasNext()) {
            it.next().m35301a();
        }
        this.f28217c.clear();
        Selector selector = this.f28223i;
        if (selector != null) {
            try {
                try {
                    try {
                        selector.close();
                    } catch (IOException unused) {
                        m35297a("Selector close error", (Throwable) null);
                    }
                } catch (Exception e10) {
                    m35297a("Selector close error", e10);
                }
            } finally {
                this.f28223i = null;
            }
        }
    }

    /* renamed from: d */
    private SocketChannel m35300d() {
        Iterator<SelectionKey> it = this.f28223i.selectedKeys().iterator();
        SocketChannel socketChannel = null;
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            if (next.isConnectable() && next.attachment() != null) {
                b bVar = (b) next.attachment();
                try {
                    SocketChannel socketChannel2 = bVar.f28228a;
                    if (socketChannel2.finishConnect()) {
                        next.cancel();
                        try {
                            this.f28217c.remove(bVar);
                            this.f28226l = bVar.f28229b;
                            return socketChannel2;
                        } catch (IOException unused) {
                            socketChannel = socketChannel2;
                            next.cancel();
                            m35295a(bVar);
                        }
                    } else {
                        next.cancel();
                        m35295a(bVar);
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return socketChannel;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.net.Socket mo35152a(long r7, javax.net.SocketFactory r9, java.net.Proxy r10, com.huawei.hms.network.embedded.InterfaceC6100t6 r11, com.huawei.hms.network.embedded.AbstractC5932g7 r12) throws java.io.IOException {
        /*
            r6 = this;
            r9 = 0
            java.nio.channels.Selector r0 = java.nio.channels.Selector.open()     // Catch: java.io.IOException -> L37
            r6.f28223i = r0     // Catch: java.io.IOException -> L37
            r0 = r6
            r1 = r7
            r3 = r10
            r4 = r11
            r5 = r12
            java.nio.channels.SocketChannel r7 = r0.m35293a(r1, r3, r4, r5)     // Catch: java.nio.channels.ClosedSelectorException -> L27
            if (r7 == 0) goto L2e
            r8 = 1
            r7.configureBlocking(r8)     // Catch: java.nio.channels.ClosedSelectorException -> L17 java.io.IOException -> L19
            goto L2e
        L17:
            r8 = move-exception
            goto L29
        L19:
            r7.close()     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L1f
            goto L24
        L1d:
            r7 = move-exception
            goto L26
        L1f:
            java.lang.String r7 = "Socket channel close error"
            r6.m35297a(r7, r9)     // Catch: java.lang.Throwable -> L1d
        L24:
            r7 = r9
            goto L2e
        L26:
            throw r7     // Catch: java.nio.channels.ClosedSelectorException -> L27
        L27:
            r8 = move-exception
            r7 = r9
        L29:
            java.lang.String r10 = "Selector is already closed"
            r6.m35297a(r10, r8)
        L2e:
            r6.m35299c()
            if (r7 == 0) goto L37
            java.net.Socket r9 = r7.socket()
        L37:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6089s8.mo35152a(long, javax.net.SocketFactory, java.net.Proxy, com.huawei.hms.network.embedded.t6, com.huawei.hms.network.embedded.g7):java.net.Socket");
    }

    /* renamed from: b */
    public List<InetSocketAddress> mo35155b() {
        return this.f28216b;
    }

    /* renamed from: a */
    private SocketChannel m35293a(long j10, Proxy proxy, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7) throws IOException {
        long millis;
        long j11 = this.f28219e;
        long j12 = j10 - j11;
        SocketChannel socketChannelM35300d = null;
        loop0: while (true) {
            boolean z10 = true;
            while (!this.f28225k) {
                if (this.f28215a.size() > 0 && z10) {
                    InetSocketAddress inetSocketAddressRemove = this.f28215a.remove(0);
                    if (this.f28215a.isEmpty()) {
                        mo35154a(inetSocketAddressRemove, (InetSocketAddress) null);
                    } else {
                        mo35154a(inetSocketAddressRemove, this.f28215a.get(0));
                    }
                    this.f28219e = this.f28222h ? this.f28220f : this.f28221g;
                    long j13 = this.f28219e;
                    long j14 = j10 - j13;
                    if (m35298a(inetSocketAddressRemove, j10, proxy, interfaceC6100t6, abstractC5932g7)) {
                        j12 = j14 + this.f28219e;
                        z10 = false;
                        j11 = j13;
                    } else {
                        j11 = j13;
                        j12 = j14;
                    }
                }
                if (this.f28217c.isEmpty() && this.f28215a.isEmpty()) {
                    return null;
                }
                long jM35303b = this.f28217c.size() > 0 ? this.f28217c.get(0).m35303b() : j12;
                if (this.f28215a.size() > 0 && jM35303b > j11) {
                    jM35303b = j11;
                }
                long jNanoTime = System.nanoTime();
                try {
                    this.f28223i.select(jM35303b);
                    if (this.f28225k) {
                        return null;
                    }
                    millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
                    socketChannelM35300d = m35300d();
                    if (socketChannelM35300d != null) {
                        break loop0;
                    }
                    m35294a(millis);
                    if (this.f28216b.size() == this.f28218d || millis >= j12) {
                        break loop0;
                    }
                    j12 -= millis;
                    if (this.f28215a.size() <= 0) {
                        continue;
                    } else {
                        if (millis >= j11) {
                            break;
                        }
                        j11 -= millis;
                    }
                } catch (IOException unused) {
                    return null;
                }
            }
            long j15 = this.f28219e;
            j11 = j15 - ((millis - j11) % j15);
        }
        return socketChannelM35300d;
    }

    /* renamed from: a */
    public void mo35153a() {
        String str;
        if (this.f28223i != null) {
            synchronized (this.f28224j) {
                try {
                    try {
                        this.f28225k = true;
                        Selector selector = this.f28223i;
                        if (selector != null) {
                            selector.close();
                        }
                    } catch (IOException unused) {
                        str = "Selector close error";
                        m35297a(str, (Throwable) null);
                    } catch (Exception unused2) {
                        str = "Selector close exception";
                        m35297a(str, (Throwable) null);
                    }
                } finally {
                    this.f28223i = null;
                }
            }
        }
    }

    /* renamed from: a */
    private void m35294a(long j10) {
        while (this.f28217c.size() > 0) {
            b bVar = this.f28217c.get(0);
            if (!bVar.m35304c()) {
                return;
            } else {
                m35295a(bVar);
            }
        }
    }

    /* renamed from: a */
    private void m35295a(b bVar) {
        this.f28216b.add(bVar.f28229b);
        this.f28217c.remove(bVar);
        bVar.m35301a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m35297a(String str, Throwable th2) {
        C6013ma.m34863f().mo34331a(4, str, th2);
    }

    /* renamed from: a */
    public void mo35154a(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        this.f28222h = inetSocketAddress2 == null || inetSocketAddress.getAddress().getAddress().length == inetSocketAddress2.getAddress().getAddress().length;
    }

    /* renamed from: a */
    private boolean m35298a(InetSocketAddress inetSocketAddress, long j10, Proxy proxy, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7) {
        b bVar = new b();
        try {
            bVar.m35302a(inetSocketAddress, j10, this.f28227m, proxy, interfaceC6100t6, abstractC5932g7);
            synchronized (this.f28224j) {
                try {
                    Selector selector = this.f28223i;
                    if (selector == null) {
                        return false;
                    }
                    bVar.f28228a.register(selector, 8).attach(bVar);
                    this.f28217c.add(bVar);
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (IOException unused) {
            m35297a("Failed to parepare socket channel for " + inetSocketAddress.toString(), (Throwable) null);
            this.f28216b.add(inetSocketAddress);
            bVar.m35301a();
            return false;
        }
    }
}
