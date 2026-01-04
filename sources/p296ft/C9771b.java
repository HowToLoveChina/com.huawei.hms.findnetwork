package p296ft;

import com.huawei.location.C6757d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ft.b */
/* loaded from: classes8.dex */
public final class C9771b {

    /* renamed from: a */
    public static final Map<Integer, String> f48056a;

    static {
        HashMap map = new HashMap();
        C6757d.m38366a(29, map, "Android10", 30, "Android11");
        C6757d.m38366a(28, map, "Android9", 26, "Android8");
        C6757d.m38366a(27, map, "Android8", 24, "Android7");
        map.put(25, "Android7");
        f48056a = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public static String m60805a(int i10) {
        return f48056a.get(Integer.valueOf(i10));
    }
}
