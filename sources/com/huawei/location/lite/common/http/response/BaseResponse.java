package com.huawei.location.lite.common.http.response;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hms.identity.AddressConstants;

/* loaded from: classes8.dex */
public abstract class BaseResponse {

    @SerializedName(alternate = {"code", "returnCode"}, value = AddressConstants.Extras.EXTRA_NAME_ERR_CODE)
    protected String code;

    @SerializedName(alternate = {"message", "returnDesc"}, value = C2126b.ERROR_MESSAGE_INFO)
    protected String msg;

    public abstract String getApiCode();

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return "0".equals(this.code);
    }
}
