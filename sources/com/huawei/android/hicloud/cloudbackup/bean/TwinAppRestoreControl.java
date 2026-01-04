package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class TwinAppRestoreControl {
    private String appId;
    private List<String> effectDevice;
    private String v1OSVersRegex;

    public String getAppId() {
        return this.appId;
    }

    public List<String> getEffectDevice() {
        return this.effectDevice;
    }

    public String getV1OSVersRegex() {
        return this.v1OSVersRegex;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setEffectDevice(List<String> list) {
        this.effectDevice = list;
    }

    public void setV1OSVersRegex(String str) {
        this.v1OSVersRegex = str;
    }

    public String toString() {
        return "TwinAppRestoreControl{appId=" + this.appId + "v1OSVersRegex=" + this.v1OSVersRegex + "effectDevice=" + this.effectDevice + '}';
    }
}
