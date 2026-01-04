package p005a4;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p631s3.InterfaceC12678a;

/* renamed from: a4.c */
/* loaded from: classes.dex */
public final class C0023c implements InterfaceC12678a {

    /* renamed from: b */
    public static final ThreadLocal<Cipher> f52b = new a();

    /* renamed from: a */
    public final SecretKey f53a;

    /* renamed from: a4.c$a */
    public class a extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return C0033m.f86f.m134a("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public C0023c(byte[] bArr) throws GeneralSecurityException {
        C0043w.m165a(bArr.length);
        this.f53a = new SecretKeySpec(bArr, "AES");
    }

    /* renamed from: c */
    private static AlgorithmParameterSpec m94c(byte[] bArr) throws GeneralSecurityException {
        return m95d(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    private static AlgorithmParameterSpec m95d(byte[] bArr, int i10, int i11) throws GeneralSecurityException {
        return (!C0042v.m164b() || C0042v.m163a() > 19) ? new GCMParameterSpec(128, bArr, i10, i11) : new IvParameterSpec(bArr, i10, i11);
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: a */
    public byte[] mo88a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 28];
        byte[] bArrM161c = C0041u.m161c(12);
        System.arraycopy(bArrM161c, 0, bArr3, 0, 12);
        AlgorithmParameterSpec algorithmParameterSpecM94c = m94c(bArrM161c);
        ThreadLocal<Cipher> threadLocal = f52b;
        threadLocal.get().init(1, this.f53a, algorithmParameterSpecM94c);
        if (bArr2 != null && bArr2.length != 0) {
            threadLocal.get().updateAAD(bArr2);
        }
        int iDoFinal = threadLocal.get().doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (iDoFinal == bArr.length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(iDoFinal - bArr.length)));
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: b */
    public byte[] mo89b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecM95d = m95d(bArr, 0, 12);
        ThreadLocal<Cipher> threadLocal = f52b;
        threadLocal.get().init(2, this.f53a, algorithmParameterSpecM95d);
        if (bArr2 != null && bArr2.length != 0) {
            threadLocal.get().updateAAD(bArr2);
        }
        return threadLocal.get().doFinal(bArr, 12, bArr.length - 12);
    }
}
