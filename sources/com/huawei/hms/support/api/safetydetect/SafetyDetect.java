package com.huawei.hms.support.api.safetydetect;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.support.api.safetydetect.p860default.C6380u;
import com.huawei.hms.utils.Checker;

/* loaded from: classes8.dex */
public class SafetyDetect {
    public static SafetyDetectClient getClient(Activity activity) {
        Checker.assertNonNull(activity);
        return new C6353a(activity, new C6380u());
    }

    public static SafetyDetectClient getClient(Context context) {
        Checker.assertNonNull(context);
        return new C6353a(context, new C6380u());
    }
}
