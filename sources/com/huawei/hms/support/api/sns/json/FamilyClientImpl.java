package com.huawei.hms.support.api.sns.json;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.entity.sns.Constants;
import com.huawei.hms.support.api.entity.sns.internal.FamilyIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.GetFamilyGroupInfoResp;
import com.huawei.hms.support.api.entity.sns.internal.GetFamilyGroupMemberResp;
import com.huawei.hms.support.api.entity.sns.internal.GetUserLoginDeviceReq;
import com.huawei.hms.support.api.entity.sns.internal.GetUserLoginDeviceResp;
import com.huawei.hms.support.api.entity.sns.internal.SnsNaming;
import com.huawei.hms.support.api.entity.sns.json.SnsOutIntent;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import p000a.C0000a;

/* loaded from: classes8.dex */
public class FamilyClientImpl extends HuaweiApi<SnsOptions> implements FamilyClient {

    /* renamed from: a */
    private static final SnsClientBuilder f29908a = new SnsClientBuilder();

    /* renamed from: b */
    private static final Api<SnsOptions> f29909b = new Api<>(HuaweiApiAvailability.HMS_API_NAME_SNS);

    public FamilyClientImpl(Activity activity, SnsOptions snsOptions) {
        super(activity, f29909b, snsOptions, (AbstractClientBuilder) f29908a);
    }

    /* renamed from: a */
    private String m36799a(String str) {
        if (!C0000a.m0a(getContext())) {
            return "";
        }
        HMSLog.m36988i("FamilyClientImpl", "HiAnalyticsClient_report_Entry");
        return HiAnalyticsClient.reportEntry(getContext(), str, Constants.SNS_SDK_VERSION_CODE);
    }

    public void biReportExit(String str, String str2, int i10, int i11) {
        if (C0000a.m0a(getContext())) {
            HMSLog.m36988i("FamilyClientImpl", "HiAnalyticsClient_report_Exit");
            HiAnalyticsClient.reportExit(getContext(), str, str2, i10, i11);
        }
    }

    @Override // com.huawei.hms.support.api.sns.json.FamilyClient
    public Task<SnsOutIntent> getFamilyIntent(FamilyIntentReq familyIntentReq) {
        Checker.checkNonNull(familyIntentReq);
        return doWrite(new FamilyGetIntentTaskApiCall(SnsNaming.GET_FAMILY_INTENT, familyIntentReq.toJsonString(), m36799a(SnsNaming.GET_FAMILY_INTENT), this));
    }

    @Override // com.huawei.hms.support.api.sns.json.FamilyClient
    public Task<GetFamilyGroupInfoResp> getGroupInfo() {
        return doWrite(new FamilyGetGroupInfoTaskApiCall(SnsNaming.GET_FAMILY_GROUP_INFO, "", m36799a(SnsNaming.GET_FAMILY_GROUP_INFO), this));
    }

    @Override // com.huawei.hms.support.api.sns.json.FamilyClient
    public Task<GetFamilyGroupMemberResp> getGroupMemberList() {
        return doWrite(new FamilyGetGroupMemberTaskApiCall(SnsNaming.GET_FAMILY_GROUP_MEMBER, "", m36799a(SnsNaming.GET_FAMILY_GROUP_INFO), this));
    }

    @Override // com.huawei.hms.support.api.sns.json.FamilyClient
    public Task<GetUserLoginDeviceResp> getUserLoginDevice(GetUserLoginDeviceReq getUserLoginDeviceReq) {
        Checker.checkNonNull(getUserLoginDeviceReq);
        return doWrite(new FamilyGetUserLoginDeviceTaskApiCall(SnsNaming.GET_USER_LOGIN_DEVICE, getUserLoginDeviceReq.toJsonString(), m36799a(SnsNaming.GET_USER_LOGIN_DEVICE), this));
    }

    public FamilyClientImpl(Context context, SnsOptions snsOptions) {
        super(context, f29909b, snsOptions, f29908a);
    }
}
