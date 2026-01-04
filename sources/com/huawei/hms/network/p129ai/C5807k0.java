package com.huawei.hms.network.p129ai;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.CreateFileUtil;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.network.base.common.MediaType;
import com.huawei.hms.network.base.common.RequestBodyProviders;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.ai.k0 */
/* loaded from: classes8.dex */
public class C5807k0 {

    /* renamed from: d */
    public static final String f25941d = "AIModelDownloader";

    /* renamed from: e */
    public static final String f25942e = "com.huawei.wisemlops.modelaccess";

    /* renamed from: f */
    public static final String f25943f = "wisemep";

    /* renamed from: g */
    public static final String f25944g = "/openapi/v1/modelaccess";

    /* renamed from: h */
    public static final String f25945h = "1.0";

    /* renamed from: i */
    public static final String f25946i = Build.MODEL;

    /* renamed from: j */
    public static final String f25947j = "NetworkKit";

    /* renamed from: k */
    public static final String f25948k = "NetworkKit_app";

    /* renamed from: l */
    public static final String f25949l = "businessId";

    /* renamed from: m */
    public static final String f25950m = "networkkit";

    /* renamed from: n */
    public static final int f25951n = 38207;

    /* renamed from: a */
    public PLSharedPreferences f25952a = new PLSharedPreferences(ContextHolder.getResourceContext(), C5826z.f26137D);

    /* renamed from: c */
    public GrsClient f25954c = new GrsClient(ContextHolder.getResourceContext(), new GrsBaseInfo());

    /* renamed from: b */
    public HttpClient f25953b = new HttpClient.Builder().retryTimeOnConnectionFailure(0).build();

    /* renamed from: com.huawei.hms.network.ai.k0$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f25955a;

        /* renamed from: b */
        public final /* synthetic */ String f25956b;

        /* renamed from: c */
        public final /* synthetic */ String f25957c;

