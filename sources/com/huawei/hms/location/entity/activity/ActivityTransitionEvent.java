package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class ActivityTransitionEvent implements Parcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new C5688yn();
    private int activityType;
    private long elapsedRealTimeNanos;
    private int transitionType;

    /* renamed from: com.huawei.hms.location.entity.activity.ActivityTransitionEvent$yn */
    public class C5688yn implements Parcelable.Creator<ActivityTransitionEvent> {
        @Override // android.os.Parcelable.Creator
        public final ActivityTransitionEvent createFromParcel(Parcel parcel) {
            return new ActivityTransitionEvent(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityTransitionEvent[] newArray(int i10) {
            return new ActivityTransitionEvent[0];
        }
    }

    public ActivityTransitionEvent(int i10, int i11, long j10) {
        this.activityType = i10;
        this.transitionType = i11;
        this.elapsedRealTimeNanos = j10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public long getElapsedRealTimeNanos() {
        return this.elapsedRealTimeNanos;
    }

    public int getTransitionType() {
        return this.transitionType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.transitionType);
        parcel.writeLong(this.elapsedRealTimeNanos);
    }

    private ActivityTransitionEvent(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.transitionType = parcel.readInt();
        this.elapsedRealTimeNanos = parcel.readLong();
    }

    public /* synthetic */ ActivityTransitionEvent(Parcel parcel, C5688yn c5688yn) {
        this(parcel);
    }
}
