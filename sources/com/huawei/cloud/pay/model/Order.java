package com.huawei.cloud.pay.model;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.Objects;
import p054cj.C1442a;
import p454lj.C11290m;

/* loaded from: classes5.dex */
public class Order implements Comparable<Order> {
    private static final String TAG = "Order";
    private long capacity;
    private String comment;
    private String currency;
    private String fee;
    private String feeUnit;
    private String orderId;
    private long orderTime;
    private int orderType;
    private String productName;
    private String status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.orderTime == ((Order) obj).orderTime;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getFee() {
        String str = this.fee;
        if (str == null || str.isEmpty()) {
            return "0";
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(this.fee);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(this.currency)) {
                String str2 = this.currency;
                return C11290m.m67749j(bigDecimal, str2, str2);
            }
            C1442a.m8291w(TAG, "currency is empty!");
            sb2.append(C11290m.m67748i(bigDecimal));
            return sb2.toString();
        } catch (NumberFormatException unused) {
            C1442a.m8289e(TAG, "getFee NumberFormatException.");
            return this.fee;
        }
    }

    public String getFeeUnit() {
        return this.feeUnit;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public long getOrderTime() {
        return this.orderTime;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.orderTime));
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setFeeUnit(String str) {
        this.feeUnit = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderTime(long j10) {
        this.orderTime = j10;
    }

    public void setOrderType(int i10) {
        this.orderType = i10;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(Order order) {
        long j10 = this.orderTime - order.orderTime;
        if (j10 > 0) {
            return -1;
        }
        return j10 < 0 ? 1 : 0;
    }
}
