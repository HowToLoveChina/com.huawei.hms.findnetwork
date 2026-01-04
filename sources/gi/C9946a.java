package gi;

import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.hms.drive.C5282f;
import java.net.URL;
import p340hi.C10209a;
import p680ui.InterfaceC13180d;

/* renamed from: gi.a */
/* loaded from: classes.dex */
public class C9946a {

    /* renamed from: e */
    public static long f48711e;

    /* renamed from: f */
    public static String f48712f;

    /* renamed from: g */
    public static String f48713g;

    /* renamed from: a */
    public InterfaceC4614q f48715a;

    /* renamed from: b */
    public static final C4650r f48708b = C4650r.m28485f("MediaHttpInterceptor");

    /* renamed from: c */
    public static final Object f48709c = new Object();

    /* renamed from: d */
    public static boolean f48710d = false;

    /* renamed from: h */
    public static int f48714h = -1;

    public C9946a(InterfaceC4614q interfaceC4614q) {
        this.f48715a = interfaceC4614q;
    }

    /* renamed from: b */
    public static void m61628b(boolean z10) {
        f48710d = z10;
    }

    /* renamed from: a */
    public void m61629a(C4604g c4604g) {
        synchronized (f48709c) {
            if (!f48710d) {
                InterfaceC4614q interfaceC4614q = this.f48715a;
                if (interfaceC4614q instanceof C10209a) {
                    String strM63358h = ((C10209a) interfaceC4614q).m63358h();
                    if (C4633d0.m28404a(strM63358h)) {
                        return;
                    }
                    try {
                        InterfaceC13180d interfaceC13180dM31716a = C5282f.m31716a("DriveConfig");
                        if (interfaceC13180dM31716a != null) {
                            String str = (String) interfaceC13180dM31716a.mo79229c(strM63358h + "_time");
                            f48711e = str == null ? 0L : Long.valueOf(str).longValue();
                            String str2 = (String) interfaceC13180dM31716a.mo79229c(strM63358h + "_host");
                            if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
                                str2 = "https://" + str2;
                            }
                            URL url = new URL(str2);
                            f48712f = url.getProtocol();
                            f48713g = url.getHost();
                            f48714h = url.getPort();
                        }
                    } catch (Exception e10) {
                        f48708b.m28489d("init drive file proxy host error: " + e10.getMessage());
                    }
                    f48710d = true;
                }
            }
            if (System.currentTimeMillis() > f48711e) {
                f48710d = false;
                f48712f = "";
                f48713g = "";
                f48714h = -1;
            }
            if (!C4633d0.m28404a(f48712f) && !C4633d0.m28404a(f48713g)) {
                c4604g.m28206y(f48712f);
                c4604g.m28203v(f48713g);
                c4604g.m28204w(f48714h);
            }
        }
    }
}
