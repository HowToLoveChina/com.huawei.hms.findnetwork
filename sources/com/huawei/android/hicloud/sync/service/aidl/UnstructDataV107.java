package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class UnstructDataV107 implements Parcelable {
    public static final Parcelable.Creator<UnstructDataV107> CREATOR = new Parcelable.Creator<UnstructDataV107>() { // from class: com.huawei.android.hicloud.sync.service.aidl.UnstructDataV107.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnstructDataV107 createFromParcel(Parcel parcel) {
            return new UnstructDataV107(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnstructDataV107[] newArray(int i10) {
            return new UnstructDataV107[i10];
        }
    };
    private String hash;

    /* renamed from: id */
    private String f12985id;
    private String name;
    private int optType;
    private String unstructUuid;
    private int version;

    private void readFromParcel(Parcel parcel) {
        this.version = parcel.readInt();
        this.f12985id = parcel.readString();
        this.unstructUuid = parcel.readString();
        this.name = parcel.readString();
        this.hash = parcel.readString();
        this.optType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHash() {
        return this.hash;
    }

    public String getId() {
        return this.f12985id;
    }

    public String getName() {
        return this.name;
    }

    public int getOptType() {
        return this.optType;
    }

    public String getUnstructUuid() {
        return this.unstructUuid;
    }

    public int getVersion() {
        return this.version;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setId(String str) {
        this.f12985id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOptType(int i10) {
        this.optType = i10;
    }

    public void setUnstructUuid(String str) {
        this.unstructUuid = str;
    }

    public void setVersion(int i10) {
        this.version = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.version);
        parcel.writeString(this.f12985id);
        parcel.writeString(this.unstructUuid);
        parcel.writeString(this.name);
        parcel.writeString(this.hash);
        parcel.writeInt(this.optType);
    }

    private UnstructDataV107(Parcel parcel) {
        this.optType = 0;
        readFromParcel(parcel);
    }
}
