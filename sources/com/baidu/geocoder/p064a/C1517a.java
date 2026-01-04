package com.baidu.geocoder.p064a;

import android.text.TextUtils;
import com.baidu.location.p065a.C1530b;
import com.baidu.location.p065a.C1534f;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.geocoder.a.a */
/* loaded from: classes.dex */
public class C1517a {

    /* renamed from: a */
    public C1522f f6516a = new C1522f();

    /* renamed from: b */
    public ArrayList<C1524h> f6517b = new ArrayList<>();

    /* renamed from: c */
    private C1519c f6518c = new C1519c();

    /* renamed from: a */
    public boolean m8629a(double d10, double d11, String str) throws NumberFormatException {
        try {
            String strM8635a = this.f6518c.m8635a(d10, d11, str);
            if (!TextUtils.isEmpty(strM8635a) && !strM8635a.equals("")) {
                C1534f.m8725c("getReverseGeoCode(),GeoCodeFromNet return the strJsonData: " + strM8635a);
                boolean zM8647a = this.f6516a.m8647a(new JSONObject(strM8635a));
                C1534f.m8725c("getReverseGeoCode(), 解析逆地理编码（RGC）结果为：" + zM8647a);
                return zM8647a;
            }
            C1534f.m8725c("getReverseGeoCode, GeoCodeFromNet return  from getRGCDataFromNetPost() is not get!");
            return false;
        } catch (JSONException e10) {
            C1534f.m8725c("getReverseGeoCode(), JSONException msg:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public boolean m8630a(String str, double d10, double d11, double d12, double d13, int i10) throws JSONException {
        String strM8691b;
        JSONObject jSONObjectOptJSONObject;
        this.f6516a.m8646a();
        this.f6517b.clear();
        String strM8636a = this.f6518c.m8636a(str, d10, d11, d12, d13, i10, null);
        if (strM8636a == null || strM8636a == "" || strM8636a.length() == 0) {
            C1534f.m8725c("searchInBounds, return from GeoCodeFromNet is empty.");
            return false;
        }
        C1534f.m8725c("searchInBounds(),GeoCodeFromNet return the strJsonData: " + strM8636a);
        try {
            strM8691b = C1530b.m8691b(strM8636a);
            C1534f.m8725c("res = " + strM8691b);
        } catch (Exception unused) {
        }
        if ("".equals(strM8691b) && strM8691b == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject(strM8691b);
        int iOptInt = jSONObject.optInt("flag");
        int iOptInt2 = jSONObject.optInt("msgcode");
        if (iOptInt == 0 && iOptInt2 == 0 && (jSONObjectOptJSONObject = jSONObject.optJSONObject(TrackConstants$Opers.RESPONSE)) != null) {
            if (jSONObjectOptJSONObject.has(JsbMapKeyNames.H5_LOC_LON)) {
                this.f6516a.f6531d = jSONObjectOptJSONObject.optDouble(JsbMapKeyNames.H5_LOC_LON);
            }
            if (jSONObjectOptJSONObject.has(JsbMapKeyNames.H5_LOC_LAT)) {
                this.f6516a.f6532e = jSONObjectOptJSONObject.optDouble(JsbMapKeyNames.H5_LOC_LAT);
            }
            C1522f c1522f = this.f6516a;
            if ((0.0d != c1522f.f6532e) & (0.0d != c1522f.f6531d)) {
                return true;
            }
        }
        return false;
    }
}
