package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class UserSearchResp implements IMessageEntity {

    @Packed
    private long userId;

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j10) {
        this.userId = j10;
    }
}
