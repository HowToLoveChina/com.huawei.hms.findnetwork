package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ShareReceiverData extends AbstractShareReceiverData {
    public static final Parcelable.Creator<ShareReceiverData> CREATOR = new Parcelable.Creator<ShareReceiverData>() { // from class: com.huawei.android.hicloud.album.service.vo.ShareReceiverData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareReceiverData createFromParcel(Parcel parcel) {
            return new ShareReceiverData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareReceiverData[] newArray(int i10) {
            return new ShareReceiverData[i10];
        }
    };

    public ShareReceiverData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ShareReceiverData [receiverID=" + this.receiverId + ", receiverAcc=" + this.receiverAcc + ", status=" + this.status + ", privilege=" + this.privilege + ", shareID=" + this.shareId + ", receiverName=" + this.receiverName + ", headPictureLocalPath=" + this.headPictureLocalPath + ", headPictureURL=" + this.headPictureURL + ", lastUpdatePicTime=" + this.lastUpdatePicTime + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.receiverId);
        parcel.writeString(this.receiverAcc);
        parcel.writeInt(this.status);
        parcel.writeInt(this.privilege);
        parcel.writeString(this.shareId);
        parcel.writeString(this.receiverName);
        parcel.writeString(this.headPictureLocalPath);
        parcel.writeString(this.headPictureURL);
        parcel.writeLong(this.lastUpdatePicTime);
    }

    public ShareReceiverData(Parcel parcel) {
        this.receiverId = parcel.readString();
        this.receiverAcc = parcel.readString();
        this.status = parcel.readInt();
        this.privilege = parcel.readInt();
        this.shareId = parcel.readString();
        this.receiverName = parcel.readString();
        this.headPictureLocalPath = parcel.readString();
        this.headPictureURL = parcel.readString();
        this.lastUpdatePicTime = parcel.readLong();
    }
}
