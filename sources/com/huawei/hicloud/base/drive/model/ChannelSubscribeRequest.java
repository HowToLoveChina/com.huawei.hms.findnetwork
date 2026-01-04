package com.huawei.hicloud.base.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public final class ChannelSubscribeRequest extends C11707b {

    @InterfaceC4648p
    private Long expirationTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22145id;

    @InterfaceC4648p
    private String pushToken;

    @InterfaceC4648p
    private Integer signVersion;

    @InterfaceC4648p
    private String type;

    @InterfaceC4648p
    private String url;

    @InterfaceC4648p
    private String userToken;

    public Long getExpirationTime() {
        return this.expirationTime;
    }

    public String getId() {
        return this.f22145id;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public Integer getSignVersion() {
        return this.signVersion;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserToken() {
        return this.userToken;
    }

    public ChannelSubscribeRequest setExpirationTime(Long l10) {
        this.expirationTime = l10;
        return this;
    }

    public ChannelSubscribeRequest setId(String str) {
        this.f22145id = str;
        return this;
    }

    public ChannelSubscribeRequest setPushToken(String str) {
        this.pushToken = str;
        return this;
    }

    public ChannelSubscribeRequest setSignVersion(Integer num) {
        this.signVersion = num;
        return this;
    }

    public ChannelSubscribeRequest setType(String str) {
        this.type = str;
        return this;
    }

    public ChannelSubscribeRequest setUrl(String str) {
        this.url = str;
        return this;
    }

    public ChannelSubscribeRequest setUserToken(String str) {
        this.userToken = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public ChannelSubscribeRequest set(String str, Object obj) {
        return (ChannelSubscribeRequest) super.set(str, obj);
    }
}
