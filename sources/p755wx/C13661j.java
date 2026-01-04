package p755wx;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p022ay.C1054d;
import p022ay.InterfaceC1055e;
import p755wx.C13655d;
import sx.C12875e;

/* renamed from: wx.j */
/* loaded from: classes9.dex */
public final class C13661j implements Closeable {

    /* renamed from: g */
    public static final Logger f61524g = Logger.getLogger(C13656e.class.getName());

    /* renamed from: a */
    public final InterfaceC1055e f61525a;

    /* renamed from: b */
    public final boolean f61526b;

    /* renamed from: c */
    public final C1054d f61527c;

    /* renamed from: d */
    public int f61528d;

    /* renamed from: e */
    public boolean f61529e;

    /* renamed from: f */
    public final C13655d.b f61530f;

    public C13661j(InterfaceC1055e interfaceC1055e, boolean z10) {
        this.f61525a = interfaceC1055e;
        this.f61526b = z10;
        C1054d c1054d = new C1054d();
        this.f61527c = c1054d;
        this.f61530f = new C13655d.b(c1054d);
        this.f61528d = 16384;
    }

    /* renamed from: F */
    public static void m82164F(InterfaceC1055e interfaceC1055e, int i10) throws IOException {
        interfaceC1055e.writeByte((i10 >>> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        interfaceC1055e.writeByte((i10 >>> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        interfaceC1055e.writeByte(i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: A */
    public synchronized void m82165A(int i10, int i11, List<C13654c> list) throws IOException {
        if (this.f61529e) {
            throw new IOException("closed");
        }
        this.f61530f.m82066g(list);
        long jM6322J = this.f61527c.m6322J();
        int iMin = (int) Math.min(this.f61528d - 4, jM6322J);
        long j10 = iMin;
        m82174v(i10, iMin + 4, (byte) 5, jM6322J == j10 ? (byte) 4 : (byte) 0);
        this.f61525a.writeInt(i11 & Integer.MAX_VALUE);
        this.f61525a.write(this.f61527c, j10);
        if (jM6322J > j10) {
            m82169E(i10, jM6322J - j10);
        }
    }

    /* renamed from: B */
    public synchronized void m82166B(int i10, EnumC13653b enumC13653b) throws IOException {
        if (this.f61529e) {
            throw new IOException("closed");
        }
        if (enumC13653b.f61376a == -1) {
            throw new IllegalArgumentException();
        }
        m82174v(i10, 4, (byte) 3, (byte) 0);
        this.f61525a.writeInt(enumC13653b.f61376a);
        this.f61525a.flush();
    }

    /* renamed from: C */
    public synchronized void m82167C(C13664m c13664m) throws IOException {
        try {
            if (this.f61529e) {
                throw new IOException("closed");
            }
            int i10 = 0;
            m82174v(0, c13664m.m82198j() * 6, (byte) 4, (byte) 0);
            while (i10 < 10) {
                if (c13664m.m82195g(i10)) {
                    this.f61525a.writeShort(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                    this.f61525a.writeInt(c13664m.m82190b(i10));
                }
                i10++;
            }
            this.f61525a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: D */
    public synchronized void m82168D(int i10, long j10) throws IOException {
        if (this.f61529e) {
            throw new IOException("closed");
        }
        if (j10 == 0 || j10 > 2147483647L) {
            throw C13656e.m82070c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
        }
        m82174v(i10, 4, (byte) 8, (byte) 0);
        this.f61525a.writeInt((int) j10);
        this.f61525a.flush();
    }

    /* renamed from: E */
    public final void m82169E(int i10, long j10) throws IOException {
        while (j10 > 0) {
            int iMin = (int) Math.min(this.f61528d, j10);
            long j11 = iMin;
            j10 -= j11;
            m82174v(i10, iMin, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
            this.f61525a.write(this.f61527c, j11);
        }
    }

    /* renamed from: b */
    public synchronized void m82170b(C13664m c13664m) throws IOException {
        try {
            if (this.f61529e) {
                throw new IOException("closed");
            }
            this.f61528d = c13664m.m82194f(this.f61528d);
            if (c13664m.m82191c() != -1) {
                this.f61530f.m82064e(c13664m.m82191c());
            }
            m82174v(0, 0, (byte) 4, (byte) 1);
            this.f61525a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f61529e = true;
        this.f61525a.close();
    }

    public synchronized void flush() throws IOException {
        if (this.f61529e) {
            throw new IOException("closed");
        }
        this.f61525a.flush();
    }

    /* renamed from: s */
    public synchronized void m82171s() throws IOException {
        try {
            if (this.f61529e) {
                throw new IOException("closed");
            }
            if (this.f61526b) {
                Logger logger = f61524g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(C12875e.m77260q(">> CONNECTION %s", C13656e.f61406a.mo6384u()));
                }
                this.f61525a.write(C13656e.f61406a.mo6373H());
                this.f61525a.flush();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: t */
    public synchronized void m82172t(boolean z10, int i10, C1054d c1054d, int i11) throws IOException {
        if (this.f61529e) {
            throw new IOException("closed");
        }
        m82173u(i10, z10 ? (byte) 1 : (byte) 0, c1054d, i11);
    }

    /* renamed from: u */
    public void m82173u(int i10, byte b10, C1054d c1054d, int i11) throws IOException {
        m82174v(i10, i11, (byte) 0, b10);
        if (i11 > 0) {
            this.f61525a.write(c1054d, i11);
        }
    }

    /* renamed from: v */
    public void m82174v(int i10, int i11, byte b10, byte b11) throws IOException {
        Logger logger = f61524g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C13656e.m82069b(false, i10, i11, b10, b11));
        }
        int i12 = this.f61528d;
        if (i11 > i12) {
            throw C13656e.m82070c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            throw C13656e.m82070c("reserved bit set: %s", Integer.valueOf(i10));
        }
        m82164F(this.f61525a, i11);
        this.f61525a.writeByte(b10 & 255);
        this.f61525a.writeByte(b11 & 255);
        this.f61525a.writeInt(i10 & Integer.MAX_VALUE);
    }

    /* renamed from: w */
    public synchronized void m82175w(int i10, EnumC13653b enumC13653b, byte[] bArr) throws IOException {
        try {
            if (this.f61529e) {
                throw new IOException("closed");
            }
            if (enumC13653b.f61376a == -1) {
                throw C13656e.m82070c("errorCode.httpCode == -1", new Object[0]);
            }
            m82174v(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f61525a.writeInt(i10);
            this.f61525a.writeInt(enumC13653b.f61376a);
            if (bArr.length > 0) {
                this.f61525a.write(bArr);
            }
            this.f61525a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: x */
    public synchronized void m82176x(boolean z10, int i10, List<C13654c> list) throws IOException {
        if (this.f61529e) {
            throw new IOException("closed");
        }
        this.f61530f.m82066g(list);
        long jM6322J = this.f61527c.m6322J();
        int iMin = (int) Math.min(this.f61528d, jM6322J);
        long j10 = iMin;
        byte b10 = jM6322J == j10 ? (byte) 4 : (byte) 0;
        if (z10) {
            b10 = (byte) (b10 | 1);
        }
        m82174v(i10, iMin, (byte) 1, b10);
        this.f61525a.write(this.f61527c, j10);
        if (jM6322J > j10) {
            m82169E(i10, jM6322J - j10);
        }
    }

    /* renamed from: y */
    public int m82177y() {
        return this.f61528d;
    }

    /* renamed from: z */
    public synchronized void m82178z(boolean z10, int i10, int i11) throws IOException {
        if (this.f61529e) {
            throw new IOException("closed");
        }
        m82174v(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
        this.f61525a.writeInt(i10);
        this.f61525a.writeInt(i11);
        this.f61525a.flush();
    }
}
