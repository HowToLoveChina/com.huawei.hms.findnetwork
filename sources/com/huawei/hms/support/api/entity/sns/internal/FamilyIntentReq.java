package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class FamilyIntentReq implements IMessageEntity {

    @Packed
    private String accountName;

    @Packed
    private int type;

    public FamilyIntentReq() {
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getType() {
        return this.type;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }

    public FamilyIntentReq(int i10) {
        this.type = i10;
    }
}
