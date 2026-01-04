package com.huawei.hicloud.base.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Error extends C11707b {

    @InterfaceC4648p
    private Integer code;

    @InterfaceC4648p
    private String description;

    @InterfaceC4648p
    private List<ErrorDetail> errorDetail;

    public Integer getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public List<ErrorDetail> getErrorDetail() {
        return this.errorDetail;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setErrorDetail(List<ErrorDetail> list) {
        this.errorDetail = list;
    }
}
