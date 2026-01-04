package p229di;

import android.os.UserManager;
import java.util.ArrayList;
import java.util.List;
import p229di.C9142g;

/* renamed from: di.t */
/* loaded from: classes4.dex */
public class C9155t {
    /* renamed from: a */
    public static Object m57496a(UserManager userManager, String str, int i10, int i11) {
        try {
            Class cls = Integer.TYPE;
            return C9142g.a.m57467b(userManager, String.class, cls, cls).m57470d("createProfileForUser", str, Integer.valueOf(i10), Integer.valueOf(i11)).m57472f();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static int m57497b(UserManager userManager, int i10) {
        try {
            return ((Integer) C9142g.a.m57467b(userManager, Integer.TYPE).m57470d("getCredentialOwnerProfile", Integer.valueOf(i10)).m57472f()).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: c */
    public static Object m57498c(UserManager userManager, int i10) {
        try {
            return C9142g.a.m57467b(userManager, Integer.TYPE).m57470d("getUserInfo", Integer.valueOf(i10)).m57472f();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static List<Object> m57499d(UserManager userManager) {
        try {
            return (List) C9142g.a.m57467b(userManager, new Class[0]).m57470d("getUsers", new Object[0]).m57472f();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }
}
