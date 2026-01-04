package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.C6264b;
import com.huawei.hms.opendevice.C6269g;
import com.huawei.hms.opendevice.C6270h;
import com.huawei.hms.support.log.HMSLog;
import java.util.UUID;
import p208cq.C8941i;

@Deprecated
/* loaded from: classes8.dex */
public class HmsInstanceIdEx {
    public static final String TAG = "HmsInstanceIdEx";

    /* renamed from: a */
    private Context f23035a;

    /* renamed from: b */
    private PushPreferences f23036b;

    /* renamed from: c */
    private HuaweiApi<Api.ApiOptions.NoOptions> f23037c;

    private HmsInstanceIdEx(Context context) {
        this.f23036b = null;
        this.f23035a = context;
        this.f23036b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f23037c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f23037c = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f23037c.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private String m30104a(String str) {
        return "creationTime" + str;
    }

    public static HmsInstanceIdEx getInstance(Context context) {
        Preconditions.checkNotNull(context);
        return new HmsInstanceIdEx(context);
    }

    public void deleteAAID(String str) throws ApiException {
        if (str == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            if (this.f23036b.containsKey(str)) {
                this.f23036b.removeKey(str);
                this.f23036b.removeKey(m30104a(str));
            }
        } catch (RuntimeException unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        } catch (Exception unused2) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public String getAAId(String str) throws ApiException {
        if (str == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            if (this.f23036b.containsKey(str)) {
                return this.f23036b.getString(str);
            }
            String string = UUID.randomUUID().toString();
            this.f23036b.saveString(str, string);
            this.f23036b.saveLong(m30104a(str), Long.valueOf(System.currentTimeMillis()));
            return string;
        } catch (RuntimeException unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        } catch (Exception unused2) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public long getCreationTime(String str) throws ApiException {
        if (str == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            if (!this.f23036b.containsKey(m30104a(str))) {
                getAAId(str);
            }
            return this.f23036b.getLong(m30104a(str));
        } catch (RuntimeException unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        } catch (Exception unused2) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public Task<TokenResult> getToken() {
        if (ProxyCenter.getProxy() != null) {
            try {
                HMSLog.m36988i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                ProxyCenter.getProxy().getToken(this.f23035a, null, null);
                C8941i c8941i = new C8941i();
                c8941i.m56658d(new TokenResult());
                return c8941i.m56656b();
            } catch (ApiException e10) {
                return this.m30103a(e10);
            } catch (Exception unused) {
                return this.m30103a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        }
        String strM36430a = C6270h.m36430a(this.f23035a, "push.gettoken");
        try {
            TokenReq tokenReqM36411b = C6264b.m36411b(this.f23035a, null, null);
            tokenReqM36411b.setAaid(HmsInstanceId.getInstance(this.f23035a).getId());
            return this.f23037c.doWrite(new C6269g("push.gettoken", tokenReqM36411b, this.f23035a, strM36430a));
        } catch (RuntimeException unused2) {
            Context context = this.f23035a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            C6270h.m36433a(context, "push.gettoken", strM36430a, errorEnum);
            return this.m30103a(errorEnum.toApiException());
        } catch (Exception unused3) {
            Context context2 = this.f23035a;
            ErrorEnum errorEnum2 = ErrorEnum.ERROR_INTERNAL_ERROR;
            C6270h.m36433a(context2, "push.gettoken", strM36430a, errorEnum2);
            return this.m30103a(errorEnum2.toApiException());
        }
    }

    /* renamed from: a */
    private Task<TokenResult> m30103a(Exception exc) {
        C8941i c8941i = new C8941i();
        c8941i.m56657c(exc);
        return c8941i.m56656b();
    }
}
