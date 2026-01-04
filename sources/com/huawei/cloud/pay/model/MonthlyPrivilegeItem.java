package com.huawei.cloud.pay.model;

import android.graphics.Bitmap;

/* loaded from: classes5.dex */
public class MonthlyPrivilegeItem {
    private String privilegeDesc;
    private Bitmap privilegeIcon;
    private String privilegeTag;

    public String getPrivilegeDesc() {
        return this.privilegeDesc;
    }

    public Bitmap getPrivilegeIcon() {
        return this.privilegeIcon;
    }

    public String getPrivilegeTag() {
        return this.privilegeTag;
    }

    public void setPrivilegeDesc(String str) {
        this.privilegeDesc = str;
    }

    public void setPrivilegeIcon(Bitmap bitmap) {
        this.privilegeIcon = bitmap;
    }

    public void setPrivilegeTag(String str) {
        this.privilegeTag = str;
    }
}
