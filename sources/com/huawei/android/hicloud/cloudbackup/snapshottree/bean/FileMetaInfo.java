package com.huawei.android.hicloud.cloudbackup.snapshottree.bean;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class FileMetaInfo {
    String datetaken;
    String filePath;
    long left;
    String pkgName;
    long right;
    long size;

    public String getDatetaken() {
        return TextUtils.isEmpty(this.datetaken) ? "" : this.datetaken;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getLeft() {
        return this.left;
    }

    public String getPkgName() {
        return TextUtils.isEmpty(this.pkgName) ? "" : this.pkgName;
    }

    public long getRight() {
        return this.right;
    }

    public long getSize() {
        return this.size;
    }

    public void setDatetaken(String str) {
        this.datetaken = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setLeft(long j10) {
        this.left = j10;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setRight(long j10) {
        this.right = j10;
    }

    public void setSize(long j10) {
        this.size = j10;
    }
}
