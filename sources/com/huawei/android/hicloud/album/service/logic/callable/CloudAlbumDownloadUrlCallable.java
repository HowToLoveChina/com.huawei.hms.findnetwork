package com.huawei.android.hicloud.album.service.logic.callable;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import java.util.concurrent.Callable;
import mk.C11476b;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1122c;
import p546p6.C12091d;
import p733w9.C13576a;

/* loaded from: classes2.dex */
public class CloudAlbumDownloadUrlCallable implements Callable<Object> {
    private static final String DEFAULT_HEAD_EXT = ".jpg";
    private static final String DOWNLOAD_URL_CACHE_FOLDER = "/downloadUrlCacheFolder/";
    private static final String TAG = "CloudAlbumDownloadUrlCallable";
    private Context context;
    private String downloadPath;
    private ImageView imageView;
    private String traceId = C1122c.m6755Z0("04019");
    private String url;

    public CloudAlbumDownloadUrlCallable(Context context, String str, ImageView imageView) {
        this.context = context;
        this.url = str;
        this.imageView = imageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fe A[PHI: r1 r2 r3 r5 r6
  0x00fe: PHI (r1v11 ??) = (r1v7 ??), (r1v9 ??), (r1v12 ??), (r1v0 ??) binds: [B:70:0x018e, B:87:0x01ee, B:37:0x00e8, B:34:0x00e3] A[DONT_GENERATE, DONT_INLINE]
  0x00fe: PHI (r2v16 ??) = (r2v11 ??), (r2v14 ??), (r2v24 ??), (r2v24 ??) binds: [B:70:0x018e, B:87:0x01ee, B:37:0x00e8, B:34:0x00e3] A[DONT_GENERATE, DONT_INLINE]
  0x00fe: PHI (r3v10 java.io.FileOutputStream) = 
  (r3v7 java.io.FileOutputStream)
  (r3v8 java.io.FileOutputStream)
  (r3v26 java.io.FileOutputStream)
  (r3v26 java.io.FileOutputStream)
 binds: [B:70:0x018e, B:87:0x01ee, B:37:0x00e8, B:34:0x00e3] A[DONT_GENERATE, DONT_INLINE]
  0x00fe: PHI (r5v10 ??) = (r5v7 ??), (r5v8 ??), (r5v18 ??), (r5v18 ??) binds: [B:70:0x018e, B:87:0x01ee, B:37:0x00e8, B:34:0x00e3] A[DONT_GENERATE, DONT_INLINE]
  0x00fe: PHI (r6v8 java.io.InputStream) = (r6v5 java.io.InputStream), (r6v6 java.io.InputStream), (r6v20 java.io.InputStream), (r6v20 java.io.InputStream) binds: [B:70:0x018e, B:87:0x01ee, B:37:0x00e8, B:34:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [v6.c] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [v6.c] */
    /* JADX WARN: Type inference failed for: r2v9, types: [v6.c] */
    /* JADX WARN: Type inference failed for: r3v25, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v29, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r3v31, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10, types: [okhttp3.g0] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v18, types: [okhttp3.g0] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [okhttp3.g0] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void downloadUrl() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 571
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadUrlCallable.downloadUrl():void");
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        String str = C11476b.m68626h(this.url) + ".jpg";
        this.downloadPath = this.context.getCacheDir().getPath() + DOWNLOAD_URL_CACHE_FOLDER + str;
        C1120a.m6675d(TAG, "fileName: " + str + ", downloadPath: " + this.downloadPath);
        C13576a c13576aM81565a = C13576a.m81565a();
        if (!c13576aM81565a.m81566b(this.downloadPath)) {
            C1120a.m6676e(TAG, "download url repeat.");
            return null;
        }
        try {
            if (C1122c.m6837u1(this.downloadPath)) {
                C1120a.m6675d(TAG, "already exist downloadPath: " + this.downloadPath);
                if (this.imageView != null) {
                    ((Activity) this.imageView.getContext()).runOnUiThread(new C12091d.q0(C0209d.m1311u(this.downloadPath), this.imageView));
                }
            } else {
                downloadUrl();
            }
            c13576aM81565a.m81568d(this.downloadPath);
            return null;
        } catch (Throwable th2) {
            c13576aM81565a.m81568d(this.downloadPath);
            throw th2;
        }
    }
}
