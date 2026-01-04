package p216d4;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: d4.j0 */
/* loaded from: classes.dex */
public abstract class AbstractC9017j0 {

    /* renamed from: a */
    public static final byte[] f45652a = new byte[0];

    /* renamed from: b */
    public static Map<String, Map<Integer, List<String>>> f45653b = new HashMap();

    /* renamed from: a */
    public static List<String> m56927a(String str, int i10) {
        Map<Integer, List<String>> map;
        synchronized (f45652a) {
            try {
                if (!TextUtils.isEmpty(str) && !C8999a0.m56863a(f45653b)) {
                    if (!f45653b.containsKey(str) || (map = f45653b.get(str)) == null || map.size() == 0) {
                        return null;
                    }
                    return map.get(Integer.valueOf(i10));
                }
                return null;
            } finally {
            }
        }
    }

    /* renamed from: b */
    public static void m56928b(String str, int i10, List<String> list) {
        synchronized (f45652a) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Map<Integer, List<String>> map = f45653b.get(str);
                if (map != null) {
                    map.put(Integer.valueOf(i10), list);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put(Integer.valueOf(i10), list);
                    f45653b.put(str, map2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
