package com.huawei.hms.findnetwork.comm.client;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* loaded from: classes8.dex */
public class FindClientBuilder extends AbstractClientBuilder<FindHmsClient, FindOptions> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public FindHmsClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new FindHmsClient(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
