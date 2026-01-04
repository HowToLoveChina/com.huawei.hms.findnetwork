package p043c1;

import android.webkit.WebSettings;
import p213d1.AbstractC8975a;
import p213d1.C8977c;
import p213d1.C8981g;
import p213d1.C8982h;
import p213d1.C8983i;

/* renamed from: c1.b */
/* loaded from: classes.dex */
public class C1377b {
    /* renamed from: a */
    public static C8981g m7913a(WebSettings webSettings) {
        return C8983i.m56811c().m56814a(webSettings);
    }

    @Deprecated
    /* renamed from: b */
    public static void m7914b(WebSettings webSettings, int i10) {
        AbstractC8975a.h hVar = C8982h.f45547T;
        if (hVar.mo56788c()) {
            C8977c.m56800d(webSettings, i10);
        } else {
            if (!hVar.mo56789d()) {
                throw C8982h.m56806a();
            }
            m7913a(webSettings).m56805a(i10);
        }
    }
}
