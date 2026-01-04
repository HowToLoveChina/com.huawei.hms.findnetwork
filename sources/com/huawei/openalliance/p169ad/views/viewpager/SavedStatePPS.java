package com.huawei.openalliance.p169ad.views.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SavedStatePPS extends PPSAbsSavedState {
    public static final Parcelable.Creator<SavedStatePPS> CREATOR = new Parcelable.ClassLoaderCreator<SavedStatePPS>() { // from class: com.huawei.openalliance.ad.views.viewpager.SavedStatePPS.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SavedStatePPS createFromParcel(Parcel parcel) {
            return new SavedStatePPS(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SavedStatePPS createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new SavedStatePPS(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SavedStatePPS[] newArray(int i10) {
            return new SavedStatePPS[i10];
        }
    };

    /* renamed from: b */
    int f38184b;

    /* renamed from: c */
    Parcelable f38185c;

    /* renamed from: d */
    ClassLoader f38186d;

    public SavedStatePPS(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
        this.f38184b = parcel.readInt();
        this.f38185c = parcel.readParcelable(classLoader);
        this.f38186d = classLoader;
    }

    @Override // com.huawei.openalliance.p169ad.views.viewpager.PPSAbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f38184b);
        parcel.writeParcelable(this.f38185c, i10);
    }

    public SavedStatePPS(Parcelable parcelable) {
        super(parcelable);
    }
}
