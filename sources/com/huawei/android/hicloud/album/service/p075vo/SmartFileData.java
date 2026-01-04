package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SmartFileData extends AbstractSmartFileData {
    public static final Parcelable.Creator<SmartFileData> CREATOR = new Parcelable.Creator<SmartFileData>() { // from class: com.huawei.android.hicloud.album.service.vo.SmartFileData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SmartFileData createFromParcel(Parcel parcel) {
            return new SmartFileData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SmartFileData[] newArray(int i10) {
            return new SmartFileData[i10];
        }
    };
    private String orientation;
    private String totalFaceNum;
    private long version;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public String getTotalFaceNum() {
        return this.totalFaceNum;
    }

    public long getVersion() {
        return this.version;
    }

    public void readFromParcel(Parcel parcel) {
        this.hash = parcel.readString();
        this.fileId = parcel.readString();
        this.createTime = parcel.readLong();
        ArrayList arrayList = new ArrayList();
        this.albumList = arrayList;
        parcel.readList(arrayList, ClassLoader.getSystemClassLoader());
        this.tagId = parcel.readString();
        this.categoryId = parcel.readString();
        this.thumbUrl = parcel.readString();
        this.faceId = parcel.readString();
        this.f11650x = parcel.readInt();
        this.f11651y = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.faceFileId = parcel.readString();
        this.version = parcel.readLong();
        this.localThumbPath = parcel.readString();
        this.localBigThumbPath = parcel.readString();
        this.localRealPath = parcel.readString();
        this.nlinks = parcel.readInt();
        this.spConfidence = parcel.readString();
        this.orientation = parcel.readString();
        this.totalFaceNum = parcel.readString();
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setTotalFaceNum(String str) {
        this.totalFaceNum = str;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }

    public String toString() {
        return "SmartFileData{hash='" + this.hash + "', fileId='" + this.fileId + "', createTime=" + this.createTime + ", albumList=" + this.albumList + ", tagId='" + this.tagId + "', categoryId='" + this.categoryId + "', thumbUrl='" + this.thumbUrl + "', faceId='" + this.faceId + "', x=" + this.f11650x + ", y=" + this.f11651y + ", width=" + this.width + ", height=" + this.height + ", faceFileId='" + this.faceFileId + "', version=" + this.version + ", otype='" + this.otype + "', nlinks=" + this.nlinks + ", localThumbPath='" + this.localThumbPath + "', localBigThumbPath='" + this.localBigThumbPath + "', localRealPath='" + this.localRealPath + "', spConfidence='" + this.spConfidence + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.hash);
        parcel.writeString(this.fileId);
        parcel.writeLong(this.createTime);
        parcel.writeList(this.albumList);
        parcel.writeString(this.tagId);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.faceId);
        parcel.writeInt(this.f11650x);
        parcel.writeInt(this.f11651y);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.faceFileId);
        parcel.writeLong(this.version);
        parcel.writeString(this.localThumbPath);
        parcel.writeString(this.localBigThumbPath);
        parcel.writeString(this.localRealPath);
        parcel.writeInt(this.nlinks);
        parcel.writeString(this.spConfidence);
        parcel.writeString(this.orientation);
        parcel.writeString(this.totalFaceNum);
    }

    public SmartFileData() {
    }

    private SmartFileData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
