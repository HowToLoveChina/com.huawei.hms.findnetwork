package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class TerminationRetentionData implements Serializable {
    private static final long serialVersionUID = -4185774434817724087L;
    private int dialogType = -1;
    private GetClientUIConfigResp getClientUIConfigResp;
    private boolean isFromIAP;
    private MonthDetail monthDetail;
    private int productType;
    private String srcChannel;
    private UserPackage userPackage;
    private Welfare welfare;

    public int getDialogType() {
        return this.dialogType;
    }

    public GetClientUIConfigResp getGetClientUIConfigResp() {
        return this.getClientUIConfigResp;
    }

    public MonthDetail getMonthDetail() {
        return this.monthDetail;
    }

    public int getProductType() {
        return this.productType;
    }

    public String getSrcChannel() {
        return this.srcChannel;
    }

    public UserPackage getUserPackage() {
        return this.userPackage;
    }

    public Welfare getWelfare() {
        return this.welfare;
    }

    public boolean isFromIAP() {
        return this.isFromIAP;
    }

    public void setDialogType(int i10) {
        this.dialogType = i10;
    }

    public void setFromIAP(boolean z10) {
        this.isFromIAP = z10;
    }

    public void setGetClientUIConfigResp(GetClientUIConfigResp getClientUIConfigResp) {
        this.getClientUIConfigResp = getClientUIConfigResp;
    }

    public void setMonthDetail(MonthDetail monthDetail) {
        this.monthDetail = monthDetail;
    }

    public void setProductType(int i10) {
        this.productType = i10;
    }

    public void setSrcChannel(String str) {
        this.srcChannel = str;
    }

    public void setUserPackage(UserPackage userPackage) {
        this.userPackage = userPackage;
    }

    public void setWelfare(Welfare welfare) {
        this.welfare = welfare;
    }
}
