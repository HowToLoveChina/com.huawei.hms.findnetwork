package cn.com.miaozhen.mobile.tracking.util;

import android.content.Context;
import ijiami_release01.NCall;

/* renamed from: cn.com.miaozhen.mobile.tracking.util.a */
/* loaded from: classes.dex */
public class C1484a {

    /* renamed from: a */
    public static String f6356a = "";

    /* renamed from: b */
    public static int f6357b = 2;

    /* renamed from: c */
    public static int f6358c;

    /* renamed from: cn.com.miaozhen.mobile.tracking.util.a$a */
    public static class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f6359a;

        public a(Context context) {
            this.f6359a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.m64618IV(new Object[]{84, this});
        }
    }

    static {
        NCall.m64618IV(new Object[]{85});
    }

    /* renamed from: a */
    public static String m8418a(Context context) {
        return (String) NCall.m64616IL(new Object[]{86, context});
    }
}
