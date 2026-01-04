package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class FollowPublicUserReq implements IMessageEntity {

    @Packed
    private boolean isManual;

    @Packed
    private long publicUid;

    public long getPublicUid() {
        return this.publicUid;
    }

    public boolean isManual() {
        return this.isManual;
    }

    public void setManual(boolean z10) {
        this.isManual = z10;
    }

    public void setPublicUid(long j10) {
        this.publicUid = j10;
    }

    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }
}
