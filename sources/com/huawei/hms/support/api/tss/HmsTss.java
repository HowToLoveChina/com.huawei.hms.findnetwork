package com.huawei.hms.support.api.tss;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;

/* loaded from: classes8.dex */
public class HmsTss {
    private static final String TAG = "HmsTss";

    public static synchronized TssClient getTssClient(Context context) {
        return getTssClient(context, "");
    }

    public static synchronized TssClient getTssClient(Context context, String str) {
        Checker.assertNonNull(context);
        return new C6402b(context, str, new TssOptions());
    }

    public static synchronized TssClient getTssClient(Activity activity) {
        return getTssClient(activity, "");
    }

    public static synchronized TssClient getTssClient(Activity activity, String str) {
        Checker.assertNonNull(activity);
        return new C6402b(activity, str, new TssOptions());
    }
}
