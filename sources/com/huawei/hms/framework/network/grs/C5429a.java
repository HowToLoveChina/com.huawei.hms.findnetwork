package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.huawei.hms.framework.network.grs.p120e.C5434a;
import com.huawei.hms.framework.network.grs.p120e.C5435b;
import com.huawei.hms.framework.network.grs.p120e.C5436c;
import com.huawei.hms.framework.network.grs.p121f.C5438b;
import com.huawei.hms.framework.network.grs.p122g.C5445d;
import com.huawei.hms.framework.network.grs.p122g.C5448g;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5453c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.a */
/* loaded from: classes8.dex */
public class C5429a {

    /* renamed from: e */
    private static final String f24877e = "a";

    /* renamed from: a */
    private final GrsBaseInfo f24878a;

    /* renamed from: b */
    private C5434a f24879b;

    /* renamed from: c */
    private C5448g f24880c;

    /* renamed from: d */
    private C5436c f24881d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a */
    public static class a implements InterfaceC5430b {

        /* renamed from: a */
        String f24882a;

        /* renamed from: b */
        Map<String, String> f24883b;

        /* renamed from: c */
        IQueryUrlsCallBack f24884c;

        /* renamed from: d */
        Context f24885d;

        /* renamed from: e */
        GrsBaseInfo f24886e;

        /* renamed from: f */
        C5434a f24887f;

