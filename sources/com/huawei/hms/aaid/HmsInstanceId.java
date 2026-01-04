package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.AbstractC6267e;
import com.huawei.hms.opendevice.AbstractC6274l;
import com.huawei.hms.opendevice.C6264b;
import com.huawei.hms.opendevice.C6268f;
import com.huawei.hms.opendevice.C6269g;
import com.huawei.hms.opendevice.C6270h;
import com.huawei.hms.opendevice.C6271i;
import com.huawei.hms.opendevice.CallableC6263a;
import com.huawei.hms.support.log.HMSLog;
import p208cq.C8941i;
import p208cq.C8943k;

/* loaded from: classes8.dex */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a */
    private Context f23032a;

    /* renamed from: b */
    private PushPreferences f23033b;

    /* renamed from: c */
    private HuaweiApi<Api.ApiOptions.NoOptions> f23034c;

    private HmsInstanceId(Context context) {
        this.f23032a = context.getApplicationContext();
        this.f23033b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f23034c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f23034c = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f23034c.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private void m30101a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!AbstractC6267e.m36424e(this.f23032a)) {
            C6271i.m36434a(this.f23032a).removeKey("subjectId");
            return;
        }
        String string = C6271i.m36434a(this.f23032a).getString("subjectId");
        if (TextUtils.isEmpty(string)) {
            C6271i.m36434a(this.f23032a).saveString("subjectId", str);
            return;
        }
        if (string.contains(str)) {
            return;
        }
        C6271i.m36434a(this.f23032a).saveString("subjectId", string + "," + str);
    }

    /* renamed from: b */
    private void m30102b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        AbstractC6274l.m36458c(context);
        return new HmsInstanceId(context);
    }

    public void deleteAAID() throws ApiException {
        m30102b();
        try {
            if (this.f23033b.containsKey("aaid")) {
                this.f23033b.removeKey("aaid");
                this.f23033b.removeKey("creationTime");
                if (C6264b.m36415d(this.f23032a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.m36988i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.f23032a);
                        return;
                    }
                    DeleteTokenReq deleteTokenReqM36406a = C6264b.m36406a(this.f23032a);
                    deleteTokenReqM36406a.setDeleteType(1);
                    deleteTokenReqM36406a.setMultiSender(false);
                    m30100a(deleteTokenReqM36406a, 1);
                    BaseUtils.deleteAllTokenCache(this.f23032a);
                }
            }
        } catch (ApiException e10) {
            throw e10;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        m30102b();
        m30099a();
        DeleteTokenReq deleteTokenReqM36408a = C6264b.m36408a(this.f23032a, str, str2);
        deleteTokenReqM36408a.setMultiSender(false);
        m30100a(deleteTokenReqM36408a, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return C8943k.m56662b(new CallableC6263a(this.f23032a.getApplicationContext()));
        } catch (Exception unused) {
            C8941i c8941i = new C8941i();
            c8941i.m56657c(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return c8941i.m56656b();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.f23033b.containsKey("creationTime")) {
                getAAID();
            }
            return this.f23033b.getLong("creationTime");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getId() {
        return C6264b.m36413b(this.f23032a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        m30102b();
        m30099a();
        TokenReq tokenReqM36411b = C6264b.m36411b(this.f23032a, null, str2);
        tokenReqM36411b.setAaid(getId());
        tokenReqM36411b.setMultiSender(false);
        C6271i.m36434a(this.f23032a).saveString(this.f23032a.getPackageName(), "1");
        return m30098a(tokenReqM36411b, 1);
    }

    public void deleteToken(String str) throws ApiException {
        m30102b();
        m30099a();
        if (!TextUtils.isEmpty(str)) {
            String strM36414c = C6264b.m36414c(this.f23032a);
            if (!TextUtils.isEmpty(strM36414c)) {
                if (str.equals(strM36414c)) {
                    deleteToken(null, null);
                    return;
                }
                DeleteTokenReq deleteTokenReqM36407a = C6264b.m36407a(this.f23032a, str);
                deleteTokenReqM36407a.setMultiSender(true);
                m30100a(deleteTokenReqM36407a, 2);
                return;
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getToken(String str) throws ApiException {
        m30102b();
        m30099a();
        if (!TextUtils.isEmpty(str)) {
            String strM36414c = C6264b.m36414c(this.f23032a);
            if (!TextUtils.isEmpty(strM36414c)) {
                if (str.equals(strM36414c)) {
                    return getToken(null, null);
                }
                TokenReq tokenReqM36410b = C6264b.m36410b(this.f23032a, str);
                tokenReqM36410b.setAaid(getId());
                tokenReqM36410b.setMultiSender(true);
                return m30098a(tokenReqM36410b, 2);
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    /* renamed from: a */
    private String m30098a(TokenReq tokenReq, int i10) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m36988i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f23032a, tokenReq.getSubjectId(), null);
            return null;
        }
        m30101a(tokenReq.getSubjectId());
        String strM36430a = C6270h.m36430a(this.f23032a, "push.gettoken");
        try {
            HMSLog.m36983d(TAG, "getToken req :" + tokenReq.toString());
            C6269g c6269g = new C6269g("push.gettoken", tokenReq, this.f23032a, strM36430a);
            c6269g.setApiLevel(i10);
            return ((TokenResult) C8943k.m56661a(this.f23034c.doWrite(c6269g))).getToken();
        } catch (Exception e10) {
            if (e10.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e10.getCause();
                C6270h.m36432a(this.f23032a, "push.gettoken", strM36430a, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f23032a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            C6270h.m36433a(context, "push.gettoken", strM36430a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    /* renamed from: a */
    private void m30100a(DeleteTokenReq deleteTokenReq, int i10) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m36988i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f23032a, subjectId, null);
            return;
        }
        String strM36430a = C6270h.m36430a(this.f23032a, "push.deletetoken");
        try {
            String strM36438b = C6271i.m36434a(this.f23032a).m36438b(subjectId);
            if (!deleteTokenReq.isMultiSender() || (!TextUtils.isEmpty(strM36438b) && !strM36438b.equals(C6271i.m36434a(this.f23032a).m36438b(null)))) {
                deleteTokenReq.setToken(strM36438b);
                C6268f c6268f = new C6268f("push.deletetoken", deleteTokenReq, strM36430a);
                c6268f.setApiLevel(i10);
                C8943k.m56661a(this.f23034c.doWrite(c6268f));
                C6271i.m36434a(this.f23032a).m36440c(subjectId);
                return;
            }
            C6271i.m36434a(this.f23032a).removeKey(subjectId);
            HMSLog.m36988i(TAG, "The local subject token is null");
        } catch (Exception e10) {
            if (e10.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e10.getCause();
                C6270h.m36432a(this.f23032a, "push.deletetoken", strM36430a, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f23032a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            C6270h.m36433a(context, "push.deletetoken", strM36430a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    /* renamed from: a */
    private void m30099a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f23032a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f23032a)) {
            HMSLog.m36986e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
