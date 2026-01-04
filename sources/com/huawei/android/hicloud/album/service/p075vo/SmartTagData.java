package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SmartTagData extends AbstractTagInfo {
    public static final Parcelable.Creator<SmartTagData> CREATOR = new Parcelable.Creator<SmartTagData>() { // from class: com.huawei.android.hicloud.album.service.vo.SmartTagData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SmartTagData createFromParcel(Parcel parcel) {
            return new SmartTagData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SmartTagData[] newArray(int i10) {
            return new SmartTagData[i10];
        }
    };
    protected int resultNum;

    private void readFromParcel(Parcel parcel) {
        this.tagId = parcel.readString();
        this.tagName = parcel.readString();
        this.createTime = parcel.readLong();
        this.categoryId = parcel.readString();
        this.faceFileId = parcel.readString();
        this.version = parcel.readLong();
        this.resultNum = parcel.readInt();
        this.localPath = parcel.readString();
        this.ext1 = parcel.readString();
        this.status = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getResultNum() {
        return this.resultNum;
    }

    public void setResultNum(int i10) {
        this.resultNum = i10;
    }

    public String toString() {
        return "SmartTagData{tagId='" + this.tagId + "', tagName='" + this.tagName + "', createTime=" + this.createTime + ", categoryId='" + this.categoryId + "', faceFileId='" + this.faceFileId + "', version=" + this.version + ", resultNum=" + this.resultNum + ", localPath='" + this.localPath + "', status='" + this.status + "', ext1='" + this.ext1 + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.tagId);
        parcel.writeString(this.tagName);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.faceFileId);
        parcel.writeLong(this.version);
        parcel.writeInt(this.resultNum);
        parcel.writeString(this.localPath);
        parcel.writeString(this.ext1);
        parcel.writeString(this.status);
    }

    public SmartTagData() {
    }

    private SmartTagData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
