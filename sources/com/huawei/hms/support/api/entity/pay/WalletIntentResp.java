package com.huawei.hms.support.api.entity.pay;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class WalletIntentResp extends AbstractMessageEntity {

    @Packed
    public PendingIntent pendingIntent;

    private static <T> T get(T t10) {
        return t10;
    }

    public PendingIntent getPendingIntent() {
        return (PendingIntent) get(this.pendingIntent);
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }
}
