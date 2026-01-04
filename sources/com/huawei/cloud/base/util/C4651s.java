package com.huawei.cloud.base.util;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;

/* renamed from: com.huawei.cloud.base.util.s */
/* loaded from: classes.dex */
public class C4651s extends ByteArrayOutputStream {

    /* renamed from: a */
    public final int f21335a;

    /* renamed from: b */
    public final C4650r f21336b;

    /* renamed from: c */
    public int f21337c;

    /* renamed from: d */
    public boolean f21338d;

    public C4651s(C4650r c4650r, int i10) {
        this.f21336b = (C4650r) C4627a0.m28391d(c4650r);
        C4627a0.m28388a(i10 >= 0);
        this.f21335a = i10;
    }

    /* renamed from: b */
    public static void m28493b(StringBuilder sb2, int i10) {
        if (i10 == 1) {
            sb2.append("1 byte");
        } else {
            sb2.append(NumberFormat.getInstance().format(i10));
            sb2.append(" bytes");
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (!this.f21338d) {
                if (this.f21337c != 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Total: ");
                    m28493b(sb2, this.f21337c);
                    int i10 = ((ByteArrayOutputStream) this).count;
                    if (i10 != 0 && i10 < this.f21337c) {
                        sb2.append(" (logging first ");
                        m28493b(sb2, ((ByteArrayOutputStream) this).count);
                        sb2.append(")");
                    }
                    this.f21336b.m28488c(sb2.toString(), true);
                    if (((ByteArrayOutputStream) this).count != 0) {
                        this.f21336b.m28488c(toString(Constants.UTF_8).replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "), true);
                    }
                }
                this.f21338d = true;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i10) {
        C4627a0.m28388a(!this.f21338d);
        this.f21337c++;
        if (((ByteArrayOutputStream) this).count < this.f21335a) {
            super.write(i10);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i10, int i11) {
        C4627a0.m28388a(!this.f21338d);
        this.f21337c += i11;
        int i12 = ((ByteArrayOutputStream) this).count;
        int i13 = this.f21335a;
        if (i12 < i13) {
            int i14 = i12 + i11;
            if (i14 > i13) {
                i11 += i13 - i14;
            }
            super.write(bArr, i10, i11);
        }
    }
}
