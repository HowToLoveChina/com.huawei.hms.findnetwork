package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class BaseReq implements IMessageEntity {

    @Packed
    protected String reservedInfor;

    public String getReservedInfor() {
        return this.reservedInfor;
    }

    public void setReservedInfor(String str) {
        this.reservedInfor = str;
    }
}
