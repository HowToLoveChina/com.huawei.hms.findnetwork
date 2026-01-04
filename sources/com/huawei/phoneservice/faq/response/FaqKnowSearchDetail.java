package com.huawei.phoneservice.faq.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class FaqKnowSearchDetail implements Parcelable {
    public static final Parcelable.Creator<FaqKnowSearchDetail> CREATOR = new C8339a();

    /* renamed from: a */
    @SerializedName("resourceId")
    private String f38784a;

    /* renamed from: b */
    @SerializedName("resourceTitle")
    private String f38785b;

    /* renamed from: c */
    @SerializedName("resourceHTitle")
    private String f38786c;

    /* renamed from: d */
    @SerializedName("content")
    private String f38787d;

    /* renamed from: e */
    @SerializedName("describe")
    private String f38788e;

    /* renamed from: f */
    @SerializedName("icon")
    private String f38789f;

    /* renamed from: g */
    @SerializedName("url")
    private String f38790g;

    /* renamed from: h */
    @SerializedName("updateDate")
    private String f38791h;

    /* renamed from: i */
    @SerializedName("knowTypeId")
    private String f38792i;

    /* renamed from: j */
    @SerializedName("knowTypeName")
    private String f38793j;

    /* renamed from: k */
    @SerializedName("comments")
    private String f38794k;

    /* renamed from: l */
    @SerializedName("downloads")
    private String f38795l;

    /* renamed from: m */
    @SerializedName("reads")
    private String f38796m;

    /* renamed from: n */
    @SerializedName("toolID")
    private String f38797n;

    /* renamed from: o */
    public int f38798o;

    /* renamed from: p */
    public String f38799p;

    /* renamed from: q */
    public String f38800q;

    /* renamed from: r */
    public int f38801r;

    /* renamed from: s */
    public SpannableString f38802s;

    /* renamed from: t */
    public String f38803t;

    /* renamed from: u */
    public int f38804u;

    /* renamed from: v */
    public String f38805v;

    /* renamed from: w */
    public String f38806w;

    /* renamed from: x */
    public String f38807x;

    /* renamed from: y */
    public SpannableString f38808y;

    /* renamed from: com.huawei.phoneservice.faq.response.FaqKnowSearchDetail$a */
    public class C8339a implements Parcelable.Creator<FaqKnowSearchDetail> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FaqKnowSearchDetail createFromParcel(Parcel parcel) {
            return new FaqKnowSearchDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FaqKnowSearchDetail[] newArray(int i10) {
            return new FaqKnowSearchDetail[i10];
        }
    }

    public FaqKnowSearchDetail() {
        this.f38798o = Integer.MAX_VALUE;
    }

    /* renamed from: a */
    public String m51965a() {
        return this.f38787d;
    }

    /* renamed from: c */
    public void m51966c(int i10) {
        this.f38804u = i10;
    }

    /* renamed from: d */
    public void m51967d(SpannableString spannableString) {
        this.f38808y = spannableString;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m51968e(String str) {
        this.f38787d = str;
    }

    /* renamed from: f */
    public SpannableString m51969f() {
        return this.f38802s;
    }

    /* renamed from: g */
    public void m51970g(SpannableString spannableString) {
        this.f38802s = spannableString;
    }

    /* renamed from: h */
    public void m51971h(String str) {
        this.f38803t = str;
    }

    /* renamed from: i */
    public String m51972i() {
        return this.f38803t;
    }

    /* renamed from: j */
    public void m51973j(String str) {
        this.f38806w = str;
    }

    /* renamed from: l */
    public String m51974l() {
        return this.f38806w;
    }

    /* renamed from: m */
    public void m51975m(String str) {
        this.f38807x = str;
    }

    /* renamed from: n */
    public String m51976n() {
        return this.f38785b;
    }

    /* renamed from: o */
    public void m51977o(String str) {
        this.f38785b = str;
    }

    /* renamed from: p */
    public String m51978p() {
        return this.f38790g;
    }

    /* renamed from: q */
    public void m51979q(String str) {
        this.f38797n = str;
    }

    /* renamed from: r */
    public void m51980r(String str) {
        this.f38791h = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f38784a);
        parcel.writeString(this.f38785b);
        parcel.writeString(this.f38786c);
        parcel.writeString(this.f38787d);
        parcel.writeString(this.f38788e);
        parcel.writeString(this.f38789f);
        parcel.writeString(this.f38790g);
        parcel.writeString(this.f38791h);
        parcel.writeString(this.f38792i);
        parcel.writeString(this.f38793j);
        parcel.writeString(this.f38794k);
        parcel.writeString(this.f38795l);
        parcel.writeString(this.f38796m);
        parcel.writeString(this.f38797n);
        parcel.writeInt(this.f38798o);
        parcel.writeInt(this.f38801r);
        parcel.writeInt(this.f38804u);
        parcel.writeString(this.f38805v);
        parcel.writeString(this.f38799p);
        parcel.writeString(this.f38800q);
        parcel.writeString(this.f38806w);
    }

    public FaqKnowSearchDetail(Parcel parcel) {
        this.f38798o = Integer.MAX_VALUE;
        this.f38784a = parcel.readString();
        this.f38785b = parcel.readString();
        this.f38786c = parcel.readString();
        this.f38787d = parcel.readString();
        this.f38788e = parcel.readString();
        this.f38789f = parcel.readString();
        this.f38790g = parcel.readString();
        this.f38791h = parcel.readString();
        this.f38792i = parcel.readString();
        this.f38793j = parcel.readString();
        this.f38794k = parcel.readString();
        this.f38795l = parcel.readString();
        this.f38796m = parcel.readString();
        this.f38797n = parcel.readString();
        this.f38798o = parcel.readInt();
        this.f38801r = parcel.readInt();
        this.f38804u = parcel.readInt();
        this.f38805v = parcel.readString();
        this.f38799p = parcel.readString();
        this.f38800q = parcel.readString();
        this.f38806w = parcel.readString();
    }
}
