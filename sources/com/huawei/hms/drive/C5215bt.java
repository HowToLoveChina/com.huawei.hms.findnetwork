package com.huawei.hms.drive;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import p022ay.InterfaceC1055e;

/* renamed from: com.huawei.hms.drive.bt */
/* loaded from: classes8.dex */
public final class C5215bt implements Closeable, Flushable {

    /* renamed from: a */
    static final Pattern f24020a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: j */
    static final /* synthetic */ boolean f24021j = true;

    /* renamed from: b */
    final InterfaceC5261dj f24022b;

    /* renamed from: c */
    final int f24023c;

    /* renamed from: d */
    InterfaceC1055e f24024d;

    /* renamed from: e */
    final LinkedHashMap<String, b> f24025e;

    /* renamed from: f */
    int f24026f;

    /* renamed from: g */
    boolean f24027g;

    /* renamed from: h */
    boolean f24028h;

    /* renamed from: i */
    boolean f24029i;

    /* renamed from: k */
    private long f24030k;

    /* renamed from: l */
    private long f24031l;

    /* renamed from: m */
    private long f24032m;

    /* renamed from: n */
    private final Executor f24033n;

    /* renamed from: o */
    private final Runnable f24034o;

    /* renamed from: com.huawei.hms.drive.bt$a */
    public final class a {

        /* renamed from: a */
        final b f24035a;

        /* renamed from: b */
        final boolean[] f24036b;

        /* renamed from: c */
        final /* synthetic */ C5215bt f24037c;

        /* renamed from: d */
        private boolean f24038d;

        /* renamed from: a */
        public void m31232a() {
            if (this.f24035a.f24044f != this) {
                return;
            }
            int i10 = 0;
            while (true) {
                C5215bt c5215bt = this.f24037c;
                if (i10 >= c5215bt.f24023c) {
                    this.f24035a.f24044f = null;
                    return;
                } else {
                    try {
                        c5215bt.f24022b.mo31640a(this.f24035a.f24042d[i10]);
                    } catch (IOException unused) {
                    }
                    i10++;
                }
            }
        }

        /* renamed from: b */
        public void m31233b() throws IOException {
            synchronized (this.f24037c) {
                try {
                    if (this.f24038d) {
                        throw new IllegalStateException();
                    }
                    if (this.f24035a.f24044f == this) {
                        this.f24037c.m31227a(this, false);
                    }
                    this.f24038d = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.drive.bt$b */
    public final class b {

        /* renamed from: a */
        final String f24039a;

        /* renamed from: b */
        final long[] f24040b;

        /* renamed from: c */
        final File[] f24041c;

        /* renamed from: d */
        final File[] f24042d;

        /* renamed from: e */
        boolean f24043e;

        /* renamed from: f */
        a f24044f;

        /* renamed from: g */
        long f24045g;

        /* renamed from: a */
        public void m31234a(InterfaceC1055e interfaceC1055e) throws IOException {
            for (long j10 : this.f24040b) {
                interfaceC1055e.writeByte(32).mo6360y0(j10);
            }
        }
    }

    /* renamed from: d */
    private synchronized void m31226d() {
        if (m31230b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: a */
    public synchronized void m31227a(a aVar, boolean z10) throws IOException {
        b bVar = aVar.f24035a;
        if (bVar.f24044f != aVar) {
            throw new IllegalStateException();
        }
        if (z10 && !bVar.f24043e) {
            for (int i10 = 0; i10 < this.f24023c; i10++) {
                if (!aVar.f24036b[i10]) {
                    aVar.m31233b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!this.f24022b.mo31642b(bVar.f24042d[i10])) {
                    aVar.m31233b();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f24023c; i11++) {
            File file = bVar.f24042d[i11];
            if (!z10) {
                this.f24022b.mo31640a(file);
            } else if (this.f24022b.mo31642b(file)) {
                File file2 = bVar.f24041c[i11];
                this.f24022b.mo31641a(file, file2);
                long j10 = bVar.f24040b[i11];
                long jMo31643c = this.f24022b.mo31643c(file2);
                bVar.f24040b[i11] = jMo31643c;
                this.f24031l = (this.f24031l - j10) + jMo31643c;
            }
        }
        this.f24026f++;
        bVar.f24044f = null;
        if (bVar.f24043e || z10) {
            bVar.f24043e = true;
            this.f24024d.mo6329R("CLEAN").writeByte(32);
            this.f24024d.mo6329R(bVar.f24039a);
            bVar.m31234a(this.f24024d);
            this.f24024d.writeByte(10);
            if (z10) {
                long j11 = this.f24032m;
                this.f24032m = 1 + j11;
                bVar.f24045g = j11;
            }
        } else {
            this.f24025e.remove(bVar.f24039a);
            this.f24024d.mo6329R("REMOVE").writeByte(32);
            this.f24024d.mo6329R(bVar.f24039a);
            this.f24024d.writeByte(10);
        }
        this.f24024d.flush();
        if (this.f24031l > this.f24030k || m31228a()) {
            this.f24033n.execute(this.f24034o);
        }
    }

    /* renamed from: b */
    public synchronized boolean m31230b() {
        return this.f24028h;
    }

    /* renamed from: c */
    public void m31231c() throws IOException {
        while (this.f24031l > this.f24030k) {
            m31229a(this.f24025e.values().iterator().next());
        }
        this.f24029i = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f24027g && !this.f24028h) {
                for (b bVar : (b[]) this.f24025e.values().toArray(new b[this.f24025e.size()])) {
                    a aVar = bVar.f24044f;
                    if (aVar != null) {
                        aVar.m31233b();
                    }
                }
                m31231c();
                this.f24024d.close();
                this.f24024d = null;
                this.f24028h = true;
                return;
            }
            this.f24028h = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f24027g) {
            m31226d();
            m31231c();
            this.f24024d.flush();
        }
    }

    /* renamed from: a */
    public boolean m31228a() {
        int i10 = this.f24026f;
        return i10 >= 2000 && i10 >= this.f24025e.size();
    }

    /* renamed from: a */
    public boolean m31229a(b bVar) throws IOException {
        a aVar = bVar.f24044f;
        if (aVar != null) {
            aVar.m31232a();
        }
        for (int i10 = 0; i10 < this.f24023c; i10++) {
            this.f24022b.mo31640a(bVar.f24041c[i10]);
            long j10 = this.f24031l;
            long[] jArr = bVar.f24040b;
            this.f24031l = j10 - jArr[i10];
            jArr[i10] = 0;
        }
        this.f24026f++;
        this.f24024d.mo6329R("REMOVE").writeByte(32).mo6329R(bVar.f24039a).writeByte(10);
        this.f24025e.remove(bVar.f24039a);
        if (m31228a()) {
            this.f24033n.execute(this.f24034o);
        }
        return true;
    }
}
