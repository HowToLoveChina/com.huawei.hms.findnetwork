package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class StartIapActivityReq implements IMessageEntity {
    public static final int TYPE_PAYINFO_ACTIVITY = 1;
    public static final int TYPE_SUBSCRIBE_EDIT_ACTIVITY = 3;
    public static final int TYPE_SUBSCRIBE_MANAGER_ACTIVITY = 2;

    @Packed
    private String subscribeProductId;

    @Packed
    private int type;

    public String getSubscribeProductId() {
        return this.subscribeProductId;
    }

    public int getType() {
        return this.type;
    }

    public void setSubscribeProductId(String str) {
        this.subscribeProductId = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
