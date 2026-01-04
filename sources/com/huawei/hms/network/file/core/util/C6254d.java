package com.huawei.hms.network.file.core.util;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.huawei.hms.network.file.core.util.d */
/* loaded from: classes8.dex */
public class C6254d {
    /* renamed from: a */
    private static List<String> m36364a(Map<String, List<String>> map, String str) {
        List<String> value = null;
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(str)) {
                    value = entry.getValue();
                }
            }
        }
        return value;
    }

    /* renamed from: b */
    public static boolean m36366b(Map<String, List<String>> map) {
        if (map == null) {
            return false;
        }
        List<String> listM36364a = m36364a(map, "Content-Encoding");
        if (Utils.isEmpty(listM36364a)) {
            return false;
        }
        Iterator<String> it = listM36364a.iterator();
        while (it.hasNext()) {
            if (Constants.GZIP.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m36367c(Map<String, List<String>> map) {
        if (map == null) {
            return false;
        }
        List<String> listM36364a = m36364a(map, "Accept-Ranges");
        if (!Utils.isEmpty(listM36364a)) {
            Iterator<String> it = listM36364a.iterator();
            while (it.hasNext()) {
                if ("bytes".equalsIgnoreCase(it.next().toLowerCase(Locale.ROOT))) {
                    return true;
                }
            }
        }
        return !Utils.isEmpty(m36364a(map, "Content-Range"));
    }

    /* renamed from: a */
    public static boolean m36365a(Map<String, List<String>> map) {
        if (map == null) {
            return false;
        }
        List<String> listM36364a = m36364a(map, "Content-Encoding");
        if (Utils.isEmpty(listM36364a)) {
            return false;
        }
        Iterator<String> it = listM36364a.iterator();
        while (it.hasNext()) {
            if (!"none".equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }
}
