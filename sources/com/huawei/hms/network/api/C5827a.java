package com.huawei.hms.network.api;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.PackageManagerCompat;
import com.huawei.hms.framework.common.ReflectionUtils;
import com.huawei.hms.framework.common.StringUtils;

/* renamed from: com.huawei.hms.network.api.a */
/* loaded from: classes8.dex */
public class C5827a {

    /* renamed from: a */
    private static final String f26167a = "DynamicLoadPermit";

    /* renamed from: b */
    private static final String f26168b = "networkkit_";

    /* renamed from: c */
    private static final String f26169c = "dynamic_load";

    /* renamed from: d */
    private static final String f26170d = "networkkit_dynamic_load";

    /* renamed from: e */
    private static final String f26171e = "share_pre_config";

    /* renamed from: f */
    private static final String f26172f = "disable";

    /* renamed from: a */
    public static boolean m33630a(Context context) {
        try {
            boolean zCheckCompatible = ReflectionUtils.checkCompatible("com.huawei.hms.network.AdvanceNetworkKitProvider");
            boolean zM33631b = m33631b(context);
            if (zCheckCompatible && !zM33631b) {
                Logger.m32141i(f26167a, "is dynamic load: false, advance: true");
                return false;
            }
            boolean zM33632c = m33632c(context);
            Logger.m32141i(f26167a, "is dynamic load: " + zM33632c + ", advance: " + zCheckCompatible);
            return zM33632c;
        } catch (Exception e10) {
            Logger.m32138e(f26167a, "get meta-data or sp error " + StringUtils.anonymizeMessage(e10.getMessage()));
            return true;
        }
    }

    /* renamed from: b */
    private static boolean m33631b(Context context) throws PackageManager.NameNotFoundException {
        Logger.m32136d(f26167a, "meta-data networkkit_dynamic_load:" + PackageManagerCompat.getMetaDataFromApp(context, f26170d, ""));
        return !f26172f.equalsIgnoreCase(r2);
    }

    /* renamed from: c */
    private static boolean m33632c(Context context) {
        Logger.m32136d(f26167a, "dynamic load sp:" + new PLSharedPreferences(context, "share_pre_config").getString("dynamic_load"));
        return !f26172f.equalsIgnoreCase(r2);
    }
}
