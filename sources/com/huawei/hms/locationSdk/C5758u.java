package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;
import java.util.Locale;

/* renamed from: com.huawei.hms.locationSdk.u */
/* loaded from: classes8.dex */
public class C5758u {
    /* renamed from: a */
    public static InterfaceC5693a0 m33168a(Activity activity, C5765w0 c5765w0) {
        Checker.assertNonNull(activity);
        return new C5701c0(activity, c5765w0);
    }

    /* renamed from: b */
    public static InterfaceC5709e0 m33172b(Activity activity, C5765w0 c5765w0) {
        Checker.assertNonNull(activity);
        return new LocationClientImpl(activity, c5765w0);
    }

    /* renamed from: c */
    public static InterfaceC5720h0 m33174c(Activity activity, C5765w0 c5765w0) {
        Checker.assertNonNull(activity);
        return new C5726j0(activity, c5765w0);
    }

    /* renamed from: d */
    public static InterfaceC5738n0 m33176d(Activity activity, C5765w0 c5765w0) {
        Checker.assertNonNull(activity);
        return new C5744p0(activity, c5765w0);
    }

    /* renamed from: a */
    public static InterfaceC5693a0 m33169a(Context context, C5765w0 c5765w0) {
        Checker.assertNonNull(context);
        return new C5701c0(context, c5765w0);
    }

    /* renamed from: b */
    public static InterfaceC5709e0 m33173b(Context context, C5765w0 c5765w0) {
        Checker.assertNonNull(context);
        return new LocationClientImpl(context, c5765w0);
    }

    /* renamed from: c */
    public static InterfaceC5720h0 m33175c(Context context, C5765w0 c5765w0) {
        Checker.assertNonNull(context);
        return new C5726j0(context, c5765w0);
    }

    /* renamed from: d */
    public static InterfaceC5738n0 m33177d(Context context, C5765w0 c5765w0) {
        Checker.assertNonNull(context);
        return new C5744p0(context, c5765w0);
    }

    /* renamed from: a */
    public static InterfaceC5729k0 m33170a(Activity activity, Locale locale, C5765w0 c5765w0) {
        Checker.assertNonNull(activity);
        return new C5735m0(activity, locale, c5765w0);
    }

    /* renamed from: a */
    public static InterfaceC5729k0 m33171a(Context context, Locale locale, C5765w0 c5765w0) {
        Checker.assertNonNull(context);
        return new C5735m0(context, locale, c5765w0);
    }
}
