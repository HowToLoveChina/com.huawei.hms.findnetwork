package com.huawei.openalliance.p169ad.hsf;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class PPSHsfService implements Parcelable {
    public static final Parcelable.Creator<PPSHsfService> CREATOR = new C7191a();

    /* renamed from: a */
    private final String f33103a;

    /* renamed from: b */
    private final IBinder f33104b;

    /* renamed from: c */
    private final int f33105c;

    /* renamed from: com.huawei.openalliance.ad.hsf.PPSHsfService$a */
    public static class C7191a implements Parcelable.Creator<PPSHsfService> {
        private C7191a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSHsfService createFromParcel(Parcel parcel) {
            return new PPSHsfService(parcel.readString(), parcel.readStrongBinder(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSHsfService[] newArray(int i10) {
            return new PPSHsfService[i10];
        }
    }

    public PPSHsfService(String str, IBinder iBinder, int i10) {
        this.f33103a = str;
        this.f33104b = iBinder;
        this.f33105c = i10;
    }

    /* renamed from: a */
    public String m43842a() {
        return this.f33103a;
    }

    /* renamed from: b */
    public IBinder m43843b() {
        return this.f33104b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f33103a);
        parcel.writeStrongBinder(this.f33104b);
        parcel.writeInt(this.f33105c);
    }
}
