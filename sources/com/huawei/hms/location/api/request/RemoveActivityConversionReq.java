package com.huawei.hms.location.api.request;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class RemoveActivityConversionReq extends BaseLocationReq {

    @Packed
    private String moduleName;

    public String getModuleName() {
        return this.moduleName;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }
}
