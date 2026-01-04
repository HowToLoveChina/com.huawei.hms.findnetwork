package com.huawei.hms.support.api.sns.json;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;

/* loaded from: classes8.dex */
public class Sns {
    private Sns() {
    }

    public static FamilyClient getFamilyClient(Activity activity, SnsOptions snsOptions) {
        Checker.assertNonNull(activity);
        return new FamilyClientImpl(activity, snsOptions);
    }

    public static SnsClient getSnsClient(Activity activity, SnsOptions snsOptions) {
        Checker.assertNonNull(activity);
        return new SnsClientImpl(activity, snsOptions);
    }

    public static FamilyClient getFamilyClient(Context context, SnsOptions snsOptions) {
        Checker.assertNonNull(context);
        return new FamilyClientImpl(context, snsOptions);
    }

    public static SnsClient getSnsClient(Context context, SnsOptions snsOptions) {
        Checker.assertNonNull(context);
        return new SnsClientImpl(context, snsOptions);
    }
}
