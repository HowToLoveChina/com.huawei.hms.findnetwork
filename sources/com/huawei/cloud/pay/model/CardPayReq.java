package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class CardPayReq extends Request {
    private String cardNo;
    private Long hmsVer;

    /* renamed from: id */
    private String f21398id;
    private Integer signMode;
    private String version;

    public CardPayReq(String str, String str2) {
        super("payByCard");
        this.cardNo = str;
        this.f21398id = str2;
        this.version = "2.0";
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public long getHmsVer() {
        return this.hmsVer.longValue();
    }

    public String getId() {
        return this.f21398id;
    }

    public int getSignMode() {
        return this.signMode.intValue();
    }

    public String getVersion() {
        return this.version;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setHmsVer(long j10) {
        this.hmsVer = Long.valueOf(j10);
    }

    public void setId(String str) {
        this.f21398id = str;
    }

    public void setSignMode(int i10) {
        this.signMode = Integer.valueOf(i10);
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public CardPayReq(String str, String str2, long j10, int i10) {
        super("payByCard");
        this.cardNo = str;
        this.f21398id = str2;
        this.version = "2.0";
        this.hmsVer = Long.valueOf(j10);
        this.signMode = Integer.valueOf(i10);
    }
}
