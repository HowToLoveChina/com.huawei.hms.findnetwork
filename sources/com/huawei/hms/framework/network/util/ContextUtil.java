package com.huawei.hms.framework.network.util;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.Logger;

/* loaded from: classes8.dex */
public class ContextUtil {
    private static final String TAG = "ContextUtil";

    @SuppressLint({"StaticFieldLeak"})
    private static Context sContext;

    public static Context getContext() {
        if (sContext == null) {
            Logger.m32138e(TAG, "if used restclient-anno sdk, you must call RestClientGlobalInstance.getInstance().init first;or call HttpClientGlobalInstance.getInstance().init() first");
        }
        return sContext;
    }

    public static void setContext(Context context) {
        CheckParamUtils.checkNotNull(context, "context == null");
        sContext = context.getApplicationContext();
    }
}
