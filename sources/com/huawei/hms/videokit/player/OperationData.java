package com.huawei.hms.videokit.player;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class OperationData implements Parcelable {
    public static final Parcelable.Creator<OperationData> CREATOR = new C6531a();

    /* renamed from: a */
    private String f30240a;

    /* renamed from: b */
    private int f30241b;

    /* renamed from: c */
    private long f30242c;

    /* renamed from: d */
    private long f30243d;

    /* renamed from: e */
    private String f30244e;

    /* renamed from: com.huawei.hms.videokit.player.OperationData$a */
    public class C6531a implements Parcelable.Creator<OperationData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OperationData createFromParcel(Parcel parcel) {
            return new OperationData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OperationData[] newArray(int i10) {
            return new OperationData[i10];
        }
    }

    public OperationData() {
    }

    public OperationData(Parcel parcel) {
        this.f30240a = parcel.readString();
        this.f30241b = parcel.readInt();
        this.f30242c = parcel.readLong();
        this.f30243d = parcel.readLong();
        this.f30244e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getApiName() {
        return this.f30240a;
    }

    public long getCallTime() {
        return this.f30243d;
    }

    public long getCostTime() {
        return this.f30242c;
    }

    public int getResult() {
        return this.f30241b;
    }

    public String getUuid() {
        return this.f30244e;
    }

    public void setApiName(String str) {
        this.f30240a = str;
    }

    public void setCallTime(long j10) {
        this.f30243d = j10;
    }

    public void setCostTime(long j10) {
        this.f30242c = j10;
    }

    public void setResult(int i10) {
        this.f30241b = i10;
    }

    public void setUuid(String str) {
        this.f30244e = str;
    }

    public String toString() {
        return "apiName:" + this.f30240a + ",result:" + this.f30241b + ",costTime:" + this.f30242c + ",callTime:" + this.f30243d + ",uuid:" + this.f30244e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f30240a);
        parcel.writeInt(this.f30241b);
        parcel.writeLong(this.f30242c);
        parcel.writeLong(this.f30243d);
        parcel.writeString(this.f30244e);
    }
}
