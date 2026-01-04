package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.C6769i;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class ActivityIdentificationData implements Parcelable {
    public static final int BIKE = 101;
    public static final int FOOT = 102;
    public static final int OTHERS = 104;
    private static final int POSSIBILITY_MAX = 100;
    private static final int POSSIBILITY_MIN = 0;
    public static final int RUNNING = 108;
    public static final int STILL = 103;
    public static final int VEHICLE = 100;
    public static final int WALKING = 107;
    private int identificationActivity;
    private int possibility;
    public static final Parcelable.Creator<ActivityIdentificationData> CREATOR = new C5675yn();
    private static final int[] VALID_TYPE_ARRAY = {100, 101, 102, 103, 107, 108};

    /* renamed from: com.huawei.hms.location.ActivityIdentificationData$yn */
    public class C5675yn implements Parcelable.Creator<ActivityIdentificationData> {
        @Override // android.os.Parcelable.Creator
        public final ActivityIdentificationData createFromParcel(Parcel parcel) {
            return new ActivityIdentificationData(parcel, (C5675yn) null);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityIdentificationData[] newArray(int i10) {
            return new ActivityIdentificationData[i10];
        }
    }

    public ActivityIdentificationData(int i10, int i11) throws ApiException {
        if (i11 > 100 || i11 < 0) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
        this.identificationActivity = i10;
        this.possibility = i11;
    }

    public static boolean isValidType(int i10) {
        return Arrays.binarySearch(VALID_TYPE_ARRAY, i10) >= 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return true;
        }
        if (getClass() != obj.getClass() || !(obj instanceof ActivityIdentificationData)) {
            return false;
        }
        ActivityIdentificationData activityIdentificationData = (ActivityIdentificationData) obj;
        return this.identificationActivity == activityIdentificationData.getIdentificationActivity() && this.possibility == activityIdentificationData.getPossibility();
    }

    public int getIdentificationActivity() {
        return this.identificationActivity;
    }

    public int getPossibility() {
        return this.possibility;
    }

    public int hashCode() {
        return new Object[]{Integer.valueOf(this.identificationActivity), Integer.valueOf(this.possibility)}.hashCode();
    }

    public void setIdentificationActivity(int i10) {
        this.identificationActivity = i10;
    }

    public void setPossibility(int i10) throws ApiException {
        if (i10 > 100 || i10 < 0) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
        this.possibility = i10;
    }

    public String toString() {
        String string;
        int i10 = this.identificationActivity;
        switch (i10) {
            case 100:
                string = "VEHICLE";
                break;
            case 101:
                string = "BIKE";
                break;
            case 102:
                string = "FOOT";
                break;
            case 103:
                string = "STILL";
                break;
            case 104:
                string = "OTHERS";
                break;
            case 105:
            case 106:
            default:
                string = Integer.toString(i10);
                break;
            case 107:
                string = "WALKING";
                break;
            case 108:
                string = "RUNNING";
                break;
        }
        StringBuilder sb2 = new StringBuilder("ActivityIdentificationData{identificationActivity=");
        sb2.append(string);
        sb2.append(", possibility=");
        return C6769i.m38373a(sb2, this.possibility, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.identificationActivity);
        parcel.writeInt(this.possibility);
    }

    private ActivityIdentificationData(Parcel parcel) {
        this.identificationActivity = parcel.readInt();
        this.possibility = parcel.readInt();
    }

    public /* synthetic */ ActivityIdentificationData(Parcel parcel, C5675yn c5675yn) {
        this(parcel);
    }
}
