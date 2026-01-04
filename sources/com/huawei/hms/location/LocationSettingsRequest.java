package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes8.dex */
public class LocationSettingsRequest implements IMessageEntity, Parcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new C5683yn();

    @Packed
    public boolean alwaysShow;

    @Packed
    public boolean needBle;

    @Packed
    public List<LocationRequest> requests;

    public static class Builder {
        private List<LocationRequest> requests = new ArrayList();
        private boolean alwaysShow = false;
        private boolean needBle = false;

        public Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            this.requests.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest) {
            this.requests.add(locationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.requests, this.alwaysShow, this.needBle, null);
        }

        public Builder setAlwaysShow(boolean z10) {
            this.alwaysShow = z10;
            return this;
        }

        public Builder setNeedBle(boolean z10) {
            this.needBle = z10;
            return this;
        }
    }

    /* renamed from: com.huawei.hms.location.LocationSettingsRequest$yn */
    public class C5683yn implements Parcelable.Creator<LocationSettingsRequest> {
        @Override // android.os.Parcelable.Creator
        public final LocationSettingsRequest createFromParcel(Parcel parcel) {
            return new LocationSettingsRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationSettingsRequest[] newArray(int i10) {
            return new LocationSettingsRequest[i10];
        }
    }

    private LocationSettingsRequest() {
    }

    public LocationSettingsRequest(Parcel parcel) {
        this.alwaysShow = parcel.readByte() != 0;
        this.needBle = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.requests);
        parcel.writeByte(this.alwaysShow ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needBle ? (byte) 1 : (byte) 0);
    }

    private LocationSettingsRequest(List<LocationRequest> list, boolean z10, boolean z11) {
        this.requests = list;
        this.alwaysShow = z10;
        this.needBle = z11;
    }

    public /* synthetic */ LocationSettingsRequest(List list, boolean z10, boolean z11, C5683yn c5683yn) {
        this(list, z10, z11);
    }
}
