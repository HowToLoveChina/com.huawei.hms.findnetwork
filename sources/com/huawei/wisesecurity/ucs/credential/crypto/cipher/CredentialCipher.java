package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import mv.C11528a;
import p239dw.C9320b;
import p374iv.C10626e;
import p500nv.C11756a;
import p535ov.InterfaceC12042i;
import p856zu.InterfaceC14386g;
import p857zv.C14389c;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class CredentialCipher implements InterfaceC14386g {
    public CredentialCipherText cipherText;
    private Credential credential;
    private CredentialClient credentialClient;

    public static class Builder {

        @InterfaceC12042i
        private CredentialCipherAlg cipherAlg = CredentialCipherAlg.AES_GCM;

        @InterfaceC12042i
        private Credential credential;

        @InterfaceC12042i
        private CredentialClient credentialClient;

        /* renamed from: iv */
        @InterfaceC12042i
        private byte[] f45388iv;

        public CredentialCipher build() throws C14389c {
            try {
                C11756a.m70079b(this);
                return new CredentialCipher(this.cipherAlg, this.credential, this.f45388iv, this.credentialClient);
            } catch (C10626e e10) {
                StringBuilder sbM58651a = C9320b.m58651a("CredentialCipher check param error : ");
                sbM58651a.append(e10.getMessage());
                throw new C14391e(sbM58651a.toString());
            }
        }

        public Builder withAlg(CredentialCipherAlg credentialCipherAlg) {
            this.cipherAlg = credentialCipherAlg;
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

        public Builder withIv(byte[] bArr) {
            this.f45388iv = C11528a.m68812a(bArr);
            return this;
        }
    }

    public CredentialCipher(CredentialCipherAlg credentialCipherAlg, Credential credential, byte[] bArr, CredentialClient credentialClient) {
        this.credential = credential;
        CredentialCipherText credentialCipherText = new CredentialCipherText();
        credentialCipherText.setAlgId(credentialCipherAlg);
        credentialCipherText.setIv(bArr);
        this.cipherText = credentialCipherText;
        this.credentialClient = credentialClient;
    }

    @Override // p856zu.InterfaceC14386g
    public CredentialDecryptHandler getDecryptHandler() {
        return new CredentialDecryptHandler(this.credential, this.cipherText, this.credentialClient);
    }

    @Override // p856zu.InterfaceC14386g
    public CredentialEncryptHandler getEncryptHandler() {
        return new CredentialEncryptHandler(this.credential, this.cipherText, this.credentialClient);
    }
}
