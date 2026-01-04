package com.huawei.hianalytics.util;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.fileprotect.HwSfpPolicyManager;
import com.huawei.hianalytics.core.log.HiLog;
import java.io.File;

/* loaded from: classes5.dex */
public class HwSfpPolicyUtils {
    /* renamed from: a */
    public static void m29040a(Context context, String str, String str2, int i10) {
        File databasePath = context.getDatabasePath(str);
        if (databasePath == null || !databasePath.exists()) {
            HiLog.m28808e("HWPU", "file does not exist");
        } else {
            m29041b(context, databasePath.getPath(), str2, i10);
        }
    }

    /* renamed from: b */
    public static void m29041b(Context context, String str, String str2, int i10) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        try {
            HwSfpPolicyManager hwSfpPolicyManager = HwSfpPolicyManager.getDefault();
            if (hwSfpPolicyManager == null) {
                return;
            }
            String label = hwSfpPolicyManager.getLabel(context, str, "SecurityLevel");
            if (TextUtils.isEmpty(label)) {
                int label2 = hwSfpPolicyManager.setLabel(context, str, "SecurityLevel", str2, i10);
                if (label2 != 0) {
                    HiLog.m28809i("HWPU", "setProtectionLabel failed. result:" + label2);
                    return;
                }
                return;
            }
            if (TextUtils.equals(label, str2)) {
                return;
            }
            HiLog.m28809i("HWPU", "setProtectionLabel failed, currentLabel: " + label + ", expectedLabel: " + str2);
        } catch (Throwable th2) {
            HiLog.m28809i("HWPU", "setProtectionLabel failed: " + th2.getMessage());
        }
    }

    public static void setPublicProtectionLevel(Context context, String str, int i10) {
        if (context != null && context.isDeviceProtectedStorage()) {
            m29041b(context, str, "S0", i10);
            HiLog.m28809i("HWPU", "haJsSdk file LABEL_VALUE :S0");
        }
    }
}
