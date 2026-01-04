package com.huawei.hicloud.notification.util;

import com.huawei.hicloud.model.AccountConstant;
import fk.C9721b;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class CheckAppStatus extends AbstractCheckAppStatus<C9721b> {
    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onForcedUpgrade() throws C9721b {
        C13452e.m80781L().m80976u1();
        throw new C9721b(4011, "forced upgrade error", "CheckAppStatus onForcedUpgrade");
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onSiteNotMatch() throws C9721b {
        throw new C9721b(AccountConstant.Err.SMS_SERVICE_FAILED_APP_NOT_AUTHORIZED, "site not match error", "CheckAppStatus onSiteNotMatch");
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onStInvalidByServer() throws C9721b {
        C13452e.m80781L().m80972t1();
        throw new C9721b(1102, "service token invalid.", "CheckAppStatus onStInvalidByServer");
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onSyncRiskEffective() throws C9721b {
        C13452e.m80781L().m80992y1();
        throw new C9721b(4008, "sync risk error.", "CheckAppStatus onSyncRiskEffective");
    }
}
