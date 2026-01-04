package bz;

/* renamed from: bz.e */
/* loaded from: classes9.dex */
public class C1362e {
    /* renamed from: a */
    public static byte[] m7861a(InterfaceC1360c interfaceC1360c, int i10) {
        byte[] bArr = new byte[i10];
        if (i10 * 8 <= interfaceC1360c.mo7858b()) {
            System.arraycopy(interfaceC1360c.mo7857a(), 0, bArr, 0, i10);
        } else {
            int iMo7858b = interfaceC1360c.mo7858b() / 8;
            for (int i11 = 0; i11 < i10; i11 += iMo7858b) {
                byte[] bArrMo7857a = interfaceC1360c.mo7857a();
                int i12 = i10 - i11;
                if (bArrMo7857a.length <= i12) {
                    System.arraycopy(bArrMo7857a, 0, bArr, i11, bArrMo7857a.length);
                } else {
                    System.arraycopy(bArrMo7857a, 0, bArr, i11, i12);
                }
            }
        }
        return bArr;
    }
}
