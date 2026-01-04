package com.huawei.location.req;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Map;

/* loaded from: classes8.dex */
public class LocationRequestInfo implements IMessageEntity, Parcelable {
    public static final Parcelable.Creator<LocationRequestInfo> CREATOR = new C6803a();

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

    /* renamed from: com.huawei.location.req.LocationRequestInfo$a */
    public class C6803a implements Parcelable.Creator<LocationRequestInfo> {
        @Override // android.os.Parcelable.Creator
        public final LocationRequestInfo createFromParcel(Parcel parcel) {
            return new LocationRequestInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationRequestInfo[] newArray(int i10) {
            return new LocationRequestInfo[i10];
        }
    }

    public LocationRequestInfo() {
    }

    public LocationRequestInfo(Parcel parcel) {
        this.expirationTime = parcel.readLong();
        this.fastestInterval = parcel.readLong();
        this.interval = parcel.readLong();
        this.maxWaitTime = parcel.readLong();
        this.numUpdates = parcel.readInt();
        this.priority = parcel.readInt();
        this.smallestDisplacement = parcel.readFloat();
        this.isFastestIntervalExplicitlySet = parcel.readByte() != 0;
        this.needAddress = parcel.readByte() != 0;
        this.language = parcel.readString();
        this.countryCode = parcel.readString();
    }

    public int deductNumUpdates() {
        int i10 = this.numUpdates - 1;
        this.numUpdates = i10;
        return i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        return this.maxWaitTime;
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

    public boolean isFastestIntervalExplicitlySet() {
        return this.isFastestIntervalExplicitlySet;
    }

    public boolean isValid() {
        int i10 = this.priority;
        return i10 == 200 || i10 == 100 || i10 == 102 || i10 == 104 || i10 == 300 || i10 == 105;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setExpirationTime(long j10) {
        this.expirationTime = j10;
    }

    public void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public void setFastestInterval(long j10) {
        this.fastestInterval = j10;
    }

    public void setFastestIntervalExplicitlySet(boolean z10) {
        this.isFastestIntervalExplicitlySet = z10;
    }

    public void setInterval(long j10) {
        this.interval = j10;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMaxWaitTime(long j10) {
        this.maxWaitTime = j10;
    }

    public void setNeedAddress(boolean z10) {
        this.needAddress = z10;
    }

    public void setNumUpdates(int i10) {
        this.numUpdates = i10;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setSmallestDisplacement(float f10) {
        this.smallestDisplacement = f10;
    }

    public String toString() {
        return "{expirationTime=" + this.expirationTime + ", fastestInterval=" + this.fastestInterval + ", interval=" + this.interval + ", maxWaitTime=" + this.maxWaitTime + ", numUpdates=" + this.numUpdates + ", priority=" + this.priority + ", smallestDisplacement=" + this.smallestDisplacement + ", isFastestIntervalExplicitlySet=" + this.isFastestIntervalExplicitlySet + ", needAddress=" + this.needAddress + ", language='" + this.language + "', countryCode='" + this.countryCode + "', extras=" + this.extras + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.expirationTime);
        parcel.writeLong(this.fastestInterval);
        parcel.writeLong(this.interval);
        parcel.writeLong(this.maxWaitTime);
        parcel.writeInt(this.numUpdates);
        parcel.writeInt(this.priority);
        parcel.writeFloat(this.smallestDisplacement);
        parcel.writeByte(this.isFastestIntervalExplicitlySet ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needAddress ? (byte) 1 : (byte) 0);
        parcel.writeString(this.language);
        parcel.writeString(this.countryCode);
    }
}
