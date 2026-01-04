package com.tencent.p204mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.opensdk.utils.d */
/* loaded from: classes9.dex */
public final class C8931d {

    /* renamed from: D */
    public static Context f45431D;

    /* renamed from: E */
    private static final int f45432E;

    /* renamed from: F */
    private static final int f45433F;

    /* renamed from: G */
    private static final int f45434G;

    /* renamed from: H */
    public static ThreadPoolExecutor f45435H;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f45432E = iAvailableProcessors;
        int i10 = iAvailableProcessors + 1;
        f45433F = i10;
        int i11 = (iAvailableProcessors * 2) + 1;
        f45434G = i11;
        f45435H = new ThreadPoolExecutor(i10, i11, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    /* renamed from: a */
    private static int m56647a(ContentResolver contentResolver, Uri uri) throws IOException {
        Log.m56640i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.m56642w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return 0;
                }
                int iAvailable = inputStreamOpenInputStream.available();
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused2) {
                }
                return iAvailable;
            } catch (Exception e10) {
                Log.m56642w("MicroMsg.SDK.Util", "getFileSize fail, " + e10.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th2;
        }
    }

    /* renamed from: b */
    public static boolean m56649b(String str) {
        return str == null || str.length() <= 0;
    }

    /* renamed from: c */
    public static int m56650c(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Integer.parseInt(str);
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f45431D != null && str.startsWith("content")) {
            try {
                return m56647a(f45431D.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static boolean m56648a(int i10) {
        return i10 == 36 || i10 == 46;
    }
}
