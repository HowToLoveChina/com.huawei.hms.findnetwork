package com.huawei.openalliance.p169ad.activity;

import android.os.Bundle;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7402ll;

/* loaded from: classes8.dex */
public class PPSNotificationActivity extends AbstractActivityC6906f {
    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AbstractC7185ho.m43820b("PPSNotificationActivity", "PPSNotificationActivity activity");
        C7402ll.m45597a(this).m45600a(this, getIntent());
        finish();
    }
}
