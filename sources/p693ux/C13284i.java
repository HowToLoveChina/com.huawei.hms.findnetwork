package p693ux;

import java.net.Proxy;
import okhttp3.C11918e0;
import okhttp3.C11958y;

/* renamed from: ux.i */
/* loaded from: classes9.dex */
public final class C13284i {
    /* renamed from: a */
    public static String m79727a(C11918e0 c11918e0, Proxy.Type type) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c11918e0.m71569i());
        sb2.append(' ');
        if (m79728b(c11918e0, type)) {
            sb2.append(c11918e0.m71573m());
        } else {
            sb2.append(m79729c(c11918e0.m71573m()));
        }
        sb2.append(" HTTP/1.1");
        return sb2.toString();
    }

    /* renamed from: b */
    public static boolean m79728b(C11918e0 c11918e0, Proxy.Type type) {
        return !c11918e0.m71568h() && type == Proxy.Type.HTTP;
    }

    /* renamed from: c */
    public static String m79729c(C11958y c11958y) {
        String strM71900g = c11958y.m71900g();
        String strM71902i = c11958y.m71902i();
        if (strM71902i == null) {
            return strM71900g;
        }
        return strM71900g + '?' + strM71902i;
    }
}
