package com.huawei.hms.network.embedded;

import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.hms.network.embedded.C6143wa;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;

/* renamed from: com.huawei.hms.network.embedded.ua */
/* loaded from: classes8.dex */
public final class C6117ua implements InterfaceC6179z7, C6143wa.a {

    /* renamed from: G */
    public static final List<EnumC6075r7> f28547G = Collections.singletonList(EnumC6075r7.HTTP_1_1);

    /* renamed from: H */
    public static final long f28548H = 16777216;

    /* renamed from: I */
    public static final long f28549I = 60000;

    /* renamed from: J */
    public static final int f28550J = 1000;

    /* renamed from: K */
    public static final int f28551K = 1200000;

    /* renamed from: L */
    public static final String f28552L = "Sec-WebSocket-Extensions";

    /* renamed from: M */
    public static final String f28553M = "permessage-deflate";

    /* renamed from: N */
    public static final String f28554N = "client_no_context_takeover";

    /* renamed from: O */
    public static final String f28555O = "server_no_context_takeover";

    /* renamed from: P */
    public static final int f28556P = 4;

    /* renamed from: Q */
    public static final /* synthetic */ boolean f28557Q = true;

    /* renamed from: B */
    public boolean f28559B;

    /* renamed from: C */
    public C5868bb f28560C;

    /* renamed from: D */
    public C5868bb f28561D;

    /* renamed from: E */
    public Deflater f28562E;

    /* renamed from: F */
    public C5923fb f28563F;

    /* renamed from: a */
    public final C6101t7 f28564a;

    /* renamed from: b */
    public final AbstractC5851a8 f28565b;

    /* renamed from: c */
    public final Random f28566c;

    /* renamed from: d */
    public long f28567d;

    /* renamed from: e */
    public final String f28568e;

    /* renamed from: f */
    public ScheduledFuture<?> f28569f;

    /* renamed from: g */
    public InterfaceC6100t6 f28570g;

    /* renamed from: h */
    public final Runnable f28571h;

    /* renamed from: i */
    public C6143wa f28572i;

    /* renamed from: j */
    public C6156xa f28573j;

    /* renamed from: k */
    public ScheduledExecutorService f28574k;

    /* renamed from: l */
    public f f28575l;

    /* renamed from: o */
    public long f28578o;

    /* renamed from: p */
    public boolean f28579p;

    /* renamed from: q */
    public ScheduledFuture<?> f28580q;

    /* renamed from: s */
    public String f28582s;

    /* renamed from: t */
    public boolean f28583t;

    /* renamed from: u */
    public int f28584u;

    /* renamed from: v */
    public int f28585v;

    /* renamed from: w */
    public int f28586w;

    /* renamed from: x */
    public boolean f28587x;

    /* renamed from: y */
    public long f28588y;

    /* renamed from: m */
    public final ArrayDeque<C5910eb> f28576m = new ArrayDeque<>();

    /* renamed from: n */
    public final ArrayDeque<Object> f28577n = new ArrayDeque<>();

    /* renamed from: r */
    public int f28581r = -1;

    /* renamed from: z */
    public LinkedList<Long> f28589z = new LinkedList<>();

    /* renamed from: A */
    public boolean f28558A = false;

    /* renamed from: com.huawei.hms.network.embedded.ua$a */
    public class a implements InterfaceC6113u6 {

        /* renamed from: a */
        public final /* synthetic */ C6101t7 f28590a;

