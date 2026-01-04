package com.huawei.hms.videokit.player;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlsCallBack;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.videokit.player.s */
/* loaded from: classes8.dex */
public class C6597s {

    /* renamed from: a */
    private static Context f30667a = null;

    /* renamed from: b */
    private static GrsClient f30668b = null;

    /* renamed from: c */
    private static boolean f30669c = false;

    /* renamed from: d */
    private static String f30670d = "";

    /* renamed from: com.huawei.hms.videokit.player.s$a */
    public static class a implements IQueryUrlsCallBack {
        @Override // com.huawei.hms.framework.network.grs.IQueryUrlsCallBack
        public void onCallBackFail(int i10) {
            C6550c1.m37264c("GrsManager", "grs url onCallBackFail =" + i10);
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlsCallBack
        public void onCallBackSuccess(Map<String, String> map) {
            C6550c1.m37264c("GrsManager", "grs url onCallBackSuccess");
            if (map == null) {
                C6550c1.m37264c("GrsManager", "get grs url is empty");
                return;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                C6550c1.m37256a("GrsManager", entry.getKey() + ":" + entry.getValue());
            }
        }
    }

    /* renamed from: a */
    public static String m37640a() {
        return f30670d;
    }

    /* renamed from: b */
    public static synchronized String m37643b(Context context, String str) throws JSONException {
        try {
            String country = f30670d;
            if (C6600t0.m37683c(country)) {
                country = Locale.getDefault().getCountry();
                if (C6600t0.m37683c(country)) {
                    country = C6581j0.m37455a();
                }
            }
            if (C6600t0.m37683c(country)) {
                C6550c1.m37262b("GrsManager", "service Country is abnormal");
                return null;
            }
            if (C6600t0.m37683c(str)) {
                C6550c1.m37265d("GrsManager", "parseGrsLocalJson grsConfigKey empty");
                return null;
            }
            String strM37594a = C6593p0.m37594a(context, "grs_sdk_global_route_config_videoplayerkit.json");
            if (C6600t0.m37683c(strM37594a)) {
                C6550c1.m37262b("GrsManager", "grs json is abnormal");
                return null;
            }
            JSONArray jSONArrayOptJSONArray = new JSONObject(strM37594a).optJSONArray("services");
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONObject(0).optJSONArray("countryOrAreaGroups");
            boolean z10 = false;
            String strOptString = null;
            for (int i10 = 0; i10 < jSONArrayOptJSONArray2.length() && !z10; i10++) {
                JSONArray jSONArrayOptJSONArray3 = jSONArrayOptJSONArray2.optJSONObject(i10).optJSONArray("countriesOrAreas");
                int i11 = 0;
                while (true) {
                    if (i11 >= jSONArrayOptJSONArray3.length()) {
                        break;
                    }
                    if (jSONArrayOptJSONArray3.optString(i11).equals(country)) {
                        strOptString = jSONArrayOptJSONArray2.getJSONObject(i10).optString("id");
                        C6550c1.m37256a("GrsManager", "countryGroups id:" + strOptString);
                        z10 = true;
                        break;
                    }
                    i11++;
                }
            }
            if (C6600t0.m37683c(strOptString)) {
                C6550c1.m37262b("GrsManager", "countryGroups id is abnormal");
                return null;
            }
            JSONArray jSONArrayOptJSONArray4 = jSONArrayOptJSONArray.optJSONObject(0).optJSONArray("servings");
            for (int i12 = 0; i12 < jSONArrayOptJSONArray4.length(); i12++) {
                if (jSONArrayOptJSONArray4.optJSONObject(i12).optString("countryOrAreaGroup").equals(strOptString)) {
                    return jSONArrayOptJSONArray4.optJSONObject(i12).optJSONObject("addresses").optString(str);
                }
            }
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public static synchronized String m37641a(String str) throws JSONException {
        try {
            if (!f30669c) {
                return null;
            }
            C6550c1.m37256a("GrsManager", "start query grs url");
            String strSynGetGrsUrl = f30668b.synGetGrsUrl("com.huawei.hms.videokit.player", str);
            if (C6600t0.m37683c(strSynGetGrsUrl)) {
                C6550c1.m37264c("GrsManager", "grs local json parse");
                strSynGetGrsUrl = m37643b(f30667a, str);
            }
            C6550c1.m37256a("GrsManager", "serverName:" + str + " grs url:" + strSynGetGrsUrl);
            return strSynGetGrsUrl;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public static void m37642a(Context context, String str) {
        C6550c1.m37264c("GrsManager", "init grs");
        f30667a = context;
        f30670d = str;
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(str);
        GrsClient grsClient = new GrsClient(context, grsBaseInfo);
        f30668b = grsClient;
        grsClient.ayncGetGrsUrls("com.huawei.hms.videokit.player", new a());
        f30669c = true;
    }
}
