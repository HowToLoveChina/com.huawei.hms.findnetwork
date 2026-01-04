package com.huawei.hms.framework.network.grs.p125h.p126f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.p125h.C5455a;
import com.huawei.hms.framework.network.grs.p125h.p127g.C5461a;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.huawei.hms.framework.network.grs.h.f.a */
/* loaded from: classes8.dex */
public class C5460a {
    /* renamed from: a */
    public static HttpsURLConnection m32333a(String str, Context context, String str2) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpsURLConnection)) {
            Logger.m32145w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
            return null;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        try {
            httpsURLConnection.setSSLSocketFactory(C5461a.m32336a(context));
            httpsURLConnection.setHostnameVerifier(C5461a.m32335a());
        } catch (IllegalArgumentException unused) {
            Logger.m32145w("URLConnectionHelper", "init https ssl socket failed.");
        }
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        String strM32322b = C5455a.m32322b(context, "NetworkKit-grs", str2);
        Logger.m32136d("URLConnectionHelper", "request to grs server with a User-Agent header is: " + strM32322b);
        httpsURLConnection.setRequestProperty("User-Agent", strM32322b);
        return httpsURLConnection;
    }

    /* renamed from: a */
    public static void m32334a(HttpsURLConnection httpsURLConnection, String str) throws Throwable {
        OutputStream outputStream;
        String str2;
        if (str == null) {
            str2 = "sendHttpBody: The Body Data is Null";
        } else {
            if (httpsURLConnection != null) {
                try {
                    outputStream = httpsURLConnection.getOutputStream();
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                }
                try {
                    outputStream.write(str.getBytes(Constants.UTF_8));
                    outputStream.flush();
                    IoUtils.closeSecure(outputStream);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    IoUtils.closeSecure(outputStream);
                    throw th;
                }
            }
            str2 = "sendHttpBody: HttpsURLConnection is Null";
        }
        Logger.m32141i("URLConnectionHelper", str2);
    }
}
