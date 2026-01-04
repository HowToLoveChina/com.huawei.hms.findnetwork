package com.huawei.hms.drive;

import java.util.Arrays;

/* renamed from: com.huawei.hms.drive.dh */
/* loaded from: classes8.dex */
public final class C5259dh {

    /* renamed from: a */
    private int f24447a;

    /* renamed from: b */
    private final int[] f24448b = new int[10];

    /* renamed from: a */
    public void m31631a() {
        this.f24447a = 0;
        Arrays.fill(this.f24448b, 0);
    }

    /* renamed from: b */
    public int m31635b(int i10) {
        return this.f24448b[i10];
    }

    /* renamed from: c */
    public int m31636c() {
        if ((this.f24447a & 2) != 0) {
            return this.f24448b[1];
        }
        return -1;
    }

    /* renamed from: d */
    public int m31639d(int i10) {
        return (this.f24447a & 32) != 0 ? this.f24448b[5] : i10;
    }

    /* renamed from: b */
    public int m31634b() {
        return Integer.bitCount(this.f24447a);
    }

    /* renamed from: c */
    public int m31637c(int i10) {
        return (this.f24447a & 16) != 0 ? this.f24448b[4] : i10;
    }

    /* renamed from: d */
    public int m31638d() {
        if ((this.f24447a & 128) != 0) {
            return this.f24448b[7];
        }
        return 65535;
    }

    /* renamed from: a */
    public C5259dh m31630a(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f24448b;
            if (i10 < iArr.length) {
                this.f24447a = (1 << i10) | this.f24447a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    /* renamed from: a */
    public boolean m31633a(int i10) {
        return (this.f24447a & (1 << i10)) != 0;
    }

    /* renamed from: a */
    public void m31632a(C5259dh c5259dh) {
        for (int i10 = 0; i10 < 10; i10++) {
            if (c5259dh.m31633a(i10)) {
                m31630a(i10, c5259dh.m31635b(i10));
            }
        }
    }
}
