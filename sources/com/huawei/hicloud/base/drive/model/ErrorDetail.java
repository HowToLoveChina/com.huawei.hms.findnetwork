package com.huawei.hicloud.base.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class ErrorDetail extends C11707b {

    @InterfaceC4648p
    private String description;

    @InterfaceC4648p
    private String domain;

    @InterfaceC4648p
    private String errorCode;

    @InterfaceC4648p
    private String reason;

    public String getDescription() {
        return this.description;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getReason() {
        return this.reason;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }
}
