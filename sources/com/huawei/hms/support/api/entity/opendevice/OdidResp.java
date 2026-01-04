package com.huawei.hms.support.api.entity.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class OdidResp extends AbstractMessageEntity {

    /* renamed from: id */
    @Packed
    private String f29795id;

    public String getId() {
        return this.f29795id;
    }

    public void setId(String str) {
        this.f29795id = str;
    }
}
