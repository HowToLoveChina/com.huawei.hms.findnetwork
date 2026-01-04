package com.huawei.hms.network.embedded;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.huawei.hms.network.embedded.p8 */
/* loaded from: classes8.dex */
public final class C6050p8 {

    /* renamed from: k */
    public static final int f27738k = 1;

    /* renamed from: l */
    public static final int f27739l = 2;

    /* renamed from: m */
    public static final C5910eb f27740m = C5910eb.m34157d("OkHttp cache v1\n");

    /* renamed from: n */
    public static final C5910eb f27741n = C5910eb.m34157d("OkHttp DIRTY :(\n");

    /* renamed from: o */
    public static final long f27742o = 32;

    /* renamed from: a */
    public RandomAccessFile f27743a;

    /* renamed from: b */
    public Thread f27744b;

    /* renamed from: c */
    public InterfaceC6183zb f27745c;

    /* renamed from: e */
    public long f27747e;

    /* renamed from: f */
    public boolean f27748f;

    /* renamed from: g */
    public final C5910eb f27749g;

    /* renamed from: i */
    public final long f27751i;

    /* renamed from: j */
    public int f27752j;

    /* renamed from: d */
    public final C5868bb f27746d = new C5868bb();

    /* renamed from: h */
    public final C5868bb f27750h = new C5868bb();

    /* renamed from: com.huawei.hms.network.embedded.p8$a */
    public class a implements InterfaceC6183zb {

        /* renamed from: a */
        public final C5855ac f27753a = new C5855ac();

        /* renamed from: b */
        public C6037o8 f27754b;

        /* renamed from: c */
        public long f27755c;

