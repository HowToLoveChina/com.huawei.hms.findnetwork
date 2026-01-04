package lk;

import fk.C9721b;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p399jk.AbstractC10896a;
import p525ok.C11908a;

/* renamed from: lk.a */
/* loaded from: classes6.dex */
public class C11304a {

    /* renamed from: a */
    public final byte[] f52958a;

    public C11304a(byte[] bArr) {
        this.f52958a = bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    /* renamed from: a */
    public byte[] m67863a(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    /* renamed from: b */
    public byte[] m67864b(byte[] bArr) throws NoSuchPaddingException, C9721b, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            byte[] bArrM67866d = m67866d(bArr, 0, 12);
            byte[] bArrM67866d2 = m67866d(bArr, 12, bArr.length);
            AbstractC10896a.m65885d("AESGCMCryptor", "decrypt:SDK_INT more than 28");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, new SecretKeySpec(this.f52958a, "AES"), new IvParameterSpec(bArrM67866d));
            return cipher.doFinal(bArrM67866d2);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            throw new C9721b(4005, "Fail to decrypt with AES GCM " + e10.getMessage(), "AESGCMCryptor decrypt");
        }
    }

    /* renamed from: c */
    public byte[] m67865c(byte[] bArr) throws NoSuchPaddingException, C9721b, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            AbstractC10896a.m65885d("AESGCMCryptor", "encrypt:SDK_INT more than 28");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            byte[] bArrM71443b = C11908a.m71443b(12);
            cipher.init(1, new SecretKeySpec(this.f52958a, "AES"), new IvParameterSpec(bArrM71443b));
            return m67863a(bArrM71443b, cipher.doFinal(bArr));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            throw new C9721b(4004, "Fail to encrypt with AES GCM " + e10.getMessage(), "AESGCMCryptor Encrypt");
        }
    }

    /* renamed from: d */
    public byte[] m67866d(byte[] bArr, int i10, int i11) {
        int i12 = i11 - i10;
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10, bArr2, 0, i12);
        return bArr2;
    }
}
