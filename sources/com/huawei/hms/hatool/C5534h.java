package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.h */
/* loaded from: classes8.dex */
public class C5534h {

    /* renamed from: a */
    private byte[] f25202a;

    /* renamed from: b */
    private int f25203b = 0;

    public C5534h(int i10) {
        this.f25202a = null;
        this.f25202a = new byte[i10];
    }

    /* renamed from: a */
    public void m32557a(byte[] bArr, int i10) {
        if (i10 <= 0) {
            return;
        }
        byte[] bArr2 = this.f25202a;
        int length = bArr2.length;
        int i11 = this.f25203b;
        if (length - i11 >= i10) {
            System.arraycopy(bArr, 0, bArr2, i11, i10);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i10) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i11);
            System.arraycopy(bArr, 0, bArr3, this.f25203b, i10);
            this.f25202a = bArr3;
        }
        this.f25203b += i10;
    }

    /* renamed from: b */
    public int m32559b() {
        return this.f25203b;
    }

    /* renamed from: a */
    public byte[] m32558a() {
        int i10 = this.f25203b;
        if (i10 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f25202a, 0, bArr, 0, i10);
        return bArr;
    }
}
