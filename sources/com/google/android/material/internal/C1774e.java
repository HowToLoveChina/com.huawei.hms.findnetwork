package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.Window;
import p273f0.C9593d1;
import p273f0.C9623r0;
import p760x2.C13689a;

/* renamed from: com.google.android.material.internal.e */
/* loaded from: classes.dex */
public class C1774e {
    /* renamed from: a */
    public static void m10680a(Window window, boolean z10, Integer num, Integer num2) {
        boolean z11 = num == null || num.intValue() == 0;
        boolean z12 = num2 == null || num2.intValue() == 0;
        if (z11 || z12) {
            int iM82288b = C13689a.m82288b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z11) {
                num = Integer.valueOf(iM82288b);
            }
            if (z12) {
                num2 = Integer.valueOf(iM82288b);
            }
        }
        C9623r0.m60136b(window, !z10);
        int iM10682c = m10682c(window.getContext(), z10);
        int iM10681b = m10681b(window.getContext(), z10);
        window.setStatusBarColor(iM10682c);
        window.setNavigationBarColor(iM10681b);
        boolean zM10683d = m10683d(iM10682c, C13689a.m82292f(num.intValue()));
        boolean zM10683d2 = m10683d(iM10681b, C13689a.m82292f(num2.intValue()));
        C9593d1 c9593d1M60135a = C9623r0.m60135a(window, window.getDecorView());
        if (c9593d1M60135a != null) {
            c9593d1M60135a.m59810b(zM10683d);
            c9593d1M60135a.m59809a(zM10683d2);
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    public static int m10681b(Context context, boolean z10) {
        if (z10) {
            return 0;
        }
        return C13689a.m82288b(context, R.attr.navigationBarColor, -16777216);
    }

    @TargetApi(21)
    /* renamed from: c */
    public static int m10682c(Context context, boolean z10) {
        if (z10) {
            return 0;
        }
        return C13689a.m82288b(context, R.attr.statusBarColor, -16777216);
    }

    /* renamed from: d */
    public static boolean m10683d(int i10, boolean z10) {
        return C13689a.m82292f(i10) || (i10 == 0 && z10);
    }
}
