package com.huawei.phoneservice.feedbackcommon.utils;

/* loaded from: classes5.dex */
public final class BitmapUtils {
    /* JADX WARN: Removed duplicated region for block: B:57:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File m53345a(android.graphics.Bitmap r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "BitmapUtils"
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG
            r3 = 50
            r5.compress(r2, r3, r1)
            java.io.File r5 = new java.io.File
            r5.<init>(r6)
            r6 = 0
            r5.createNewFile()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            byte[] r1 = r1.toByteArray()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r6 = 102400(0x19000, float:1.43493E-40)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
        L2f:
            int r1 = r3.read(r6)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r4 = -1
            if (r1 == r4) goto L3f
            r4 = 0
            r2.write(r6, r4, r1)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            goto L2f
        L3b:
            r5 = move-exception
            goto L54
        L3d:
            r6 = move-exception
            goto L56
        L3f:
            r2.flush()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r2.close()     // Catch: java.io.IOException -> L46
            goto L4e
        L46:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r6)
        L4e:
            r3.close()     // Catch: java.io.IOException -> L52
            goto L82
        L52:
            r6 = move-exception
            goto L7b
        L54:
            r6 = r3
            goto L86
        L56:
            r1 = r6
        L57:
            r6 = r2
            goto L63
        L59:
            r5 = move-exception
            goto L86
        L5b:
            r1 = move-exception
            r3 = r6
            goto L57
        L5e:
            r5 = move-exception
            r3 = r6
            goto L84
        L61:
            r1 = move-exception
            r3 = r6
        L63:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L83
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r1)     // Catch: java.lang.Throwable -> L83
            if (r6 == 0) goto L78
            r6.close()     // Catch: java.io.IOException -> L70
            goto L78
        L70:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r6)
        L78:
            if (r3 == 0) goto L82
            goto L4e
        L7b:
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r6)
        L82:
            return r5
        L83:
            r5 = move-exception
        L84:
            r2 = r6
            goto L54
        L86:
            if (r2 == 0) goto L94
            r2.close()     // Catch: java.io.IOException -> L8c
            goto L94
        L8c:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r1)
        L94:
            if (r6 == 0) goto La2
            r6.close()     // Catch: java.io.IOException -> L9a
            goto La2
        L9a:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r6)
        La2:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.BitmapUtils.m53345a(android.graphics.Bitmap, java.lang.String):java.io.File");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x008c A[EXC_TOP_SPLITTER, PHI: r6
  0x008c: PHI (r6v11 android.os.ParcelFileDescriptor) = 
  (r6v10 android.os.ParcelFileDescriptor)
  (r6v15 android.os.ParcelFileDescriptor)
  (r6v15 android.os.ParcelFileDescriptor)
 binds: [B:57:0x00dd, B:23:0x0085, B:20:0x0080] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File getFileFromUri(android.content.Context r6, android.net.Uri r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.BitmapUtils.getFileFromUri(android.content.Context, android.net.Uri, java.lang.String):java.io.File");
    }
}
