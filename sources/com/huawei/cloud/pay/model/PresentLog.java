package com.huawei.cloud.pay.model;

import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class PresentLog {
    private BigDecimal fee;
    private MemGradeRights grade;
    private String presentNickName;
    private String presentUid;
    private String productName;
    private String requestId;
    private long tradeTime;

    public BigDecimal getFee() {
        return this.fee;
    }

    public MemGradeRights getGrade() {
        return this.grade;
    }

    public String getPresentNickName() {
        return this.presentNickName;
    }

    public String getPresentUid() {
        return this.presentUid;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getTradeTime() {
        return this.tradeTime;
    }

    public void setFee(BigDecimal bigDecimal) {
        this.fee = bigDecimal;
    }

    public void setGrade(MemGradeRights memGradeRights) {
        this.grade = memGradeRights;
    }

    public void setPresentNickName(String str) {
        this.presentNickName = str;
    }

    public void setPresentUid(String str) {
        this.presentUid = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setTradeTime(long j10) {
        this.tradeTime = j10;
    }
}
