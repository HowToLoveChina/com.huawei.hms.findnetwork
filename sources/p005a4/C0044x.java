package p005a4;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* renamed from: a4.x */
/* loaded from: classes.dex */
public class C0044x extends AbstractC0029i {
    public C0044x(byte[] bArr, int i10) throws InvalidKeyException {
        super(bArr, i10);
    }

    /* renamed from: n */
    public static int[] m168n(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        AbstractC0029i.m121k(iArr3, iArr);
        iArr3[12] = iArr2[0];
        iArr3[13] = iArr2[1];
        iArr3[14] = iArr2[2];
        iArr3[15] = iArr2[3];
        AbstractC0029i.m122l(iArr3);
        iArr3[4] = iArr3[12];
        iArr3[5] = iArr3[13];
        iArr3[6] = iArr3[14];
        iArr3[7] = iArr3[15];
        return Arrays.copyOf(iArr3, 8);
    }

    @Override // p005a4.AbstractC0029i
    /* renamed from: d */
    public int[] mo117d(int[] iArr, int i10) {
        if (iArr.length != mo118g() / 4) {
            throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
        }
        int[] iArr2 = new int[16];
        AbstractC0029i.m121k(iArr2, m168n(this.f77a, iArr));
        iArr2[12] = i10;
        iArr2[13] = 0;
        iArr2[14] = iArr[4];
        iArr2[15] = iArr[5];
        return iArr2;
    }

    @Override // p005a4.AbstractC0029i
    /* renamed from: g */
    public int mo118g() {
        return 24;
    }
}
