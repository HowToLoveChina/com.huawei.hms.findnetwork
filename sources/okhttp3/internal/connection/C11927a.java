package okhttp3.internal.connection;

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
import okhttp3.AbstractC11953t;
import okhttp3.InterfaceC11919f;
import p791xx.C13893h;
import sx.C12875e;

/* renamed from: okhttp3.internal.connection.a */
/* loaded from: classes9.dex */
public class C11927a extends C11929c {

    /* renamed from: v */
    public static ThreadFactory f55333v;

    /* renamed from: w */
    public static ExecutorService f55334w;

    /* renamed from: n */
    public final CopyOnWriteArrayList<InetSocketAddress> f55335n;

    /* renamed from: o */
    public final CopyOnWriteArrayList<InetSocketAddress> f55336o;

    /* renamed from: p */
    public final CopyOnWriteArrayList<b> f55337p;

    /* renamed from: q */
    public int f55338q;

    /* renamed from: r */
    public BlockingQueue<b> f55339r;

    /* renamed from: s */
    public b f55340s;

    /* renamed from: t */
    public volatile boolean f55341t;

    /* renamed from: u */
    public long f55342u;

    /* renamed from: okhttp3.internal.connection.a$a */
    public class a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f55343a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, " OkHttp_" + this.f55343a.getAndIncrement() + " concurrentConnect");
        }
    }

    static {
        a aVar = new a();
        f55333v = aVar;
        f55334w = Executors.newCachedThreadPool(aVar);
    }

    public C11927a(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        super(copyOnWriteArrayList, i10, i11);
        this.f55336o = new CopyOnWriteArrayList<>();
        this.f55337p = new CopyOnWriteArrayList<>();
        this.f55339r = new LinkedBlockingQueue();
        this.f55335n = copyOnWriteArrayList;
        this.f55362f = i10;
        this.f55363g = i10 / 2;
    }

    /* renamed from: k */
    public static void m71642k(String str, Throwable th2) {
        C13893h.m83291l().mo83257s(4, str, th2);
    }

    @Override // okhttp3.internal.connection.C11929c
    /* renamed from: b */
    public void mo71644b() {
        this.f55341t = true;
        this.f55339r.add(b.f55344m);
    }

    @Override // okhttp3.internal.connection.C11929c
    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo71645d(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        super.mo71645d(inetSocketAddress, inetSocketAddress2);
    }

    /* renamed from: e */
    public final void m71646e() throws IOException {
        b bVar;
        if (!this.f55341t && (bVar = this.f55340s) != null) {
            this.f55337p.remove(bVar);
        }
        Iterator<b> it = this.f55337p.iterator();
        while (it.hasNext()) {
            b next = it.next();
            try {
                if (next != this.f55340s && next.m71661g()) {
                    m71649n(next.f55346b);
                }
                next.m71659e();
            } catch (ConcurrentModificationException e10) {
                m71642k(e10.getMessage(), e10);
            }
        }
        this.f55337p.clear();
    }

    @Override // okhttp3.internal.connection.C11929c
    /* renamed from: f */
    public List<InetSocketAddress> mo71647f() {
        return this.f55336o;
    }

    @Override // okhttp3.internal.connection.C11929c
    /* renamed from: h */
    public Socket mo71648h(long j10, SocketFactory socketFactory, Proxy proxy, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t) throws InterruptedException, IOException {
        b bVar;
        int size = this.f55335n.isEmpty() ? 0 : this.f55335n.size();
        while (!this.f55335n.isEmpty() && !m71653r()) {
            if (this.f55341t) {
                m71646e();
                return null;
            }
            this.f55342u = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            b bVarM71651p = m71651p(interfaceC11919f, j10, socketFactory, proxy, abstractC11953t, this.f55339r);
            if (bVarM71651p != null) {
                try {
                    f55334w.submit(bVarM71651p);
                    this.f55337p.add(bVarM71651p);
                } catch (RejectedExecutionException e10) {
                    m71642k(e10.getMessage(), e10);
                }
                try {
                    if (this.f55341t) {
                        m71646e();
                        return null;
                    }
                    if (m71653r()) {
                        m71646e();
                        return m71652q();
                    }
                    if (this.f55364h) {
                        this.f55338q = this.f55362f;
                    } else {
                        this.f55338q = this.f55363g;
                    }
                    b bVarPoll = this.f55339r.poll(this.f55338q - (TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) - this.f55342u), TimeUnit.MILLISECONDS);
                    if (this.f55341t) {
                        m71646e();
                        return null;
                    }
                    if (bVarPoll != null) {
                        m71654s(bVarPoll);
                    }
                } catch (InterruptedException e11) {
                    m71642k(e11.getMessage(), e11);
                }
            }
        }
        ArrayList arrayList = new ArrayList(this.f55337p);
        if (!this.f55341t && !m71653r() && m71650o() != size && !arrayList.isEmpty()) {
            try {
                bVar = (b) arrayList.get(arrayList.size() - 1);
            } catch (IndexOutOfBoundsException e12) {
                m71642k(e12.getMessage(), e12);
                bVar = null;
            }
            if (bVar != null) {
                try {
                    b bVarPoll2 = this.f55339r.poll(bVar.m71660f(), TimeUnit.MILLISECONDS);
                    if (!this.f55341t) {
                        if (bVarPoll2 == null) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                m71649n(((b) it.next()).f55346b);
                            }
                        } else {
                            m71654s(bVarPoll2);
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                b bVar2 = (b) it2.next();
                                if (bVar2 != this.f55340s && bVar2.m71661g()) {
                                    m71649n(bVar2.f55346b);
                                }
                            }
                        }
                    }
                } catch (InterruptedException e13) {
                    m71642k(e13.getMessage(), e13);
                }
            }
        }
        b bVar3 = this.f55340s;
        if (bVar3 != null) {
            this.f55368l = bVar3.f55346b;
        }
        try {
            m71646e();
        } catch (RuntimeException unused) {
            m71642k("ClearResource with RuntimeException error", null);
        }
        return m71652q();
    }

    /* renamed from: n */
    public final void m71649n(InetSocketAddress inetSocketAddress) {
        synchronized (this.f55336o) {
            try {
                if (!this.f55336o.contains(inetSocketAddress)) {
                    this.f55336o.add(inetSocketAddress);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: o */
    public final int m71650o() {
        int size;
        synchronized (this.f55336o) {
            size = this.f55336o.size();
        }
        return size;
    }

    /* renamed from: p */
    public final b m71651p(InterfaceC11919f interfaceC11919f, long j10, SocketFactory socketFactory, Proxy proxy, AbstractC11953t abstractC11953t, Queue queue) {
        if (this.f55335n.isEmpty()) {
            return null;
        }
        InetSocketAddress inetSocketAddressRemove = this.f55335n.remove(0);
        if (this.f55335n.isEmpty()) {
            mo71645d(inetSocketAddressRemove, null);
        } else {
            mo71645d(inetSocketAddressRemove, this.f55335n.get(0));
        }
        return new b(inetSocketAddressRemove, j10, this.f55369m, socketFactory, proxy, interfaceC11919f, abstractC11953t, queue);
    }

    /* renamed from: q */
    public final Socket m71652q() {
        b bVar = this.f55340s;
        if (bVar != null) {
            return bVar.f55353i;
        }
        return null;
    }

    /* renamed from: r */
    public final synchronized boolean m71653r() {
        return this.f55340s != null;
    }

    /* renamed from: s */
    public final synchronized void m71654s(b bVar) {
        if (this.f55340s != null) {
            return;
        }
        this.f55340s = bVar;
    }

    /* renamed from: okhttp3.internal.connection.a$b */
    public static final class b implements Callable<b> {

        /* renamed from: m */
        public static b f55344m = new b();

        /* renamed from: a */
        public String f55345a;

        /* renamed from: b */
        public InetSocketAddress f55346b;

        /* renamed from: c */
        public Proxy f55347c;

        /* renamed from: d */
        public SocketFactory f55348d;

        /* renamed from: e */
        public InterfaceC11919f f55349e;

        /* renamed from: f */
        public AbstractC11953t f55350f;

        /* renamed from: g */
        public long f55351g;

        /* renamed from: h */
        public int f55352h;

        /* renamed from: i */
        public Socket f55353i;

        /* renamed from: j */
        public volatile boolean f55354j;

        /* renamed from: k */
        public Queue f55355k;

        /* renamed from: l */
        public int f55356l;

        public b(InetSocketAddress inetSocketAddress, long j10, int i10, SocketFactory socketFactory, Proxy proxy, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t, Queue queue) {
            this.f55354j = false;
            this.f55345a = Thread.currentThread().getName();
            this.f55346b = inetSocketAddress;
            this.f55347c = proxy;
            this.f55348d = socketFactory;
            this.f55349e = interfaceC11919f;
            this.f55350f = abstractC11953t;
            this.f55352h = (int) j10;
            this.f55355k = queue;
            this.f55356l = i10;
            this.f55351g = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) + j10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b call() throws Exception {
            Thread.currentThread().setName(this.f55345a + Thread.currentThread().getName());
            this.f55350f.connectStart(this.f55349e, this.f55346b, this.f55347c);
            Socket socketCreateSocket = (this.f55347c.type() == Proxy.Type.DIRECT || this.f55347c.type() == Proxy.Type.HTTP) ? this.f55348d.createSocket() : new Socket(this.f55347c);
            this.f55353i = socketCreateSocket;
            socketCreateSocket.setTrafficClass(this.f55356l);
            try {
                this.f55353i.connect(this.f55346b, this.f55352h);
                if (this.f55354j) {
                    C12875e.m77251h(this.f55353i);
                    return null;
                }
                if (this.f55353i.isClosed()) {
                    return null;
                }
                this.f55355k.add(this);
                return this;
            } catch (IOException | RuntimeException e10) {
                C12875e.m77251h(this.f55353i);
                m71662h(e10);
                throw new IOException("ConnectTask call error ", e10);
            }
        }

        /* renamed from: e */
        public void m71659e() throws IOException {
            this.f55354j = true;
            Socket socket = this.f55353i;
            if (socket == null || socket.isClosed()) {
                return;
            }
            C12875e.m77251h(this.f55353i);
        }

        /* renamed from: f */
        public long m71660f() {
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            long j10 = this.f55351g;
            if (millis >= j10) {
                return 0L;
            }
            return j10 - millis;
        }

        /* renamed from: g */
        public boolean m71661g() {
            return TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) >= this.f55351g;
        }

        /* renamed from: h */
        public final void m71662h(Exception exc) {
            C11927a.m71642k("address " + this.f55346b + " connect failed", exc);
        }

        public b() {
            this.f55354j = false;
        }
    }
}
