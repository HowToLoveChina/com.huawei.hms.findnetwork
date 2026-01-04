package com.huawei.hms.support.api.tss;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* renamed from: com.huawei.hms.support.api.tss.a */
/* loaded from: classes8.dex */
public class C6401a extends AbstractClientBuilder<C6403c, TssOptions> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public AnyClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C6403c(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
