package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

/* renamed from: com.google.android.material.internal.f */
/* loaded from: classes.dex */
public class C1775f {
    /* renamed from: a */
    public static boolean m10684a() {
        return m10685b() || m10687d();
    }

    /* renamed from: b */
    public static boolean m10685b() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("lge");
    }

    /* renamed from: c */
    public static boolean m10686c() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
    }

    /* renamed from: d */
    public static boolean m10687d() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("samsung");
    }
}
