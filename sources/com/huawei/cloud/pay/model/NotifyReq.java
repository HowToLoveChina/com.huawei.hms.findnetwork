package com.huawei.cloud.pay.model;

import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceSwitchSuggestDialog;

/* loaded from: classes5.dex */
public class NotifyReq extends Request {

    /* renamed from: id */
    private String f21411id;
    private String orderId;
    private String preorderId;
    private String productId;
    private String purchaseToken;
    private String requestId;
    private String subscriptionId;

    public NotifyReq() {
        super(SpaceSwitchSuggestDialog.SCENE_ID_NOTIFY);
    }

    public String getId() {
        return this.f21411id;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPreorderId() {
        return this.preorderId;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPurchaseToken() {
        return this.purchaseToken;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public void setId(String str) {
        this.f21411id = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPreorderId(String str) {
        this.preorderId = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPurchaseToken(String str) {
        this.purchaseToken = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public NotifyReq(String str, String str2, String str3) {
        super(SpaceSwitchSuggestDialog.SCENE_ID_NOTIFY);
        this.f21411id = str;
        this.requestId = str2;
        this.orderId = str3;
    }
}
