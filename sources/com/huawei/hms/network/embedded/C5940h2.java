package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.util.Date;
import java.util.concurrent.Executor;
import org.chromium.net.NetworkQualityRttListener;

/* renamed from: com.huawei.hms.network.embedded.h2 */
/* loaded from: classes8.dex */
public class C5940h2 extends NetworkQualityRttListener {

    /* renamed from: a */
    public static final String f26914a = "CronetNetworkQualityRtt";

    public C5940h2(Executor executor) {
        super(executor);
    }

    @Override // org.chromium.net.NetworkQualityRttListener
    public void onRttObservation(int i10, long j10, int i11) {
        Logger.m32144v(f26914a, "onRttObservation[%s]: %d, %d", new Date(j10).toString(), Integer.valueOf(i10), Integer.valueOf(i11));
    }
}
