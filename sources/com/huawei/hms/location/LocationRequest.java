package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.location.C6769i;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes8.dex */
public class LocationRequest implements IMessageEntity, Parcelable {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    public static final Parcelable.Creator<LocationRequest> CREATOR = new C5681yn();
    private static final double FASTEST_INTERVAL_FACTOR = 6.0d;
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HD_ACCURACY = 200;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_HIGH_ACCURACY_AND_INDOOR = 400;
    public static final int PRIORITY_INDOOR = 300;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_MAG_POSITION = 301;
    public static final int PRIORITY_NO_POWER = 105;

    @Packed
    private int coordinateType;

    @Packed
    private String countryCode;

    @Packed
    private long expirationTime;

    @Packed
    private Map<String, String> extras;

    @Packed
    private long fastestInterval;

    @Packed
    private long interval;

    @Packed
    private boolean isFastestIntervalExplicitlySet;

    @Packed
    private String language;

    @Packed
    private long maxWaitTime;

    @Packed
    private boolean needAddress;

    @Packed
    private int numUpdates;

    @Packed
    private int priority;

    @Packed
    private float smallestDisplacement;

    /* renamed from: com.huawei.hms.location.LocationRequest$yn */
    public class C5681yn implements Parcelable.Creator<LocationRequest> {
        @Override // android.os.Parcelable.Creator
        public final LocationRequest createFromParcel(Parcel parcel) {
            return new LocationRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationRequest[] newArray(int i10) {
            return new LocationRequest[i10];
        }
    }

    public LocationRequest() {
        this.priority = 102;
        this.interval = C5863b6.g.f26453g;
        this.fastestInterval = (long) (C5863b6.g.f26453g / FASTEST_INTERVAL_FACTOR);
        this.isFastestIntervalExplicitlySet = false;
        this.expirationTime = Long.MAX_VALUE;
        this.numUpdates = Integer.MAX_VALUE;
        this.smallestDisplacement = 0.0f;
        this.maxWaitTime = 0L;
        this.needAddress = false;
        this.language = "";
        this.countryCode = "";
        this.coordinateType = 0;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationRequest locationRequest = obj instanceof LocationRequest ? (LocationRequest) obj : null;
        if (locationRequest == null) {
            return false;
        }
        boolean z10 = this.expirationTime == locationRequest.expirationTime && this.isFastestIntervalExplicitlySet == locationRequest.isFastestIntervalExplicitlySet && this.fastestInterval == locationRequest.fastestInterval && this.interval == locationRequest.interval && this.maxWaitTime == locationRequest.maxWaitTime && this.numUpdates == locationRequest.numUpdates && this.priority == locationRequest.priority && this.needAddress == locationRequest.needAddress && Float.compare(this.smallestDisplacement, locationRequest.smallestDisplacement) == 0 && this.coordinateType == locationRequest.coordinateType;
        String str3 = this.language;
        boolean z11 = str3 != null && (str2 = locationRequest.language) != null && z10 && str3.equals(str2);
        String str4 = this.countryCode;
        return str4 != null && (str = locationRequest.countryCode) != null && z11 && str4.equals(str);
    }

    public int getCoordinateType() {
        return this.coordinateType;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public long getExpirationTime() {
        return this.expirationTime;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public long getFastestInterval() {
        return this.fastestInterval;
    }

    public long getInterval() {
        return this.interval;
    }

    public String getLanguage() {
        return this.language;
    }

    public long getMaxWaitTime() {
        long j10 = this.maxWaitTime;
        long j11 = this.interval;
        return j10 < j11 ? j11 : j10;
    }

    public boolean getNeedAddress() {
        return this.needAddress;
    }

    public int getNumUpdates() {
        return this.numUpdates;
    }

    public int getPriority() {
        return this.priority;
    }

    public float getSmallestDisplacement() {
        return this.smallestDisplacement;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.priority), Long.valueOf(this.interval), Long.valueOf(this.fastestInterval), Boolean.valueOf(this.isFastestIntervalExplicitlySet), Long.valueOf(this.expirationTime), Integer.valueOf(this.numUpdates), Float.valueOf(this.smallestDisplacement), Long.valueOf(this.maxWaitTime), Boolean.valueOf(this.needAddress), this.language, this.countryCode, Integer.valueOf(this.coordinateType));
    }

    public boolean isFastestIntervalExplicitlySet() {
        return this.isFastestIntervalExplicitlySet;
    }

    public void putExtras(String str, String str2) {
        if (this.extras == null) {
            this.extras = new HashMap();
        }
        this.extras.put(str, str2);
    }

    public LocationRequest setCoordinateType(int i10) {
        this.coordinateType = i10;
        return this;
    }

