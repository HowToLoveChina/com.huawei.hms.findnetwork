package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class Stat implements Parcelable {
    public static final Parcelable.Creator<Stat> CREATOR = new Parcelable.Creator<Stat>() { // from class: com.huawei.android.hicloud.album.service.vo.Stat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Stat createFromParcel(Parcel parcel) {
            return new Stat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Stat[] newArray(int i10) {
            return new Stat[i10];
        }
    };
    private int localAdded = -1;
    private int localUpdated = -1;
    private int localRecycleUpdated = -1;
    private int cloudNormal = -1;
    private int cloudRecycle = -1;
    private long disconnectedTime = -1;
    private String sessionID = "";

    public Stat() {
    }

    private void readFromParcel(Parcel parcel) {
        this.localAdded = parcel.readInt();
        this.localUpdated = parcel.readInt();
        this.localRecycleUpdated = parcel.readInt();
        this.cloudNormal = parcel.readInt();
        this.cloudRecycle = parcel.readInt();
        this.disconnectedTime = parcel.readLong();
        this.sessionID = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCloudNormal() {
        return this.cloudNormal;
    }

    public int getCloudRecycle() {
        return this.cloudRecycle;
    }

    public long getDisconnectedTime() {
        return this.disconnectedTime;
    }

    public int getLocalAdded() {
        return this.localAdded;
    }

    public int getLocalRecycleUpdated() {
        return this.localRecycleUpdated;
    }

    public int getLocalUpdated() {
        return this.localUpdated;
    }

    public String getSessionId() {
        return this.sessionID;
    }

    public void setCloudNormal(int i10) {
        this.cloudNormal = i10;
    }

    public void setCloudRecycle(int i10) {
        this.cloudRecycle = i10;
    }

    public void setDisconnectedTime(long j10) {
        this.disconnectedTime = j10;
    }

    public void setLocalAdded(int i10) {
        this.localAdded = i10;
    }

    public void setLocalRecycleUpdated(int i10) {
        this.localRecycleUpdated = i10;
    }

    public void setLocalUpdated(int i10) {
        this.localUpdated = i10;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public String toString() {
        return "Stat{localAdded=" + this.localAdded + ", localUpdated=" + this.localUpdated + ", localRecycleUpdated=" + this.localRecycleUpdated + ", cloudNormal=" + this.cloudNormal + ", cloudRecycle=" + this.cloudRecycle + ", disconnectedTime=" + this.disconnectedTime + ", sessionID=" + this.sessionID + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.localAdded);
        parcel.writeInt(this.localUpdated);
        parcel.writeInt(this.localRecycleUpdated);
        parcel.writeInt(this.cloudNormal);
        parcel.writeInt(this.cloudRecycle);
        parcel.writeLong(this.disconnectedTime);
        parcel.writeString(this.sessionID);
    }

    public Stat(Parcel parcel) {
        readFromParcel(parcel);
    }
}
