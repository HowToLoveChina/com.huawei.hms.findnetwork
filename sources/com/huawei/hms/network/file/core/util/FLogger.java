package com.huawei.hms.network.file.core.util;

import com.huawei.hms.framework.common.Logger;

/* loaded from: classes8.dex */
public class FLogger {
    private static final boolean DEBUG = false;
    private static final String FLOG_TAG = "file_request";

    /* renamed from: d */
    public static void m36350d(String str, String str2, Object... objArr) {
        Logger.m32137d("file_request-" + str, str2, objArr);
    }

    /* renamed from: e */
    public static void m36351e(String str, String str2) {
        Logger.m32138e("file_request-" + str, str2);
    }

    /* renamed from: i */
    public static void m36353i(String str, String str2, Object... objArr) {
        Logger.m32142i("file_request-" + str, str2, objArr);
    }

    public static void logException(Exception exc) {
        Logger.m32143v(FLOG_TAG, "logException :" + exc.getMessage());
    }

    /* renamed from: v */
    public static void m36354v(String str, String str2) {
        Logger.m32143v(FLOG_TAG + str, str2);
    }

    /* renamed from: w */
    public static void m36355w(String str, String str2, Object... objArr) {
        Logger.m32147w("file_request-" + str, str2, objArr);
    }

    /* renamed from: e */
    public static void m36352e(String str, String str2, Throwable th2) {
        Logger.m32139e("file_request-" + str, str2, th2);
    }
}
