package com.huawei.hms.network.embedded;

import java.util.Arrays;

/* renamed from: com.huawei.hms.network.embedded.ca */
/* loaded from: classes8.dex */
public final class C5881ca {

    /* renamed from: c */
    public static final int f26586c = 65535;

    /* renamed from: d */
    public static final int f26587d = 1;

    /* renamed from: e */
    public static final int f26588e = 2;

    /* renamed from: f */
    public static final int f26589f = 4;

    /* renamed from: g */
    public static final int f26590g = 5;

    /* renamed from: h */
    public static final int f26591h = 6;

    /* renamed from: i */
    public static final int f26592i = 7;

    /* renamed from: j */
    public static final int f26593j = 10;

    /* renamed from: a */
    public int f26594a;

    /* renamed from: b */
    public final int[] f26595b = new int[10];

    /* renamed from: a */
    public int m34073a(int i10) {
        return this.f26595b[i10];
    }

    /* renamed from: b */
    public int m34078b() {
        if ((this.f26594a & 2) != 0) {
            return this.f26595b[1];
        }
        return -1;
    }

    /* renamed from: c */
    public int m34080c() {
        if ((this.f26594a & 128) != 0) {
            return this.f26595b[7];
        }
        return 65535;
    }

    /* renamed from: d */
    public int m34082d() {
        return Integer.bitCount(this.f26594a);
    }

    /* renamed from: e */
    public boolean m34084e(int i10) {
        return (this.f26594a & (1 << i10)) != 0;
    }

    /* renamed from: a */
    public C5881ca m34074a(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f26595b;
            if (i10 < iArr.length) {
                this.f26594a = (1 << i10) | this.f26594a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    /* renamed from: b */
    public int m34079b(int i10) {
        return (this.f26594a & 16) != 0 ? this.f26595b[4] : i10;
    }

    /* renamed from: c */
    public int m34081c(int i10) {
        return (this.f26594a & 32) != 0 ? this.f26595b[5] : i10;
    }

    /* renamed from: d */
    public int m34083d(int i10) {
        return (this.f26594a & 64) != 0 ? this.f26595b[6] : i10;
    }

    /* renamed from: a */
    public void m34075a() {
        this.f26594a = 0;
        Arrays.fill(this.f26595b, 0);
    }

    /* renamed from: a */
    public void m34076a(C5881ca c5881ca) {
        for (int i10 = 0; i10 < 10; i10++) {
            if (c5881ca.m34084e(i10)) {
                m34074a(i10, c5881ca.m34073a(i10));
            }
        }
    }

    /* renamed from: a */
    public boolean m34077a(boolean z10) {
        if ((this.f26594a & 4) != 0) {
            if (this.f26595b[2] == 1) {
                return true;
            }
        } else if (z10) {
            return true;
        }
        return false;
    }
}
