package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetAvailableGradePackagesReq extends Request {
    private ChannelInfo channelInfo;
    private String clientVer;
    private String features;
    private Filter filter;
    private String hmsVer;
    private long spaceNeeded;
    private String voucherCode;

    public GetAvailableGradePackagesReq(String str, Filter filter, String str2, ChannelInfo channelInfo, String str3) {
        super(str);
        this.clientVer = "3";
        this.filter = filter;
        this.voucherCode = str2;
        this.channelInfo = channelInfo;
        this.hmsVer = str3;
        this.features = "YY";
    }

    public ChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public String getClientVer() {
        return this.clientVer;
    }

    public String getFeatures() {
        return this.features;
    }

    public String getHmsVer() {
        return this.hmsVer;
    }

    public long getSpaceNeeded() {
        return this.spaceNeeded;
    }

    public String getmCouponCode() {
        return this.voucherCode;
    }

    public Filter getmFilter() {
        return this.filter;
    }

    public void setChannelInfo(ChannelInfo channelInfo) {
        this.channelInfo = channelInfo;
    }

    public void setClientVer(String str) {
        this.clientVer = str;
    }

    public void setFeatures(String str) {
        this.features = str;
    }

    public void setHmsVer(String str) {
        this.hmsVer = str;
    }

    public void setSpaceNeeded(long j10) {
        this.spaceNeeded = j10;
    }

    public void setmCouponCode(String str) {
        this.voucherCode = str;
    }

    public void setmFilter(Filter filter) {
        this.filter = filter;
    }
}
