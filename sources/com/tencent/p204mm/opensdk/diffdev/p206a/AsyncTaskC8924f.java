package com.tencent.p204mm.opensdk.diffdev.p206a;

import android.os.AsyncTask;
import com.tencent.p204mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p204mm.opensdk.diffdev.OAuthListener;
import com.tencent.p204mm.opensdk.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.f */
/* loaded from: classes9.dex */
final class AsyncTaskC8924f extends AsyncTask<Void, Void, a> {

    /* renamed from: k */
    private OAuthListener f45416k;

    /* renamed from: n */
    private String f45417n;

    /* renamed from: t */
    private int f45418t;
    private String url;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.f$a */
    public static class a {

        /* renamed from: m */
        public OAuthErrCode f45419m;

        /* renamed from: u */
        public String f45420u;

        /* renamed from: v */
        public int f45421v;

        /* renamed from: b */
        public static a m56632b(byte[] bArr) throws JSONException {
            OAuthErrCode oAuthErrCode;
            String str;
            OAuthErrCode oAuthErrCode2;
            a aVar = new a();
            Log.m56638d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
            if (bArr != null && bArr.length != 0) {
                try {
                } catch (Exception e10) {
                    str = String.format("parse fail, build String fail, ex = %s", e10.getMessage());
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i10 = jSONObject.getInt("wx_errcode");
                    aVar.f45421v = i10;
                    Log.m56638d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i10)));
                    int i11 = aVar.f45421v;
                    if (i11 == 408) {
                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                    } else if (i11 != 500) {
                        switch (i11) {
                            case 402:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Timeout;
                                break;
                            case 403:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Cancel;
                                break;
                            case 404:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 405:
                                aVar.f45419m = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.f45420u = jSONObject.getString("wx_code");
                                return aVar;
                            default:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                        }
                    } else {
                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    aVar.f45419m = oAuthErrCode2;
                    return aVar;
                } catch (Exception e11) {
                    str = String.format("parse json fail, ex = %s", e11.getMessage());
                    Log.m56639e("MicroMsg.SDK.NoopingResult", str);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f45419m = oAuthErrCode;
                    return aVar;
                }
            }
            Log.m56639e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.f45419m = oAuthErrCode;
            return aVar;
        }
    }

    public AsyncTaskC8924f(String str, OAuthListener oAuthListener) {
        this.f45417n = str;
        this.f45416k = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) throws Throwable {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str2 = this.f45417n;
        if (str2 == null || str2.length() == 0) {
            Log.m56639e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            Log.m56640i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.url);
                if (this.f45418t == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.f45418t;
                }
                sb2.append(str);
                String string = sb2.toString();
                long jCurrentTimeMillis = System.currentTimeMillis();
                byte[] bArrM56631a = C8923e.m56631a(string);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                a aVarM56632b = a.m56632b(bArrM56631a);
                Log.m56638d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVarM56632b.f45419m.toString(), Integer.valueOf(aVarM56632b.f45421v), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                OAuthErrCode oAuthErrCode2 = aVarM56632b.f45419m;
                if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                    Log.m56639e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), Integer.valueOf(aVarM56632b.f45421v)));
                    return aVarM56632b;
                }
                int i10 = aVarM56632b.f45421v;
                this.f45418t = i10;
                if (i10 == EnumC8925g.UUID_SCANED.getCode()) {
                    this.f45416k.onQrcodeScanned();
                } else if (aVarM56632b.f45421v != EnumC8925g.UUID_KEEP_CONNECT.getCode() && aVarM56632b.f45421v == EnumC8925g.UUID_CONFIRM.getCode()) {
                    String str3 = aVarM56632b.f45420u;
                    if (str3 == null || str3.length() == 0) {
                        Log.m56639e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        aVarM56632b.f45419m = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    return aVarM56632b;
                }
            }
            Log.m56640i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.f45419m = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f45416k.onAuthFinish(aVar2.f45419m, aVar2.f45420u);
    }
}
