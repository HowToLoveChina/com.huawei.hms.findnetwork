package com.huawei.hms.framework.network.restclient;

import android.content.Context;
import com.huawei.hms.framework.network.util.HttpUtils;

/* loaded from: classes8.dex */
public class Version {
    private static final String BUILD_TIME = "2025-03-31";
    private static final String VERSION = "8.0.1.309";
    private static String userAgent;

    public static String getBuildTime() {
        return "2025-03-31";
    }

    public static String getUserAgent(Context context) {
        if (userAgent == null) {
            userAgent = HttpUtils.getAgent(context);
        }
        return userAgent;
    }

    public static String getVersion() {
        return "8.0.1.309";
    }
}
