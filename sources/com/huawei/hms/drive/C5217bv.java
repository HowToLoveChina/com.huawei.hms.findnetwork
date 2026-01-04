package com.huawei.hms.drive;

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

/* renamed from: com.huawei.hms.drive.bv */
/* loaded from: classes8.dex */
public class C5217bv extends C5219bx {

    /* renamed from: f */
    private static ThreadFactory f24046f;

    /* renamed from: g */
    private static ExecutorService f24047g;

    /* renamed from: h */
    private final CopyOnWriteArrayList<InetSocketAddress> f24048h;

    /* renamed from: i */
    private final CopyOnWriteArrayList<InetSocketAddress> f24049i;

    /* renamed from: j */
    private final CopyOnWriteArrayList<a> f24050j;

    /* renamed from: k */
    private int f24051k;

    /* renamed from: l */
    private BlockingQueue<a> f24052l;

    /* renamed from: m */
    private a f24053m;

    /* renamed from: n */
    private volatile boolean f24054n;

    /* renamed from: o */
    private long f24055o;

    /* renamed from: com.huawei.hms.drive.bv$a */
    public static final class a implements Callable<a> {

        /* renamed from: a */
        private static a f24057a = new a();

        /* renamed from: b */
        private String f24058b;

        /* renamed from: c */
        private InetSocketAddress f24059c;

        /* renamed from: d */
        private Proxy f24060d;

        /* renamed from: e */
        private SocketFactory f24061e;

        /* renamed from: f */
        private InterfaceC5177aj f24062f;

        /* renamed from: g */
        private AbstractC5188au f24063g;

        /* renamed from: h */
        private long f24064h;

        /* renamed from: i */
        private int f24065i;

        /* renamed from: j */
        private Socket f24066j;

        /* renamed from: k */
        private volatile boolean f24067k;

        /* renamed from: l */
        private Queue f24068l;

        /* renamed from: m */
        private int f24069m;

        public a(InetSocketAddress inetSocketAddress, long j10, int i10, SocketFactory socketFactory, Proxy proxy, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au, Queue queue) {
            this.f24067k = false;
            this.f24058b = Thread.currentThread().getName();
            this.f24059c = inetSocketAddress;
            this.f24060d = proxy;
            this.f24061e = socketFactory;
            this.f24062f = interfaceC5177aj;
            this.f24063g = abstractC5188au;
            this.f24065i = (int) j10;
            this.f24068l = queue;
            this.f24069m = i10;
            this.f24064h = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) + j10;
        }

        /* renamed from: c */
        public void m31260c() throws IOException {
            this.f24067k = true;
            Socket socket = this.f24066j;
            if (socket == null || socket.isClosed()) {
                return;
            }
            C5210bo.m31193a(this.f24066j);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a call() throws Exception {
            Thread.currentThread().setName(this.f24058b + Thread.currentThread().getName());
            this.f24063g.m30900a(this.f24062f, this.f24059c, this.f24060d);
            Socket socketCreateSocket = (this.f24060d.type() == Proxy.Type.DIRECT || this.f24060d.type() == Proxy.Type.HTTP) ? this.f24061e.createSocket() : new Socket(this.f24060d);
            this.f24066j = socketCreateSocket;
            socketCreateSocket.setTrafficClass(this.f24069m);
            try {
                this.f24066j.connect(this.f24059c, this.f24065i);
                if (this.f24067k) {
                    C5210bo.m31193a(this.f24066j);
                    return null;
                }
                if (this.f24066j.isClosed()) {
                    return null;
                }
                this.f24068l.add(this);
                return this;
            } catch (IOException | RuntimeException e10) {
                C5210bo.m31193a(this.f24066j);
                m31255a(e10);
                throw new IOException("ConnectTask call error ", e10);
            }
        }

        /* renamed from: a */
        public boolean m31258a() {
            return TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) >= this.f24064h;
        }

        /* renamed from: b */
        public long m31259b() {
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            long j10 = this.f24064h;
            if (millis >= j10) {
                return 0L;
            }
            return j10 - millis;
        }

        /* renamed from: a */
        private void m31255a(Exception exc) {
            C5217bv.m31245b("address " + this.f24059c + " connect failed", exc);
        }

        public a() {
            this.f24067k = false;
        }
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.huawei.hms.drive.bv.1

