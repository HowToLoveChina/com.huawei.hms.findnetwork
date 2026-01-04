package com.huawei.hms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class LocationAvailability implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new C5680yn();
    private static final String EXTRA_KEY = "com.huawei.hms.location.EXTRA_LOCATION_AVAILABILITY";
    private static final int LOCATION_STATUS_AVAILABLE = 1000;
    private static final String TAG = "LocationAvailability";

    @Packed
    private int cellStatus;

    @Packed
    private long elapsedRealtimeNs;

    @Packed
    private int locationStatus;

    @Packed
    private int wifiStatus;

    /* renamed from: com.huawei.hms.location.LocationAvailability$yn */
    public class C5680yn implements Parcelable.Creator<LocationAvailability> {
        @Override // android.os.Parcelable.Creator
        public final LocationAvailability createFromParcel(Parcel parcel) {
            return new LocationAvailability(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationAvailability[] newArray(int i10) {
            return new LocationAvailability[i10];
        }
    }

    public LocationAvailability() {
    }

    public LocationAvailability(Parcel parcel) {
        this.cellStatus = parcel.readInt();
        this.wifiStatus = parcel.readInt();
        this.elapsedRealtimeNs = parcel.readLong();
        this.locationStatus = parcel.readInt();
    }

    public static LocationAvailability extractLocationAvailability(Intent intent) {
        try {
            if ((intent.getParcelableExtra(EXTRA_KEY) instanceof LocationAvailability) && hasLocationAvailability(intent)) {
                return (LocationAvailability) intent.getParcelableExtra(EXTRA_KEY);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean hasLocationAvailability(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            return intent.hasExtra(EXTRA_KEY);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.cellStatus == locationAvailability.cellStatus && this.wifiStatus == locationAvailability.wifiStatus && this.elapsedRealtimeNs == locationAvailability.elapsedRealtimeNs && this.locationStatus == locationAvailability.locationStatus;
    }

    public int getCellStatus() {
        return this.cellStatus;
    }

    public long getElapsedRealtimeNs() {
        return this.elapsedRealtimeNs;
    }

    public int getLocationStatus() {
        return this.locationStatus;
    }

    public int getWifiStatus() {
        return this.wifiStatus;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.locationStatus), Integer.valueOf(this.cellStatus), Integer.valueOf(this.wifiStatus), Long.valueOf(this.elapsedRealtimeNs)});
    }

    public boolean isLocationAvailable() {
        return this.locationStatus < 1000;
    }

    public void setCellStatus(int i10) {
        this.cellStatus = i10;
    }

    public void setElapsedRealtimeNs(long j10) {
        this.elapsedRealtimeNs = j10;
    }

    public void setLocationStatus(int i10) {
        this.locationStatus = i10;
    }

    public void setWifiStatus(int i10) {
        this.wifiStatus = i10;
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + isLocationAvailable() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.cellStatus);
        parcel.writeInt(this.wifiStatus);
        parcel.writeLong(this.elapsedRealtimeNs);
        parcel.writeInt(this.locationStatus);
    }
}
