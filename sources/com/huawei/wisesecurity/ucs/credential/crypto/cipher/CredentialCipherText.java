package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import mv.C11528a;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class CredentialCipherText {
    private CredentialCipherAlg algId;
    private byte[] cipherBytes;

    /* renamed from: iv */
    private byte[] f45390iv;
    private byte[] plainBytes;

    public void checkParam(boolean z10) throws C14391e {
        byte[] bArr = this.f45390iv;
        if (bArr == null || (this.algId == CredentialCipherAlg.AES_GCM && bArr.length != 12)) {
            throw new C14391e("illegal iv param..");
        }
        if (z10) {
            byte[] bArr2 = this.plainBytes;
            if (bArr2 == null || bArr2.length == 0) {
                throw new C14391e("plainBytes data can not be empty..");
            }
            return;
        }
        byte[] bArr3 = this.cipherBytes;
        if (bArr3 == null || bArr3.length == 0) {
            throw new C14391e("cipherBytes data can not be empty..");
        }
    }

    public int getAlgId() {
        return this.algId.getId();
    }

    public byte[] getCipherBytes() {
        return C11528a.m68812a(this.cipherBytes);
    }

    public byte[] getIv() {
        return C11528a.m68812a(this.f45390iv);
    }

    public byte[] getPlainBytes() {
        return C11528a.m68812a(this.plainBytes);
    }

    public void setAlgId(CredentialCipherAlg credentialCipherAlg) {
        this.algId = credentialCipherAlg;
    }

    public void setCipherBytes(byte[] bArr) {
        this.cipherBytes = C11528a.m68812a(bArr);
    }

    public void setIv(byte[] bArr) {
        this.f45390iv = C11528a.m68812a(bArr);
    }

    public void setPlainBytes(byte[] bArr) {
        this.plainBytes = C11528a.m68812a(bArr);
    }
}
