package com.huawei.hianalytics.util;

import android.content.Context;
import com.huawei.hianalytics.C4818z0;
import com.huawei.hianalytics.core.log.HiLog;

/* loaded from: classes5.dex */
public class HiAnalyticTools {
    public static void enableLog(Context context) {
        enableLog(context, 3);
    }

    public static void enableLog(Context context, int i10) {
        HiLog.setLogAdapter(new C4818z0());
        HiLog.init(i10, "FormalHASDK");
    }
}
