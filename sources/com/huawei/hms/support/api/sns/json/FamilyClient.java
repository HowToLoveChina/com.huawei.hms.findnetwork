package com.huawei.hms.support.api.sns.json;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.api.entity.sns.internal.FamilyIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.GetFamilyGroupInfoResp;
import com.huawei.hms.support.api.entity.sns.internal.GetFamilyGroupMemberResp;
import com.huawei.hms.support.api.entity.sns.internal.GetUserLoginDeviceReq;
import com.huawei.hms.support.api.entity.sns.internal.GetUserLoginDeviceResp;
import com.huawei.hms.support.api.entity.sns.json.SnsOutIntent;

/* loaded from: classes8.dex */
public interface FamilyClient {
    Task<SnsOutIntent> getFamilyIntent(FamilyIntentReq familyIntentReq);

    Task<GetFamilyGroupInfoResp> getGroupInfo();

    Task<GetFamilyGroupMemberResp> getGroupMemberList();

    Task<GetUserLoginDeviceResp> getUserLoginDevice(GetUserLoginDeviceReq getUserLoginDeviceReq);
}
