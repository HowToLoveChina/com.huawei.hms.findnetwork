package com.huawei.android.dynamicfeature.plugin.language;

import android.content.Context;
import android.webkit.WebView;
import p250e7.C9419a;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.m */
/* loaded from: classes2.dex */
public class C2405m {

    /* renamed from: a */
    public static Context f11495a = null;

    /* renamed from: b */
    public static boolean f11496b = false;

    /* renamed from: c */
    public static boolean f11497c = false;

    /* renamed from: d */
    public static final String f11498d = "m";

    /* renamed from: com.huawei.android.dynamicfeature.plugin.language.m$a */
    public static class a {

        /* renamed from: a */
        public static WebView f11499a = new WebView(C2405m.f11495a);
    }

    /* renamed from: b */
    public static synchronized void m15023b(Context context) {
        try {
            if (f11496b) {
                return;
            }
            if (!f11497c) {
                try {
                    f11495a = context;
                    a.f11499a.loadData("", "", "");
                    a.f11499a.stopLoading();
                    a.f11499a.destroy();
                    f11497c = true;
                } catch (Exception e10) {
                    C9419a.m59082h(f11498d, "init webview failed", e10);
                    return;
                }
            }
            try {
                C2396d.m14992c(context);
                f11496b = true;
                f11495a = null;
                a.f11499a = null;
            } catch (Exception e11) {
                C9419a.m59082h(f11498d, "install language failed", e11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
