package p253ea;

import ba.C1152f;
import java.util.HashMap;

/* renamed from: ea.a */
/* loaded from: classes3.dex */
public class C9439a {
    /* renamed from: a */
    public static void m59207a(String str) {
        m59208b(str, -1);
    }

    /* renamed from: b */
    public static void m59208b(String str, int i10) {
        HashMap map = new HashMap();
        map.put("result", "1");
        map.put("err_reason", str);
        if (i10 >= 0) {
            map.put("retry_num", String.valueOf(i10));
        }
        C1152f.m7225a().m7227c(map);
    }
}
