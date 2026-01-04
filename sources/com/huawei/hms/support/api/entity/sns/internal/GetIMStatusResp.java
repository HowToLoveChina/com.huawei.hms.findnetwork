package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class GetIMStatusResp implements IMessageEntity {

    @Packed
    private int onlineStatus;

    public int getOnlineStatus() {
        return this.onlineStatus;
    }

    public void setOnlineStatus(int i10) {
        this.onlineStatus = i10;
    }
}
