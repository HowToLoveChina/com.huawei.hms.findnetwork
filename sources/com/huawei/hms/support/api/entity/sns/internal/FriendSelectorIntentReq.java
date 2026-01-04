package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class FriendSelectorIntentReq implements IMessageEntity {

    @Packed
    private boolean singleChoice;

    public boolean isSingleChoice() {
        return this.singleChoice;
    }

    public void setSingleChoice(boolean z10) {
        this.singleChoice = z10;
    }

    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }
}
