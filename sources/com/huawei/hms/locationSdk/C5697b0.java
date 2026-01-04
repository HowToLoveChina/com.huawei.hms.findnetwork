package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* renamed from: com.huawei.hms.locationSdk.b0 */
/* loaded from: classes8.dex */
public class C5697b0 extends AbstractClientBuilder<C5747q0, C5765w0> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public C5747q0 buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C5747q0(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