        public a(String str, String str2, String str3) {
            this.f25955a = str;
            this.f25956b = str2;
            this.f25957c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            C5805j0 c5805j0M33411a = C5807k0.this.m33411a();
            if (c5805j0M33411a != null) {
                String strM33386a = c5805j0M33411a.m33384b().m33408b().m33386a();
                String strM33402d = c5805j0M33411a.m33384b().m33408b().m33389b().m33402d();
                String strM33393d = c5805j0M33411a.m33384b().m33408b().m33393d();
                int iM33404a = c5805j0M33411a.m33384b().m33404a();
                if (iM33404a == 0) {
                    boolean z10 = TextUtils.isEmpty(this.f25955a) || !TextUtils.equals(this.f25955a, strM33393d);
                    if (TextUtils.isEmpty(strM33386a) || !z10) {
                        C5807k0.this.f25952a.putLong(C5826z.f26138E, System.currentTimeMillis());
                        C5807k0.this.f25952a.putString("modelVersion", strM33393d);
                        str = "model download failed,downloadUrl:" + StringUtils.anonymizeMessage(strM33386a) + ",version:" + this.f25955a + ",response version:" + strM33393d;
                    } else {
                        if (C5807k0.this.m33416a(strM33386a, strM33402d, this.f25956b, this.f25957c)) {
                            C5807k0.this.f25952a.putLong(C5826z.f26138E, System.currentTimeMillis());
                            C5807k0.this.f25952a.putString("modelVersion", strM33393d);
                            Logger.m32141i(C5807k0.f25941d, "model download success modelVersion:" + strM33393d);
                            C5807k0.this.f25952a.putLong("modelDisable", 0L);
                        }
                        str = "model download request failed";
                    }
                } else {
                    if (iM33404a == 38207) {
                        CreateFileUtil.deleteSecure(this.f25956b + this.f25957c);
                        C5807k0.this.f25952a.putLong("modelDisable", 38207L);
                        C5807k0.this.f25952a.putLong(C5826z.f26138E, System.currentTimeMillis());
                        Logger.m32145w(C5807k0.f25941d, "model download failed,model disable");
                        return;
                    }
                    str = "model download failed,response code:" + iM33404a;
                }
            } else {
                str = "model download failed,response is null";
            }
            Logger.m32145w(C5807k0.f25941d, str);
            C5807k0.this.f25952a.putLong("modelDisable", 0L);
        }
    }

    /* renamed from: a */
    public C5805j0 m33411a() {
        String strSynGetGrsUrl = this.f25954c.synGetGrsUrl(f25942e, f25943f);
        C5805j0 c5805j0M33413a = null;
        if (TextUtils.isEmpty(strSynGetGrsUrl)) {
            Logger.m32145w(f25941d, "model download synGetGrsUrl failed: " + strSynGetGrsUrl);
            return null;
        }
        String str = strSynGetGrsUrl + f25944g;
        Logger.m32141i(f25941d, "model download before requset url is: " + StringUtils.anonymizeMessage(str));
        C5803i0 c5803i0 = new C5803i0();
        c5803i0.m33355a("1.0");
        c5803i0.m33356b().m33378c(UUID.randomUUID().toString());
        c5803i0.m33356b().m33374a(f25947j);
        c5803i0.m33356b().m33376b(f25948k);
        c5803i0.m33352a().m33364c().m33366a("");
        c5803i0.m33352a().m33364c().m33370c(EmuiUtil.getEMUIVersionCode() + "");
        c5803i0.m33352a().m33364c().m33372d("");
        c5803i0.m33352a().m33364c().m33368b(f25946i);
        c5803i0.m33352a().m33361a("");
        c5803i0.m33352a().m33363b("");
        Request requestBuild = this.f25953b.newRequest().url(str).addHeader(f25949l, "networkkit").requestBody(RequestBodyProviders.create(MediaType.parse("application/json;charset=utf-8"), c5803i0.m33358d())).build();
        Logger.m32143v(f25941d, "model download before requset body:" + c5803i0.m33358d());
        try {
            Response<ResponseBody> responseExecute = this.f25953b.newSubmit(requestBuild).execute();
            if (responseExecute.getCode() == 200) {
                String str2 = new String(responseExecute.getBody().bytes(), Constants.UTF_8);
                Logger.m32143v(f25941d, "model download before response body:" + str2);
                c5805j0M33413a = m33413a(str2);
            }
            Logger.m32145w(f25941d, "model download before response code:" + responseExecute.getCode());
            responseExecute.close();
        } catch (Exception e10) {
            Logger.m32145w(f25941d, "model download before requset failed:" + e10.getMessage());
        }
        return c5805j0M33413a;
    }

    /* renamed from: a */
    private C5805j0 m33413a(String str) {
        Logger.m32141i(f25941d, "model download before response parse json start");
        C5805j0 c5805j0 = new C5805j0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            c5805j0.m33383a(jSONObject.optString("version"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("meta");
            if (jSONObjectOptJSONObject != null) {
                c5805j0.m33380a().m33395a(jSONObjectOptJSONObject.optString("uuid"));
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("result");
            if (jSONObjectOptJSONObject2 != null) {
                c5805j0.m33384b().m33405a(jSONObjectOptJSONObject2.optInt("code"));
                c5805j0.m33384b().m33407a(jSONObjectOptJSONObject2.optString("des"));
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("data");
                if (jSONObjectOptJSONObject3 != null) {
                    c5805j0.m33384b().m33408b().m33390b(jSONObjectOptJSONObject3.optString("modelName"));
                    c5805j0.m33384b().m33408b().m33392c(jSONObjectOptJSONObject3.optString("modelVersion"));
                    c5805j0.m33384b().m33408b().m33388a(jSONObjectOptJSONObject3.optString("accessUrl"));
                    JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("metas");
                    if (jSONObjectOptJSONObject4 != null) {
                        c5805j0.m33384b().m33408b().m33389b().m33403d(jSONObjectOptJSONObject4.optString("sha256"));
                    }
                } else {
                    Logger.m32145w(f25941d, "model download before response parse json no data");
                }
            }
        } catch (JSONException e10) {
            Logger.m32145w(f25941d, "model download before response parse json failed:" + e10.getMessage());
        }
        return c5805j0;
    }

    /* renamed from: a */
    public void m33418a(String str, String str2, String str3) {
        Logger.m32141i(f25941d, "model download start");
        C5794e.m33310a().m33312b(new a(str3, str, str2));
    }

    /* renamed from: a */
    private boolean m33415a(Response<ResponseBody> response, String str, String str2, String str3) throws IOException {
        Logger.m32141i(f25941d, "model download request success,write file start");
        boolean zM33423a = false;
        if (TextUtils.isEmpty(str2)) {
            Logger.m32145w(f25941d, "model download save path is empty");
            return false;
        }
        InputStream inputStream = response.getBody().getInputStream();
        long contentLength = response.getBody().getContentLength();
        byte[] bArr = new byte[8192];
        FileOutputStream fileOutputStreamNewSafeFileOutputStream = null;
        try {
            try {
                Logger.m32143v(f25941d, "download write file path: " + str2 + str3);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(FeedbackWebConstants.SUFFIX);
                String string = sb2.toString();
                Logger.m32141i(f25941d, "download write file temp name: " + string);
                File fileNewSafeFile = CreateFileUtil.newSafeFile(str2 + string);
                if (!fileNewSafeFile.exists()) {
                    fileNewSafeFile.createNewFile();
                }
                fileOutputStreamNewSafeFileOutputStream = CreateFileUtil.newSafeFileOutputStream(fileNewSafeFile);
                long j10 = 0;
                int i10 = 0;
                while (true) {
                    int i11 = inputStream.read(bArr);
                    if (i11 == -1) {
                        break;
                    }
                    fileOutputStreamNewSafeFileOutputStream.write(bArr, 0, i11);
                    j10 += i11;
                    int i12 = (int) (((j10 * 1.0f) / contentLength) * 100.0f);
                    if (i12 != i10 && contentLength != -1) {
                        Logger.m32141i(f25941d, "download write file progress : " + i12);
                        i10 = i12;
                    }
                }
                fileOutputStreamNewSafeFileOutputStream.flush();
                Logger.m32141i(f25941d, "download write temp file success");
                String fileHashData = CreateFileUtil.getFileHashData(str2 + string, "SHA256");
                Logger.m32143v(f25941d, "download write file check SHA256 Hash:" + fileHashData + "  response Sha256:" + str);
                if (str.equalsIgnoreCase(fileHashData)) {
                    Logger.m32141i(f25941d, "download write file check success");
                    zM33423a = C5809l0.m33423a(str2 + string, str2, str3);
                } else {
                    Logger.m32141i(f25941d, "download write file check failed");
                }
            } catch (Exception e10) {
                Logger.m32146w(f25941d, "download write file failed : ", e10);
            }
            IoUtils.closeSecure(inputStream);
            IoUtils.closeSecure((OutputStream) fileOutputStreamNewSafeFileOutputStream);
            return zM33423a;
        } catch (Throwable th2) {
            IoUtils.closeSecure(inputStream);
            IoUtils.closeSecure((OutputStream) null);
            throw th2;
        }
    }

    /* renamed from: a */
    public boolean m33416a(String str, String str2, String str3, String str4) {
        boolean zM33415a;
        Logger.m32143v(f25941d, "model download request start,url:" + str);
        try {
            Response<ResponseBody> responseExecute = this.f25953b.newSubmit(this.f25953b.newRequest().url(str).addHeader(f25949l, "networkkit").build()).execute();
            Logger.m32141i(f25941d, "model download request response code:" + responseExecute.getCode());
            if (responseExecute.getCode() == 200) {
                zM33415a = m33415a(responseExecute, str2, str3, str4);
            } else {
                Logger.m32145w(f25941d, "model download requset failed");
                zM33415a = false;
            }
            responseExecute.close();
            return zM33415a;
        } catch (IOException e10) {
            Logger.m32145w(f25941d, "model download requset failed:" + e10.getMessage());
            return false;
        }
    }
}
