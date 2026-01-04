package ug;

import android.content.Context;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p015ak.C0209d;
import p521og.C11877j;
import p521og.C11881n;
import p809yg.C13981a;
import tg.C13011a;

/* renamed from: ug.b */
/* loaded from: classes4.dex */
public final class C13172b {
    /* renamed from: a */
    public static int m79205a(Context context) {
        int iM79206b = m79206b(context);
        if (!C0209d.m1277l1() ? !m79210f("com.huawei.android.app.HwSdLockManager") : !m79210f("com.hihonor.android.app.HwSdLockManager")) {
            iM79206b &= -33;
        }
        if (!m79209e(context)) {
            iM79206b &= -65;
        }
        if (!C11881n.m71338A(context)) {
            iM79206b &= -257;
        }
        return iM79206b & (-17);
    }

    /* renamed from: b */
    public static int m79206b(Context context) {
        int i10 = C13011a.m78314a() ? HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA : 127;
        return C11881n.m71338A(context) ? i10 | 256 : i10;
    }

    /* renamed from: c */
    public static int m79207c(Context context) {
        return C11877j.m71222N(context, m79206b(context));
    }

    /* renamed from: d */
    public static int m79208d(int i10) {
        switch (i10) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            default:
                return 0;
        }
    }

    /* renamed from: e */
    public static boolean m79209e(Context context) {
        return C13171a.m79198d();
    }

    /* renamed from: f */
    public static boolean m79210f(String str) throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (Exception e10) {
            C13981a.m83988e("ClientCapability", "ClientCapability isClassSupport Exception" + e10.getMessage());
            cls = null;
        }
        return cls != null;
    }

    /* renamed from: g */
    public static boolean m79211g(Context context) {
        int iM79205a = m79205a(context);
        String strM26236g = C4347e.m26236g();
        String str = C1443a.f6213a;
        return (iM79205a == m79207c(context) && ((TextUtils.isEmpty(strM26236g) || strM26236g.equals(C11877j.m71258d0(context))) && (TextUtils.isEmpty(str) || str.equals(C11877j.m71255c0(context))))) ? false : true;
    }

    /* renamed from: h */
    public static boolean m79212h(int i10, int i11) {
        int iM79208d = m79208d(i10);
        return iM79208d != 0 && (iM79208d & i11) > 0;
    }

    /* renamed from: i */
    public static void m79213i(Context context, int i10) {
        C11877j.m71233S0(context, i10);
        C4347e.m26240k(context);
    }
}
