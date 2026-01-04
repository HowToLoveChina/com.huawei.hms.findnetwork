package com.huawei.hms.framework.network.grs.p120e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.e.c */
/* loaded from: classes8.dex */
public class C5436c {

    /* renamed from: b */
    private static final String f24921b = "c";

    /* renamed from: c */
    private static final Map<String, PLSharedPreferences> f24922c = new ConcurrentHashMap(16);

    /* renamed from: a */
    private final PLSharedPreferences f24923a;

    public C5436c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.m32137d(f24921b, "get pkgname from context is{%s}", packageName);
        Map<String, PLSharedPreferences> map = f24922c;
        if (map.containsKey(str + packageName)) {
            this.f24923a = map.get(str + packageName);
        } else {
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(context, str + packageName);
            this.f24923a = pLSharedPreferences;
            map.put(str + packageName, pLSharedPreferences);
        }
        m32199a(context);
    }

    /* renamed from: a */
    public String m32200a(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.f24923a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.f24923a.getString(str, str2);
        }
        return string;
    }

    /* renamed from: b */
    public void m32203b() {
        PLSharedPreferences pLSharedPreferences = this.f24923a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f24923a.clear();
        }
    }

    /* renamed from: a */
    public Map<String, ?> m32201a() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f24923a;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.f24923a.getAll();
        }
        return all;
    }

    /* renamed from: b */
    public void m32204b(String str, String str2) {
        PLSharedPreferences pLSharedPreferences = this.f24923a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f24923a.putString(str, str2);
        }
    }

    /* renamed from: a */
    private void m32199a(Context context) {
        String str = f24921b;
        Logger.m32141i(str, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            String string = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String strM32200a = m32200a("version", "");
            if (string.equals(strM32200a)) {
                return;
            }
            Logger.m32142i(str, "app version changed! old version{%s} and new version{%s}", strM32200a, string);
            m32203b();
            m32204b("version", string);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.m32145w(f24921b, "get app version failed and catch NameNotFoundException");
        }
    }

    /* renamed from: a */
    public void m32202a(String str) {
        PLSharedPreferences pLSharedPreferences = this.f24923a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f24923a.remove(str);
        }
    }
}
