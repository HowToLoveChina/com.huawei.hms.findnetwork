package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public abstract class AbstractTagInfo implements Parcelable {
    protected String categoryId;
    protected long createTime;
    protected String ext1;
    protected String faceFileId;
    protected String localPath;
    protected String status;
    protected String tagId;
    protected String tagName;
    protected long version;

    public String getCategoryId() {
        return this.categoryId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getExt1() {
        return this.ext1;
    }

    public String getFaceFileId() {
        return this.faceFileId;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTagId() {
        return this.tagId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public long getVersion() {
        return this.version;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setExt1(String str) {
        this.ext1 = str;
    }

    public void setFaceFileId(String str) {
        this.faceFileId = str;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTagId(String str) {
        this.tagId = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }
}
