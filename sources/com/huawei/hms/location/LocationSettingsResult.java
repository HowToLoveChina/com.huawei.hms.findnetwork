package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

/* loaded from: classes8.dex */
public class LocationSettingsResult extends Result implements Parcelable {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new C5684yn();

    @Packed
    private LocationSettingsStates locationSettingsStates;

    @Packed
    private Status status;

    /* renamed from: com.huawei.hms.location.LocationSettingsResult$yn */
    public class C5684yn implements Parcelable.Creator<LocationSettingsResult> {
        @Override // android.os.Parcelable.Creator
        public final LocationSettingsResult createFromParcel(Parcel parcel) {
            return new LocationSettingsResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationSettingsResult[] newArray(int i10) {
            return new LocationSettingsResult[i10];
        }
    }

    public LocationSettingsResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.locationSettingsStates;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public Status getStatus() {
        return this.status;
    }

    public void setLocationSettingsStates(LocationSettingsStates locationSettingsStates) {
        this.locationSettingsStates = locationSettingsStates;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.status, i10);
        parcel.writeParcelable(this.locationSettingsStates, i10);
    }

    public LocationSettingsResult(Parcel parcel) {
        this.status = (Status) parcel.readParcelable(Status.class.getClassLoader());
        this.locationSettingsStates = (LocationSettingsStates) parcel.readParcelable(LocationSettingsStates.class.getClassLoader());
    }
}
