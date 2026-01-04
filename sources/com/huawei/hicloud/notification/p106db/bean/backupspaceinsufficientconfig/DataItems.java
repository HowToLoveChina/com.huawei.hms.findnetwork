package com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;

/* loaded from: classes6.dex */
public class DataItems {

    @SerializedName("bundleName")
    private String bundleName;

    @SerializedName("desc")
    private String desc;
    private String errorDesc;

    @SerializedName("icon")
    private CommonPicture icon;

    @SerializedName("triggerDefine")
    private TriggerDefine triggerDefine;

    public String getBundleName() {
        return this.bundleName;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public CommonPicture getIcon() {
        return this.icon;
    }

    public TriggerDefine getTriggerDefine() {
        return this.triggerDefine;
    }

    public void setBundleName(String str) {
        this.bundleName = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setErrorDesc(String str) {
        this.errorDesc = str;
    }

    public void setIcon(CommonPicture commonPicture) {
        this.icon = commonPicture;
    }

    public void setTriggerDefine(TriggerDefine triggerDefine) {
        this.triggerDefine = triggerDefine;
    }
}
