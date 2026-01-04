package com.huawei.hms.network.embedded;

import com.huawei.hms.network.httpclient.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.huawei.hms.network.embedded.q1 */
/* loaded from: classes8.dex */
public class C6056q1 extends InputStream {

    /* renamed from: h */
    public static final String f27819h = "CacheInputStream";

    /* renamed from: a */
    public final InputStream f27820a;

    /* renamed from: b */
    public final InterfaceC6030o1 f27821b;

    /* renamed from: f */
    public int f27825f;

    /* renamed from: c */
    public byte[] f27822c = new byte[8192];

    /* renamed from: d */
    public int f27823d = 0;

    /* renamed from: e */
    public int f27824e = 0;

    /* renamed from: g */
    public int f27826g = 0;

    public C6056q1(ResponseBody responseBody, InterfaceC6030o1 interfaceC6030o1) {
        if (responseBody == null || responseBody.getInputStream() == null) {
            throw new IllegalArgumentException("ResponseBody delegrate == null");
        }
        this.f27820a = responseBody.getInputStream();
        this.f27821b = interfaceC6030o1;
    }

    private void write(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        try {
            this.f27821b.write(bArr);
        } catch (IOException e10) {
            this.f27821b.abort();
            throw e10;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27820a.close();
        InterfaceC6030o1 interfaceC6030o1 = this.f27821b;
        if (interfaceC6030o1 != null) {
            interfaceC6030o1.close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.f27821b == null) {
            return this.f27820a.read(bArr, 0, bArr.length);
        }
        int i10 = this.f27820a.read(bArr, 0, bArr.length);
        this.f27825f = i10;
        if (i10 == -1) {
            int i11 = this.f27823d;
            if (i11 > 0) {
                write(C6160y1.encryptBody(Arrays.copyOfRange(this.f27822c, 0, i11)));
                this.f27823d = 0;
            }
            return this.f27825f;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i10);
        int i12 = this.f27826g + this.f27825f;
        this.f27826g = i12;
        if (i12 > 16777216) {
            this.f27821b.abort();
            this.f27826g = 0;
        }
        int i13 = this.f27823d;
        int i14 = 8192 - i13;
        this.f27824e = i14;
        int i15 = this.f27825f;
        if (i15 < i14) {
            System.arraycopy(bArrCopyOfRange, 0, this.f27822c, i13, i15);
            this.f27823d += this.f27825f;
        } else {
            System.arraycopy(bArrCopyOfRange, 0, this.f27822c, i13, i14);
            write(C6160y1.encryptBody(this.f27822c));
            int i16 = this.f27825f;
            int i17 = this.f27824e;
            int i18 = i16 - i17;
            System.arraycopy(bArrCopyOfRange, i17, this.f27822c, 0, i18);
            this.f27823d = i18;
        }
        return this.f27825f;
    }
}
