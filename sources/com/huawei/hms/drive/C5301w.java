package com.huawei.hms.drive;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* renamed from: com.huawei.hms.drive.w */
/* loaded from: classes8.dex */
public class C5301w {

    /* renamed from: a */
    private static final String f24582a = "SecureX509SingleInstance";

    /* renamed from: b */
    private static volatile C5302x f24583b;

    private C5301w() {
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static C5302x m31829a(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        InputStream inputStreamOpen;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        C5304z.m31839a(context);
        if (f24583b == null) {
            synchronized (C5301w.class) {
                if (f24583b == null) {
                    try {
                        inputStreamOpen = C5303y.m31835a(context);
                    } catch (RuntimeException unused) {
                        C5170ac.m30796c(f24582a, "get files bks error");
                        inputStreamOpen = null;
                    }
                    if (inputStreamOpen == null) {
                        C5170ac.m30795b(f24582a, "get assets bks");
                        inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        C5170ac.m30795b(f24582a, "get files bks");
                    }
                    f24583b = new C5302x(inputStreamOpen, "");
                }
            }
        }
        C5170ac.m30794a(f24582a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f24583b;
    }
}
