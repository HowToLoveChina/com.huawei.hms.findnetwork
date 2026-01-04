package com.huawei.hicloud.model.request;

import com.huawei.hicloud.model.AccountConstant;

/* loaded from: classes6.dex */
public class SMSLoginReq extends Request {
    private String authCode;

    public SMSLoginReq(String str) {
        super(AccountConstant.Cmd.SMS_LOGIN);
        this.authCode = str;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }
}
