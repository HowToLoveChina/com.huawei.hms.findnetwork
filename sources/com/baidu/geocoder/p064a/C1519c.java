package com.baidu.geocoder.p064a;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.baidu.location.p065a.C1530b;
import com.baidu.location.p065a.C1533e;
import com.baidu.location.p065a.C1534f;
import com.baidu.location.provider.C1540c;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.OsType;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.geocoder.a.c */
/* loaded from: classes.dex */
public class C1519c {

    /* renamed from: a */
    private final int f6522a = 3;

    /* renamed from: b */
    private final int f6523b = 6;

    /* renamed from: c */
    private String f6524c = null;

    /* renamed from: a */
    public String m8635a(double d10, double d11, String str) {
        String str2;
        String strM8637a = C1520d.m8637a(d10, d11, str);
        String str3 = "";
        if (TextUtils.isEmpty(C1534f.f6664j) || TextUtils.isEmpty(strM8637a)) {
            str2 = " getRGCDataFromNetPost(), get domain or get param to post is empty.";
        } else {
            C1534f.m8725c("rgc url = " + (C1534f.f6664j + Constants.QUESTION_STR + strM8637a));
            C1534f.m8725c("getRGCDataFromNetPost(): strDomain:" + C1534f.f6664j + "\n strParam: " + strM8637a);
            this.f6524c = "";
            for (int i10 = 3; i10 > 0; i10--) {
                String strM8708a = C1533e.m8708a(C1534f.f6664j, strM8637a);
                this.f6524c = strM8708a;
                if (!TextUtils.isEmpty(strM8708a)) {
                    break;
                }
            }
            if (!TextUtils.isEmpty(this.f6524c)) {
                try {
                    str3 = this.f6524c;
                    C1534f.m8725c("rgc res = " + str3);
                    return str3;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return str3;
                }
            }
            str2 = "getRGCDataFromNetPost(), the straData get from net post is empty!";
        }
        C1534f.m8725c(str2);
        return "";
    }

    /* renamed from: a */
    public String m8636a(String str, double d10, double d11, double d12, double d13, int i10, Handler handler) throws JSONException {
        this.f6524c = "";
        try {
            String strM8827f = C1540c.m8807a(LocationClient.mContext).m8827f();
            String str2 = C1534f.f6675u;
            C1534f.m8725c("GC_URL==https://newclient.map.baidu.com/client/infopass/infopass/mecp ,strKeyword =" + str);
            C1534f.m8725c("par = " + strM8827f);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JsbMapKeyNames.H5_LOC_LON, d10);
            jSONObject.put(JsbMapKeyNames.H5_LOC_LAT, d13);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(JsbMapKeyNames.H5_LOC_LON, d12);
            jSONObject2.put(JsbMapKeyNames.H5_LOC_LAT, d11);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("oem", "huawei");
            jSONObject3.put("prod", C1534f.f6660f + LocationClient.mContext.getPackageName());
            jSONObject3.put("mb", Build.PRODUCT);
            jSONObject3.put("os", OsType.ANDROID + Build.VERSION.RELEASE);
            jSONObject3.put("mpk", "9e3eb12274ec8961114fe5487682be41");
            jSONObject3.put("cuid", str2);
            jSONObject3.put("bloc", Jni.encodeOfflineLocationUpdateRequest(strM8827f));
            jSONObject3.put("bottomleft", jSONObject);
            jSONObject3.put("topright", jSONObject2);
            jSONObject3.put("keyword", str);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("method", "getPreciseGeocode");
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("serverid", jSONObject4);
            jSONObject5.put(RemoteMessageConst.MessageBody.PARAM, jSONObject3);
            C1534f.m8725c("obj =" + jSONObject5.toString());
            C1534f.m8725c("prod =SDKHW5.5.10:buildn817:" + LocationClient.mContext.getPackageName());
            this.f6524c = m8634a(C1534f.f6662h, jSONObject5);
        } catch (Exception e10) {
            C1534f.m8725c("GC出现异常");
            e10.printStackTrace();
        }
        return this.f6524c;
    }

    /* renamed from: a */
    private String m8634a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            C1534f.m8725c("getDataFromNet(), url to http get() is empty");
            return null;
        }
        String strM8708a = "";
        int i10 = 0;
        while (TextUtils.isEmpty(strM8708a)) {
            int i11 = i10 + 1;
            if (i10 >= 6) {
                break;
            }
            C1534f.m8725c("getDataFromNet(), url to http get() is :" + str);
            try {
                strM8708a = C1533e.m8708a(str, C1530b.m8686a(jSONObject.toString()));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            i10 = i11;
        }
        return strM8708a;
    }
}
