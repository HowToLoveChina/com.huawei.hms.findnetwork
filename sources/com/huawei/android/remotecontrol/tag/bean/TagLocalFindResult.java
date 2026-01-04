package com.huawei.android.remotecontrol.tag.bean;

/* loaded from: classes4.dex */
public class TagLocalFindResult {
    protected long currentTime;
    protected String exeResult;
    protected long executeTime;
    protected String info;
    protected String operation;
    protected String tagSn;

    public TagLocalFindResult(String str, String str2, String str3, String str4) {
        this.tagSn = str;
        this.operation = str2;
        this.exeResult = str3;
        this.info = str4;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public String getExeResult() {
        return this.exeResult;
    }

    public long getExecuteTime() {
        return this.executeTime;
    }

    public String getInfo() {
        return this.info;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getTagSn() {
        return this.tagSn;
    }

    public void setCurrentTime(long j10) {
        this.currentTime = j10;
    }

    public void setExecuteTime(long j10) {
        this.executeTime = j10;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    public void setTagSn(String str) {
        this.tagSn = str;
    }
}
