package p229di;

import android.content.Intent;
import p229di.C9142g;

/* renamed from: di.e */
/* loaded from: classes4.dex */
public class C9140e {

    /* renamed from: a */
    public static final String f45938a;

    static {
        f45938a = C9142g.m57463b() ? "com.hihonor.android.content.IntentExEx" : "com.huawei.android.content.IntentExEx";
    }

    /* renamed from: a */
    public static boolean m57458a(Intent intent, int i10) {
        try {
            C9142g.a.m57468c(f45938a, Intent.class, Integer.TYPE).m57470d("addHwFlags", intent, Integer.valueOf(i10)).m57472f();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static int m57459b(String str) {
        try {
            return ((Integer) C9142g.a.m57468c(f45938a, new Class[0]).m57473h(str).m57472f()).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }
}
