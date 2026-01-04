package com.huawei.android.hicloud.cloudbackup.model;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class AppBaseInfo {
    private long appApkSize;
    private long appDataSize;
    private boolean appSwitch;
    private boolean isOmConfigAble;
    private String packageName;

    public long getAppApkSize() {
        return this.appApkSize;
    }

    public long getAppDataSize() {
        return this.appDataSize;
    }

    public boolean getAppSwitch() {
        return this.appSwitch;
    }

    public String getPackageName() {
        return TextUtils.isEmpty(this.packageName) ? "" : this.packageName;
    }

    public boolean isOmConfigAble() {
        return this.isOmConfigAble;
    }

    public void setAppApkSize(long j10) {
        this.appApkSize = j10;
    }

    public void setAppDataSize(long j10) {
        this.appDataSize = j10;
    }

    public void setAppSwitch(boolean z10) {
        this.appSwitch = z10;
    }

    public void setOmConfigAble(boolean z10) {
        this.isOmConfigAble = z10;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }
}
