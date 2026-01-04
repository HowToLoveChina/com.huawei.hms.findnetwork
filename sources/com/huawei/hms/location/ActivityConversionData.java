package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class ActivityConversionData implements Parcelable {
    public static final Parcelable.Creator<ActivityConversionData> CREATOR = new C5670yn();
    private int activityType;
    private int conversionType;
    private long elapsedTimeFromReboot;

    /* renamed from: com.huawei.hms.location.ActivityConversionData$yn */
    public class C5670yn implements Parcelable.Creator<ActivityConversionData> {
        @Override // android.os.Parcelable.Creator
        public final ActivityConversionData createFromParcel(Parcel parcel) {
            return new ActivityConversionData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityConversionData[] newArray(int i10) {
            return new ActivityConversionData[0];
        }
    }

    public ActivityConversionData() {
    }

    public ActivityConversionData(int i10, int i11, long j10) {
        if (!ActivityIdentificationData.isValidType(i10) || (i11 != 0 && i11 != 1)) {
            throw new IllegalArgumentException("ActivityConversionData:The parameter is out of range");
        }
        this.activityType = i10;
        this.conversionType = i11;
        this.elapsedTimeFromReboot = j10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityConversionData)) {
            return false;
        }
        ActivityConversionData activityConversionData = (ActivityConversionData) obj;
        return this.activityType == activityConversionData.getActivityType() && this.conversionType == activityConversionData.getConversionType() && this.elapsedTimeFromReboot == activityConversionData.getElapsedTimeFromReboot();
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getConversionType() {
        return this.conversionType;
    }

    public long getElapsedTimeFromReboot() {
        return this.elapsedTimeFromReboot;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "ActivityConversionData{activityType=" + this.activityType + ", conversionType=" + this.conversionType + ", elapsedTimeFromReboot=" + this.elapsedTimeFromReboot + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.conversionType);
        parcel.writeLong(this.elapsedTimeFromReboot);
    }

    private ActivityConversionData(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.conversionType = parcel.readInt();
        this.elapsedTimeFromReboot = parcel.readLong();
    }

    public /* synthetic */ ActivityConversionData(Parcel parcel, C5670yn c5670yn) {
        this(parcel);
    }
}
