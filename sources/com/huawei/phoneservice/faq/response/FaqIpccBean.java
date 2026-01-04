package com.huawei.phoneservice.faq.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes4.dex */
public class FaqIpccBean implements Parcelable {
    public static final Parcelable.Creator<FaqIpccBean> CREATOR = new C8338a();

    /* renamed from: a */
    @SerializedName("accessToken")
    private String f38763a;

    /* renamed from: b */
    @SerializedName(FaqConstants.FAQ_CHANNEL)
    private String f38764b;

    /* renamed from: c */
    @SerializedName("country")
    private String f38765c;

    /* renamed from: d */
    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private String f38766d;

    /* renamed from: e */
    @SerializedName("custlevel")
    private String f38767e;

    /* renamed from: f */
    @SerializedName("appVersion")
    private String f38768f;

    /* renamed from: g */
    @SerializedName(FaqConstants.FAQ_SHASN)
    private String f38769g;

    /* renamed from: h */
    @SerializedName(FaqConstants.FAQ_ROMVERSION)
    private String f38770h;

    /* renamed from: i */
    @SerializedName(FaqConstants.FAQ_MODEL)
    private String f38771i;

    /* renamed from: j */
    @SerializedName("SN")
    private String f38772j;

    /* renamed from: k */
    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String f38773k;

    /* renamed from: l */
    @SerializedName(FaqConstants.FAQ_OSVERSION)
    private String f38774l;

    /* renamed from: m */
    @SerializedName("countryCode")
    private String f38775m;

    /* renamed from: n */
    @SerializedName("type")
    private String f38776n;

    /* renamed from: o */
    @SerializedName(FaqConstants.FAQ_TYPECODE)
    private String f38777o;

    /* renamed from: p */
    @SerializedName(FaqConstants.FAQ_WECHATID)
    private String f38778p;

    /* renamed from: q */
    @SerializedName(FaqConstants.FAQ_WEIBOID)
    private String f38779q;

    /* renamed from: r */
    @SerializedName(FaqConstants.FAQ_PICID)
    private String f38780r;

    /* renamed from: s */
    @SerializedName(FaqConstants.FAQ_LOG_SERVER_APPID)
    private String f38781s;

    /* renamed from: t */
    @SerializedName(FaqConstants.FAQ_LOG_SERVER_SECRET_KEY)
    private String f38782t;

    /* renamed from: u */
    @SerializedName(FaqConstants.FAQ_LOG_SERVER_LOG_PATH)
    private String f38783u;

    /* renamed from: com.huawei.phoneservice.faq.response.FaqIpccBean$a */
    public class C8338a implements Parcelable.Creator<FaqIpccBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FaqIpccBean createFromParcel(Parcel parcel) {
            return new FaqIpccBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FaqIpccBean[] newArray(int i10) {
            return new FaqIpccBean[i10];
        }
    }

    public FaqIpccBean() {
    }

    public FaqIpccBean(Parcel parcel) {
        this.f38763a = parcel.readString();
        this.f38764b = parcel.readString();
        this.f38765c = parcel.readString();
        this.f38766d = parcel.readString();
        this.f38767e = parcel.readString();
        this.f38768f = parcel.readString();
        this.f38769g = parcel.readString();
        this.f38770h = parcel.readString();
        this.f38771i = parcel.readString();
        this.f38772j = parcel.readString();
        this.f38773k = parcel.readString();
        this.f38774l = parcel.readString();
        this.f38775m = parcel.readString();
        this.f38776n = parcel.readString();
        this.f38777o = parcel.readString();
        this.f38778p = parcel.readString();
        this.f38779q = parcel.readString();
        this.f38780r = parcel.readString();
        this.f38781s = parcel.readString();
        this.f38782t = parcel.readString();
        this.f38783u = parcel.readString();
    }

    /* renamed from: A */
    public void m51936A(String str) {
        this.f38780r = str;
    }

    /* renamed from: I */
    public void m51937I(String str) {
        this.f38770h = str;
    }

    /* renamed from: K */
    public void m51938K(String str) {
        this.f38772j = str;
    }

    /* renamed from: L */
    public void m51939L(String str) {
        this.f38769g = str;
    }

    /* renamed from: M */
    public void m51940M(String str) {
        this.f38776n = str;
    }

    /* renamed from: N */
    public void m51941N(String str) {
        this.f38777o = str;
    }

    /* renamed from: O */
    public void m51942O(String str) {
        this.f38778p = str;
    }

    /* renamed from: P */
    public void m51943P(String str) {
        this.f38779q = str;
    }

    /* renamed from: a */
    public String m51944a() {
        return this.f38763a;
    }

    /* renamed from: c */
    public void m51945c(String str) {
        this.f38763a = str;
    }

    /* renamed from: d */
    public String m51946d() {
        return this.f38768f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m51947e(String str) {
        this.f38768f = str;
    }

    /* renamed from: f */
    public String m51948f() {
        return this.f38764b;
    }

    /* renamed from: g */
    public void m51949g(String str) {
        this.f38764b = str;
    }

    /* renamed from: h */
    public String m51950h() {
        return this.f38765c;
    }

    /* renamed from: i */
    public void m51951i(String str) {
        this.f38765c = str;
    }

    /* renamed from: j */
    public String m51952j() {
        return this.f38766d;
    }

    /* renamed from: l */
    public void m51953l(String str) {
        this.f38775m = str;
    }

    /* renamed from: m */
    public String m51954m() {
        return this.f38771i;
    }

    /* renamed from: n */
    public void m51955n(String str) {
        this.f38767e = str;
    }

    /* renamed from: o */
    public void m51956o(String str) {
        this.f38773k = str;
    }

    /* renamed from: p */
    public void m51957p(String str) {
        this.f38766d = str;
    }

    /* renamed from: q */
    public void m51958q(String str) {
        this.f38781s = str;
    }

    /* renamed from: r */
    public void m51959r(String str) {
        this.f38783u = str;
    }

    /* renamed from: s */
    public void m51960s(String str) {
        this.f38782t = str;
    }

    /* renamed from: t */
    public void m51961t(String str) {
        this.f38771i = str;
    }

    /* renamed from: v */
    public void m51962v(String str) {
        this.f38774l = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f38763a);
        parcel.writeString(this.f38764b);
        parcel.writeString(this.f38765c);
        parcel.writeString(this.f38766d);
        parcel.writeString(this.f38767e);
        parcel.writeString(this.f38768f);
        parcel.writeString(this.f38769g);
        parcel.writeString(this.f38770h);
        parcel.writeString(this.f38771i);
        parcel.writeString(this.f38772j);
        parcel.writeString(this.f38773k);
        parcel.writeString(this.f38774l);
        parcel.writeString(this.f38775m);
        parcel.writeString(this.f38776n);
        parcel.writeString(this.f38777o);
        parcel.writeString(this.f38778p);
        parcel.writeString(this.f38779q);
        parcel.writeString(this.f38780r);
        parcel.writeString(this.f38781s);
        parcel.writeString(this.f38782t);
        parcel.writeString(this.f38783u);
    }
}
