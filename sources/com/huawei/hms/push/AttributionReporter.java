package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.p148ui.SafeBundle;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.task.AttributionReportTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.AttributionReportReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class AttributionReporter {
    public static final String APP_VERSION = "appVersion";
    public static final String SYSTEM_PERMISSION = "permission";

    /* renamed from: a */
    private HuaweiApi<Api.ApiOptions.NoOptions> f29600a;

    /* renamed from: b */
    private Context f29601b;

    private AttributionReporter(Context context) {
        Preconditions.checkNotNull(context);
        this.f29601b = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f29600a = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f29600a = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f29600a.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private Task<Void> m36470a(AttributionEvent attributionEvent, Bundle bundle) throws ApiException {
        C8941i c8941i;
        int externalCode;
        String strReportEntry = PushBiUtil.reportEntry(this.f29601b, PushNaming.PUSH_ANALYSIS_REPORT);
        if (bundle == null || attributionEvent == null) {
            PushBiUtil.reportExit(this.f29601b, PushNaming.PUSH_ANALYSIS_REPORT, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.m36986e("AttributionReporter", "Invalid argument: argument should not be null");
            throw new IllegalArgumentException("Invalid argument: argument should not be null");
        }
        try {
            if (!AbstractC6285d.m36515d(this.f29601b)) {
                throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
            }
            long j10 = new PushPreferences(this.f29601b, "hwpush_local_config").getLong("analysis_last_failed_time");
            if (j10 > 0 && System.currentTimeMillis() - j10 < 86400000) {
                throw ErrorEnum.ERROR_NOT_IN_SERVICE.toApiException();
            }
            return this.f29600a.doWrite(new AttributionReportTask(PushNaming.PUSH_ANALYSIS_REPORT, JsonUtil.createJsonString(m36471a(attributionEvent, new SafeBundle(bundle))), strReportEntry));
        } catch (ApiException e10) {
            C8941i c8941i2 = new C8941i();
            c8941i2.m56657c(e10);
            externalCode = e10.getStatusCode();
            c8941i = c8941i2;
            PushBiUtil.reportExit(this.f29601b, PushNaming.PUSH_ANALYSIS_REPORT, strReportEntry, externalCode);
            return c8941i.m56656b();
        } catch (Exception unused) {
            c8941i = new C8941i();
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            c8941i.m56657c(errorEnum.toApiException());
            externalCode = errorEnum.getExternalCode();
            PushBiUtil.reportExit(this.f29601b, PushNaming.PUSH_ANALYSIS_REPORT, strReportEntry, externalCode);
            return c8941i.m56656b();
        }
    }

    public static AttributionReporter getInstance(Context context) {
        return new AttributionReporter(context);
    }

    public Task<Void> report(AttributionEvent attributionEvent, Bundle bundle) {
        return m36470a(attributionEvent, bundle);
    }

    /* renamed from: a */
    private AttributionReportReq m36471a(AttributionEvent attributionEvent, SafeBundle safeBundle) throws ApiException {
        Bundle bundle = safeBundle.getBundle().getBundle("analysisExt");
        if (bundle != null && !bundle.isEmpty()) {
            String string = bundle.getString(RemoteMessageConst.MSGID);
            if (!TextUtils.isEmpty(string)) {
                String string2 = bundle.getString("hsId");
                if (!TextUtils.isEmpty(string2)) {
                    AttributionReportReq attributionReportReq = new AttributionReportReq();
                    attributionReportReq.setCampaignId(bundle.getString(JsbMapKeyNames.H5_CLIENT_ID));
                    attributionReportReq.setMsgId(string);
                    attributionReportReq.setHaStorageId(string2);
                    attributionReportReq.setEventId(attributionEvent.getEventId());
                    attributionReportReq.setPkgName(this.f29601b.getPackageName());
                    if (attributionEvent.equals(AttributionEvent.PERMISSION_GRANTED) || attributionEvent.equals(AttributionEvent.PERMISSION_DENIED)) {
                        String string3 = safeBundle.getString("permission");
                        if (!TextUtils.isEmpty(string3) && string3.startsWith("android.permission")) {
                            attributionReportReq.setReqPermission(string3);
                        } else {
                            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
                        }
                    }
                    attributionReportReq.setTimeStamp(System.currentTimeMillis());
                    attributionReportReq.setAppVersion(safeBundle.getString("appVersion"));
                    return attributionReportReq;
                }
                throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
            }
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
