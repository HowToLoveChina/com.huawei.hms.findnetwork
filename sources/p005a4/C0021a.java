package p005a4;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: a4.a */
/* loaded from: classes.dex */
public final class C0021a implements InterfaceC0036p {

    /* renamed from: d */
    public static final ThreadLocal<Cipher> f42d = new a();

    /* renamed from: a */
    public final SecretKeySpec f43a;

    /* renamed from: b */
    public final int f44b;

    /* renamed from: c */
    public final int f45c;

    /* renamed from: a4.a$a */
    public class a extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return C0033m.f86f.m134a("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public C0021a(byte[] bArr, int i10) throws GeneralSecurityException {
        C0043w.m165a(bArr.length);
        this.f43a = new SecretKeySpec(bArr, "AES");
        int blockSize = f42d.get().getBlockSize();
        this.f45c = blockSize;
        if (i10 < 12 || i10 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f44b = i10;
    }

    @Override // p005a4.InterfaceC0036p
    /* renamed from: a */
    public byte[] mo82a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f44b;
        if (length > Integer.MAX_VALUE - i10) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.f44b));
        }
        byte[] bArr2 = new byte[bArr.length + i10];
        byte[] bArrM161c = C0041u.m161c(i10);
        System.arraycopy(bArrM161c, 0, bArr2, 0, this.f44b);
        m84c(bArr, 0, bArr.length, bArr2, this.f44b, bArrM161c, true);
        return bArr2;
    }

    @Override // p005a4.InterfaceC0036p
    /* renamed from: b */
    public byte[] mo83b(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f44b;
        if (length < i10) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        int length2 = bArr.length;
        int i11 = this.f44b;
        byte[] bArr3 = new byte[length2 - i11];
        m84c(bArr, i11, bArr.length - i11, bArr3, 0, bArr2, false);
        return bArr3;
    }

    /* renamed from: c */
    public final void m84c(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, byte[] bArr3, boolean z10) throws GeneralSecurityException {
        Cipher cipher = f42d.get();
        byte[] bArr4 = new byte[this.f45c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f44b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z10) {
            cipher.init(1, this.f43a, ivParameterSpec);
        } else {
            cipher.init(2, this.f43a, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i10, i11, bArr2, i12) != i11) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }
}
