package p229di;

import p229di.C9142g;

/* renamed from: di.a */
/* loaded from: classes4.dex */
public class C9136a {

    /* renamed from: a */
    public static final String f45935a;

    static {
        f45935a = C9142g.m57463b() ? "com.hihonor.android.app.ActivityManagerEx" : "com.huawei.android.app.ActivityManagerEx";
    }

    /* renamed from: a */
    public static boolean m57448a(int i10) {
        try {
            C9142g.a.m57468c(f45935a, Integer.TYPE).m57470d("startUserInBackground", Integer.valueOf(i10)).m57472f();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
