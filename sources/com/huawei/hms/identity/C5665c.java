package com.huawei.hms.identity;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* renamed from: com.huawei.hms.identity.c */
/* loaded from: classes8.dex */
public class C5665c extends AbstractClientBuilder<C5664b, C5667e> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    /* renamed from: a */
    public C5664b buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C5664b(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
