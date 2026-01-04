package com.huawei.android.hicloud.sync.protocol;

import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.AbstractCheckAppStatus;
import fk.C9722c;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.sync.protocol.l */
/* loaded from: classes3.dex */
public class C2933l extends AbstractCheckAppStatus<C9722c> {
    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onForcedUpgrade() throws C9722c {
        C13452e.m80781L().m80976u1();
        throw new C9722c(2201, "CheckAppStatus onForcedUpgrade");
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onSiteNotMatch() throws C9722c {
        throw new C9722c(2203, "SyncCheckAppStatus onSiteNotMatch");
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onStInvalidByServer() throws C9722c {
        C13452e.m80781L().m80972t1();
        throw new C9722c(2001, "SyncCheckAppStatus onStInvalidByServer");
    }

    @Override // com.huawei.hicloud.notification.util.AbstractCheckAppStatus
    public void onSyncRiskEffective() throws C9722c {
        C13452e.m80781L().m80992y1();
        throw new C9722c(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED, "SyncCheckAppStatus onSyncRiskEffective");
    }
}
