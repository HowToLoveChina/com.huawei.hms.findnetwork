package com.huawei.hms.ads.inner;

import android.content.Context;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.C7286a;

@OuterVisible
/* loaded from: classes8.dex */
public class HwECApi {
    @OuterVisible
    public static boolean openLandingPage(Context context, String str) {
        return C7286a.m44210a().m44216a(context, str);
    }

    @OuterVisible
    public static void setAccessToken(String str) {
        C7286a.m44210a().m44215a(str);
    }

    @OuterVisible
    public static void setECCallback(IECCallback iECCallback) {
        C7286a.m44210a().m44214a(iECCallback);
    }
}
