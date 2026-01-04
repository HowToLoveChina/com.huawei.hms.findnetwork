package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.sns.UnreadMsg;

/* loaded from: classes8.dex */
public class UnreadMsgCountResult extends Result {
    private UnreadMsg unreadMsg;

    public UnreadMsg getUnreadMsg() {
        return this.unreadMsg;
    }

    public void setUnreadMsg(UnreadMsg unreadMsg) {
        this.unreadMsg = unreadMsg;
    }
}
