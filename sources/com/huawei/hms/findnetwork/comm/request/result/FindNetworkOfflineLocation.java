package com.huawei.hms.findnetwork.comm.request.result;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.findnetwork.comm.PlainLocation;

/* loaded from: classes8.dex */
public class FindNetworkOfflineLocation extends PlainLocation {

    @SerializedName("broadcastTime")
    private long broadcastTime;

    /* renamed from: sn */
    @SerializedName("sn")
    private String m_sn;

    public long getBroadcastTime() {
        return this.broadcastTime;
    }

    public String getSn() {
        return this.m_sn;
    }

    public void setBroadcastTime(long j10) {
        this.broadcastTime = j10;
    }

    public void setSn(String str) {
        this.m_sn = str;
    }
}
