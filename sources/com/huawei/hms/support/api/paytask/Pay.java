package com.huawei.hms.support.api.paytask;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;

/* loaded from: classes8.dex */
public class Pay {
    private Pay() {
    }

    public static PayClient getPayClient(Activity activity) {
        Checker.assertNonNull(activity);
        return new PayClientEntryImpl(activity);
    }

    public static PayClient getPayClient(Context context) {
        Checker.assertNonNull(context);
        return new PayClientEntryImpl(context);
    }
}
