package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;

/* renamed from: com.huawei.hianalytics.x0 */
/* loaded from: classes5.dex */
public class C4814x0 {

    /* renamed from: a */
    public static final Object f21988a = new Object();

    /* renamed from: a */
    public static boolean f21989a = false;

    /* renamed from: b */
    public static boolean f21990b = false;

    /* renamed from: a */
    public static boolean m29056a() {
        if (!f21989a) {
            synchronized (f21988a) {
                try {
                    f21990b = true;
                } catch (ClassNotFoundException unused) {
                    f21990b = false;
                }
                f21989a = true;
            }
        }
        boolean z10 = f21990b;
        HiLog.m28809i("HmsBaseExist", "hms base exist: " + z10);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m29057a(boolean r4) {
        /*
            if (r4 != 0) goto L7
            boolean r4 = m29056a()
            return r4
        L7:
            android.content.Context r4 = com.huawei.hianalytics.core.common.EnvUtils.getAppContext()
            r0 = 0
            java.lang.String r1 = "HmsBaseExist"
            if (r4 != 0) goto L11
            goto L2f
        L11:
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Throwable -> L2a
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r4 = r2.getApplicationInfo(r4, r3)     // Catch: java.lang.Throwable -> L2a
            android.os.Bundle r4 = r4.metaData     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L2f
            java.lang.String r2 = "com.huawei.hms.client.appid"
            boolean r4 = r4.containsKey(r2)     // Catch: java.lang.Throwable -> L2a
            goto L30
        L2a:
            java.lang.String r4 = "applicationInfo not found"
            com.huawei.hianalytics.core.log.HiLog.m28812w(r1, r4)
        L2f:
            r4 = r0
        L30:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "contains appId: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.huawei.hianalytics.core.log.HiLog.m28809i(r1, r2)
            boolean r1 = m29056a()
            if (r1 == 0) goto L4d
            if (r4 == 0) goto L4d
            r0 = 1
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.C4814x0.m29057a(boolean):boolean");
    }
}
