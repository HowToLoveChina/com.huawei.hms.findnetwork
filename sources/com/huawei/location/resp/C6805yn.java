package com.huawei.location.resp;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.huawei.location.resp.yn */
/* loaded from: classes8.dex */
public final class C6805yn implements Parcelable {
    public static final Parcelable.Creator<C6805yn> CREATOR = new a();

    /* renamed from: a */
    public Location f31396a;

    /* renamed from: com.huawei.location.resp.yn$a */
    public class a implements Parcelable.Creator<C6805yn> {
        @Override // android.os.Parcelable.Creator
        public final C6805yn createFromParcel(Parcel parcel) {
            return new C6805yn(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final C6805yn[] newArray(int i10) {
            return new C6805yn[i10];
        }
    }

    public C6805yn() {
    }

    public C6805yn(Location location) {
        this.f31396a = location;
    }

    /* renamed from: a */
    public final Location m38490a() {
        return this.f31396a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        Location location = this.f31396a;
        if (location != null) {
            String provider = location.getProvider();
            if (provider == null) {
                provider = "";
            }
            parcel.writeString(provider);
            parcel.writeLong(this.f31396a.getTime());
            parcel.writeLong(this.f31396a.getElapsedRealtimeNanos());
            parcel.writeByte((byte) 0);
            parcel.writeDouble(this.f31396a.getLatitude());
            parcel.writeDouble(this.f31396a.getLongitude());
            parcel.writeDouble(this.f31396a.getAltitude());
            parcel.writeFloat(this.f31396a.getSpeed());
            parcel.writeFloat(this.f31396a.getBearing());
            parcel.writeFloat(this.f31396a.getAccuracy());
            parcel.writeFloat(this.f31396a.getVerticalAccuracyMeters());
            parcel.writeFloat(this.f31396a.getSpeedAccuracyMetersPerSecond());
            parcel.writeFloat(this.f31396a.getBearingAccuracyDegrees());
            parcel.writeBundle(this.f31396a.getExtras());
        }
    }

    public C6805yn(Parcel parcel) {
        if (this.f31396a == null) {
            this.f31396a = new Location(parcel.readString());
        }
        this.f31396a.setTime(parcel.readLong());
        this.f31396a.setElapsedRealtimeNanos(parcel.readLong());
        parcel.readByte();
        this.f31396a.setLatitude(parcel.readDouble());
        this.f31396a.setLongitude(parcel.readDouble());
        this.f31396a.setAltitude(parcel.readDouble());
        this.f31396a.setSpeed(parcel.readFloat());
        this.f31396a.setBearing(parcel.readFloat());
        this.f31396a.setAccuracy(parcel.readFloat());
        this.f31396a.setVerticalAccuracyMeters(parcel.readFloat());
        this.f31396a.setSpeedAccuracyMetersPerSecond(parcel.readFloat());
        this.f31396a.setBearingAccuracyDegrees(parcel.readFloat());
        this.f31396a.setExtras(parcel.readBundle(C6805yn.class.getClassLoader()));
    }
}
