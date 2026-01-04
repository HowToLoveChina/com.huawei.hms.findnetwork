package com.huawei.wearengine.sensor;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes9.dex */
public class DataResult implements Parcelable {
    public static final Parcelable.Creator<DataResult> CREATOR = new C8908a();

    /* renamed from: a */
    public long f45372a;

    /* renamed from: b */
    public float[] f45373b;

    /* renamed from: c */
    public List<DataResult> f45374c;

    /* renamed from: d */
    public int f45375d;

    /* renamed from: e */
    public Sensor f45376e;

    /* renamed from: f */
    public String f45377f = "";

    /* renamed from: com.huawei.wearengine.sensor.DataResult$a */
    public class C8908a implements Parcelable.Creator<DataResult> {
        @Override // android.os.Parcelable.Creator
        public DataResult createFromParcel(Parcel parcel) {
            DataResult dataResult = new DataResult();
            if (parcel != null) {
                dataResult.m56616f(parcel.readLong());
                dataResult.m56617g(parcel.createFloatArray());
                dataResult.m56614d(parcel.readArrayList(DataResult.class.getClassLoader()));
                dataResult.m56612a(parcel.readInt());
                dataResult.m56615e((Sensor) parcel.readParcelable(Sensor.class.getClassLoader()));
                dataResult.m56613c(parcel.readString());
            }
            return dataResult;
        }

        @Override // android.os.Parcelable.Creator
        public DataResult[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new DataResult[0] : new DataResult[i10];
        }
    }

    /* renamed from: a */
    public void m56612a(int i10) {
        this.f45375d = i10;
    }

    /* renamed from: c */
    public void m56613c(String str) {
        this.f45377f = str;
    }

    /* renamed from: d */
    public void m56614d(List<DataResult> list) {
        this.f45374c = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m56615e(Sensor sensor) {
        this.f45376e = sensor;
    }

    /* renamed from: f */
    public void m56616f(long j10) {
        this.f45372a = j10;
    }

    /* renamed from: g */
    public void m56617g(float[] fArr) {
        this.f45373b = fArr == null ? null : (float[]) fArr.clone();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeLong(this.f45372a);
        parcel.writeFloatArray(this.f45373b);
        parcel.writeList(this.f45374c);
        parcel.writeInt(this.f45375d);
        parcel.writeParcelable(this.f45376e, i10);
        parcel.writeString(this.f45377f);
    }
}
