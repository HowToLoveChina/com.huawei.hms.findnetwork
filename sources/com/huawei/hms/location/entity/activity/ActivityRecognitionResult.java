package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes8.dex */
public class ActivityRecognitionResult implements Parcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new C5686yn();
    private long elapsedRealtimeMillis;
    private List<DetectedActivity> probableActivities;
    private long time;

    /* renamed from: com.huawei.hms.location.entity.activity.ActivityRecognitionResult$yn */
    public class C5686yn implements Parcelable.Creator<ActivityRecognitionResult> {
        @Override // android.os.Parcelable.Creator
        public final ActivityRecognitionResult createFromParcel(Parcel parcel) {
            return new ActivityRecognitionResult(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityRecognitionResult[] newArray(int i10) {
            return new ActivityRecognitionResult[0];
        }
    }

    private ActivityRecognitionResult(Parcel parcel) {
        this.time = parcel.readLong();
        this.elapsedRealtimeMillis = parcel.readLong();
        this.probableActivities = parcel.createTypedArrayList(DetectedActivity.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int i10) {
        List<DetectedActivity> list = this.probableActivities;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        for (DetectedActivity detectedActivity : this.probableActivities) {
            if (detectedActivity.getType() == i10) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.elapsedRealtimeMillis;
    }

    public DetectedActivity getMostProbableActivity() {
        List<DetectedActivity> list = this.probableActivities;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.probableActivities.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.probableActivities;
    }

    public long getTime() {
        return this.time;
    }

    public void setElapsedRealtimeMillis(long j10) {
        this.elapsedRealtimeMillis = j10;
    }

    public void setProbableActivities(List<DetectedActivity> list) {
        this.probableActivities = list;
    }

    public void setTime(long j10) {
        this.time = j10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.time);
        parcel.writeLong(this.elapsedRealtimeMillis);
        parcel.writeTypedList(this.probableActivities);
    }

    public /* synthetic */ ActivityRecognitionResult(Parcel parcel, C5686yn c5686yn) {
        this(parcel);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j10, long j11) {
        this.probableActivities = list;
        this.time = j10;
        this.elapsedRealtimeMillis = j11;
    }
}
