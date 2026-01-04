package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new C1879a();

    /* renamed from: a */
    public final C1887a f9030a;

    /* renamed from: b */
    public final C1887a f9031b;

    /* renamed from: c */
    public final int f9032c;

    /* renamed from: d */
    public int f9033d;

    /* renamed from: e */
    public int f9034e;

    /* renamed from: f */
    public int f9035f;

    /* renamed from: g */
    public int f9036g;

    /* renamed from: com.google.android.material.timepicker.TimeModel$a */
    public class C1879a implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeModel[] newArray(int i10) {
            return new TimeModel[i10];
        }
    }

    public TimeModel() {
        this(0);
    }

    /* renamed from: a */
    public static String m11415a(Resources resources, CharSequence charSequence) {
        return m11416c(resources, charSequence, "%02d");
    }

    /* renamed from: c */
    public static String m11416c(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    /* renamed from: d */
    public static int m11417d(int i10) {
        return i10 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f9033d == timeModel.f9033d && this.f9034e == timeModel.f9034e && this.f9032c == timeModel.f9032c && this.f9035f == timeModel.f9035f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9032c), Integer.valueOf(this.f9033d), Integer.valueOf(this.f9034e), Integer.valueOf(this.f9035f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f9033d);
        parcel.writeInt(this.f9034e);
        parcel.writeInt(this.f9035f);
        parcel.writeInt(this.f9032c);
    }

    public TimeModel(int i10) {
        this(0, 0, 10, i10);
    }

    public TimeModel(int i10, int i11, int i12, int i13) {
        this.f9033d = i10;
        this.f9034e = i11;
        this.f9035f = i12;
        this.f9032c = i13;
        this.f9036g = m11417d(i10);
        this.f9030a = new C1887a(59);
        this.f9031b = new C1887a(i13 == 1 ? 24 : 12);
    }

    public TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
