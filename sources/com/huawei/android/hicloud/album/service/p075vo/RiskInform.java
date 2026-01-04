package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class RiskInform implements Parcelable {
    public static final Parcelable.Creator<RiskInform> CREATOR = new Parcelable.Creator<RiskInform>() { // from class: com.huawei.android.hicloud.album.service.vo.RiskInform.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RiskInform createFromParcel(Parcel parcel) {
            return new RiskInform(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RiskInform[] newArray(int i10) {
            return new RiskInform[i10];
        }
    };
    private String fileID;
    private String label;
    private String ownerId;
    private int scene;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFileID() {
        return this.fileID;
    }

    public String getLabel() {
        return this.label;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public int getScene() {
        return this.scene;
    }

    public void readFromParcel(Parcel parcel) {
        this.fileID = parcel.readString();
        this.ownerId = parcel.readString();
        this.label = parcel.readString();
        this.scene = parcel.readInt();
    }

    public void setFileID(String str) {
        this.fileID = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setScene(int i10) {
        this.scene = i10;
    }

    public String toString() {
        return "RiskInform{fileID=" + this.fileID + ", label=" + this.label + ", scene=" + this.scene + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.fileID);
        parcel.writeString(this.ownerId);
        parcel.writeString(this.label);
        parcel.writeInt(this.scene);
    }

    private RiskInform(Parcel parcel) {
        readFromParcel(parcel);
    }

    public RiskInform() {
    }

    public RiskInform(String str, String str2, String str3, int i10) {
        this.fileID = str;
        this.ownerId = str2;
        this.label = str3;
        this.scene = i10;
    }
}
