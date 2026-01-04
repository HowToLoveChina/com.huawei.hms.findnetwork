package com.huawei.location.lite.common.config;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.http.response.BaseResponse;
import java.util.ArrayList;
import p588qr.C12391c;

/* loaded from: classes8.dex */
public class ConfigResponseData extends BaseResponse {

    @SerializedName("data")
    private ArrayList<C12391c> data;

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public String getApiCode() {
        return String.valueOf(this.code);
    }

    public ArrayList<C12391c> getData() {
        return this.data;
    }

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public boolean isSuccess() {
        return TextUtils.equals(this.code, "0") || TextUtils.isEmpty(this.code);
    }
}
