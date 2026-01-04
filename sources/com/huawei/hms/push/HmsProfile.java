package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;
import p237du.C9310c;
import p443l4.AbstractC11229a;

/* loaded from: classes8.dex */
public class HmsProfile {
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;

    /* renamed from: c */
    private static final String f29614c = "HmsProfile";

    /* renamed from: a */
    private Context f29615a;

    /* renamed from: b */
    private HuaweiApi<Api.ApiOptions.NoOptions> f29616b;

    private HmsProfile(Context context) {
        this.f29615a = null;
        Preconditions.checkNotNull(context);
        this.f29615a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f29616b = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f29616b = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f29616b.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private Task<Void> m36487a(int i10, String str, int i11, String str2) {
        if (!isSupportProfile()) {
            C8941i c8941i = new C8941i();
            c8941i.m56657c(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
            return c8941i.m56656b();
        }
        if (!TextUtils.isEmpty(str)) {
            String strM36488a = m36488a(this.f29615a);
            if (TextUtils.isEmpty(strM36488a)) {
                HMSLog.m36988i(f29614c, "agc connect services config missing project id.");
                C8941i c8941i2 = new C8941i();
                c8941i2.m56657c(ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
                return c8941i2.m56656b();
            }
            if (str.equals(strM36488a)) {
                str = "";
            }
        }
        ProfileReq profileReq = new ProfileReq();
        if (i10 == 0) {
            profileReq.setOperation(0);
            profileReq.setType(i11);
        } else {
            profileReq.setOperation(1);
        }
        String strReportEntry = PushBiUtil.reportEntry(this.f29615a, PushNaming.PUSH_PROFILE);
        try {
            profileReq.setSubjectId(str);
            profileReq.setProfileId(C9310c.m58618b(str2));
            profileReq.setPkgName(this.f29615a.getPackageName());
            return this.f29616b.doWrite(new ProfileTask(PushNaming.PUSH_PROFILE, JsonUtil.createJsonString(profileReq), strReportEntry));
        } catch (Exception e10) {
            if (e10.getCause() instanceof ApiException) {
                C8941i c8941i3 = new C8941i();
                ApiException apiException = (ApiException) e10.getCause();
                c8941i3.m56657c(apiException);
                PushBiUtil.reportExit(this.f29615a, PushNaming.PUSH_PROFILE, strReportEntry, apiException.getStatusCode());
                return c8941i3.m56656b();
            }
            C8941i c8941i4 = new C8941i();
            Context context = this.f29615a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            PushBiUtil.reportExit(context, PushNaming.PUSH_PROFILE, strReportEntry, errorEnum);
            c8941i4.m56657c(errorEnum.toApiException());
            return c8941i4.m56656b();
        }
    }

    /* renamed from: b */
    private boolean m36489b(Context context) {
        return AbstractC6285d.m36511b(context) >= 110001400;
    }

    public static HmsProfile getInstance(Context context) {
        return new HmsProfile(context);
    }

    public Task<Void> addProfile(int i10, String str) {
        return addProfile("", i10, str);
    }

    public Task<Void> deleteProfile(String str) {
        return deleteProfile("", str);
    }

    public boolean isSupportProfile() {
        if (!AbstractC6285d.m36515d(this.f29615a)) {
            return true;
        }
        if (AbstractC6285d.m36514c()) {
            HMSLog.m36988i(f29614c, "current EMUI version below 9.1, not support profile operation.");
            return false;
        }
        if (m36489b(this.f29615a)) {
            return true;
        }
        HMSLog.m36988i(f29614c, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
        return false;
    }

    public Task<Void> addProfile(String str, int i10, String str2) {
        if (i10 != 1 && i10 != 2) {
            HMSLog.m36988i(f29614c, "add profile type undefined.");
            C8941i c8941i = new C8941i();
            c8941i.m56657c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return c8941i.m56656b();
        }
        if (!TextUtils.isEmpty(str2)) {
            return m36487a(0, str, i10, str2);
        }
        HMSLog.m36988i(f29614c, "add profile params is empty.");
        C8941i c8941i2 = new C8941i();
        c8941i2.m56657c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return c8941i2.m56656b();
    }

    public Task<Void> deleteProfile(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return m36487a(1, str, -1, str2);
        }
        HMSLog.m36986e(f29614c, "del profile params is empty.");
        C8941i c8941i = new C8941i();
        c8941i.m56657c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return c8941i.m56656b();
    }

    /* renamed from: a */
    private static String m36488a(Context context) {
        return AbstractC11229a.m67436d(context).mo66356b("client/project_id");
    }
}
