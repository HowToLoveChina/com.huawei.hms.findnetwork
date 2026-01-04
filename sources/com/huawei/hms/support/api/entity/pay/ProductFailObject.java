package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class ProductFailObject implements IMessageEntity {

    @Packed
    public int code;

    @Packed
    public String msg;

    @Packed
    public String productNo;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getProductNo() {
        return this.productNo;
    }
}
