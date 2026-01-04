package com.huawei.hms.drive;

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

/* renamed from: com.huawei.hms.drive.bx */
/* loaded from: classes8.dex */
class C5219bx {

    /* renamed from: a */
    public int f24070a;

    /* renamed from: b */
    public int f24071b;

    /* renamed from: c */
    public boolean f24072c;

    /* renamed from: d */
    public InetSocketAddress f24073d;

    /* renamed from: e */
    protected int f24074e;

    /* renamed from: f */
    private final CopyOnWriteArrayList<InetSocketAddress> f24075f;

    /* renamed from: i */
    private final int f24078i;

    /* renamed from: j */
    private int f24079j;

    /* renamed from: k */
    private Selector f24080k;

    /* renamed from: g */
    private final CopyOnWriteArrayList<InetSocketAddress> f24076g = new CopyOnWriteArrayList<>();

    /* renamed from: h */
    private final CopyOnWriteArrayList<a> f24077h = new CopyOnWriteArrayList<>();

    /* renamed from: l */
    private Object f24081l = new Object();

    /* renamed from: m */
    private volatile boolean f24082m = false;

    public C5219bx(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        this.f24075f = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        this.f24079j = i10;
        this.f24070a = i10;
        this.f24071b = i10 / 2;
        this.f24074e = i11;
        this.f24078i = copyOnWriteArrayList.size();
    }

