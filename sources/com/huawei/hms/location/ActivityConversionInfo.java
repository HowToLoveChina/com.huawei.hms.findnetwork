package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.location.C6769i;

/* loaded from: classes8.dex */
public class ActivityConversionInfo implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityConversionInfo> CREATOR = new C5671yn();
    public static final int ENTER_ACTIVITY_CONVERSION = 0;
    public static final int EXIT_ACTIVITY_CONVERSION = 1;

    @Packed
    private int activityType;

    @Packed
    private int conversionType;

    public static class Builder {
        private int mActivityType = -1;
        private int mConversionType = -1;

        public ActivityConversionInfo build() {
            Preconditions.checkState(this.mActivityType != -1, "ActivityType not set.");
            Preconditions.checkState(this.mConversionType != -1, "ConversionType not set.");
            return new ActivityConversionInfo(this.mActivityType, this.mConversionType);
        }

        public Builder setActivityType(int i10) {
            if (!ActivityIdentificationData.isValidType(i10)) {
                throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
            }
            this.mActivityType = i10;
            return this;
        }

        public Builder setConversionType(int i10) {
            if (i10 != 0 && i10 != 1) {
                throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
            }
            this.mConversionType = i10;
            return this;
        }
    }

    /* renamed from: com.huawei.hms.location.ActivityConversionInfo$yn */
    public class C5671yn implements Parcelable.Creator<ActivityConversionInfo> {
        @Override // android.os.Parcelable.Creator
        public final ActivityConversionInfo createFromParcel(Parcel parcel) {
            return new ActivityConversionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityConversionInfo[] newArray(int i10) {
            return new ActivityConversionInfo[i10];
        }
    }

    public ActivityConversionInfo() {
    }

    public ActivityConversionInfo(int i10, int i11) {
        if (!ActivityIdentificationData.isValidType(i10) || (i11 != 0 && i11 != 1)) {
            throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
        }
        this.activityType = i10;
        this.conversionType = i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return true;
        }
        if (!(obj instanceof ActivityConversionInfo)) {
            return false;
        }
        ActivityConversionInfo activityConversionInfo = (ActivityConversionInfo) obj;
        return this.activityType == activityConversionInfo.getActivityType() && this.conversionType == activityConversionInfo.getConversionType();
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getConversionType() {
        return this.conversionType;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.activityType), Integer.valueOf(this.conversionType));
    }

    public void setActivityType(int i10) {
        if (!ActivityIdentificationData.isValidType(i10)) {
            throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
        }
        this.activityType = i10;
    }

    public void setConversionType(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
        }
        this.conversionType = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ActivityConversionInfo{activityType=");
        sb2.append(this.activityType);
        sb2.append(", conversionType=");
        return C6769i.m38373a(sb2, this.conversionType, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.conversionType);
    }

    public ActivityConversionInfo(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.conversionType = parcel.readInt();
    }
}
