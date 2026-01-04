package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.sns.UserId;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class UserDataReq extends UserId implements IMessageEntity {
    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }
}
