package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;

/* loaded from: classes6.dex */
public class HiCloudMsgNoticeBean {

    @SerializedName("actionList")
    private HiCloudMsgNoticeAction[] actionList;

    @SerializedName(RemoteMessageConst.MSGID)
    private String msgId;
    private int priority;
    private int timesOneDay;

    @SerializedName("userGroupExtIDs")
    protected List<String> userGroupExtIDs;

    public HiCloudMsgNoticeAction[] getActionList() {
        return this.actionList;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getTimesOneDay() {
        return this.timesOneDay;
    }

    public void setActionList(HiCloudMsgNoticeAction[] hiCloudMsgNoticeActionArr) {
        this.actionList = hiCloudMsgNoticeActionArr;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setTimesOneDay(int i10) {
        this.timesOneDay = i10;
    }
}
