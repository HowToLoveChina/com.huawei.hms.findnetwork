package p229di;

import android.os.UserManager;
import p229di.C9142g;

/* renamed from: di.u */
/* loaded from: classes4.dex */
public class C9156u {

    /* renamed from: a */
    public static final String f45944a;

    static {
        f45944a = C9142g.m57463b() ? "com.hihonor.android.os.UserManagerEx" : "com.huawei.android.os.UserManagerEx";
    }

    /* renamed from: a */
    public static Object m57500a(UserManager userManager, int i10) {
        try {
            return C9142g.a.m57468c(f45944a, UserManager.class, Integer.TYPE).m57470d("getUserInfoEx", userManager, Integer.valueOf(i10)).m57472f();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m57501b(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return ((Boolean) C9142g.a.m57468c(f45944a, obj.getClass()).m57470d("isHwHiddenSpace", obj).m57472f()).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
