package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class Etag implements Parcelable {
    public static final Parcelable.Creator<Etag> CREATOR = new Parcelable.Creator<Etag>() { // from class: com.huawei.android.hicloud.sync.service.aidl.Etag.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Etag createFromParcel(Parcel parcel) {
            return new Etag(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Etag[] newArray(int i10) {
            return new Etag[i10];
        }
    };
    private String etag;
    private int operation;
    private int recycleStatus;
    private long recycleTime;
    private int status;
    private String uuid;
    private int version;

    private void readFromParcel(Parcel parcel) {
        this.uuid = parcel.readString();
        this.etag = parcel.readString();
        this.status = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEtag() {
        return this.etag;
    }

    public int getOperation() {
        return this.operation;
    }

    public int getRecycleStatus() {
        return this.recycleStatus;
    }

    public long getRecycleTime() {
        return this.recycleTime;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setOperation(int i10) {
        this.operation = i10;
    }

    public void setRecycleStatus(int i10) {
        this.recycleStatus = i10;
    }

    public void setRecycleTime(long j10) {
        this.recycleTime = j10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVersion(int i10) {
        this.version = i10;
    }

    public String toString() {
        return "[uuid=" + this.uuid + ", etag=" + this.etag + ", status=" + this.status + ", operation= " + this.operation + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.uuid);
        parcel.writeString(this.etag);
        parcel.writeInt(this.status);
        if (this.version >= 101) {
            parcel.writeInt(this.operation);
        }
    }

    private Etag(Parcel parcel) {
        this.version = -1;
        this.uuid = null;
        this.etag = null;
        this.status = -1;
        this.operation = -1;
        readFromParcel(parcel);
    }

    public Etag() {
        this.version = -1;
        this.uuid = null;
        this.etag = null;
        this.status = -1;
        this.operation = -1;
    }
}
