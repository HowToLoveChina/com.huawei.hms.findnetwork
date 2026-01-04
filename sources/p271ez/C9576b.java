package p271ez;

/* renamed from: ez.b */
/* loaded from: classes9.dex */
public class C9576b {
    /* renamed from: a */
    public static void m59766a(int i10, byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, int i13) {
        for (int i14 = 0; i14 < i10; i14++) {
            bArr3[i13 + i14] = (byte) (bArr[i11 + i14] ^ bArr2[i12 + i14]);
        }
    }

    /* renamed from: b */
    public static void m59767b(int i10, byte[] bArr, byte[] bArr2) {
        for (int i11 = 0; i11 < i10; i11++) {
            bArr2[i11] = (byte) (bArr2[i11] ^ bArr[i11]);
        }
    }
}