    public LocationRequest setCountryCode(String str) {
        this.countryCode = str;
        return this;
    }

    public LocationRequest setExpirationDuration(long j10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = j10 <= Long.MAX_VALUE - jElapsedRealtime ? j10 + jElapsedRealtime : Long.MAX_VALUE;
        this.expirationTime = j11;
        if (j11 < 0) {
            j11 = 0;
        }
        this.expirationTime = j11;
        return this;
    }

    public LocationRequest setExpirationTime(long j10) {
        if (j10 < 0) {
            j10 = 0;
        }
        this.expirationTime = j10;
        return this;
    }

    public LocationRequest setFastestInterval(long j10) throws IllegalArgumentException {
        if (j10 < 0) {
            throw new IllegalArgumentException("FastestInterval is invalid");
        }
        this.isFastestIntervalExplicitlySet = true;
        this.fastestInterval = j10;
        return this;
    }

    public LocationRequest setInterval(long j10) throws IllegalArgumentException {
        if (j10 < 0) {
            throw new IllegalArgumentException("interval is invalid");
        }
        this.interval = j10;
        this.fastestInterval = this.isFastestIntervalExplicitlySet ? this.fastestInterval : (long) (j10 / FASTEST_INTERVAL_FACTOR);
        return this;
    }

    public LocationRequest setLanguage(String str) {
        this.language = str;
        return this;
    }

    public LocationRequest setMaxWaitTime(long j10) {
        if (SystemClock.uptimeMillis() + j10 < 0) {
            throw new IllegalArgumentException("maxWaitTime value is out of system time,is invalid");
        }
        this.maxWaitTime = j10;
        return this;
    }

    public LocationRequest setNeedAddress(boolean z10) {
        this.needAddress = z10;
        return this;
    }

    public LocationRequest setNumUpdates(int i10) throws IllegalArgumentException {
        if (i10 <= 0) {
            throw new IllegalArgumentException("numUpdates is invalid");
        }
        this.numUpdates = i10;
        return this;
    }

    public LocationRequest setPriority(int i10) {
        if (i10 != 102 && i10 != 100 && i10 != 104 && i10 != 105 && i10 != 200 && i10 != 300 && i10 != 400 && i10 != 301) {
            throw new IllegalArgumentException("priority is not a known constant");
        }
        this.priority = i10;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("smallestDisplacement param invalid");
        }
        this.smallestDisplacement = f10;
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LocationRequest{priority=");
        sb2.append(this.priority);
        sb2.append(", interval=");
        sb2.append(this.interval);
        sb2.append(", fastestInterval=");
        sb2.append(this.fastestInterval);
        sb2.append(", isFastestIntervalExplicitlySet=");
        sb2.append(this.isFastestIntervalExplicitlySet);
        sb2.append(", expirationTime=");
        sb2.append(this.expirationTime);
        sb2.append(", numUpdates=");
        sb2.append(this.numUpdates);
        sb2.append(", smallestDisplacement=");
        sb2.append(this.smallestDisplacement);
        sb2.append(", maxWaitTime=");
        sb2.append(this.maxWaitTime);
        sb2.append(", needAddress=");
        sb2.append(this.needAddress);
        sb2.append(", language=");
        sb2.append(this.language);
        sb2.append(", countryCode=");
        sb2.append(this.countryCode);
        sb2.append(", coordinateType=");
        return C6769i.m38373a(sb2, this.coordinateType, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.priority);
        parcel.writeLong(this.interval);
        parcel.writeLong(this.fastestInterval);
        parcel.writeByte(this.isFastestIntervalExplicitlySet ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.expirationTime);
        parcel.writeInt(this.numUpdates);
        parcel.writeFloat(this.smallestDisplacement);
        parcel.writeLong(this.maxWaitTime);
        parcel.writeByte(this.needAddress ? (byte) 1 : (byte) 0);
        parcel.writeString(this.language);
        parcel.writeString(this.countryCode);
        parcel.writeInt(this.coordinateType);
        parcel.writeMap(this.extras);
    }

    public LocationRequest(Parcel parcel) {
        this.priority = parcel.readInt();
        this.interval = parcel.readLong();
        this.fastestInterval = parcel.readLong();
        this.isFastestIntervalExplicitlySet = parcel.readByte() != 0;
        this.expirationTime = parcel.readLong();
        this.numUpdates = parcel.readInt();
        this.smallestDisplacement = parcel.readFloat();
        this.maxWaitTime = parcel.readLong();
        this.needAddress = parcel.readByte() != 0;
        this.language = parcel.readString();
        this.countryCode = parcel.readString();
        this.coordinateType = parcel.readInt();
        HashMap map = new HashMap();
        this.extras = map;
        parcel.readMap(map, LocationRequest.class.getClassLoader());
    }
}
