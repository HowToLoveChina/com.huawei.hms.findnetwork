package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcelable;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class AbstractSmartFileData implements Parcelable {
    protected List<String> albumList;
    protected String categoryId;
    protected long createTime;
    protected String faceFileId;
    protected String faceId;
    protected String fileId;
    protected String hash;
    protected int height;
    protected String localBigThumbPath;
    protected String localRealPath;
    protected String localThumbPath;
    protected int nlinks;
    protected String otype;
    protected String spConfidence;
    protected String tagId;
    protected String thumbUrl;
    protected int width;

    /* renamed from: x */
    protected int f11650x;

    /* renamed from: y */
    protected int f11651y;

    public List<String> getAlbumList() {
        return this.albumList;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFaceFileId() {
        return this.faceFileId;
    }

    public String getFaceId() {
        return this.faceId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getHash() {
        return this.hash;
    }

    public int getHeight() {
        return this.height;
    }

    public String getLocalBigThumbPath() {
        return this.localBigThumbPath;
    }

    public String getLocalRealPath() {
        return this.localRealPath;
    }

    public String getLocalThumbPath() {
        return this.localThumbPath;
    }

    public int getNlinks() {
        return this.nlinks;
    }

    public String getOtype() {
        return this.otype;
    }

    public String getSpConfidence() {
        return this.spConfidence;
    }

    public String getTagId() {
        return this.tagId;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public int getX() {
        return this.f11650x;
    }

    public int getY() {
        return this.f11651y;
    }

    public void setAlbumList(List<String> list) {
        this.albumList = list;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setFaceFileId(String str) {
        this.faceFileId = str;
    }

    public void setFaceId(String str) {
        this.faceId = str;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setLocalBigThumbPath(String str) {
        this.localBigThumbPath = str;
    }

    public void setLocalRealPath(String str) {
        this.localRealPath = str;
    }

    public void setLocalThumbPath(String str) {
        this.localThumbPath = str;
    }

    public void setNlinks(int i10) {
        this.nlinks = i10;
    }

    public void setOtype(String str) {
        this.otype = str;
    }

    public void setSpConfidence(String str) {
        this.spConfidence = str;
    }

    public void setTagId(String str) {
        this.tagId = str;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    public void setX(int i10) {
        this.f11650x = i10;
    }

    public void setY(int i10) {
        this.f11651y = i10;
    }
}
