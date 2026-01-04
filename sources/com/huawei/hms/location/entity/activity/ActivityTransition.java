package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;

/* loaded from: classes8.dex */
public class ActivityTransition implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new C5687yn();
    private int activityType;
    private int transitionType;

    /* renamed from: com.huawei.hms.location.entity.activity.ActivityTransition$yn */
    public class C5687yn implements Parcelable.Creator<ActivityTransition> {
        @Override // android.os.Parcelable.Creator
        public final ActivityTransition createFromParcel(Parcel parcel) {
            return new ActivityTransition(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityTransition[] newArray(int i10) {
            return new ActivityTransition[i10];
        }
    }

    public ActivityTransition() {
    }

    public ActivityTransition(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.transitionType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getTransitionType() {
        return this.transitionType;
    }

    public void setActivityType(int i10) {
        this.activityType = i10;
    }

    public void setTransitionType(int i10) {
        this.transitionType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.transitionType);
    }
}
