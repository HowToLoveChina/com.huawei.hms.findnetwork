package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class MonthStartResp {
    private long capacity;
    private String channel;
    private String currency;

    /* renamed from: id */
    private String f21410id;
    private String price;
    private String productName;
    private int productType;
    private long taskDate;

    public long getCapacity() {
        return this.capacity;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getId() {
        return this.f21410id;
    }

    public String getPrice() {
        return this.price;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getProductType() {
        return this.productType;
    }

    public long getTaskDate() {
        return this.taskDate;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setId(String str) {
        this.f21410id = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setProductType(int i10) {
        this.productType = i10;
    }

    public void setTaskDate(long j10) {
        this.taskDate = j10;
    }
}
