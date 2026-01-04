package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class MonthDetail implements Serializable {
    private static final long serialVersionUID = -8800027411000696075L;
    private String channel;
    private long curCapacity;
    private MemGrade curGrade;
    private String curPackageId;
    private String curProductName;
    private int curProductType;
    private String currency;
    private int isAutoPay;
    private long nextCapacity;
    private String nextPackageId;
    private String nextPrice;
    private String nextProductName;
    private int nextProductType;
    private int payCount;
    private long taskDate;

    public String getChannel() {
        return this.channel;
    }

    public long getCurCapacity() {
        return this.curCapacity;
    }

    public MemGrade getCurGrade() {
        return this.curGrade;
    }

    public String getCurPackageId() {
        return this.curPackageId;
    }

    public String getCurProductName() {
        return this.curProductName;
    }

    public int getCurProductType() {
        return this.curProductType;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getIsAutoPay() {
        return this.isAutoPay;
    }

    public long getNextCapacity() {
        return this.nextCapacity;
    }

    public String getNextPackageId() {
        return this.nextPackageId;
    }

    public String getNextPrice() {
        return this.nextPrice;
    }

    public String getNextProductName() {
        return this.nextProductName;
    }

    public int getNextProductType() {
        return this.nextProductType;
    }

    public int getPayCount() {
        return this.payCount;
    }

    public long getTaskDate() {
        return this.taskDate;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCurCapacity(long j10) {
        this.curCapacity = j10;
    }

    public void setCurGrade(MemGrade memGrade) {
        this.curGrade = memGrade;
    }

    public void setCurPackageId(String str) {
        this.curPackageId = str;
    }

    public void setCurProductName(String str) {
        this.curProductName = str;
    }

    public void setCurProductType(int i10) {
        this.curProductType = i10;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setIsAutoPay(int i10) {
        this.isAutoPay = i10;
    }

    public void setNextCapacity(long j10) {
        this.nextCapacity = j10;
    }

    public void setNextPackageId(String str) {
        this.nextPackageId = str;
    }

    public void setNextPrice(String str) {
        this.nextPrice = str;
    }

    public void setNextProductName(String str) {
        this.nextProductName = str;
    }

    public void setNextProductType(int i10) {
        this.nextProductType = i10;
    }

    public void setPayCount(int i10) {
        this.payCount = i10;
    }

    public void setTaskDate(long j10) {
        this.taskDate = j10;
    }
}
