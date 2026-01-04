package com.huawei.openalliance.p169ad.views.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public abstract class PPSAbsSavedState implements Parcelable {

    /* renamed from: b */
    private final Parcelable f38183b;

    /* renamed from: a */
    public static final PPSAbsSavedState f38182a = new PPSAbsSavedState() { // from class: com.huawei.openalliance.ad.views.viewpager.PPSAbsSavedState.1
    };
    public static final Parcelable.Creator<PPSAbsSavedState> CREATOR = new Parcelable.ClassLoaderCreator<PPSAbsSavedState>() { // from class: com.huawei.openalliance.ad.views.viewpager.PPSAbsSavedState.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSAbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSAbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return PPSAbsSavedState.f38182a;
            }
            throw new IllegalStateException("superState should null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSAbsSavedState[] newArray(int i10) {
            return new PPSAbsSavedState[i10];
        }
    };

    private PPSAbsSavedState() {
        this.f38183b = null;
    }

    /* renamed from: a */
    public final Parcelable m50527a() {
        return this.f38183b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f38183b, i10);
    }

    public PPSAbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f38183b = parcelable == null ? f38182a : parcelable;
    }

    public PPSAbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f38183b = parcelable == f38182a ? null : parcelable;
    }
}
