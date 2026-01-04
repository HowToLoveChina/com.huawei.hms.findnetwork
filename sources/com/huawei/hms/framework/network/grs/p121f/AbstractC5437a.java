package com.huawei.hms.framework.network.grs.p121f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C5462a;
import com.huawei.hms.framework.network.grs.local.model.C5463b;
import com.huawei.hms.framework.network.grs.local.model.C5464c;
import com.huawei.hms.framework.network.grs.local.model.C5465d;
import com.huawei.hms.framework.network.grs.p120e.C5434a;
import com.huawei.hms.framework.network.grs.p125h.C5457c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.f.a */
/* loaded from: classes8.dex */
public abstract class AbstractC5437a {

    /* renamed from: a */
    protected C5462a f24924a;

    /* renamed from: b */
    protected List<C5463b> f24925b;

    /* renamed from: c */
    protected boolean f24926c = false;

    /* renamed from: d */
    protected boolean f24927d = false;

    /* renamed from: e */
    protected Set<String> f24928e = new HashSet(16);

    /* renamed from: b */
    private int m32206b(String str, Context context) {
        if (m32207h(C5457c.m32327a(str, context)) != 0) {
            return -1;
        }
        Logger.m32142i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
        return 0;
    }

    /* renamed from: h */
    private int m32207h(String str) {
        int iMo32219c;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f24927d && (iMo32219c = mo32219c(str)) != 0) {
            return iMo32219c;
        }
        int iMo32216b = mo32216b(str);
        return iMo32216b != 0 ? iMo32216b : mo32225g(str);
    }

    /* renamed from: i */
    private int m32208i(String str) {
        List<C5463b> list;
        int iM32223e;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (!this.f24927d || !((list = this.f24925b) == null || list.isEmpty()) || (iM32223e = m32223e(str)) == 0) ? m32224f(str) : iM32223e;
    }

    /* renamed from: a */
    public int m32209a(String str, Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(GrsApp.getInstance().getBrand("/"));
        sb2.append(str);
        return m32206b(sb2.toString(), context) != 0 ? -1 : 0;
    }

    /* renamed from: b */
    public abstract int mo32216b(String str);

    /* renamed from: c */
    public abstract int mo32219c(String str);

    /* renamed from: c */
    public Set<String> m32220c() {
        return this.f24928e;
    }

    /* renamed from: d */
    public boolean m32221d() {
        return this.f24926c;
    }

    /* renamed from: e */
    public int m32223e(String str) throws JSONException {
        JSONArray jSONArray;
        this.f24925b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.m32138e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            this.f24925b.addAll(m32212a(jSONArray));
            return 0;
        } catch (JSONException e10) {
            Logger.m32147w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return -1;
        }
    }

    /* renamed from: f */
    public int m32224f(String str) {
        try {
            m32218b(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e10) {
            Logger.m32147w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e10.getMessage()));
            return -1;
        }
    }

    /* renamed from: g */
    public abstract int mo32225g(String str);

    /* renamed from: a */
    public String m32210a(Context context, C5434a c5434a, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z10) {
        Map<String, String> mapM32213a = m32213a(context, c5434a, grsBaseInfo, str, z10);
        if (mapM32213a != null) {
            return mapM32213a.get(str2);
        }
        Logger.m32147w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    /* renamed from: b */
    public C5462a m32217b() {
        return this.f24924a;
    }

    /* renamed from: d */
    public boolean m32222d(String str) {
        String str2;
        try {
            this.f24924a = new C5462a();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("name")) {
                this.f24924a.m32342b(jSONObject.getString("name"));
            }
            if (jSONObject.has("cacheControl")) {
                this.f24924a.m32339a(jSONObject.getLong("cacheControl"));
            }
            if (jSONObject.has("services")) {
                m32218b(jSONObject.getJSONArray("services"));
            }
            if (jSONObject.has("countryGroups")) {
                JSONArray jSONArray = jSONObject.getJSONArray("countryGroups");
                ArrayList arrayList = new ArrayList(16);
                this.f24925b = arrayList;
                arrayList.addAll(m32212a(jSONArray));
            }
            Logger.m32142i("AbstractLocalManager", "parse from sp services size : %d, countryGroups size: %d:", Integer.valueOf(this.f24928e.size()), Integer.valueOf(this.f24925b.size()));
            return true;
        } catch (JSONException unused) {
            str2 = "Parse local config from sp failed, JSONException";
            Logger.m32145w("AbstractLocalManager", str2);
            return false;
        } catch (Throwable th2) {
            str2 = "Parse local config from sp failed, Throwable:" + StringUtils.anonymizeMessage(th2.getMessage());
            Logger.m32145w("AbstractLocalManager", str2);
            return false;
        }
    }

    /* renamed from: a */
    public String m32211a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("no_route_country".equals(str)) {
            return "no-country";
        }
        List<C5463b> list = this.f24925b;
        if (list != null && !list.isEmpty()) {
            for (C5463b c5463b : this.f24925b) {
                if (c5463b.m32343a().contains(str)) {
                    return c5463b.m32346b();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[PHI: r10
  0x0060: PHI (r10v5 java.lang.String) = (r10v0 java.lang.String), (r10v1 java.lang.String) binds: [B:17:0x005e, B:20:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6 A[PHI: r5
  0x00c6: PHI (r5v10 java.lang.String) = (r5v8 java.lang.String), (r5v9 java.lang.String) binds: [B:33:0x00c4, B:36:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m32218b(org.json.JSONArray r15) throws org.json.JSONException {
        /*
            r14 = this;
            if (r15 == 0) goto Lf5
            int r0 = r15.length()
            if (r0 != 0) goto La
            goto Lf5
        La:
            r0 = 0
            r1 = r0
        Lc:
            int r2 = r15.length()
            if (r1 >= r2) goto Lf5
            org.json.JSONObject r2 = r15.getJSONObject(r1)
            com.huawei.hms.framework.network.grs.local.model.c r3 = new com.huawei.hms.framework.network.grs.local.model.c
            r3.<init>()
            java.lang.String r4 = "name"
            java.lang.String r4 = r2.getString(r4)
            r3.m32355b(r4)
            java.util.Set<java.lang.String> r5 = r14.f24928e
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto Lf1
            java.util.Set<java.lang.String> r5 = r14.f24928e
            r5.add(r4)
            boolean r5 = r14.f24927d
            if (r5 == 0) goto Lf1
            java.lang.String r5 = "routeBy"
            java.lang.String r5 = r2.getString(r5)
            r3.m32357c(r5)
            java.lang.String r5 = "servings"
            org.json.JSONArray r5 = r2.getJSONArray(r5)
            r6 = r0
        L45:
            int r7 = r5.length()
            java.lang.String r8 = "AbstractLocalManager"
            if (r6 >= r7) goto Lbe
            java.lang.Object r7 = r5.get(r6)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            com.huawei.hms.framework.network.grs.local.model.d r9 = new com.huawei.hms.framework.network.grs.local.model.d
            r9.<init>()
            java.lang.String r10 = "countryOrAreaGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L65
        L60:
            java.lang.String r8 = r7.getString(r10)
            goto L79
        L65:
            java.lang.String r10 = "countryGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L6e
            goto L60
        L6e:
            java.lang.Object[] r10 = new java.lang.Object[]{r4}
            java.lang.String r11 = "maybe this service{%s} routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.m32144v(r8, r11, r10)
            java.lang.String r8 = "no-country"
        L79:
            r9.m32359a(r8)
            java.lang.String r8 = "addresses"
            org.json.JSONObject r7 = r7.getJSONObject(r8)
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r10 = 16
            r8.<init>(r10)
            java.util.Iterator r10 = r7.keys()
        L8d:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto Lb1
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = r7.getString(r11)
            boolean r13 = android.text.TextUtils.isEmpty(r11)
            if (r13 != 0) goto L8d
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L8d
            java.lang.String r12 = r7.getString(r11)
            r8.put(r11, r12)
            goto L8d
        Lb1:
            r9.m32360a(r8)
            java.lang.String r7 = r9.m32361b()
            r3.m32352a(r7, r9)
            int r6 = r6 + 1
            goto L45
        Lbe:
            java.lang.String r5 = "countryOrAreaGroups"
            boolean r6 = r2.has(r5)
            if (r6 == 0) goto Lcf
        Lc6:
            org.json.JSONArray r2 = r2.getJSONArray(r5)
            java.util.List r2 = r14.m32212a(r2)
            goto Lde
        Lcf:
            java.lang.String r5 = "countryGroups"
            boolean r6 = r2.has(r5)
            if (r6 == 0) goto Ld8
            goto Lc6
        Ld8:
            java.lang.String r2 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.m32141i(r8, r2)
            r2 = 0
        Lde:
            r3.m32353a(r2)
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.f24924a
            if (r2 != 0) goto Lec
            com.huawei.hms.framework.network.grs.local.model.a r2 = new com.huawei.hms.framework.network.grs.local.model.a
            r2.<init>()
            r14.f24924a = r2
        Lec:
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.f24924a
            r2.m32340a(r4, r3)
        Lf1:
            int r1 = r1 + 1
            goto Lc
        Lf5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p121f.AbstractC5437a.m32218b(org.json.JSONArray):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0045 A[PHI: r5
  0x0045: PHI (r5v10 java.lang.String) = (r5v6 java.lang.String), (r5v7 java.lang.String) binds: [B:10:0x0043, B:13:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.hms.framework.network.grs.local.model.C5463b> m32212a(org.json.JSONArray r9) throws org.json.JSONException {
        /*
            r8 = this;
            if (r9 == 0) goto L8b
            int r8 = r9.length()
            if (r8 != 0) goto La
            goto L8b
        La:
            java.util.ArrayList r8 = new java.util.ArrayList
            r0 = 16
            r8.<init>(r0)
            r1 = 0
            r2 = r1
        L13:
            int r3 = r9.length()
            if (r2 >= r3) goto L8a
            org.json.JSONObject r3 = r9.getJSONObject(r2)
            com.huawei.hms.framework.network.grs.local.model.b r4 = new com.huawei.hms.framework.network.grs.local.model.b
            r4.<init>()
            java.lang.String r5 = "id"
            java.lang.String r5 = r3.getString(r5)
            r4.m32347b(r5)
            java.lang.String r5 = "name"
            java.lang.String r5 = r3.getString(r5)
            r4.m32349c(r5)
            java.lang.String r5 = "description"
            java.lang.String r5 = r3.getString(r5)
            r4.m32344a(r5)
            java.lang.String r5 = "countriesOrAreas"
            boolean r6 = r3.has(r5)
            if (r6 == 0) goto L4a
        L45:
            org.json.JSONArray r3 = r3.getJSONArray(r5)
            goto L5b
        L4a:
            java.lang.String r5 = "countries"
            boolean r6 = r3.has(r5)
            if (r6 == 0) goto L53
            goto L45
        L53:
            java.lang.String r3 = "AbstractLocalManager"
            java.lang.String r5 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.m32145w(r3, r5)
            r3 = 0
        L5b:
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>(r0)
            if (r3 == 0) goto L85
            int r6 = r3.length()
            if (r6 != 0) goto L69
            goto L85
        L69:
            r6 = r1
        L6a:
            int r7 = r3.length()
            if (r6 >= r7) goto L7c
            java.lang.Object r7 = r3.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            r5.add(r7)
            int r6 = r6 + 1
            goto L6a
        L7c:
            r4.m32345a(r5)
            r8.add(r4)
            int r2 = r2 + 1
            goto L13
        L85:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L8a:
            return r8
        L8b:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p121f.AbstractC5437a.m32212a(org.json.JSONArray):java.util.List");
    }

    /* renamed from: a */
    public Map<String, String> m32213a(Context context, C5434a c5434a, GrsBaseInfo grsBaseInfo, String str, boolean z10) {
        C5462a c5462a = this.f24924a;
        if (c5462a == null) {
            Logger.m32145w("AbstractLocalManager", "application data is null.");
            return null;
        }
        C5464c c5464cM32337a = c5462a.m32337a(str);
        if (c5464cM32337a == null) {
            Logger.m32147w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String strM32237b = C5441e.m32237b(context, c5434a, c5464cM32337a.m32354b(), grsBaseInfo, z10);
        if (strM32237b == null) {
            Logger.m32147w("AbstractLocalManager", "country not found by routeby in local config{%s}", c5464cM32337a.m32354b());
            return null;
        }
        List<C5463b> listM32351a = c5464cM32337a.m32351a();
        C5465d c5465dM32350a = c5464cM32337a.m32350a((listM32351a == null || listM32351a.size() == 0) ? m32211a(strM32237b) : m32205a(listM32351a, grsBaseInfo, strM32237b).get(strM32237b));
        if (c5465dM32350a == null) {
            return null;
        }
        return c5465dM32350a.m32358a();
    }

    /* renamed from: a */
    private Map<String, String> m32205a(List<C5463b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (C5463b c5463b : list) {
            if (c5463b.m32343a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), c5463b.m32346b());
            }
            if (c5463b.m32343a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), c5463b.m32346b());
            }
            if (c5463b.m32343a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), c5463b.m32346b());
            }
            if (c5463b.m32343a().contains(str)) {
                Logger.m32143v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, c5463b.m32346b());
            }
        }
        return concurrentHashMap;
    }

    /* renamed from: a */
    public JSONObject m32214a() throws JSONException {
        JSONObject jSONObjectM32341b = this.f24924a.m32341b();
        if (this.f24925b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<C5463b> it = this.f24925b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m32348c());
            }
            jSONObjectM32341b.put("countryGroups", jSONArray);
        }
        return jSONObjectM32341b;
    }

    /* renamed from: a */
    public void m32215a(Context context, List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            Logger.m32136d("AbstractLocalManager", "getBatchLoadSdkSuccessFlag file:" + str);
            if (TextUtils.isEmpty(str) || !Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                Logger.m32137d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, skipped.", str);
            } else {
                Object[] objArr = {str};
                if (m32208i(C5457c.m32327a(GrsApp.getInstance().getBrand("/") + str, context)) == 0) {
                    Logger.m32137d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", objArr);
                } else {
                    Logger.m32147w("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", objArr);
                }
            }
        }
    }
}
