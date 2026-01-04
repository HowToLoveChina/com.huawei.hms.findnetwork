package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class GroupMemListReq implements IMessageEntity {

    @Packed
    private long groupId;

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j10) {
        this.groupId = j10;
    }

    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }
}
