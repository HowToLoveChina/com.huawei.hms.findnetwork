package com.huawei.updatesdk.p191b.p201h;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;

/* renamed from: com.huawei.updatesdk.b.h.c */
/* loaded from: classes9.dex */
public final class C8835c {

    /* renamed from: a */
    private static String f45185a;

    /* renamed from: b */
    private static Resources f45186b;

    /* renamed from: a */
    public static int m56331a(Context context, String str) {
        return m56332a(context, str, "id");
    }

    /* renamed from: b */
    public static int m56334b(Context context, String str) {
        return m56332a(context, str, "layout");
    }

    /* renamed from: c */
    public static int m56335c(Context context, String str) {
        return m56332a(context, str, ExtractOWiFiHelper.STING_NODE);
    }

    /* renamed from: a */
    private static int m56332a(Context context, String str, String str2) {
        if (f45186b == null) {
            f45186b = context.getResources();
        }
        return f45186b.getIdentifier(str, str2, m56333a(context));
    }

    /* renamed from: a */
    private static String m56333a(Context context) {
        if (f45185a == null) {
            f45185a = context.getPackageName();
        }
        return f45185a;
    }
}
