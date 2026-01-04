package com.huawei.hwcloudjs.service.hms;

import android.app.Activity;
import com.huawei.hwcloudjs.api.TaskCallBack;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.hms.bean.AccessTokenInfo;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.m */
/* loaded from: classes8.dex */
public class C6681m implements TaskCallBack<AccessTokenInfo> {

    /* renamed from: a */
    final /* synthetic */ Activity f30991a;

    /* renamed from: b */
    final /* synthetic */ String f30992b;

    /* renamed from: c */
    final /* synthetic */ String[] f30993c;

    /* renamed from: d */
    final /* synthetic */ String f30994d;

    /* renamed from: e */
    final /* synthetic */ String f30995e;

    /* renamed from: f */
    final /* synthetic */ boolean f30996f;

    /* renamed from: g */
    final /* synthetic */ JsCallback f30997g;

    /* renamed from: h */
    final /* synthetic */ HmsLiteCoreApi f30998h;

    public C6681m(HmsLiteCoreApi hmsLiteCoreApi, Activity activity, String str, String[] strArr, String str2, String str3, boolean z10, JsCallback jsCallback) {
        this.f30998h = hmsLiteCoreApi;
        this.f30991a = activity;
        this.f30992b = str;
        this.f30993c = strArr;
        this.f30994d = str2;
        this.f30995e = str3;
        this.f30996f = z10;
        this.f30997g = jsCallback;
    }

    @Override // com.huawei.hwcloudjs.api.TaskCallBack
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResult(AccessTokenInfo accessTokenInfo) throws JSONException {
        String str;
        if (this.f30998h.f30925f) {
            return;
        }
        if (accessTokenInfo == null) {
            this.f30998h.f30926g.removeMessages(4);
            this.f30998h.m37936a(this.f30991a, this.f30992b, this.f30993c, this.f30994d, this.f30995e, null, this.f30996f, this.f30997g);
            str = "jsIAccessToken.getAccessToken result = null";
        } else {
            if (accessTokenInfo.isSuccess()) {
                String accessToken = accessTokenInfo.getAccessToken();
                C6659d.m37882c("HmsLiteCoreApi", "signIn getAccessToken success", true);
                this.f30998h.f30926g.removeMessages(4);
                this.f30998h.m37936a(this.f30991a, this.f30992b, this.f30993c, this.f30994d, this.f30995e, accessToken, this.f30996f, this.f30997g);
                return;
            }
            this.f30998h.f30926g.removeMessages(4);
            this.f30998h.m37936a(this.f30991a, this.f30992b, this.f30993c, this.f30994d, this.f30995e, null, this.f30996f, this.f30997g);
            str = " stateCode = " + accessTokenInfo.getStatus().getStateCode() + "\nstatusMessage = " + accessTokenInfo.getStatus().getStateMessage();
        }
        C6659d.m37881b("HmsLiteCoreApi", str, true);
    }
}
