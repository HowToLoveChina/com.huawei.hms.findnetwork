package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class ClearLocalSpace extends CommonCard {

    @SerializedName("localSpace")
    private String localSpace;

    public RomVersion[] getFmRVersions() {
        return getrVersions();
    }

    public String getLocalSpace() {
        return this.localSpace;
    }

    public void setFmRVersions(RomVersion[] romVersionArr) {
        setrVersions(romVersionArr);
    }

    public void setLocalSpace(String str) {
        this.localSpace = str;
    }
}
