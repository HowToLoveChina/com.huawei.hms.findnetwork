package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import cv.InterfaceC8954a;
import java.nio.charset.StandardCharsets;
import p239dw.AbstractC9353u;
import p239dw.C9319a0;
import p239dw.C9320b;
import p267ev.EnumC9566e;
import p267ev.InterfaceC9569h;
import p318gv.C10054a;
import p374iv.C10622a;
import p374iv.C10623b;
import p857zv.C14387a;
import p857zv.C14389c;
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

    private boolean doVerify() throws C14387a {
        C9319a0 c9319a0 = (C9319a0) new C9319a0().m58650k().m67097b("appAuth.verify").m67099d();
        try {
            try {
                this.signText.checkParam(false);
                boolean zCheckSignature = checkSignature(new C10054a.b().m62495c(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(AbstractC9353u.m58709a(this.credential))).m62494b(EnumC9566e.HMAC_SHA256).m62493a().getSignHandler().from(this.signText.getDataBytes()).sign(), this.signText.getSignature());
                c9319a0.m67103h(0);
                return zCheckSignature;
            } catch (C10623b | C14389c e10) {
                String str = "Fail to verify, errorMessage : " + e10.getMessage();
                c9319a0.m67103h(1003).m67101f(str);
                throw new C14387a(1003L, str);
            } catch (C14391e e11) {
                String str2 = "Fail to verify, errorMessage : " + e11.getMessage();
                c9319a0.m67103h(1001).m67101f(str2);
                throw new C14387a(1001L, str2);
            }
        } finally {
            this.credentialClient.reportLogs(c9319a0);
        }
    }

    /* renamed from: fromBase64Data, reason: merged with bridge method [inline-methods] */
    public CredentialVerifyHandler m85672fromBase64Data(String str) throws C14387a {
        return fromData(str, InterfaceC8954a.f45454a);
    }

    /* renamed from: fromBase64UrlData, reason: merged with bridge method [inline-methods] */
    public CredentialVerifyHandler m85673fromBase64UrlData(String str) throws C14387a {
        return fromData(str, InterfaceC8954a.f45455b);
    }

    /* renamed from: fromData, reason: merged with bridge method [inline-methods] */
    public CredentialVerifyHandler m85674fromData(String str) throws C14387a {
        if (TextUtils.isEmpty(str)) {
            throw new C14387a(1001L, "dataString cannot empty..");
        }
        return fromData(str.getBytes(StandardCharsets.UTF_8));
    }

    /* renamed from: fromHexData, reason: merged with bridge method [inline-methods] */
    public CredentialVerifyHandler m85675fromHexData(String str) throws C14387a {
        return fromData(str, InterfaceC8954a.f45456c);
    }

    public boolean verify(String str) throws C14387a {
        if (TextUtils.isEmpty(str)) {
            throw new C14387a(1001L, "signature cannot empty..");
        }
        return verify(str.getBytes(StandardCharsets.UTF_8));
    }

    public boolean verifyBase64(String str) throws C14387a {
        return verify(str, InterfaceC8954a.f45454a);
    }

    public boolean verifyBase64Url(String str) throws C14387a {
        return verify(str, InterfaceC8954a.f45455b);
    }

    public boolean verifyHex(String str) throws C14387a {
        return verify(str, InterfaceC8954a.f45456c);
    }

    private CredentialVerifyHandler fromData(String str, InterfaceC8954a interfaceC8954a) throws C14387a {
        try {
            fromData(interfaceC8954a.mo56697b(str));
            return this;
        } catch (C10622a e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to decode sign data: ");
            sbM58651a.append(e10.getMessage());
            throw new C14387a(1003L, sbM58651a.toString());
        }
    }

    private boolean verify(String str, InterfaceC8954a interfaceC8954a) throws C14387a {
        try {
            return verify(interfaceC8954a.mo56697b(str));
        } catch (C10622a e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to decode signature : ");
            sbM58651a.append(e10.getMessage());
            throw new C14387a(1003L, sbM58651a.toString());
        }
    }

    @Override // p267ev.InterfaceC9569h
    public CredentialVerifyHandler fromData(byte[] bArr) {
        this.signText.setDataBytes(bArr);
        return this;
    }

    @Override // p267ev.InterfaceC9569h
    public boolean verify(byte[] bArr) throws C14387a {
        this.signText.setSignature(bArr);
        return doVerify();
    }
}
