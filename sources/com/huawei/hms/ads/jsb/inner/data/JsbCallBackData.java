package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class JsbCallBackData<T> {
    private String callBackName;
    private boolean complete;
    private T data;

    public JsbCallBackData(T t10, boolean z10, String str) {
        this.complete = z10;
        this.data = t10;
        this.callBackName = str;
    }
}
