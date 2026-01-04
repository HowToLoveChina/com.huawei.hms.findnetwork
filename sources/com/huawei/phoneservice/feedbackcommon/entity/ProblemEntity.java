package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class ProblemEntity implements Parcelable {
    public static final Parcelable.Creator<ProblemEntity> CREATOR = new C8607a();

    /* renamed from: a */
    public String f40067a;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.entity.ProblemEntity$a */
    public class C8607a implements Parcelable.Creator<ProblemEntity> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProblemEntity createFromParcel(Parcel parcel) {
            return new ProblemEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProblemEntity[] newArray(int i10) {
            return new ProblemEntity[i10];
        }
    }

    public ProblemEntity() {
    }

    public ProblemEntity(Parcel parcel) {
        this.f40067a = parcel.readString();
    }

    /* renamed from: a */
    public String m53180a() {
        return this.f40067a;
    }

    /* renamed from: c */
    public void m53181c(String str) {
        this.f40067a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f40067a);
    }

    public ProblemEntity(String str) {
        this.f40067a = str;
    }
}
