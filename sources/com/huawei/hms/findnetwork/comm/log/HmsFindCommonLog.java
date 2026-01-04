package com.huawei.hms.findnetwork.comm.log;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes8.dex */
public class HmsFindCommonLog {
    private static final String COMMON_TAG = "HMSFindNetworkSDK_61502320_";

    private HmsFindCommonLog() {
    }

    /* renamed from: d */
    public static void m31923d(String str, String str2) {
    }

    /* renamed from: e */
    public static void m31924e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(COMMON_TAG + str, str2);
    }

    /* renamed from: i */
    public static void m31925i(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(COMMON_TAG + str, str2);
    }

    /* renamed from: w */
    public static void m31926w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(COMMON_TAG + str, str2);
    }
}
