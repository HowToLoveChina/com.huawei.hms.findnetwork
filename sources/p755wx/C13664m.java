package p755wx;

import java.util.Arrays;

/* renamed from: wx.m */
/* loaded from: classes9.dex */
public final class C13664m {

    /* renamed from: a */
    public int f61539a;

    /* renamed from: b */
    public final int[] f61540b = new int[10];

    /* renamed from: a */
    public void m82189a() {
        this.f61539a = 0;
        Arrays.fill(this.f61540b, 0);
    }

    /* renamed from: b */
    public int m82190b(int i10) {
        return this.f61540b[i10];
    }

    /* renamed from: c */
    public int m82191c() {
        if ((this.f61539a & 2) != 0) {
            return this.f61540b[1];
        }
        return -1;
    }

    /* renamed from: d */
    public int m82192d() {
        if ((this.f61539a & 128) != 0) {
            return this.f61540b[7];
        }
        return 65535;
    }

    /* renamed from: e */
    public int m82193e(int i10) {
        return (this.f61539a & 16) != 0 ? this.f61540b[4] : i10;
    }

    /* renamed from: f */
    public int m82194f(int i10) {
        return (this.f61539a & 32) != 0 ? this.f61540b[5] : i10;
    }

    /* renamed from: g */
    public boolean m82195g(int i10) {
        return (this.f61539a & (1 << i10)) != 0;
    }

    /* renamed from: h */
    public void m82196h(C13664m c13664m) {
        for (int i10 = 0; i10 < 10; i10++) {
            if (c13664m.m82195g(i10)) {
                m82197i(i10, c13664m.m82190b(i10));
            }
        }
    }

    /* renamed from: i */
    public C13664m m82197i(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f61540b;
            if (i10 < iArr.length) {
                this.f61539a = (1 << i10) | this.f61539a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    /* renamed from: j */
    public int m82198j() {
        return Integer.bitCount(this.f61539a);
    }
}
