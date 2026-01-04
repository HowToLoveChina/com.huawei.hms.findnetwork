package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class DetectedActivity implements Parcelable {
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new C5691yn();
    private int confidence;
    private int type;

    /* renamed from: com.huawei.hms.location.entity.activity.DetectedActivity$yn */
    public class C5691yn implements Parcelable.Creator<DetectedActivity> {
        @Override // android.os.Parcelable.Creator
        public final DetectedActivity createFromParcel(Parcel parcel) {
            return new DetectedActivity(parcel, (C5691yn) null);
        }

        @Override // android.os.Parcelable.Creator
        public final DetectedActivity[] newArray(int i10) {
            return new DetectedActivity[i10];
        }
    }

    public DetectedActivity() {
    }

    public DetectedActivity(int i10, int i11) {
        this.confidence = i11;
        this.type = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public int getType() {
        return this.type;
    }

    public void setConfidence(int i10) {
        this.confidence = i10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.confidence);
    }

    private DetectedActivity(Parcel parcel) {
        this.type = parcel.readInt();
        this.confidence = parcel.readInt();
    }

    public /* synthetic */ DetectedActivity(Parcel parcel, C5691yn c5691yn) {
        this(parcel);
    }
}
