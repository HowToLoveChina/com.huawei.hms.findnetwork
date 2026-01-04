package com.huawei.android.p069cg.p072vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.album.service.p075vo.AbstractShareAlbumData;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareInfo extends AbstractShareAlbumData {
    public static final Parcelable.Creator<ShareInfo> CREATOR = new Parcelable.Creator<ShareInfo>() { // from class: com.huawei.android.cg.vo.ShareInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareInfo createFromParcel(Parcel parcel) {
            return new ShareInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareInfo[] newArray(int i10) {
            return new ShareInfo[i10];
        }
    };
    protected List<ShareReceiver> receiverList;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ShareReceiver> getReceiverList() {
        return this.receiverList;
    }

    public void readFromParcel(Parcel parcel) {
        this.shareId = parcel.readString();
        this.ownerId = parcel.readString();
        this.shareName = parcel.readString();
        this.ownerAcc = parcel.readString();
        Parcelable.Creator<ShareReceiver> creator = ShareReceiver.CREATOR;
        this.receiverList = parcel.readArrayList(creator.getClass().getClassLoader());
        this.type = parcel.readInt();
        this.countNum = parcel.readInt();
        this.localThumbPath = parcel.readArrayList(creator.getClass().getClassLoader());
        this.resource = parcel.readString();
        this.createTime = parcel.readLong();
        this.source = parcel.readString();
        this.flversion = parcel.readLong();
        this.iversion = parcel.readInt();
    }

    public void setReceiverList(List<ShareReceiver> list) {
        this.receiverList = list;
    }

    public String toString() {
        return "ShareInfo [shareID=" + this.shareId + ", ownerID=" + this.ownerId + ", shareName=" + this.shareName + ", ownerAcc=" + this.ownerAcc + ", receiverList=" + this.receiverList + ", type=" + this.type + ", countNum=" + this.countNum + ", resource=" + this.resource + ", localThumbPath=" + this.localThumbPath + ", source=" + this.source + ", flversion=" + this.flversion + ", iversion=" + this.iversion + ", privilege=" + this.privilege + ", totalSize=" + this.totalSize + ", deleteFlag=" + this.deleteFlag + "]";
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
        parcel.writeInt(this.iversion);
    }

    public ShareInfo() {
    }

    private ShareInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
