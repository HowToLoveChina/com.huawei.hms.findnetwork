package com.huawei.hwidauth.utils.globalcfg;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class CountryInfoForCFG implements Parcelable {
    public static final Parcelable.Creator<CountryInfoForCFG> CREATOR = new C6725a();

    /* renamed from: a */
    public String f31165a;

    /* renamed from: b */
    public String f31166b;

    /* renamed from: c */
    public String f31167c;

    /* renamed from: d */
    public String f31168d;

    /* renamed from: e */
    public String f31169e;

    /* renamed from: f */
    public String f31170f;

    /* renamed from: g */
    public String f31171g;

    /* renamed from: h */
    public String f31172h;

    /* renamed from: com.huawei.hwidauth.utils.globalcfg.CountryInfoForCFG$a */
    public class C6725a implements Parcelable.Creator<CountryInfoForCFG> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CountryInfoForCFG createFromParcel(Parcel parcel) {
            return new CountryInfoForCFG(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CountryInfoForCFG[] newArray(int i10) {
            return new CountryInfoForCFG[i10];
        }
    }

    public CountryInfoForCFG() {
    }

    public CountryInfoForCFG(Parcel parcel) {
        this.f31165a = parcel.readString();
        this.f31166b = parcel.readString();
        this.f31167c = parcel.readString();
        this.f31168d = parcel.readString();
        this.f31169e = parcel.readString();
        this.f31170f = parcel.readString();
        this.f31171g = parcel.readString();
        this.f31172h = parcel.readString();
    }

    /* renamed from: a */
    public String m38255a() {
        return this.f31165a;
    }

    /* renamed from: c */
    public void m38256c(String str) {
        this.f31165a = str;
    }

    /* renamed from: d */
    public String m38257d() {
        return this.f31168d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m38258e(String str) {
        this.f31166b = str;
    }

    /* renamed from: f */
    public String m38259f() {
        return this.f31170f;
    }

    /* renamed from: g */
    public void m38260g(String str) {
        this.f31167c = str;
    }

    /* renamed from: h */
    public String m38261h() {
        return this.f31172h;
    }

    /* renamed from: i */
    public void m38262i(String str) {
        this.f31168d = str;
    }

    /* renamed from: j */
    public void m38263j(String str) {
        this.f31169e = str;
    }

    /* renamed from: l */
    public void m38264l(String str) {
        this.f31170f = str;
    }

    /* renamed from: m */
    public void m38265m(String str) {
        this.f31171g = str;
    }

    /* renamed from: n */
    public void m38266n(String str) {
        this.f31172h = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31165a);
        parcel.writeString(this.f31166b);
        parcel.writeString(this.f31167c);
        parcel.writeString(this.f31168d);
        parcel.writeString(this.f31169e);
        parcel.writeString(this.f31170f);
        parcel.writeString(this.f31171g);
        parcel.writeString(this.f31172h);
    }
}
