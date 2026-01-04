package com.huawei.hms.support.hwid.common.p146e;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.framework.network.restclient.Response;
import com.huawei.hms.framework.network.restclient.RestClient;
import com.huawei.hms.framework.network.restclient.RestClientGlobalInstance;
import com.huawei.hms.framework.network.restclient.ResultCallback;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.support.hwid.bean.CheckPasswordByUserIdReq;
import com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler;
import com.huawei.hms.support.hwid.common.p143c.p144a.C6468b;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.hms.support.hwid.common.e.e */
/* loaded from: classes8.dex */
public class C6475e {

    /* renamed from: a */
    private static final C6475e f30067a = new C6475e();

    /* renamed from: b */
    private String f30068b = "";

    /* renamed from: c */
    private String f30069c = "";

    /* renamed from: d */
    private Context f30070d;

    /* renamed from: e */
    private CloudRequestHandler f30071e;

    /* renamed from: a */
    public static C6475e m36894a() {
        return f30067a;
    }

    /* renamed from: a */
    public void m36900a(Context context, CheckPasswordByUserIdReq checkPasswordByUserIdReq, String str, String str2, String str3, CloudRequestHandler cloudRequestHandler) {
        this.f30068b = str3;
        this.f30069c = checkPasswordByUserIdReq.getPackageName();
        this.f30070d = context;
        this.f30071e = cloudRequestHandler;
        final C6468b c6468b = new C6468b(context, checkPasswordByUserIdReq, str, str2, str3);
        RestClientGlobalInstance.getInstance().init(this.f30070d);
        RestClient restClientBuild = new RestClient.Builder(this.f30070d).build();
        if (restClientBuild == null) {
            m36896a(2003, "restClient is null");
            return;
        }
        InterfaceC6471a interfaceC6471a = (InterfaceC6471a) restClientBuild.create(InterfaceC6471a.class);
        try {
            interfaceC6471a.m36868a(c6468b.m36851d(), RequestBody.create(" text/html; charset=utf-8", c6468b.m36859e().getBytes(Constants.UTF_8))).enqueue(new ResultCallback<ResponseBody>() { // from class: com.huawei.hms.support.hwid.common.e.e.1
                @Override // com.huawei.hms.framework.network.restclient.ResultCallback
                public void onFailure(Throwable th2) {
                    C6477g.m36903a("GetVerifyPwdUtil", "request getResource for siteDomain onFailure");
                    C6475e.this.m36896a(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "request getResource for siteDomain onFailure");
                }

                @Override // com.huawei.hms.framework.network.restclient.ResultCallback
                public void onResponse(Response<ResponseBody> response) {
                    C6477g.m36903a("GetVerifyPwdUtil", "request getResource for siteDomain success");
                    C6475e.this.m36897a(c6468b, response);
                }
            });
        } catch (IOException unused) {
            C6477g.m36903a("GetVerifyPwdUtil", "request getResource for siteDomain IOException");
            m36896a(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "request getResource for siteDomain IOException");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m36897a(C6468b c6468b, Response<ResponseBody> response) {
        C6477g.m36903a("GetVerifyPwdUtil", "handleRequestNet");
        int code = response.getCode();
        C6477g.m36903a("GetVerifyPwdUtil", "code:" + code);
        if (code == 200) {
            C6477g.m36903a("GetVerifyPwdUtil", "GetResourceRequest success");
            try {
                c6468b.m36858a(new String(response.getBody().bytes(), Constants.UTF_8));
                Bundle bundleMo36849b = c6468b.mo36849b();
                String string = bundleMo36849b.getString(CommonConstant.KEY_ID_TOKEN);
                if (!TextUtils.isEmpty(string)) {
                    C6477g.m36904a("GetVerifyPwdUtil", "idToken is:" + string, false);
                    Bundle bundle = new Bundle();
                    bundle.putString(CommonConstant.KEY_ID_TOKEN, string);
                    C6476f.m36902a(this.f30068b, "hwid.checkPasswordByUserId", this.f30069c);
                    this.f30071e.onFinish(bundle);
                } else {
                    int i10 = bundleMo36849b.getInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
                    C6477g.m36904a("GetVerifyPwdUtil", "handleRequestNet errorCode:" + i10, true);
                    m36895a(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, i10, bundleMo36849b.getString("errorDesc"));
                }
                return;
            } catch (IOException unused) {
                C6477g.m36903a("GetVerifyPwdUtil", "IOException");
                m36896a(2015, "IOException");
                return;
            } catch (XmlPullParserException unused2) {
                C6477g.m36903a("GetVerifyPwdUtil", "XmlPullParserException");
                m36896a(2015, "XmlPullParserException");
                return;
            }
        }
        m36896a(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS, "request error.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m36896a(int i10, String str) {
        m36895a(i10, i10, str);
    }

    /* renamed from: a */
    private void m36895a(int i10, int i11, String str) {
        ErrorStatus errorStatus = new ErrorStatus(i10, str);
        errorStatus.setSubErrCode(i11);
        this.f30071e.onError(errorStatus);
        C6476f.m36901a(this.f30068b, "hwid.checkPasswordByUserId", i10, this.f30069c);
    }
}
