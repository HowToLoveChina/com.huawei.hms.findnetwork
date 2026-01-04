package dk;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p399jk.AbstractC10896a;

/* renamed from: dk.d */
/* loaded from: classes6.dex */
public class C9163d {

    /* renamed from: a */
    public static Map<String, String> f45959a = new ConcurrentHashMap();

    /* renamed from: a */
    public static String m57584a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return f45959a.get(str);
        }
        AbstractC10896a.m65888w("StringConstants", "key is empty");
        return "";
    }

    /* renamed from: b */
    public static void m57585b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AbstractC10896a.m65888w("StringConstants", "key or value is empty");
        } else {
            f45959a.put(str, str2);
        }
    }
}
