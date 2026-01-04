package p005a4;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p631s3.InterfaceC12681d;

/* renamed from: a4.d */
/* loaded from: classes.dex */
public final class C0024d implements InterfaceC12681d {

    /* renamed from: c */
    public static final Collection<Integer> f54c = Arrays.asList(64);

    /* renamed from: d */
    public static final byte[] f55d = new byte[16];

    /* renamed from: e */
    public static final byte[] f56e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* renamed from: a */
    public final C0038r f57a;

    /* renamed from: b */
    public final byte[] f58b;

    public C0024d(byte[] bArr) throws GeneralSecurityException {
        if (f54c.contains(Integer.valueOf(bArr.length))) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.f58b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.f57a = new C0038r(bArrCopyOfRange);
        } else {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
    }

    @Override // p631s3.InterfaceC12681d
    /* renamed from: a */
    public byte[] mo97a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipherM134a = C0033m.f86f.m134a("AES/CTR/NoPadding");
        byte[] bArrM99c = m99c(bArr2, bArr);
        byte[] bArr3 = (byte[]) bArrM99c.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipherM134a.init(1, new SecretKeySpec(this.f58b, "AES"), new IvParameterSpec(bArr3));
        return C0027g.m111a(bArrM99c, cipherM134a.doFinal(bArr));
    }

    @Override // p631s3.InterfaceC12681d
    /* renamed from: b */
    public byte[] mo98b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        Cipher cipherM134a = C0033m.f86f.m134a("AES/CTR/NoPadding");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArr3 = (byte[]) bArrCopyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipherM134a.init(2, new SecretKeySpec(this.f58b, "AES"), new IvParameterSpec(bArr3));
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
        byte[] bArrDoFinal = cipherM134a.doFinal(bArrCopyOfRange2);
        if (bArrCopyOfRange2.length == 0 && bArrDoFinal == null && C0042v.m164b()) {
            bArrDoFinal = new byte[0];
        }
        if (C0027g.m112b(bArrCopyOfRange, m99c(bArr2, bArrDoFinal))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }

    /* renamed from: c */
    public final byte[] m99c(byte[]... bArr) throws GeneralSecurityException {
        if (bArr.length == 0) {
            return this.f57a.mo152a(f56e, 16);
        }
        byte[] bArrMo152a = this.f57a.mo152a(f55d, 16);
        for (int i10 = 0; i10 < bArr.length - 1; i10++) {
            byte[] bArr2 = bArr[i10];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            bArrMo152a = C0027g.m115e(C0025e.m101b(bArrMo152a), this.f57a.mo152a(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        return this.f57a.mo152a(bArr3.length >= 16 ? C0027g.m116f(bArr3, bArrMo152a) : C0027g.m115e(C0025e.m100a(bArr3), C0025e.m101b(bArrMo152a)), 16);
    }
}
