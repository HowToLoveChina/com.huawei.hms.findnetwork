package com.huawei.hicloud.notification.p106db.bean;

import java.io.InputStream;
import p015ak.C0209d;

/* loaded from: classes6.dex */
public class HicloudH5IncentiveConfig {
    private static final String TAG = "HicloudH5IncentiveConfig";
    private HicloudH5Incentive hicloudH5Incentive = null;

    private String readConfigStr(InputStream inputStream) {
        return C0209d.m1290o2(inputStream);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hicloud.notification.p106db.bean.HicloudH5Incentive getConfigFromFile() {
        /*
            r7 = this;
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "get Config From File"
            java.lang.String r2 = "HicloudH5IncentiveConfig"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r2, r1)
            com.huawei.hicloud.notification.manager.HiCloudH5ConfigService r1 = new com.huawei.hicloud.notification.manager.HiCloudH5ConfigService
            r3 = 0
            r1.<init>(r3)
            java.lang.String r1 = r1.getConfigFilePath()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "filePath: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r2, r4)
            java.io.File r4 = new java.io.File
            r4.<init>(r1)
            boolean r1 = r4.exists()
            if (r1 != 0) goto L4b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "file.exists(): "
            r7.append(r0)
            boolean r0 = r4.exists()
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r2, r7)
            return r3
        L4b:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r3 = r7.readConfigStr(r1)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            r4.<init>()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            java.lang.Class<com.huawei.hicloud.notification.db.bean.HicloudH5Incentive> r5 = com.huawei.hicloud.notification.p106db.bean.HicloudH5Incentive.class
            java.lang.Object r3 = r4.fromJson(r3, r5)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            com.huawei.hicloud.notification.db.bean.HicloudH5Incentive r3 = (com.huawei.hicloud.notification.p106db.bean.HicloudH5Incentive) r3     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            r7.hicloudH5Incentive = r3     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
        L63:
            r1.close()     // Catch: java.io.IOException -> L67
            goto L91
        L67:
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r2, r0)
            goto L91
        L6b:
            r7 = move-exception
            r3 = r1
            goto L94
        L6e:
            r3 = move-exception
            goto L76
        L70:
            r7 = move-exception
            goto L94
        L72:
            r1 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
        L76:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            r4.<init>()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = "cloud config file not e: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L6b
            r4.append(r3)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L6b
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r2, r3)     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L91
            goto L63
        L91:
            com.huawei.hicloud.notification.db.bean.HicloudH5Incentive r7 = r7.hicloudH5Incentive
            return r7
        L94:
            if (r3 == 0) goto L9d
            r3.close()     // Catch: java.io.IOException -> L9a
            goto L9d
        L9a:
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r2, r0)
        L9d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.p106db.bean.HicloudH5IncentiveConfig.getConfigFromFile():com.huawei.hicloud.notification.db.bean.HicloudH5Incentive");
    }
}
