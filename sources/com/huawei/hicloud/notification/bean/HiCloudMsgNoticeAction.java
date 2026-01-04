package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class HiCloudMsgNoticeAction {

    @SerializedName(Constants.CONTENT_SERVER_REALM)
    private int action;

    @SerializedName("addHomepageH5")
    private boolean addHomepageH5;
    private String beginTime;

    @SerializedName("desktopPopup")
    private DeskTopPopup desktopPopup;
    private String endTime;

    /* renamed from: id */
    @SerializedName("id")
    private String f22625id;

    @SerializedName("incentiveScenes")
    private List<String> incentiveScenes;
    private boolean limitNormalUser;
    private int msgIntervalDays;

    @SerializedName("goto")
    private MsgJump msgJump;
    private int muteTimeControl;

    @SerializedName("transEntrance")
    private boolean needShowBadge;

    @SerializedName("notifyBar")
    private NotifyBar notifyBar;

    @SerializedName("params")
    private List<String> params;
    private int periodReminder;

    @SerializedName("picture")
    private String picture;
    private int priority;
    private int readValidityDays;

    @SerializedName("realtimeParams")
    private List<String> realtimeParams;
    private int remainValidityDays;
    private boolean syncMsgCenter;

    @SerializedName("text")
    private String text;

    @SerializedName("title")
    private String title;

    @SerializedName("trigger")
    private String trigger;

    @SerializedName("triggerScope")
    private List<Integer> triggerScope;
    private int triggerofDays;
    private String type;

    @SerializedName("url")
    private String url;
    private int userType;

    public int getAction() {
        return this.action;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public DeskTopPopup getDesktopPopup() {
        return this.desktopPopup;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.f22625id;
    }

    public List<String> getIncentiveScenes() {
        return this.incentiveScenes;
    }

    public int getMsgIntervalDays() {
        return this.msgIntervalDays;
    }

    public MsgJump getMsgJump() {
        return this.msgJump;
    }

    public int getMuteTimeControl() {
        return this.muteTimeControl;
    }

    public NotifyBar getNotifyBar() {
        return this.notifyBar;
    }

    public List<String> getParams() {
        List<String> list = this.params;
        return list == null ? new ArrayList() : list;
    }

    public int getPeriodReminder() {
        return this.periodReminder;
    }

    public String getPicture() {
        return this.picture;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getReadValidityDays() {
        return this.readValidityDays;
    }

    public List<String> getRealTimeParams() {
        List<String> list = this.realtimeParams;
        return list == null ? new ArrayList() : list;
    }

    public int getRemainValidityDays() {
        return this.remainValidityDays;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public List<Integer> getTriggerScope() {
        List<Integer> list = this.triggerScope;
        return list == null ? new ArrayList() : list;
    }

    public int getTriggerofDays() {
        return this.triggerofDays;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUserType() {
        return this.userType;
    }

    public boolean isAddHomepageH5() {
        return this.addHomepageH5;
    }

    public boolean isLimitNormalUser() {
        return this.limitNormalUser;
    }

    public boolean isNeedShowBadge() {
        return this.needShowBadge;
    }

    public boolean isSyncMsgCenter() {
        return this.syncMsgCenter;
    }

    public void setAction(int i10) {
        this.action = i10;
    }

    public void setAddHomepageH5(boolean z10) {
        this.addHomepageH5 = z10;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setDesktopPopup(DeskTopPopup deskTopPopup) {
        this.desktopPopup = deskTopPopup;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setId(String str) {
        this.f22625id = str;
    }

    public void setIncentiveScenes(List<String> list) {
        this.incentiveScenes = list;
    }

    public void setLimitNormalUser(boolean z10) {
        this.limitNormalUser = z10;
    }

    public void setMsgGoto(MsgJump msgJump) {
        this.msgJump = msgJump;
    }

    public void setMsgIntervalDays(int i10) {
        this.msgIntervalDays = i10;
    }

    public void setMuteTimeControl(int i10) {
        this.muteTimeControl = i10;
    }

    public void setNeedShowBadge(boolean z10) {
        this.needShowBadge = z10;
    }

    public void setNotifyBar(NotifyBar notifyBar) {
        this.notifyBar = notifyBar;
    }

    public void setParams(List<String> list) {
        this.params = list;
    }

    public void setPeriodReminder(int i10) {
        this.periodReminder = i10;
    }

    public void setPicture(String str) {
        this.picture = str;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setReadValidityDays(int i10) {
        this.readValidityDays = i10;
    }

    public void setRealTimeParams(List<String> list) {
        this.realtimeParams = list;
    }

    public void setRemainValidityDays(int i10) {
        this.remainValidityDays = i10;
    }

    public void setSyncMsgCenter(boolean z10) {
        this.syncMsgCenter = z10;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTrigger(String str) {
        this.trigger = str;
    }

    public void setTriggerScope(List<Integer> list) {
        this.triggerScope = list;
    }

    public void setTriggerofDays(int i10) {
        this.triggerofDays = i10;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserType(int i10) {
        this.userType = i10;
    }
}
