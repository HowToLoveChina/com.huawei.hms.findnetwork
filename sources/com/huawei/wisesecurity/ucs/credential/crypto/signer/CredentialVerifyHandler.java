package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import cv.InterfaceC8954a;
import java.nio.charset.StandardCharsets;
import p239dw.KekStore;
import p239dw.CryptoHashMap;
import p239dw.C9320b;
import p267ev.EnumC9566e;
import p267ev.InterfaceC9569h;
import p318gv.C10054a;
import p374iv.C10622a;
import p374iv.Exception_C10623b;
import p857zv.Exception_C14387a;
import p857zv.Exception_C14389c;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class CredentialVerifyHandler implements InterfaceC9569h {
    private Credential credential;
    private CredentialClient credentialClient;
    private CredentialSignText signText;

    public CredentialVerifyHandler(Credential credential, CredentialSignText credentialSignText, CredentialClient credentialClient) {
        this.credential = credential;
        this.signText = credentialSignText;
        this.credentialClient = credentialClient;
    }

    private boolean checkSignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    private boolean doVerify() throws Exception_C14387a {
        CryptoHashMap CryptoHashMap = (CryptoHashMap) new CryptoHashMap().m58650k().putApiName("appAuth.verify").putCallTime();
        try {
            try {
                this.signText.checkParam(false);
                boolean zCheckSignature = checkSignature(new C10054a.b().m62495c(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(KekStore.getKekParam(this.credential))).m62494b(EnumC9566e.HMAC_SHA256).m62493a().getSignHandler().from(this.signText.getDataBytes()).sign(), this.signText.getSignature());
                CryptoHashMap.putStatusCode(0);
                return zCheckSignature;
            } catch (Exception_C10623b | Exception_C14389c e10) {
                String str = "Fail to verify, errorMessage : " + e10.getMessage();
                CryptoHashMap.putStatusCode(1003).putErrorMessageInfo(str);
                throw new Exception_C14387a(1003L, str);
            } catch (C14391e e11) {
                String str2 = "Fail to verify, errorMessage : " + e11.getMessage();
                CryptoHashMap.putStatusCode(1001).putErrorMessageInfo(str2);
                throw new Exception_C14387a(1001L, str2);
            }
        } finally {
            this.credentialClient.reportLogs(CryptoHashMap);
        }
    }

    /* renamed from: fromBase64Data, reason: merged with bridge method [inline-methods] */
    public CredentialVerifyHandler m85672fromBase64Data(String str) throws Exception_C14387a {
        return fromData(str, InterfaceC8954a.f45454a);
    }

    /* renamed from: fromBase64UrlData, reason: merged with bridge method [inline-methods] */
    public CredentialVerifyHandler m85673fromBase64UrlData(String str) throws Exception_C14387a {
        return fromData(str, InterfaceC8954a.f45455b);
    }

    /* renamed from: fromData, reason: merged with bridge method [inline-methods] */
    public CredentialVerifyHandler m85674fromData(String str) throws Exception_C14387a {
        if (TextUtils.isEmpty(str)) {
            throw new Exception_C14387a(1001L, "dataString cannot empty..");
        }
        return fromData(str.getBytes(StandardCharsets.UTF_8));
    }

    /* renamed from: fromHexData, reason: merged with bridge method [inline-methods] */
    public CredentialVerifyHandler m85675fromHexData(String str) throws Exception_C14387a {
        return fromData(str, InterfaceC8954a.f45456c);
    }

    public boolean verify(String str) throws Exception_C14387a {
        if (TextUtils.isEmpty(str)) {
            throw new Exception_C14387a(1001L, "signature cannot empty..");
        }
        return verify(str.getBytes(StandardCharsets.UTF_8));
    }

    public boolean verifyBase64(String str) throws Exception_C14387a {
        return verify(str, InterfaceC8954a.f45454a);
    }

    public boolean verifyBase64Url(String str) throws Exception_C14387a {
        return verify(str, InterfaceC8954a.f45455b);
    }

    public boolean verifyHex(String str) throws Exception_C14387a {
        return verify(str, InterfaceC8954a.f45456c);
    }

    private CredentialVerifyHandler fromData(String str, InterfaceC8954a interfaceC8954a) throws Exception_C14387a {
        try {
            fromData(interfaceC8954a.mo56697b(str));
            return this;
        } catch (C10622a e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to decode sign data: ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14387a(1003L, sbM58651a.toString());
        }
    }

    private boolean verify(String str, InterfaceC8954a interfaceC8954a) throws Exception_C14387a {
        try {
            return verify(interfaceC8954a.mo56697b(str));
        } catch (C10622a e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to decode signature : ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14387a(1003L, sbM58651a.toString());
        }
    }

    @Override // p267ev.InterfaceC9569h
    public CredentialVerifyHandler fromData(byte[] bArr) {
        this.signText.setDataBytes(bArr);
        return this;
    }

    @Override // p267ev.InterfaceC9569h
    public boolean verify(byte[] bArr) throws Exception_C14387a {
        this.signText.setSignature(bArr);
        return doVerify();
    }
}
