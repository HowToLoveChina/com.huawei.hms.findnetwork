package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class UserSearchReq implements IMessageEntity {

    @Packed
    private String account;

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }
}
