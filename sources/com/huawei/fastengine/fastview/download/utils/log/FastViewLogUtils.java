package com.huawei.fastengine.fastview.download.utils.log;

import android.util.Log;

/* loaded from: classes5.dex */
public class FastViewLogUtils {
    private static final String TAG = "FastSDK";
    private static int nativeLogLevel = 4;

    /* renamed from: d */
    public static void m28721d(String str) {
        m28722d("", str);
    }

    /* renamed from: e */
    public static void m28723e(String str) {
        m28724e("", str);
    }

    /* renamed from: i */
    public static void m28725i(String str) {
        m28726i("", str);
    }

    public static void setNativeLogLevel(int i10) {
        nativeLogLevel = i10;
    }

    /* renamed from: w */
    public static void m28727w(String str) {
        m28728w("", str);
    }

    /* renamed from: d */
    public static void m28722d(String str, String str2) {
        if (nativeLogLevel <= 3) {
            Log.d(TAG, "[" + str + "]" + str2);
        }
    }

    /* renamed from: e */
    public static void m28724e(String str, String str2) {
        if (nativeLogLevel <= 6) {
            Log.e(TAG, "[" + str + "]" + str2);
        }
    }

    /* renamed from: i */
    public static void m28726i(String str, String str2) {
        if (nativeLogLevel <= 4) {
            Log.i(TAG, "[" + str + "]" + str2);
        }
    }

    /* renamed from: w */
    public static void m28728w(String str, String str2) {
        if (nativeLogLevel <= 5) {
            Log.w(TAG, "[" + str + "]" + str2);
        }
    }
}
