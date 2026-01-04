package com.huawei.updatesdk.p191b.p198e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.updatesdk.b.e.d */
/* loaded from: classes9.dex */
class C8825d {
    /* renamed from: a */
    private static String m56284a(Context context, String str) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        byte[] bArr = new byte[inputStreamOpen.available()];
        C8774a.m56009b("JsonPareUrl", "loadJSONFromAsset code: " + inputStreamOpen.read(bArr));
        inputStreamOpen.close();
        return new String(bArr, Constants.UTF_8);
    }

    /* renamed from: a */
    public static String m56285a(Context context, String str, String str2) throws JSONException {
        String string = "";
        try {
            JSONArray jSONArray = new JSONObject(m56284a(context, str)).getJSONArray("services");
            JSONArray jSONArray2 = jSONArray.getJSONObject(0).getJSONArray("servings");
            for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i10);
                if (TextUtils.equals(str2, jSONObject.getString("countryOrAreaGroup"))) {
                    string = jSONObject.getJSONObject("addresses").getString("ROOT");
                }
            }
        } catch (Exception unused) {
            C8774a.m56008a("JsonPareUrl", "Failed to obtain the default url.");
        }
        return string;
    }
}
