package p005a4;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import p797y3.InterfaceC13908a;

/* renamed from: a4.r */
/* loaded from: classes.dex */
public final class C0038r implements InterfaceC13908a {

    /* renamed from: a */
    public final SecretKey f96a;

    /* renamed from: b */
    public byte[] f97b;

    /* renamed from: c */
    public byte[] f98c;

    public C0038r(byte[] bArr) throws GeneralSecurityException {
        C0043w.m165a(bArr.length);
        this.f96a = new SecretKeySpec(bArr, "AES");
        m153b();
    }

    /* renamed from: c */
    public static Cipher m151c() throws GeneralSecurityException {
        return C0033m.f86f.m134a("AES/ECB/NoPadding");
    }

    @Override // p797y3.InterfaceC13908a
    /* renamed from: a */
    public byte[] mo152a(byte[] bArr, int i10) throws GeneralSecurityException {
        if (i10 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher cipherM151c = m151c();
        cipherM151c.init(1, this.f96a);
        int iMax = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
        byte[] bArrM114d = iMax * 16 == bArr.length ? C0027g.m114d(bArr, (iMax - 1) * 16, this.f97b, 0, 16) : C0027g.m115e(C0025e.m100a(Arrays.copyOfRange(bArr, (iMax - 1) * 16, bArr.length)), this.f98c);
        byte[] bArrDoFinal = new byte[16];
        for (int i11 = 0; i11 < iMax - 1; i11++) {
            bArrDoFinal = cipherM151c.doFinal(C0027g.m114d(bArrDoFinal, 0, bArr, i11 * 16, 16));
        }
        return Arrays.copyOf(cipherM151c.doFinal(C0027g.m115e(bArrM114d, bArrDoFinal)), i10);
    }

    /* renamed from: b */
    public final void m153b() throws GeneralSecurityException {
        Cipher cipherM151c = m151c();
        cipherM151c.init(1, this.f96a);
        byte[] bArrM101b = C0025e.m101b(cipherM151c.doFinal(new byte[16]));
        this.f97b = bArrM101b;
        this.f98c = C0025e.m101b(bArrM101b);
    }
}
