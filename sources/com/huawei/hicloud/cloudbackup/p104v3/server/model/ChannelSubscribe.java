package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class ChannelSubscribe extends C11707b {

    @InterfaceC4648p
    private C4644l expirationTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22588id;

    @InterfaceC4648p
    private String pushToken;

    @InterfaceC4648p
    private Integer signVersion;

    @InterfaceC4648p
    private String type;

    public C4644l getExpirationTime() {
        return this.expirationTime;
    }

    public String getId() {
        return this.f22588id;
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

    public ChannelSubscribe setExpirationTime(C4644l c4644l) {
        this.expirationTime = c4644l;
        return this;
    }

    public ChannelSubscribe setId(String str) {
        this.f22588id = str;
        return this;
    }

    public ChannelSubscribe setPushToken(String str) {
        this.pushToken = str;
        return this;
    }

    public ChannelSubscribe setSignVersion(Integer num) {
        this.signVersion = num;
        return this;
    }

    public ChannelSubscribe setType(String str) {
        this.type = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public ChannelSubscribe set(String str, Object obj) {
        return (ChannelSubscribe) super.set(str, obj);
    }
}
