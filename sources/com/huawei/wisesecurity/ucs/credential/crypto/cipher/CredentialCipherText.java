package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import mv.SafeBytes;
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
        return SafeBytes.doClone(this.cipherBytes);
    }

    public byte[] getIv() {
        return SafeBytes.doClone(this.f45390iv);
    }

    public byte[] getPlainBytes() {
        return SafeBytes.doClone(this.plainBytes);
    }

    public void setAlgId(CredentialCipherAlg credentialCipherAlg) {
        this.algId = credentialCipherAlg;
    }

    public void setCipherBytes(byte[] bArr) {
        this.cipherBytes = SafeBytes.doClone(bArr);
    }

    public void setIv(byte[] bArr) {
        this.f45390iv = SafeBytes.doClone(bArr);
    }

    public void setPlainBytes(byte[] bArr) {
        this.plainBytes = SafeBytes.doClone(bArr);
    }
}
