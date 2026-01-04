package com.huawei.hms.support.api.sns;

import android.content.Intent;
import com.huawei.hms.support.api.client.Result;

/* loaded from: classes8.dex */
public class IntentResult extends Result {
    private Intent intent;

    public Intent getIntent() {
        return this.intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
