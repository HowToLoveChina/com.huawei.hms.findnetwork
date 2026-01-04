package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class UiIntentReq implements IMessageEntity {

    @Packed
    private long param;

    @Packed
    private int type;

    public long getParam() {
        return this.param;
    }

    public int getType() {
        return this.type;
    }

    public void setParam(long j10) {
        this.param = j10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public String toJsonString() {
        return "{'type':" + this.type + ",'param':" + this.param + "}";
    }
}
