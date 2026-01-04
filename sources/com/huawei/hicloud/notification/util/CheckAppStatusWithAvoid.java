package com.huawei.hicloud.notification.util;

import com.huawei.hicloud.model.AccountConstant;
import fk.C9721b;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class CheckAppStatusWithAvoid extends AbstractCheckAppStatus<C9721b> {
    private boolean isNotCloudDrive;
    private boolean needExecute;

    public CheckAppStatusWithAvoid(boolean z10, boolean z11) {
        this.isNotCloudDrive = z10;
        this.needExecute = z11;
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onForcedUpgrade() throws C9721b {
        if (this.isNotCloudDrive) {
            C13452e.m80781L().m80976u1();
        } else if (this.needExecute) {
            C13452e.m80781L().m80980v1();
            C13452e.m80781L().m80976u1();
        }
        throw new C9721b(4011, "forced upgrade error.", "onForcedUpgrade");
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onSiteNotMatch() throws C9721b {
        throw new C9721b(AccountConstant.Err.SMS_SERVICE_FAILED_APP_NOT_AUTHORIZED, "site not match error.", "onSiteNotMatch");
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onStInvalidByServer() throws C9721b {
        if (this.isNotCloudDrive) {
            C13452e.m80781L().m80972t1();
        } else if (this.needExecute) {
            C13452e.m80781L().m80980v1();
            C13452e.m80781L().m80972t1();
        }
        throw new C9721b(1102, "check local st is invalid", "checkSTInvalid");
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onSyncRiskEffective() throws C9721b {
        if (this.isNotCloudDrive) {
            C13452e.m80781L().m80992y1();
        } else if (this.needExecute) {
            C13452e.m80781L().m80984w1(true);
            C13452e.m80781L().m80992y1();
        }
        throw new C9721b(4008, "sync risk error.", "onSyncRiskEffective");
    }
}
