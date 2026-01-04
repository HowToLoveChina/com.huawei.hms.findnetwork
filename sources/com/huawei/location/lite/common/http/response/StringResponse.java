package com.huawei.location.lite.common.http.response;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public class StringResponse extends BaseResponse {
    private String body;

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public String getApiCode() {
        return this.code;
    }

    public String getBody() {
        return this.body;
    }

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public boolean isSuccess() {
        return TextUtils.equals(this.code, "0");
    }
}
