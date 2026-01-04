package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import cv.InterfaceC8954a;
import cv.InterfaceC8955b;
import java.nio.charset.StandardCharsets;
import mv.C11528a;
import p239dw.AbstractC9353u;
import p239dw.C9319a0;
import p239dw.C9320b;
import p267ev.EnumC9566e;
import p267ev.InterfaceC9567f;
import p318gv.C10054a;
import p374iv.C10622a;
import p374iv.C10623b;
import p857zv.C14387a;
import p857zv.C14389c;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class CredentialSignHandler implements InterfaceC9567f {
    private Credential credential;
    private CredentialClient credentialClient;
    private CredentialSignText signText;

    public CredentialSignHandler(Credential credential, CredentialSignText credentialSignText, CredentialClient credentialClient) {
        this.credential = credential;
        this.signText = credentialSignText;
        this.credentialClient = credentialClient;
    }

    private void doSign() throws C14387a {
        C9319a0 c9319a0 = (C9319a0) new C9319a0().m58650k().m67097b("appAuth.sign").m67099d();
        try {
            try {
                this.signText.checkParam(true);
                this.signText.setSignature(new C10054a.b().m62495c(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(AbstractC9353u.m58709a(this.credential))).m62494b(EnumC9566e.HMAC_SHA256).m62493a().getSignHandler().from(this.signText.getDataBytes()).sign());
                c9319a0.m67103h(0);
            } catch (C10623b | C14389c e10) {
                String str = "Fail to sign, errorMessage : " + e10.getMessage();
                c9319a0.m67103h(1003).m67101f(str);
                throw new C14387a(1003L, str);
            } catch (C14391e e11) {
                String str2 = "Fail to sign, errorMessage : " + e11.getMessage();
                c9319a0.m67103h(1001).m67101f(str2);
                throw new C14387a(1001L, str2);
            }
        } finally {
            this.credentialClient.reportLogs(c9319a0);
        }
    }

    private String sign(InterfaceC8955b interfaceC8955b) throws C14387a {
        try {
            doSign();
            return interfaceC8955b.mo56698a(this.signText.getSignature());
        } catch (C10622a e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to encode signature bytes: ");
            sbM58651a.append(e10.getMessage());
            throw new C14387a(1003L, sbM58651a.toString());
        }
    }

    @Override // p267ev.InterfaceC9567f
    public CredentialSignHandler from(String str) throws C14387a {
        if (TextUtils.isEmpty(str)) {
            throw new C14387a(1001L, "dataString cannot empty..");
        }
        return from(str.getBytes(StandardCharsets.UTF_8));
    }

    /* renamed from: fromBase64 */
    public CredentialSignHandler m85669fromBase64(String str) throws C14387a {
        return from(str, InterfaceC8954a.f45454a);
    }

    /* renamed from: fromBase64Url */
    public CredentialSignHandler m85670fromBase64Url(String str) throws C14387a {
        return from(str, InterfaceC8954a.f45455b);
    }

    /* renamed from: fromHex */
    public CredentialSignHandler m85671fromHex(String str) throws C14387a {
        return from(str, InterfaceC8954a.f45456c);
    }

    public String signBase64() throws C14387a {
        return sign(InterfaceC8955b.f45458a);
    }

    public String signBase64Url() throws C14387a {
        return sign(InterfaceC8955b.f45459b);
    }

    public String signHex() throws C14387a {
        return sign(InterfaceC8955b.f45460c);
    }

    private CredentialSignHandler from(String str, InterfaceC8954a interfaceC8954a) throws C14387a {
        try {
            from(interfaceC8954a.mo56697b(str));
            return this;
        } catch (C10622a e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to decode plain text : ");
            sbM58651a.append(e10.getMessage());
            throw new C14387a(1003L, sbM58651a.toString());
        }
    }

    @Override // p267ev.InterfaceC9567f
    public byte[] sign() throws C14387a {
        doSign();
        return this.signText.getSignature();
    }

    @Override // p267ev.InterfaceC9567f
    public CredentialSignHandler from(byte[] bArr) {
        this.signText.setDataBytes(C11528a.m68812a(bArr));
        return this;
    }
}
