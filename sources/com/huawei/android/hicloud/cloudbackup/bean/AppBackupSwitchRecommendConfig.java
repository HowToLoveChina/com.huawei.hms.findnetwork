package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class AppBackupSwitchRecommendConfig {
    private int recommendInterval = 30;
    private float startCheckThreshold = 0.2f;
    private float endCalcThreshold = 0.1f;
    private int cacheExpires = 72;
    private int recommendNotifyInterval = 14;
    private float recommendRetryRate = 1.0f;
    private int recommendRetryTimes = 3;
    private int notifyCheckInterval = 72;
    private int quotaInfoCacheExpires = 24;

    public int getCacheExpires() {
        return this.cacheExpires;
    }

    public float getEndCalcThreshold() {
        return this.endCalcThreshold;
    }

    public int getNotifyCheckInterval() {
        return this.notifyCheckInterval;
    }

    public int getQuotaInfoCacheExpires() {
        return this.quotaInfoCacheExpires;
    }

    public int getRecommendInterval() {
        return this.recommendInterval;
    }

    public int getRecommendNotifyInterval() {
        return this.recommendNotifyInterval;
    }

    public float getRecommendRetryRate() {
        return this.recommendRetryRate;
    }

    public int getRecommendRetryTimes() {
        return this.recommendRetryTimes;
    }

    public float getStartCheckThreshold() {
        return this.startCheckThreshold;
    }

    public void setCacheExpires(int i10) {
        this.cacheExpires = i10;
    }

    public void setEndCalcThreshold(float f10) {
        this.endCalcThreshold = f10;
    }

    public void setNotifyCheckInterval(int i10) {
        this.notifyCheckInterval = i10;
    }

    public void setQuotaInfoCacheExpires(int i10) {
        this.quotaInfoCacheExpires = i10;
    }

    public void setRecommendInterval(int i10) {
        this.recommendInterval = i10;
    }

    public void setRecommendNotifyInterval(int i10) {
        this.recommendNotifyInterval = i10;
    }

    public void setRecommendRetryRate(float f10) {
        this.recommendRetryRate = f10;
    }

    public void setRecommendRetryTimes(int i10) {
        this.recommendRetryTimes = i10;
    }

    public void setStartCheckThreshold(float f10) {
        this.startCheckThreshold = f10;
    }
}
