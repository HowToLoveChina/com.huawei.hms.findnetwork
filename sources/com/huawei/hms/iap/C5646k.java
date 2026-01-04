package com.huawei.hms.iap;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.iap.entity.C5636c;
import com.huawei.hms.iap.entity.IsSandboxActivatedResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.k */
/* loaded from: classes8.dex */
public class C5646k extends AbstractC5629a<C5642g, IsSandboxActivatedResult> {
    public C5646k(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public int mo32976a() {
        return 40002000;
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public void mo32981a(C8941i<IsSandboxActivatedResult> c8941i, ResponseErrorCode responseErrorCode, String str) throws IllegalArgumentException {
        HMSLog.m36988i("IsSandboxActivatedTaskApiCall", "dealSuccess");
        C5636c c5636c = new C5636c();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonToEntity(str, c5636c);
        }
        IsSandboxActivatedResult isSandboxActivatedResult = new IsSandboxActivatedResult();
        isSandboxActivatedResult.setReturnCode(c5636c.getReturnCode());
        isSandboxActivatedResult.setErrMsg(c5636c.getErrMsg());
        isSandboxActivatedResult.setIsSandboxUser(c5636c.getIsSandboxUser());
        isSandboxActivatedResult.setIsSandboxApk(c5636c.getIsSandboxApk());
        isSandboxActivatedResult.setVersionInApk(c5636c.getVersionInApk());
        isSandboxActivatedResult.setVersionFrMarket(c5636c.getVersionFrMarket());
        isSandboxActivatedResult.setStatus(new Status(responseErrorCode.getStatusCode(), responseErrorCode.getErrorReason()));
        c8941i.m56658d(isSandboxActivatedResult);
    }
}
