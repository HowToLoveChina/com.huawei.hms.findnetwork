package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.sns.UnreadMsg;

/* loaded from: classes8.dex */
public class GetUnreadMsgResp implements IMessageEntity {

    @Packed
    private UnreadMsg unreadMsg;

    public UnreadMsg getUnreadMsg() {
        return this.unreadMsg;
    }

    public void setUnreadMsg(UnreadMsg unreadMsg) {
        this.unreadMsg = unreadMsg;
    }
}
