package com.huawei.hms.support.api.pay;

import android.app.PendingIntent;
import com.huawei.hms.support.api.client.Result;

/* loaded from: classes8.dex */
public class GetWalletUiIntentResult extends Result {
    private PendingIntent pendingIntent;

    public PendingIntent getPindingIntent() {
        return this.pendingIntent;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }
}
