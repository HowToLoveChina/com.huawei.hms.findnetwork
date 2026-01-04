package com.huawei.hicloud.request.userk.bean;

/* loaded from: classes6.dex */
public class TrustCircleUserKeyReq extends UserKeyBaseReq {
    private String aad;
    private int taVersion;
    private String tcisId;

    public TrustCircleUserKeyReq(int i10, String str, String str2, int i11, String str3) {
        super(3, EncryptBaseReq.INFO_QUERY_TRUST_CIRCLE_USER_KEY);
        this.keyType = str;
        this.businessType = i10;
        this.tcisId = str2;
        this.taVersion = i11;
        this.aad = str3;
    }

    public String getAad() {
        return this.aad;
    }

    public int getTaVersion() {
        return this.taVersion;
    }

    public String getTcisId() {
        return this.tcisId;
    }

    public void setAad(String str) {
        this.aad = str;
    }

    public void setTaVersion(int i10) {
        this.taVersion = i10;
    }

    public void setTcisId(String str) {
        this.tcisId = str;
    }
}
