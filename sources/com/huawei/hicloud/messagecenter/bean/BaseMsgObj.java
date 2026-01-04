package com.huawei.hicloud.messagecenter.bean;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class BaseMsgObj implements Serializable {
    protected String agdParameters;
    protected int alreadyRead;
    protected String msgGotoType;
    protected String msgGotoUri;
    protected long notifyTime;
    private int priority;
    protected long readValidityTime;
    protected long remainValidityTime;
    protected String resourceInfo;
    protected String uniqueId;

    public String getAgdParameters() {
        return this.agdParameters;
    }

    public int getAlreadyRead() {
        return this.alreadyRead;
    }

    public String getMsgGotoType() {
        return this.msgGotoType;
    }

    public String getMsgGotoUri() {
        return this.msgGotoUri;
    }

    public long getNotifyTime() {
        return this.notifyTime;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getReadValidityTime() {
        return this.readValidityTime;
    }

    public long getRemainValidityTime() {
        return this.remainValidityTime;
    }

    public String getResourceInfo() {
        return this.resourceInfo;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setAgdParameters(String str) {
        this.agdParameters = str;
    }

    public void setAlreadyRead(int i10) {
        this.alreadyRead = i10;
    }

    public void setMsgGotoType(String str) {
        this.msgGotoType = str;
    }

    public void setMsgGotoUri(String str) {
        this.msgGotoUri = str;
    }

    public void setNotifyTime(long j10) {
        this.notifyTime = j10;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setReadValidityTime(long j10) {
        this.readValidityTime = j10;
    }

    public void setRemainValidityTime(long j10) {
        this.remainValidityTime = j10;
    }

    public void setResourceInfo(String str) {
        this.resourceInfo = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }
}
