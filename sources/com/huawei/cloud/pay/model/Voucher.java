package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/* loaded from: classes5.dex */
public class Voucher implements Serializable, Comparable<Voucher> {
    private static final long serialVersionUID = 6682206013658188890L;
    private long activityEndTime;
    private String activityId;
    private String activityName;
    private long activityStartTime;
    private String applicationId;
    private String applicationName;
    private BigDecimal balance;
    private long capacity;
    private boolean checked;
    private long claimTime;
    private String consumeMode;
    private String country;
    private long createTime;
    private String currency;
    private String discount;
    private long effectiveTime;
    private long expireTime;
    private String faceValue;
    private String feeMode;
    private String gradeCode;
    private String logoUrl;
    private BigDecimal minFee;
    private int orderStatus;
    private String productId;
    private String productName;
    private List<String> relatedPackages;
    private String roundMode;
    private String roundPrecision;
    private int status;
    private BigDecimal subFee;
    private int superScript;
    private String unusableDesc;
    private String useUrl;
    private String voucherCode;
    private String voucherId;
    private String voucherName;
    private String voucherSubTitle;
    private String voucherTitle;
    private String welfareName;
    private int ruleStatus = 0;
    private int voucherCardType = 0;

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public long getActivityEndTime() {
        return this.activityEndTime;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public long getActivityStartTime() {
        return this.activityStartTime;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public long getClaimTime() {
        return this.claimTime;
    }

    public String getConsumeMode() {
        return this.consumeMode;
    }

    public String getCountry() {
        return this.country;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDiscount() {
        return this.discount;
    }

    public long getEffectiveTime() {
        return this.effectiveTime;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getFaceValue() {
        return this.faceValue;
    }

    public String getFeeMode() {
        return this.feeMode;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public BigDecimal getMinFee() {
        return this.minFee;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public List<String> getRelatedPackages() {
        return this.relatedPackages;
    }

    public String getRoundMode() {
        return this.roundMode;
    }

    public String getRoundPrecision() {
        return this.roundPrecision;
    }

    public int getRuleStatus() {
        return this.ruleStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public BigDecimal getSubFee() {
        return this.subFee;
    }

    public int getSuperScript() {
        return this.superScript;
    }

    public String getUbusableDesc() {
        return this.unusableDesc;
    }

    public String getUseUrl() {
        return this.useUrl;
    }

    public String getVoucherAppId() {
        return this.applicationId;
    }

    public int getVoucherCardType() {
        return this.voucherCardType;
    }

    public String getVoucherCode() {
        return this.voucherCode;
    }

    public String getVoucherId() {
        return this.voucherId;
    }

    public String getVoucherName() {
        return this.voucherName;
    }

    public String getVoucherSubTitle() {
        return this.voucherSubTitle;
    }

    public String getVoucherTitle() {
        return this.voucherTitle;
    }

    public String getWelfareName() {
        return this.welfareName;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setActivityEndTime(long j10) {
        this.activityEndTime = j10;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public void setActivityStartTime(long j10) {
        this.activityStartTime = j10;
    }

    public void setApplicationName(String str) {
        this.applicationName = str;
    }

    public void setBalance(BigDecimal bigDecimal) {
        this.balance = bigDecimal;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setChecked(boolean z10) {
        this.checked = z10;
    }

    public void setClaimTime(long j10) {
        this.claimTime = j10;
    }

    public void setConsumeMode(String str) {
        this.consumeMode = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDiscount(String str) {
        this.discount = str;
    }

    public void setEffectiveTime(long j10) {
        this.effectiveTime = j10;
    }

    public void setExpireTime(long j10) {
        this.expireTime = j10;
    }

    public void setFaceValue(String str) {
        this.faceValue = str;
    }

    public void setFeeMode(String str) {
        this.feeMode = str;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public void setMinFee(BigDecimal bigDecimal) {
        this.minFee = bigDecimal;
    }

    public void setOrderStatus(int i10) {
        this.orderStatus = i10;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setRelatedPackages(List<String> list) {
        this.relatedPackages = list;
    }

    public void setRoundMode(String str) {
        this.roundMode = str;
    }

    public void setRoundPrecision(String str) {
        this.roundPrecision = str;
    }

    public void setRuleStatus(int i10) {
        this.ruleStatus = i10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setSubFee(BigDecimal bigDecimal) {
        this.subFee = bigDecimal;
    }

    public void setSuperScript(int i10) {
        this.superScript = i10;
    }

    public void setUbusableDesc(String str) {
        this.unusableDesc = str;
    }

    public void setUseUrl(String str) {
        this.useUrl = str;
    }

    public void setVoucherAppId(String str) {
        this.applicationId = str;
    }

    public void setVoucherCardType(int i10) {
        this.voucherCardType = i10;
    }

    public void setVoucherCode(String str) {
        this.voucherCode = str;
    }

    public void setVoucherId(String str) {
        this.voucherId = str;
    }

    public void setVoucherName(String str) {
        this.voucherName = str;
    }

    public void setVoucherSubTitle(String str) {
        this.voucherSubTitle = str;
    }

    public void setVoucherTitle(String str) {
        this.voucherTitle = str;
    }

    public void setWelfareName(String str) {
        this.welfareName = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(Voucher voucher) {
        BigDecimal bigDecimal;
        int i10 = voucher.voucherCardType;
        int i11 = this.voucherCardType;
        if (i10 != i11 || voucher.expireTime != this.expireTime) {
            long j10 = this.expireTime - voucher.expireTime;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }
        if (i11 == 1 || !"0".equals(this.feeMode) || !"0".equals(voucher.feeMode) || (bigDecimal = this.balance) == null) {
            return 0;
        }
        if (bigDecimal.compareTo(voucher.balance) == 1) {
            return 1;
        }
        if (this.balance.compareTo(voucher.balance) == -1) {
            return -1;
        }
        this.balance.compareTo(voucher.balance);
        return 0;
    }
}
