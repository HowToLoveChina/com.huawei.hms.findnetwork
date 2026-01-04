package p271ez;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Map;

/* renamed from: ez.e */
/* loaded from: classes9.dex */
public class C9579e {

    /* renamed from: a */
    public static final ThreadLocal f47673a = new ThreadLocal();

    /* renamed from: ez.e$a */
    public static class a implements PrivilegedAction {

        /* renamed from: a */
        public final /* synthetic */ String f47674a;

        public a(String str) {
            this.f47674a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return Security.getProperty(this.f47674a);
        }
    }

    /* renamed from: ez.e$b */
    public static class b implements PrivilegedAction {

        /* renamed from: a */
        public final /* synthetic */ String f47675a;

        public b(String str) {
            this.f47675a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty(this.f47675a);
        }
    }

    /* renamed from: a */
    public static String m59774a(String str) {
        String str2;
        String str3 = (String) AccessController.doPrivileged(new a(str));
        if (str3 != null) {
            return str3;
        }
        Map map = (Map) f47673a.get();
        return (map == null || (str2 = (String) map.get(str)) == null) ? (String) AccessController.doPrivileged(new b(str)) : str2;
    }

    /* renamed from: b */
    public static boolean m59775b(String str) {
        try {
            return m59776c(m59774a(str));
        } catch (AccessControlException unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m59776c(String str) {
        if (str == null || str.length() != 4) {
            return false;
        }
        if (str.charAt(0) != 't' && str.charAt(0) != 'T') {
            return false;
        }
        if (str.charAt(1) != 'r' && str.charAt(1) != 'R') {
            return false;
        }
        if (str.charAt(2) == 'u' || str.charAt(2) == 'U') {
            return str.charAt(3) == 'e' || str.charAt(3) == 'E';
        }
        return false;
    }
}
