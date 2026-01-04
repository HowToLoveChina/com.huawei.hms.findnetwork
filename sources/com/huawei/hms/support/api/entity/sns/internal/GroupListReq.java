package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class GroupListReq implements IMessageEntity {

    @Packed
    private int groupType;

    public int getGroupType() {
        return this.groupType;
    }

    public void setGroupType(int i10) {
        this.groupType = i10;
    }

    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }
}
