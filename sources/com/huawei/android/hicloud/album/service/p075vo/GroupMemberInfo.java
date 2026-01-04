package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class GroupMemberInfo implements Parcelable {
    public static final Parcelable.Creator<GroupMemberInfo> CREATOR = new Parcelable.Creator<GroupMemberInfo>() { // from class: com.huawei.android.hicloud.album.service.vo.GroupMemberInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberInfo createFromParcel(Parcel parcel) {
            return new GroupMemberInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberInfo[] newArray(int i10) {
            return new GroupMemberInfo[i10];
        }
    };
    private String displayName;
    private String imagePath;
    private String joinTime;
    private long userId;

    public GroupMemberInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public String getJoinTime() {
        return this.joinTime;
    }

    public long getUserID() {
        return this.userId;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public void setJoinTime(String str) {
        this.joinTime = str;
    }

    public void setUserID(long j10) {
        this.userId = j10;
    }

    public String toString() {
        return "GroupMemberInfo{userId=" + this.userId + ", displayName='" + this.displayName + "', imagePath='" + this.imagePath + "', joinTime='" + this.joinTime + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.userId);
        parcel.writeString(this.displayName);
        parcel.writeString(this.imagePath);
        parcel.writeString(this.joinTime);
    }

    public GroupMemberInfo(long j10, String str, String str2, String str3) {
        this.userId = j10;
        this.displayName = str;
        this.imagePath = str2;
        this.joinTime = str3;
    }

    public GroupMemberInfo(Parcel parcel) {
        this.userId = parcel.readLong();
        this.displayName = parcel.readString();
        this.imagePath = parcel.readString();
        this.joinTime = parcel.readString();
    }
}
