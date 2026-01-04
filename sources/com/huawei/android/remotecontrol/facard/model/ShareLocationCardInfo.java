package com.huawei.android.remotecontrol.facard.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;

/* loaded from: classes4.dex */
public class ShareLocationCardInfo {

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("relationType")
    private Integer relationType;

    @SerializedName("senderDeviceType")
    private String senderDeviceType;

    @SerializedName("senderUserId")
    private String senderUserId;

    @SerializedName(HwPayConstant.KEY_USER_NAME)
    private String userName;

    public String getDeviceId() {
        return this.deviceId;
    }

    public Integer getRelationType() {
        return this.relationType;
    }

    public String getSenderDeviceType() {
        return this.senderDeviceType;
    }

    public String getSenderUserId() {
        return this.senderUserId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setRelationType(Integer num) {
        this.relationType = num;
    }

    public void setSenderDeviceType(String str) {
        this.senderDeviceType = str;
    }

    public void setSenderUserId(String str) {
        this.senderUserId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
