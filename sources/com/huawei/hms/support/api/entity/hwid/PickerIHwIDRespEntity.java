package com.huawei.hms.support.api.entity.hwid;

import android.content.Intent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public abstract class PickerIHwIDRespEntity extends AbstractMessageEntity {

    @Packed
    private Intent mData;

    @Packed
    private int mRetCode;

    public Intent getData() {
        return this.mData;
    }

    public int getRetCode() {
        return this.mRetCode;
    }

    public void setData(Intent intent) {
        this.mData = intent;
    }

    public void setRetCode(int i10) {
        this.mRetCode = i10;
    }
}
