package com.huawei.hms.findnetwork.comm.request.result;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.findnetwork.comm.PlainLocation;

/* loaded from: classes8.dex */
public class FindNetworkOfflineLocation extends PlainLocation {

    @SerializedName("broadcastTime")
    private long broadcastTime;

    /* renamed from: sn */
    @SerializedName("sn")
    private String f24749sn;

    public long getBroadcastTime() {
        return this.broadcastTime;
    }

    public String getSn() {
        return this.f24749sn;
    }

    public void setBroadcastTime(long j10) {
        this.broadcastTime = j10;
    }

    public void setSn(String str) {
        this.f24749sn = str;
    }
}
