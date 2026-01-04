package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class CtagInfo implements Parcelable {
    public static final Parcelable.Creator<CtagInfo> CREATOR = new Parcelable.Creator<CtagInfo>() { // from class: com.huawei.android.hicloud.sync.service.aidl.CtagInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CtagInfo createFromParcel(Parcel parcel) {
            return new CtagInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CtagInfo[] newArray(int i10) {
            return new CtagInfo[i10];
        }
    };
    protected String ctagName;
    protected String ctagValue;
    protected boolean expired;
    protected int status;
    protected String syncToken;

    public static Parcelable.Creator<CtagInfo> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCtagName() {
        return this.ctagName;
    }

    public String getCtagValue() {
        return this.ctagValue;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSyncToken() {
        return this.syncToken;
    }

    public boolean isExpired() {
        return this.expired;
    }

    public void readFromParcel(Parcel parcel) {
        this.ctagName = parcel.readString();
        this.ctagValue = parcel.readString();
        this.status = parcel.readInt();
    }

    public void setCtagName(String str) {
        this.ctagName = str;
    }

    public void setCtagValue(String str) {
        this.ctagValue = str;
    }

    public void setExpired(boolean z10) {
        this.expired = z10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setSyncToken(String str) {
        this.syncToken = str;
    }

    public String toString() {
        return "[name=" + this.ctagName + ", ctag=" + this.ctagValue + ", syncToken=" + this.syncToken + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.ctagName);
        parcel.writeString(this.ctagValue);
        parcel.writeInt(this.status);
    }

    private CtagInfo(Parcel parcel) {
        this.expired = true;
        readFromParcel(parcel);
    }

    public CtagInfo() {
        this.expired = true;
    }
}
