package com.huawei.wearengine.sensor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public class Sensor implements Parcelable {
    public static final Parcelable.Creator<Sensor> CREATOR = new C8909a();

    /* renamed from: a */
    public String f45378a;

    /* renamed from: b */
    public int f45379b;

    /* renamed from: c */
    public int f45380c;

    /* renamed from: d */
    public int f45381d;

    /* renamed from: e */
    public float f45382e;

    /* renamed from: f */
    public String f45383f;

    /* renamed from: com.huawei.wearengine.sensor.Sensor$a */
    public class C8909a implements Parcelable.Creator<Sensor> {
        @Override // android.os.Parcelable.Creator
        public Sensor createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            return new Sensor(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public Sensor[] newArray(int i10) {
            return new Sensor[i10];
        }
    }

    public Sensor(int i10, int i11, int i12, float f10, String str) {
        this.f45379b = i10;
        this.f45380c = i11;
        this.f45381d = i12;
        this.f45382e = f10;
        this.f45378a = m56618a(i11);
        this.f45383f = str;
    }

    /* renamed from: a */
    public final String m56618a(int i10) {
        switch (i10) {
            case 0:
                return "ECG";
            case 1:
                return "PPG";
            case 2:
                return "ACC";
            case 3:
                return "GYRO";
            case 4:
                return "MAG";
            case 5:
                return "PRESSURE";
            case 6:
                return "HR";
            default:
                return "";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.f45379b);
        parcel.writeInt(this.f45380c);
        parcel.writeInt(this.f45381d);
        parcel.writeFloat(this.f45382e);
        parcel.writeString(this.f45383f);
    }
}
