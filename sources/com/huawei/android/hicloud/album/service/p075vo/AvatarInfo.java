package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AvatarInfo implements Parcelable {
    public static final Parcelable.Creator<AvatarInfo> CREATOR = new Parcelable.Creator<AvatarInfo>() { // from class: com.huawei.android.hicloud.album.service.vo.AvatarInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AvatarInfo createFromParcel(Parcel parcel) {
            return new AvatarInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AvatarInfo[] newArray(int i10) {
            return new AvatarInfo[i10];
        }
    };
    private String headPictureURL;
    private String nickName;
    private String thirdImageURL;
    private String userId;

    public AvatarInfo(String str) {
        this.userId = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHeadPictureURL() {
        return this.headPictureURL;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getThirdImageURL() {
        return this.thirdImageURL;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setHeadPictureURL(String str) {
        this.headPictureURL = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setThirdImageURL(String str) {
        this.thirdImageURL = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "AvatarInfo{nickName='" + this.nickName + "', headPictureURL='" + this.headPictureURL + "', userId='" + this.userId + "', thirdImageURL='" + this.thirdImageURL + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.nickName);
        parcel.writeString(this.headPictureURL);
        parcel.writeString(this.userId);
        parcel.writeString(this.thirdImageURL);
    }

    public AvatarInfo(Parcel parcel) {
        this.nickName = parcel.readString();
        this.headPictureURL = parcel.readString();
        this.userId = parcel.readString();
        this.thirdImageURL = parcel.readString();
    }
}
