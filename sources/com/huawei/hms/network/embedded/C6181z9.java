package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6103t9;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.huawei.hms.network.embedded.z9 */
/* loaded from: classes8.dex */
public final class C6181z9 implements Closeable {

    /* renamed from: g */
    public static final Logger f29238g = Logger.getLogger(C6116u9.class.getName());

    /* renamed from: a */
    public final InterfaceC5882cb f29239a;

    /* renamed from: b */
    public final boolean f29240b;

    /* renamed from: c */
    public final C5868bb f29241c;

    /* renamed from: d */
    public int f29242d;

    /* renamed from: e */
    public boolean f29243e;

    /* renamed from: f */
    public final C6103t9.b f29244f;

    public C6181z9(InterfaceC5882cb interfaceC5882cb, boolean z10) {
        this.f29239a = interfaceC5882cb;
        this.f29240b = z10;
        C5868bb c5868bb = new C5868bb();
        this.f29241c = c5868bb;
        this.f29244f = new C6103t9.b(c5868bb);
        this.f29242d = 16384;
    }

    /* renamed from: b */
    private void m35938b(int i10, long j10) throws IOException {
        while (j10 > 0) {
            int iMin = (int) Math.min(this.f29242d, j10);
            long j11 = iMin;
            j10 -= j11;
            m35940a(i10, iMin, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
            this.f29239a.write(this.f29241c, j11);
        }
    }

    /* renamed from: a */
    public void m35939a(int i10, byte b10, C5868bb c5868bb, int i11) throws IOException {
        m35940a(i10, i11, (byte) 0, b10);
        if (i11 > 0) {
            this.f29239a.write(c5868bb, i11);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f29243e = true;
        this.f29239a.close();
    }

    public synchronized void flush() throws IOException {
        if (this.f29243e) {
            throw new IOException("closed");
        }
        this.f29239a.flush();
    }

    /* renamed from: s */
    public synchronized void m35950s() throws IOException {
        try {
            if (this.f29243e) {
                throw new IOException("closed");
            }
            if (this.f29240b) {
                Logger logger = f29238g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(C5920f8.m34236a(">> CONNECTION %s", C6116u9.f28524a.mo34181d()));
                }
                this.f29239a.write(C6116u9.f28524a.mo34195m());
                this.f29239a.flush();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: t */
    public int m35951t() {
        return this.f29242d;
    }

    /* renamed from: a */
    public void m35940a(int i10, int i11, byte b10, byte b11) throws IOException {
        Logger logger = f29238g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C6116u9.m35513a(false, i10, i11, b10, b11));
        }
        int i12 = this.f29242d;
        if (i11 > i12) {
            throw C6116u9.m35511a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            throw C6116u9.m35511a("reserved bit set: %s", Integer.valueOf(i10));
        }
        m35937a(this.f29239a, i11);
        this.f29239a.writeByte(b10 & 255);
        this.f29239a.writeByte(b11 & 255);
        this.f29239a.writeInt(i10 & Integer.MAX_VALUE);
    }

    /* renamed from: b */
    public synchronized void m35949b(C5881ca c5881ca) throws IOException {
        try {
            if (this.f29243e) {
                throw new IOException("closed");
            }
            int i10 = 0;
            m35940a(0, c5881ca.m34082d() * 6, (byte) 4, (byte) 0);
            while (i10 < 10) {
                if (c5881ca.m34084e(i10)) {
                    this.f29239a.writeShort(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                    this.f29239a.writeInt(c5881ca.m34073a(i10));
                }
                i10++;
            }
            this.f29239a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m35941a(int i10, int i11, List<C6090s9> list) throws IOException {
        if (this.f29243e) {
            throw new IOException("closed");
        }
        this.f29244f.m35473a(list);
        long jM33913B = this.f29241c.m33913B();
        int iMin = (int) Math.min(this.f29242d - 4, jM33913B);
        long j10 = iMin;
        m35940a(i10, iMin + 4, (byte) 5, jM33913B == j10 ? (byte) 4 : (byte) 0);
        this.f29239a.writeInt(i11 & Integer.MAX_VALUE);
        this.f29239a.write(this.f29241c, j10);
        if (jM33913B > j10) {
            m35938b(i10, jM33913B - j10);
        }
    }

    /* renamed from: a */
    public synchronized void m35942a(int i10, long j10) throws IOException {
        if (this.f29243e) {
            throw new IOException("closed");
        }
        if (j10 == 0 || j10 > 2147483647L) {
            throw C6116u9.m35511a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
        }
        m35940a(i10, 4, (byte) 8, (byte) 0);
        this.f29239a.writeInt((int) j10);
        this.f29239a.flush();
    }

    /* renamed from: a */
    public synchronized void m35943a(int i10, EnumC6077r9 enumC6077r9) throws IOException {
        if (this.f29243e) {
            throw new IOException("closed");
        }
        if (enumC6077r9.f28121a == -1) {
            throw new IllegalArgumentException();
        }
        m35940a(i10, 4, (byte) 3, (byte) 0);
        this.f29239a.writeInt(enumC6077r9.f28121a);
        this.f29239a.flush();
    }

    /* renamed from: a */
    public synchronized void m35944a(int i10, EnumC6077r9 enumC6077r9, byte[] bArr) throws IOException {
        try {
            if (this.f29243e) {
                throw new IOException("closed");
            }
            if (enumC6077r9.f28121a == -1) {
                throw C6116u9.m35511a("errorCode.httpCode == -1", new Object[0]);
            }
            m35940a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f29239a.writeInt(i10);
            this.f29239a.writeInt(enumC6077r9.f28121a);
            if (bArr.length > 0) {
                this.f29239a.write(bArr);
            }
            this.f29239a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m35945a(C5881ca c5881ca) throws IOException {
        try {
            if (this.f29243e) {
                throw new IOException("closed");
            }
            this.f29242d = c5881ca.m34081c(this.f29242d);
            if (c5881ca.m34078b() != -1) {
                this.f29244f.m35470a(c5881ca.m34078b());
            }
            m35940a(0, 0, (byte) 4, (byte) 1);
            this.f29239a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public static void m35937a(InterfaceC5882cb interfaceC5882cb, int i10) throws IOException {
        interfaceC5882cb.writeByte((i10 >>> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        interfaceC5882cb.writeByte((i10 >>> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        interfaceC5882cb.writeByte(i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: a */
    public synchronized void m35946a(boolean z10, int i10, int i11) throws IOException {
        if (this.f29243e) {
            throw new IOException("closed");
        }
        m35940a(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
        this.f29239a.writeInt(i10);
        this.f29239a.writeInt(i11);
        this.f29239a.flush();
    }

    /* renamed from: a */
    public synchronized void m35947a(boolean z10, int i10, C5868bb c5868bb, int i11) throws IOException {
        if (this.f29243e) {
            throw new IOException("closed");
        }
        m35939a(i10, z10 ? (byte) 1 : (byte) 0, c5868bb, i11);
    }

    /* renamed from: a */
    public synchronized void m35948a(boolean z10, int i10, List<C6090s9> list) throws IOException {
        if (this.f29243e) {
            throw new IOException("closed");
        }
        this.f29244f.m35473a(list);
        long jM33913B = this.f29241c.m33913B();
        int iMin = (int) Math.min(this.f29242d, jM33913B);
        long j10 = iMin;
        byte b10 = jM33913B == j10 ? (byte) 4 : (byte) 0;
        if (z10) {
            b10 = (byte) (b10 | 1);
        }
        m35940a(i10, iMin, (byte) 1, b10);
        this.f29239a.write(this.f29241c, j10);
        if (jM33913B > j10) {
            m35938b(i10, jM33913B - j10);
        }
    }
}
