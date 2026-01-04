package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* renamed from: com.huawei.hms.iap.entity.c */
/* loaded from: classes8.dex */
public class C5636c extends AbstractMessageEntity {

    @Packed
    private String errMsg;

    @Packed
    private Boolean isSandboxApk;

    @Packed
    private Boolean isSandboxUser;

    @Packed
    private int returnCode;

    @Packed
    private String versionFrMarket;

    @Packed
    private String versionInApk;

    public String getErrMsg() {
        return this.errMsg;
    }

    public Boolean getIsSandboxApk() {
        return this.isSandboxApk;
    }

    public Boolean getIsSandboxUser() {
        return this.isSandboxUser;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getVersionFrMarket() {
        return this.versionFrMarket;
    }

    public String getVersionInApk() {
        return this.versionInApk;
    }
}
