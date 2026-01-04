package com.huawei.hwidauth.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.tencent.p204mm.opensdk.modelbase.BaseReq;
import com.tencent.p204mm.opensdk.modelbase.BaseResp;
import com.tencent.p204mm.opensdk.modelmsg.SendAuth;
import com.tencent.p204mm.opensdk.openapi.IWXAPI;
import com.tencent.p204mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.p204mm.opensdk.openapi.WXAPIFactory;
import p497nq.C11742a;
import p640sq.C12824c;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class AuthWXEntryActivity extends Activity implements IWXAPIEventHandler {

    /* renamed from: a */
    public IWXAPI f31177a;

    /* renamed from: a */
    public final void m38277a(Context context) {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, C12824c.m76991M(), true);
        this.f31177a = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp(C12824c.m76991M());
        this.f31177a.handleIntent(getIntent(), this);
        C12824c.m77021x("");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        Bundle extras;
        super.onCreate(bundle);
        C12836o.m77097b("AuthWXEntryActivity", "AuthWXEntryActivity onCreate", true);
        requestWindowFeature(1);
        C12824c.m77002e(this);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        if (!(intent instanceof SafeIntent)) {
            SafeIntent safeIntent = new SafeIntent(intent);
            setIntent(safeIntent);
            intent = safeIntent;
        }
        try {
            m38277a(this);
            extras = intent.getExtras();
        } catch (Exception e10) {
            C12836o.m77098c("AuthWXEntryActivity", e10.getClass().getSimpleName(), true);
            extras = null;
        }
        if (extras == null || extras.isEmpty()) {
            C12836o.m77097b("AuthWXEntryActivity", "not called by weixin app, finish myself", true);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C12836o.m77097b("AuthWXEntryActivity", "AuthWXEntryActivity onNewIntent", true);
        setIntent(intent);
        this.f31177a.handleIntent(intent, this);
    }

    @Override // com.tencent.p204mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        C12836o.m77096a("AuthWXEntryActivity", "enter onReq", true);
        finish();
    }

    @Override // com.tencent.p204mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        C12836o.m77097b("AuthWXEntryActivity", "enter onResp", true);
        if (baseResp instanceof SendAuth.Resp) {
            SendAuth.Resp resp = (SendAuth.Resp) baseResp;
            int i10 = resp.errCode;
            Intent intent = new Intent();
            intent.setAction("com.huawei.hwid.third.ACTION_WEIXIN_LOGIN_RESP");
            if (i10 == -4 || i10 == -2) {
                C12836o.m77097b("AuthWXEntryActivity", "user cancel or denied login with wechat", true);
                intent.putExtra(MapKeyNames.RESULT_CODE, 0);
            } else if (i10 == 0) {
                String str = resp.code;
                String str2 = resp.state;
                intent.putExtra("code", str);
                intent.putExtra(CommonConstant.ReqAccessTokenParam.STATE_LABEL, str2);
                intent.putExtra(MapKeyNames.RESULT_CODE, -1);
            }
            C11742a.m70048a().m70050b(intent);
        }
        finish();
    }
}
