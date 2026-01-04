package com.huawei.android.p069cg.p072vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.album.service.p075vo.AbstractShareReceiverData;

/* loaded from: classes2.dex */
public class ShareReceiver extends AbstractShareReceiverData {
    public static final Parcelable.Creator<ShareReceiver> CREATOR = new Parcelable.Creator<ShareReceiver>() { // from class: com.huawei.android.cg.vo.ShareReceiver.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareReceiver createFromParcel(Parcel parcel) {
            return new ShareReceiver(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareReceiver[] newArray(int i10) {
            return new ShareReceiver[i10];
        }
    };
    private String permissionId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPermissionId() {
        return this.permissionId;
    }

    public void readFromParcel(Parcel parcel) {
        this.receiverId = parcel.readString();
        this.receiverAcc = parcel.readString();
        this.status = parcel.readInt();
        this.privilege = parcel.readInt();
        this.shareId = parcel.readString();
    }

    public void setPermissionId(String str) {
        this.permissionId = str;
    }

    public String toString() {
        return "ShareReceiver [receiverID=" + this.receiverId + ", receiverAcc=" + this.receiverAcc + ", status=" + this.status + ", privilege=" + this.privilege + ", shareID=" + this.shareId + ", receiverName=" + this.receiverName + ", headPictureLocalPath=" + this.headPictureLocalPath + ", headPictureURL=" + this.headPictureURL + ", lastUpdatePicTime=" + this.lastUpdatePicTime + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.receiverId);
        parcel.writeString(this.receiverAcc);
        parcel.writeInt(this.status);
        parcel.writeInt(this.privilege);
        parcel.writeString(this.shareId);
    }

    public ShareReceiver() {
    }

    private ShareReceiver(Parcel parcel) {
        readFromParcel(parcel);
    }
}
