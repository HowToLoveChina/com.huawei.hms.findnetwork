package p693ux;

import java.util.List;
import okhttp3.C11922g0;
import okhttp3.C11947n;
import okhttp3.C11955v;
import okhttp3.C11958y;
import okhttp3.InterfaceC11948o;
import p022ay.C1057g;

/* renamed from: ux.e */
/* loaded from: classes9.dex */
public final class C13280e {

    /* renamed from: a */
    public static final C1057g f59986a = C1057g.m6364k("\"\\");

    /* renamed from: b */
    public static final C1057g f59987b = C1057g.m6364k("\t ,=");

    /* renamed from: a */
    public static long m79712a(C11955v c11955v) {
        return m79719h(c11955v.m71853c("Content-Length"));
    }

    /* renamed from: b */
    public static long m79713b(C11922g0 c11922g0) {
        return m79712a(c11922g0.m71601y());
    }

    /* renamed from: c */
    public static boolean m79714c(C11922g0 c11922g0) {
        if (c11922g0.m71593E().m71569i().equals("HEAD")) {
            return false;
        }
        int iM71597u = c11922g0.m71597u();
        return (((iM71597u >= 100 && iM71597u < 200) || iM71597u == 204 || iM71597u == 304) && m79713b(c11922g0) == -1 && !"chunked".equalsIgnoreCase(c11922g0.m71599w("Transfer-Encoding"))) ? false : true;
    }

    /* renamed from: d */
    public static int m79715d(String str, int i10) {
        try {
            long j10 = Long.parseLong(str);
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j10 < 0) {
                return 0;
            }
            return (int) j10;
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    /* renamed from: e */
    public static void m79716e(InterfaceC11948o interfaceC11948o, C11958y c11958y, C11955v c11955v) {
        if (interfaceC11948o == InterfaceC11948o.f55635a) {
            return;
        }
        List<C11947n> listM71815f = C11947n.m71815f(c11958y, c11955v);
        if (listM71815f.isEmpty()) {
            return;
        }
        interfaceC11948o.mo71822a(c11958y, listM71815f);
    }

    /* renamed from: f */
    public static int m79717f(String str, int i10, String str2) {
        while (i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            i10++;
        }
        return i10;
    }

    /* renamed from: g */
    public static int m79718g(String str, int i10) {
        char cCharAt;
        while (i10 < str.length() && ((cCharAt = str.charAt(i10)) == ' ' || cCharAt == '\t')) {
            i10++;
        }
        return i10;
    }

    /* renamed from: h */
    public static long m79719h(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }
}
