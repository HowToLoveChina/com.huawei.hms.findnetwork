package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class AbstractSmartAlbumInfo implements Parcelable {
    protected List<String> albumList;
    protected String categoryId;
    protected String categoryName;
    protected long createTime;
    protected String hash;
    protected String localPath;
    protected int photoNum;
    protected int tagNum;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<String> getAlbumList() {
        return this.albumList;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getHash() {
        return this.hash;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public int getPhotoNum() {
        return this.photoNum;
    }

    public int getTagNum() {
        return this.tagNum;
    }

    public void readFromParcel(Parcel parcel) {
        this.categoryId = parcel.readString();
        this.categoryName = parcel.readString();
        this.photoNum = parcel.readInt();
        this.tagNum = parcel.readInt();
        this.localPath = parcel.readString();
        this.createTime = parcel.readLong();
        this.hash = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.albumList = arrayList;
        parcel.readList(arrayList, ClassLoader.getSystemClassLoader());
    }

    public void setAlbumList(List<String> list) {
        this.albumList = list;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setPhotoNum(int i10) {
        this.photoNum = i10;
    }

    public void setTagNum(int i10) {
        this.tagNum = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.categoryId);
        parcel.writeString(this.categoryName);
        parcel.writeInt(this.photoNum);
        parcel.writeInt(this.tagNum);
        parcel.writeString(this.localPath);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.hash);
        parcel.writeList(this.albumList);
    }
}
