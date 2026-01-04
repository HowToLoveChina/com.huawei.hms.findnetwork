package com.huawei.hms.iap.entity;

import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* loaded from: classes8.dex */
public class OwnedPurchasesResult extends Result {
    private String continuationToken;
    private String errMsg;
    private List<String> inAppPurchaseDataList;
    private List<String> inAppSignature;
    private List<String> itemList;
    private List<String> placedInappPurchaseDataList;
    private List<String> placedInappSignatureList;
    private int returnCode;
    private String signatureAlgorithm;

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public List<String> getInAppPurchaseDataList() {
        return this.inAppPurchaseDataList;
    }

    public List<String> getInAppSignature() {
        return this.inAppSignature;
    }

    public List<String> getItemList() {
        return this.itemList;
    }

    public List<String> getPlacedInappPurchaseDataList() {
        return this.placedInappPurchaseDataList;
    }

    public List<String> getPlacedInappSignatureList() {
        return this.placedInappSignatureList;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public void setContinuationToken(String str) {
        this.continuationToken = str;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setInAppPurchaseDataList(List<String> list) {
        this.inAppPurchaseDataList = list;
    }

    public void setInAppSignature(List<String> list) {
        this.inAppSignature = list;
    }

    public void setItemList(List<String> list) {
        this.itemList = list;
    }

    public void setPlacedInappPurchaseDataList(List<String> list) {
        this.placedInappPurchaseDataList = list;
    }

    public void setPlacedInappSignatureList(List<String> list) {
        this.placedInappSignatureList = list;
    }

    public void setReturnCode(int i10) {
        this.returnCode = i10;
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
    }
}
