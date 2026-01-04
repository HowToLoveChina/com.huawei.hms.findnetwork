package com.huawei.hwidauth.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class SiteListInfo implements Parcelable {
    public static final Parcelable.Creator<SiteListInfo> CREATOR = new C6698a();

    /* renamed from: a */
    public int f31034a = 0;

    /* renamed from: b */
    public String f31035b = "";

    /* renamed from: c */
    public String f31036c = "";

    /* renamed from: d */
    public String f31037d = "";

    /* renamed from: com.huawei.hwidauth.datatype.SiteListInfo$a */
    public class C6698a implements Parcelable.Creator<SiteListInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SiteListInfo createFromParcel(Parcel parcel) {
            SiteListInfo siteListInfo = new SiteListInfo();
            siteListInfo.f31034a = parcel.readInt();
            siteListInfo.f31035b = parcel.readString();
            siteListInfo.f31036c = parcel.readString();
            siteListInfo.f31037d = parcel.readString();
            return siteListInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SiteListInfo[] newArray(int i10) {
            return new SiteListInfo[i10];
        }
    }

    /* renamed from: f */
    public static String m38040f(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.getString(str) : "";
    }

    /* renamed from: h */
    public static void m38041h(XmlPullParser xmlPullParser, SiteListInfo siteListInfo, int i10) {
        String attributeName = xmlPullParser.getAttributeName(i10);
        String attributeValue = xmlPullParser.getAttributeValue(i10);
        if (attributeName.equals("id")) {
            siteListInfo.m38047g(siteListInfo.m38046d(attributeValue));
            return;
        }
        if (attributeName.equals("domain")) {
            try {
                JSONObject jSONObject = new JSONObject(attributeValue);
                siteListInfo.f31035b = m38040f(jSONObject, "cas").trim();
                siteListInfo.f31037d = m38040f(jSONObject, "honor-cas").trim();
                siteListInfo.f31036c = m38040f(jSONObject, "as").trim();
            } catch (JSONException e10) {
                C12836o.m77099d("SiteListInfo", "parseJSONArrayInfos JSONException: " + e10.getClass().getSimpleName(), true);
            } catch (Exception e11) {
                C12836o.m77099d("SiteListInfo", "parseJSONArrayInfos Exception: " + e11.getClass().getSimpleName(), true);
            }
        }
    }

    /* renamed from: i */
    public static void m38042i(XmlPullParser xmlPullParser, SiteListInfo siteListInfo, String str) {
        if (xmlPullParser == null || siteListInfo == null || str == null) {
            C12836o.m77099d("SiteListInfo", "param is null.", true);
        } else if ("site".equals(str)) {
            for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
                m38041h(xmlPullParser, siteListInfo, i10);
            }
        }
    }

    /* renamed from: a */
    public int m38045a() {
        return this.f31034a;
    }

    /* renamed from: d */
    public final int m38046d(String str) {
        try {
            return m38048j(str);
        } catch (Exception e10) {
            C12836o.m77099d("SiteListInfo", "e = " + e10.getClass().getSimpleName(), true);
            return 0;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: g */
    public final void m38047g(int i10) {
        this.f31034a = i10;
    }

    /* renamed from: j */
    public final int m38048j(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e10) {
            C12836o.m77099d("SiteListInfo", "parsError " + e10.getClass().getSimpleName(), true);
            return -1;
        }
    }

    /* renamed from: l */
    public String m38049l() {
        return this.f31035b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f31034a);
        parcel.writeString(this.f31037d);
        parcel.writeString(this.f31035b);
        parcel.writeString(this.f31036c);
    }
}