        public a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, C5434a c5434a) {
            this.f24882a = str;
            this.f24883b = map;
            this.f24884c = iQueryUrlsCallBack;
            this.f24885d = context;
            this.f24886e = grsBaseInfo;
            this.f24887f = c5434a;
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC5430b
        /* renamed from: a */
        public void mo32159a() {
            Map<String, String> map = this.f24883b;
            if (map != null && !map.isEmpty()) {
                Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f24882a, StringUtils.anonymizeMessage(new JSONObject(this.f24883b).toString()));
                this.f24884c.onCallBackSuccess(this.f24883b);
                return;
            }
            if (this.f24883b != null) {
                Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f24882a);
                this.f24884c.onCallBackFail(-3);
                return;
            }
            Logger.m32141i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> mapM32230a = C5438b.m32226a(this.f24885d.getPackageName()).m32230a(this.f24885d, this.f24887f, this.f24886e, this.f24882a, true);
            if (mapM32230a == null || mapM32230a.isEmpty()) {
                Logger.m32140e(C5429a.f24877e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f24882a);
            }
            if (mapM32230a == null) {
                mapM32230a = new ConcurrentHashMap<>();
            }
            Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f24882a, StringUtils.anonymizeMessage(new JSONObject(mapM32230a).toString()));
            this.f24884c.onCallBackSuccess(mapM32230a);
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC5430b
        /* renamed from: a */
        public void mo32160a(C5445d c5445d) {
            String strM32284j = c5445d.m32284j();
            Map<String, String> mapM32152a = C5429a.m32152a(strM32284j, this.f24882a);
            if (!mapM32152a.isEmpty()) {
                Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f24882a, StringUtils.anonymizeMessage(new JSONObject(mapM32152a).toString()));
                this.f24884c.onCallBackSuccess(mapM32152a);
                return;
            }
            Map<String, String> map = this.f24883b;
            if (map != null && !map.isEmpty()) {
                Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f24882a, StringUtils.anonymizeMessage(new JSONObject(this.f24883b).toString()));
                this.f24884c.onCallBackSuccess(this.f24883b);
                return;
            }
            if (this.f24883b != null) {
                Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f24882a);
                this.f24884c.onCallBackFail(-5);
                return;
            }
            if (!TextUtils.isEmpty(strM32284j)) {
                Logger.m32140e(C5429a.f24877e, "The serviceName[%s] is not configured on the GRS server.", this.f24882a);
            }
            Logger.m32141i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> mapM32230a = C5438b.m32226a(this.f24885d.getPackageName()).m32230a(this.f24885d, this.f24887f, this.f24886e, this.f24882a, true);
            if (mapM32230a == null || mapM32230a.isEmpty()) {
                Logger.m32140e(C5429a.f24877e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f24882a);
            }
            if (mapM32230a == null) {
                mapM32230a = new ConcurrentHashMap<>();
            }
            Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f24882a, StringUtils.anonymizeMessage(new JSONObject(mapM32230a).toString()));
            this.f24884c.onCallBackSuccess(mapM32230a);
        }
    }

    /* renamed from: com.huawei.hms.framework.network.grs.a$b */
    public static class b implements InterfaceC5430b {

        /* renamed from: a */
        String f24888a;

        /* renamed from: b */
        String f24889b;

        /* renamed from: c */
        IQueryUrlCallBack f24890c;

        /* renamed from: d */
        String f24891d;

        /* renamed from: e */
        Context f24892e;

        /* renamed from: f */
        GrsBaseInfo f24893f;

        /* renamed from: g */
        C5434a f24894g;

        public b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, C5434a c5434a) {
            this.f24888a = str;
            this.f24889b = str2;
            this.f24890c = iQueryUrlCallBack;
            this.f24891d = str3;
            this.f24892e = context;
            this.f24893f = grsBaseInfo;
            this.f24894g = c5434a;
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC5430b
        /* renamed from: a */
        public void mo32159a() {
            if (!TextUtils.isEmpty(this.f24891d)) {
                Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f24888a, this.f24889b, StringUtils.anonymizeMessage(this.f24891d));
                this.f24890c.onCallBackSuccess(this.f24891d);
                return;
            }
            if (!TextUtils.isEmpty(this.f24891d)) {
                Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f24888a, this.f24889b);
                this.f24890c.onCallBackFail(-3);
                return;
            }
            Logger.m32141i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String strM32229a = C5438b.m32226a(this.f24892e.getPackageName()).m32229a(this.f24892e, this.f24894g, this.f24893f, this.f24888a, this.f24889b, true);
            if (strM32229a == null || strM32229a.isEmpty()) {
                Logger.m32140e(C5429a.f24877e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f24888a, this.f24889b);
            }
            Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f24888a, this.f24889b, StringUtils.anonymizeMessage(strM32229a));
            this.f24890c.onCallBackSuccess(strM32229a);
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC5430b
        /* renamed from: a */
        public void mo32160a(C5445d c5445d) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String strM32284j = c5445d.m32284j();
            Map<String, String> mapM32152a = C5429a.m32152a(strM32284j, this.f24888a);
            if (mapM32152a.containsKey(this.f24889b)) {
                String str2 = C5429a.f24877e;
                String str3 = this.f24888a;
                String str4 = this.f24889b;
                Logger.m32142i(str2, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(mapM32152a.get(str4)));
                iQueryUrlCallBack = this.f24890c;
                str = mapM32152a.get(this.f24889b);
            } else {
                if (TextUtils.isEmpty(this.f24891d)) {
                    if (!TextUtils.isEmpty(this.f24891d)) {
                        Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f24888a, this.f24889b);
                        this.f24890c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(strM32284j)) {
                        Logger.m32140e(C5429a.f24877e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f24888a, this.f24889b);
                    }
                    Logger.m32141i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                    String strM32229a = C5438b.m32226a(this.f24892e.getPackageName()).m32229a(this.f24892e, this.f24894g, this.f24893f, this.f24888a, this.f24889b, true);
                    if (strM32229a == null || strM32229a.isEmpty()) {
                        Logger.m32140e(C5429a.f24877e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f24888a, this.f24889b);
                    }
                    Logger.m32142i(C5429a.f24877e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f24888a, this.f24889b, StringUtils.anonymizeMessage(strM32229a));
                    this.f24890c.onCallBackSuccess(strM32229a);
                    return;
                }
                String str5 = C5429a.f24877e;
                String str6 = this.f24888a;
                String str7 = this.f24889b;
                Logger.m32142i(str5, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", str6, str7, StringUtils.anonymizeMessage(mapM32152a.get(str7)));
                iQueryUrlCallBack = this.f24890c;
                str = this.f24891d;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public C5429a(GrsBaseInfo grsBaseInfo, C5434a c5434a, C5448g c5448g, C5436c c5436c) {
        this.f24878a = grsBaseInfo;
        this.f24879b = c5434a;
        this.f24880c = c5448g;
        this.f24881d = c5436c;
    }

    /* renamed from: a */
    public static CountryCodeBean m32148a(Context context, boolean z10) {
        return new CountryCodeBean(context, z10);
    }

    /* renamed from: a */
    public String m32154a(Context context, String str, int i10) {
        C5445d c5445dM32297a = this.f24880c.m32297a(new C5453c(this.f24878a, context), str, this.f24881d, i10);
        return c5445dM32297a == null ? "" : c5445dM32297a.m32287m() ? this.f24879b.m32190a().m32200a(this.f24878a.getGrsParasKey(true, true, context), "") : c5445dM32297a.m32284j();
    }

    /* renamed from: a */
    public String m32155a(String str, String str2, Context context, int i10) {
        C5435b c5435b = new C5435b();
        String strM32229a = m32151a(str, c5435b, context).get(str2);
        if (c5435b.m32198a() && !TextUtils.isEmpty(strM32229a)) {
            Logger.m32142i(f24877e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(strM32229a));
            return strM32229a;
        }
        String strM32154a = m32154a(context, str, i10);
        String str3 = m32152a(strM32154a, str).get(str2);
        if (!TextUtils.isEmpty(str3)) {
            Logger.m32142i(f24877e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            return str3;
        }
        if (TextUtils.isEmpty(strM32229a)) {
            if (!TextUtils.isEmpty(strM32154a)) {
                Logger.m32140e(f24877e, "The serviceName[%s][%s] is not configured on the GRS server.", str, str2);
            }
            String str4 = f24877e;
            Logger.m32141i(str4, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
            strM32229a = C5438b.m32226a(context.getPackageName()).m32229a(context, this.f24879b, this.f24878a, str, str2, true);
            if (strM32229a == null || strM32229a.isEmpty()) {
                Logger.m32140e(str4, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str, str2);
            }
        }
        Logger.m32142i(f24877e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(strM32229a));
        return strM32229a;
    }

    /* renamed from: a */
    public static Map<String, Map<String, String>> m32150a(String str) throws JSONException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.m32143v(f24877e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, m32153a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e10) {
            Logger.m32147w(f24877e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return concurrentHashMap;
        }
    }

    /* renamed from: a */
    public Map<String, String> m32156a(String str, Context context, int i10) {
        C5435b c5435b = new C5435b();
        Map<String, String> mapM32151a = m32151a(str, c5435b, context);
        if (c5435b.m32198a() && !mapM32151a.isEmpty()) {
            Logger.m32142i(f24877e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapM32151a).toString()));
            return mapM32151a;
        }
        String strM32154a = m32154a(context, str, i10);
        Map<String, String> mapM32152a = m32152a(strM32154a, str);
        if (!mapM32152a.isEmpty()) {
            Logger.m32142i(f24877e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapM32152a).toString()));
            return mapM32152a;
        }
        if (mapM32151a.isEmpty()) {
            if (!TextUtils.isEmpty(strM32154a)) {
                Logger.m32140e(f24877e, "The serviceName[%s] is not configured on the GRS server.", str);
            }
            String str2 = f24877e;
            Logger.m32141i(str2, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
            mapM32151a = C5438b.m32226a(context.getPackageName()).m32230a(context, this.f24879b, this.f24878a, str, true);
            if (mapM32151a == null || mapM32151a.isEmpty()) {
                Logger.m32140e(str2, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str);
            }
        }
        String str3 = f24877e;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = StringUtils.anonymizeMessage(mapM32151a != null ? new JSONObject(mapM32151a).toString() : "");
        Logger.m32142i(str3, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", objArr);
        return mapM32151a;
    }

    /* renamed from: a */
    private Map<String, String> m32151a(String str, C5435b c5435b, Context context) {
        Map<String, String> mapM32191a = this.f24879b.m32191a(this.f24878a, str, c5435b, context);
        if (mapM32191a != null && !mapM32191a.isEmpty()) {
            Logger.m32141i(f24877e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return mapM32191a;
        }
        Map<String, String> mapM32230a = C5438b.m32226a(context.getPackageName()).m32230a(context, this.f24879b, this.f24878a, str, false);
        Logger.m32141i(f24877e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return mapM32230a != null ? mapM32230a : new HashMap();
    }

    /* renamed from: a */
    public static Map<String, String> m32152a(String str, String str2) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.m32145w(f24877e, "isSpExpire jsonValue from server is null.");
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.m32147w(f24877e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return map;
            }
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject2.get(next).toString());
            }
            return map;
        } catch (JSONException e10) {
            Logger.m32147w(f24877e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return map;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m32153a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                    concurrentHashMap.put(next, string);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e10) {
            Logger.m32147w(f24877e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return concurrentHashMap;
        }
    }

    /* renamed from: a */
    public void m32157a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i10) {
        C5435b c5435b = new C5435b();
        Map<String, String> mapM32151a = m32151a(str, c5435b, context);
        if (!c5435b.m32198a()) {
            this.f24880c.m32299a(new C5453c(this.f24878a, context), new a(str, mapM32151a, iQueryUrlsCallBack, context, this.f24878a, this.f24879b), str, this.f24881d, i10);
        } else if (mapM32151a.isEmpty()) {
            Logger.m32142i(f24877e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            String str2 = f24877e;
            Logger.m32142i(str2, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapM32151a).toString()));
            Logger.m32142i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(mapM32151a).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(mapM32151a);
        }
    }

    /* renamed from: a */
    public void m32158a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i10) {
        C5435b c5435b = new C5435b();
        String str3 = m32151a(str, c5435b, context).get(str2);
        if (!c5435b.m32198a()) {
            this.f24880c.m32299a(new C5453c(this.f24878a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.f24878a, this.f24879b), str, this.f24881d, i10);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.m32142i(f24877e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.m32142i(f24877e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
