package iq;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p640sq.C12836o;

/* renamed from: iq.c */
/* loaded from: classes8.dex */
public class C10589c {
    /* renamed from: a */
    public static String m64966a(String str, String str2, String str3, String str4) throws JSONException {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(JsbMapKeyNames.H5_DEVICE_TYPE, "0");
                jSONObject2.put("deviceID", str);
                jSONArray.put(jSONObject2);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(JsbMapKeyNames.H5_DEVICE_TYPE, "6");
                jSONObject3.put("deviceID", str2);
                jSONArray.put(jSONObject3);
            }
            if (!TextUtils.isEmpty(str3)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(JsbMapKeyNames.H5_DEVICE_TYPE, "8");
                jSONObject4.put("deviceID", str3);
                jSONArray.put(jSONObject4);
            }
            if (!TextUtils.isEmpty(str4)) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(JsbMapKeyNames.H5_DEVICE_TYPE, "9");
                jSONObject5.put("deviceID", str4);
                jSONArray.put(jSONObject5);
            }
            jSONObject.put(CommonPickerConstant.RequestParams.KEY_DEVICE_INFO, jSONArray);
        } catch (JSONException unused) {
            C12836o.m77099d("DeviceUtil", "getDeviceInfo JSONException", true);
        }
        return jSONObject.toString();
    }
}
