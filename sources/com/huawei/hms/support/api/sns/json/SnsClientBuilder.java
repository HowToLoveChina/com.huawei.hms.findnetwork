package com.huawei.hms.support.api.sns.json;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* loaded from: classes8.dex */
public class SnsClientBuilder extends AbstractClientBuilder<SnsHmsClient, SnsOptions> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public SnsHmsClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new SnsHmsClient(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
