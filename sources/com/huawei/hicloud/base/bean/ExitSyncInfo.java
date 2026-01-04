package com.huawei.hicloud.base.bean;

import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
public class ExitSyncInfo {
    private Drawable iconDrawable;
    private String iconText;
    private String syncType;

    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public String getIconText() {
        return this.iconText;
    }

    public String getSyncType() {
        return this.syncType;
    }

    public void setIconDrawable(Drawable drawable) {
        this.iconDrawable = drawable;
    }

    public void setIconText(String str) {
        this.iconText = str;
    }

    public void setSyncType(String str) {
        this.syncType = str;
    }
}
