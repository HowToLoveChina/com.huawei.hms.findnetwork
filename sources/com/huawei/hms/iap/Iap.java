package com.huawei.hms.iap;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;

/* loaded from: classes8.dex */
public class Iap {
    private Iap() {
    }

    public static IapClient getIapClient(Activity activity) {
        Checker.assertNonNull(activity);
        return new C5632d(activity);
    }

    public static IapClient getIapClient(Activity activity, String str) {
        Checker.assertNonNull(activity);
        Checker.assertNonNull(str);
        return new C5632d(activity, str);
    }

    public static IapClient getIapClient(Activity activity, String str, boolean z10) {
        Checker.assertNonNull(activity);
        if (z10) {
            Checker.assertNonNull(str, "Null productAppId is not permitted.");
        }
        return new C5632d(activity, str, z10);
    }

    public static IapClient getIapClient(Context context) {
        Checker.assertNonNull(context);
        return new C5632d(context);
    }

    public static IapClient getIapClient(Context context, String str) {
        Checker.assertNonNull(context);
        Checker.assertNonNull(str);
        return new C5632d(context, str);
    }

    public static IapClient getIapClient(Context context, String str, boolean z10) {
        Checker.assertNonNull(context);
        if (z10) {
            Checker.assertNonNull(str, "Null productAppId is not permitted.");
        }
        return new C5632d(context, str, z10);
    }
}
