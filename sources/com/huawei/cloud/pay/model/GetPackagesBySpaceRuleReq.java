package com.huawei.cloud.pay.model;

import p454lj.C11296s;

/* loaded from: classes5.dex */
public class GetPackagesBySpaceRuleReq extends Request {
    private String appId;
    private int channelId;
    private ChannelInfo channelInfo;
    private String clientVer;
    private String features;
    private int hmsVer;
    private int notifyType;
    private int scheme;
    private long spaceNeeded;
    private int triggerType;
    private String version;

    public GetPackagesBySpaceRuleReq(int i10, long j10, int i11, ChannelInfo channelInfo) {
        super("getPackagesBySpaceRule");
        this.triggerType = i10;
        this.spaceNeeded = j10;
        this.notifyType = i11;
        this.clientVer = "6";
        this.version = "4.0";
        this.channelInfo = channelInfo;
        this.hmsVer = C11296s.m67834r();
        this.features = "YY";
    }

    public String getAppId() {
        return this.appId;
    }

    public int getChannalId() {
        return this.channelId;
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

    public int getHmsVer() {
        return this.hmsVer;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public int getScheme() {
        return this.scheme;
    }

    public long getSpaceNeeded() {
        return this.spaceNeeded;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setChannalId(int i10) {
        this.channelId = i10;
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

    public void setHmsVer(int i10) {
        this.hmsVer = i10;
    }

    public void setNotifyType(int i10) {
        this.notifyType = i10;
    }

    public void setScheme(int i10) {
        this.scheme = i10;
    }

    public void setSpaceNeeded(long j10) {
        this.spaceNeeded = j10;
    }

    public void setTriggerType(int i10) {
        this.triggerType = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public GetPackagesBySpaceRuleReq(int i10, long j10, int i11, int i12, String str, ChannelInfo channelInfo) {
        super("getPackagesBySpaceRule");
        this.triggerType = i10;
        this.spaceNeeded = j10;
        this.notifyType = i11;
        this.clientVer = "6";
        this.version = "4.0";
        this.channelId = i12;
        this.appId = str;
        this.channelInfo = channelInfo;
        this.hmsVer = C11296s.m67834r();
        this.features = "Y";
    }
}
