package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class Ctag implements Parcelable {
    public static final Parcelable.Creator<Ctag> CREATOR = new Parcelable.Creator<Ctag>() { // from class: com.huawei.android.hicloud.sync.service.aidl.Ctag.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Ctag createFromParcel(Parcel parcel) {
            return new Ctag(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Ctag[] newArray(int i10) {
            return new Ctag[i10];
        }
    };
    private String ctag;
    private boolean expired;
    private int status;
    private String syncToken;
    private int version;

    private void readFromParcel(Parcel parcel) {
        this.ctag = parcel.readString();
        this.status = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCtag() {
        return this.ctag;
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

    public void setCtag(String str) {
        this.ctag = str;
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

    public void setVersion(int i10) {
        this.version = i10;
    }

    public String toString() {
        return "[ctag=" + this.ctag + ", status=" + this.status + ", expired=" + this.expired + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.ctag);
        parcel.writeInt(this.status);
        if (this.version >= 101) {
            parcel.writeByte(this.expired ? (byte) 1 : (byte) 0);
            parcel.writeString(this.syncToken);
        }
    }

    private Ctag(Parcel parcel) {
        this.version = -1;
        this.ctag = null;
        this.status = -1;
        this.expired = true;
        readFromParcel(parcel);
    }

    public Ctag() {
        this.version = -1;
        this.ctag = null;
        this.status = -1;
        this.expired = true;
    }

    public Ctag(String str, int i10, boolean z10, String str2) {
        this.version = -1;
        this.ctag = str;
        this.status = i10;
        this.expired = z10;
        this.syncToken = str2;
    }
}
