package p015ak;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.bean.CookieVal;
import com.huawei.hicloud.base.bean.CookieValExtra;
import com.huawei.hicloud.base.bean.HwCookie;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p399jk.AbstractC10896a;

/* renamed from: ak.g */
/* loaded from: classes6.dex */
public final class C0215g {

    /* renamed from: i */
    public static C0215g f797i;

    /* renamed from: j */
    public static final Object f798j = new Object();

    /* renamed from: a */
    public final Context f799a;

    /* renamed from: b */
    public final SharedPreferences f800b;

    /* renamed from: c */
    public long f801c;

    /* renamed from: d */
    public long f802d;

    /* renamed from: e */
    public boolean f803e = true;

    /* renamed from: f */
    public final ReentrantLock f804f = new ReentrantLock();

    /* renamed from: g */
    public final ReadWriteLock f805g = new ReentrantReadWriteLock();

    /* renamed from: h */
    public final ReadWriteLock f806h = new ReentrantReadWriteLock();

    public C0215g(Context context) {
        this.f799a = context;
        this.f800b = C0214f0.m1382b(context, "cookiesHelper", 0);
    }

    /* renamed from: f */
    public static C0215g m1384f() {
        C0215g c0215g;
        synchronized (f798j) {
            try {
                C0215g c0215g2 = f797i;
                if (c0215g2 == null || c0215g2.f799a == null || c0215g2.f800b == null) {
                    f797i = new C0215g(C0213f.m1377a());
                }
                c0215g = f797i;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c0215g;
    }

    /* renamed from: a */
    public boolean m1385a() {
        SharedPreferences sharedPreferences = this.f800b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.clear();
        return editorEdit.commit();
    }

    /* renamed from: b */
    public final String m1386b(JSONObject jSONObject, String str) throws JSONException {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject3 = (JSONObject) jSONObject.get(next);
                Iterator<String> itKeys2 = jSONObject3.keys();
                JSONObject jSONObject4 = new JSONObject();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    jSONObject4.put(next2, jSONObject3.get(next2));
                }
                jSONObject4.put("k", next);
                jSONArray.put(jSONObject4);
            }
            jSONObject2.put("vals", jSONArray);
            jSONObject2.put("domain", str);
            return jSONObject2.toString();
        } catch (JSONException e10) {
            AbstractC10896a.m65886e("CookiesHelper", "formatRequest json error " + e10.getMessage());
            return null;
        } catch (Exception e11) {
            AbstractC10896a.m65886e("CookiesHelper", "formatRequest error " + e11.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public String m1387c(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65888w("CookiesHelper", "domain is null");
            return null;
        }
        if (!m1392i() && m1391h() == 0) {
            AbstractC10896a.m65888w("CookiesHelper", "not first request, timestamp is null, domain = " + str);
            return null;
        }
        if (m1392i()) {
            AbstractC10896a.m65887i("CookiesHelper", "first request, request {}, domain = " + str);
            return new JSONObject().toString();
        }
        try {
            Map<String, CookieValExtra> mapM1390g = m1390g(str);
            if (mapM1390g == null) {
                AbstractC10896a.m65888w("CookiesHelper", "local cookie error, domain = " + str);
                return null;
            }
            HashMap map = new HashMap(mapM1390g);
            m1395l(map, m1388d(), str);
            if (map.isEmpty()) {
                m1394k(str);
                return new JSONObject().toString();
            }
            JSONObject jSONObject = new JSONObject(map.toString());
            if (map.size() != mapM1390g.size()) {
                m1399p(str, jSONObject.toString());
            }
            return m1386b(jSONObject, str);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("CookiesHelper", "getCookies error " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    public final long m1388d() {
        return (m1391h() + SystemClock.elapsedRealtime()) - this.f801c;
    }

    /* renamed from: e */
    public final synchronized String m1389e(String str) {
        SharedPreferences sharedPreferences = this.f800b;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str, "");
    }

    /* renamed from: g */
    public final Map<String, CookieValExtra> m1390g(String str) {
        if (this.f800b == null) {
            AbstractC10896a.m65888w("CookiesHelper", "sp is null");
            return null;
        }
        try {
            HashMap map = new HashMap();
            String strM1389e = m1389e(str);
            if (TextUtils.isEmpty(strM1389e)) {
                return map;
            }
            JSONObject jSONObject = new JSONObject(strM1389e);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, (CookieValExtra) new Gson().fromJson(((JSONObject) jSONObject.get(next)).toString(), CookieValExtra.class));
            }
            return map;
        } catch (JSONException e10) {
            AbstractC10896a.m65886e("CookiesHelper", "getLocalCookieExtra json error " + e10.getMessage());
            return null;
        } catch (Exception e11) {
            AbstractC10896a.m65886e("CookiesHelper", "getLocalCookieExtra error " + e11.getMessage());
            return null;
        }
    }

    /* renamed from: h */
    public final long m1391h() {
        this.f805g.readLock().lock();
        try {
            return this.f802d;
        } finally {
            this.f805g.readLock().unlock();
        }
    }

    /* renamed from: i */
    public final boolean m1392i() {
        this.f806h.readLock().lock();
        try {
            return this.f803e;
        } finally {
            this.f806h.readLock().unlock();
        }
    }

    /* renamed from: j */
    public void m1393j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f804f.lock();
        try {
            try {
                AbstractC10896a.m65885d("CookiesHelper", "recordCookies " + str);
                HwCookie hwCookie = (HwCookie) new Gson().fromJson(str, HwCookie.class);
                if (hwCookie.getTs() != null && m1391h() == 0) {
                    AbstractC10896a.m65887i("CookiesHelper", "first update timeStamp");
                    m1401r(hwCookie.getTs().longValue());
                    this.f801c = SystemClock.elapsedRealtime();
                }
                m1398o(hwCookie.getDomain(), hwCookie);
                if (m1392i()) {
                    m1400q(false);
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("CookiesHelper", "recordCookies error " + e10.getMessage());
            }
            this.f804f.unlock();
        } catch (Throwable th2) {
            this.f804f.unlock();
            throw th2;
        }
    }

    /* renamed from: k */
    public final synchronized void m1394k(String str) {
        SharedPreferences sharedPreferences = this.f800b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    /* renamed from: l */
    public final void m1395l(Map<String, CookieValExtra> map, long j10, String str) {
        if (map == null || map.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, CookieValExtra>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, CookieValExtra> next = it.next();
            String key = next.getKey();
            if (j10 > next.getValue().getE()) {
                it.remove();
                AbstractC10896a.m65885d("CookiesHelper", "time expired, k = " + key + ", domain = " + str);
            }
        }
    }

    /* renamed from: m */
    public void m1396m(C4609l c4609l) {
        if (c4609l == null) {
            return;
        }
        try {
            Map<String, Object> unknownKeys = c4609l.getUnknownKeys();
            if (unknownKeys != null && !unknownKeys.isEmpty() && unknownKeys.containsKey("x-hw-cookie")) {
                Object obj = unknownKeys.get("x-hw-cookie");
                m1384f().m1393j(obj instanceof List ? (String) ((List) obj).get(0) : "");
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("CookiesHelper", "saveCookies error " + e10.getMessage());
        }
    }

    /* renamed from: n */
    public final void m1397n(Map<String, CookieValExtra> map, List<CookieVal> list, String str) {
        if (list == null || list.isEmpty() || map == null) {
            return;
        }
        for (CookieVal cookieVal : list) {
            String k10 = cookieVal.getK();
            String v10 = cookieVal.getV();
            long e10 = cookieVal.getE();
            if (map.containsKey(k10)) {
                CookieValExtra cookieValExtra = map.get(k10);
                if (cookieValExtra != null) {
                    cookieValExtra.setV(v10);
                    cookieValExtra.setE(e10);
                }
            } else {
                map.put(k10, new CookieValExtra(v10, e10));
                AbstractC10896a.m65885d("CookiesHelper", "insert into local, k = " + k10 + ", domain = " + str);
            }
        }
    }

    /* renamed from: o */
    public final void m1398o(String str, HwCookie hwCookie) {
        try {
            Map<String, CookieValExtra> mapM1390g = m1390g(str);
            if (mapM1390g == null) {
                AbstractC10896a.m65888w("CookiesHelper", "localCookies is null, domain = " + str);
                mapM1390g = new HashMap<>();
            }
            if (hwCookie.getTs() != null) {
                m1395l(mapM1390g, hwCookie.getTs().longValue(), str);
            }
            m1397n(mapM1390g, hwCookie.getVals(), str);
            if (mapM1390g.isEmpty()) {
                m1394k(str);
            } else {
                m1399p(str, new JSONObject(mapM1390g.toString()).toString());
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("CookiesHelper", "updateCookies error " + e10.getMessage());
        }
    }

    /* renamed from: p */
    public final synchronized void m1399p(String str, String str2) {
        SharedPreferences sharedPreferences = this.f800b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    /* renamed from: q */
    public final void m1400q(boolean z10) {
        this.f806h.writeLock().lock();
        try {
            this.f803e = z10;
        } finally {
            this.f806h.writeLock().unlock();
        }
    }

    /* renamed from: r */
    public final void m1401r(long j10) {
        this.f805g.writeLock().lock();
        try {
            this.f802d = j10;
        } finally {
            this.f805g.writeLock().unlock();
        }
    }
}
