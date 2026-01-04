package p572qb;

import android.text.TextUtils;
import io.C10582a;
import java.util.HashMap;
import mk.C11477c;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: qb.l0 */
/* loaded from: classes3.dex */
public class C12320l0 {

    /* renamed from: qb.l0$a */
    public static class a {

        /* renamed from: a */
        public static C12320l0 f57049a = new C12320l0();
    }

    /* renamed from: a */
    public static synchronized C12320l0 m74090a() {
        return a.f57049a;
    }

    /* renamed from: b */
    public void m74091b() {
        if (C0213f.m1377a() == null) {
            C11839m.m70687e("UserRegisterManager", "refreshTimeZone context is null.");
            return;
        }
        C11060c c11060c = new C11060c();
        c11060c.m66643I(C11058a.m66627b("06008"));
        try {
            HashMap<String, String> resultMap = new C10582a(c11060c.m66661q()).m64942k().getResultMap();
            if (resultMap != null) {
                String str = resultMap.get("userTimeZone");
                C11839m.m70686d("UserRegisterManager", "refreshTimeZone timeZone = " + str);
                if (TextUtils.isEmpty(str)) {
                    C11839m.m70689w("UserRegisterManager", "refreshTimeZone timeZone is null.");
                } else {
                    C13452e.m80781L().m80809G2(C11477c.m68636f(str));
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("UserRegisterManager", "refreshTimeZone exception: " + e10.toString());
        }
    }
}
