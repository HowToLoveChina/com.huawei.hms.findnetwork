package com.huawei.hms.drive;

import com.huawei.hms.drive.C5248cy;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p022ay.C1054d;
import p022ay.InterfaceC1055e;

/* renamed from: com.huawei.hms.drive.de */
/* loaded from: classes8.dex */
final class C5256de implements Closeable {

    /* renamed from: b */
    private static final Logger f24432b = Logger.getLogger(C5249cz.class.getName());

    /* renamed from: a */
    final C5248cy.b f24433a;

    /* renamed from: c */
    private final InterfaceC1055e f24434c;

    /* renamed from: d */
    private final boolean f24435d;

    /* renamed from: e */
    private final C1054d f24436e;

    /* renamed from: f */
    private int f24437f;

    /* renamed from: g */
    private boolean f24438g;

    public C5256de(InterfaceC1055e interfaceC1055e, boolean z10) {
        this.f24434c = interfaceC1055e;
        this.f24435d = z10;
        C1054d c1054d = new C1054d();
        this.f24436e = c1054d;
        this.f24433a = new C5248cy.b(c1054d);
        this.f24437f = 16384;
    }

    /* renamed from: a */
    public void m31607a(int i10, byte b10, C1054d c1054d, int i11) throws IOException {
        m31608a(i10, i11, (byte) 0, b10);
        if (i11 > 0) {
            this.f24434c.write(c1054d, i11);
        }
    }

    /* renamed from: b */
    public synchronized void m31617b() throws IOException {
        if (this.f24438g) {
            throw new IOException("closed");
        }
        this.f24434c.flush();
    }

    /* renamed from: c */
    public int m31619c() {
        return this.f24437f;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f24438g = true;
        this.f24434c.close();
    }

    /* renamed from: a */
    private static void m31604a(InterfaceC1055e interfaceC1055e, int i10) throws IOException {
        interfaceC1055e.writeByte((i10 >>> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        interfaceC1055e.writeByte((i10 >>> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        interfaceC1055e.writeByte(i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: b */
    public synchronized void m31618b(C5259dh c5259dh) throws IOException {
        try {
            if (!this.f24438g) {
                int i10 = 0;
                m31608a(0, c5259dh.m31634b() * 6, (byte) 4, (byte) 0);
                while (i10 < 10) {
                    if (c5259dh.m31633a(i10)) {
                        this.f24434c.writeShort(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                        this.f24434c.writeInt(c5259dh.m31635b(i10));
                    }
                    i10++;
                }
                this.f24434c.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m31615a(boolean z10, int i10, C1054d c1054d, int i11) throws IOException {
        if (!this.f24438g) {
            m31607a(i10, z10 ? (byte) 1 : (byte) 0, c1054d, i11);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m31606a() throws IOException {
        try {
            if (!this.f24438g) {
                if (this.f24435d) {
                    Logger logger = f24432b;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(C5210bo.m31181a(">> CONNECTION %s", C5249cz.f24297a.mo6384u()));
                    }
                    this.f24434c.write(C5249cz.f24297a.mo6373H());
                    this.f24434c.flush();
                    return;
                }
                return;
            }
            throw new IOException("closed");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    private void m31605b(int i10, long j10) throws IOException {
        while (j10 > 0) {
            int iMin = (int) Math.min(this.f24437f, j10);
            long j11 = iMin;
            j10 -= j11;
            m31608a(i10, iMin, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
            this.f24434c.write(this.f24436e, j11);
        }
    }

    /* renamed from: a */
    public synchronized void m31613a(C5259dh c5259dh) throws IOException {
        try {
            if (!this.f24438g) {
                this.f24437f = c5259dh.m31639d(this.f24437f);
                if (c5259dh.m31636c() != -1) {
                    this.f24433a.m31479a(c5259dh.m31636c());
                }
                m31608a(0, 0, (byte) 4, (byte) 1);
                this.f24434c.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m31609a(int i10, int i11, List<C5247cx> list) throws IOException {
        if (!this.f24438g) {
            this.f24433a.m31482a(list);
            long jM6322J = this.f24436e.m6322J();
            int iMin = (int) Math.min(this.f24437f - 4, jM6322J);
            long j10 = iMin;
            m31608a(i10, iMin + 4, (byte) 5, jM6322J == j10 ? (byte) 4 : (byte) 0);
            this.f24434c.writeInt(i11 & Integer.MAX_VALUE);
            this.f24434c.write(this.f24436e, j10);
            if (jM6322J > j10) {
                m31605b(i10, jM6322J - j10);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m31611a(int i10, EnumC5246cw enumC5246cw) throws IOException {
        if (!this.f24438g) {
            if (enumC5246cw.f24267l != -1) {
                m31608a(i10, 4, (byte) 3, (byte) 0);
                this.f24434c.writeInt(enumC5246cw.f24267l);
                this.f24434c.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m31614a(boolean z10, int i10, int i11) throws IOException {
        if (!this.f24438g) {
            m31608a(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
            this.f24434c.writeInt(i10);
            this.f24434c.writeInt(i11);
            this.f24434c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m31612a(int i10, EnumC5246cw enumC5246cw, byte[] bArr) throws IOException {
        try {
            if (!this.f24438g) {
                if (enumC5246cw.f24267l != -1) {
                    m31608a(0, bArr.length + 8, (byte) 7, (byte) 0);
                    this.f24434c.writeInt(i10);
                    this.f24434c.writeInt(enumC5246cw.f24267l);
                    if (bArr.length > 0) {
                        this.f24434c.write(bArr);
                    }
                    this.f24434c.flush();
                } else {
                    throw C5249cz.m31483a("errorCode.httpCode == -1", new Object[0]);
                }
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m31610a(int i10, long j10) throws IOException {
        if (this.f24438g) {
            throw new IOException("closed");
        }
        if (j10 != 0 && j10 <= 2147483647L) {
            m31608a(i10, 4, (byte) 8, (byte) 0);
            this.f24434c.writeInt((int) j10);
            this.f24434c.flush();
        } else {
            throw C5249cz.m31483a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
        }
    }

    /* renamed from: a */
    public void m31608a(int i10, int i11, byte b10, byte b11) throws IOException {
        Logger logger = f24432b;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C5249cz.m31485a(false, i10, i11, b10, b11));
        }
        int i12 = this.f24437f;
        if (i11 > i12) {
            throw C5249cz.m31483a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
        }
        if ((Integer.MIN_VALUE & i10) == 0) {
            m31604a(this.f24434c, i11);
            this.f24434c.writeByte(b10 & 255);
            this.f24434c.writeByte(b11 & 255);
            this.f24434c.writeInt(i10 & Integer.MAX_VALUE);
            return;
        }
        throw C5249cz.m31483a("reserved bit set: %s", Integer.valueOf(i10));
    }

    /* renamed from: a */
    public synchronized void m31616a(boolean z10, int i10, List<C5247cx> list) throws IOException {
        if (!this.f24438g) {
            this.f24433a.m31482a(list);
            long jM6322J = this.f24436e.m6322J();
            int iMin = (int) Math.min(this.f24437f, jM6322J);
            long j10 = iMin;
            byte b10 = jM6322J == j10 ? (byte) 4 : (byte) 0;
            if (z10) {
                b10 = (byte) (b10 | 1);
            }
            m31608a(i10, iMin, (byte) 1, b10);
            this.f24434c.write(this.f24436e, j10);
            if (jM6322J > j10) {
                m31605b(i10, jM6322J - j10);
            }
        } else {
            throw new IOException("closed");
        }
    }
}
