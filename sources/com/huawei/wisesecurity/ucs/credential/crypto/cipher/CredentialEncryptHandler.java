package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import cv.InterfaceC8954a;
import cv.InterfaceC8955b;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;
import mv.SafeBytes;
import p021av.C1027a;
import p239dw.KekStore;
import p239dw.CryptoHashMap;
import p239dw.C9320b;
import p374iv.C10622a;
import p374iv.Exception_C10623b;
import p856zu.enumEncryptAlgorithm;
import p856zu.interfaceEnDecryptKey;
import p857zv.Exception_C14387a;
import p857zv.Exception_C14389c;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class CredentialEncryptHandler implements interfaceEnDecryptKey {
    private CredentialCipherText cipherText;
    private Credential credential;
    private CredentialClient credentialClient;

    public CredentialEncryptHandler(Credential credential, CredentialCipherText credentialCipherText, CredentialClient credentialClient) {
        this.credential = credential;
        this.cipherText = credentialCipherText;
        this.credentialClient = credentialClient;
    }

    private void doEncrypt() throws Exception_C14387a {
        CryptoHashMap CryptoHashMap = (CryptoHashMap) new CryptoHashMap().m58650k().putApiName("appAuth.encrypt").putCallTime();
        try {
            try {
                this.cipherText.checkParam(true);
                this.cipherText.setCipherBytes(new C1027a.b().setKey(new SecretKeySpec(SkDkEntity.from(this.credential.getDataKeyBytes()).decryptSkDk(KekStore.getKekParam(this.credential)), "AES")).m6222b(enumEncryptAlgorithm.AES_GCM).m6223c(this.cipherText.getIv()).m6221a().getEncryptHandler().from(this.cipherText.getPlainBytes()).toEnDecryptKeyBytes());
                CryptoHashMap.putStatusCode(0);
            } catch (Exception_C10623b | Exception_C14389c e10) {
                String str = "Fail to encrypt, errorMessage : " + e10.getMessage();
                CryptoHashMap.putStatusCode(1003).putErrorMessageInfo(str);
                throw new Exception_C14387a(1003L, str);
            } catch (C14391e e11) {
                String str2 = "Fail to encrypt, errorMessage : " + e11.getMessage();
                CryptoHashMap.putStatusCode(1001).putErrorMessageInfo(str2);
                throw new Exception_C14387a(1001L, str2);
            }
        } finally {
            this.credentialClient.reportLogs(CryptoHashMap);
        }
    }

    /* renamed from: to */
    private String m56621to(InterfaceC8955b interfaceC8955b) throws Exception_C14387a {
        try {
            doEncrypt();
            return interfaceC8955b.mo56698a(this.cipherText.getCipherBytes());
        } catch (C10622a e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to encode cipher bytes: ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14387a(1003L, sbM58651a.toString());
        }
    }

    /* renamed from: from, reason: merged with bridge method [inline-methods] */
    public CredentialEncryptHandler m85665from(String str) throws Exception_C14387a {
        if (TextUtils.isEmpty(str)) {
            throw new Exception_C14387a(1001L, "plainText cannot empty..");
        }
        return from(str.getBytes(StandardCharsets.UTF_8));
    }

    /* renamed from: fromBase64, reason: merged with bridge method [inline-methods] */
    public CredentialEncryptHandler m85666fromBase64(String str) throws Exception_C14387a {
        return from(str, InterfaceC8954a.f45454a);
    }

    /* renamed from: fromBase64Url, reason: merged with bridge method [inline-methods] */
    public CredentialEncryptHandler m85667fromBase64Url(String str) throws Exception_C14387a {
        return from(str, InterfaceC8954a.f45455b);
    }

    /* renamed from: fromHex, reason: merged with bridge method [inline-methods] */
    public CredentialEncryptHandler m85668fromHex(String str) throws Exception_C14387a {
        return from(str, InterfaceC8954a.f45456c);
    }

    public String toBase64() throws Exception_C14387a {
        return m56621to(InterfaceC8955b.f45458a);
    }

    public String toBase64Url() throws Exception_C14387a {
        return m56621to(InterfaceC8955b.f45459b);
    }

    public String toHex() throws Exception_C14387a {
        return m56621to(InterfaceC8955b.f45460c);
    }

    private CredentialEncryptHandler from(String str, InterfaceC8954a interfaceC8954a) throws Exception_C14387a {
        try {
            from(interfaceC8954a.mo56697b(str));
            return this;
        } catch (C10622a e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to decode plain text : ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14387a(1003L, sbM58651a.toString());
        }
    }

    @Override // p856zu.interfaceEnDecryptKey
    /* renamed from: to */
    public byte[] toEnDecryptKeyBytes() throws Exception_C14387a {
        doEncrypt();
        return this.cipherText.getCipherBytes();
    }

    @Override // p856zu.interfaceEnDecryptKey
    public CredentialEncryptHandler from(byte[] bArr) throws Exception_C14387a {
        if (bArr == null) {
            throw new Exception_C14387a(1001L, "plainBytes cannot null..");
        }
        this.cipherText.setPlainBytes(SafeBytes.doClone(bArr));
        return this;
    }
}
