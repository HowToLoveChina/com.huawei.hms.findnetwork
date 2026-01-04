package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.hms.network.embedded.f2 */
/* loaded from: classes8.dex */
public class C5914f2 extends InputStream {

    /* renamed from: e */
    public static final String f26732e = "CronetInputStream";

    /* renamed from: f */
    public static final int f26733f = 32768;

    /* renamed from: g */
    public static final int f26734g = 1;

    /* renamed from: h */
    public static final int f26735h = 2;

    /* renamed from: a */
    public final C5966j2 f26736a;

    /* renamed from: b */
    public boolean f26737b;

    /* renamed from: c */
    public ByteBuffer f26738c;

    /* renamed from: d */
    public IOException f26739d;

    public C5914f2(C5966j2 c5966j2) {
        this.f26736a = c5966j2;
    }

    /* renamed from: s */
    private void m34209s() throws IOException {
        if (this.f26737b) {
            IOException iOException = this.f26739d;
            if (iOException != null) {
                throw iOException;
            }
        } else {
            if (m34210t()) {
                return;
            }
            if (this.f26738c == null) {
                this.f26738c = ByteBuffer.allocateDirect(f26733f);
            }
            this.f26738c.clear();
            this.f26736a.m34495a(this.f26738c);
            IOException iOException2 = this.f26739d;
            if (iOException2 != null) {
                throw iOException2;
            }
            ByteBuffer byteBuffer = this.f26738c;
            if (byteBuffer != null) {
                byteBuffer.flip();
            }
        }
    }

    /* renamed from: t */
    private boolean m34210t() {
        ByteBuffer byteBuffer = this.f26738c;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }

    /* renamed from: a */
    public void m34211a(IOException iOException) {
        this.f26739d = iOException;
        this.f26737b = true;
        this.f26738c = null;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26736a.disconnect();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            this.f26736a.setReadStatus(1);
            m34209s();
            if (m34210t()) {
                return this.f26738c.get() & 255;
            }
            return -1;
        } catch (Throwable th2) {
            Logger.m32139e(f26732e, "cronet stream read error:", th2);
            this.f26736a.setReadStatus(2);
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            this.f26736a.setReadStatus(1);
            if (i11 < 0 || i10 < 0 || i10 + i11 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i11 == 0) {
                return 0;
            }
            m34209s();
            if (!m34210t()) {
                return -1;
            }
            int iMin = Math.min(this.f26738c.limit() - this.f26738c.position(), i11);
            this.f26738c.get(bArr, i10, iMin);
            return iMin;
        } catch (Throwable th2) {
            Logger.m32139e(f26732e, "cronet stream read error:", th2);
            this.f26736a.setReadStatus(2);
            throw th2;
        }
    }
}
