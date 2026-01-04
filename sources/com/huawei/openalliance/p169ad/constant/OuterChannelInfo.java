package com.huawei.openalliance.p169ad.constant;

import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public class OuterChannelInfo {
    public static final String CHANNEL_ID = "channelId";
    public static final String CHANNEL_INFO = "channelInfo";

    @InterfaceC6929a
    private String channelInfo;

    @InterfaceC6929a
    private long clickTimestamp;

    @InterfaceC6929a
    private long installTimestamp;

    public OuterChannelInfo() {
        this.installTimestamp = -1L;
        this.clickTimestamp = -1L;
    }

    public String getChannelInfo() {
        return this.channelInfo;
    }

    public long getClickTimestamp() {
        return this.clickTimestamp;
    }

    public long getInstallTimestamp() {
        return this.installTimestamp;
    }

    public void setChannelInfo(String str) {
        this.channelInfo = str;
    }

    public void setClickTimestamp(long j10) {
        this.clickTimestamp = j10;
    }

    public void setInstallTimestamp(long j10) {
        this.installTimestamp = j10;
    }

    public OuterChannelInfo(String str, long j10, long j11) {
        this.channelInfo = str;
        this.clickTimestamp = j10;
        this.installTimestamp = j11;
    }
}
