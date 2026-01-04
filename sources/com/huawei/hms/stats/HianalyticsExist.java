package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class HianalyticsExist {

    /* renamed from: a */
    private static final Object f29736a = new Object();

    /* renamed from: b */
    private static boolean f29737b = false;

    /* renamed from: c */
    private static boolean f29738c = false;

    public static boolean isHianalyticsExist() {
        synchronized (f29736a) {
            try {
                if (!f29737b) {
                    f29737b = true;
                    HMSLog.m36988i("HianalyticsExist", "hianalytics exist: " + f29738c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f29738c;
    }
}
