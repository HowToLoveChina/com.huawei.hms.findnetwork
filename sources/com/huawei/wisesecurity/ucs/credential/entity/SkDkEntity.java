package com.huawei.wisesecurity.ucs.credential.entity;

import javax.crypto.spec.SecretKeySpec;
import p021av.C1027a;
import p239dw.C9320b;
import p374iv.Exception_C10623b;
import p856zu.enumEncryptAlgorithm;
import p857zv.Exception_C14389c;

/* loaded from: classes9.dex */
public class SkDkEntity {
    private static final int GCM_IV_LEN = 12;
    private static final int GCM_TAG_LEN = 16;

    /* renamed from: iv */
    private byte[] f45394iv;
    private byte[] secKey;

    public static SkDkEntity from(byte[] bArr) throws Exception_C14389c {
        SkDkEntity skDkEntity = new SkDkEntity();
        if (bArr.length < 28) {
            throw new Exception_C14389c(1001L, "SK DK format error");
        }
        byte[] bArr2 = new byte[12];
        skDkEntity.f45394iv = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        byte[] bArr3 = new byte[bArr.length - 12];
        skDkEntity.secKey = bArr3;
        System.arraycopy(bArr, 12, bArr3, 0, bArr.length - 12);
        return skDkEntity;
    }

    public byte[] decryptSkDk(byte[] bArr) throws Exception_C14389c {
        try {
            return new C1027a.b().m6222b(enumEncryptAlgorithm.AES_GCM).m6223c(this.f45394iv).setKey(new SecretKeySpec(bArr, "AES")).m6221a().getDecryptHandler().from(this.secKey).mo56620to();
        } catch (Exception_C10623b e10) {
            StringBuilder sbM58651a = C9320b.m58651a("decrypt sk dk error : ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(1003L, sbM58651a.toString());
        }
    }

    public byte[] getIv() {
        return this.f45394iv;
    }

    public byte[] getSecKey() {
        return this.secKey;
    }
}
