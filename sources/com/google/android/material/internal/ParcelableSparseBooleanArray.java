package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

/* loaded from: classes.dex */
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new C1767a();

    /* renamed from: com.google.android.material.internal.ParcelableSparseBooleanArray$a */
    public class C1767a implements Parcelable.Creator<ParcelableSparseBooleanArray> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseBooleanArray createFromParcel(Parcel parcel) {
            int i10 = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i10);
            int[] iArr = new int[i10];
            boolean[] zArr = new boolean[i10];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i11 = 0; i11 < i10; i11++) {
                parcelableSparseBooleanArray.put(iArr[i11], zArr[i11]);
            }
            return parcelableSparseBooleanArray;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseBooleanArray[] newArray(int i10) {
            return new ParcelableSparseBooleanArray[i10];
        }
    }

    public ParcelableSparseBooleanArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i11 = 0; i11 < size(); i11++) {
            iArr[i11] = keyAt(i11);
            zArr[i11] = valueAt(i11);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }

    public ParcelableSparseBooleanArray(int i10) {
        super(i10);
    }
}
