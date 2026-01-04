package com.huawei.hms.drive;

import com.huawei.hms.drive.C5254dc;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p022ay.C1054d;
import p022ay.C1057g;
import p022ay.InterfaceC1055e;
import p022ay.InterfaceC1056f;

/* renamed from: com.huawei.hms.drive.da */
/* loaded from: classes8.dex */
public final class C5252da implements Closeable {

    /* renamed from: p */
    static final /* synthetic */ boolean f24314p = true;

    /* renamed from: q */
    private static final ExecutorService f24315q = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C5210bo.m31188a("OkHttp Http2Connection", true));

    /* renamed from: a */
    final boolean f24317a;

    /* renamed from: b */
    final c f24318b;

    /* renamed from: d */
    final String f24320d;

    /* renamed from: e */
    int f24321e;

    /* renamed from: f */
    int f24322f;

    /* renamed from: g */
    final InterfaceC5258dg f24323g;

    /* renamed from: i */
    long f24325i;

    /* renamed from: k */
    final C5259dh f24327k;

    /* renamed from: l */
    final Socket f24328l;

    /* renamed from: m */
    final C5256de f24329m;

    /* renamed from: n */
    final e f24330n;

    /* renamed from: o */
    final Set<Integer> f24331o;

    /* renamed from: r */
    private boolean f24332r;

    /* renamed from: s */
    private final ScheduledExecutorService f24333s;

    /* renamed from: t */
    private final ExecutorService f24334t;

    /* renamed from: c */
    final Map<Integer, C5255dd> f24319c = new LinkedHashMap();

    /* renamed from: u */
    private long f24335u = 0;

    /* renamed from: v */
    private long f24336v = 0;

    /* renamed from: w */
    private long f24337w = 0;

    /* renamed from: x */
    private long f24338x = 0;

    /* renamed from: y */
    private long f24339y = 0;

    /* renamed from: z */
    private long f24340z = 0;

    /* renamed from: A */
    private long f24316A = 0;

    /* renamed from: h */
    long f24324h = 0;

    /* renamed from: j */
    C5259dh f24326j = new C5259dh();

    /* renamed from: com.huawei.hms.drive.da$b */
    public final class b extends AbstractRunnableC5208bm {
        public b() {
            super("OkHttp %s ping", C5252da.this.f24320d);
        }

        @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
        /* renamed from: f */
        public void mo31106f() throws IOException {
            boolean z10;
            synchronized (C5252da.this) {
                if (C5252da.this.f24336v < C5252da.this.f24335u) {
                    z10 = true;
                } else {
                    C5252da.m31518c(C5252da.this);
                    z10 = false;
                }
            }
            if (z10) {
                C5252da.this.m31514a((IOException) null);
            } else {
                C5252da.this.m31539a(false, 1, 0);
            }
        }
    }

    /* renamed from: com.huawei.hms.drive.da$c */
    public static abstract class c {

        /* renamed from: m */
        public static final c f24372m = new c() { // from class: com.huawei.hms.drive.da.c.1
            @Override // com.huawei.hms.drive.C5252da.c
            /* renamed from: a */
            public void mo31320a(C5255dd c5255dd) throws IOException {
                c5255dd.m31587a(EnumC5246cw.REFUSED_STREAM, (IOException) null);
            }
        };

        /* renamed from: a */
        public void mo31319a(C5252da c5252da) {
        }

        /* renamed from: a */
        public abstract void mo31320a(C5255dd c5255dd) throws IOException;
    }

    /* renamed from: com.huawei.hms.drive.da$d */
    public final class d extends AbstractRunnableC5208bm {

        /* renamed from: a */
        final boolean f24373a;

        /* renamed from: b */
        final int f24374b;

        /* renamed from: d */
        final int f24375d;

        public d(boolean z10, int i10, int i11) {
            super("OkHttp %s ping %08x%08x", C5252da.this.f24320d, Integer.valueOf(i10), Integer.valueOf(i11));
            this.f24373a = z10;
            this.f24374b = i10;
            this.f24375d = i11;
        }

        @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
        /* renamed from: f */
        public void mo31106f() throws IOException {
            C5252da.this.m31539a(this.f24373a, this.f24374b, this.f24375d);
        }
    }

    /* renamed from: com.huawei.hms.drive.da$e */
    public class e extends AbstractRunnableC5208bm implements C5254dc.b {

        /* renamed from: a */
        final C5254dc f24377a;

        public e(C5254dc c5254dc) {
            super("OkHttp %s", C5252da.this.f24320d);
            this.f24377a = c5254dc;
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31552a() {
        }

        /* renamed from: b */
        public void m31562b(boolean z10, C5259dh c5259dh) {
            C5255dd[] c5255ddArr;
            long j10;
            synchronized (C5252da.this.f24329m) {
                synchronized (C5252da.this) {
                    try {
                        int iM31638d = C5252da.this.f24327k.m31638d();
                        if (z10) {
                            C5252da.this.f24327k.m31631a();
                        }
                        C5252da.this.f24327k.m31632a(c5259dh);
                        int iM31638d2 = C5252da.this.f24327k.m31638d();
                        c5255ddArr = null;
                        if (iM31638d2 == -1 || iM31638d2 == iM31638d) {
                            j10 = 0;
                        } else {
                            j10 = iM31638d2 - iM31638d;
                            if (!C5252da.this.f24319c.isEmpty()) {
                                c5255ddArr = (C5255dd[]) C5252da.this.f24319c.values().toArray(new C5255dd[C5252da.this.f24319c.size()]);
                            }
                        }
                    } finally {
                    }
                }
                try {
                    C5252da c5252da = C5252da.this;
                    c5252da.f24329m.m31613a(c5252da.f24327k);
                } catch (IOException e10) {
                    C5252da.this.m31514a(e10);
                }
            }
            if (c5255ddArr != null) {
                for (C5255dd c5255dd : c5255ddArr) {
                    synchronized (c5255dd) {
                        c5255dd.m31583a(j10);
                    }
                }
            }
            C5252da.f24315q.execute(new AbstractRunnableC5208bm("OkHttp %s settings", C5252da.this.f24320d) { // from class: com.huawei.hms.drive.da.e.3
                @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
                /* renamed from: f */
                public void mo31106f() {
                    C5252da c5252da2 = C5252da.this;
                    c5252da2.f24318b.mo31319a(c5252da2);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4, types: [com.huawei.hms.drive.dc, java.io.Closeable] */
        @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
        /* renamed from: f */
        public void mo31106f() throws Throwable {
            EnumC5246cw enumC5246cw;
            EnumC5246cw enumC5246cw2;
            EnumC5246cw enumC5246cw3 = EnumC5246cw.INTERNAL_ERROR;
            IOException iOException = null;
            iOException = null;
            iOException = null;
            try {
                try {
                    this.f24377a.m31578a(this);
                    while (this.f24377a.m31579a(false, (C5254dc.b) this)) {
                    }
                    enumC5246cw2 = EnumC5246cw.NO_ERROR;
                } catch (IOException e10) {
                    e = e10;
                } catch (NullPointerException e11) {
                    e = e11;
                    enumC5246cw2 = enumC5246cw3;
                } catch (Throwable th2) {
                    th = th2;
                    enumC5246cw = enumC5246cw3;
                    C5252da.this.m31537a(enumC5246cw, enumC5246cw3, iOException);
                    C5210bo.m31191a(this.f24377a);
                    throw th;
                }
                try {
                    enumC5246cw3 = EnumC5246cw.CANCEL;
                    C5252da.this.m31537a(enumC5246cw2, enumC5246cw3, (IOException) null);
                    enumC5246cw = enumC5246cw2;
                } catch (IOException e12) {
                    e = e12;
                    enumC5246cw3 = EnumC5246cw.PROTOCOL_ERROR;
                    C5252da c5252da = C5252da.this;
                    c5252da.m31537a(enumC5246cw3, enumC5246cw3, e);
                    iOException = e;
                    enumC5246cw = c5252da;
                    this = this.f24377a;
                    C5210bo.m31191a((Closeable) this);
                } catch (NullPointerException e13) {
                    e = e13;
                    C5269dr.m31692e().mo31656a(5, e.getMessage(), e);
                    IOException iOException2 = new IOException(e);
                    C5252da c5252da2 = C5252da.this;
                    c5252da2.m31537a(enumC5246cw2, enumC5246cw3, iOException2);
                    iOException = c5252da2;
                    enumC5246cw = enumC5246cw2;
                    this = this.f24377a;
                    C5210bo.m31191a((Closeable) this);
                }
                this = this.f24377a;
                C5210bo.m31191a((Closeable) this);
            } catch (Throwable th3) {
                th = th3;
                C5252da.this.m31537a(enumC5246cw, enumC5246cw3, iOException);
                C5210bo.m31191a(this.f24377a);
                throw th;
            }
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31553a(int i10, int i11, int i12, boolean z10) {
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31560a(boolean z10, int i10, InterfaceC1056f interfaceC1056f, int i11) throws IOException {
            if (C5252da.this.m31546c(i10)) {
                C5252da.this.m31529a(i10, interfaceC1056f, i11, z10);
                return;
            }
            C5255dd c5255ddM31526a = C5252da.this.m31526a(i10);
            if (c5255ddM31526a == null) {
                C5252da.this.m31530a(i10, EnumC5246cw.PROTOCOL_ERROR);
                long j10 = i11;
                C5252da.this.m31535a(j10);
                interfaceC1056f.skip(j10);
                return;
            }
            c5255ddM31526a.m31584a(interfaceC1056f, i11);
            if (z10) {
                c5255ddM31526a.m31585a(C5210bo.f23990c, true);
            }
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31559a(boolean z10, int i10, int i11, List<C5247cx> list) {
            if (C5252da.this.m31546c(i10)) {
                C5252da.this.m31532a(i10, list, z10);
                return;
            }
            synchronized (C5252da.this) {
                try {
                    C5255dd c5255ddM31526a = C5252da.this.m31526a(i10);
                    if (c5255ddM31526a == null) {
                        if (C5252da.this.f24332r) {
                            return;
                        }
                        C5252da c5252da = C5252da.this;
                        if (i10 <= c5252da.f24321e) {
                            return;
                        }
                        if (i10 % 2 == c5252da.f24322f % 2) {
                            return;
                        }
                        final C5255dd c5255dd = new C5255dd(i10, C5252da.this, false, z10, C5210bo.m31202b(list));
                        C5252da c5252da2 = C5252da.this;
                        c5252da2.f24321e = i10;
                        c5252da2.f24319c.put(Integer.valueOf(i10), c5255dd);
                        C5252da.f24315q.execute(new AbstractRunnableC5208bm("OkHttp %s stream %d", new Object[]{C5252da.this.f24320d, Integer.valueOf(i10)}) { // from class: com.huawei.hms.drive.da.e.1
                            @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
                            /* renamed from: f */
                            public void mo31106f() {
                                try {
                                    C5252da.this.f24318b.mo31320a(c5255dd);
                                } catch (IOException e10) {
                                    C5269dr.m31692e().mo31656a(4, "Http2Connection.Listener failure for " + C5252da.this.f24320d, e10);
                                    try {
                                        c5255dd.m31587a(EnumC5246cw.PROTOCOL_ERROR, e10);
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                        });
                        return;
                    }
                    c5255ddM31526a.m31585a(C5210bo.m31202b(list), z10);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31556a(int i10, EnumC5246cw enumC5246cw) {
            if (C5252da.this.m31546c(i10)) {
                C5252da.this.m31545c(i10, enumC5246cw);
                return;
            }
            C5255dd c5255ddM31540b = C5252da.this.m31540b(i10);
            if (c5255ddM31540b != null) {
                c5255ddM31540b.m31588b(enumC5246cw);
            }
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31561a(final boolean z10, final C5259dh c5259dh) {
            try {
                C5252da.this.f24333s.execute(new AbstractRunnableC5208bm("OkHttp %s ACK Settings", new Object[]{C5252da.this.f24320d}) { // from class: com.huawei.hms.drive.da.e.2
                    @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
                    /* renamed from: f */
                    public void mo31106f() {
                        e.this.m31562b(z10, c5259dh);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31558a(boolean z10, int i10, int i11) {
            if (!z10) {
                try {
                    C5252da.this.f24333s.execute(C5252da.this.new d(true, i10, i11));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (C5252da.this) {
                try {
                    if (i10 == 1) {
                        C5252da.m31522f(C5252da.this);
                    } else if (i10 == 2) {
                        C5252da.m31523g(C5252da.this);
                    } else if (i10 == 3) {
                        C5252da.m31524h(C5252da.this);
                        C5252da.this.notifyAll();
                    }
                } finally {
                }
            }
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31557a(int i10, EnumC5246cw enumC5246cw, C1057g c1057g) {
            C5255dd[] c5255ddArr;
            c1057g.m6370E();
            synchronized (C5252da.this) {
                c5255ddArr = (C5255dd[]) C5252da.this.f24319c.values().toArray(new C5255dd[C5252da.this.f24319c.size()]);
                C5252da.this.f24332r = true;
            }
            for (C5255dd c5255dd : c5255ddArr) {
                if (c5255dd.m31582a() > i10 && c5255dd.m31590c()) {
                    c5255dd.m31588b(EnumC5246cw.REFUSED_STREAM);
                    C5252da.this.m31540b(c5255dd.m31582a());
                }
            }
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31555a(int i10, long j10) {
            if (i10 == 0) {
                synchronized (C5252da.this) {
                    C5252da c5252da = C5252da.this;
                    c5252da.f24325i += j10;
                    c5252da.notifyAll();
                }
                return;
            }
            C5255dd c5255ddM31526a = C5252da.this.m31526a(i10);
            if (c5255ddM31526a != null) {
                synchronized (c5255ddM31526a) {
                    c5255ddM31526a.m31583a(j10);
                }
            }
        }

        @Override // com.huawei.hms.drive.C5254dc.b
        /* renamed from: a */
        public void mo31554a(int i10, int i11, List<C5247cx> list) {
            C5252da.this.m31531a(i11, list);
        }
    }

    public C5252da(a aVar) {
        C5259dh c5259dh = new C5259dh();
        this.f24327k = c5259dh;
        this.f24331o = new LinkedHashSet();
        this.f24323g = aVar.f24368f;
        boolean z10 = aVar.f24369g;
        this.f24317a = z10;
        this.f24318b = aVar.f24367e;
        int i10 = z10 ? 1 : 2;
        this.f24322f = i10;
        if (z10) {
            this.f24322f = i10 + 2;
        }
        if (z10) {
            this.f24326j.m31630a(7, 16777216);
        }
        String str = aVar.f24364b;
        this.f24320d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C5210bo.m31188a(C5210bo.m31181a("OkHttp %s Writer", str), false));
        this.f24333s = scheduledThreadPoolExecutor;
        if (aVar.f24370h != 0) {
            b bVar = new b();
            int i11 = aVar.f24370h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(bVar, i11, i11, TimeUnit.MILLISECONDS);
        }
        this.f24334t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), C5210bo.m31188a(C5210bo.m31181a("OkHttp %s Push Observer", str), true));
        c5259dh.m31630a(7, 65535);
        c5259dh.m31630a(5, 16384);
        this.f24325i = c5259dh.m31638d();
        this.f24328l = aVar.f24363a;
        this.f24329m = new C5256de(aVar.f24366d, z10);
        this.f24330n = new e(new C5254dc(aVar.f24365c, z10));
    }

    /* renamed from: f */
    public static /* synthetic */ long m31522f(C5252da c5252da) {
        long j10 = c5252da.f24336v;
        c5252da.f24336v = 1 + j10;
        return j10;
    }

    /* renamed from: g */
    public static /* synthetic */ long m31523g(C5252da c5252da) {
        long j10 = c5252da.f24338x;
        c5252da.f24338x = 1 + j10;
        return j10;
    }

    /* renamed from: h */
    public static /* synthetic */ long m31524h(C5252da c5252da) {
        long j10 = c5252da.f24340z;
        c5252da.f24340z = 1 + j10;
        return j10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f24329m.m31619c());
        r6 = r2;
        r8.f24325i -= r6;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m31533a(int r9, boolean r10, p022ay.C1054d r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            com.huawei.hms.drive.de r8 = r8.f24329m
            r8.m31615a(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r4 = r8.f24325i     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.Map<java.lang.Integer, com.huawei.hms.drive.dd> r2 = r8.f24319c     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L65
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            com.huawei.hms.drive.de r4 = r8.f24329m     // Catch: java.lang.Throwable -> L28
            int r4 = r4.m31619c()     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.f24325i     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.f24325i = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            com.huawei.hms.drive.de r4 = r8.f24329m
            if (r10 == 0) goto L53
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = r3
        L54:
            r4.m31615a(r5, r9, r11, r2)
            goto Ld
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5252da.m31533a(int, boolean, ay.d, long):void");
    }

    /* renamed from: c */
    public boolean m31546c(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m31537a(EnumC5246cw.NO_ERROR, EnumC5246cw.CANCEL, (IOException) null);
    }

    /* renamed from: c */
    public static /* synthetic */ long m31518c(C5252da c5252da) {
        long j10 = c5252da.f24335u;
        c5252da.f24335u = 1 + j10;
        return j10;
    }

    /* renamed from: b */
    public synchronized C5255dd m31540b(int i10) {
        C5255dd c5255ddRemove;
        c5255ddRemove = this.f24319c.remove(Integer.valueOf(i10));
        notifyAll();
        return c5255ddRemove;
    }

    /* renamed from: d */
    public void m31547d() {
        synchronized (this) {
            try {
                long j10 = this.f24338x;
                long j11 = this.f24337w;
                if (j10 < j11) {
                    return;
                }
                this.f24337w = j11 + 1;
                this.f24316A = System.nanoTime() + 1000000000;
                try {
                    this.f24333s.execute(new AbstractRunnableC5208bm("OkHttp %s ping", this.f24320d) { // from class: com.huawei.hms.drive.da.3
                        @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
                        /* renamed from: f */
                        public void mo31106f() throws IOException {
                            C5252da.this.m31539a(false, 2, 0);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public void m31544c() throws IOException {
        m31538a(true);
    }

    /* renamed from: com.huawei.hms.drive.da$a */
    public static class a {

        /* renamed from: a */
        Socket f24363a;

        /* renamed from: b */
        String f24364b;

        /* renamed from: c */
        InterfaceC1056f f24365c;

        /* renamed from: d */
        InterfaceC1055e f24366d;

        /* renamed from: e */
        c f24367e = c.f24372m;

        /* renamed from: f */
        InterfaceC5258dg f24368f = InterfaceC5258dg.f24446a;

        /* renamed from: g */
        boolean f24369g;

        /* renamed from: h */
        int f24370h;

        public a(boolean z10) {
            this.f24369g = z10;
        }

        /* renamed from: a */
        public a m31550a(Socket socket, String str, InterfaceC1056f interfaceC1056f, InterfaceC1055e interfaceC1055e) {
            this.f24363a = socket;
            this.f24364b = str;
            this.f24365c = interfaceC1056f;
            this.f24366d = interfaceC1055e;
            return this;
        }

        /* renamed from: a */
        public a m31549a(c cVar) {
            this.f24367e = cVar;
            return this;
        }

        /* renamed from: a */
        public a m31548a(int i10) {
            this.f24370h = i10;
            return this;
        }

        /* renamed from: a */
        public C5252da m31551a() {
            return new C5252da(this);
        }
    }

    /* renamed from: c */
    public void m31545c(final int i10, final EnumC5246cw enumC5246cw) {
        m31512a(new AbstractRunnableC5208bm("OkHttp %s Push Reset[%s]", new Object[]{this.f24320d, Integer.valueOf(i10)}) { // from class: com.huawei.hms.drive.da.7
            @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
            /* renamed from: f */
            public void mo31106f() {
                C5252da.this.f24323g.mo31626a(i10, enumC5246cw);
                synchronized (C5252da.this) {
                    C5252da.this.f24331o.remove(Integer.valueOf(i10));
                }
            }
        });
    }

    /* renamed from: b */
    private C5255dd m31517b(int i10, List<C5247cx> list, boolean z10) throws IOException {
        int i11;
        C5255dd c5255dd;
        boolean z11;
        boolean z12 = !z10;
        synchronized (this.f24329m) {
            try {
                synchronized (this) {
                    try {
                        if (this.f24322f > 1073741823) {
                            m31536a(EnumC5246cw.REFUSED_STREAM);
                        }
                        if (!this.f24332r) {
                            i11 = this.f24322f;
                            this.f24322f = i11 + 2;
                            c5255dd = new C5255dd(i11, this, z12, false, null);
                            z11 = !z10 || this.f24325i == 0 || c5255dd.f24406b == 0;
                            if (c5255dd.m31589b()) {
                                this.f24319c.put(Integer.valueOf(i11), c5255dd);
                            }
                        } else {
                            throw new C5245cv();
                        }
                    } finally {
                    }
                }
                if (i10 == 0) {
                    this.f24329m.m31616a(z12, i11, list);
                } else if (!this.f24317a) {
                    this.f24329m.m31609a(i10, i11, list);
                } else {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            this.f24329m.m31617b();
        }
        return c5255dd;
    }

    /* renamed from: a */
    public synchronized C5255dd m31526a(int i10) {
        return this.f24319c.get(Integer.valueOf(i10));
    }

    /* renamed from: a */
    public synchronized int m31525a() {
        return this.f24327k.m31637c(Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public synchronized void m31535a(long j10) {
        long j11 = this.f24324h + j10;
        this.f24324h = j11;
        if (j11 >= this.f24326j.m31638d() / 2) {
            m31528a(0, this.f24324h);
            this.f24324h = 0L;
        }
    }

    /* renamed from: a */
    public C5255dd m31527a(List<C5247cx> list, boolean z10) throws IOException {
        return m31517b(0, list, z10);
    }

    /* renamed from: b */
    public void m31542b(int i10, EnumC5246cw enumC5246cw) throws IOException {
        this.f24329m.m31611a(i10, enumC5246cw);
    }

    /* renamed from: a */
    public void m31534a(int i10, boolean z10, List<C5247cx> list) throws IOException {
        this.f24329m.m31616a(z10, i10, list);
    }

    /* renamed from: b */
    public void m31541b() throws IOException {
        this.f24329m.m31617b();
    }

    /* renamed from: a */
    public void m31530a(final int i10, final EnumC5246cw enumC5246cw) {
        try {
            this.f24333s.execute(new AbstractRunnableC5208bm("OkHttp %s stream %d", new Object[]{this.f24320d, Integer.valueOf(i10)}) { // from class: com.huawei.hms.drive.da.1
                @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
                /* renamed from: f */
                public void mo31106f() throws IOException {
                    try {
                        C5252da.this.m31542b(i10, enumC5246cw);
                    } catch (IOException e10) {
                        C5252da.this.m31514a(e10);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: b */
    public synchronized boolean m31543b(long j10) {
        if (this.f24332r) {
            return false;
        }
        if (this.f24338x < this.f24337w) {
            if (j10 >= this.f24316A) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m31528a(final int i10, final long j10) {
        try {
            this.f24333s.execute(new AbstractRunnableC5208bm("OkHttp Window Update %s stream %d", new Object[]{this.f24320d, Integer.valueOf(i10)}) { // from class: com.huawei.hms.drive.da.2
                @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
                /* renamed from: f */
                public void mo31106f() throws IOException {
                    try {
                        C5252da.this.f24329m.m31610a(i10, j10);
                    } catch (IOException e10) {
                        C5252da.this.m31514a(e10);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: a */
    public void m31539a(boolean z10, int i10, int i11) throws IOException {
        try {
            this.f24329m.m31614a(z10, i10, i11);
        } catch (IOException e10) {
            m31514a(e10);
        }
    }

    /* renamed from: a */
    public void m31536a(EnumC5246cw enumC5246cw) throws IOException {
        synchronized (this.f24329m) {
            synchronized (this) {
                if (this.f24332r) {
                    return;
                }
                this.f24332r = true;
                this.f24329m.m31612a(this.f24321e, enumC5246cw, C5210bo.f23988a);
            }
        }
    }

    /* renamed from: a */
    public void m31537a(EnumC5246cw enumC5246cw, EnumC5246cw enumC5246cw2, IOException iOException) throws IOException {
        C5255dd[] c5255ddArr;
        if (!f24314p && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        try {
            m31536a(enumC5246cw);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.f24319c.isEmpty()) {
                    c5255ddArr = null;
                } else {
                    c5255ddArr = (C5255dd[]) this.f24319c.values().toArray(new C5255dd[this.f24319c.size()]);
                    this.f24319c.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (c5255ddArr != null) {
            for (C5255dd c5255dd : c5255ddArr) {
                try {
                    c5255dd.m31587a(enumC5246cw2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f24329m.close();
        } catch (IOException unused3) {
        }
        try {
            this.f24328l.close();
        } catch (IOException unused4) {
        }
        this.f24333s.shutdown();
        this.f24334t.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m31514a(IOException iOException) throws IOException {
        EnumC5246cw enumC5246cw = EnumC5246cw.PROTOCOL_ERROR;
        m31537a(enumC5246cw, enumC5246cw, iOException);
    }

    /* renamed from: a */
    public void m31538a(boolean z10) throws IOException {
        if (z10) {
            this.f24329m.m31606a();
            this.f24329m.m31618b(this.f24326j);
            if (this.f24326j.m31638d() != 65535) {
                this.f24329m.m31610a(0, r5 - 65535);
            }
        }
        new Thread(this.f24330n).start();
    }

    /* renamed from: a */
    public void m31531a(final int i10, final List<C5247cx> list) {
        synchronized (this) {
            try {
                if (this.f24331o.contains(Integer.valueOf(i10))) {
                    m31530a(i10, EnumC5246cw.PROTOCOL_ERROR);
                    return;
                }
                this.f24331o.add(Integer.valueOf(i10));
                try {
                    m31512a(new AbstractRunnableC5208bm("OkHttp %s Push Request[%s]", new Object[]{this.f24320d, Integer.valueOf(i10)}) { // from class: com.huawei.hms.drive.da.4
                        @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
                        /* renamed from: f */
                        public void mo31106f() {
                            if (C5252da.this.f24323g.mo31628a(i10, list)) {
                                try {
                                    C5252da.this.f24329m.m31611a(i10, EnumC5246cw.CANCEL);
                                    synchronized (C5252da.this) {
                                        C5252da.this.f24331o.remove(Integer.valueOf(i10));
                                    }
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m31532a(final int i10, final List<C5247cx> list, final boolean z10) {
        try {
            m31512a(new AbstractRunnableC5208bm("OkHttp %s Push Headers[%s]", new Object[]{this.f24320d, Integer.valueOf(i10)}) { // from class: com.huawei.hms.drive.da.5
                @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
                /* renamed from: f */
                public void mo31106f() {
                    boolean zMo31629a = C5252da.this.f24323g.mo31629a(i10, list, z10);
                    if (zMo31629a) {
                        try {
                            C5252da.this.f24329m.m31611a(i10, EnumC5246cw.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (zMo31629a || z10) {
                        synchronized (C5252da.this) {
                            C5252da.this.f24331o.remove(Integer.valueOf(i10));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: a */
    public void m31529a(final int i10, InterfaceC1056f interfaceC1056f, final int i11, final boolean z10) throws IOException {
        final C1054d c1054d = new C1054d();
        long j10 = i11;
        interfaceC1056f.mo6357w0(j10);
        interfaceC1056f.read(c1054d, j10);
        if (c1054d.m6322J() == j10) {
            m31512a(new AbstractRunnableC5208bm("OkHttp %s Push Data[%s]", new Object[]{this.f24320d, Integer.valueOf(i10)}) { // from class: com.huawei.hms.drive.da.6
                @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
                /* renamed from: f */
                public void mo31106f() {
                    try {
                        boolean zMo31627a = C5252da.this.f24323g.mo31627a(i10, c1054d, i11, z10);
                        if (zMo31627a) {
                            C5252da.this.f24329m.m31611a(i10, EnumC5246cw.CANCEL);
                        }
                        if (zMo31627a || z10) {
                            synchronized (C5252da.this) {
                                C5252da.this.f24331o.remove(Integer.valueOf(i10));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
        } else {
            throw new IOException(c1054d.m6322J() + " != " + i11);
        }
    }

    /* renamed from: a */
    private synchronized void m31512a(AbstractRunnableC5208bm abstractRunnableC5208bm) {
        if (!this.f24332r) {
            this.f24334t.execute(abstractRunnableC5208bm);
        }
    }
}
