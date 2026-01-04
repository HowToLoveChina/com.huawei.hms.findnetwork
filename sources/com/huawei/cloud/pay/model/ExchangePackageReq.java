package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class ExchangePackageReq extends Request {
    private ChannelInfo channel;
    private long hmsVer;
    private int signMode;

    public ExchangePackageReq(String str, ChannelInfo channelInfo, long j10, int i10) {
        super(str);
        this.channel = channelInfo;
        this.hmsVer = j10;
        this.signMode = i10;
    }

    public ChannelInfo getChannel() {
        return this.channel;
    }

    public long getHmsVer() {
        return this.hmsVer;
    }

    public int getSignMode() {
        return this.signMode;
    }

    public void setChannel(ChannelInfo channelInfo) {
        this.channel = channelInfo;
    }

    public void setHmsVer(long j10) {
        this.hmsVer = j10;
    }

    public void setSignMode(int i10) {
        this.signMode = i10;
    }
}
