package com.huawei.fastengine.fastview;

import com.huawei.openalliance.p169ad.constant.Constants;

/* loaded from: classes5.dex */
public class Config {
    public static final String ACTION_AIDL_FASTAPP = "com.huawei.fastapp.engine.action.AIDL_SERVICE";
    public static final String FASTAPP_SUPPORT_RPKTYPE_DATA = "com.huawei.fastapp.supportRpkType";
    private static String packageName = getDefaultPackageName();

    private static String getDefaultPackageName() {
        return Constants.FAST_APP_PKG;
    }

    public static String getInstallPackageName() {
        return "package:" + packageName;
    }

    public static String getPackageName() {
        return packageName;
    }

    public static void setPackageName(String str) {
        packageName = str;
    }
}
