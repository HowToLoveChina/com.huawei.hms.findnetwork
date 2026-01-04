package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class GeneralAlbumData implements Parcelable {
    public static final Parcelable.Creator<GeneralAlbumData> CREATOR = new Parcelable.Creator<GeneralAlbumData>() { // from class: com.huawei.android.hicloud.album.service.vo.GeneralAlbumData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeneralAlbumData createFromParcel(Parcel parcel) {
            return new GeneralAlbumData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeneralAlbumData[] newArray(int i10) {
            return new GeneralAlbumData[i10];
        }
    };
    private String albumId;
    private String albumName;
    private String albumType;
    private long createTime;

    @SerializedName("expand")
    private JsonObject expand;
    private String expandString;
    private int garbage;
    private String lpath;
    private int photoNum;
    private long size;
    private String source;
    private long timeStamp;

    public static String getBundleKey() {
        return "AlbumInfoList";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public String getAlbumType() {
        return this.albumType;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public JsonObject getExpand() {
        return this.expand;
    }

    public String getExpandString() {
        return this.expandString;
    }

    public int getGarbage() {
        return this.garbage;
    }

    public String getLpath() {
        return this.lpath;
    }

    public int getPhotoNum() {
        return this.photoNum;
    }

    public long getSize() {
        return this.size;
    }

    public String getSource() {
        return this.source;
    }

    public long getTimestamp() {
        return this.timeStamp;
    }

    public void readFromParcel(Parcel parcel) {
        this.albumId = parcel.readString();
        this.albumName = parcel.readString();
        this.albumType = parcel.readString();
        this.createTime = parcel.readLong();
        this.photoNum = parcel.readInt();
        this.source = parcel.readString();
        this.size = parcel.readLong();
        this.lpath = parcel.readString();
        this.garbage = parcel.readInt();
        this.expandString = parcel.readString();
        if (Version.isSupportTimeStamp()) {
            this.timeStamp = parcel.readLong();
        }
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setAlbumType(String str) {
        this.albumType = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setExpand(JsonObject jsonObject) {
        this.expand = jsonObject;
    }

    public void setExpandString(String str) {
        this.expandString = str;
    }

    public void setGarbage(int i10) {
        this.garbage = i10;
    }

    public void setLpath(String str) {
        this.lpath = str;
    }

    public void setPhotoNum(int i10) {
        this.photoNum = i10;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTimestamp(long j10) {
        this.timeStamp = j10;
    }

    public String toString() {
        return "GeneralAlbumData{albumId='" + this.albumId + "', albumName='" + this.albumName + "', albumType='" + this.albumType + "', createTime=" + this.createTime + ", photoNum=" + this.photoNum + ", source='" + this.source + "', size=" + this.size + ", lpath='" + this.lpath + "', garbage=" + this.garbage + ", expandString='" + this.expandString + "', timeStamp='" + this.timeStamp + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeString(this.albumType);
        parcel.writeLong(this.createTime);
        parcel.writeInt(this.photoNum);
        parcel.writeString(this.source);
        parcel.writeLong(this.size);
        parcel.writeString(this.lpath);
        parcel.writeInt(this.garbage);
        parcel.writeString(this.expandString);
        if (Version.isSupportTimeStamp()) {
            parcel.writeLong(this.timeStamp);
        }
    }

    public GeneralAlbumData() {
    }

    private GeneralAlbumData(Parcel parcel) {
        readFromParcel(parcel);
    }

    public GeneralAlbumData(GeneralAlbumData generalAlbumData) {
        if (generalAlbumData == null) {
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        generalAlbumData.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        readFromParcel(parcelObtain);
        parcelObtain.recycle();
    }
}
