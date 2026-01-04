package com.huawei.hms.framework.common;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BundleUtil {
    public static final String TAG = "BundleUtil";
    public static final String UNDERLINE_TAG = "_";

    public static String bundleToJson(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            return jSONObject.toString();
        }
        try {
            for (String str : bundle.keySet()) {
                jSONObject.put(str, String.valueOf(bundle.get(str)));
            }
        } catch (JSONException unused) {
            Logger.m32138e(TAG, "bundleToJson meet error");
        }
        return jSONObject.toString();
    }

    public static Bundle jsonToBundle(String str) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str)) {
            return bundle;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle.putString(next, jSONObject.optString(next));
            }
        } catch (JSONException unused) {
            Logger.m32138e(TAG, "jsonToBundle meet error");
        }
        return bundle;
    }

    public static String transPkgPrefix(String str) {
        StringBuilder sb2 = new StringBuilder();
        if (str != null && str.contains(".")) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length > 0) {
                for (String str2 : strArrSplit) {
                    sb2.append(str2);
                }
            }
            sb2.append("_");
        }
        return sb2.toString();
    }
}
