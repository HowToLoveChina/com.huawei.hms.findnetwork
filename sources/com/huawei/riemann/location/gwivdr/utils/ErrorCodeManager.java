package com.huawei.riemann.location.gwivdr.utils;

import as.C1016d;

/* loaded from: classes5.dex */
public class ErrorCodeManager {
    private static final Object LOCK = new Object();
    private static final String TAG = "ErrorCodeManager";
    private static volatile int errorCode;

    public static int getErrorCode() {
        return errorCode;
    }

    public static void setErrorCode(int i10) {
        synchronized (LOCK) {
            try {
                if (errorCode == i10) {
                    return;
                }
                C1016d.m6181a(TAG, "errorCode before: " + errorCode + ", after: " + i10);
                errorCode = i10;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String toString() {
        return "ErrorCodeManager{}";
    }
}
