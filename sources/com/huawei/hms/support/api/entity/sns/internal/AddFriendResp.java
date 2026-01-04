package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class AddFriendResp implements IMessageEntity {

    @Packed
    private int result;

    public int getResult() {
        return this.result;
    }

    public void setResult(int i10) {
        this.result = i10;
    }
}
