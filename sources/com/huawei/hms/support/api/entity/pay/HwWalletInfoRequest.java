package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class HwWalletInfoRequest implements IMessageEntity {

    @Packed
    public String merchantId;

    @Packed
    public String queryFlag;

    private static <T> T get(T t10) {
        return t10;
    }

    public String getMerchantId() {
        return (String) get(this.merchantId);
    }

    public String getQueryFlag() {
        return (String) get(this.queryFlag);
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public void setQueryFlag(String str) {
        this.queryFlag = str;
    }
}
