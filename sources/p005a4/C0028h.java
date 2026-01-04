package p005a4;

import java.security.InvalidKeyException;

/* renamed from: a4.h */
/* loaded from: classes.dex */
public class C0028h extends AbstractC0029i {
    public C0028h(byte[] bArr, int i10) throws InvalidKeyException {
        super(bArr, i10);
    }

    @Override // p005a4.AbstractC0029i
    /* renamed from: d */
    public int[] mo117d(int[] iArr, int i10) {
        if (iArr.length != mo118g() / 4) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
        }
        int[] iArr2 = new int[16];
        AbstractC0029i.m121k(iArr2, this.f77a);
        iArr2[12] = i10;
        System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
        return iArr2;
    }

    @Override // p005a4.AbstractC0029i
    /* renamed from: g */
    public int mo118g() {
        return 12;
    }
}
