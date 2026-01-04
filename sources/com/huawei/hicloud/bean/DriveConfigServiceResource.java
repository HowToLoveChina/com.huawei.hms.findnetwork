package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class DriveConfigServiceResource implements Serializable {
    private static final long serialVersionUID = 5509321225347433077L;

    @SerializedName("subDesc")
    private String subDesc;

    @SerializedName("subPageIcon")
    private String subPageIcon;

    @SerializedName("subSwitchDesc")
    private String subSwitchDesc;

    public String getSubDesc() {
        return this.subDesc;
    }

    public String getSubPageIcon() {
        return this.subPageIcon;
    }

    public String getSubSwitchDesc() {
        return this.subSwitchDesc;
    }

    public void setSubDesc(String str) {
        this.subDesc = str;
    }

    public void setSubPageIcon(String str) {
        this.subPageIcon = str;
    }

    public void setSubSwitchDesc(String str) {
        this.subSwitchDesc = str;
    }
}
