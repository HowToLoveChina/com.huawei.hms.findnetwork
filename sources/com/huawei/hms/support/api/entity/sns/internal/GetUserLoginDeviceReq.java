package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class GetUserLoginDeviceReq implements IMessageEntity {

    @Packed
    private String accessToken;

    @Packed
    private String userId;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }
}
