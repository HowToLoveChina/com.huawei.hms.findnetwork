package com.huawei.feedback.mail.util;

import com.huawei.feedback.log.BaseLogger;
import java.io.File;

/* loaded from: classes5.dex */
public class Accessory {
    private static final String LOG_TAG = "Accessory";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0155  */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File accessoryZipFile(java.io.File r5, boolean r6, android.content.Context r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.mail.util.Accessory.accessoryZipFile(java.io.File, boolean, android.content.Context):java.io.File");
    }

    private static boolean isMkdirSuccess(File file) {
        if (file == null) {
            BaseLogger.m28731e(LOG_TAG, "file is null");
            return false;
        }
        if (file.exists()) {
            return true;
        }
        BaseLogger.m28729d(LOG_TAG, "file not exist, create it");
        if (file.mkdirs()) {
            return true;
        }
        BaseLogger.m28729d(LOG_TAG, "create file fail");
        return false;
    }
}
