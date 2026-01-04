package com.huawei.hms.support.api.safetydetect.p860default;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.q */
/* loaded from: classes8.dex */
public class C6376q {

    /* renamed from: a */
    private static final String f29894a = "q";

    /* renamed from: b */
    private static volatile a f29895b;

    /* renamed from: com.huawei.hms.support.api.safetydetect.default.q$a */
    public static class a {

        /* renamed from: a */
        private String f29896a;

        /* renamed from: b */
        private String f29897b;

        /* renamed from: c */
        private long f29898c;

        /* renamed from: d */
        private String f29899d;

        private a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f29896a = jSONObject.optString("token");
                this.f29898c = jSONObject.optLong("extime");
                this.f29899d = jSONObject.optString("iv");
            } catch (JSONException e10) {
                Log.e(C6376q.f29894a, "Build risk token cache error. " + e10.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static String m36755b(Context context) throws NoSuchPaddingException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, InvalidKeyException, KeyStoreException, CertificateException, InvalidAlgorithmParameterException {
            if (C6376q.f29895b != null) {
                if (System.currentTimeMillis() > C6376q.f29895b.f29898c) {
                    return "";
                }
                Log.i(C6376q.f29894a, "Get token from cache success.");
                return C6376q.f29895b.f29897b;
            }
            String strM36769a = C6385z.m36768a(context).m36769a("riskToken");
            if (TextUtils.isEmpty(strM36769a)) {
                return "";
            }
            a aVar = new a(strM36769a);
            if (System.currentTimeMillis() > aVar.f29898c) {
                return "";
            }
            byte[] bArrM36742a = C6372m.m36742a("riskTokenSdkCache", aVar.f29899d, C6360d.m36730a(aVar.f29896a));
            if (bArrM36742a.length == 0) {
                return "";
            }
            String str = new String(bArrM36742a, StandardCharsets.UTF_8);
            Log.i(C6376q.f29894a, "Get token from sp cache success.");
            aVar.m36754a(str);
            a unused = C6376q.f29895b = aVar;
            return str;
        }

        private a(String str, long j10) {
            this.f29897b = str;
            this.f29898c = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static void m36756b(Context context, String str) throws JSONException, NoSuchPaddingException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, InvalidKeyException, KeyStoreException, CertificateException, InvalidAlgorithmParameterException {
            long jCurrentTimeMillis = System.currentTimeMillis() + 3300000;
            a unused = C6376q.f29895b = new a(str, jCurrentTimeMillis);
            String strEncodeToString = Base64.encodeToString(C6374o.m36745a(12), 2);
            byte[] bArrM36743b = C6372m.m36743b("riskTokenSdkCache", strEncodeToString, str.getBytes(StandardCharsets.UTF_8));
            if (bArrM36743b.length == 0) {
                Log.e(C6376q.f29894a, "Save risk token error. Android key store aes encrypt error.");
                return;
            }
            String strEncodeToString2 = Base64.encodeToString(bArrM36743b, 2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", strEncodeToString2);
                jSONObject.put("extime", jCurrentTimeMillis);
                jSONObject.put("iv", strEncodeToString);
                C6385z.m36768a(context).m36770a("riskToken", jSONObject.toString());
            } catch (JSONException e10) {
                Log.e(C6376q.f29894a, "Save risk token error. " + e10.getMessage());
            }
        }

        /* renamed from: a */
        private void m36754a(String str) {
            this.f29897b = str;
        }
    }

    /* renamed from: a */
    public static String m36749a(Context context) {
        return a.m36755b(context);
    }

    /* renamed from: a */
    public static void m36750a(Context context, String str) throws JSONException, NoSuchPaddingException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, InvalidKeyException, KeyStoreException, CertificateException, InvalidAlgorithmParameterException {
        a.m36756b(context, str);
    }
}
