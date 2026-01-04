package com.huawei.hms.support.api.pay;

import com.huawei.hms.support.api.client.Result;

/* loaded from: classes8.dex */
public class HwWalletInfoResult extends Result {
    private String result;

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
