package com.huawei.hms.framework.network.grs.p122g.p124j;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p121f.C5438b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.j.c */
/* loaded from: classes8.dex */
public class C5453c {

    /* renamed from: a */
    private final GrsBaseInfo f24995a;

    /* renamed from: b */
    private final Context f24996b;

    /* renamed from: c */
    private final Set<String> f24997c = new HashSet();

    public C5453c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f24995a = grsBaseInfo;
        this.f24996b = context;
    }

    /* renamed from: e */
    private String m32306e() throws JSONException {
        Set<String> setM32233b = C5438b.m32226a(this.f24996b.getPackageName()).m32233b();
        if (setM32233b.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = setM32233b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.m32137d("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: f */
    private String m32307f() throws JSONException {
        Logger.m32143v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f24997c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.m32144v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public Context m32308a() {
        return this.f24996b;
    }

    /* renamed from: b */
    public GrsBaseInfo m32310b() {
        return this.f24995a;
    }

    /* renamed from: c */
    public String m32311c() {
        return this.f24997c.size() == 0 ? m32306e() : m32307f();
    }

    /* renamed from: d */
    public Set<String> m32312d() {
        return this.f24997c;
    }

    /* renamed from: a */
    public void m32309a(String str) {
        this.f24997c.add(str);
    }
}
