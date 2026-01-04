package com.huawei.location.base.activity.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class MovementEvent implements Parcelable {
    public static final Parcelable.Creator<MovementEvent> CREATOR = new C6741a();
    private int mEventType;
    private String mMovement;

    /* renamed from: com.huawei.location.base.activity.entity.MovementEvent$a */
    public class C6741a implements Parcelable.Creator<MovementEvent> {
        @Override // android.os.Parcelable.Creator
        public final MovementEvent createFromParcel(Parcel parcel) {
            return new MovementEvent(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final MovementEvent[] newArray(int i10) {
            return new MovementEvent[i10];
        }
    }

    public MovementEvent(String str, int i10) {
        this.mMovement = str;
        this.mEventType = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.mEventType;
    }

    public String getMovement() {
        return this.mMovement;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mMovement);
        parcel.writeInt(this.mEventType);
    }
}
