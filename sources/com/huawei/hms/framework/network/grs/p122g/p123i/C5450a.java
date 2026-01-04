package com.huawei.hms.framework.network.grs.p122g.p123i;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5454d;
import com.huawei.hms.framework.network.grs.p125h.C5457c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.i.a */
/* loaded from: classes8.dex */
public class C5450a {

    /* renamed from: a */
    private static final String f24990a = "a";

    /* renamed from: b */
    private static C5454d f24991b;

    /* renamed from: c */
    private static final Object f24992c = new Object();

    /* renamed from: a */
    public static C5454d m32303a(Context context) {
        ArrayList arrayList;
        synchronized (f24992c) {
            try {
                if (f24991b != null) {
                    String str = f24990a;
                    Object[] objArr = new Object[1];
                    objArr[0] = context == null ? "" : context.getPackageName();
                    Logger.m32142i(str, "getGrsServerBean pkg:%s, GrsServerBean exists.", objArr);
                    return f24991b;
                }
                if (context == null) {
                    Logger.m32141i(f24990a, "getGrsServerBean context is invalid.");
                    return null;
                }
                String str2 = f24990a;
                Logger.m32141i(str2, "getGrsServerBean parse ServerConfig");
                String strM32327a = C5457c.m32327a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
                Logger.m32141i(str2, "getGrsServerBean got Content:" + StringUtils.anonymizeMessage(strM32327a));
                if (TextUtils.isEmpty(strM32327a)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(strM32327a).getJSONObject("grs_server");
                    JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                            arrayList.add(jSONArray.get(i10).toString());
                        }
                    }
                    String str3 = f24990a;
                    Logger.m32141i(str3, "getGrsServerBean create GrsServerBean");
                    C5454d c5454d = new C5454d();
                    f24991b = c5454d;
                    c5454d.m32316a(arrayList);
                    f24991b.m32315a(jSONObject.getString("grs_query_endpoint_2.0"));
                    f24991b.m32314a(jSONObject.getInt("grs_query_timeout"));
                    Logger.m32142i(str3, "getGrsServerBean end, package:%s", context.getPackageName());
                } catch (JSONException e10) {
                    Logger.m32147w(f24990a, "getGrsServerBean catch JSONException: %s   ___ package:%s ____ content:%s", StringUtils.anonymizeMessage(e10.getMessage()), context.getPackageName(), StringUtils.anonymizeMessage(strM32327a));
                    f24991b = null;
                }
                return f24991b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
