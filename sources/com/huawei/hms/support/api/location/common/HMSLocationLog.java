package com.huawei.hms.support.api.location.common;

import as.C1016d;
import bs.C1280g;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class HMSLocationLog {
    private static String compositeMessage(String str, String str2) {
        return "|" + str + "|" + str2;
    }

    private static String compositeTagForHMSLog(String str) {
        return "HwLocation_" + str;
    }

    /* renamed from: d */
    public static void m36657d(String str, String str2, String str3) {
        C1016d.m6181a(compositeTagForHMSLog(str), compositeMessage(str2, str3));
    }

    /* renamed from: e */
    public static void m36658e(String str, String str2, long j10, String str3) {
        HMSLog.m36984e(compositeTagForHMSLog(str), j10, compositeMessage(str2, str3));
        C1280g.m7590b(str, compositeMessage(str2, str3), null);
    }

    /* renamed from: i */
    public static void m36662i(String str, String str2, String str3) {
        C1016d.m6186f(compositeTagForHMSLog(str), compositeMessage(str2, str3));
    }

    /* renamed from: w */
    public static void m36663w(String str, String str2, String str3) {
        C1016d.m6190j(compositeTagForHMSLog(str), compositeMessage(str2, str3));
    }

    /* renamed from: e */
    public static void m36659e(String str, String str2, long j10, String str3, Throwable th2) {
        HMSLog.m36985e(compositeTagForHMSLog(str), j10, compositeMessage(str2, str3), th2);
        C1280g.m7590b(str, compositeMessage(str2, str3), null);
    }

    /* renamed from: e */
    public static void m36660e(String str, String str2, String str3) {
        C1016d.m6183c(compositeTagForHMSLog(str), compositeMessage(str2, str3));
    }

    /* renamed from: e */
    public static void m36661e(String str, String str2, String str3, Throwable th2) {
        C1016d.m6184d(compositeTagForHMSLog(str), compositeMessage(str2, str3), th2);
    }
}
