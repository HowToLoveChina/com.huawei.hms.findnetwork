package com.huawei.hwidauth.utils.globalcfg;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class SiteInfoForCFG implements Parcelable {
    public static final Parcelable.Creator<SiteInfoForCFG> CREATOR = new C6726a();

    /* renamed from: a */
    public String f31173a;

    /* renamed from: b */
    public String f31174b;

    /* renamed from: c */
    public String f31175c;

    /* renamed from: d */
    public String f31176d;

    /* renamed from: com.huawei.hwidauth.utils.globalcfg.SiteInfoForCFG$a */
    public class C6726a implements Parcelable.Creator<SiteInfoForCFG> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SiteInfoForCFG createFromParcel(Parcel parcel) {
            return new SiteInfoForCFG(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SiteInfoForCFG[] newArray(int i10) {
            return new SiteInfoForCFG[i10];
        }
    }

    public SiteInfoForCFG() {
    }

    public SiteInfoForCFG(Parcel parcel) {
        this.f31173a = parcel.readString();
        this.f31174b = parcel.readString();
        this.f31175c = parcel.readString();
        this.f31176d = parcel.readString();
    }

    /* renamed from: a */
    public String m38269a() {
        return this.f31173a;
    }

    /* renamed from: c */
    public void m38270c(String str) {
        this.f31173a = str;
    }

    /* renamed from: d */
    public String m38271d() {
        return this.f31176d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m38272e(String str) {
        this.f31174b = str;
    }

    /* renamed from: f */
    public void m38273f(String str) {
        this.f31175c = str;
    }

    /* renamed from: g */
    public void m38274g(String str) {
        this.f31176d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31173a);
        parcel.writeString(this.f31174b);
        parcel.writeString(this.f31175c);
        parcel.writeString(this.f31176d);
    }
}
