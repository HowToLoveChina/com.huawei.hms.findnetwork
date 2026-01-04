package com.huawei.hwidauth.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class ReadAllowListInfo implements Parcelable {
    public static final Parcelable.Creator<ReadAllowListInfo> CREATOR = new C6696a();

    /* renamed from: com.huawei.hwidauth.datatype.ReadAllowListInfo$a */
    public class C6696a implements Parcelable.Creator<ReadAllowListInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadAllowListInfo createFromParcel(Parcel parcel) {
            return new ReadAllowListInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReadAllowListInfo[] newArray(int i10) {
            return new ReadAllowListInfo[i10];
        }
    }

    public ReadAllowListInfo(Parcel parcel) {
    }

    /* renamed from: a */
    public static void m38019a(XmlPullParser xmlPullParser, ArrayList<String> arrayList, String str) {
        if (xmlPullParser == null || str == null) {
            return;
        }
        if ("hosts".equals(xmlPullParser.getAttributeName(0))) {
            String attributeValue = xmlPullParser.getAttributeValue(0);
            if (TextUtils.isEmpty(attributeValue)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(attributeValue);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    arrayList.add(jSONArray.getString(i10));
                }
            } catch (JSONException unused) {
                C12836o.m77097b("ReadAllowListInfo", "JSONException", true);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
    }
}
