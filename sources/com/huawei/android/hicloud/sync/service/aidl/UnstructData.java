package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class UnstructData implements Parcelable {
    public static final Parcelable.Creator<UnstructData> CREATOR = new Parcelable.Creator<UnstructData>() { // from class: com.huawei.android.hicloud.sync.service.aidl.UnstructData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnstructData createFromParcel(Parcel parcel) {
            return new UnstructData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnstructData[] newArray(int i10) {
            return new UnstructData[i10];
        }
    };
    protected String hash;

    /* renamed from: id */
    protected String f12984id;
    protected String name;
    protected int optType;
    protected String unstructUuid;
    protected int version;

    public static Parcelable.Creator<UnstructData> getCreator() {
        return CREATOR;
    }

    private void readFromParcel(Parcel parcel) {
        this.f12984id = parcel.readString();
        this.unstructUuid = parcel.readString();
        this.name = parcel.readString();
        this.hash = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHash() {
        return this.hash;
    }

    public String getId() {
        return this.f12984id;
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
        this.f12984id = str;
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

    public String toString() {
        return "UnstructData [name=" + this.name + ", hash=" + this.hash + ", unstruct uuid =" + this.unstructUuid + ", id=" + this.f12984id + ", optType = " + this.optType + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12984id);
        parcel.writeString(this.unstructUuid);
        parcel.writeString(this.name);
        parcel.writeString(this.hash);
    }

    public UnstructData() {
        this.optType = 0;
    }

    public UnstructData(String str, String str2, String str3, String str4, int i10, int i11) {
        this.f12984id = str;
        this.name = str2;
        this.unstructUuid = str3;
        this.hash = str4;
        this.version = i10;
        this.optType = i11;
    }

    private UnstructData(Parcel parcel) {
        this.optType = 0;
        readFromParcel(parcel);
    }
}
