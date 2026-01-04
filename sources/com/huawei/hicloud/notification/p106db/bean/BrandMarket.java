package com.huawei.hicloud.notification.p106db.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import java.util.List;

/* loaded from: classes6.dex */
public class BrandMarket extends BaseCardBean {

    @SerializedName("activityId")
    private String activityId;

    @SerializedName("activityType")
    private String activityType;
    private boolean adSwitchControl = false;

    @SerializedName(FrequencyManager.H5DialogConstant.BEGIN_TIME)
    private String beginTime;

    @SerializedName("devConditions")
    private String[] devConditions;

    @SerializedName("endTime")
    private String endTime;

    /* renamed from: ka */
    private C4913Ka f22641ka;

    @SerializedName("notifyBar")
    private int notifyBar;

    @SerializedName("params")
    private List<String> params;
    private Pps pps;

    @SerializedName("realtimeParams")
    private List<String> realtimeParams;

    @SerializedName("redDot")
    private int redDot;

    @SerializedName("textGoto")
    private NotifyTypeAndUriGoto textGoto;

    @SerializedName("textLink")
    private String textLink;

    @SerializedName("trigger")
    private String trigger;

    @SerializedName("userGroupExtIDs")
    private String[] userGroupExtIDs;

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public String[] getDevConditions() {
        return this.devConditions;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public C4913Ka getKa() {
        return this.f22641ka;
    }

    public List<String> getParams() {
        return this.params;
    }

    public Pps getPps() {
        return this.pps;
    }

    public List<String> getRealtimeParams() {
        return this.realtimeParams;
    }

    public NotifyTypeAndUriGoto getTextGoto() {
        return this.textGoto;
    }

    public String getTextLink() {
        return this.textLink;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public String[] getUserGroupExtIDs() {
        return this.userGroupExtIDs;
    }

    public boolean isAdSwitchControl() {
        return this.adSwitchControl;
    }

    public boolean isKaCard() {
        if (getNotifyTypeAndUriGoto() != null) {
            return TextUtils.equals(getNotifyTypeAndUriGoto().getNotifyType(), NotifyConstants.HICLOUD_KA);
        }
        return false;
    }

    public boolean isNotifyBar() {
        return this.notifyBar != 0;
    }

    public boolean isPpsCard() {
        if (getNotifyTypeAndUriGoto() != null) {
            return TextUtils.equals(getNotifyTypeAndUriGoto().getNotifyType(), NotifyConstants.HICLOUD_PPS);
        }
        return false;
    }

    public boolean isRedDot() {
        return this.redDot != 0;
    }

    public boolean isTempBackUpCard() {
        if (getNotifyTypeAndUriGoto() != null) {
            return TextUtils.equals(getNotifyTypeAndUriGoto().getNotifyType(), NotifyConstants.TYPE_DEEPLINK) && GeneralRedirectUtil.isTempBackupLink(getNotifyTypeAndUriGoto().getNotifyUri());
        }
        return false;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityType(String str) {
        this.activityType = str;
    }

    public void setAdSwitchControl(boolean z10) {
        this.adSwitchControl = z10;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setDevConditions(String[] strArr) {
        this.devConditions = strArr;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setKa(C4913Ka c4913Ka) {
        this.f22641ka = c4913Ka;
    }

    public void setNotifyBar(int i10) {
        this.notifyBar = i10;
    }

    public void setParams(List<String> list) {
        this.params = list;
    }

    public void setPps(Pps pps) {
        this.pps = pps;
    }

    public void setRealtimeParams(List<String> list) {
        this.realtimeParams = list;
    }

    public void setRedDot(int i10) {
        this.redDot = i10;
    }

    public void setTextGoto(NotifyTypeAndUriGoto notifyTypeAndUriGoto) {
        this.textGoto = notifyTypeAndUriGoto;
    }

    public void setTextLink(String str) {
        this.textLink = str;
    }

    public void setTrigger(String str) {
        this.trigger = str;
    }

    public void setUserGroupExtIDs(String[] strArr) {
        this.userGroupExtIDs = strArr;
    }
}
