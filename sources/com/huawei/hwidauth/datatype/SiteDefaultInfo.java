package com.huawei.hwidauth.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class SiteDefaultInfo implements Parcelable {
    public static final Parcelable.Creator<SiteDefaultInfo> CREATOR = new C6697a();

    /* renamed from: a */
    public String f31029a = "";

    /* renamed from: b */
    public String f31030b = "";

    /* renamed from: c */
    public String f31031c = "";

    /* renamed from: d */
    public String f31032d = "";

    /* renamed from: e */
    public String f31033e = "";

    /* renamed from: com.huawei.hwidauth.datatype.SiteDefaultInfo$a */
    public class C6697a implements Parcelable.Creator<SiteDefaultInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SiteDefaultInfo createFromParcel(Parcel parcel) {
            SiteDefaultInfo siteDefaultInfo = new SiteDefaultInfo();
            siteDefaultInfo.f31029a = parcel.readString();
            siteDefaultInfo.f31030b = parcel.readString();
            siteDefaultInfo.f31031c = parcel.readString();
            siteDefaultInfo.f31032d = parcel.readString();
            return siteDefaultInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SiteDefaultInfo[] newArray(int i10) {
            return new SiteDefaultInfo[i10];
        }
    }

    /* renamed from: d */
    public static String m38023d(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.getString(str) : "";
    }

    /* renamed from: f */
    public static void m38024f(XmlPullParser xmlPullParser, SiteDefaultInfo siteDefaultInfo) {
        try {
            if ("domain".equals(xmlPullParser.getAttributeName(0))) {
                JSONObject jSONObject = new JSONObject(xmlPullParser.getAttributeValue(0));
                siteDefaultInfo.m38029e(m38023d(jSONObject, "logout").trim());
                siteDefaultInfo.m38031i(m38023d(jSONObject, "qrauth").trim());
                siteDefaultInfo.m38033m(m38023d(jSONObject, "cas").trim());
                siteDefaultInfo.m38035p(m38023d(jSONObject, "honor-cas").trim());
                siteDefaultInfo.m38034o(m38023d(jSONObject, "as").trim());
            }
        } catch (JSONException e10) {
            C12836o.m77097b("SiteDefaultInfo", "parseJSONArrayInfos JSONException: " + e10.getClass().getSimpleName(), true);
        } catch (Exception e11) {
            C12836o.m77097b("SiteDefaultInfo", "parseJSONArrayInfos Exception: " + e11.getClass().getSimpleName(), true);
        }
    }

    /* renamed from: a */
    public String m38028a() {
        return this.f31029a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public final void m38029e(String str) {
        this.f31029a = str;
    }

    /* renamed from: g */
    public String m38030g() {
        return this.f31030b;
    }

    /* renamed from: i */
    public final void m38031i(String str) {
        this.f31030b = str;
    }

    /* renamed from: j */
    public String m38032j() {
        return this.f31031c;
    }

    /* renamed from: m */
    public final void m38033m(String str) {
        this.f31031c = str;
    }

    /* renamed from: o */
    public final void m38034o(String str) {
        this.f31033e = str;
    }

    /* renamed from: p */
    public final void m38035p(String str) {
        this.f31032d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31029a);
        parcel.writeString(this.f31030b);
        parcel.writeString(this.f31031c);
        parcel.writeString(this.f31032d);
    }
}
