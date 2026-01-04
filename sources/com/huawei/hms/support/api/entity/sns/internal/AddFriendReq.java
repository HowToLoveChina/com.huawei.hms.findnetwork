package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.sns.UserId;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class AddFriendReq extends UserId implements IMessageEntity {

    @Packed
    private String remark;

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }
}
