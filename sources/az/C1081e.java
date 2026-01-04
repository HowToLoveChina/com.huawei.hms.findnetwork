package az;

import uy.InterfaceC13288b;

/* renamed from: az.e */
/* loaded from: classes9.dex */
public class C1081e implements InterfaceC13288b {

    /* renamed from: a */
    public byte[] f5198a;

    public C1081e(int i10) {
        this.f5198a = new byte[i10];
    }

    /* renamed from: a */
    public byte[] m6455a() {
        return this.f5198a;
    }

    public C1081e(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public C1081e(byte[] bArr, int i10, int i11) {
        this(i11);
        System.arraycopy(bArr, i10, this.f5198a, 0, i11);
    }
}
