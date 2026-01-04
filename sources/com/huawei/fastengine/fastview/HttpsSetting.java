package com.huawei.fastengine.fastview;

import android.content.Context;
import android.util.Log;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.C11912b0;
import p373iu.C10616d;
import p373iu.C10617e;
import p751wt.C13638a;

/* loaded from: classes5.dex */
public class HttpsSetting {
    private static final String TAG = "HttpsSetting";

    private static C13638a get(Context context) throws IllegalAccessException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        return C13638a.m82005b(context);
    }

    public static void initHttpsURLConnection(HttpsURLConnection httpsURLConnection, Context context) {
        String str;
        try {
            httpsURLConnection.setSSLSocketFactory(get(context));
            httpsURLConnection.setHostnameVerifier(C10616d.f51032h);
        } catch (IOException unused) {
            str = "IOException!";
            FastViewLogUtils.m28724e(TAG, str);
        } catch (IllegalAccessException unused2) {
            str = "IllegalAccessException!";
            FastViewLogUtils.m28724e(TAG, str);
        } catch (KeyManagementException unused3) {
            str = "KeyManagementException!";
            FastViewLogUtils.m28724e(TAG, str);
        } catch (KeyStoreException unused4) {
            str = "KeyStoreException!";
            FastViewLogUtils.m28724e(TAG, str);
        } catch (NoSuchAlgorithmException unused5) {
            str = "NoSuchAlgorithmException!";
            FastViewLogUtils.m28724e(TAG, str);
        } catch (UnrecoverableKeyException unused6) {
            str = "UnrecoverableKeyException!";
            FastViewLogUtils.m28724e(TAG, str);
        } catch (CertificateException unused7) {
            str = "CertificateException!";
            FastViewLogUtils.m28724e(TAG, str);
        }
    }

    public static void initSSLSocket(C11912b0.c cVar, Context context) {
        if (context == null) {
            return;
        }
        try {
            cVar.m71521r(C10617e.m65071b(context.getApplicationContext()), new SecureX509TrustManager(context.getApplicationContext()));
            cVar.m71515l(C10616d.f51032h);
        } catch (Exception e10) {
            Log.e(TAG, "init ok http ssl socket failed." + e10.getMessage());
        }
    }
}
