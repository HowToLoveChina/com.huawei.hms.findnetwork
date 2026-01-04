package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.sns.UserUnreadMsg;

/* loaded from: classes8.dex */
public class GetUserUnreadMsgResp implements IMessageEntity {

    @Packed
    private UserUnreadMsg userUnreadMsg;

    public UserUnreadMsg getUserUnreadMsg() {
        return this.userUnreadMsg;
    }

    public void setUserUnreadMsg(UserUnreadMsg userUnreadMsg) {
        this.userUnreadMsg = userUnreadMsg;
    }
}
