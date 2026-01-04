package com.huawei.hms.videokit.player;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.restclient.RestClient;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import gu.C10048b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p373iu.C10618f;
import p373iu.C10619g;
import p406ju.C10929a;

/* renamed from: com.huawei.hms.videokit.player.o0 */
/* loaded from: classes8.dex */
public class C6591o0 {

    /* renamed from: a */
    private int f30651a;

    /* renamed from: b */
    private String f30652b = null;

    /* renamed from: c */
    private String f30653c = "";

    /* renamed from: d */
    private String f30654d = "";

    /* renamed from: e */
    private int f30655e = PlayerConstants.ErrorCode.GET_URL_FAILED;

    /* renamed from: f */
    private String f30656f = "";

    /* renamed from: g */
    private int f30657g = 0;

    /* renamed from: h */
    private long f30658h = 0;

    /* renamed from: i */
    private long f30659i = 0;

    /* renamed from: c */
    private C6560h m37577c(String str) {
        String str2;
        C6550c1.m37256a("NetworkUtil", "server responseData: " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(C5963j.f27041j);
            C6550c1.m37264c("NetworkUtil", "retCode:" + strOptString);
            if (!"0".equals(strOptString) || jSONObject.optString("playURLs") == null) {
                this.f30656f = jSONObject.optString("retMsg");
                try {
                    this.f30655e = Integer.parseInt(strOptString);
                } catch (NumberFormatException e10) {
                    C6550c1.m37258a("NetworkUtil", "NumberFormatException", e10);
                    this.f30655e = PlayerConstants.ErrorCode.GET_URL_FAILED;
                }
                this.f30657g = this.f30655e;
            } else {
                C6560h c6560h = new C6560h();
                String[] strArrM37576b = m37576b(jSONObject.getString("playURLs"));
                String strOptString2 = jSONObject.optString("picture");
                this.f30655e = PlayerConstants.ErrorCode.GET_URL_FAILED;
                if (strArrM37576b.length >= 1) {
                    c6560h.m37375a(strArrM37576b);
                    c6560h.m37374a(strOptString2);
                    return c6560h;
                }
                C6550c1.m37256a("NetworkUtil", "playURLs length" + strArrM37576b.length);
            }
        } catch (JSONException e11) {
            e = e11;
            str2 = "JSONException :";
            C6550c1.m37258a("NetworkUtil", str2, e);
            return new C6560h();
        } catch (Exception e12) {
            e = e12;
            str2 = "Exception :";
            C6550c1.m37258a("NetworkUtil", str2, e);
            return new C6560h();
        }
        return new C6560h();
    }

