package com.huawei.hms.ads.consent.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6935g;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class ConsentSyncReq extends ConsentSyncBase {

    @InterfaceC6929a
    private String accessToken;

    @InterfaceC6935g
    private String deviceId;
    private int deviceIdType;
    private String pkgName;
    private String sdkversion;
    private Long timestamp;

    @OuterVisible
    public ConsentSyncReq(List<String> list, int i10, String str) {
        super(list, i10);
        this.pkgName = str;
    }

    @OuterVisible
    public String getAccessToken() {
        return this.accessToken;
    }

    @OuterVisible
    public String getDeviceId() {
        return this.deviceId;
    }

    @OuterVisible
    public int getDeviceIdType() {
        return this.deviceIdType;
    }

    @OuterVisible
    public String getPkgName() {
        return this.pkgName;
    }

    @OuterVisible
    public String getSdkversion() {
        return this.sdkversion;
    }

    @OuterVisible
    public Long getTimestamp() {
        return this.timestamp;
    }

    @OuterVisible
    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    @OuterVisible
    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    @OuterVisible
    public void setDeviceIdType(int i10) {
        this.deviceIdType = i10;
    }

    @OuterVisible
    public void setPkgName(String str) {
        this.pkgName = str;
    }

    @OuterVisible
    public void setSdkversion(String str) {
        this.sdkversion = str;
    }

    @OuterVisible
    public void setTimestamp(Long l10) {
        this.timestamp = l10;
    }
}
