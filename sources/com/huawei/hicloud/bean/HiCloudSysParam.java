package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class HiCloudSysParam {
    private String date;

    @SerializedName("SystemParameter")
    private HiCloudSysParamMap hiCloudSysParamMap;

    /* renamed from: id */
    private String f22232id;
    private long version;

    public String getDate() {
        return this.date;
    }

    public HiCloudSysParamMap getHiCloudSysParamMap() {
        return this.hiCloudSysParamMap;
    }

    public String getId() {
        return this.f22232id;
    }

    public long getVersion() {
        return this.version;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setHiCloudSysParamMap(HiCloudSysParamMap hiCloudSysParamMap) {
        this.hiCloudSysParamMap = hiCloudSysParamMap;
    }

    public void setId(String str) {
        this.f22232id = str;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }
}
