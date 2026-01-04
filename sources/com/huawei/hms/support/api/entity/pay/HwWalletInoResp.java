package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class HwWalletInoResp extends AbstractMessageEntity {

    @Packed
    public String result;

    private static <T> T get(T t10) {
        return t10;
    }

    public String getResult() {
        return (String) get(this.result);
    }

    public void setResult(String str) {
        this.result = str;
    }
}
