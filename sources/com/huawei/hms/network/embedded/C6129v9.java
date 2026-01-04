package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6155x9;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
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

/* renamed from: com.huawei.hms.network.embedded.v9 */
/* loaded from: classes8.dex */
public final class C6129v9 implements Closeable {

    /* renamed from: A */
    public static final int f28698A = 1;

    /* renamed from: B */
    public static final int f28699B = 2;

    /* renamed from: C */
    public static final int f28700C = 3;

    /* renamed from: D */
    public static final long f28701D = 1000000000;

    /* renamed from: E */
    public static final ExecutorService f28702E = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C5920f8.m34245a("OkHttp Http2Connection", true));

    /* renamed from: F */
    public static final /* synthetic */ boolean f28703F = true;

    /* renamed from: z */
    public static final int f28704z = 16777216;

    /* renamed from: a */
    public final boolean f28705a;

    /* renamed from: b */
    public final j f28706b;

    /* renamed from: d */
    public final String f28708d;

    /* renamed from: e */
    public int f28709e;

    /* renamed from: f */
    public int f28710f;

    /* renamed from: g */
    public boolean f28711g;

    /* renamed from: h */
    public final ScheduledExecutorService f28712h;

    /* renamed from: i */
    public final ExecutorService f28713i;

    /* renamed from: j */
    public final InterfaceC5867ba f28714j;

    /* renamed from: s */
    public long f28723s;

    /* renamed from: u */
    public final C5881ca f28725u;

    /* renamed from: v */
    public final Socket f28726v;

    /* renamed from: w */
    public final C6181z9 f28727w;

    /* renamed from: x */
    public final l f28728x;

    /* renamed from: y */
    public final Set<Integer> f28729y;

    /* renamed from: c */
    public final Map<Integer, C6168y9> f28707c = new LinkedHashMap();

    /* renamed from: k */
    public long f28715k = 0;

    /* renamed from: l */
    public long f28716l = 0;

    /* renamed from: m */
    public long f28717m = 0;

    /* renamed from: n */
    public long f28718n = 0;

    /* renamed from: o */
    public long f28719o = 0;

    /* renamed from: p */
    public long f28720p = 0;

    /* renamed from: q */
    public long f28721q = 0;

    /* renamed from: r */
    public long f28722r = 0;

    /* renamed from: t */
    public C5881ca f28724t = new C5881ca();

    /* renamed from: com.huawei.hms.network.embedded.v9$a */
    public class a extends AbstractRunnableC5893d8 {

        /* renamed from: b */
        public final /* synthetic */ int f28730b;

        /* renamed from: c */
        public final /* synthetic */ EnumC6077r9 f28731c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i10, EnumC6077r9 enumC6077r9) {
            super(str, objArr);
            this.f28730b = i10;
            this.f28731c = enumC6077r9;
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() throws IOException {
            try {
                C6129v9.this.m35662b(this.f28730b, this.f28731c);
            } catch (IOException e10) {
                C6129v9.this.m35637a(e10);
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$b */
    public class b extends AbstractRunnableC5893d8 {

        /* renamed from: b */
        public final /* synthetic */ int f28733b;

        /* renamed from: c */
        public final /* synthetic */ long f28734c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i10, long j10) {
            super(str, objArr);
            this.f28733b = i10;
            this.f28734c = j10;
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() throws IOException {
            try {
                C6129v9.this.f28727w.m35942a(this.f28733b, this.f28734c);
            } catch (IOException e10) {
                C6129v9.this.m35637a(e10);
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$c */
    public class c extends AbstractRunnableC5893d8 {
        public c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() throws IOException {
            C6129v9.this.m35660a(false, 2, 0);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$d */
    public class d extends AbstractRunnableC5893d8 {

        /* renamed from: b */
        public final /* synthetic */ int f28737b;

        /* renamed from: c */
        public final /* synthetic */ List f28738c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i10, List list) {
            super(str, objArr);
            this.f28737b = i10;
            this.f28738c = list;
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() {
            if (C6129v9.this.f28714j.mo33906a(this.f28737b, this.f28738c)) {
                try {
                    C6129v9.this.f28727w.m35943a(this.f28737b, EnumC6077r9.CANCEL);
                    synchronized (C6129v9.this) {
                        C6129v9.this.f28729y.remove(Integer.valueOf(this.f28737b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$e */
    public class e extends AbstractRunnableC5893d8 {

        /* renamed from: b */
        public final /* synthetic */ int f28740b;

        /* renamed from: c */
        public final /* synthetic */ List f28741c;

        /* renamed from: d */
        public final /* synthetic */ boolean f28742d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Object[] objArr, int i10, List list, boolean z10) {
            super(str, objArr);
            this.f28740b = i10;
            this.f28741c = list;
            this.f28742d = z10;
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() {
            boolean zMo33907a = C6129v9.this.f28714j.mo33907a(this.f28740b, this.f28741c, this.f28742d);
            if (zMo33907a) {
                try {
                    C6129v9.this.f28727w.m35943a(this.f28740b, EnumC6077r9.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (zMo33907a || this.f28742d) {
                synchronized (C6129v9.this) {
                    C6129v9.this.f28729y.remove(Integer.valueOf(this.f28740b));
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$f */
    public class f extends AbstractRunnableC5893d8 {

        /* renamed from: b */
        public final /* synthetic */ int f28744b;

        /* renamed from: c */
        public final /* synthetic */ C5868bb f28745c;

        /* renamed from: d */
        public final /* synthetic */ int f28746d;

        /* renamed from: e */
        public final /* synthetic */ boolean f28747e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Object[] objArr, int i10, C5868bb c5868bb, int i11, boolean z10) {
            super(str, objArr);
            this.f28744b = i10;
            this.f28745c = c5868bb;
            this.f28746d = i11;
            this.f28747e = z10;
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() {
            try {
                boolean zMo33905a = C6129v9.this.f28714j.mo33905a(this.f28744b, this.f28745c, this.f28746d, this.f28747e);
                if (zMo33905a) {
                    C6129v9.this.f28727w.m35943a(this.f28744b, EnumC6077r9.CANCEL);
                }
                if (zMo33905a || this.f28747e) {
                    synchronized (C6129v9.this) {
                        C6129v9.this.f28729y.remove(Integer.valueOf(this.f28744b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$g */
    public class g extends AbstractRunnableC5893d8 {

        /* renamed from: b */
        public final /* synthetic */ int f28749b;

        /* renamed from: c */
        public final /* synthetic */ EnumC6077r9 f28750c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Object[] objArr, int i10, EnumC6077r9 enumC6077r9) {
            super(str, objArr);
            this.f28749b = i10;
            this.f28750c = enumC6077r9;
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() {
            C6129v9.this.f28714j.mo33904a(this.f28749b, this.f28750c);
            synchronized (C6129v9.this) {
                C6129v9.this.f28729y.remove(Integer.valueOf(this.f28749b));
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$h */
    public static class h {

        /* renamed from: a */
        public Socket f28752a;

        /* renamed from: b */
        public String f28753b;

        /* renamed from: c */
        public InterfaceC5896db f28754c;

        /* renamed from: d */
        public InterfaceC5882cb f28755d;

        /* renamed from: e */
        public j f28756e = j.f28761a;

        /* renamed from: f */
        public InterfaceC5867ba f28757f = InterfaceC5867ba.f26520a;

        /* renamed from: g */
        public boolean f28758g;

        /* renamed from: h */
        public int f28759h;

        public h(boolean z10) {
            this.f28758g = z10;
        }

        /* renamed from: a */
        public h m35676a(int i10) {
            this.f28759h = i10;
            return this;
        }

        /* renamed from: a */
        public h m35677a(InterfaceC5867ba interfaceC5867ba) {
            this.f28757f = interfaceC5867ba;
            return this;
        }

        /* renamed from: a */
        public h m35678a(j jVar) {
            this.f28756e = jVar;
            return this;
        }

        /* renamed from: a */
        public h m35679a(Socket socket) throws IOException {
            SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            return m35680a(socket, remoteSocketAddress instanceof InetSocketAddress ? ((InetSocketAddress) remoteSocketAddress).getHostName() : remoteSocketAddress.toString(), C6040ob.m34934a(C6040ob.m34945b(socket)), C6040ob.m34933a(C6040ob.m34939a(socket)));
        }

        /* renamed from: a */
        public h m35680a(Socket socket, String str, InterfaceC5896db interfaceC5896db, InterfaceC5882cb interfaceC5882cb) {
            this.f28752a = socket;
            this.f28753b = str;
            this.f28754c = interfaceC5896db;
            this.f28755d = interfaceC5882cb;
            return this;
        }

        /* renamed from: a */
        public C6129v9 m35681a() {
            return new C6129v9(this);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$i */
    public final class i extends AbstractRunnableC5893d8 {
        public i() {
            super("OkHttp %s ping", C6129v9.this.f28708d);
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() throws IOException {
            boolean z10;
            synchronized (C6129v9.this) {
                if (C6129v9.this.f28716l < C6129v9.this.f28715k) {
                    z10 = true;
                } else {
                    C6129v9.m35642d(C6129v9.this);
                    z10 = false;
                }
            }
            C6129v9 c6129v9 = C6129v9.this;
            if (z10) {
                c6129v9.m35637a((IOException) null);
            } else {
                c6129v9.m35660a(false, 1, 0);
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$j */
    public static abstract class j {

        /* renamed from: a */
        public static final j f28761a = new a();

        /* renamed from: com.huawei.hms.network.embedded.v9$j$a */
        public class a extends j {
            @Override // com.huawei.hms.network.embedded.C6129v9.j
            /* renamed from: a */
            public void mo35683a(C6168y9 c6168y9) throws IOException {
                c6168y9.m35872a(EnumC6077r9.REFUSED_STREAM, (IOException) null);
            }
        }

        /* renamed from: a */
        public void mo35682a(C6129v9 c6129v9) {
        }

        /* renamed from: a */
        public abstract void mo35683a(C6168y9 c6168y9) throws IOException;
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$k */
    public final class k extends AbstractRunnableC5893d8 {

        /* renamed from: b */
        public final boolean f28762b;

        /* renamed from: c */
        public final int f28763c;

        /* renamed from: d */
        public final int f28764d;

        public k(boolean z10, int i10, int i11) {
            super("OkHttp %s ping %08x%08x", C6129v9.this.f28708d, Integer.valueOf(i10), Integer.valueOf(i11));
            this.f28762b = z10;
            this.f28763c = i10;
            this.f28764d = i11;
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() throws IOException {
            C6129v9.this.m35660a(this.f28762b, this.f28763c, this.f28764d);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v9$l */
    public class l extends AbstractRunnableC5893d8 implements C6155x9.b {

        /* renamed from: b */
        public final C6155x9 f28766b;

        /* renamed from: com.huawei.hms.network.embedded.v9$l$a */
        public class a extends AbstractRunnableC5893d8 {

            /* renamed from: b */
            public final /* synthetic */ C6168y9 f28768b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, C6168y9 c6168y9) {
                super(str, objArr);
                this.f28768b = c6168y9;
            }

            @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
            /* renamed from: b */
            public void mo34106b() {
                try {
                    C6129v9.this.f28706b.mo35683a(this.f28768b);
                } catch (IOException e10) {
                    C6013ma.m34863f().mo34331a(4, "Http2Connection.Listener failure for " + C6129v9.this.f28708d, e10);
                    try {
                        this.f28768b.m35872a(EnumC6077r9.PROTOCOL_ERROR, e10);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* renamed from: com.huawei.hms.network.embedded.v9$l$b */
        public class b extends AbstractRunnableC5893d8 {

            /* renamed from: b */
            public final /* synthetic */ boolean f28770b;

            /* renamed from: c */
            public final /* synthetic */ C5881ca f28771c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Object[] objArr, boolean z10, C5881ca c5881ca) {
                super(str, objArr);
                this.f28770b = z10;
                this.f28771c = c5881ca;
            }

            @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
            /* renamed from: b */
            public void mo34106b() {
                l.this.m35695b(this.f28770b, this.f28771c);
            }
        }

        /* renamed from: com.huawei.hms.network.embedded.v9$l$c */
        public class c extends AbstractRunnableC5893d8 {
            public c(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
            /* renamed from: b */
            public void mo34106b() {
                C6129v9 c6129v9 = C6129v9.this;
                c6129v9.f28706b.mo35682a(c6129v9);
            }
        }

        public l(C6155x9 c6155x9) {
            super("OkHttp %s", C6129v9.this.f28708d);
            this.f28766b = c6155x9;
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35684a() {
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() throws Throwable {
            Throwable th2;
            NullPointerException e10;
            EnumC6077r9 enumC6077r9;
            EnumC6077r9 enumC6077r92;
            EnumC6077r9 enumC6077r93 = EnumC6077r9.INTERNAL_ERROR;
            IOException e11 = null;
            try {
                try {
                    this.f28766b.m35804a(this);
                    while (this.f28766b.m35805a(false, (C6155x9.b) this)) {
                    }
                    enumC6077r9 = EnumC6077r9.NO_ERROR;
                } catch (IOException e12) {
                    e11 = e12;
                } catch (NullPointerException e13) {
                    e10 = e13;
                    enumC6077r9 = enumC6077r93;
                } catch (Throwable th3) {
                    th2 = th3;
                    C6129v9.this.m35658a(enumC6077r93, enumC6077r93, (IOException) null);
                    C5920f8.m34248a(this.f28766b);
                    throw th2;
                }
                try {
                    enumC6077r92 = EnumC6077r9.CANCEL;
                } catch (IOException e14) {
                    e11 = e14;
                    enumC6077r9 = EnumC6077r9.PROTOCOL_ERROR;
                    enumC6077r92 = enumC6077r9;
                    C6129v9.this.m35658a(enumC6077r9, enumC6077r92, e11);
                    C5920f8.m34248a(this.f28766b);
                } catch (NullPointerException e15) {
                    e10 = e15;
                    C6013ma.m34863f().mo34331a(5, e10.getMessage(), e10);
                    C6129v9.this.m35658a(enumC6077r9, enumC6077r93, new IOException(e10));
                    C5920f8.m34248a(this.f28766b);
                }
                C6129v9.this.m35658a(enumC6077r9, enumC6077r92, e11);
                C5920f8.m34248a(this.f28766b);
            } catch (Throwable th4) {
                th2 = th4;
                C6129v9.this.m35658a(enumC6077r93, enumC6077r93, (IOException) null);
                C5920f8.m34248a(this.f28766b);
                throw th2;
            }
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35685a(int i10, int i11, int i12, boolean z10) {
        }

        /* renamed from: b */
        public void m35695b(boolean z10, C5881ca c5881ca) {
            C6168y9[] c6168y9Arr;
            long j10;
            synchronized (C6129v9.this.f28727w) {
                synchronized (C6129v9.this) {
                    try {
                        int iM34080c = C6129v9.this.f28725u.m34080c();
                        if (z10) {
                            C6129v9.this.f28725u.m34075a();
                        }
                        C6129v9.this.f28725u.m34076a(c5881ca);
                        int iM34080c2 = C6129v9.this.f28725u.m34080c();
                        c6168y9Arr = null;
                        if (iM34080c2 == -1 || iM34080c2 == iM34080c) {
                            j10 = 0;
                        } else {
                            j10 = iM34080c2 - iM34080c;
                            if (!C6129v9.this.f28707c.isEmpty()) {
                                c6168y9Arr = (C6168y9[]) C6129v9.this.f28707c.values().toArray(new C6168y9[C6129v9.this.f28707c.size()]);
                            }
                        }
                    } finally {
                    }
                }
                try {
                    C6129v9 c6129v9 = C6129v9.this;
                    c6129v9.f28727w.m35945a(c6129v9.f28725u);
                } catch (IOException e10) {
                    C6129v9.this.m35637a(e10);
                }
            }
            if (c6168y9Arr != null) {
                for (C6168y9 c6168y9 : c6168y9Arr) {
                    synchronized (c6168y9) {
                        c6168y9.m35867a(j10);
                    }
                }
            }
            C6129v9.f28702E.execute(new c("OkHttp %s settings", C6129v9.this.f28708d));
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35686a(int i10, int i11, List<C6090s9> list) {
            C6129v9.this.m35652a(i11, list);
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35687a(int i10, long j10) {
            if (i10 == 0) {
                synchronized (C6129v9.this) {
                    C6129v9 c6129v9 = C6129v9.this;
                    c6129v9.f28723s += j10;
                    c6129v9.notifyAll();
                }
                return;
            }
            C6168y9 c6168y9M35664d = C6129v9.this.m35664d(i10);
            if (c6168y9M35664d != null) {
                synchronized (c6168y9M35664d) {
                    c6168y9M35664d.m35867a(j10);
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35688a(int i10, EnumC6077r9 enumC6077r9) {
            boolean zM35665e = C6129v9.this.m35665e(i10);
            C6129v9 c6129v9 = C6129v9.this;
            if (zM35665e) {
                c6129v9.m35651a(i10, enumC6077r9);
                return;
            }
            C6168y9 c6168y9M35666f = c6129v9.m35666f(i10);
            if (c6168y9M35666f != null) {
                c6168y9M35666f.m35875b(enumC6077r9);
            }
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35689a(int i10, EnumC6077r9 enumC6077r9, C5910eb c5910eb) {
            C6168y9[] c6168y9Arr;
            c5910eb.mo34192j();
            synchronized (C6129v9.this) {
                c6168y9Arr = (C6168y9[]) C6129v9.this.f28707c.values().toArray(new C6168y9[C6129v9.this.f28707c.size()]);
                C6129v9.this.f28711g = true;
            }
            for (C6168y9 c6168y9 : c6168y9Arr) {
                if (c6168y9.m35878e() > i10 && c6168y9.m35881h()) {
                    c6168y9.m35875b(EnumC6077r9.REFUSED_STREAM);
                    C6129v9.this.m35666f(c6168y9.m35878e());
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35690a(int i10, String str, C5910eb c5910eb, String str2, int i11, long j10) {
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35691a(boolean z10, int i10, int i11) {
            if (z10) {
                synchronized (C6129v9.this) {
                    try {
                        if (i10 == 1) {
                            C6129v9.m35639b(C6129v9.this);
                        } else if (i10 == 2) {
                            C6129v9.m35645g(C6129v9.this);
                        } else if (i10 == 3) {
                            C6129v9.m35646h(C6129v9.this);
                            C6129v9.this.notifyAll();
                        }
                    } finally {
                    }
                }
                return;
            }
            try {
                C6129v9.this.f28712h.execute(C6129v9.this.new k(true, i10, i11));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35692a(boolean z10, int i10, int i11, List<C6090s9> list) {
            if (C6129v9.this.m35665e(i10)) {
                C6129v9.this.m35653a(i10, list, z10);
                return;
            }
            synchronized (C6129v9.this) {
                try {
                    C6168y9 c6168y9M35664d = C6129v9.this.m35664d(i10);
                    if (c6168y9M35664d != null) {
                        c6168y9M35664d.m35870a(C5920f8.m34259b(list), z10);
                        return;
                    }
                    if (C6129v9.this.f28711g) {
                        return;
                    }
                    C6129v9 c6129v9 = C6129v9.this;
                    if (i10 <= c6129v9.f28709e) {
                        return;
                    }
                    if (i10 % 2 == c6129v9.f28710f % 2) {
                        return;
                    }
                    C6168y9 c6168y9 = new C6168y9(i10, C6129v9.this, false, z10, C5920f8.m34259b(list));
                    C6129v9 c6129v92 = C6129v9.this;
                    c6129v92.f28709e = i10;
                    c6129v92.f28707c.put(Integer.valueOf(i10), c6168y9);
                    C6129v9.f28702E.execute(new a("OkHttp %s stream %d", new Object[]{C6129v9.this.f28708d, Integer.valueOf(i10)}, c6168y9));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35693a(boolean z10, int i10, InterfaceC5896db interfaceC5896db, int i11) throws IOException {
            if (C6129v9.this.m35665e(i10)) {
                C6129v9.this.m35650a(i10, interfaceC5896db, i11, z10);
                return;
            }
            C6168y9 c6168y9M35664d = C6129v9.this.m35664d(i10);
            if (c6168y9M35664d == null) {
                C6129v9.this.m35663c(i10, EnumC6077r9.PROTOCOL_ERROR);
                long j10 = i11;
                C6129v9.this.m35668k(j10);
                interfaceC5896db.skip(j10);
                return;
            }
            c6168y9M35664d.m35868a(interfaceC5896db, i11);
            if (z10) {
                c6168y9M35664d.m35870a(C5920f8.f26771c, true);
            }
        }

        @Override // com.huawei.hms.network.embedded.C6155x9.b
        /* renamed from: a */
        public void mo35694a(boolean z10, C5881ca c5881ca) {
            try {
                C6129v9.this.f28712h.execute(new b("OkHttp %s ACK Settings", new Object[]{C6129v9.this.f28708d}, z10, c5881ca));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public C6129v9(h hVar) {
        C5881ca c5881ca = new C5881ca();
        this.f28725u = c5881ca;
        this.f28729y = new LinkedHashSet();
        this.f28714j = hVar.f28757f;
        boolean z10 = hVar.f28758g;
        this.f28705a = z10;
        this.f28706b = hVar.f28756e;
        int i10 = z10 ? 1 : 2;
        this.f28710f = i10;
        if (z10) {
            this.f28710f = i10 + 2;
        }
        if (z10) {
            this.f28724t.m34074a(7, 16777216);
        }
        String str = hVar.f28753b;
        this.f28708d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C5920f8.m34245a(C5920f8.m34236a("OkHttp %s Writer", str), false));
        this.f28712h = scheduledThreadPoolExecutor;
        if (hVar.f28759h != 0) {
            i iVar = new i();
            long j10 = hVar.f28759h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, j10, j10, TimeUnit.MILLISECONDS);
        }
        this.f28713i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), C5920f8.m34245a(C5920f8.m34236a("OkHttp %s Push Observer", str), true));
        c5881ca.m34074a(7, 65535);
        c5881ca.m34074a(5, 16384);
        this.f28723s = c5881ca.m34080c();
        this.f28726v = hVar.f28752a;
        this.f28727w = new C6181z9(hVar.f28755d, z10);
        this.f28728x = new l(new C6155x9(hVar.f28754c, z10));
    }

    /* renamed from: b */
    public static /* synthetic */ long m35639b(C6129v9 c6129v9) {
        long j10 = c6129v9.f28716l;
        c6129v9.f28716l = 1 + j10;
        return j10;
    }

    /* renamed from: d */
    public static /* synthetic */ long m35642d(C6129v9 c6129v9) {
        long j10 = c6129v9.f28715k;
        c6129v9.f28715k = 1 + j10;
        return j10;
    }

    /* renamed from: g */
    public static /* synthetic */ long m35645g(C6129v9 c6129v9) {
        long j10 = c6129v9.f28718n;
        c6129v9.f28718n = 1 + j10;
        return j10;
    }

    /* renamed from: h */
    public static /* synthetic */ long m35646h(C6129v9 c6129v9) {
        long j10 = c6129v9.f28720p;
        c6129v9.f28720p = 1 + j10;
        return j10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m35658a(EnumC6077r9.NO_ERROR, EnumC6077r9.CANCEL, (IOException) null);
    }

    /* renamed from: e */
    public boolean m35665e(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    /* renamed from: f */
    public synchronized C6168y9 m35666f(int i10) {
        C6168y9 c6168y9Remove;
        c6168y9Remove = this.f28707c.remove(Integer.valueOf(i10));
        notifyAll();
        return c6168y9Remove;
    }

    public void flush() throws IOException {
        this.f28727w.flush();
    }

    /* renamed from: j */
    public synchronized boolean m35667j(long j10) {
        if (this.f28711g) {
            return false;
        }
        if (this.f28718n < this.f28717m) {
            if (j10 >= this.f28721q) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public synchronized void m35668k(long j10) {
        long j11 = this.f28722r + j10;
        this.f28722r = j11;
        if (j11 >= this.f28724t.m34080c() / 2) {
            m35649a(0, this.f28722r);
            this.f28722r = 0L;
        }
    }

    /* renamed from: s */
    public synchronized void m35669s() throws InterruptedException {
        while (this.f28720p < this.f28719o) {
            wait();
        }
    }

    /* renamed from: t */
    public synchronized int m35670t() {
        return this.f28725u.m34079b(Integer.MAX_VALUE);
    }

    /* renamed from: u */
    public synchronized int m35671u() {
        return this.f28707c.size();
    }

    /* renamed from: v */
    public void m35672v() {
        synchronized (this) {
            try {
                long j10 = this.f28718n;
                long j11 = this.f28717m;
                if (j10 < j11) {
                    return;
                }
                this.f28717m = j11 + 1;
                this.f28721q = System.nanoTime() + 1000000000;
                try {
                    this.f28712h.execute(new c("OkHttp %s ping", this.f28708d));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: w */
    public void m35673w() throws IOException {
        m35659a(true);
    }

    /* renamed from: x */
    public void m35674x() throws IOException {
        synchronized (this) {
            this.f28719o++;
        }
        m35660a(false, 3, 1330343787);
    }

    /* renamed from: y */
    public void m35675y() throws InterruptedException, IOException {
        m35674x();
        m35669s();
    }

    /* renamed from: c */
    private C6168y9 m35641c(int i10, List<C6090s9> list, boolean z10) throws IOException {
        int i11;
        C6168y9 c6168y9;
        boolean z11;
        boolean z12 = !z10;
        synchronized (this.f28727w) {
            try {
                synchronized (this) {
                    try {
                        if (this.f28710f > 1073741823) {
                            m35657a(EnumC6077r9.REFUSED_STREAM);
                        }
                        if (this.f28711g) {
                            throw new C6064q9();
                        }
                        i11 = this.f28710f;
                        this.f28710f = i11 + 2;
                        c6168y9 = new C6168y9(i11, this, z12, false, null);
                        z11 = !z10 || this.f28723s == 0 || c6168y9.f29179b == 0;
                        if (c6168y9.m35882i()) {
                            this.f28707c.put(Integer.valueOf(i11), c6168y9);
                        }
                    } finally {
                    }
                }
                if (i10 == 0) {
                    this.f28727w.m35948a(z12, i11, list);
                } else {
                    if (this.f28705a) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.f28727w.m35941a(i10, i11, list);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            this.f28727w.flush();
        }
        return c6168y9;
    }

    /* renamed from: a */
    public C6168y9 m35648a(List<C6090s9> list, boolean z10) throws IOException {
        return m35641c(0, list, z10);
    }

    /* renamed from: b */
    public C6168y9 m35661b(int i10, List<C6090s9> list, boolean z10) throws IOException {
        if (this.f28705a) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return m35641c(i10, list, z10);
    }

    /* renamed from: d */
    public synchronized C6168y9 m35664d(int i10) {
        return this.f28707c.get(Integer.valueOf(i10));
    }

    /* renamed from: a */
    public void m35649a(int i10, long j10) {
        try {
            this.f28712h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f28708d, Integer.valueOf(i10)}, i10, j10));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: b */
    public void m35662b(int i10, EnumC6077r9 enumC6077r9) throws IOException {
        this.f28727w.m35943a(i10, enumC6077r9);
    }

    /* renamed from: c */
    public void m35663c(int i10, EnumC6077r9 enumC6077r9) {
        try {
            this.f28712h.execute(new a("OkHttp %s stream %d", new Object[]{this.f28708d, Integer.valueOf(i10)}, i10, enumC6077r9));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: a */
    public void m35650a(int i10, InterfaceC5896db interfaceC5896db, int i11, boolean z10) throws IOException {
        C5868bb c5868bb = new C5868bb();
        long j10 = i11;
        interfaceC5896db.mo33970i(j10);
        interfaceC5896db.read(c5868bb, j10);
        if (c5868bb.m33913B() == j10) {
            m35635a(new f("OkHttp %s Push Data[%s]", new Object[]{this.f28708d, Integer.valueOf(i10)}, i10, c5868bb, i11, z10));
            return;
        }
        throw new IOException(c5868bb.m33913B() + " != " + i11);
    }

    /* renamed from: a */
    public void m35651a(int i10, EnumC6077r9 enumC6077r9) {
        m35635a(new g("OkHttp %s Push Reset[%s]", new Object[]{this.f28708d, Integer.valueOf(i10)}, i10, enumC6077r9));
    }

    /* renamed from: a */
    public void m35652a(int i10, List<C6090s9> list) {
        synchronized (this) {
            try {
                if (this.f28729y.contains(Integer.valueOf(i10))) {
                    m35663c(i10, EnumC6077r9.PROTOCOL_ERROR);
                    return;
                }
                this.f28729y.add(Integer.valueOf(i10));
                try {
                    m35635a(new d("OkHttp %s Push Request[%s]", new Object[]{this.f28708d, Integer.valueOf(i10)}, i10, list));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m35653a(int i10, List<C6090s9> list, boolean z10) {
        try {
            m35635a(new e("OkHttp %s Push Headers[%s]", new Object[]{this.f28708d, Integer.valueOf(i10)}, i10, list, z10));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f28727w.m35951t());
        r6 = r2;
        r8.f28723s -= r6;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m35654a(int r9, boolean r10, com.huawei.hms.network.embedded.C5868bb r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            com.huawei.hms.network.embedded.z9 r8 = r8.f28727w
            r8.m35947a(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r4 = r8.f28723s     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.Map<java.lang.Integer, com.huawei.hms.network.embedded.y9> r2 = r8.f28707c     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
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
            com.huawei.hms.network.embedded.z9 r4 = r8.f28727w     // Catch: java.lang.Throwable -> L28
            int r4 = r4.m35951t()     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.f28723s     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.f28723s = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            com.huawei.hms.network.embedded.z9 r4 = r8.f28727w
            if (r10 == 0) goto L53
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = r3
        L54:
            r4.m35947a(r5, r9, r11, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6129v9.m35654a(int, boolean, com.huawei.hms.network.embedded.bb, long):void");
    }

    /* renamed from: a */
    public void m35655a(int i10, boolean z10, List<C6090s9> list) throws IOException {
        this.f28727w.m35948a(z10, i10, list);
    }

    /* renamed from: a */
    public void m35656a(C5881ca c5881ca) throws IOException {
        synchronized (this.f28727w) {
            synchronized (this) {
                if (this.f28711g) {
                    throw new C6064q9();
                }
                this.f28724t.m34076a(c5881ca);
            }
            this.f28727w.m35949b(c5881ca);
        }
    }

    /* renamed from: a */
    private synchronized void m35635a(AbstractRunnableC5893d8 abstractRunnableC5893d8) {
        if (!this.f28711g) {
            this.f28713i.execute(abstractRunnableC5893d8);
        }
    }

    /* renamed from: a */
    public void m35657a(EnumC6077r9 enumC6077r9) throws IOException {
        synchronized (this.f28727w) {
            synchronized (this) {
                if (this.f28711g) {
                    return;
                }
                this.f28711g = true;
                this.f28727w.m35944a(this.f28709e, enumC6077r9, C5920f8.f26769a);
            }
        }
    }

    /* renamed from: a */
    public void m35658a(EnumC6077r9 enumC6077r9, EnumC6077r9 enumC6077r92, IOException iOException) throws IOException {
        C6168y9[] c6168y9Arr;
        if (!f28703F && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        try {
            m35657a(enumC6077r9);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.f28707c.isEmpty()) {
                    c6168y9Arr = null;
                } else {
                    c6168y9Arr = (C6168y9[]) this.f28707c.values().toArray(new C6168y9[this.f28707c.size()]);
                    this.f28707c.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (c6168y9Arr != null) {
            for (C6168y9 c6168y9 : c6168y9Arr) {
                try {
                    c6168y9.m35872a(enumC6077r92, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f28727w.close();
        } catch (IOException unused3) {
        }
        try {
            this.f28726v.close();
        } catch (IOException unused4) {
        }
        this.f28712h.shutdown();
        this.f28713i.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m35637a(IOException iOException) throws IOException {
        EnumC6077r9 enumC6077r9 = EnumC6077r9.PROTOCOL_ERROR;
        m35658a(enumC6077r9, enumC6077r9, iOException);
    }

    /* renamed from: a */
    public void m35659a(boolean z10) throws IOException {
        if (z10) {
            this.f28727w.m35950s();
            this.f28727w.m35949b(this.f28724t);
            if (this.f28724t.m34080c() != 65535) {
                this.f28727w.m35942a(0, r5 - 65535);
            }
        }
        new Thread(this.f28728x).start();
    }

    /* renamed from: a */
    public void m35660a(boolean z10, int i10, int i11) throws IOException {
        try {
            this.f28727w.m35946a(z10, i10, i11);
        } catch (IOException e10) {
            m35637a(e10);
        }
    }
}
