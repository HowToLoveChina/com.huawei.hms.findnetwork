package com.huawei.hms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class HwLocationResult implements Parcelable {
    public static final Parcelable.Creator<HwLocationResult> CREATOR = new C5679yn();
    private int code;
    private Location location;
    private String message;

    /* renamed from: com.huawei.hms.location.HwLocationResult$yn */
    public class C5679yn implements Parcelable.Creator<HwLocationResult> {
        @Override // android.os.Parcelable.Creator
        public final HwLocationResult createFromParcel(Parcel parcel) {
            return new HwLocationResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HwLocationResult[] newArray(int i10) {
            return new HwLocationResult[i10];
        }
    }

    public HwLocationResult() {
    }

    public HwLocationResult(int i10, String str) {
        this.code = i10;
        this.message = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeParcelable(this.location, i10);
    }

    public HwLocationResult(int i10, String str, Location location) {
        this.code = i10;
        this.message = str;
        this.location = location;
    }

    public HwLocationResult(Parcel parcel) {
        this.code = parcel.readInt();
        this.message = parcel.readString();
        this.location = (Location) parcel.readParcelable(Location.class.getClassLoader());
    }
}
