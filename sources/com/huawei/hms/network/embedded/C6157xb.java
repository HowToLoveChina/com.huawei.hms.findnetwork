package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* renamed from: com.huawei.hms.network.embedded.xb */
/* loaded from: classes8.dex */
public final class C6157xb extends C5910eb {

    /* renamed from: g */
    public final transient byte[][] f29104g;

    /* renamed from: h */
    public final transient int[] f29105h;

    public C6157xb(C5868bb c5868bb, int i10) {
        super(null);
        C5883cc.m34088a(c5868bb.f26524b, 0L, i10);
        C6131vb c6131vb = c5868bb.f26523a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = c6131vb.f28800c;
            int i15 = c6131vb.f28799b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            c6131vb = c6131vb.f28803f;
        }
        this.f29104g = new byte[i13][];
        this.f29105h = new int[i13 * 2];
        C6131vb c6131vb2 = c5868bb.f26523a;
        int i16 = 0;
        while (i11 < i10) {
            byte[][] bArr = this.f29104g;
            bArr[i16] = c6131vb2.f28798a;
            int i17 = c6131vb2.f28800c;
            int i18 = c6131vb2.f28799b;
            i11 += i17 - i18;
            if (i11 > i10) {
                i11 = i10;
            }
            int[] iArr = this.f29105h;
            iArr[i16] = i11;
            iArr[bArr.length + i16] = i18;
            c6131vb2.f28801d = true;
            i16++;
            c6131vb2 = c6131vb2.f28803f;
        }
    }

    /* renamed from: c */
    private int m35813c(int i10) {
        int iBinarySearch = Arrays.binarySearch(this.f29105h, 0, this.f29104g.length, i10 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    /* renamed from: o */
    private C5910eb m35814o() {
        return new C5910eb(mo34195m());
    }

    /* renamed from: p */
    private Object m35815p() {
        return m35814o();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: a */
    public byte mo34159a(int i10) {
        C5883cc.m34088a(this.f29105h[this.f29104g.length - 1], i10, 1L);
        int iM35813c = m35813c(i10);
        int i11 = iM35813c == 0 ? 0 : this.f29105h[iM35813c - 1];
        int[] iArr = this.f29105h;
        byte[][] bArr = this.f29104g;
        return bArr[iM35813c][(i10 - i11) + iArr[bArr.length + iM35813c]];
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: b */
    public int mo34173b(byte[] bArr, int i10) {
        return m35814o().mo34173b(bArr, i10);
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: d */
    public C5910eb mo34180d(C5910eb c5910eb) {
        return m35814o().mo34180d(c5910eb);
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: e */
    public byte[] mo34184e() {
        return mo34195m();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5910eb) {
            C5910eb c5910eb = (C5910eb) obj;
            if (c5910eb.mo34192j() == mo34192j() && mo34168a(0, c5910eb, 0, mo34192j())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: f */
    public C5910eb mo34186f() {
        return m35814o().mo34186f();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: g */
    public C5910eb mo34188g() {
        return m35814o().mo34188g();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: h */
    public C5910eb mo34189h() {
        return m35814o().mo34189h();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    public int hashCode() {
        int i10 = this.f26713b;
        if (i10 != 0) {
            return i10;
        }
        int length = this.f29104g.length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            byte[] bArr = this.f29104g[i11];
            int[] iArr = this.f29105h;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        this.f26713b = i12;
        return i12;
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: j */
    public int mo34192j() {
        return this.f29105h[this.f29104g.length - 1];
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: k */
    public C5910eb mo34193k() {
        return m35814o().mo34193k();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: l */
    public C5910eb mo34194l() {
        return m35814o().mo34194l();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: m */
    public byte[] mo34195m() {
        int[] iArr = this.f29105h;
        byte[][] bArr = this.f29104g;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr2 = this.f29105h;
            int i12 = iArr2[length + i10];
            int i13 = iArr2[i10];
            System.arraycopy(this.f29104g[i10], i12, bArr2, i11, i13 - i11);
            i10++;
            i11 = i13;
        }
        return bArr2;
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: n */
    public String mo34196n() {
        return m35814o().mo34196n();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    public String toString() {
        return m35814o().toString();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: a */
    public int mo34162a(byte[] bArr, int i10) {
        return m35814o().mo34162a(bArr, i10);
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: b */
    public C5910eb mo34174b(int i10) {
        return m35814o().mo34174b(i10);
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: c */
    public C5910eb mo34178c(C5910eb c5910eb) {
        return m35814o().mo34178c(c5910eb);
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: d */
    public String mo34181d() {
        return m35814o().mo34181d();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: a */
    public C5910eb mo34163a(int i10, int i11) {
        return m35814o().mo34163a(i10, i11);
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: b */
    public String mo34175b() {
        return m35814o().mo34175b();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: c */
    public String mo34179c() {
        return m35814o().mo34179c();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: a */
    public String mo34164a(Charset charset) {
        return m35814o().mo34164a(charset);
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: a */
    public ByteBuffer mo34165a() {
        return ByteBuffer.wrap(mo34195m()).asReadOnlyBuffer();
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: a */
    public void mo34166a(C5868bb c5868bb) {
        int length = this.f29104g.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.f29105h;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            C6131vb c6131vb = new C6131vb(this.f29104g[i10], i12, (i12 + i13) - i11, true, false);
            C6131vb c6131vb2 = c5868bb.f26523a;
            if (c6131vb2 == null) {
                c6131vb.f28804g = c6131vb;
                c6131vb.f28803f = c6131vb;
                c5868bb.f26523a = c6131vb;
            } else {
                c6131vb2.f28804g.m35701a(c6131vb);
            }
            i10++;
            i11 = i13;
        }
        c5868bb.f26524b += i11;
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: a */
    public void mo34167a(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.f29104g.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.f29105h;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            outputStream.write(this.f29104g[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: a */
    public boolean mo34168a(int i10, C5910eb c5910eb, int i11, int i12) {
        if (i10 < 0 || i10 > mo34192j() - i12) {
            return false;
        }
        int iM35813c = m35813c(i10);
        while (i12 > 0) {
            int i13 = iM35813c == 0 ? 0 : this.f29105h[iM35813c - 1];
            int iMin = Math.min(i12, ((this.f29105h[iM35813c] - i13) + i13) - i10);
            int[] iArr = this.f29105h;
            byte[][] bArr = this.f29104g;
            if (!c5910eb.mo34169a(i11, bArr[iM35813c], (i10 - i13) + iArr[bArr.length + iM35813c], iMin)) {
                return false;
            }
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            iM35813c++;
        }
        return true;
    }

    @Override // com.huawei.hms.network.embedded.C5910eb
    /* renamed from: a */
    public boolean mo34169a(int i10, byte[] bArr, int i11, int i12) {
        if (i10 < 0 || i10 > mo34192j() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int iM35813c = m35813c(i10);
        while (i12 > 0) {
            int i13 = iM35813c == 0 ? 0 : this.f29105h[iM35813c - 1];
            int iMin = Math.min(i12, ((this.f29105h[iM35813c] - i13) + i13) - i10);
            int[] iArr = this.f29105h;
            byte[][] bArr2 = this.f29104g;
            if (!C5883cc.m34090a(bArr2[iM35813c], (i10 - i13) + iArr[bArr2.length + iM35813c], bArr, i11, iMin)) {
                return false;
            }
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            iM35813c++;
        }
        return true;
    }
}
