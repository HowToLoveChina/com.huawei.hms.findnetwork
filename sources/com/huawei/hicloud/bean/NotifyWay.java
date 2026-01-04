package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class NotifyWay {
    private String group;
    private boolean hasIcon;
    private String messageId;
    private String msgType;
    private String name;

    @SerializedName("goto")
    private NotifyJumpInfo notifyJumpInfo;
    private String position;
    private String richMsgContent;
    private String smsTemplateId;
    private String text;
    private String title;

    public String getGroup() {
        return this.group;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public String getName() {
        return this.name;
    }

    public NotifyJumpInfo getNotifyJumpInfo() {
        return this.notifyJumpInfo;
    }

    public String getPosition() {
        return this.position;
    }

    public String getRichMsgContent() {
        return this.richMsgContent;
    }

    public String getSmsTemplateId() {
        return this.smsTemplateId;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isHasIcon() {
        return this.hasIcon;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public void setHasIcon(boolean z10) {
        this.hasIcon = z10;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMsgType(String str) {
        this.msgType = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNotifyJumpInfo(NotifyJumpInfo notifyJumpInfo) {
        this.notifyJumpInfo = notifyJumpInfo;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setRichMsgContent(String str) {
        this.richMsgContent = str;
    }

    public void setSmsTemplateId(String str) {
        this.smsTemplateId = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
