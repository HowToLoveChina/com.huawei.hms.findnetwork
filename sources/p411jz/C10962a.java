package p411jz;

import java.io.DataInputStream;
import java.io.IOException;
import p351hz.C10364c;
import p351hz.C10366e;

/* renamed from: jz.a */
/* loaded from: classes9.dex */
public final class C10962a {

    /* renamed from: a */
    public final byte[] f51933a;

    /* renamed from: b */
    public final int f51934b;

    /* renamed from: c */
    public int f51935c;

    /* renamed from: d */
    public int f51936d;

    /* renamed from: e */
    public int f51937e;

    /* renamed from: f */
    public int f51938f = 0;

    /* renamed from: g */
    public int f51939g = 0;

    /* renamed from: h */
    public int f51940h = 0;

    public C10962a(int i10, byte[] bArr, C10364c c10364c) {
        this.f51935c = 0;
        this.f51936d = 0;
        this.f51937e = 0;
        this.f51934b = i10;
        byte[] bArrM63795a = c10364c.m63795a(i10, false);
        this.f51933a = bArrM63795a;
        if (bArr != null) {
            int iMin = Math.min(bArr.length, i10);
            this.f51936d = iMin;
            this.f51937e = iMin;
            this.f51935c = iMin;
            System.arraycopy(bArr, bArr.length - iMin, bArrM63795a, 0, iMin);
        }
    }

    /* renamed from: a */
    public void m66159a(DataInputStream dataInputStream, int i10) throws IOException {
        int iMin = Math.min(this.f51934b - this.f51936d, i10);
        dataInputStream.readFully(this.f51933a, this.f51936d, iMin);
        int i11 = this.f51936d + iMin;
        this.f51936d = i11;
        if (this.f51937e < i11) {
            this.f51937e = i11;
        }
    }

    /* renamed from: b */
    public int m66160b(byte[] bArr, int i10) {
        int i11 = this.f51936d;
        int i12 = this.f51935c;
        int i13 = i11 - i12;
        if (i11 == this.f51934b) {
            this.f51936d = 0;
        }
        System.arraycopy(this.f51933a, i12, bArr, i10, i13);
        this.f51935c = this.f51936d;
        return i13;
    }

    /* renamed from: c */
    public int m66161c(int i10) {
        int i11 = this.f51936d;
        int i12 = (i11 - i10) - 1;
        if (i10 >= i11) {
            i12 += this.f51934b;
        }
        return this.f51933a[i12] & 255;
    }

    /* renamed from: d */
    public int m66162d() {
        return this.f51936d;
    }

    /* renamed from: e */
    public boolean m66163e() {
        return this.f51939g > 0;
    }

    /* renamed from: f */
    public boolean m66164f() {
        return this.f51936d < this.f51938f;
    }

    /* renamed from: g */
    public void m66165g(C10364c c10364c) {
        c10364c.m63796c(this.f51933a);
    }

    /* renamed from: h */
    public void m66166h(byte b10) {
        byte[] bArr = this.f51933a;
        int i10 = this.f51936d;
        int i11 = i10 + 1;
        this.f51936d = i11;
        bArr[i10] = b10;
        if (this.f51937e < i11) {
            this.f51937e = i11;
        }
    }

    /* renamed from: i */
    public void m66167i(int i10, int i11) throws IOException {
        int i12;
        if (i10 < 0 || i10 >= this.f51937e) {
            throw new C10366e();
        }
        int iMin = Math.min(this.f51938f - this.f51936d, i11);
        this.f51939g = i11 - iMin;
        this.f51940h = i10;
        int i13 = (this.f51936d - i10) - 1;
        if (i13 < 0) {
            int i14 = this.f51934b;
            int i15 = i13 + i14;
            int iMin2 = Math.min(i14 - i15, iMin);
            byte[] bArr = this.f51933a;
            System.arraycopy(bArr, i15, bArr, this.f51936d, iMin2);
            this.f51936d += iMin2;
            iMin -= iMin2;
            if (iMin == 0) {
                return;
            } else {
                i13 = 0;
            }
        }
        do {
            int iMin3 = Math.min(iMin, this.f51936d - i13);
            byte[] bArr2 = this.f51933a;
            System.arraycopy(bArr2, i13, bArr2, this.f51936d, iMin3);
            i12 = this.f51936d + iMin3;
            this.f51936d = i12;
            iMin -= iMin3;
        } while (iMin > 0);
        if (this.f51937e < i12) {
            this.f51937e = i12;
        }
    }

    /* renamed from: j */
    public void m66168j() throws IOException {
        int i10 = this.f51939g;
        if (i10 > 0) {
            m66167i(this.f51940h, i10);
        }
    }

    /* renamed from: k */
    public void m66169k() {
        this.f51935c = 0;
        this.f51936d = 0;
        this.f51937e = 0;
        this.f51938f = 0;
        this.f51933a[this.f51934b - 1] = 0;
    }

    /* renamed from: l */
    public void m66170l(int i10) {
        int i11 = this.f51934b;
        int i12 = this.f51936d;
        if (i11 - i12 <= i10) {
            this.f51938f = i11;
        } else {
            this.f51938f = i12 + i10;
        }
    }
}
