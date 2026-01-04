package com.huawei.android.remotecontrol.offlinelocate.bean;

/* loaded from: classes4.dex */
public class OfflinePublicKeyInfoBean {
    private Long createTime;
    private String offlinePublicKey;

    public OfflinePublicKeyInfoBean(String str, Long l10) {
        this.offlinePublicKey = str;
        this.createTime = l10;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getOfflinePublicKey() {
        return this.offlinePublicKey;
    }
}
