package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.hms.network.embedded.C5863b6;

/* loaded from: classes2.dex */
public class AppBackupDurationInfo {
    long dataCacheDurationMillis;
    long moduleDataCacheDurationMillis;
    long sdcardCacheDurationMillis;
    int dataCacheDuration = 36;
    int sdcardCacheDuration = 36;
    int moduleDataCacheDuration = 48;

    public long getDataCacheDurationMillis() {
        if (this.dataCacheDurationMillis == 0) {
            this.dataCacheDurationMillis = this.dataCacheDuration * C5863b6.g.f26453g;
        }
        return this.dataCacheDurationMillis;
    }

    public long getModuleDataCacheDurationMillis() {
        if (this.moduleDataCacheDurationMillis == 0) {
            this.moduleDataCacheDurationMillis = this.moduleDataCacheDuration * C5863b6.g.f26453g;
        }
        return this.moduleDataCacheDurationMillis;
    }

    public long getSdcardCacheDurationMillis() {
        if (this.sdcardCacheDurationMillis == 0) {
            this.sdcardCacheDurationMillis = this.sdcardCacheDuration * C5863b6.g.f26453g;
        }
        return this.sdcardCacheDurationMillis;
    }

    public void setDataCacheDurationMillis(long j10) {
        this.dataCacheDurationMillis = j10;
    }

    public void setModuleDataCacheDurationMillis(long j10) {
        this.moduleDataCacheDurationMillis = j10;
    }

    public void setSdcardCacheDurationMillis(long j10) {
        this.sdcardCacheDurationMillis = j10;
    }

    public String toString() {
        return "AppBackupDurationInfo{dataCacheDuration=" + this.dataCacheDuration + ", sdcardCacheDuration=" + this.sdcardCacheDuration + ", moudleDataCacheDuration=" + this.moduleDataCacheDuration + '}';
    }
}
