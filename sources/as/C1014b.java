package as;

import android.util.Log;
import java.text.Normalizer;

/* renamed from: as.b */
/* loaded from: classes8.dex */
public final class C1014b {
    /* renamed from: a */
    public static void m6174a(int i10, String str, String str2) {
        if (!C1016d.m6188h() && i10 == 4 && C1016d.m6189i()) {
            return;
        }
        C1019g c1019g = new C1019g(i10, "LITE_SDK-" + str);
        c1019g.m6195c(str2);
        c1019g.m6197e(null);
        String str3 = c1019g.m6193a() + c1019g.m6194b();
        Log.println(i10, str, str3 != null ? Normalizer.normalize(str3, Normalizer.Form.NFKC).replace("\\n", "").replace("\\r", "") : "");
    }

    /* renamed from: b */
    public static void m6175b(int i10, String str, String str2, Throwable th2) {
        C1019g c1019g = new C1019g(i10, "LITE_SDK-" + str);
        c1019g.m6195c(str2);
        c1019g.m6197e(th2);
        String str3 = c1019g.m6193a() + c1019g.m6194b();
        Log.println(i10, str, str3 != null ? Normalizer.normalize(str3, Normalizer.Form.NFKC).replace("\\n", "").replace("\\r", "") : "");
    }
}
