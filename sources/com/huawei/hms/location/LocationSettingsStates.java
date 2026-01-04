package com.huawei.hms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.internal.safeparcel.SafeParcelableSerializer;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class LocationSettingsStates extends AbstractSafeParcelable implements IMessageEntity {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new C5685yn();

    @Packed
    private boolean blePresent;

    @Packed
    private boolean bleUsable;

    @Packed
    private boolean gnssPresent;

    @Packed
    private boolean gnssUsable;

    @Packed
    @Deprecated
    private boolean gpsPresent;

    @Packed
    @Deprecated
    private boolean gpsUsable;

    @Packed
    private boolean hmsLocationPresent;

    @Packed
    private boolean hmsLocationUsable;

    @Packed
    private boolean locationPresent;

    @Packed
    private boolean locationUsable;

    @Packed
    private boolean networkLocationPresent;

    @Packed
    private boolean networkLocationUsable;

    /* renamed from: com.huawei.hms.location.LocationSettingsStates$yn */
    public class C5685yn implements Parcelable.Creator<LocationSettingsStates> {
        @Override // android.os.Parcelable.Creator
        public final LocationSettingsStates createFromParcel(Parcel parcel) {
            return new LocationSettingsStates(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationSettingsStates[] newArray(int i10) {
            return new LocationSettingsStates[i10];
        }
    }

    public LocationSettingsStates() {
        this.hmsLocationUsable = true;
        this.hmsLocationPresent = true;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        LocationSettingsStates locationSettingsStates;
        if (intent != null && (locationSettingsStates = (LocationSettingsStates) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.huawei.hms.location.LOCATION_SETTINGS_STATES", CREATOR)) != null) {
            locationSettingsStates.setGnssUsable(locationSettingsStates.isGpsUsable());
            locationSettingsStates.setGnssPresent(locationSettingsStates.isGpsPresent());
            return locationSettingsStates;
        }
        return new LocationSettingsStates();
    }

    public boolean isBlePresent() {
        return this.blePresent;
    }

    public boolean isBleUsable() {
        return this.bleUsable;
    }

    public boolean isGnssPresent() {
        return this.gnssPresent;
    }

    public boolean isGnssUsable() {
        return this.gnssUsable;
    }

    @Deprecated
    public boolean isGpsPresent() {
        return this.gpsPresent;
    }

    @Deprecated
    public boolean isGpsUsable() {
        return this.gpsUsable;
    }

    public boolean isHMSLocationPresent() {
        return this.hmsLocationPresent;
    }

    public boolean isHMSLocationUsable() {
        return this.hmsLocationUsable;
    }

    public boolean isLocationPresent() {
        return this.locationPresent;
    }

    public boolean isLocationUsable() {
        return this.locationUsable;
    }

    public boolean isNetworkLocationPresent() {
        return this.networkLocationPresent;
    }

    public boolean isNetworkLocationUsable() {
        return this.networkLocationUsable;
    }

    public void setBlePresent(boolean z10) {
        this.blePresent = z10;
    }

    public void setBleUsable(boolean z10) {
        this.bleUsable = z10;
    }

    public void setGnssPresent(boolean z10) {
        this.gnssPresent = z10;
    }

    public void setGnssUsable(boolean z10) {
        this.gnssUsable = z10;
    }

    @Deprecated
    public void setGpsPresent(boolean z10) {
        this.gpsPresent = z10;
    }

    @Deprecated
    public void setGpsUsable(boolean z10) {
        this.gpsUsable = z10;
    }

    public void setHMSLocationPresent(boolean z10) {
        this.hmsLocationPresent = z10;
    }

    public void setHmsLocationUsable(boolean z10) {
        this.hmsLocationUsable = z10;
    }

    public void setLocationPresent(boolean z10) {
        this.locationPresent = z10;
    }

    public void setLocationUsable(boolean z10) {
        this.locationUsable = z10;
    }

    public void setNetworkLocationPresent(boolean z10) {
        this.networkLocationPresent = z10;
    }

    public void setNetworkLocationUsable(boolean z10) {
        this.networkLocationUsable = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isGpsUsable());
        SafeParcelWriter.writeBoolean(parcel, 2, isNetworkLocationUsable());
        SafeParcelWriter.writeBoolean(parcel, 3, isBleUsable());
        SafeParcelWriter.writeBoolean(parcel, 4, isGpsPresent());
        SafeParcelWriter.writeBoolean(parcel, 5, isNetworkLocationPresent());
        SafeParcelWriter.writeBoolean(parcel, 6, isBlePresent());
        SafeParcelWriter.writeBoolean(parcel, 7, isHMSLocationUsable());
        SafeParcelWriter.writeBoolean(parcel, 8, isHMSLocationPresent());
        SafeParcelWriter.writeBoolean(parcel, 9, isGnssUsable());
        SafeParcelWriter.writeBoolean(parcel, 10, isGnssPresent());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public LocationSettingsStates(Parcel parcel) {
        this.hmsLocationUsable = true;
        this.hmsLocationPresent = true;
        this.blePresent = parcel.readByte() != 0;
        this.bleUsable = parcel.readByte() != 0;
        this.gpsPresent = parcel.readByte() != 0;
        this.gpsUsable = parcel.readByte() != 0;
        this.locationPresent = parcel.readByte() != 0;
        this.locationUsable = parcel.readByte() != 0;
        this.networkLocationPresent = parcel.readByte() != 0;
        this.networkLocationUsable = parcel.readByte() != 0;
        this.hmsLocationUsable = parcel.readByte() != 0;
        this.hmsLocationPresent = parcel.readByte() != 0;
        this.gnssUsable = parcel.readByte() != 0;
        this.gnssPresent = parcel.readByte() != 0;
    }

    @Deprecated
    public LocationSettingsStates(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
        this.gpsUsable = z10;
        this.networkLocationUsable = z11;
        this.bleUsable = z12;
        this.gpsPresent = z13;
        this.networkLocationPresent = z14;
        this.blePresent = z15;
        this.hmsLocationUsable = z16;
        this.hmsLocationPresent = z17;
        this.gnssUsable = z10;
        this.gnssPresent = z13;
    }
}