            /* renamed from: a */
            private final AtomicInteger f24056a = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, " OkHttp_" + this.f24056a.getAndIncrement() + " concurrentConnect");
            }
        };
        f24046f = threadFactory;
        f24047g = Executors.newCachedThreadPool(threadFactory);
    }

    public C5217bv(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        super(copyOnWriteArrayList, i10, i11);
        this.f24049i = new CopyOnWriteArrayList<>();
        this.f24050j = new CopyOnWriteArrayList<>();
        this.f24052l = new LinkedBlockingQueue();
        this.f24048h = copyOnWriteArrayList;
        this.f24070a = i10;
        this.f24071b = i10 / 2;
    }

    /* renamed from: c */
    private int m31246c() {
        int size;
        synchronized (this.f24049i) {
            size = this.f24049i.size();
        }
        return size;
    }

    /* renamed from: d */
    private synchronized boolean m31247d() {
        return this.f24053m != null;
    }

    /* renamed from: e */
    private Socket m31248e() {
        a aVar = this.f24053m;
        if (aVar != null) {
            return aVar.f24066j;
        }
        return null;
    }

    /* renamed from: f */
    private void m31249f() throws IOException {
        a aVar;
        if (!this.f24054n && (aVar = this.f24053m) != null) {
            this.f24050j.remove(aVar);
        }
        Iterator<a> it = this.f24050j.iterator();
        while (it.hasNext()) {
            a next = it.next();
            try {
                if (next != this.f24053m && next.m31258a()) {
                    m31244a(next.f24059c);
                }
                next.m31260c();
            } catch (ConcurrentModificationException e10) {
                m31245b(e10.getMessage(), e10);
            }
        }
        this.f24050j.clear();
    }

    @Override // com.huawei.hms.drive.C5219bx
    /* renamed from: b */
    public void mo31253b() {
        this.f24054n = true;
        this.f24052l.add(a.f24057a);
    }

    @Override // com.huawei.hms.drive.C5219bx
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo31252a(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        super.mo31252a(inetSocketAddress, inetSocketAddress2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m31245b(String str, Throwable th2) {
        C5269dr.m31692e().mo31656a(4, str, th2);
    }

    @Override // com.huawei.hms.drive.C5219bx
    /* renamed from: a */
    public Socket mo31250a(long j10, SocketFactory socketFactory, Proxy proxy, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au) throws InterruptedException, IOException {
        a aVar;
        int size = this.f24048h.isEmpty() ? 0 : this.f24048h.size();
        while (!this.f24048h.isEmpty() && !m31247d()) {
            if (this.f24054n) {
                m31249f();
                return null;
            }
            this.f24055o = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            a aVarM31241a = m31241a(interfaceC5177aj, j10, socketFactory, proxy, abstractC5188au, this.f24052l);
            if (aVarM31241a != null) {
                try {
                    f24047g.submit(aVarM31241a);
                    this.f24050j.add(aVarM31241a);
                } catch (RejectedExecutionException e10) {
                    m31245b(e10.getMessage(), e10);
                }
                try {
                    if (this.f24054n) {
                        m31249f();
                        return null;
                    }
                    if (m31247d()) {
                        m31249f();
                        return m31248e();
                    }
                    if (this.f24072c) {
                        this.f24051k = this.f24070a;
                    } else {
                        this.f24051k = this.f24071b;
                    }
                    a aVarPoll = this.f24052l.poll(this.f24051k - (TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) - this.f24055o), TimeUnit.MILLISECONDS);
                    if (this.f24054n) {
                        m31249f();
                        return null;
                    }
                    if (aVarPoll != null) {
                        m31242a(aVarPoll);
                    }
                } catch (InterruptedException e11) {
                    m31245b(e11.getMessage(), e11);
                }
            }
        }
        ArrayList arrayList = new ArrayList(this.f24050j);
        if (!this.f24054n && !m31247d() && m31246c() != size && !arrayList.isEmpty()) {
            try {
                aVar = (a) arrayList.get(arrayList.size() - 1);
            } catch (IndexOutOfBoundsException e12) {
                m31245b(e12.getMessage(), e12);
                aVar = null;
            }
            if (aVar != null) {
                try {
                    a aVarPoll2 = this.f24052l.poll(aVar.m31259b(), TimeUnit.MILLISECONDS);
                    if (!this.f24054n) {
                        if (aVarPoll2 == null) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                m31244a(((a) it.next()).f24059c);
                            }
                        } else {
                            m31242a(aVarPoll2);
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                a aVar2 = (a) it2.next();
                                if (aVar2 != this.f24053m && aVar2.m31258a()) {
                                    m31244a(aVar2.f24059c);
                                }
                            }
                        }
                    }
                } catch (InterruptedException e13) {
                    m31245b(e13.getMessage(), e13);
                }
            }
        }
        a aVar3 = this.f24053m;
        if (aVar3 != null) {
            this.f24073d = aVar3.f24059c;
        }
        try {
            m31249f();
        } catch (RuntimeException unused) {
            m31245b("ClearResource with RuntimeException error", null);
        }
        return m31248e();
    }

    @Override // com.huawei.hms.drive.C5219bx
    /* renamed from: a */
    public List<InetSocketAddress> mo31251a() {
        return this.f24049i;
    }

    /* renamed from: a */
    private void m31244a(InetSocketAddress inetSocketAddress) {
        synchronized (this.f24049i) {
            try {
                if (!this.f24049i.contains(inetSocketAddress)) {
                    this.f24049i.add(inetSocketAddress);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private a m31241a(InterfaceC5177aj interfaceC5177aj, long j10, SocketFactory socketFactory, Proxy proxy, AbstractC5188au abstractC5188au, Queue queue) {
        if (this.f24048h.isEmpty()) {
            return null;
        }
        InetSocketAddress inetSocketAddressRemove = this.f24048h.remove(0);
        if (!this.f24048h.isEmpty()) {
            mo31252a(inetSocketAddressRemove, this.f24048h.get(0));
        } else {
            mo31252a(inetSocketAddressRemove, (InetSocketAddress) null);
        }
        return new a(inetSocketAddressRemove, j10, this.f24074e, socketFactory, proxy, interfaceC5177aj, abstractC5188au, queue);
    }

    /* renamed from: a */
    private synchronized void m31242a(a aVar) {
        if (this.f24053m != null) {
            return;
        }
        this.f24053m = aVar;
    }
}
