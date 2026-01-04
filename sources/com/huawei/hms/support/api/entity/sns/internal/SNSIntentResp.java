package com.huawei.hms.support.api.entity.sns.internal;

import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class SNSIntentResp implements IMessageEntity {

    @Packed
    private Intent intent;

    public Intent getIntent() {
        return this.intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
