package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareAlbumData extends AbstractShareAlbumData {
    public static final Parcelable.Creator<ShareAlbumData> CREATOR = new Parcelable.Creator<ShareAlbumData>() { // from class: com.huawei.android.hicloud.album.service.vo.ShareAlbumData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareAlbumData createFromParcel(Parcel parcel) {
            return new ShareAlbumData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareAlbumData[] newArray(int i10) {
            return new ShareAlbumData[i10];
        }
    };

    @SerializedName("expand")
    private JsonObject expand;
    private String expandString;
    private int onlyFrdCanBeShared;
    private int photoNum;
    private List<ShareReceiverData> receiverList;

    private void readFromParcel(Parcel parcel) {
        this.shareId = parcel.readString();
        this.ownerId = parcel.readString();
        this.shareName = parcel.readString();
        this.ownerAcc = parcel.readString();
        Parcelable.Creator<ShareReceiverData> creator = ShareReceiverData.CREATOR;
        this.receiverList = parcel.readArrayList(creator.getClass().getClassLoader());
        this.type = parcel.readInt();
        this.countNum = parcel.readInt();
        this.localThumbPath = parcel.readArrayList(creator.getClass().getClassLoader());
        this.resource = parcel.readString();
        this.createTime = parcel.readLong();
        this.source = parcel.readString();
        this.flversion = parcel.readLong();
        this.privilege = parcel.readString();
        if (Version.isSupportQueryDeviceInfoList()) {
            this.expandString = parcel.readString();
        }
        if (Version.isSupportRiskReport()) {
            this.onlyFrdCanBeShared = parcel.readInt();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JsonObject getExpand() {
        return this.expand;
    }

    public String getExpandString() {
        return this.expandString;
    }

    public int getOnlyFrdCanBeShared() {
        return this.onlyFrdCanBeShared;
    }

    public int getPhotoNum() {
        return this.photoNum;
    }

    public List<ShareReceiverData> getReceiverList() {
        return this.receiverList;
    }

    public void setExpand(JsonObject jsonObject) {
        this.expand = jsonObject;
    }

    public void setExpandString(String str) {
        this.expandString = str;
    }

    public void setOnlyFrdCanBeShared(int i10) {
        this.onlyFrdCanBeShared = i10;
    }

    public void setPhotoNum(int i10) {
        this.photoNum = i10;
    }

    public void setReceiverList(List<ShareReceiverData> list) {
        this.receiverList = list;
    }

    public String toString() {
        return "ShareAlbumData{shareId='" + this.shareId + "', ownerId='" + this.ownerId + "', shareName='" + this.shareName + "', ownerAcc='" + this.ownerAcc + "', receiverList=" + this.receiverList + ", type=" + this.type + ", countNum=" + this.countNum + ", photoNum=" + this.photoNum + ", resource='" + this.resource + "', localThumbPath=" + this.localThumbPath + ", createTime=" + this.createTime + ", source='" + this.source + "', privilege='" + this.privilege + "', totalSize=" + this.totalSize + ", flversion=" + this.flversion + ", expandString=" + this.expandString + ", onlyFrdCanBeShared=" + this.onlyFrdCanBeShared + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.shareId);
        parcel.writeString(this.ownerId);
        parcel.writeString(this.shareName);
        parcel.writeString(this.ownerAcc);
        parcel.writeList(this.receiverList);
        parcel.writeInt(this.type);
        parcel.writeInt(this.countNum);
        parcel.writeList(this.localThumbPath);
        parcel.writeString(this.resource);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.source);
        parcel.writeLong(this.flversion);
        parcel.writeString(this.privilege);
        if (Version.isSupportQueryDeviceInfoList()) {
            parcel.writeString(this.expandString);
        }
        if (Version.isSupportRiskReport()) {
            parcel.writeInt(this.onlyFrdCanBeShared);
        }
    }

    public ShareAlbumData() {
    }

    private ShareAlbumData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
