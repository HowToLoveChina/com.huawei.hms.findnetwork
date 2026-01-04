package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;

/* renamed from: com.huawei.hms.network.embedded.q8 */
/* loaded from: classes8.dex */
public class C6063q8 extends C6089s8 {

    /* renamed from: v */
    public static ThreadFactory f27922v;

    /* renamed from: w */
    public static ExecutorService f27923w;

    /* renamed from: n */
    public final CopyOnWriteArrayList<InetSocketAddress> f27924n;

    /* renamed from: o */
    public final CopyOnWriteArrayList<InetSocketAddress> f27925o;

    /* renamed from: p */
    public final CopyOnWriteArrayList<b> f27926p;

    /* renamed from: q */
    public int f27927q;

    /* renamed from: r */
    public BlockingQueue<b> f27928r;

    /* renamed from: s */
    public b f27929s;

    /* renamed from: t */
    public volatile boolean f27930t;

    /* renamed from: u */
    public long f27931u;

    /* renamed from: com.huawei.hms.network.embedded.q8$a */
    public class a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f27932a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, " OkHttp_" + this.f27932a.getAndIncrement() + " concurrentConnect");
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.q8$b */
    public static final class b implements Callable<b> {

        /* renamed from: m */
        public static b f27933m = new b();

        /* renamed from: a */
        public String f27934a;

        /* renamed from: b */
        public InetSocketAddress f27935b;

        /* renamed from: c */
        public Proxy f27936c;

        /* renamed from: d */
        public SocketFactory f27937d;

        /* renamed from: e */
        public InterfaceC6100t6 f27938e;

        /* renamed from: f */
        public AbstractC5932g7 f27939f;

        /* renamed from: g */
        public long f27940g;

        /* renamed from: h */
        public int f27941h;

        /* renamed from: i */
        public Socket f27942i;

        /* renamed from: j */
        public volatile boolean f27943j;

        /* renamed from: k */
        public Queue f27944k;

        /* renamed from: l */
        public int f27945l;

        public b() {
            this.f27943j = false;
        }

        /* renamed from: b */
        public long m35161b() {
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            long j10 = this.f27940g;
            if (millis >= j10) {
                return 0L;
            }
            return j10 - millis;
        }

        /* renamed from: c */
        public boolean m35162c() {
            return TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) >= this.f27940g;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public b call() throws Exception {
            Thread.currentThread().setName(this.f27934a + Thread.currentThread().getName());
            this.f27939f.connectStart(this.f27938e, this.f27935b, this.f27936c);
            Socket socketCreateSocket = (this.f27936c.type() == Proxy.Type.DIRECT || this.f27936c.type() == Proxy.Type.HTTP) ? this.f27937d.createSocket() : new Socket(this.f27936c);
            this.f27942i = socketCreateSocket;
            socketCreateSocket.setTrafficClass(this.f27945l);
            try {
                this.f27942i.connect(this.f27935b, this.f27941h);
                if (this.f27943j) {
                    C5920f8.m34251a(this.f27942i);
                    return null;
                }
                if (this.f27942i.isClosed()) {
                    return null;
                }
                this.f27944k.add(this);
                return this;
            } catch (IOException | RuntimeException e10) {
                C5920f8.m34251a(this.f27942i);
                m35157a(e10);
                throw new IOException("ConnectTask call error ", e10);
            }
        }

        public b(InetSocketAddress inetSocketAddress, long j10, int i10, SocketFactory socketFactory, Proxy proxy, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7, Queue queue) {
            this.f27943j = false;
            this.f27934a = Thread.currentThread().getName();
            this.f27935b = inetSocketAddress;
            this.f27936c = proxy;
            this.f27937d = socketFactory;
            this.f27938e = interfaceC6100t6;
            this.f27939f = abstractC5932g7;
            this.f27941h = (int) j10;
            this.f27944k = queue;
            this.f27945l = i10;
            this.f27940g = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) + j10;
        }

        /* renamed from: a */
        public void m35160a() throws IOException {
            this.f27943j = true;
            Socket socket = this.f27942i;
            if (socket == null || socket.isClosed()) {
                return;
            }
            C5920f8.m34251a(this.f27942i);
        }

        /* renamed from: a */
        private void m35157a(Exception exc) {
            C6063q8.m35147b("address " + this.f27935b + " connect failed", exc);
        }
    }

    static {
        a aVar = new a();
        f27922v = aVar;
        f27923w = Executors.newCachedThreadPool(aVar);
    }

    public C6063q8(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        super(copyOnWriteArrayList, i10, i11);
        this.f27925o = new CopyOnWriteArrayList<>();
        this.f27926p = new CopyOnWriteArrayList<>();
        this.f27928r = new LinkedBlockingQueue();
        this.f27924n = copyOnWriteArrayList;
        this.f28220f = i10;
        this.f28221g = i10 / 2;
    }

    /* renamed from: a */
    private b m35143a(InterfaceC6100t6 interfaceC6100t6, long j10, SocketFactory socketFactory, Proxy proxy, AbstractC5932g7 abstractC5932g7, Queue queue) {
        if (this.f27924n.isEmpty()) {
            return null;
        }
        InetSocketAddress inetSocketAddressRemove = this.f27924n.remove(0);
        if (this.f27924n.isEmpty()) {
            mo35154a(inetSocketAddressRemove, (InetSocketAddress) null);
        } else {
            mo35154a(inetSocketAddressRemove, this.f27924n.get(0));
        }
        return new b(inetSocketAddressRemove, j10, this.f28227m, socketFactory, proxy, interfaceC6100t6, abstractC5932g7, queue);
    }

    /* renamed from: c */
    private void m35148c() throws IOException {
        b bVar;
        if (!this.f27930t && (bVar = this.f27929s) != null) {
            this.f27926p.remove(bVar);
        }
        Iterator<b> it = this.f27926p.iterator();
        while (it.hasNext()) {
            b next = it.next();
            try {
                if (next != this.f27929s && next.m35162c()) {
                    m35146a(next.f27935b);
                }
                next.m35160a();
            } catch (ConcurrentModificationException e10) {
                m35147b(e10.getMessage(), e10);
            }
        }
        this.f27926p.clear();
    }

    /* renamed from: d */
    private int m35149d() {
        int size;
        synchronized (this.f27925o) {
            size = this.f27925o.size();
        }
        return size;
    }

    /* renamed from: e */
    private Socket m35150e() {
        b bVar = this.f27929s;
        if (bVar != null) {
            return bVar.f27942i;
        }
        return null;
    }

    /* renamed from: f */
    private synchronized boolean m35151f() {
        return this.f27929s != null;
    }

    @Override // com.huawei.hms.network.embedded.C6089s8
    /* renamed from: b */
    public List<InetSocketAddress> mo35155b() {
        return this.f27925o;
    }

    /* renamed from: b */
    public static void m35147b(String str, Throwable th2) {
        C6013ma.m34863f().mo34331a(4, str, th2);
    }

    @Override // com.huawei.hms.network.embedded.C6089s8
    /* renamed from: a */
    public Socket mo35152a(long j10, SocketFactory socketFactory, Proxy proxy, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7) throws InterruptedException, IOException {
        b bVar;
        int size = this.f27924n.isEmpty() ? 0 : this.f27924n.size();
        while (!this.f27924n.isEmpty() && !m35151f()) {
            if (this.f27930t) {
                m35148c();
                return null;
            }
            this.f27931u = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            b bVarM35143a = m35143a(interfaceC6100t6, j10, socketFactory, proxy, abstractC5932g7, this.f27928r);
            if (bVarM35143a != null) {
                try {
                    f27923w.submit(bVarM35143a);
                    this.f27926p.add(bVarM35143a);
                } catch (RejectedExecutionException e10) {
                    m35147b(e10.getMessage(), e10);
                }
                try {
                    if (this.f27930t) {
                        m35148c();
                        return null;
                    }
                    if (m35151f()) {
                        m35148c();
                        return m35150e();
                    }
                    int i10 = this.f28222h ? this.f28220f : this.f28221g;
                    this.f27927q = i10;
                    b bVarPoll = this.f27928r.poll(i10 - (TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) - this.f27931u), TimeUnit.MILLISECONDS);
                    if (this.f27930t) {
                        m35148c();
                        return null;
                    }
                    if (bVarPoll != null) {
                        m35144a(bVarPoll);
                    }
                } catch (InterruptedException e11) {
                    m35147b(e11.getMessage(), e11);
                }
            }
        }
        ArrayList arrayList = new ArrayList(this.f27926p);
        if (!this.f27930t && !m35151f() && m35149d() != size && !arrayList.isEmpty()) {
            try {
                bVar = (b) arrayList.get(arrayList.size() - 1);
            } catch (IndexOutOfBoundsException e12) {
                m35147b(e12.getMessage(), e12);
                bVar = null;
            }
            if (bVar != null) {
                try {
                    b bVarPoll2 = this.f27928r.poll(bVar.m35161b(), TimeUnit.MILLISECONDS);
                    if (!this.f27930t) {
                        if (bVarPoll2 == null) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                m35146a(((b) it.next()).f27935b);
                            }
                        } else {
                            m35144a(bVarPoll2);
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                b bVar2 = (b) it2.next();
                                if (bVar2 != this.f27929s && bVar2.m35162c()) {
                                    m35146a(bVar2.f27935b);
                                }
                            }
                        }
                    }
                } catch (InterruptedException e13) {
                    m35147b(e13.getMessage(), e13);
                }
            }
        }
        b bVar3 = this.f27929s;
        if (bVar3 != null) {
            this.f28226l = bVar3.f27935b;
        }
        try {
            m35148c();
        } catch (RuntimeException unused) {
            m35147b("ClearResource with RuntimeException error", null);
        }
        return m35150e();
    }

    @Override // com.huawei.hms.network.embedded.C6089s8
    /* renamed from: a */
    public void mo35153a() {
        this.f27930t = true;
        this.f27928r.add(b.f27933m);
    }

    /* renamed from: a */
    private synchronized void m35144a(b bVar) {
        if (this.f27929s != null) {
            return;
        }
        this.f27929s = bVar;
    }

    /* renamed from: a */
    private void m35146a(InetSocketAddress inetSocketAddress) {
        synchronized (this.f27925o) {
            try {
                if (!this.f27925o.contains(inetSocketAddress)) {
                    this.f27925o.add(inetSocketAddress);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.network.embedded.C6089s8
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo35154a(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        super.mo35154a(inetSocketAddress, inetSocketAddress2);
    }
}
