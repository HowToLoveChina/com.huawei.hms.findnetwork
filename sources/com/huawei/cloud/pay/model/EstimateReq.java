package com.huawei.cloud.pay.model;

import java.math.BigDecimal;
import java.util.Map;

/* loaded from: classes5.dex */
public class EstimateReq extends Request {
    private Map<String, String> campaignExt;
    private BigDecimal deductAmount;

    /* renamed from: id */
    private String f21405id;
    private int packageType;
    private String promId;
    private Integer supportSub;
    private String version;

    public EstimateReq(Map<String, String> map) {
        super("estimatePackage");
        this.campaignExt = map;
    }

    public Map<String, String> getCampaignExt() {
        return this.campaignExt;
    }

    public BigDecimal getDeductAmount() {
        return this.deductAmount;
    }

    public String getId() {
        return this.f21405id;
    }

    public int getPackageType() {
        return this.packageType;
    }

    public String getPromId() {
        return this.promId;
    }

    public Integer getSupportSub() {
        return this.supportSub;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCampaignExt(Map<String, String> map) {
        this.campaignExt = map;
    }

    public void setDeductAmount(BigDecimal bigDecimal) {
        this.deductAmount = bigDecimal;
    }

    public void setPromId(String str) {
        this.promId = str;
    }

    public void setSupportSub(Integer num) {
        this.supportSub = num;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public EstimateReq(String str, int i10, String str2, BigDecimal bigDecimal, Integer num, String str3) {
        super("estimatePackage");
        this.f21405id = str;
        this.packageType = i10;
        this.version = str2;
        this.deductAmount = bigDecimal;
        this.supportSub = num;
        this.promId = str3;
    }
}
