package es;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: es.r */
/* loaded from: classes8.dex */
public class C9553r {

    /* renamed from: a */
    public static final Pattern f47463a = Pattern.compile("\\d+");

    /* renamed from: b */
    public static final Pattern f47464b = Pattern.compile("^[.0-9a-zA-Z_-]{1,}$");

    /* renamed from: a */
    public static boolean m59644a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (m59645b(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m59645b(String str) {
        return str == null || str.isEmpty();
    }
}
