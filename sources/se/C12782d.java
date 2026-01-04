package se;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p227dg.C9097b;
import p664u0.C13108a;
import p677ue.C13168a;
import p809yg.C13981a;
import ye.C13978y;

/* renamed from: se.d */
/* loaded from: classes4.dex */
public class C12782d {
    /* renamed from: a */
    public static void m76698a(Context context, String str, String str2) {
        C13981a.m83989i("AlarmExecutor", "alarm start");
        if (context == null) {
            C13981a.m83989i("AlarmExecutor", "alarm context is null");
            return;
        }
        if (str == null) {
            C13981a.m83988e("AlarmExecutor", "alarm perDeviceId is null");
        } else if (str2 == null) {
            C13981a.m83988e("AlarmExecutor", "alarm cptList is null");
        } else {
            m76699b(str, false);
            C13981a.m83989i("AlarmExecutor", "alarm cancelAncillary: left & right");
        }
    }

    /* renamed from: b */
    public static void m76699b(String str, boolean z10) {
        HashMap map = new HashMap();
        if (z10) {
            map.put(2, 1);
        } else {
            map.put(2, 0);
        }
        m76706i(str, map, m76702e(1, 1));
    }

    /* renamed from: c */
    public static void m76700c(String str, boolean z10) {
        HashMap map = new HashMap();
        if (z10) {
            map.put(2, 1);
        } else {
            map.put(2, 0);
        }
        m76706i(str, map, m76702e(1, 0));
    }

    /* renamed from: d */
    public static void m76701d(String str, boolean z10) {
        HashMap map = new HashMap();
        if (z10) {
            map.put(2, 1);
        } else {
            map.put(2, 0);
        }
        m76706i(str, map, m76702e(0, 1));
    }

    /* renamed from: e */
    public static JSONObject m76702e(int i10, int i11) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0x00", i10);
            jSONObject.put("0x01", i11);
        } catch (JSONException unused) {
            C13981a.m83988e("AlarmExecutor", "createDeviceObject JSONException");
        }
        return jSONObject;
    }

    /* renamed from: f */
    public static void m76703f(Context context) {
        C13981a.m83989i("AlarmExecutor", "alarm start");
        if (context == null) {
            C13981a.m83989i("AlarmExecutor", "alarm context is null");
            return;
        }
        if (C9097b.m57305o()) {
            C13981a.m83989i("AlarmExecutor", "close tag bell");
            C9097b.m57310t(context);
            C13108a.m78878b(context).m78881d(new Intent("com.huawei.hidisk.phone.finder.TAG.BELL.AUTO.END"));
        }
        C12785g.m76715s().m76723G(true, false, null);
    }

    /* renamed from: g */
    public static void m76704g(Context context, String str, String str2) {
        C13981a.m83989i("AlarmExecutor", "alarm start");
        if (context == null) {
            C13981a.m83989i("AlarmExecutor", "alarm context is null");
            return;
        }
        if (str2 == null) {
            C13981a.m83988e("AlarmExecutor", "alarm cptList is null");
            return;
        }
        if (str == null) {
            C13981a.m83988e("AlarmExecutor", "alarm perDeviceId is null");
            return;
        }
        String[] strArrSplit = str2.split(",");
        if (C12786h.m76748c(strArrSplit)) {
            m76700c(str, true);
            m76701d(str, false);
            C13981a.m83989i("AlarmExecutor", "alarm executeAncillary: left");
        } else if (C12786h.m76749d(strArrSplit)) {
            m76701d(str, true);
            m76700c(str, false);
            C13981a.m83989i("AlarmExecutor", "alarm executeAncillary: right");
        } else if (!C12786h.m76747b(strArrSplit)) {
            C13981a.m83989i("AlarmExecutor", "alarm executeAncillary: other");
        } else {
            m76699b(str, true);
            C13981a.m83989i("AlarmExecutor", "alarm executeAncillary: left & right");
        }
    }

    /* renamed from: h */
    public static void m76705h(String str, String str2, String str3) {
        C13981a.m83989i("AlarmExecutor", "execute wear control start");
        if (str == null) {
            C13981a.m83988e("AlarmExecutor", "alarm perDeviceId is null");
            return;
        }
        try {
            C13978y.m83903T().m83956N(str, str2, str3);
        } catch (Exception e10) {
            C13981a.m83988e("AlarmExecutor", "execute WearDevice alarm error:" + e10.getMessage());
        }
    }

    /* renamed from: i */
    public static void m76706i(String str, HashMap<Integer, Integer> map, JSONObject jSONObject) {
        C13981a.m83989i("AlarmExecutor", "send alarm operation, controlType: " + map);
        Bundle bundle = new Bundle();
        bundle.putString("deviceId", str);
        bundle.putSerializable("controlTypeMap", map);
        bundle.putString("controlObj", jSONObject.toString());
        bundle.putLong("controlTime", 20000L);
        new C13168a("controlDevAction", bundle).m79190g();
    }
}
