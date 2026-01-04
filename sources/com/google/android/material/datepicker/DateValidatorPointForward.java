package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

/* loaded from: classes.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new C1719a();

    /* renamed from: a */
    public final long f7890a;

    /* renamed from: com.google.android.material.datepicker.DateValidatorPointForward$a */
    public class C1719a implements Parcelable.Creator<DateValidatorPointForward> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward[] newArray(int i10) {
            return new DateValidatorPointForward[i10];
        }
    }

    public /* synthetic */ DateValidatorPointForward(long j10, C1719a c1719a) {
        this(j10);
    }

    /* renamed from: a */
    public static DateValidatorPointForward m10236a(long j10) {
        return new DateValidatorPointForward(j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f7890a == ((DateValidatorPointForward) obj).f7890a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f7890a)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    /* renamed from: k */
    public boolean mo10216k(long j10) {
        return j10 >= this.f7890a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f7890a);
    }

    public DateValidatorPointForward(long j10) {
        this.f7890a = j10;
    }
}
