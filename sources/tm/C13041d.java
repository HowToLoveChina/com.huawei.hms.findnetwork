package tm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0213f;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;
import p783xp.C13843a;

/* renamed from: tm.d */
/* loaded from: classes6.dex */
public class C13041d {

    /* renamed from: e */
    public static final Object f59363e = new Object();

    /* renamed from: f */
    @SuppressLint({"StaticFieldLeak"})
    public static C13041d f59364f;

    /* renamed from: a */
    public SharedPreferences f59365a;

    /* renamed from: b */
    public Context f59366b;

    /* renamed from: c */
    public Map<String, String> f59367c;

    /* renamed from: d */
    public boolean f59368d = true;

    public C13041d(Context context) {
        this.f59366b = context;
        this.f59365a = C0214f0.m1382b(context, "grs_urls", 0);
    }

    /* renamed from: e */
    public static C13041d m78675e() {
        C13041d c13041d;
        synchronized (f59363e) {
            try {
                C13041d c13041d2 = f59364f;
                if (c13041d2 == null || c13041d2.f59366b == null || c13041d2.f59365a == null) {
                    f59364f = new C13041d(C0213f.m1377a());
                }
                c13041d = f59364f;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c13041d;
    }

    /* renamed from: a */
    public void m78676a() {
        SharedPreferences sharedPreferences = this.f59365a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
        Map<String, String> map = this.f59367c;
        if (map != null) {
            map.clear();
        }
    }

    /* renamed from: b */
    public boolean m78677b(Map<String, String> map) {
        try {
            Map<String, ?> all = this.f59365a.getAll();
            if (all != null && all.size() > 0) {
                if (map.size() != all.size()) {
                    AbstractC10896a.m65887i("GrsUrlsSpManager", "compareUrlsMapWithSpFile, sp urls map size is not equal with grs urls map");
                    return false;
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (TextUtils.isEmpty(key)) {
                        AbstractC10896a.m65887i("GrsUrlsSpManager", "compareUrlsMapWithSpFile, urls map has null key");
                        return false;
                    }
                    if (!all.containsKey(key)) {
                        AbstractC10896a.m65887i("GrsUrlsSpManager", "compareUrlsMapWithSpFile, sp urls map not contain key: " + key);
                        return false;
                    }
                    Object obj = all.get(key);
                    if (!(obj instanceof String)) {
                        AbstractC10896a.m65887i("GrsUrlsSpManager", "compareUrlsMapWithSpFile, sp urls map has value not string");
                        return false;
                    }
                    if (!value.equals(obj.toString())) {
                        AbstractC10896a.m65887i("GrsUrlsSpManager", "compareUrlsMapWithSpFile, sp urls map not equal with urls map");
                        return false;
                    }
                }
                AbstractC10896a.m65887i("GrsUrlsSpManager", "compareUrlsMapWithSpFile, sp urls map is same with urls map");
                return true;
            }
            AbstractC10896a.m65887i("GrsUrlsSpManager", "compareUrlsMapWithSpFile, sp urls map is null or size is 0");
            return false;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("GrsUrlsSpManager", "compareUrlsMapWithSpFile, throws exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: c */
    public Map<String, String> m78678c() {
        Map<String, String> map = this.f59367c;
        if (map != null && !map.isEmpty()) {
            return this.f59367c;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SharedPreferences sharedPreferences = this.f59365a;
        if (sharedPreferences == null) {
            AbstractC10896a.m65888w("GrsUrlsSpManager", "grsUrlsSp is null");
            return linkedHashMap;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null || all.isEmpty()) {
            AbstractC10896a.m65888w("GrsUrlsSpManager", "urlsMap is empty");
            return linkedHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            linkedHashMap.put(C13843a.m83101w((String) entry.getValue()), entry.getKey());
        }
        this.f59367c = new LinkedHashMap(linkedHashMap);
        return linkedHashMap;
    }

    /* renamed from: d */
    public String m78679d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return m78678c().get(str);
        }
        AbstractC10896a.m65888w("GrsUrlsSpManager", "urlHost is null");
        return "";
    }

    /* renamed from: f */
    public String m78680f(String str) {
        return this.f59365a.getString(str, "");
    }

    /* renamed from: g */
    public boolean m78681g() {
        return this.f59368d;
    }

    /* renamed from: h */
    public boolean m78682h() {
        SharedPreferences sharedPreferences = this.f59365a;
        if (sharedPreferences != null) {
            return sharedPreferences.getAll().isEmpty();
        }
        return true;
    }

    /* renamed from: i */
    public boolean m78683i(Map<String, String> map) {
        SharedPreferences.Editor editorEdit = this.f59365a.edit();
        Map<String, ?> all = this.f59365a.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!map.containsKey(key)) {
                    editorEdit.remove(key);
                }
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            editorEdit.putString(entry.getKey(), entry.getValue());
        }
        return editorEdit.commit();
    }

    /* renamed from: j */
    public void m78684j(boolean z10) {
        this.f59368d = z10;
    }
}