    /* renamed from: h */
    private HashMap<String, String> m37578h() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED);
        map.put("User-Agent", "VideoKitPlayer/10016300");
        map.put("x-traceId", this.f30652b);
        C6550c1.m37256a("NetworkUtil", "get request header");
        return map;
    }

    /* renamed from: a */
    public int m37579a() {
        return this.f30651a;
    }

    /* renamed from: b */
    public int m37582b() {
        return this.f30655e;
    }

    /* renamed from: d */
    public String m37584d() {
        return this.f30654d;
    }

    /* renamed from: e */
    public long m37585e() {
        return this.f30658h;
    }

    /* renamed from: f */
    public String m37586f() {
        return this.f30653c;
    }

    /* renamed from: g */
    public String m37587g() throws JSONException {
        JSONException e10;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("trace_id", this.f30652b);
            jSONObject = new JSONObject();
        } catch (JSONException e11) {
            e10 = e11;
            jSONObject = jSONObject3;
        }
        try {
            jSONObject.put("metrics_data", jSONObject2);
        } catch (JSONException e12) {
            e10 = e12;
            C6550c1.m37258a("NetworkUtil", "getRecordString JSONException ", e10);
            return jSONObject.toString();
        }
        return jSONObject.toString();
    }

    /* renamed from: i */
    public long m37588i() {
        return this.f30659i;
    }

    /* renamed from: j */
    public int m37589j() {
        return this.f30657g;
    }

    /* renamed from: a */
    private HttpClient m37574a(Context context) {
        String str;
        try {
            SecureX509TrustManager secureX509TrustManagerM65081a = C10619g.m65081a(context);
            C10618f c10618f = new C10618f(secureX509TrustManagerM65081a, C10048b.m62471c());
            C6550c1.m37256a("NetworkUtil", "build httpclient and set properties");
            return new HttpClient.Builder().connectTimeout(6000).readTimeout(6000).hostnameVerifier((HostnameVerifier) new C10929a()).sslSocketFactory((SSLSocketFactory) c10618f, (X509TrustManager) secureX509TrustManagerM65081a).options(m37587g()).build();
        } catch (IOException e10) {
            e = e10;
            str = "IOException ";
            C6550c1.m37258a("NetworkUtil", str, e);
            return null;
        } catch (KeyManagementException e11) {
            e = e11;
            str = "KeyManagementException ";
            C6550c1.m37258a("NetworkUtil", str, e);
            return null;
        } catch (KeyStoreException e12) {
            e = e12;
            str = "KeyStoreException ";
            C6550c1.m37258a("NetworkUtil", str, e);
            return null;
        } catch (NoSuchAlgorithmException e13) {
            e = e13;
            str = "NoSuchAlgorithmException ";
            C6550c1.m37258a("NetworkUtil", str, e);
            return null;
        } catch (CertificateException e14) {
            e = e14;
            str = "CertificateException ";
            C6550c1.m37258a("NetworkUtil", str, e);
            return null;
        }
    }

    /* renamed from: b */
    private String[] m37576b(String str) throws JSONException {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                String[] strArr = jSONArray.length() >= 8 ? new String[8] : new String[jSONArray.length()];
                C6550c1.m37256a("NetworkUtil", "befor cycle urlArray:" + strArr.length);
                for (int i10 = 0; i10 < jSONArray.length() && i10 < 8; i10++) {
                    Object obj = jSONArray.get(i10);
                    if (obj instanceof String) {
                        strArr[i10] = (String) obj;
                    }
                }
                C6550c1.m37256a("NetworkUtil", "last urlArray length:" + strArr.length);
                return strArr;
            }
        } catch (JSONException e10) {
            C6550c1.m37258a("NetworkUtil", "Exception :", e10);
        }
        return new String[0];
    }

    /* renamed from: c */
    public String m37583c() {
        return this.f30656f;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8 A[Catch: Exception -> 0x0037, IOException -> 0x003a, TryCatch #2 {IOException -> 0x003a, Exception -> 0x0037, blocks: (B:36:0x002b, B:38:0x0031, B:44:0x003d, B:46:0x0049, B:49:0x0089, B:54:0x00a2, B:56:0x00a8, B:58:0x00c3, B:50:0x008c, B:53:0x009d), top: B:65:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c3 A[Catch: Exception -> 0x0037, IOException -> 0x003a, TRY_LEAVE, TryCatch #2 {IOException -> 0x003a, Exception -> 0x0037, blocks: (B:36:0x002b, B:38:0x0031, B:44:0x003d, B:46:0x0049, B:49:0x0089, B:54:0x00a2, B:56:0x00a8, B:58:0x00c3, B:50:0x008c, B:53:0x009d), top: B:65:0x002b }] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.videokit.player.C6560h m37580a(android.content.Context r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r3 = this;
            java.lang.String r0 = "NetworkUtil"
            r3.f30652b = r8
            java.util.HashMap r8 = r3.m37578h()
            com.huawei.hms.network.httpclient.HttpClient r4 = r3.m37574a(r4)
            com.huawei.hms.network.restclient.RestClient$Builder r1 = new com.huawei.hms.network.restclient.RestClient$Builder
            r1.<init>()
            com.huawei.hms.network.restclient.RestClient$Builder r4 = r1.httpClient(r4)
            com.huawei.hms.network.restclient.RestClient$Builder r4 = r4.baseUrl(r6)
            com.huawei.hms.network.restclient.RestClient r4 = r4.build()
            java.lang.Class<com.huawei.hms.videokit.player.u> r6 = com.huawei.hms.videokit.player.InterfaceC6601u.class
            java.lang.Object r4 = r4.create(r6)
            com.huawei.hms.videokit.player.u r4 = (com.huawei.hms.videokit.player.InterfaceC6601u) r4
            long r1 = com.huawei.hms.videokit.player.C6600t0.m37688f()
            r3.f30658h = r1
            com.huawei.hms.network.httpclient.Submit r4 = r4.m37697a(r7, r8, r5)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            if (r4 != 0) goto L3d
            com.huawei.hms.videokit.player.h r4 = new com.huawei.hms.videokit.player.h     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            r4.<init>()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            return r4
        L37:
            r4 = move-exception
            goto Lc9
        L3a:
            r4 = move-exception
            goto Ld3
        L3d:
            com.huawei.hms.network.httpclient.Response r5 = r4.execute()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            long r6 = com.huawei.hms.videokit.player.C6600t0.m37688f()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            r3.f30659i = r6     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            if (r5 == 0) goto Lda
            int r6 = r5.getCode()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            r3.f30654d = r6     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            com.huawei.hms.network.httpclient.RequestFinishedInfo r4 = r4.getRequestFinishedInfo()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            com.huawei.hms.network.httpclient.RequestFinishedInfo$Metrics r4 = r4.getMetrics()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r4 = r4.getProtocol()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            r3.f30653c = r4     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            r4.<init>()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r6 = "protocol:"
            r4.append(r6)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r6 = r3.f30653c     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            r4.append(r6)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            com.huawei.hms.videokit.player.C6550c1.m37256a(r0, r4)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r4 = r3.f30653c     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r4 = r4.toLowerCase(r6)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r7 = "http/1.1"
            boolean r4 = r4.equals(r7)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            if (r4 == 0) goto L8c
            java.lang.String r4 = "HTTP/1.1"
        L89:
            r3.f30653c = r4     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            goto La2
        L8c:
            java.lang.String r4 = r3.f30653c     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r4 = r4.toLowerCase(r6)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r6 = "h2"
            boolean r4 = r4.equals(r6)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            if (r4 == 0) goto L9d
            java.lang.String r4 = "HTTP/2.0"
            goto L89
        L9d:
            java.lang.String r4 = "none http protocol"
            com.huawei.hms.videokit.player.C6550c1.m37256a(r0, r4)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
        La2:
            boolean r4 = r5.isSuccessful()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            if (r4 == 0) goto Lc3
            java.lang.String r4 = "response is successful"
            com.huawei.hms.videokit.player.C6550c1.m37256a(r0, r4)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.lang.Object r5 = r5.getBody()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            com.huawei.hms.network.httpclient.ResponseBody r5 = (com.huawei.hms.network.httpclient.ResponseBody) r5     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            byte[] r5 = r5.bytes()     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            r4.<init>(r5, r6)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            com.huawei.hms.videokit.player.h r3 = r3.m37577c(r4)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            return r3
        Lc3:
            java.lang.String r4 = "response is fail"
            com.huawei.hms.videokit.player.C6550c1.m37262b(r0, r4)     // Catch: java.lang.Exception -> L37 java.io.IOException -> L3a
            goto Lda
        Lc9:
            r5 = 101(0x65, float:1.42E-43)
            r3.f30651a = r5
            java.lang.String r3 = "Exception"
        Lcf:
            com.huawei.hms.videokit.player.C6550c1.m37258a(r0, r3, r4)
            goto Lda
        Ld3:
            r5 = 100
            r3.f30651a = r5
            java.lang.String r3 = "ioException"
            goto Lcf
        Lda:
            com.huawei.hms.videokit.player.h r3 = new com.huawei.hms.videokit.player.h
            r3.<init>()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.videokit.player.C6591o0.m37580a(android.content.Context, java.util.Map, java.lang.String, java.lang.String, java.lang.String):com.huawei.hms.videokit.player.h");
    }

    /* renamed from: a */
    public InterfaceC6601u m37581a(Context context, String str) {
        return (InterfaceC6601u) new RestClient.Builder().httpClient(m37574a(context)).baseUrl(str).build().create(InterfaceC6601u.class);
    }

    /* renamed from: a */
    public static String m37575a(String str) {
        try {
            return URLEncoder.encode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C6550c1.m37258a("NetworkUtil", " encoder data error ", e10);
            return str;
        }
    }
}
