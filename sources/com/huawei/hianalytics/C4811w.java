package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.network.embedded.C6158y;
import com.huawei.secure.android.common.util.SafeBase64;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.w */
/* loaded from: classes5.dex */
public class C4811w {

    /* renamed from: a */
    public static volatile C4811w f21954a;

    /* renamed from: e */
    public static final List<String> f21955e = Arrays.asList(PackageConstants.GENERAL_SERVICES_ACTION, "com.huawei.hwid.core");

    /* renamed from: f */
    public static final List<String> f21956f = Arrays.asList("Analytics_Kit_Tag");

    /* renamed from: a */
    public boolean f21961a = true;

    /* renamed from: a */
    public int f21957a = 1;

    /* renamed from: a */
    public long f21958a = 86400000;

    /* renamed from: b */
    public int f21962b = 30;

    /* renamed from: c */
    public int f21965c = 30;

    /* renamed from: d */
    public int f21967d = 30;

    /* renamed from: e */
    public int f21969e = C6158y.f29108c;

    /* renamed from: f */
    public int f21970f = 50;

    /* renamed from: g */
    public int f21971g = 512;

    /* renamed from: h */
    public int f21972h = 300;

    /* renamed from: a */
    public String f21959a = "";

    /* renamed from: b */
    public boolean f21964b = true;

    /* renamed from: a */
    public final List<String> f21960a = new ArrayList();

    /* renamed from: b */
    public final List<String> f21963b = new ArrayList();

    /* renamed from: c */
    public final List<String> f21966c = new ArrayList();

    /* renamed from: d */
    public final List<String> f21968d = new ArrayList();

    public C4811w() {
        m29051a();
    }

    /* renamed from: a */
    public long m29048a() {
        return new Random().nextInt(this.f21962b) * 60000;
    }

    /* renamed from: b */
    public long m29053b() {
        return this.f21958a;
    }

    /* renamed from: a */
    public static C4811w m29047a() {
        if (f21954a == null) {
            synchronized (C4811w.class) {
                try {
                    if (f21954a == null) {
                        f21954a = new C4811w();
                    }
                } finally {
                }
            }
        }
        return f21954a;
    }

    /* renamed from: b */
    public final void m29054b() {
        HiLog.m28807d("MCC", "reset");
        this.f21961a = true;
        this.f21957a = 1;
        this.f21958a = 86400000L;
        this.f21962b = 30;
        this.f21969e = C6158y.f29108c;
        this.f21965c = 30;
        this.f21967d = 30;
        this.f21970f = 50;
        this.f21971g = 512;
        this.f21972h = 300;
        this.f21959a = "";
        this.f21964b = true;
        try {
            m29052a(m29049a(f21955e), this.f21963b, false);
            m29052a(m29049a(f21956f), this.f21966c, false);
            this.f21960a.clear();
            this.f21968d.clear();
        } catch (Throwable th2) {
            HiLog.m28812w("MCC", "reset fail: " + th2.getMessage());
        }
    }

    /* renamed from: a */
    public final List<String> m29049a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final List<String> m29050a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
            String strOptString = jSONArrayOptJSONArray.optString(i10);
            if (!TextUtils.isEmpty(strOptString)) {
                arrayList.add(strOptString);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final synchronized void m29051a() {
        String strM28908a;
        HiLog.m28807d("MCC", "init");
        try {
            strM28908a = C4785j.m28908a("kit_ha_metric_config", "mc_config", "");
        } catch (Throwable th2) {
            HiLog.m28812w("MCC", "init fail " + th2.getMessage());
            m29054b();
        }
        if (TextUtils.isEmpty(strM28908a)) {
            m29054b();
            return;
        }
        JSONObject jSONObject = new JSONObject(strM28908a);
        boolean z10 = this.f21961a;
        boolean zOptBoolean = jSONObject.optBoolean("collectEnable", false);
        this.f21961a = zOptBoolean;
        if (zOptBoolean != z10) {
            C4805t.m29028a(zOptBoolean);
        }
        this.f21957a = jSONObject.optInt("idFlag", 1);
        this.f21958a = jSONObject.optLong("reportInterval", 86400000L);
        this.f21962b = jSONObject.optInt("randomBound", 30);
        this.f21969e = jSONObject.optInt("minValidTime", C6158y.f29108c);
        this.f21965c = jSONObject.optInt("totalCount", 30);
        this.f21967d = jSONObject.optInt("batchSize", 30);
        this.f21970f = jSONObject.optInt("titleLength", 50);
        this.f21971g = jSONObject.optInt("artistLength", 512);
        this.f21972h = jSONObject.optInt("albumLength", 300);
        this.f21959a = jSONObject.optString("mepUrl", "");
        this.f21964b = jSONObject.optBoolean("checkCollectUrl", true);
        List<String> listM29050a = m29050a(jSONObject, "whiteProcess");
        if (!((ArrayList) listM29050a).isEmpty()) {
            m29052a(listM29050a, this.f21963b, false);
        }
        List<String> listM29050a2 = m29050a(jSONObject, "whiteTag");
        if (!((ArrayList) listM29050a2).isEmpty()) {
            m29052a(listM29050a2, this.f21966c, false);
        }
        List<String> listM29050a3 = m29050a(jSONObject, "whiteList");
        if (!((ArrayList) listM29050a3).isEmpty()) {
            m29052a(listM29050a3, this.f21960a, true);
        }
        List<String> listM29050a4 = m29050a(jSONObject, "whiteTimeList");
        if (!((ArrayList) listM29050a4).isEmpty()) {
            m29052a(listM29050a4, this.f21968d, true);
        }
    }

    /* renamed from: a */
    public final void m29052a(List<String> list, List<String> list2, boolean z10) {
        list2.clear();
        for (String str : list) {
            if (z10) {
                try {
                    str = new String(SafeBase64.decode(C4785j.m28931b(str), 0), StandardCharsets.UTF_8);
                } catch (Throwable th2) {
                    HiLog.m28812w("MCC", "initList fail: " + th2.getMessage());
                }
            }
            list2.add(str);
        }
    }
}
