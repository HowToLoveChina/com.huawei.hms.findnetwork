package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class SnsMsg implements IMessageEntity {

    @Packed
    private byte[] appIconData;

    @Packed
    private String appName;

    @Packed
    private boolean checkTargetApp;

    @Packed
    private String description;

    @Packed
    private byte[] linkIconData;

    @Packed
    private String targetAppMarketId;

    @Packed
    private String targetAppPackageName;

    @Packed
    private int targetAppVersionCode;

    @Packed
    private String title;

    @Packed
    private String url;

    @Packed
    private int urlType = 0;

    public byte[] getAppIconData() {
        byte[] bArr = this.appIconData;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public String getAppName() {
        return this.appName;
    }

    public String getDescription() {
        return this.description;
    }

    public byte[] getLinkIconData() {
        byte[] bArr = this.linkIconData;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public String getTargetAppMarketId() {
        return this.targetAppMarketId;
    }

    public String getTargetAppPackageName() {
        return this.targetAppPackageName;
    }

    public int getTargetAppVersionCode() {
        return this.targetAppVersionCode;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUrlType() {
        return this.urlType;
    }

    public boolean isCheckTargetApp() {
        return this.checkTargetApp;
    }

    public void setAppIconData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        this.appIconData = (byte[]) bArr.clone();
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCheckTargetApp(boolean z10) {
        this.checkTargetApp = z10;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLinkIconData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        this.linkIconData = (byte[]) bArr.clone();
    }

    public void setTargetAppMarketId(String str) {
        this.targetAppMarketId = str;
    }

    public void setTargetAppPackageName(String str) {
        this.targetAppPackageName = str;
    }

    public void setTargetAppVersionCode(int i10) {
        this.targetAppVersionCode = i10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUrlType(int i10) {
        this.urlType = i10;
    }
}