    /* renamed from: c */
    private SocketChannel m31270c() {
        Iterator<SelectionKey> it = this.f24080k.selectedKeys().iterator();
        SocketChannel socketChannel = null;
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            if (next.isConnectable() && next.attachment() != null) {
                a aVar = (a) next.attachment();
                try {
                    SocketChannel socketChannel2 = aVar.f24083a;
                    if (socketChannel2.finishConnect()) {
                        next.cancel();
                        try {
                            this.f24077h.remove(aVar);
                            this.f24073d = aVar.f24084b;
                            return socketChannel2;
                        } catch (IOException unused) {
                            socketChannel = socketChannel2;
                            next.cancel();
                            m31266a(aVar);
                        }
                    } else {
                        next.cancel();
                        m31266a(aVar);
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return socketChannel;
    }

    /* renamed from: d */
    private void m31271d() {
        Iterator<a> it = this.f24077h.iterator();
        while (it.hasNext()) {
            it.next().m31272a();
        }
        this.f24077h.clear();
        Selector selector = this.f24080k;
        if (selector != null) {
            try {
                try {
                    selector.close();
                } catch (IOException unused) {
                    m31268a("Selector close error", (Throwable) null);
                } catch (Exception e10) {
                    m31268a("Selector close error", e10);
                }
            } finally {
                this.f24080k = null;
            }
        }
    }

    /* renamed from: b */
    public void mo31253b() {
        Selector selector;
        if (this.f24080k != null) {
            synchronized (this.f24081l) {
                try {
                    try {
                        try {
                            this.f24082m = true;
                            selector = this.f24080k;
                        } catch (IOException unused) {
                            m31268a("Selector close error", (Throwable) null);
                        }
                    } catch (Exception unused2) {
                        m31268a("Selector close exception", (Throwable) null);
                    }
                    if (selector != null) {
                        selector.close();
                    }
                } finally {
                    this.f24080k = null;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.net.Socket mo31250a(long r7, javax.net.SocketFactory r9, java.net.Proxy r10, com.huawei.hms.drive.InterfaceC5177aj r11, com.huawei.hms.drive.AbstractC5188au r12) throws java.io.IOException {
        /*
            r6 = this;
            r9 = 0
            java.nio.channels.Selector r0 = java.nio.channels.Selector.open()     // Catch: java.io.IOException -> L37
            r6.f24080k = r0     // Catch: java.io.IOException -> L37
            r0 = r6
            r1 = r7
            r3 = r10
            r4 = r11
            r5 = r12
            java.nio.channels.SocketChannel r7 = r0.m31264a(r1, r3, r4, r5)     // Catch: java.nio.channels.ClosedSelectorException -> L27
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
            r6.m31268a(r7, r9)     // Catch: java.lang.Throwable -> L1e
            goto L1c
        L26:
            throw r7     // Catch: java.nio.channels.ClosedSelectorException -> L27
        L27:
            r8 = move-exception
            r7 = r9
        L29:
            java.lang.String r10 = "Selector is already closed"
            r6.m31268a(r10, r8)
        L2e:
            r6.m31271d()
            if (r7 == 0) goto L37
            java.net.Socket r9 = r7.socket()
        L37:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5219bx.mo31250a(long, javax.net.SocketFactory, java.net.Proxy, com.huawei.hms.drive.aj, com.huawei.hms.drive.au):java.net.Socket");
    }

    /* renamed from: com.huawei.hms.drive.bx$a */
    public final class a {

        /* renamed from: a */
        SocketChannel f24083a;

        /* renamed from: b */
        InetSocketAddress f24084b;

        /* renamed from: c */
        long f24085c;

        private a() {
            this.f24083a = null;
            this.f24084b = null;
            this.f24085c = 0L;
        }

        /* renamed from: a */
        public void m31273a(InetSocketAddress inetSocketAddress, long j10, int i10, Proxy proxy, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au) throws IOException {
            this.f24084b = inetSocketAddress;
            this.f24085c = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) + j10;
            abstractC5188au.m30900a(interfaceC5177aj, inetSocketAddress, proxy);
            SocketChannel socketChannelOpen = SocketChannel.open();
            this.f24083a = socketChannelOpen;
            socketChannelOpen.configureBlocking(false);
            this.f24083a.socket().setTrafficClass(i10);
            this.f24083a.connect(inetSocketAddress);
        }

        /* renamed from: b */
        public boolean m31274b() {
            return TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) >= this.f24085c;
        }

        /* renamed from: c */
        public long m31275c() {
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            long j10 = this.f24085c;
            if (millis >= j10) {
                return 0L;
            }
            return j10 - millis;
        }

        /* renamed from: a */
        public void m31272a() {
            SocketChannel socketChannel = this.f24083a;
            if (socketChannel == null) {
                return;
            }
            try {
                try {
                    socketChannel.close();
                } catch (IOException unused) {
                    C5219bx.this.m31268a("Socket channel close error", (Throwable) null);
                }
            } finally {
                this.f24083a = null;
            }
        }
    }

    /* renamed from: a */
    public List<InetSocketAddress> mo31251a() {
        return this.f24076g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m31268a(String str, Throwable th2) {
        C5269dr.m31692e().mo31656a(4, str, th2);
    }

    /* renamed from: a */
    private SocketChannel m31264a(long j10, Proxy proxy, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au) throws IOException {
        int i10 = this.f24079j;
        long j11 = i10;
        long j12 = j10 - i10;
        SocketChannel socketChannelM31270c = null;
        boolean z10 = true;
        while (!this.f24082m) {
            if (this.f24075f.size() > 0 && z10) {
                InetSocketAddress inetSocketAddressRemove = this.f24075f.remove(0);
                if (!this.f24075f.isEmpty()) {
                    mo31252a(inetSocketAddressRemove, this.f24075f.get(0));
                } else {
                    mo31252a(inetSocketAddressRemove, (InetSocketAddress) null);
                }
                if (this.f24072c) {
                    this.f24079j = this.f24070a;
                } else {
                    this.f24079j = this.f24071b;
                }
                int i11 = this.f24079j;
                long j13 = i11;
                long j14 = j10 - i11;
                if (m31269a(inetSocketAddressRemove, j10, proxy, interfaceC5177aj, abstractC5188au)) {
                    j12 = j14 + this.f24079j;
                    z10 = false;
                    j11 = j13;
                } else {
                    j11 = j13;
                    j12 = j14;
                }
            }
            if (this.f24077h.isEmpty() && this.f24075f.isEmpty()) {
                return null;
            }
            long jM31275c = this.f24077h.size() > 0 ? this.f24077h.get(0).m31275c() : j12;
            if (this.f24075f.size() > 0 && jM31275c > j11) {
                jM31275c = j11;
            }
            long jNanoTime = System.nanoTime();
            try {
                this.f24080k.select(jM31275c);
                if (this.f24082m) {
                    return null;
                }
                long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
                socketChannelM31270c = m31270c();
                if (socketChannelM31270c != null) {
                    break;
                }
                m31265a(millis);
                if (this.f24076g.size() == this.f24078i || millis >= j12) {
                    break;
                }
                j12 -= millis;
                if (this.f24075f.size() > 0) {
                    if (millis >= j11) {
                        int i12 = this.f24079j;
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
        return socketChannelM31270c;
    }

    /* renamed from: a */
    private boolean m31269a(InetSocketAddress inetSocketAddress, long j10, Proxy proxy, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au) {
        a aVar = new a();
        try {
            aVar.m31273a(inetSocketAddress, j10, this.f24074e, proxy, interfaceC5177aj, abstractC5188au);
            synchronized (this.f24081l) {
                try {
                    Selector selector = this.f24080k;
                    if (selector == null) {
                        return false;
                    }
                    aVar.f24083a.register(selector, 8).attach(aVar);
                    this.f24077h.add(aVar);
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (IOException unused) {
            m31268a("Failed to parepare socket channel for " + inetSocketAddress.toString(), (Throwable) null);
            this.f24076g.add(inetSocketAddress);
            aVar.m31272a();
            return false;
        }
    }

    /* renamed from: a */
    private void m31266a(a aVar) {
        this.f24076g.add(aVar.f24084b);
        this.f24077h.remove(aVar);
        aVar.m31272a();
    }

    /* renamed from: a */
    private void m31265a(long j10) {
        while (this.f24077h.size() > 0) {
            a aVar = this.f24077h.get(0);
            if (!aVar.m31274b()) {
                return;
            } else {
                m31266a(aVar);
            }
        }
    }

    /* renamed from: a */
    public void mo31252a(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        if (inetSocketAddress2 != null) {
            if (inetSocketAddress.getAddress().getAddress().length == inetSocketAddress2.getAddress().getAddress().length) {
                this.f24072c = true;
                return;
            } else {
                this.f24072c = false;
                return;
            }
        }
        this.f24072c = true;
    }
}
