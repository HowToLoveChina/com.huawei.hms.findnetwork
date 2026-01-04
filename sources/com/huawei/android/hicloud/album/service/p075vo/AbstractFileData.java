package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public abstract class AbstractFileData implements Parcelable {
    protected long addTime;
    protected String ext1;
    protected String ext2;
    protected String ext3;
    private int fileNum;
    protected int fileStatus;
    protected long finishTime;
    protected long sizeProgress;

    public long getAddTime() {
        return this.addTime;
    }

    public String getExt1() {
        return this.ext1;
    }

    public String getExt2() {
        return this.ext2;
    }

    public String getExt3() {
        return this.ext3;
    }

    public int getFileNum() {
        return this.fileNum;
    }

    public int getFileStatus() {
        return this.fileStatus;
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public long getSizeProgress() {
        return this.sizeProgress;
    }

    public void setAddTime(long j10) {
        this.addTime = j10;
    }

    public void setExt1(String str) {
        this.ext1 = str;
    }

    public void setExt2(String str) {
        this.ext2 = str;
    }

    public void setExt3(String str) {
        this.ext3 = str;
    }

    public void setFileNum(int i10) {
        this.fileNum = i10;
    }

    public void setFileStatus(int i10) {
        this.fileStatus = i10;
    }

    public void setFinishTime(long j10) {
        this.finishTime = j10;
    }

    public void setSizeProgress(long j10) {
        this.sizeProgress = j10;
    }
}
