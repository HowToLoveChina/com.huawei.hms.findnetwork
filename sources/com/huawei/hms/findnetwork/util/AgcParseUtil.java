package com.huawei.hms.findnetwork.util;

import android.content.Context;
import p417k4.AbstractC10984c;
import p443l4.AbstractC11229a;

/* loaded from: classes8.dex */
public class AgcParseUtil {
    private static AbstractC11229a getAgcConfig() {
        return AbstractC11229a.m67436d(AbstractC10984c.m66351c().mo66353b());
    }

    public static String getAppId() {
        return getAgcConfig().mo66356b("client/app_id");
    }

    public static String getPackageName() {
        return getAgcConfig().mo66356b("client/package_name");
    }

    public static String getRegion() {
        return getAgcConfig().mo66356b("region");
    }

    private static AbstractC11229a getAgcConfig(Context context) {
        return AbstractC11229a.m67436d(context);
    }

    public static String getAppId(Context context) {
        return context == null ? "" : getAgcConfig(context).mo66356b("client/app_id");
    }

    public static String getPackageName(Context context) {
        return context == null ? "" : getAgcConfig(context).mo66356b("client/package_name");
    }
}
