package com.huawei.android.hicloud.cloudbackup.bean;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class ProgressBean implements Serializable {
    private static final long serialVersionUID = -7565305373725469171L;
    private int count;
    private int current;
    private long fileSize;
    private String module;
    private int status;
    private int typeCount;
    private int typeIndex;
    private int uploadSizeProgress;

    public ProgressBean(String str, int i10, int i11, long j10, int i12, int i13) {
        this.module = str;
        this.current = i10;
        this.count = i11;
        this.status = i13;
        this.fileSize = j10;
        this.uploadSizeProgress = i12;
    }

    public int getCount() {
        return this.count;
    }

    public int getCurrent() {
        return this.current;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getModule() {
        return this.module;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTypeCount() {
        return this.typeCount;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public int getUploadSizeProgress() {
        return this.uploadSizeProgress;
    }

    public void setCount(int i10) {
        this.count = i10;
    }

    public void setCurrent(int i10) {
        this.current = i10;
    }

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setTypeCount(int i10) {
        this.typeCount = i10;
    }

    public void setTypeIndex(int i10) {
        this.typeIndex = i10;
    }

    public void setUploadSizeProgress(int i10) {
        this.uploadSizeProgress = i10;
    }

    public ProgressBean(String str, int i10, int i11, int i12) {
        this(str, i10, i11, 0L, 0, i12);
    }
}
