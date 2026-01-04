package com.huawei.cloud.pay.model;

import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.Objects;
import p054cj.C1442a;
import p454lj.C11290m;

/* loaded from: classes5.dex */
public class TransactionItem implements Comparable<TransactionItem> {
    private static final String TAG = "TransactionItem";
    private static final int TIME_MINUS_ONE = -1;
    private static final int TIME_ONE = 1;
    private static final int TIME_ZERO = 0;
    private static final long TIME_ZERO_LONG = 0;
    private long capacity;
    private String comment;
    private String country;
    private String currency;
    private BigDecimal fee;
    private String feeUnit;
    private String label;
    private int orderSource;
    private int orderStatus;
    private int orderType;
    private String payChannelDesc;
    private String productName;
    private int subType;
    private String trxId;
    private long trxTime;
    private String trxType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.trxTime == ((TransactionItem) obj).trxTime;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getFee() {
        if (this.fee == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(this.currency)) {
            C1442a.m8291w("Order", "currency is empty!");
            sb2.append(C11290m.m67748i(this.fee));
            return sb2.toString();
        }
        BigDecimal bigDecimal = this.fee;
        String str = this.currency;
        return C11290m.m67749j(bigDecimal, str, str);
    }

    public String getFeeUnit() {
        return this.feeUnit;
    }

    public String getLabel() {
        return this.label;
    }

    public int getOrderSource() {
        return this.orderSource;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public String getPayChannelDesc() {
        return this.payChannelDesc;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getSubType() {
        return this.subType;
    }

    public String getTrxId() {
        return this.trxId;
    }

    public long getTrxTime() {
        return this.trxTime;
    }

    public String getTrxType() {
        return this.trxType;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.trxTime));
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setFee(BigDecimal bigDecimal) {
        this.fee = bigDecimal;
    }

    public void setFeeUnit(String str) {
        this.feeUnit = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setOrderSource(int i10) {
        this.orderSource = i10;
    }

    public void setOrderStatus(int i10) {
        this.orderStatus = i10;
    }

    public void setOrderType(int i10) {
        this.orderType = i10;
    }

    public void setPayChannelDesc(String str) {
        this.payChannelDesc = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setSubType(int i10) {
        this.subType = i10;
    }

    public void setTrxId(String str) {
        this.trxId = str;
    }

    public void setTrxTime(long j10) {
        this.trxTime = j10;
    }

    public void setTrxType(String str) {
        this.trxType = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(TransactionItem transactionItem) {
        long j10 = this.trxTime - transactionItem.trxTime;
        if (j10 > 0) {
            return -1;
        }
        return j10 < 0 ? 1 : 0;
    }
}
