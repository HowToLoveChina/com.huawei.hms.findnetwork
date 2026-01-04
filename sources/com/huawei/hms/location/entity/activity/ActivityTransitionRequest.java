package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public class ActivityTransitionRequest implements Parcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new C5689yn();
    private List<ActivityTransition> transitions;

    /* renamed from: com.huawei.hms.location.entity.activity.ActivityTransitionRequest$yn */
    public class C5689yn implements Parcelable.Creator<ActivityTransitionRequest> {
        @Override // android.os.Parcelable.Creator
        public final ActivityTransitionRequest createFromParcel(Parcel parcel) {
            return new ActivityTransitionRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityTransitionRequest[] newArray(int i10) {
            return new ActivityTransitionRequest[i10];
        }
    }

    public ActivityTransitionRequest() {
        this.transitions = new CopyOnWriteArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ActivityTransition> getTransitions() {
        return this.transitions;
    }

    public void setTransitions(List<ActivityTransition> list) {
        this.transitions = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.transitions);
    }

    public ActivityTransitionRequest(Parcel parcel) {
        this.transitions = new CopyOnWriteArrayList();
        this.transitions = parcel.createTypedArrayList(ActivityTransition.CREATOR);
    }
}
