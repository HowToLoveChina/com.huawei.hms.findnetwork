package com.huawei.hms.network.embedded;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.network.embedded.C5863b6;
import gu.C10048b;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import p373iu.C10613a;
import p406ju.C10929a;

/* renamed from: com.huawei.hms.network.embedded.c6 */
/* loaded from: classes8.dex */
public class C5877c6 {

    /* renamed from: a */
    public static final String f26564a = "c6";

    /* renamed from: b */
    public static SSLSocketFactory f26565b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* renamed from: a */
    public static C5890d5 m34037a(Context context, String str, String str2) throws Throwable {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
        try {
            f26565b = C10613a.m65057b(context, C10048b.m62471c());
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
            Logger.m32146w(f26564a, "catch exception when create sslSocketFactory", e10);
        }
        C5890d5 c5890d5 = new C5890d5();
        HttpsURLConnection httpsURLConnection3 = null;
        HttpsURLConnection httpsURLConnection4 = null;
        try {
            try {
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                ?? r12 = C5863b6.a.f26411a;
                try {
                    httpsURLConnection.addRequestProperty(C5863b6.a.f26411a, context.getPackageName());
                    httpsURLConnection.addRequestProperty(C5863b6.a.f26412b, str2);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setSSLSocketFactory(f26565b);
                    httpsURLConnection.setHostnameVerifier(new C10929a());
                    c5890d5.m34103a(httpsURLConnection.getResponseCode());
                    httpsURLConnection2 = r12;
                } catch (IOException e11) {
                    e = e11;
                    httpsURLConnection4 = httpsURLConnection;
                    Logger.m32143v(f26564a, "connection query fail");
                    c5890d5.m34103a(ExceptionCode.getErrorCodeFromException(e));
                    httpsURLConnection3 = httpsURLConnection4;
                    if (httpsURLConnection4 != null) {
                        httpsURLConnection = httpsURLConnection4;
                        httpsURLConnection2 = httpsURLConnection4;
                        httpsURLConnection.disconnect();
                        httpsURLConnection3 = httpsURLConnection2;
                    }
                    return c5890d5;
                } catch (Throwable th2) {
                    th = th2;
                    httpsURLConnection3 = httpsURLConnection;
                    if (httpsURLConnection3 != null) {
                        httpsURLConnection3.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e12) {
                e = e12;
            }
            httpsURLConnection.disconnect();
            httpsURLConnection3 = httpsURLConnection2;
            return c5890d5;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    public static String m34038a(Context context) {
        String str = f26564a;
        Logger.m32143v(str, "entry to getDomainName function");
        Map<String, String> mapSynGetGrsUrls = new GrsClient(context, new GrsBaseInfo()).synGetGrsUrls(C5863b6.n.f26486j);
        if (mapSynGetGrsUrls == null || mapSynGetGrsUrls.isEmpty()) {
            return "";
        }
        String str2 = mapSynGetGrsUrls.get(new ArrayList(mapSynGetGrsUrls.keySet()).get(new SecureRandom().nextInt(mapSynGetGrsUrls.size())));
        Logger.m32143v(str, "domain in random: " + str2);
        return str2;
    }
}
