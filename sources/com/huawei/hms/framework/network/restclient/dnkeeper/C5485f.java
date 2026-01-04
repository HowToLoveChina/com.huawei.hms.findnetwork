package com.huawei.hms.framework.network.restclient.dnkeeper;

import android.content.Context;
import android.text.TextUtils;
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

/* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.f */
/* loaded from: classes8.dex */
public class C5485f {

    /* renamed from: a */
    private static final String f25116a = "DNKeeperCallable";

    /* renamed from: a */
    public static DnsResult m32388a(DnsResult dnsResult, String str) {
        if (TextUtils.isEmpty(str)) {
            return dnsResult;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DnsResult.Address.Builder().value(str).build());
        if (dnsResult != null) {
            dnsResult.setAddressList(arrayList);
        }
        return dnsResult;
    }

    /* renamed from: a */
    public static DnsResult m32389a(String str) throws JSONException {
        Logger.m32143v(f25116a, "parseResponse: " + str);
        DnsResult dnsResult = new DnsResult();
        if (TextUtils.isEmpty(str)) {
            return dnsResult;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            dnsResult.setType(string);
            JSONArray jSONArray = jSONObject.getJSONArray(DnsResult.KEY_ADDRESSLIST);
            dnsResult.setCreateTime(jSONObject.getLong("createTime"));
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i10);
                String string2 = jSONObject2.getString("value");
                if (!TextUtils.isEmpty(string2)) {
                    if ("CNAME".equals(string)) {
                        dnsResult.setType(m32392a(arrayList, arrayList2, jSONObject2, string2));
                    } else {
                        m32394a(arrayList, arrayList2, new DnsResult.Address.Builder().value(string2).type(jSONObject2.getString("type")).ttl(jSONObject2.getLong("ttl") * 1000).build());
                    }
                }
            }
            m32395a(arrayList, arrayList2, dnsResult);
            return dnsResult;
        } catch (JSONException e10) {
            Logger.m32146w(f25116a, "parseResponse", e10);
            m32395a(arrayList, arrayList2, dnsResult);
            return dnsResult;
        }
    }

    /* renamed from: a */
    public static String m32390a(RequestHost requestHost) {
        return requestHost != null ? m32393a(requestHost, ContextHolder.getAppContext()).toString() : "";
    }

    /* renamed from: a */
    public static String m32391a(HashSet<RequestHost> hashSet) throws JSONException {
        Context appContext = ContextHolder.getAppContext();
        if (hashSet == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<RequestHost> it = hashSet.iterator();
        while (it.hasNext()) {
            jSONArray.put(m32393a(it.next(), appContext));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("queryInfos", jSONArray);
        } catch (JSONException e10) {
            Logger.m32147w(f25116a, "getRequestStr :", e10.getClass().getSimpleName());
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private static String m32392a(List<DnsResult.Address> list, List<DnsResult.Address> list2, JSONObject jSONObject, String str) throws JSONException, UnknownHostException {
        Logger.m32142i(f25116a, "Type is cname, and user localDns to parse %s", str);
        try {
            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                m32394a(list, list2, new DnsResult.Address.Builder().value(inetAddress.getHostAddress()).ttl(jSONObject.getLong("ttl") * 1000).type(inetAddress instanceof Inet4Address ? "A" : "AAAA").build());
            }
        } catch (IllegalArgumentException | NullPointerException e10) {
            Logger.m32146w(f25116a, "DNKeeperManager parseResponse failed, Exception: " + str, e10);
        } catch (UnknownHostException unused) {
            Logger.m32145w(f25116a, "DNKeeperManager parseResponse failed,UnknownHostException:" + str);
        }
        return (list.isEmpty() || list2.isEmpty()) ? (!list.isEmpty() || list2.isEmpty()) ? "A" : "AAAA" : "ALL";
    }

    /* renamed from: a */
    private static JSONObject m32393a(RequestHost requestHost, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String apkName = requestHost.getApkName();
        if (TextUtils.isEmpty(apkName) && context != null) {
            apkName = context.getPackageName();
        }
        try {
            jSONObject.put("DomainName", requestHost.getDomainName());
            jSONObject.put("ApkName", apkName);
            jSONObject.put("DnsFailType", requestHost.getDnsFailType());
            jSONObject.put("FailIP", requestHost.getFailIP());
            jSONObject.put("accelerate", requestHost.getAccelerate());
            jSONObject.put("type", requestHost.getType());
        } catch (JSONException e10) {
            Logger.m32146w(f25116a, "getRequestStr", e10);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static void m32394a(List<DnsResult.Address> list, List<DnsResult.Address> list2, DnsResult.Address address) {
        if (address.getType().equalsIgnoreCase("A")) {
            list.add(address);
        } else {
            list2.add(address);
        }
    }

    /* renamed from: a */
    private static void m32395a(List<DnsResult.Address> list, List<DnsResult.Address> list2, DnsResult dnsResult) {
        if (list.isEmpty() || list2.isEmpty()) {
            dnsResult.getAddressList().addAll(list);
            dnsResult.getAddressList().addAll(list2);
            return;
        }
        int iMax = Math.max(list.size(), list2.size());
        for (int i10 = 0; i10 < iMax; i10++) {
            if (i10 < list.size()) {
                dnsResult.getAddressList().add(list.get(i10));
            }
            if (i10 < list2.size()) {
                dnsResult.getAddressList().add(list2.get(i10));
            }
        }
    }

    /* renamed from: a */
    public static void m32396a(JSONArray jSONArray, int i10, String str, String str2, long j10) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", str);
            jSONObject.put("value", str2);
            jSONObject.put("ttl", j10);
            jSONArray.put(i10, jSONObject);
        } catch (JSONException e10) {
            Logger.m32146w(f25116a, "JSONException", e10);
            throw e10;
        }
    }

    /* renamed from: a */
    public static boolean m32397a(PLSharedPreferences pLSharedPreferences, String str) throws JSONException {
        if (pLSharedPreferences == null) {
            return true;
        }
        DnsResult dnsResultM32389a = m32389a(pLSharedPreferences.getString(str));
        if (!m32398a(dnsResultM32389a)) {
            if (System.currentTimeMillis() - dnsResultM32389a.getCreateTime() < 604800000) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m32398a(DnsResult dnsResult) {
        return dnsResult == null || dnsResult.isEmpty();
    }
}
