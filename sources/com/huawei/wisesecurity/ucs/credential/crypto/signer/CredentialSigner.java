package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import p239dw.C9320b;
import p267ev.InterfaceC9565d;
import p374iv.C10626e;
import p500nv.C11756a;
import p535ov.InterfaceC12042i;
import p857zv.Exception_C14389c;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class CredentialSigner implements InterfaceC9565d {
    private Credential credential;
    private CredentialClient credentialClient;
    private CredentialSignText signText;

    public static class Builder {

        @InterfaceC12042i
        private Credential credential;

        @InterfaceC12042i
        private CredentialClient credentialClient;

        @InterfaceC12042i
        private CredentialSignAlg signAlg = CredentialSignAlg.HMAC_SHA256;

        public CredentialSigner build() throws Exception_C14389c {
            try {
                C11756a.m70079b(this);
                return new CredentialSigner(this.signAlg, this.credential, this.credentialClient);
            } catch (C10626e e10) {
                StringBuilder sbM58651a = C9320b.m58651a("CredentialCipher check param error : ");
                sbM58651a.append(e10.getMessage());
                throw new C14391e(sbM58651a.toString());
            }
        }

        public Builder withAlg(CredentialSignAlg credentialSignAlg) {
            this.signAlg = credentialSignAlg;
            return this;
        }

        public Builder withCredential(Credential credential) {
            this.credential = credential;
            return this;
        }

        public Builder withCredentialClient(CredentialClient credentialClient) {
            this.credentialClient = credentialClient;
            return this;
        }
    }

    private CredentialSigner(CredentialSignAlg credentialSignAlg, Credential credential, CredentialClient credentialClient) {
        this.credential = credential;
        CredentialSignText credentialSignText = new CredentialSignText();
        this.signText = credentialSignText;
        credentialSignText.setAlgId(credentialSignAlg);
        this.credentialClient = credentialClient;
    }

    @Override // p267ev.InterfaceC9565d
    public CredentialSignHandler getSignHandler() {
        return new CredentialSignHandler(this.credential, this.signText, this.credentialClient);
    }

    @Override // p267ev.InterfaceC9565d
    public CredentialVerifyHandler getVerifyHandler() {
        return new CredentialVerifyHandler(this.credential, this.signText, this.credentialClient);
    }

    public /* synthetic */ CredentialSigner(CredentialSignAlg credentialSignAlg, Credential credential, CredentialClient credentialClient, C89141 c89141) {
        this(credentialSignAlg, credential, credentialClient);
    }
}
