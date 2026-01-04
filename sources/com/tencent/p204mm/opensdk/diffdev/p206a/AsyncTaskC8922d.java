package com.tencent.p204mm.opensdk.diffdev.p206a;

import android.os.AsyncTask;
import android.util.Base64;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.tencent.p204mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p204mm.opensdk.diffdev.OAuthListener;
import com.tencent.p204mm.opensdk.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.d */
/* loaded from: classes9.dex */
public final class AsyncTaskC8922d extends AsyncTask<Void, Void, a> {

    /* renamed from: h */
    private static String f45404h = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    private String appId;

    /* renamed from: i */
    private String f45405i;

    /* renamed from: j */
    private String f45406j;

    /* renamed from: k */
    private OAuthListener f45407k;

    /* renamed from: l */
    private AsyncTaskC8924f f45408l;
    private String scope;
    private String signature;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.d$a */
    public static class a {

        /* renamed from: m */
        public OAuthErrCode f45409m;

        /* renamed from: n */
        public String f45410n;

        /* renamed from: o */
        public String f45411o;

        /* renamed from: p */
        public String f45412p;

        /* renamed from: q */
        public int f45413q;

        /* renamed from: r */
        public String f45414r;

        /* renamed from: s */
        public byte[] f45415s;

        private a() {
        }

        /* renamed from: a */
        public static a m56630a(byte[] bArr) throws JSONException {
            OAuthErrCode oAuthErrCode;
            String str;
            a aVar = new a();
            if (bArr != null && bArr.length != 0) {
                try {
                } catch (Exception e10) {
                    str = String.format("parse fail, build String fail, ex = %s", e10.getMessage());
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i10 = jSONObject.getInt(InterfaceC5323b.f24681h);
                    if (i10 != 0) {
                        Log.m56639e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i10)));
                        aVar.f45409m = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f45413q = i10;
                        aVar.f45414r = jSONObject.optString("errmsg");
                        return aVar;
                    }
                    String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                    if (string != null && string.length() != 0) {
                        byte[] bArrDecode = Base64.decode(string, 0);
                        if (bArrDecode != null && bArrDecode.length != 0) {
                            aVar.f45409m = OAuthErrCode.WechatAuth_Err_OK;
                            aVar.f45415s = bArrDecode;
                            aVar.f45410n = jSONObject.getString("uuid");
                            String string2 = jSONObject.getString(SnapshotBackupMeta.KEY_STRING_APP_NAME);
                            aVar.f45411o = string2;
                            Log.m56638d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f45410n, string2, Integer.valueOf(aVar.f45415s.length)));
                            return aVar;
                        }
                        Log.m56639e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                        aVar.f45409m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    }
                    Log.m56639e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                    aVar.f45409m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                    return aVar;
                } catch (Exception e11) {
                    str = String.format("parse json fail, ex = %s", e11.getMessage());
                    Log.m56639e("MicroMsg.SDK.GetQRCodeResult", str);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f45409m = oAuthErrCode;
                    return aVar;
                }
            }
            Log.m56639e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.f45409m = oAuthErrCode;
            return aVar;
        }
    }

    public AsyncTaskC8922d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.f45405i = str3;
        this.f45406j = str4;
        this.signature = str5;
        this.f45407k = oAuthListener;
    }

    /* renamed from: a */
    public final boolean m56629a() {
        Log.m56640i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        AsyncTaskC8924f asyncTaskC8924f = this.f45408l;
        return asyncTaskC8924f == null ? cancel(true) : asyncTaskC8924f.cancel(true);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) throws Throwable {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.m56640i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String str = String.format(f45404h, this.appId, this.f45405i, this.f45406j, this.scope, this.signature);
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArrM56631a = C8923e.m56631a(str);
        Log.m56638d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", str, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        return a.m56630a(bArrM56631a);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f45409m;
        if (oAuthErrCode != OAuthErrCode.WechatAuth_Err_OK) {
            Log.m56639e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.f45407k.onAuthFinish(aVar2.f45409m, null);
            return;
        }
        Log.m56638d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f45415s.length);
        this.f45407k.onAuthGotQrcode(aVar2.f45412p, aVar2.f45415s);
        AsyncTaskC8924f asyncTaskC8924f = new AsyncTaskC8924f(aVar2.f45410n, this.f45407k);
        this.f45408l = asyncTaskC8924f;
        asyncTaskC8924f.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
