package com.huawei.hms.findnetwork.util;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes8.dex */
public class HmsFindSDKLog {
    private static final String COMMON_TAG = "HMSFindNetworkSDK_61502320_";

    /* renamed from: d */
    public static void m32125d(String str, String str2) {
    }

    /* renamed from: e */
    public static void m32126e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(COMMON_TAG + str, str2);
    }

    /* renamed from: i */
    public static void m32127i(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(COMMON_TAG + str, str2);
    }

    /* renamed from: w */
    public static void m32128w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(COMMON_TAG + str, str2);
    }
}
