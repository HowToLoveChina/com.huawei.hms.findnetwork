package com.huawei.feedback.mail.zip.p099sp;

import android.content.Context;
import com.huawei.feedback.log.BaseLogger;
import p015ak.C0212e0;

/* loaded from: classes5.dex */
public final class SharedPreferencesStorage implements SharedPreferencesKey {
    public static final String BACKUPOPTION_SPFILE = "cloudbacksettings";
    private static final String EMAIL_ADDRESS = "email_address";
    private static SharedPreferencesStorage instance;

    private SharedPreferencesStorage() {
    }

    public static synchronized SharedPreferencesStorage getInstance() {
        try {
            if (instance == null) {
                instance = new SharedPreferencesStorage();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return instance;
    }

    public boolean getUnlimitSizeUpload(Context context) {
        if (context != null) {
            return C0212e0.m1354d(context, "feedback", SharedPreferencesKey.UNLIMIT_UPLOADSIZE_FLAG, false);
        }
        BaseLogger.m28731e("getUnlimitSizeUpload", "getUnlimitSizeUpload context null");
        return false;
    }

    public void setUnlimitSizeUpload(Context context, boolean z10) {
        C0212e0.m1365o(context, "feedback", SharedPreferencesKey.UNLIMIT_UPLOADSIZE_FLAG, z10);
    }
}
