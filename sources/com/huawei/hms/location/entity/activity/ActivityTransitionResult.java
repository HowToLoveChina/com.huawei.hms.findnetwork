package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes8.dex */
public class ActivityTransitionResult implements Parcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new C5690yn();
    private List<ActivityTransitionEvent> transitionEvents;

    /* renamed from: com.huawei.hms.location.entity.activity.ActivityTransitionResult$yn */
    public class C5690yn implements Parcelable.Creator<ActivityTransitionResult> {
        @Override // android.os.Parcelable.Creator
        public final ActivityTransitionResult createFromParcel(Parcel parcel) {
            return new ActivityTransitionResult(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityTransitionResult[] newArray(int i10) {
            return new ActivityTransitionResult[0];
        }
    }

    private ActivityTransitionResult(Parcel parcel) {
        this.transitionEvents = parcel.createTypedArrayList(ActivityTransitionEvent.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ActivityTransitionEvent> getTransitionEvents() {
        return this.transitionEvents;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.transitionEvents);
    }

    public /* synthetic */ ActivityTransitionResult(Parcel parcel, C5690yn c5690yn) {
        this(parcel);
    }

    public ActivityTransitionResult(List<ActivityTransitionEvent> list) {
        this.transitionEvents = list;
    }
}
