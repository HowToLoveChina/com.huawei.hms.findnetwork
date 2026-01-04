package com.huawei.android.hicloud.agreement.oobe;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class LanguageConfig {
    public static final String CONNECTION_SYMBOL = "-";
    public static final String TAG = "LanguageConfig";

    public static String getLanguageCode(Context context, String str) throws JSONException {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(C0209d.m1290o2(context.getAssets().open("oobe_agreement/language_config.json")));
            if (jSONObject.has("all")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("all");
                int iLastIndexOf = str.lastIndexOf("-");
                if (jSONObject2.has(str)) {
                    return jSONObject2.getString(str);
                }
                if (iLastIndexOf != -1) {
                    String strSubstring = str.substring(0, iLastIndexOf + 1);
                    if (jSONObject2.has(strSubstring)) {
                        return jSONObject2.getString(strSubstring);
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getLanguageCode exception:" + e10.toString());
        }
        return null;
    }
}
