package com.huawei.hms.drive;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.drive.C5298t;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.drive.q */
/* loaded from: classes8.dex */
public class C5295q {
    /* renamed from: a */
    public static C5298t m31777a(C5298t c5298t, String str) {
        if (TextUtils.isEmpty(str)) {
            return c5298t;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C5298t.a.C14437a().m31816b(str).m31815a());
        c5298t.m31802a(arrayList);
        return c5298t;
    }

    /* renamed from: a */
    public static C5298t m31778a(String str) throws JSONException {
        Logger.m32143v("DNKeeperCallable", "parseResponse: " + str);
        C5298t c5298t = new C5298t();
        if (TextUtils.isEmpty(str)) {
            return c5298t;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            c5298t.m31801a(string);
            JSONArray jSONArray = jSONObject.getJSONArray(DnsResult.KEY_ADDRESSLIST);
            c5298t.m31800a(jSONObject.getLong("createTime"));
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i10);
                String string2 = jSONObject2.getString("value");
                if (!TextUtils.isEmpty(string2)) {
                    if ("CNAME".equals(string)) {
                        c5298t.m31801a(m31781a(arrayList, arrayList2, jSONObject2, string2));
                    } else {
                        m31783a(arrayList, arrayList2, new C5298t.a.C14437a().m31816b(string2).m31814a(jSONObject2.getString("type")).m31813a(jSONObject2.getLong("ttl") * 1000).m31815a());
                    }
                }
            }
            m31784a(arrayList, arrayList2, c5298t);
            return c5298t;
        } catch (JSONException e10) {
            Logger.m32146w("DNKeeperCallable", "parseResponse", e10);
            m31784a(arrayList, arrayList2, c5298t);
            return c5298t;
        }
    }

    /* renamed from: a */
    public static String m31779a(C5291m c5291m) {
        return c5291m != null ? m31782a(c5291m, ContextHolder.getAppContext()).toString() : "";
    }

    /* renamed from: a */
    public static String m31780a(HashSet<C5291m> hashSet) throws JSONException {
        Context appContext = ContextHolder.getAppContext();
        if (hashSet == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<C5291m> it = hashSet.iterator();
        while (it.hasNext()) {
            jSONArray.put(m31782a(it.next(), appContext));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("queryInfos", jSONArray);
        } catch (JSONException e10) {
            Logger.m32147w("DNKeeperCallable", "getRequestStr :", e10.getClass().getSimpleName());
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private static String m31781a(List<C5298t.a> list, List<C5298t.a> list2, JSONObject jSONObject, String str) throws JSONException, UnknownHostException {
        Logger.m32142i("DNKeeperCallable", "Type is cname, and user localDns to parse %s", str);
        try {
            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                m31783a(list, list2, new C5298t.a.C14437a().m31816b(inetAddress.getHostAddress()).m31813a(jSONObject.getLong("ttl") * 1000).m31814a(inetAddress instanceof Inet4Address ? "A" : "AAAA").m31815a());
            }
        } catch (IllegalArgumentException | NullPointerException e10) {
            Logger.m32146w("DNKeeperCallable", "DNKeeperManager parseResponse failed, Exception: " + str, e10);
        } catch (UnknownHostException unused) {
            Logger.m32145w("DNKeeperCallable", "DNKeeperManager parseResponse failed,UnknownHostException:" + str);
        }
        return (list.isEmpty() || list2.isEmpty()) ? (!list.isEmpty() || list2.isEmpty()) ? "A" : "AAAA" : "ALL";
    }

    /* renamed from: a */
    private static JSONObject m31782a(C5291m c5291m, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String strM31758b = c5291m.m31758b();
        if (TextUtils.isEmpty(strM31758b) && context != null) {
            strM31758b = context.getPackageName();
        }
        try {
            jSONObject.put("DomainName", c5291m.m31754a());
            jSONObject.put("ApkName", strM31758b);
            jSONObject.put("DnsFailType", c5291m.m31760c());
            jSONObject.put("FailIP", c5291m.m31761d());
            jSONObject.put("accelerate", c5291m.m31763f());
            jSONObject.put("type", c5291m.m31762e());
        } catch (JSONException e10) {
            Logger.m32146w("DNKeeperCallable", "getRequestStr", e10);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static void m31783a(List<C5298t.a> list, List<C5298t.a> list2, C5298t.a aVar) {
        if (aVar.m31807a().equalsIgnoreCase("A")) {
            list.add(aVar);
        } else {
            list2.add(aVar);
        }
    }

    /* renamed from: a */
    private static void m31784a(List<C5298t.a> list, List<C5298t.a> list2, C5298t c5298t) {
        if (list.isEmpty() || list2.isEmpty()) {
            c5298t.m31803b().addAll(list);
            c5298t.m31803b().addAll(list2);
            return;
        }
        int iMax = Math.max(list.size(), list2.size());
        for (int i10 = 0; i10 < iMax; i10++) {
            if (i10 < list.size()) {
                c5298t.m31803b().add(list.get(i10));
            }
            if (i10 < list2.size()) {
                c5298t.m31803b().add(list2.get(i10));
            }
        }
    }

    /* renamed from: a */
    public static void m31785a(JSONArray jSONArray, int i10, String str, String str2, long j10) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", str);
            jSONObject.put("value", str2);
            jSONObject.put("ttl", j10);
            jSONArray.put(i10, jSONObject);
        } catch (JSONException e10) {
            Logger.m32146w("DNKeeperCallable", "JSONException", e10);
            throw e10;
        }
    }

    /* renamed from: a */
    public static boolean m31786a(C5298t c5298t) {
        return c5298t == null || c5298t.m31805d();
    }

    /* renamed from: a */
    public static boolean m31787a(PLSharedPreferences pLSharedPreferences, String str) throws JSONException {
        if (pLSharedPreferences == null) {
            return true;
        }
        C5298t c5298tM31778a = m31778a(pLSharedPreferences.getString(str));
        if (!m31786a(c5298tM31778a)) {
            if (System.currentTimeMillis() - c5298tM31778a.m31804c() < 604800000) {
                return false;
            }
        }
        return true;
    }
}
