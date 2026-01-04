package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes3.dex */
public class ParcelableMap<k, t> implements Parcelable {
    public static final Parcelable.Creator<ParcelableMap> CREATOR = new Parcelable.Creator<ParcelableMap>() { // from class: com.huawei.android.hicloud.sync.service.aidl.ParcelableMap.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMap createFromParcel(Parcel parcel) {
            return new ParcelableMap(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMap[] newArray(int i10) {
            return new ParcelableMap[i10];
        }
    };
    private static final String TAG = "ParcelableMap";
    private Map<k, t> map;

    private void readFromParcel(Parcel parcel) {
        this.map = parcel.readHashMap(ParcelableMap.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<k, t> getMap() {
        return this.map;
    }

    public void setMap(Map<k, t> map) {
        this.map = map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeMap(this.map);
    }

    private ParcelableMap(Parcel parcel) {
        readFromParcel(parcel);
    }

    public ParcelableMap() {
    }
}
