package com.huawei.android.remotecontrol.sharing.bean;

import com.google.gson.Gson;

/* loaded from: classes4.dex */
public class ShareGrantInfo {
    private String receiverUserId;
    private int relationType;
    private String senderDeviceId;
    private String senderDeviceName;
    private String senderDeviceType;
    private String senderIconUrl;
    private String senderName;
    private String senderUserId;
    private long shareEndTime;
    private long shareInterval;
    private long shareStartTime;

    public String getReceiverUserId() {
        return this.receiverUserId;
    }

    public int getRelationType() {
        return this.relationType;
    }

    public String getSenderDeviceId() {
        return this.senderDeviceId;
    }

    public String getSenderDeviceName() {
        return this.senderDeviceName;
    }

    public String getSenderDeviceType() {
        return this.senderDeviceType;
    }

    public String getSenderIconUrl() {
        return this.senderIconUrl;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public String getSenderUserId() {
        return this.senderUserId;
    }

    public long getShareEndTime() {
        return this.shareEndTime;
    }

    public long getShareInterval() {
        return this.shareInterval;
    }

    public long getShareStartTime() {
        return this.shareStartTime;
    }

    public void setReceiverUserId(String str) {
        this.receiverUserId = str;
    }

    public void setRelationType(int i10) {
        this.relationType = i10;
    }

    public void setSenderDeviceId(String str) {
        this.senderDeviceId = str;
    }

    public void setSenderDeviceName(String str) {
        this.senderDeviceName = str;
    }

    public void setSenderDeviceType(String str) {
        this.senderDeviceType = str;
    }

    public void setSenderIconUrl(String str) {
        this.senderIconUrl = str;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public void setSenderUserId(String str) {
        this.senderUserId = str;
    }

    public void setShareEndTime(long j10) {
        this.shareEndTime = j10;
    }

    public void setShareInterval(long j10) {
        this.shareInterval = j10;
    }

    public void setShareStartTime(long j10) {
        this.shareStartTime = j10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
