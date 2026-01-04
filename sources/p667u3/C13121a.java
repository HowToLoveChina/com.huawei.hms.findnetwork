package p667u3;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p005a4.C0033m;
import p005a4.C0041u;
import p005a4.C0042v;
import p005a4.C0043w;
import p631s3.InterfaceC12678a;

/* renamed from: u3.a */
/* loaded from: classes.dex */
public final class C13121a implements InterfaceC12678a {

    /* renamed from: b */
    public static final ThreadLocal<Cipher> f59620b = new a();

    /* renamed from: a */
    public final SecretKey f59621a;

    /* renamed from: u3.a$a */
    public class a extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return C0033m.f86f.m134a("AES/GCM-SIV/NoPadding");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public C13121a(byte[] bArr) throws GeneralSecurityException {
        C0043w.m165a(bArr.length);
        this.f59621a = new SecretKeySpec(bArr, "AES");
    }

    /* renamed from: c */
    public static AlgorithmParameterSpec m78917c(byte[] bArr) throws GeneralSecurityException {
        return m78918d(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public static AlgorithmParameterSpec m78918d(byte[] bArr, int i10, int i11) throws GeneralSecurityException, ClassNotFoundException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, i10, i11);
        } catch (ClassNotFoundException unused) {
            if (C0042v.m164b()) {
                return new IvParameterSpec(bArr, i10, i11);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
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
        AlgorithmParameterSpec algorithmParameterSpecM78917c = m78917c(bArrM161c);
        ThreadLocal<Cipher> threadLocal = f59620b;
        threadLocal.get().init(1, this.f59621a, algorithmParameterSpecM78917c);
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
    public byte[] mo89b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException, ClassNotFoundException {
        if (bArr.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecM78918d = m78918d(bArr, 0, 12);
        ThreadLocal<Cipher> threadLocal = f59620b;
        threadLocal.get().init(2, this.f59621a, algorithmParameterSpecM78918d);
        if (bArr2 != null && bArr2.length != 0) {
            threadLocal.get().updateAAD(bArr2);
        }
        return threadLocal.get().doFinal(bArr, 12, bArr.length - 12);
    }
}
