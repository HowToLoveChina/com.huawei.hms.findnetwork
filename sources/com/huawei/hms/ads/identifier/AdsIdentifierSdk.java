package com.huawei.hms.ads.identifier;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes8.dex */
public abstract class AdsIdentifierSdk {
    private static Context appContext;

    @Keep
    public static void destroy(Context context) {
        appContext = null;
        C5070d.m30261b(context);
    }

    public static Context getContext() {
        return appContext;
    }

    @Keep
    public static void init(Context context) {
        if (context == null) {
            return;
        }
        appContext = context.getApplicationContext();
        C5070d.m30260a(context);
        C5069c.m30254b(context);
    }
}
