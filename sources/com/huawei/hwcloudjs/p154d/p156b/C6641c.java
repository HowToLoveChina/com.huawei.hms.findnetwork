package com.huawei.hwcloudjs.p154d.p156b;

import android.content.Context;
import com.huawei.hwcloudjs.p164f.C6659d;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.HttpsURLConnection;
import p373iu.C10617e;
import p406ju.C10929a;

/* renamed from: com.huawei.hwcloudjs.d.b.c */
/* loaded from: classes8.dex */
public class C6641c {

    /* renamed from: a */
    private static final String f30848a = "HttpsSetting";

    /* renamed from: a */
    public static void m37824a(HttpsURLConnection httpsURLConnection, Context context) {
        StringBuilder sb2;
        String str;
        if (httpsURLConnection == null || context == null) {
            C6659d.m37881b(f30848a, "init https ssl socket null.", true);
            return;
        }
        try {
            httpsURLConnection.setSSLSocketFactory(C10617e.m65071b(context.getApplicationContext()));
            httpsURLConnection.setHostnameVerifier(new C10929a());
        } catch (IOException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "init https ssl socket failed.IOException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30848a, sb2.toString(), true);
        } catch (IllegalAccessException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "init https ssl socket failed.IllegalAccessException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30848a, sb2.toString(), true);
        } catch (IllegalArgumentException e12) {
            e = e12;
            sb2 = new StringBuilder();
            str = "init https ssl socket failed.IllegalArgumentException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30848a, sb2.toString(), true);
        } catch (KeyManagementException e13) {
            e = e13;
            sb2 = new StringBuilder();
            str = "init https ssl socket failed.KeyManagementException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30848a, sb2.toString(), true);
        } catch (KeyStoreException e14) {
            e = e14;
            sb2 = new StringBuilder();
            str = "init https ssl socket failed.KeyStoreException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30848a, sb2.toString(), true);
        } catch (NoSuchAlgorithmException e15) {
            e = e15;
            sb2 = new StringBuilder();
            str = "init https ssl socket failed.NoSuchAlgorithmException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30848a, sb2.toString(), true);
        } catch (CertificateException e16) {
            e = e16;
            sb2 = new StringBuilder();
            str = "init https ssl socket failed.CertificateException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30848a, sb2.toString(), true);
        }
    }
}
