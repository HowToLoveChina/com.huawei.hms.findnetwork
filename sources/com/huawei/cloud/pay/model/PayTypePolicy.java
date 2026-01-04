package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class PayTypePolicy {
    private int index;
    private String packageId;
    private String payment;
    private String salChannel;
    private String srcChannel;

    public int getIndex() {
        return this.index;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getPayment() {
        return this.payment;
    }

    public String getSalChannel() {
        return this.salChannel;
    }

    public String getSrcChannel() {
        return this.srcChannel;
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public void setPayment(String str) {
        this.payment = str;
    }

    public void setSalChannel(String str) {
        this.salChannel = str;
    }

    public void setSrcChannel(String str) {
        this.srcChannel = str;
    }
}
