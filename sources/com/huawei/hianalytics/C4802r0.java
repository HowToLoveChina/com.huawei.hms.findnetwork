package com.huawei.hianalytics;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* renamed from: com.huawei.hianalytics.r0 */
/* loaded from: classes5.dex */
public class C4802r0 extends AbstractClientBuilder<C4806t0, C4810v0> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public AnyClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C4806t0(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
