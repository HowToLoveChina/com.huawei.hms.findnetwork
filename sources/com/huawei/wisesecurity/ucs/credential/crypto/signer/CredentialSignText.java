package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import mv.C11528a;
import p857zv.C14389c;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class CredentialSignText {
    private CredentialSignAlg algId;
    private byte[] dataBytes;
    private byte[] signature;

    public void checkParam(boolean z10) throws C14389c {
        byte[] bArr = this.dataBytes;
        if (bArr == null || bArr.length == 0) {
            throw new C14391e("dataBytes data can not be empty..");
        }
        if (z10) {
            return;
        }
        byte[] bArr2 = this.signature;
        if (bArr2 == null || bArr2.length == 0) {
            throw new C14391e("signature data can not be empty..");
        }
    }

    public int getAlgId() {
        return this.algId.getId();
    }

    public byte[] getDataBytes() {
        return C11528a.m68812a(this.dataBytes);
    }

    public byte[] getSignature() {
        return C11528a.m68812a(this.signature);
    }

    public void setAlgId(CredentialSignAlg credentialSignAlg) {
        this.algId = credentialSignAlg;
    }

    public void setDataBytes(byte[] bArr) {
        this.dataBytes = C11528a.m68812a(bArr);
    }

    public void setSignature(byte[] bArr) {
        this.signature = C11528a.m68812a(bArr);
    }
}
