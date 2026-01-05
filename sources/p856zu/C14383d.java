package p856zu;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import p238dv.enumKeyStore;
import p374iv.Exception_C10623b;

/* renamed from: zu.d */
/* loaded from: classes9.dex */
public class C14383d implements InterfaceC14382c {

    /* renamed from: a */
    public final Key f63755a;

    /* renamed from: b */
    public final AlgorithmParameterSpec f63756b;

    /* renamed from: c */
    public final C14381b f63757c;

    /* renamed from: d */
    public final enumKeyStore f63758d;

    public C14383d(enumKeyStore enumKeyStore, Key key, C14381b c14381b, AlgorithmParameterSpec algorithmParameterSpec) {
        this.f63758d = enumKeyStore;
        this.f63755a = key;
        this.f63756b = algorithmParameterSpec;
        this.f63757c = c14381b;
    }

    /* renamed from: a */
    public final byte[] m85614a() throws Exception_C10623b, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            String strM85607f = this.f63757c.getAlgorithm().getAlgorithmName();
            enumKeyStore enumKeyStore = this.f63758d;
            Cipher cipher = enumKeyStore == enumKeyStore.ANDROID_KEYSTORE ? Cipher.getInstance(strM85607f) : Cipher.getInstance(strM85607f, enumKeyStore.m58644e());
            cipher.init(2, this.f63755a, this.f63756b);
            return cipher.doFinal(this.f63757c.m85609b());
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            throw new Exception_C10623b("Fail to decrypt: " + e10.getMessage());
        }
    }

    @Override // p856zu.InterfaceC14382c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C14383d from(byte[] bArr) throws Exception_C10623b {
        this.f63757c.setKey(bArr);
        return this;
    }

    @Override // p856zu.InterfaceC14382c
    /* renamed from: to */
    public byte[] mo56620to() throws Exception_C10623b {
        return m85614a();
    }
}
