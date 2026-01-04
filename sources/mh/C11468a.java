package mh;

import android.text.TextUtils;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: mh.a */
/* loaded from: classes4.dex */
public class C11468a {

    /* renamed from: a */
    public static Map<String, InstallCallback> f53362a = new ConcurrentHashMap();

    /* renamed from: b */
    public static Map<String, MarketInfo> f53363b = new ConcurrentHashMap();

    /* renamed from: a */
    public static InstallCallback m68590a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f53362a.get(str);
    }

    /* renamed from: b */
    public static String m68591b(InstallCallback installCallback) {
        if (installCallback == null) {
            return "";
        }
        String string = UUID.randomUUID().toString();
        f53362a.put(string, installCallback);
        return string;
    }

    /* renamed from: c */
    public static void m68592c(String str, MarketInfo marketInfo) {
        if (str == null) {
            return;
        }
        f53363b.put(str, marketInfo);
    }

    /* renamed from: d */
    public static MarketInfo m68593d(String str) {
        if (str == null) {
            return null;
        }
        return f53363b.get(str);
    }

    /* renamed from: e */
    public static void m68594e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f53362a.remove(str);
    }

    /* renamed from: f */
    public static void m68595f(String str) {
        if (str == null) {
            return;
        }
        f53363b.remove(str);
    }
}
