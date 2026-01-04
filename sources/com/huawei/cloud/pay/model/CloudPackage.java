package com.huawei.cloud.pay.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.cloud.pay.R$plurals;
import com.huawei.cloud.pay.R$string;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Objects;
import p454lj.C11290m;

/* loaded from: classes5.dex */
public class CloudPackage implements Comparable<CloudPackage>, Serializable {
    private static final long serialVersionUID = 6682206013658188889L;
    private long capacity;
    private CountDownConfig countDownConfig;
    private String country;
    private String currency;
    private String dicountTag;
    private int durationMonth;
    private String durationName;
    private String durationTag;
    private int durationUnit;
    private long effectBeginTime;
    private long effectEndTime;
    private HashMap<String, String> extendTagMap;
    private GiftRight giftRight;
    private String gradeCode;

    /* renamed from: id */
    private String f21401id;
    private int matchPriority;
    private String memAD;
    private int omType;
    private String omid;
    private String packageTitle;
    private BigDecimal price;
    private String productName;
    private int productType;
    private int promDuration;
    private int promType;
    private String remark;
    private String remark2;
    private String remark3;
    private String renewChooseDesc;
    private int renewChooseType;
    private Integer scheme;
    private int showSeq;
    private BigDecimal spPrice;
    private String spaceTag;
    private String status;
    private String symbol;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.capacity == ((CloudPackage) obj).capacity;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public CountDownConfig getCountDownConfig() {
        return this.countDownConfig;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCurrencySymbol() {
        return TextUtils.isEmpty(this.currency) ? this.symbol : C11290m.m67740a(this.currency);
    }

    public String getDicountTag() {
        return this.dicountTag;
    }

    public int getDurationMonth() {
        return this.durationMonth;
    }

    public String getDurationName() {
        return this.durationName;
    }

    public String getDurationTag() {
        return this.durationTag;
    }

    public int getDurationUnit() {
        return this.durationUnit;
    }

    public long getEffectBeginTime() {
        return this.effectBeginTime;
    }

    public long getEffectEndTime() {
        return this.effectEndTime;
    }

    public HashMap<String, String> getExtendTagMap() {
        return this.extendTagMap;
    }

    public GiftRight getGiftRight() {
        return this.giftRight;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getId() {
        return this.f21401id;
    }

    public int getMatchPriority() {
        return this.matchPriority;
    }

    public String getMemAD() {
        return this.memAD;
    }

    public int getOmType() {
        return this.omType;
    }

    public String getOmid() {
        return this.omid;
    }

    public String getPackageTitle() {
        return this.packageTitle;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getProductType() {
        return this.productType;
    }

    public int getPromDuration() {
        return this.promDuration;
    }

    public int getPromType() {
        return this.promType;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getRemark2() {
        return this.remark2;
    }

    public String getRemark3() {
        return this.remark3;
    }

    public String getRenewChooseDesc() {
        return this.renewChooseDesc;
    }

    public int getRenewChooseType() {
        return this.renewChooseType;
    }

    public Integer getScheme() {
        return this.scheme;
    }

    public int getShowSeq() {
        return this.showSeq;
    }

    public BigDecimal getSpPrice() {
        return this.spPrice;
    }

    public String getSpaceTag() {
        return this.spaceTag;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.capacity));
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setCountDownConfig(CountDownConfig countDownConfig) {
        this.countDownConfig = countDownConfig;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDicountTag(String str) {
        this.dicountTag = str;
    }

    public void setDurationMonth(int i10) {
        this.durationMonth = i10;
    }

    public void setDurationName(String str) {
        this.durationName = str;
    }

    public void setDurationTag(String str) {
        this.durationTag = str;
    }

    public void setDurationUnit(int i10) {
        this.durationUnit = i10;
    }

    public void setEffectBeginTime(long j10) {
        this.effectBeginTime = j10;
    }

    public void setEffectEndTime(long j10) {
        this.effectEndTime = j10;
    }

    public void setExtendTagMap(HashMap<String, String> map) {
        this.extendTagMap = map;
    }

    public void setGiftRight(GiftRight giftRight) {
        this.giftRight = giftRight;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setId(String str) {
        this.f21401id = str;
    }

    public void setMatchPriority(int i10) {
        this.matchPriority = i10;
    }

    public void setMemAD(String str) {
        this.memAD = str;
    }

    public void setOmType(int i10) {
        this.omType = i10;
    }

    public void setOmid(String str) {
        this.omid = str;
    }

    public void setPackageTitle(String str) {
        this.packageTitle = str;
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

    public void setPromDuration(int i10) {
        this.promDuration = i10;
    }

    public void setPromType(int i10) {
        this.promType = i10;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRemark2(String str) {
        this.remark2 = str;
    }

    public void setRemark3(String str) {
        this.remark3 = str;
    }

    public void setRenewChooseDesc(String str) {
        this.renewChooseDesc = str;
    }

    public void setRenewChooseType(int i10) {
        this.renewChooseType = i10;
    }

    public void setScheme(Integer num) {
        this.scheme = num;
    }

    public void setShowSeq(int i10) {
        this.showSeq = i10;
    }

    public void setSpPrice(BigDecimal bigDecimal) {
        this.spPrice = bigDecimal;
    }

    public void setSpaceTag(String str) {
        this.spaceTag = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(CloudPackage cloudPackage) {
        long j10 = this.capacity - cloudPackage.capacity;
        if (j10 < 0) {
            return -1;
        }
        if (j10 > 0) {
            return 1;
        }
        int i10 = this.durationMonth - cloudPackage.durationMonth;
        if (i10 < 0) {
            return -1;
        }
        return i10 > 0 ? 1 : 0;
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
