package com.huawei.hms.network.embedded;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.network.inner.api.NetworkReceiver;

/* renamed from: com.huawei.hms.network.embedded.m1 */
/* loaded from: classes8.dex */
public class C6004m1 implements NetworkReceiver {

    /* renamed from: a */
    public C5991l1 f27471a;

    public C6004m1(C5991l1 c5991l1) {
        this.f27471a = c5991l1;
    }

    @Override // com.huawei.hms.network.inner.api.NetworkReceiver
    public void onReceiveMsg(Context context, Intent intent) {
        C5991l1 c5991l1 = this.f27471a;
        if (c5991l1 != null) {
            c5991l1.processNetworkReceiveMsg();
        }
    }
}