        public a() {
            this.f27754b = new C6037o8(C6050p8.this.f27743a.getChannel());
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            if (this.f27754b == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.f27754b = null;
            synchronized (C6050p8.this) {
                try {
                    C6050p8 c6050p8 = C6050p8.this;
                    int i10 = c6050p8.f27752j - 1;
                    c6050p8.f27752j = i10;
                    if (i10 == 0) {
                        RandomAccessFile randomAccessFile2 = c6050p8.f27743a;
                        c6050p8.f27743a = null;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (randomAccessFile != null) {
                C5920f8.m34248a(randomAccessFile);
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            long j11;
            char c10;
            C6050p8 c6050p8;
            if (this.f27754b == null) {
                throw new IllegalStateException("closed");
            }
            synchronized (C6050p8.this) {
                while (true) {
                    try {
                        long j12 = this.f27755c;
                        C6050p8 c6050p82 = C6050p8.this;
                        j11 = c6050p82.f27747e;
                        if (j12 != j11) {
                            long jM33913B = j11 - c6050p82.f27750h.m33913B();
                            long j13 = this.f27755c;
                            if (j13 >= jM33913B) {
                                long jMin = Math.min(j10, j11 - j13);
                                C6050p8.this.f27750h.m33927a(c5868bb, this.f27755c - jM33913B, jMin);
                                this.f27755c += jMin;
                                return jMin;
                            }
                            c10 = 2;
                        } else if (!c6050p82.f27748f) {
                            if (c6050p82.f27744b == null) {
                                c6050p82.f27744b = Thread.currentThread();
                                c10 = 1;
                                break;
                            }
                            this.f27753a.m33843a(c6050p82);
                        } else {
                            return -1L;
                        }
                    } finally {
                    }
                }
                if (c10 == 2) {
                    long jMin2 = Math.min(j10, j11 - this.f27755c);
                    this.f27754b.m34928a(this.f27755c + 32, c5868bb, jMin2);
                    this.f27755c += jMin2;
                    return jMin2;
                }
                try {
                    C6050p8 c6050p83 = C6050p8.this;
                    long j14 = c6050p83.f27745c.read(c6050p83.f27746d, c6050p83.f27751i);
                    if (j14 == -1) {
                        C6050p8.this.m35015a(j11);
                        synchronized (C6050p8.this) {
                            C6050p8 c6050p84 = C6050p8.this;
                            c6050p84.f27744b = null;
                            c6050p84.notifyAll();
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j14, j10);
                    C6050p8.this.f27746d.m33927a(c5868bb, 0L, jMin3);
                    this.f27755c += jMin3;
                    this.f27754b.m34929b(j11 + 32, C6050p8.this.f27746d.m85653clone(), j14);
                    synchronized (C6050p8.this) {
                        try {
                            C6050p8 c6050p85 = C6050p8.this;
                            c6050p85.f27750h.write(c6050p85.f27746d, j14);
                            long jM33913B2 = C6050p8.this.f27750h.m33913B();
                            C6050p8 c6050p86 = C6050p8.this;
                            if (jM33913B2 > c6050p86.f27751i) {
                                C5868bb c5868bb2 = c6050p86.f27750h;
                                c5868bb2.skip(c5868bb2.m33913B() - C6050p8.this.f27751i);
                            }
                            c6050p8 = C6050p8.this;
                            c6050p8.f27747e += j14;
                        } finally {
                        }
                    }
                    synchronized (c6050p8) {
                        C6050p8 c6050p87 = C6050p8.this;
                        c6050p87.f27744b = null;
                        c6050p87.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th2) {
                    synchronized (C6050p8.this) {
                        C6050p8 c6050p88 = C6050p8.this;
                        c6050p88.f27744b = null;
                        c6050p88.notifyAll();
                        throw th2;
                    }
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f27753a;
        }
    }

    public C6050p8(RandomAccessFile randomAccessFile, InterfaceC6183zb interfaceC6183zb, long j10, C5910eb c5910eb, long j11) {
        this.f27743a = randomAccessFile;
        this.f27745c = interfaceC6183zb;
        this.f27748f = interfaceC6183zb == null;
        this.f27747e = j10;
        this.f27749g = c5910eb;
        this.f27751i = j11;
    }

    /* renamed from: a */
    public static C6050p8 m35011a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        C6037o8 c6037o8 = new C6037o8(randomAccessFile.getChannel());
        C5868bb c5868bb = new C5868bb();
        c6037o8.m34928a(0L, c5868bb, 32L);
        if (!c5868bb.mo33957d(r2.mo34192j()).equals(f27740m)) {
            throw new IOException("unreadable cache file");
        }
        long j10 = c5868bb.readLong();
        long j11 = c5868bb.readLong();
        C5868bb c5868bb2 = new C5868bb();
        c6037o8.m34928a(j10 + 32, c5868bb2, j11);
        return new C6050p8(randomAccessFile, null, j10, c5868bb2.mo33982r(), 0L);
    }

    /* renamed from: b */
    public C5910eb m35017b() {
        return this.f27749g;
    }

    /* renamed from: c */
    public InterfaceC6183zb m35018c() {
        synchronized (this) {
            try {
                if (this.f27743a == null) {
                    return null;
                }
                this.f27752j++;
                return new a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static C6050p8 m35012a(File file, InterfaceC6183zb interfaceC6183zb, C5910eb c5910eb, long j10) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        C6050p8 c6050p8 = new C6050p8(randomAccessFile, interfaceC6183zb, 0L, c5910eb, j10);
        randomAccessFile.setLength(0L);
        c6050p8.m35013a(f27741n, -1L, -1L);
        return c6050p8;
    }

    /* renamed from: b */
    private void m35014b(long j10) throws IOException {
        C5868bb c5868bb = new C5868bb();
        c5868bb.mo33928a(this.f27749g);
        new C6037o8(this.f27743a.getChannel()).m34929b(32 + j10, c5868bb, this.f27749g.mo34192j());
    }

    /* renamed from: a */
    public void m35015a(long j10) throws IOException {
        m35014b(j10);
        this.f27743a.getChannel().force(false);
        m35013a(f27740m, j10, this.f27749g.mo34192j());
        this.f27743a.getChannel().force(false);
        synchronized (this) {
            this.f27748f = true;
        }
        C5920f8.m34248a(this.f27745c);
        this.f27745c = null;
    }

    /* renamed from: a */
    private void m35013a(C5910eb c5910eb, long j10, long j11) throws IOException {
        C5868bb c5868bb = new C5868bb();
        c5868bb.mo33928a(c5910eb);
        c5868bb.writeLong(j10);
        c5868bb.writeLong(j11);
        if (c5868bb.m33913B() != 32) {
            throw new IllegalArgumentException();
        }
        new C6037o8(this.f27743a.getChannel()).m34929b(0L, c5868bb, 32L);
    }

    /* renamed from: a */
    public boolean m35016a() {
        return this.f27743a == null;
    }
}
