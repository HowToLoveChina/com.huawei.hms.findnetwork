package p281f8;

import android.content.Context;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.request.callable.SerialTaskCallable;
import gp.C10028c;
import p031b7.C1120a;
import p031b7.C1136q;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: f8.i */
/* loaded from: classes2.dex */
public class C9672i {
    /* renamed from: a */
    public static boolean m60381a() {
        return C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1();
    }

    /* renamed from: b */
    public static boolean m60382b(Context context) {
        return !C1136q.a.m6988c(context);
    }

    /* renamed from: c */
    public static boolean m60383c() {
        return !CloudAlbumSettings.m14363h().m14380p();
    }

    /* renamed from: d */
    public static boolean m60384d() {
        return C13452e.m80781L().m80932j1();
    }

    /* renamed from: e */
    public static boolean m60385e(Context context) {
        return !C1136q.e.m7166d(context);
    }

    /* renamed from: f */
    public static void m60386f(Context context, int i10, boolean z10) {
        if (i10 == 1002) {
            m60388h(context, !z10);
            return;
        }
        if (i10 == 1001) {
            m60387g(!z10);
            return;
        }
        C1120a.m6675d("SwitchProcessor", "not support broadcast for cmdId: " + i10);
    }

    /* renamed from: g */
    public static void m60387g(boolean z10) {
        C9665b.m60344a(z10 ? 1 : 0);
    }

    /* renamed from: h */
    public static void m60388h(Context context, boolean z10) {
        C12515a.m75110o().m75175e(new SerialTaskCallable(context, z10, SerialTaskCallable.REPORT_SWITCH_DATA), false);
        C9665b.m60349f(context, z10 ? 1 : 0);
    }
}
