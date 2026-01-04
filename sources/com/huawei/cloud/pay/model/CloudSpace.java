package com.huawei.cloud.pay.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.cloud.pay.R$plurals;
import com.huawei.cloud.pay.R$string;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import p454lj.C11290m;

/* loaded from: classes5.dex */
public class CloudSpace implements Serializable {
    private static final long serialVersionUID = -2336907900532689257L;
    private long activeTime;
    private long baseCapacity;
    private long capacity;
    private ConvertInfo convertInfo;
    private String currency;
    private int durationMonth;
    private int durationUnit;
    private long endTime;
    private long endtime;
    private PackageGrades grade;
    private String gradeCode;
    private String gradeName;

    /* renamed from: id */
    private String f21402id;
    private int isAutoPay = -1;
    private String packageTitle;
    private String petalOneMemberName;
    private int petalOneMemberType;
    private BigDecimal price;
    private String productName;
    private int productType;
    private String remark;
    private int scheme;
    private BigDecimal spPrice;
    private long starttime;
    private String symbol;
    private int userPayType;

    public long getActiveTime() {
        return this.activeTime;
    }

    public long getBaseCapacity() {
        return this.baseCapacity;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public ConvertInfo getConvertInfo() {
        return this.convertInfo;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCurrencySymbol() {
        return TextUtils.isEmpty(this.currency) ? this.symbol : C11290m.m67740a(this.currency);
    }

    public int getDurationMonth() {
        return this.durationMonth;
    }

    public int getDurationUnit() {
        return this.durationUnit;
    }

    public long getEndTime() {
        long j10 = this.endTime;
        return j10 > 0 ? j10 : this.endtime;
    }

    public PackageGrades getGrade() {
        return this.grade;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public String getId() {
        return this.f21402id;
    }

    public int getIsAutoPay() {
        return this.isAutoPay;
    }

    public String getPackageTitle() {
        return this.packageTitle;
    }

    public String getPetalOneMemberName() {
        return this.petalOneMemberName;
    }

    public int getPetalOneMemberType() {
        return this.petalOneMemberType;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getScheme() {
        return this.scheme;
    }

    public BigDecimal getSpPrice() {
        return this.spPrice;
    }

    public long getStartTime() {
        return this.starttime;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public long getTotalCapacity() {
        return this.baseCapacity + this.capacity;
    }

    public int getType() {
        return this.productType;
    }

    public int getUserPayType() {
        return this.userPayType;
    }

    public void setActiveTime(long j10) {
        this.activeTime = j10;
    }

    public void setBaseCapacity(long j10) {
        this.baseCapacity = j10;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setConvertInfo(ConvertInfo convertInfo) {
        this.convertInfo = convertInfo;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDurationMonth(int i10) {
        this.durationMonth = i10;
    }

    public void setDurationUnit(int i10) {
        this.durationUnit = i10;
    }

    public void setEndTime(long j10) {
        this.endTime = j10;
    }

    public void setEndTimeOld(long j10) {
        this.endtime = j10;
    }

    public void setGrade(PackageGrades packageGrades) {
        this.grade = packageGrades;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setGradeName(String str) {
        this.gradeName = str;
    }

    public void setId(String str) {
        this.f21402id = str;
    }

    public void setIsAutoPay(int i10) {
        this.isAutoPay = i10;
    }

    public void setPackageTitle(String str) {
        this.packageTitle = str;
    }

    public void setPetalOneMemberName(String str) {
        this.petalOneMemberName = str;
    }

    public void setPetalOneMemberType(int i10) {
        this.petalOneMemberType = i10;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setProductType(int i10) {
        this.productType = i10;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setScheme(int i10) {
        this.scheme = i10;
    }

    public void setSpPrice(BigDecimal bigDecimal) {
        this.spPrice = bigDecimal;
    }

    public void setStartTime(long j10) {
        this.starttime = j10;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setUserPayType(int i10) {
        this.userPayType = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public String getProductName(Context context) {
        int i10 = this.productType;
        if (i10 == 8 || i10 == 6) {
            return context.getString(R$string.cloudpay_continuous_monthly_title_new);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        Resources resources = context.getResources();
        int i11 = R$plurals.cloudpay_package_duration_time_unit_month;
        int i12 = this.durationMonth;
        return resources.getQuantityString(i11, i12, numberFormat.format(i12));
    }
}
