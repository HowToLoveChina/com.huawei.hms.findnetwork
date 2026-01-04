package cn.com.miaozhen.mobile.tracking.util;

import android.content.Context;
import cn.com.miaozhen.mobile.tracking.p055a.C1471h;
import ijiami_release01.NCall;
import java.util.Map;

/* renamed from: cn.com.miaozhen.mobile.tracking.util.i */
/* loaded from: classes.dex */
public class C1492i {

    /* renamed from: a */
    private static C1471h f6374a = null;

    /* renamed from: b */
    private static String f6375b = null;

    /* renamed from: c */
    private static boolean f6376c = false;

    /* renamed from: cn.com.miaozhen.mobile.tracking.util.i$a */
    public static class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f6377a;

        /* renamed from: b */
        final /* synthetic */ String f6378b;

        public a(Context context, String str) {
            this.f6377a = context;
            this.f6378b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.m64618IV(new Object[]{145, this});
        }
    }

    static {
        NCall.m64618IV(new Object[]{146});
    }

    /* renamed from: b */
    public static C1471h m8482b(Context context) {
        return (C1471h) NCall.m64616IL(new Object[]{150, context});
    }

    /* renamed from: c */
    private static C1471h m8484c(Context context) {
        return (C1471h) NCall.m64616IL(new Object[]{151, context});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m8485c(C1471h c1471h) {
        NCall.m64618IV(new Object[]{152, c1471h});
    }

    /* renamed from: a */
    public static synchronized void m8478a(Context context, String str) {
        NCall.m64618IV(new Object[]{147, context, str});
    }

    /* renamed from: a */
    private static boolean m8479a(Context context) {
        return NCall.m64619IZ(new Object[]{148, context});
    }

    /* renamed from: a */
    public static boolean m8480a(Map<String, Long> map, String str) {
        return NCall.m64619IZ(new Object[]{149, map, str});
    }
}