        public a(C6101t7 c6101t7) {
            this.f28590a = c6101t7;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6113u6
        public void onFailure(InterfaceC6100t6 interfaceC6100t6, IOException iOException) throws IOException {
            C6117ua.this.m35528a(iOException, (C6127v7) null);
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6113u6
        public void onResponse(InterfaceC6100t6 interfaceC6100t6, C6127v7 c6127v7) throws IOException {
            C6128v8 c6128v8Mo34044a = AbstractC5879c8.f26567a.mo34044a(c6127v7);
            try {
                C6117ua.this.m35527a(c6127v7, c6128v8Mo34044a);
                f fVarM35625g = c6128v8Mo34044a.m35625g();
                C6117ua.this.m35526a(c6127v7);
                try {
                    C6117ua.this.m35530a("OkHttp WebSocket " + this.f28590a.m35423k().m34807r(), fVarM35625g);
                    C6117ua c6117ua = C6117ua.this;
                    c6117ua.f28565b.onOpen(c6117ua, c6127v7);
                    C6117ua.this.m35541e();
                } catch (Exception e10) {
                    C6117ua.this.m35528a(e10, (C6127v7) null);
                }
            } catch (IOException e11) {
                if (c6128v8Mo34044a != null) {
                    c6128v8Mo34044a.m35631m();
                }
                C6117ua.this.m35528a(e11, c6127v7);
                C5920f8.m34248a(c6127v7);
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ua$b */
    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C6117ua.this.cancel();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ua$c */
    public static final class c {

        /* renamed from: a */
        public final int f28593a;

        /* renamed from: b */
        public final C5910eb f28594b;

        /* renamed from: c */
        public final long f28595c;

        public c(int i10, C5910eb c5910eb, long j10) {
            this.f28593a = i10;
            this.f28594b = c5910eb;
            this.f28595c = j10;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ua$d */
    public static final class d {

        /* renamed from: a */
        public final int f28596a;

        /* renamed from: b */
        public final C5910eb f28597b;

        public d(int i10, C5910eb c5910eb) {
            this.f28596a = i10;
            this.f28597b = c5910eb;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ua$e */
    public final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            C6117ua.this.m35549l();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ua$f */
    public static abstract class f implements Closeable {

        /* renamed from: a */
        public final boolean f28599a;

        /* renamed from: b */
        public final InterfaceC5896db f28600b;

        /* renamed from: c */
        public final InterfaceC5882cb f28601c;

        public f(boolean z10, InterfaceC5896db interfaceC5896db, InterfaceC5882cb interfaceC5882cb) {
            this.f28599a = z10;
            this.f28600b = interfaceC5896db;
            this.f28601c = interfaceC5882cb;
        }
    }

    public C6117ua(C6101t7 c6101t7, AbstractC5851a8 abstractC5851a8, Random random, long j10) {
        if (!"GET".equals(c6101t7.m35420h())) {
            throw new IllegalArgumentException("Request must be GET: " + c6101t7.m35420h());
        }
        this.f28564a = c6101t7;
        this.f28565b = abstractC5851a8;
        this.f28566c = random;
        this.f28567d = j10;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f28568e = C5910eb.m34158e(bArr).mo34175b();
        this.f28571h = new Runnable() { // from class: gq.g
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f48999a.m35519n();
            }
        };
    }

    /* renamed from: f */
    private C5910eb m35517f(C5910eb c5910eb) throws IOException {
        if (this.f28559B) {
            this.f28562E.reset();
        }
        this.f28560C.mo33928a(c5910eb);
        C5923fb c5923fb = this.f28563F;
        C5868bb c5868bb = this.f28560C;
        c5923fb.write(c5868bb, c5868bb.m33913B());
        this.f28563F.flush();
        return this.f28561D.mo33982r().mo34163a(0, r3.mo34192j() - 4);
    }

    /* renamed from: m */
    private synchronized void m35518m() {
        if (this.f28558A) {
            C5920f8.m34248a(this.f28560C);
            C5920f8.m34248a(this.f28561D);
            C5920f8.m34248a(this.f28563F);
            this.f28558A = false;
        }
    }

    /* renamed from: n */
    public /* synthetic */ void m35519n() throws IOException {
        do {
            try {
            } catch (IOException e10) {
                m35528a(e10, (C6127v7) null);
                return;
            }
        } while (m35548k());
    }

    /* renamed from: o */
    private void m35520o() {
        if (!f28557Q && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ScheduledExecutorService scheduledExecutorService = this.f28574k;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.f28571h);
        }
    }

    /* renamed from: b */
    public void m35533b() {
        this.f28569f.cancel(true);
        C6013ma.m34863f().mo34331a(4, "After sentPingCount = " + this.f28584u + " receivedPongCount = " + this.f28586w + " reset the ping interver to " + this.f28567d, (Throwable) null);
        this.f28584u = 0;
        this.f28586w = 0;
        this.f28585v = 0;
    }

    /* renamed from: c */
    public InterfaceC6100t6 m35537c() {
        return this.f28570g;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6179z7
    public void cancel() {
        this.f28570g.cancel();
    }

    /* renamed from: d */
    public LinkedList<Long> m35539d() {
        return this.f28589z;
    }

    /* renamed from: e */
    public void m35541e() throws IOException {
        while (this.f28581r == -1) {
            this.f28572i.m35759a();
        }
    }

    /* renamed from: g */
    public synchronized int m35544g() {
        return this.f28585v;
    }

    /* renamed from: h */
    public synchronized int m35545h() {
        return this.f28586w;
    }

    /* renamed from: i */
    public synchronized int m35546i() {
        return this.f28584u;
    }

    /* renamed from: j */
    public void m35547j() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.f28580q;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f28574k.shutdown();
        this.f28574k.awaitTermination(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* renamed from: k */
    public boolean m35548k() throws IOException {
        String str;
        int i10;
        f fVar;
        synchronized (this) {
            try {
                if (this.f28583t) {
                    return false;
                }
                C6156xa c6156xa = this.f28573j;
                C5910eb c5910ebPoll = this.f28576m.poll();
                d dVar = 0;
                if (c5910ebPoll == null) {
                    Object objPoll = this.f28577n.poll();
                    if (objPoll instanceof c) {
                        i10 = this.f28581r;
                        str = this.f28582s;
                        if (i10 != -1) {
                            fVar = this.f28575l;
                            this.f28575l = null;
                            this.f28574k.shutdown();
                        } else {
                            this.f28580q = this.f28574k.schedule(new b(), ((c) objPoll).f28595c, TimeUnit.MILLISECONDS);
                            fVar = null;
                        }
                    } else {
                        if (objPoll == null) {
                            return false;
                        }
                        str = null;
                        i10 = -1;
                        fVar = null;
                    }
                    dVar = objPoll;
                } else {
                    str = null;
                    i10 = -1;
                    fVar = null;
                }
                try {
                    if (c5910ebPoll != null) {
                        c6156xa.m35812b(c5910ebPoll);
                    } else if (dVar instanceof d) {
                        C5910eb c5910eb = dVar.f28597b;
                        InterfaceC5882cb interfaceC5882cbM34933a = C6040ob.m34933a(c6156xa.m35808a(dVar.f28596a, c5910eb.mo34192j()));
                        interfaceC5882cbM34933a.mo33928a(c5910eb);
                        interfaceC5882cbM34933a.close();
                        synchronized (this) {
                            this.f28578o -= c5910eb.mo34192j();
                        }
                    } else {
                        if (!(dVar instanceof c)) {
                            throw new AssertionError();
                        }
                        c cVar = (c) dVar;
                        c6156xa.m35810a(cVar.f28593a, cVar.f28594b);
                        if (fVar != null) {
                            this.f28565b.onClosed(this, i10, str);
                        }
                    }
                    C5920f8.m34248a(fVar);
                    return true;
                } catch (Throwable th2) {
                    C5920f8.m34248a(fVar);
                    throw th2;
                }
            } finally {
            }
        }
    }

    /* renamed from: l */
    public void m35549l() throws IOException {
        synchronized (this) {
            try {
                if (this.f28583t) {
                    return;
                }
                C6156xa c6156xa = this.f28573j;
                int i10 = this.f28587x ? this.f28584u : -1;
                this.f28584u++;
                this.f28587x = true;
                if (i10 == -1) {
                    try {
                        c6156xa.m35811a(C5910eb.f26711f);
                        this.f28588y = System.currentTimeMillis();
                        return;
                    } catch (IOException e10) {
                        m35528a(e10, (C6127v7) null);
                        return;
                    }
                }
                m35528a(new SocketTimeoutException("sent ping but didn't receive pong within " + this.f28567d + "ms (after " + (i10 - 1) + " successful ping/pongs)"), (C6127v7) null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6179z7
    public C6101t7 request() {
        return this.f28564a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6179z7
    /* renamed from: a */
    public synchronized long mo35521a() {
        return this.f28578o;
    }

    @Override // com.huawei.hms.network.embedded.C6143wa.a
    /* renamed from: b */
    public void mo35534b(int i10, String str) throws IOException {
        f fVar;
        if (i10 == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            try {
                if (this.f28581r != -1) {
                    throw new IllegalStateException("already closed");
                }
                this.f28581r = i10;
                this.f28582s = str;
                fVar = null;
                if (this.f28579p && this.f28577n.isEmpty()) {
                    f fVar2 = this.f28575l;
                    this.f28575l = null;
                    ScheduledFuture<?> scheduledFuture = this.f28580q;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f28574k.shutdown();
                    fVar = fVar2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            this.f28565b.onClosing(this, i10, str);
            if (fVar != null) {
                this.f28565b.onClosed(this, i10, str);
            }
        } finally {
            m35518m();
            C5920f8.m34248a(fVar);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6143wa.a
    /* renamed from: c */
    public synchronized void mo35538c(C5910eb c5910eb) {
        try {
            if (!this.f28583t && (!this.f28579p || !this.f28577n.isEmpty())) {
                this.f28576m.add(c5910eb);
                m35520o();
                this.f28585v++;
            }
        } finally {
        }
    }

    @Override // com.huawei.hms.network.embedded.C6143wa.a
    /* renamed from: d */
    public void mo35540d(C5910eb c5910eb) throws IOException {
        this.f28565b.onMessage(this, c5910eb);
    }

    /* renamed from: e */
    public synchronized boolean m35542e(C5910eb c5910eb) {
        try {
            if (!this.f28583t && (!this.f28579p || !this.f28577n.isEmpty())) {
                this.f28576m.add(c5910eb);
                m35520o();
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: f */
    public boolean m35543f() throws IOException {
        try {
            this.f28572i.m35759a();
            return this.f28581r == -1;
        } catch (Exception e10) {
            this.m35528a(e10, (C6127v7) null);
            return false;
        }
    }

    /* renamed from: a */
    public void m35522a(int i10, TimeUnit timeUnit) throws InterruptedException {
        this.f28574k.awaitTermination(i10, timeUnit);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6179z7
    /* renamed from: b */
    public boolean mo35535b(C5910eb c5910eb) {
        if (c5910eb != null) {
            return m35516a(c5910eb, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* renamed from: a */
    public void m35523a(long j10) {
        if (j10 >= 1000 && j10 <= 1200000 && this.f28569f != null) {
            this.f28567d = j10;
            try {
                m35533b();
                ScheduledExecutorService scheduledExecutorService = this.f28574k;
                e eVar = new e();
                long j11 = this.f28567d;
                this.f28569f = scheduledExecutorService.scheduleAtFixedRate(eVar, j11, j11, TimeUnit.MILLISECONDS);
                return;
            } catch (RuntimeException e10) {
                C6013ma.m34863f().mo34331a(4, "Start new websocket interval ping error", e10);
                return;
            }
        }
        C6013ma.m34863f().mo34331a(5, "WebSocket resetPingInterval param " + j10 + " error. The interval ranges are [1000," + f28551K + "]ms", (Throwable) null);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6179z7
    /* renamed from: b */
    public boolean mo35536b(String str) {
        if (str != null) {
            return m35516a(C5910eb.m34157d(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    @Override // com.huawei.hms.network.embedded.C6143wa.a
    /* renamed from: a */
    public synchronized void mo35524a(C5910eb c5910eb) {
        try {
            this.f28586w++;
            this.f28587x = false;
            if (this.f28588y != 0) {
                this.f28589z.add(Long.valueOf(System.currentTimeMillis() - this.f28588y));
                if (this.f28589z.size() > 5) {
                    this.f28589z.remove(0);
                }
            }
            this.f28565b.onReadPong(this.f28567d, this.f28589z);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public void m35525a(C6062q7 c6062q7) {
        C6062q7 c6062q7M35125a = c6062q7.m35096t().m35130b(f28547G).m35125a();
        C6101t7 c6101t7M35436a = this.f28564a.m35421i().m35440b("Upgrade", "websocket").m35440b("Connection", "Upgrade").m35440b("Sec-WebSocket-Key", this.f28568e).m35440b("Sec-WebSocket-Version", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN).m35436a();
        InterfaceC6100t6 interfaceC6100t6Mo34043a = AbstractC5879c8.f26567a.mo34043a(c6062q7M35125a, c6101t7M35436a);
        this.f28570g = interfaceC6100t6Mo34043a;
        interfaceC6100t6Mo34043a.enqueue(new a(c6101t7M35436a));
    }

    /* renamed from: a */
    public void m35526a(C6127v7 c6127v7) {
        if (c6127v7.m35582b(f28552L) != null && c6127v7.m35582b(f28552L).contains(f28553M)) {
            this.f28558A = true;
            if (c6127v7.m35582b(f28552L).contains(f28554N) && c6127v7.m35582b(f28552L).contains(f28555O)) {
                this.f28559B = true;
            }
        }
        if (this.f28558A) {
            this.f28560C = new C5868bb();
            this.f28561D = new C5868bb();
            Deflater deflater = new Deflater(-1, true);
            this.f28562E = deflater;
            this.f28563F = new C5923fb((InterfaceC5882cb) this.f28561D, deflater);
        }
    }

    /* renamed from: a */
    public void m35527a(C6127v7 c6127v7, C6128v8 c6128v8) throws IOException {
        if (c6127v7.m35589w() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + c6127v7.m35589w() + " " + c6127v7.m35572B() + "'");
        }
        String strM35582b = c6127v7.m35582b("Connection");
        if (!"Upgrade".equalsIgnoreCase(strM35582b)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strM35582b + "'");
        }
        String strM35582b2 = c6127v7.m35582b("Upgrade");
        if (!"websocket".equalsIgnoreCase(strM35582b2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strM35582b2 + "'");
        }
        String strM35582b3 = c6127v7.m35582b("Sec-WebSocket-Accept");
        String strMo34175b = C5910eb.m34157d(this.f28568e + C6130va.f28774a).mo34188g().mo34175b();
        if (strMo34175b.equals(strM35582b3)) {
            if (c6128v8 == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strMo34175b + "' but was '" + strM35582b3 + "'");
    }

    /* renamed from: a */
    public void m35528a(Exception exc, C6127v7 c6127v7) throws IOException {
        synchronized (this) {
            try {
                if (this.f28583t) {
                    return;
                }
                this.f28583t = true;
                f fVar = this.f28575l;
                this.f28575l = null;
                ScheduledFuture<?> scheduledFuture = this.f28580q;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledExecutorService scheduledExecutorService = this.f28574k;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                }
                try {
                    C6013ma.m34863f().mo34331a(5, "failWebSocket", exc);
                    this.f28565b.onFailure(this, exc, c6127v7);
                } finally {
                    C5920f8.m34248a(fVar);
                    m35518m();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.network.embedded.C6143wa.a
    /* renamed from: a */
    public void mo35529a(String str) throws IOException {
        this.f28565b.onMessage(this, str);
    }

    /* renamed from: a */
    public void m35530a(String str, f fVar) throws IOException {
        synchronized (this) {
            try {
                this.f28575l = fVar;
                this.f28573j = new C6156xa(fVar.f28599a, fVar.f28601c, this.f28566c, this.f28558A);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C5920f8.m34245a(str, false));
                this.f28574k = scheduledThreadPoolExecutor;
                if (this.f28567d != 0) {
                    e eVar = new e();
                    long j10 = this.f28567d;
                    this.f28569f = scheduledThreadPoolExecutor.scheduleAtFixedRate(eVar, j10, j10, TimeUnit.MILLISECONDS);
                }
                if (!this.f28577n.isEmpty()) {
                    m35520o();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f28572i = new C6143wa(fVar.f28599a, fVar.f28600b, this, this.f28558A, this.f28559B);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6179z7
    /* renamed from: a */
    public boolean mo35531a(int i10, String str) {
        return m35532a(i10, str, 60000L);
    }

    /* renamed from: a */
    public synchronized boolean m35532a(int i10, String str, long j10) {
        C5910eb c5910ebM34157d;
        try {
            C6130va.m35699b(i10);
            if (str != null) {
                c5910ebM34157d = C5910eb.m34157d(str);
                if (c5910ebM34157d.mo34192j() > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: " + str);
                }
            } else {
                c5910ebM34157d = null;
            }
            if (!this.f28583t && !this.f28579p) {
                this.f28579p = true;
                this.f28577n.add(new c(i10, c5910ebM34157d, j10));
                m35520o();
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    private synchronized boolean m35516a(C5910eb c5910eb, int i10) {
        if (!this.f28583t && !this.f28579p) {
            if (this.f28558A) {
                try {
                    c5910eb = m35517f(c5910eb);
                } catch (Exception e10) {
                    C6013ma.m34863f().mo34331a(5, e10.getMessage(), e10);
                    m35528a(e10, (C6127v7) null);
                }
            }
            if (c5910eb == null) {
                return false;
            }
            if (this.f28578o + c5910eb.mo34192j() > f28548H) {
                mo35531a(1001, (String) null);
                return false;
            }
            this.f28578o += c5910eb.mo34192j();
            this.f28577n.add(new d(i10, c5910eb));
            m35520o();
            return true;
        }
        return false;
    }
}
