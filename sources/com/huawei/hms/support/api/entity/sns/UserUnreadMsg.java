package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class UserUnreadMsg implements IMessageEntity {

    @Packed
    private int friendMsg;

    public int getFriendMsg() {
        return this.friendMsg;
    }

    public void setFriendMsg(int i10) {
        this.friendMsg = i10;
    }
}
