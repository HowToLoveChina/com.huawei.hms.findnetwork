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
import mv.SafeBytes;
import p238dv.enumKeyStore;
import p374iv.Exception_C10623b;

/* renamed from: zu.e */
/* loaded from: classes9.dex */
public class EnDecryptAlgorithm implements interfaceEnDecryptKey {

    /* renamed from: a */
    public final Key m_key;

    /* renamed from: b */
    public final AlgorithmParameterSpec m_parameterspec;

    /* renamed from: c */
    public final C14381b f63761c;

    /* renamed from: d */
    public final enumKeyStore m_keystore;

    public EnDecryptAlgorithm(enumKeyStore enumKeyStore, Key key, C14381b c14381b, AlgorithmParameterSpec algorithmParameterSpec) {
        this.m_keystore = enumKeyStore;
        this.m_key = key;
        this.m_parameterspec = algorithmParameterSpec;
        this.f63761c = c14381b;
    }

    /* renamed from: a */
    public final void doEncrypt() throws Exception_C10623b, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            String strM85607f = this.f63761c.getAlgorithm().getAlgorithmName();
            enumKeyStore enumKeyStore = this.m_keystore;
            Cipher cipher = enumKeyStore == enumKeyStore.ANDROID_KEYSTORE ? Cipher.getInstance(strM85607f) : Cipher.getInstance(strM85607f, enumKeyStore.m58644e());
            cipher.init(1, this.m_key, this.m_parameterspec);
            C14381b c14381b = this.f63761c;
            c14381b.setKey(cipher.doFinal(c14381b.m85610c()));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            throw new Exception_C10623b("Fail to encrypt: " + e10.getMessage());
        }
    }

    @Override // p856zu.interfaceEnDecryptKey
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EnDecryptAlgorithm from(byte[] bArr) throws Exception_C10623b {
        this.f63761c.m85613f(SafeBytes.doClone(bArr));
        return this;
    }

    @Override // p856zu.interfaceEnDecryptKey
    /* renamed from: to */
    public byte[] toEnDecryptKeyBytes() throws Exception_C10623b, InvalidKeyException, InvalidAlgorithmParameterException {
        doEncrypt();
        return this.f63761c.m85609b();
    }
}
