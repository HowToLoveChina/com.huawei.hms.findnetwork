package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.identity.AddressConstants;

/* loaded from: classes2.dex */
public class UserTokenErrRsp {

    @SerializedName(AddressConstants.Extras.EXTRA_NAME_ERR_CODE)
    private int errorCode;

    @SerializedName("errorInfo")
    private String errorInfo;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setErrorInfo(String str) {
        this.errorInfo = str;
    }
}
