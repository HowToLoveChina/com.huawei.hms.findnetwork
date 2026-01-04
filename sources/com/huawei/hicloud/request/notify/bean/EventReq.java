package com.huawei.hicloud.request.notify.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.bean.NotifyExtend;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class EventReq extends NotifyBaseReq {

    @SerializedName("appId")
    private String appId;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("cfgInstanceId")
    private String cfgInstanceId;

    @SerializedName("cfgKey")
    private String cfgKey;

    @SerializedName("cfgResourceId")
    private int cfgResourceId;

    @SerializedName("countryCode")
    private String countryCode;

    @SerializedName("extend")
    private NotifyExtend extend;

    @SerializedName(FaqConstants.FAQ_MODEL)
    private String model;

    @SerializedName("notifyPurposes")
    private List<String> notifyPurposes;

    @SerializedName(NotifyConstants.Keys.NOTIFY_TYPE)
    private String notifyType;

    @SerializedName("notifyWays")
    private List<NotifyWay> notifyWays;

    @SerializedName("pushToken")
    private String pushToken;

    @SerializedName("userData")
    private String userData;

    @SerializedName(JsbMapKeyNames.H5_USER_ID)
    private String userId;

    public EventReq(String str) {
        super(str);
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCfgInstanceId() {
        return this.cfgInstanceId;
    }

    public String getCfgKey() {
        return this.cfgKey;
    }

    public int getCfgResourceId() {
        return this.cfgResourceId;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public NotifyExtend getExtend() {
        return this.extend;
    }

    public String getModel() {
        return this.model;
    }

    public List<String> getNotifyPurposes() {
        return this.notifyPurposes;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public List<NotifyWay> getNotifyWays() {
        return this.notifyWays;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public String getUserData() {
        return this.userData;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setCfgInstanceId(String str) {
        this.cfgInstanceId = str;
    }

    public void setCfgKey(String str) {
        this.cfgKey = str;
    }

    public void setCfgResourceId(int i10) {
        this.cfgResourceId = i10;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setExtend(NotifyExtend notifyExtend) {
        this.extend = notifyExtend;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setNotifyPurposes(List<String> list) {
        this.notifyPurposes = list;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setNotifyWays(List<NotifyWay> list) {
        this.notifyWays = list;
    }

    public void setPushToken(String str) {
        this.pushToken = str;
    }

    public void setUserData(String str) {
        this.userData = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
