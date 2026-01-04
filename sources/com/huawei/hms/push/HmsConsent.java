package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ConsentTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableConsentReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class HmsConsent {

    /* renamed from: a */
    private HuaweiApi<Api.ApiOptions.NoOptions> f29604a;

    /* renamed from: b */
    private Context f29605b;

    private HmsConsent(Context context) {
        Preconditions.checkNotNull(context);
        this.f29605b = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f29604a = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f29604a = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f29604a.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private Task<Void> m36472a(boolean z10) throws ApiException {
        C8941i c8941i;
        int externalCode;
        String strReportEntry = PushBiUtil.reportEntry(this.f29605b, PushNaming.PUSH_CONSENT);
        try {
            if (!AbstractC6285d.m36515d(this.f29605b)) {
                throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
            }
            EnableConsentReq enableConsentReq = new EnableConsentReq();
            enableConsentReq.setPackageName(this.f29605b.getPackageName());
            enableConsentReq.setEnable(z10);
            return this.f29604a.doWrite(new ConsentTask(PushNaming.PUSH_CONSENT, JsonUtil.createJsonString(enableConsentReq), strReportEntry));
        } catch (ApiException e10) {
            C8941i c8941i2 = new C8941i();
            c8941i2.m56657c(e10);
            externalCode = e10.getStatusCode();
            c8941i = c8941i2;
            PushBiUtil.reportExit(this.f29605b, PushNaming.PUSH_CONSENT, strReportEntry, externalCode);
            return c8941i.m56656b();
        } catch (Exception unused) {
            c8941i = new C8941i();
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            c8941i.m56657c(errorEnum.toApiException());
            externalCode = errorEnum.getExternalCode();
            PushBiUtil.reportExit(this.f29605b, PushNaming.PUSH_CONSENT, strReportEntry, externalCode);
            return c8941i.m56656b();
        }
    }

    public static HmsConsent getInstance(Context context) {
        return new HmsConsent(context);
    }

    public Task<Void> consentOff() {
        return m36472a(false);
    }

    public Task<Void> consentOn() {
        return m36472a(true);
    }
}
