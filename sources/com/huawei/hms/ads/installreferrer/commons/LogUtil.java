package com.huawei.hms.ads.installreferrer.commons;

import android.util.Log;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes8.dex */
public final class LogUtil {
    @Keep
    public static void logError(String str, String str2) {
        if (Log.isLoggable(str, 6)) {
            Log.e(str, str2);
        }
    }

    @Keep
    public static void logInfo(String str, String str2) {
        if (Log.isLoggable(str, 4)) {
            Log.i(str, str2);
        }
    }

    @Keep
    public static void logVerbose(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    @Keep
    public static void logWarn(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }
}
