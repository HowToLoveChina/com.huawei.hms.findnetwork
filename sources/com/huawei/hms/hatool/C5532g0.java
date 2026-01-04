package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.g0 */
/* loaded from: classes8.dex */
public final class C5532g0 {

    /* renamed from: c */
    private static C5532g0 f25182c;

    /* renamed from: a */
    private Context f25183a;

    /* renamed from: b */
    private final Object f25184b = new Object();

    private C5532g0() {
    }

    /* renamed from: a */
    public static C5532g0 m32514a() {
        if (f25182c == null) {
            m32516b();
        }
        return f25182c;
    }

    /* renamed from: b */
    private static synchronized void m32516b() {
        if (f25182c == null) {
            f25182c = new C5532g0();
        }
    }

    /* renamed from: a */
    private JSONObject m32515a(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                C5571v.m32789b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    /* renamed from: b */
    public void m32521b(String str, int i10, String str2, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        C5525e.m32484a().m32490a(str, i10, str2, m32515a(linkedHashMap), System.currentTimeMillis());
    }

    /* renamed from: a */
    public void m32517a(Context context) {
        synchronized (this.f25184b) {
            try {
                if (this.f25183a != null) {
                    return;
                }
                this.f25183a = context;
                C5525e.m32484a().m32487a(context);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m32518a(String str, int i10) {
        C5525e.m32484a().m32488a(str, i10);
    }

    /* renamed from: a */
    public void m32519a(String str, int i10, String str2, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        C5525e.m32484a().m32489a(str, i10, str2, m32515a(linkedHashMap));
    }

    /* renamed from: a */
    public void m32520a(String str, Context context, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            C5525e.m32484a().m32489a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            C5571v.m32797f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }
}
