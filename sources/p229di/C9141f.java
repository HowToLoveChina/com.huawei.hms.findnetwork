package p229di;

import p229di.C9142g;

/* renamed from: di.f */
/* loaded from: classes4.dex */
public class C9141f {

    /* renamed from: a */
    public static final String f45939a;

    static {
        f45939a = C9142g.m57463b() ? "com.hihonor.android.content.pm.UserInfoEx" : "com.huawei.android.content.pm.UserInfoEx";
    }

    /* renamed from: a */
    public static boolean m57460a(Object obj) {
        try {
            return ((Boolean) C9142g.a.m57467b(obj, new Class[0]).m57470d("isClonedProfile", new Object[0]).m57472f()).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m57461b() {
        try {
            C9142g.a.m57468c(f45939a, new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
