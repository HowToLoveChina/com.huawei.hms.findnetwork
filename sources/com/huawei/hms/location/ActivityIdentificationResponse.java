package com.huawei.hms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes8.dex */
public class ActivityIdentificationResponse implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityIdentificationResponse> CREATOR = new C5676yn();
    private static final String EXTRA_CONSTANT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_RESULT";
    private static final String TAG = "ActivityIdentificationResponse";

    @Packed
    private List<ActivityIdentificationData> activityIdentificationDatas;

    @Packed
    private long elapsedTimeFromReboot;

    @Packed
    private long time;

    /* renamed from: com.huawei.hms.location.ActivityIdentificationResponse$yn */
    public class C5676yn implements Parcelable.Creator<ActivityIdentificationResponse> {
        @Override // android.os.Parcelable.Creator
        public final ActivityIdentificationResponse createFromParcel(Parcel parcel) {
            return new ActivityIdentificationResponse(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityIdentificationResponse[] newArray(int i10) {
            return new ActivityIdentificationResponse[0];
        }
    }

    public ActivityIdentificationResponse() {
    }

    private ActivityIdentificationResponse(Parcel parcel) {
        this.time = parcel.readLong();
        this.elapsedTimeFromReboot = parcel.readLong();
        this.activityIdentificationDatas = parcel.createTypedArrayList(ActivityIdentificationData.CREATOR);
    }

    public static boolean containDataFromIntent(Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra(EXTRA_CONSTANT)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static ActivityIdentificationResponse getDataFromIntent(Intent intent) {
        try {
            if (!containDataFromIntent(intent)) {
                return null;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra(EXTRA_CONSTANT);
            if (parcelableExtra == null) {
                parcelableExtra = null;
            } else if (parcelableExtra instanceof Bundle) {
                parcelableExtra = ((Bundle) parcelableExtra).getParcelable("KEY_RESPONSE");
            }
            if (parcelableExtra instanceof ActivityIdentificationResponse) {
                return (ActivityIdentificationResponse) parcelableExtra;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof ActivityIdentificationResponse)) {
            return false;
        }
        ActivityIdentificationResponse activityIdentificationResponse = (ActivityIdentificationResponse) obj;
        return this.time == activityIdentificationResponse.getTime() && this.elapsedTimeFromReboot == activityIdentificationResponse.getElapsedTimeFromReboot() && Objects.equals(this.activityIdentificationDatas, activityIdentificationResponse.getActivityIdentificationDatas());
    }

    public List<ActivityIdentificationData> getActivityIdentificationDatas() {
        return this.activityIdentificationDatas;
    }

    public int getActivityPossibility(int i10) {
        List<ActivityIdentificationData> list = this.activityIdentificationDatas;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        for (ActivityIdentificationData activityIdentificationData : this.activityIdentificationDatas) {
            if (activityIdentificationData.getIdentificationActivity() == i10) {
                return activityIdentificationData.getPossibility();
            }
        }
        return 0;
    }

    public long getElapsedTimeFromReboot() {
        return this.elapsedTimeFromReboot;
    }

    public ActivityIdentificationData getMostActivityIdentification() {
        List<ActivityIdentificationData> list = this.activityIdentificationDatas;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.activityIdentificationDatas.get(0);
    }

    public long getTime() {
        return this.time;
    }

    public int hashCode() {
        return new Object[]{Long.valueOf(this.time), Long.valueOf(this.elapsedTimeFromReboot), this.activityIdentificationDatas}.hashCode();
    }

    public void setActivityIdentificationDatas(List<ActivityIdentificationData> list) {
        this.activityIdentificationDatas = list;
    }

    public void setElapsedTimeFromReboot(long j10) {
        this.elapsedTimeFromReboot = j10;
    }

    public void setTime(long j10) {
        this.time = j10;
    }

    public String toString() {
        return "ActivityIdentificationResponse{time=" + this.time + ", elapsedTimeFromReboot=" + this.elapsedTimeFromReboot + ", activityIdentificationDatas=" + this.activityIdentificationDatas + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.time);
        parcel.writeLong(this.elapsedTimeFromReboot);
        parcel.writeTypedList(this.activityIdentificationDatas);
    }

    public /* synthetic */ ActivityIdentificationResponse(Parcel parcel, C5676yn c5676yn) {
        this(parcel);
    }

    public ActivityIdentificationResponse(ActivityIdentificationData activityIdentificationData, long j10, long j11) {
        this.activityIdentificationDatas = Collections.singletonList(activityIdentificationData);
        this.time = j10;
        this.elapsedTimeFromReboot = j11;
    }

    public ActivityIdentificationResponse(List<ActivityIdentificationData> list, long j10, long j11) {
        this.activityIdentificationDatas = list;
        this.time = j10;
        this.elapsedTimeFromReboot = j11;
    }
}
