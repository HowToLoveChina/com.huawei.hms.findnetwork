package com.huawei.android.hicloud.commonlib.space;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;

/* loaded from: classes3.dex */
public class QuotaDetail {

    @SerializedName("assetsQuotadSpace")
    private long assetsQuotadSpace;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("kind")
    private String kind;

    @SerializedName("recordsCount")
    private int recordsCount;

    @SerializedName("recordsQuotadSpace")
    private long recordsQuotadSpace;

    @SerializedName(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_SERVICETYPE)
    private long serviceType;

    @SerializedName("statistics")
    private String statistics;

    @SerializedName("trashed")
    private boolean trashed;

    public long getAssetsQuotadSpace() {
        return this.assetsQuotadSpace;
    }

    public String getDetailDeviceID() {
        return this.deviceId;
    }

    public String getKind() {
        return this.kind;
    }

    public int getRecordsCount() {
        return this.recordsCount;
    }

    public long getRecordsQuotadSpace() {
        return this.recordsQuotadSpace;
    }

    public long getServiceType() {
        return this.serviceType;
    }

    public String getStatistics() {
        return this.statistics;
    }

    public boolean isTrashed() {
        return this.trashed;
    }

    public void setAssetsQuotadSpace(long j10) {
        this.assetsQuotadSpace = j10;
    }

    public void setDeviceID(String str) {
        this.deviceId = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setRecordsCount(int i10) {
        this.recordsCount = i10;
    }

    public void setRecordsQuotadSpace(long j10) {
        this.recordsQuotadSpace = j10;
    }

    public void setServiceType(long j10) {
        this.serviceType = j10;
    }

    public void setStatistics(String str) {
        this.statistics = str;
    }

    public void setTrashed(boolean z10) {
        this.trashed = z10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
