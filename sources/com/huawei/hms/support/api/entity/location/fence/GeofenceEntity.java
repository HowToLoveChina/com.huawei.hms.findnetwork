package com.huawei.hms.support.api.entity.location.fence;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.Geofence;
import com.huawei.location.C6769i;

/* loaded from: classes8.dex */
public class GeofenceEntity implements Parcelable, Geofence, IMessageEntity {
    private static final int CONVERSIONS_MAX = 7;
    public static final Parcelable.Creator<GeofenceEntity> CREATOR = new C6327yn();
    private static final double DEFAULT_LATITUDE_MAX = 90.0d;
    private static final double DEFAULT_LATITUDE_MIN = -90.0d;
    private static final double DEFAULT_LONGITUDE_MAX = 180.0d;
    private static final double DEFAULT_LONGITUDE_MIN = -180.0d;
    private static final float DEFAULT_RADIUS = 0.0f;
    private static final int DEFAULT_UNIQUE_ID_LENGTH_MAX = 100;

    @Packed
    private int conversions;

    @Packed
    private int dwellDelayTime;

    @Packed
    private double latitude;

    @Packed
    private double longitude;

    @Packed
    private int notificationInterval;

    @Packed
    private float radius;

    @Packed
    private String uniqueId;

    @Packed
    private long validDuration;

    /* renamed from: com.huawei.hms.support.api.entity.location.fence.GeofenceEntity$yn */
    public class C6327yn implements Parcelable.Creator<GeofenceEntity> {
        @Override // android.os.Parcelable.Creator
        public final GeofenceEntity createFromParcel(Parcel parcel) {
            return new GeofenceEntity(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final GeofenceEntity[] newArray(int i10) {
            return new GeofenceEntity[i10];
        }
    }

    private GeofenceEntity(Parcel parcel) {
        this.dwellDelayTime = -1;
        this.uniqueId = parcel.readString();
        this.conversions = parcel.readInt();
        this.validDuration = parcel.readLong();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.radius = parcel.readFloat();
        this.notificationInterval = parcel.readInt();
        this.dwellDelayTime = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.hms.location.Geofence
    public final String getUniqueId() {
        return this.uniqueId;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GeofenceEntity{uniqueId='");
        sb2.append(this.uniqueId);
        sb2.append("', conversions=");
        sb2.append(this.conversions);
        sb2.append(", validDuration=");
        sb2.append(this.validDuration);
        sb2.append(", radius=");
        sb2.append(this.radius);
        sb2.append(", notificationInterval=");
        sb2.append(this.notificationInterval);
        sb2.append(", dwellDelayTime=");
        return C6769i.m38373a(sb2, this.dwellDelayTime, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.uniqueId);
        parcel.writeInt(this.conversions);
        parcel.writeLong(this.validDuration);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeFloat(this.radius);
        parcel.writeInt(this.notificationInterval);
        parcel.writeInt(this.dwellDelayTime);
    }

    public /* synthetic */ GeofenceEntity(Parcel parcel, C6327yn c6327yn) {
        this(parcel);
    }

    public GeofenceEntity(String str, int i10, double d10, double d11, float f10, long j10, int i11, int i12) {
        this.dwellDelayTime = -1;
        if (TextUtils.isEmpty(str) || str.length() > 100) {
            throw new IllegalArgumentException(TextUtils.isEmpty(str) ? "uniqueId is null" : "uniqueId is too long: ".concat(str));
        }
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f10);
        }
        if (d10 > DEFAULT_LATITUDE_MAX || d10 < DEFAULT_LATITUDE_MIN) {
            throw new IllegalArgumentException("invalid latitude");
        }
        if (d11 > DEFAULT_LONGITUDE_MAX || d11 < DEFAULT_LONGITUDE_MIN) {
            throw new IllegalArgumentException("invalid longitude");
        }
        if ((i10 & 7) == 0) {
            throw new IllegalArgumentException("invalid conversions: " + i10);
        }
        this.uniqueId = str;
        this.latitude = d10;
        this.longitude = d11;
        this.radius = f10;
        this.validDuration = j10;
        this.conversions = i10;
        this.notificationInterval = i11;
        this.dwellDelayTime = i12;
    }
}
