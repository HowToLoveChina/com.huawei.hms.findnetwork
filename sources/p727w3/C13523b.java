package p727w3;

import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.ProviderException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import p631s3.InterfaceC12678a;

/* renamed from: w3.b */
/* loaded from: classes.dex */
public final class C13523b implements InterfaceC12678a {

    /* renamed from: b */
    public static final String f60879b = "b";

    /* renamed from: a */
    public final SecretKey f60880a;

    public C13523b(String str, KeyStore keyStore) throws GeneralSecurityException {
        SecretKey secretKey = (SecretKey) keyStore.getKey(str, null);
        this.f60880a = secretKey;
        if (secretKey != null) {
            return;
        }
        throw new InvalidKeyException("Keystore cannot load the key with ID: " + str);
    }

    /* renamed from: e */
    public static void m81390e() throws InterruptedException {
        try {
            Thread.sleep((int) (Math.random() * 100.0d));
        } catch (InterruptedException unused) {
        }
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: a */
    public byte[] mo88a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException, InterruptedException {
        try {
            return m81392d(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException e10) {
            Log.w(f60879b, "encountered a potentially transient KeyStore error, will wait and retry", e10);
            m81390e();
            return this.m81392d(bArr, bArr2);
        }
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: b */
    public byte[] mo89b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException, InterruptedException {
        try {
            return m81391c(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException e10) {
            Log.w(f60879b, "encountered a potentially transient KeyStore error, will wait and retry", e10);
            m81390e();
            return this.m81391c(bArr, bArr2);
        }
    }

    /* renamed from: c */
    public final byte[] m81391c(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, this.f60880a, gCMParameterSpec);
        cipher.updateAAD(bArr2);
        return cipher.doFinal(bArr, 12, bArr.length - 12);
    }

    /* renamed from: d */
    public final byte[] m81392d(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 28];
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, this.f60880a);
        cipher.updateAAD(bArr2);
        cipher.doFinal(bArr, 0, bArr.length, bArr3, 12);
        System.arraycopy(cipher.getIV(), 0, bArr3, 0, 12);
        return bArr3;
    }
}
