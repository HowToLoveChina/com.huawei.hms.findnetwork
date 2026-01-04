package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class LocalId implements Parcelable {
    public static final Parcelable.Creator<LocalId> CREATOR = new Parcelable.Creator<LocalId>() { // from class: com.huawei.android.hicloud.sync.service.aidl.LocalId.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalId createFromParcel(Parcel parcel) {
            return new LocalId(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalId[] newArray(int i10) {
            return new LocalId[i10];
        }
    };
    private int dirty;

    /* renamed from: id */
    private String f12983id;

    public static Parcelable.Creator<LocalId> getCreator() {
        return CREATOR;
    }

    private void readFromParcel(Parcel parcel) {
        this.f12983id = parcel.readString();
        this.dirty = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDirty() {
        return this.dirty;
    }

    public String getId() {
        return this.f12983id;
    }

    public void setDirty(int i10) {
        this.dirty = i10;
    }

    public void setId(String str) {
        this.f12983id = str;
    }

    public String toString() {
        return "LocalId [id=" + this.f12983id + ", dirty=" + this.dirty + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12983id);
        parcel.writeInt(this.dirty);
    }

    private LocalId(Parcel parcel) {
        readFromParcel(parcel);
    }

    public LocalId() {
    }
}
