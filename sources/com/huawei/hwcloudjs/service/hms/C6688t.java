package com.huawei.hwcloudjs.service.hms;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hwcloudjs.p164f.C6659d;
import java.io.Serializable;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hwcloudjs.service.hms.t */
/* loaded from: classes8.dex */
public class C6688t {

    /* renamed from: a */
    private static final String f31011a = "JsonCodec";

    /* renamed from: b */
    protected static final String f31012b = "_val_type_";

    /* renamed from: c */
    protected static final int f31013c = -1;

    /* renamed from: d */
    protected static final int f31014d = 0;

    /* renamed from: e */
    protected static final int f31015e = 1;

    /* renamed from: f */
    private static final String f31016f = "_list_size_";

    /* renamed from: g */
    private static final String f31017g = "_list_item_";

    /* renamed from: com.huawei.hwcloudjs.service.hms.t$a */
    public static final class a extends Exception {
        public a() {
        }

        public a(String str) {
            super(str);
        }
    }

    /* renamed from: b */
    private Long m37986b(JSONObject jSONObject) {
        Object objOpt = jSONObject.opt("value");
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Number) {
            return Long.valueOf(((Number) objOpt).longValue());
        }
        if (objOpt instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) objOpt));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* renamed from: c */
    private Short m37987c(JSONObject jSONObject) {
        Object objOpt = jSONObject.opt("value");
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Number) {
            return Short.valueOf(((Number) objOpt).shortValue());
        }
        if (objOpt instanceof String) {
            try {
                return Short.valueOf(Short.parseShort((String) objOpt));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public Bundle m37988a(JSONObject jSONObject, Bundle bundle) throws JSONException {
        String str;
        JSONObject jSONObjectOptJSONObject;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (next != null && (next instanceof String) && (jSONObjectOptJSONObject = jSONObject.optJSONObject((str = next))) != null) {
                m37990a(str, jSONObjectOptJSONObject.optString("type"), jSONObjectOptJSONObject, bundle);
            }
        }
        return bundle;
    }

    /* renamed from: a */
    private Float m37984a(JSONObject jSONObject) {
        Object objOpt = jSONObject.opt("value");
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Number) {
            return Float.valueOf(((Number) objOpt).floatValue());
        }
        if (objOpt instanceof String) {
            try {
                return Float.valueOf(Float.parseFloat((String) objOpt));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m37989a(String str, Bundle bundle, JSONObject jSONObject) throws JSONException {
        Object obj;
        for (String str2 : bundle.keySet()) {
            Object obj2 = bundle.get(str2);
            if (obj2 != null) {
                try {
                    if (obj2 instanceof Bundle) {
                        Bundle bundle2 = (Bundle) obj2;
                        int i10 = bundle2.getInt(f31012b, -1);
                        if (i10 == 1) {
                            JSONArray jSONArray = new JSONArray();
                            m37991a(str, jSONArray, bundle2);
                            obj = jSONArray;
                        } else if (i10 == 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            m37989a(str, bundle2, jSONObject2);
                            obj = jSONObject2;
                        }
                        jSONObject.put(str2, obj);
                    } else {
                        if (obj2 instanceof Intent) {
                            String str3 = str + "_" + UUID.randomUUID().toString() + "";
                            C6687s.m37979a().m37982a(str3, (Intent) obj2);
                            obj = str3;
                        } else if (obj2 instanceof PendingIntent) {
                            String str4 = str + "_" + UUID.randomUUID().toString() + "";
                            C6687s.m37979a().m37981a(str4, (PendingIntent) obj2);
                            obj = str4;
                        } else {
                            jSONObject.put(str2, obj2);
                        }
                        jSONObject.put(str2, obj);
                    }
                } catch (JSONException unused) {
                    C6659d.m37881b(f31011a, "signInRes2Json put json error", true);
                }
            }
        }
    }

    /* renamed from: a */
    public void m37990a(String str, String str2, JSONObject jSONObject, Bundle bundle) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        if ("String".equals(str2)) {
            bundle.putString(str, jSONObject.optString("value"));
            return;
        }
        if ("Integer".equals(str2)) {
            bundle.putInt(str, jSONObject.optInt("value"));
            return;
        }
        if ("Short".equals(str2)) {
            Short shM37987c = m37987c(jSONObject);
            if (shM37987c != null) {
                bundle.putShort(str, shM37987c.shortValue());
                return;
            }
            return;
        }
        if ("Long".equals(str2)) {
            Long lM37986b = m37986b(jSONObject);
            if (lM37986b != null) {
                bundle.putLong(str, lM37986b.longValue());
                return;
            }
            return;
        }
        if ("Float".equals(str2)) {
            Float fM37984a = m37984a(jSONObject);
            if (fM37984a != null) {
                bundle.putFloat(str, fM37984a.floatValue());
                return;
            }
            return;
        }
        if ("Double".equals(str2)) {
            bundle.putDouble(str, jSONObject.optDouble("value"));
            return;
        }
        if ("Boolean".equals(str2)) {
            bundle.putBoolean(str, jSONObject.optBoolean("value"));
            return;
        }
        if ("List".equals(str2)) {
            m37985a(str, jSONObject, bundle);
        } else {
            if (!"entity".equals(str2) || (jSONObjectOptJSONObject = jSONObject.optJSONObject("value")) == null) {
                return;
            }
            Bundle bundleM37988a = m37988a(jSONObjectOptJSONObject, new Bundle());
            bundleM37988a.putInt(f31012b, 0);
            bundle.putBundle(str, bundleM37988a);
        }
    }

    /* renamed from: a */
    public void m37991a(String str, JSONArray jSONArray, Bundle bundle) throws JSONException {
        int i10 = bundle.getInt(f31016f);
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = bundle.get(f31017g + i11);
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                jSONArray.put(obj);
            } else if (obj instanceof Bundle) {
                Bundle bundle2 = (Bundle) obj;
                if (bundle2.getInt(f31012b, -1) == 0) {
                    JSONObject jSONObject = new JSONObject();
                    m37989a(str, bundle2, jSONObject);
                    jSONArray.put(jSONObject);
                }
            }
        }
    }

    /* renamed from: a */
    private void m37985a(String str, JSONObject jSONObject, Bundle bundle) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("value");
        if (jSONArrayOptJSONArray != null) {
            String strOptString = jSONObject.optString("subType");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(f31012b, 1);
            bundle2.putInt(f31016f, jSONArrayOptJSONArray.length());
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                Object objOpt = jSONArrayOptJSONArray.opt(i10);
                if (objOpt != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("value", objOpt);
                        jSONObject2.put("type", strOptString);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(f31017g);
                        sb2.append(i10);
                        m37990a(sb2.toString(), strOptString, jSONObject2, bundle2);
                    } catch (JSONException unused) {
                        C6659d.m37881b(f31011a, "writeList put json error", true);
                    }
                }
            }
            bundle.putBundle(str, bundle2);
        }
    }
}
