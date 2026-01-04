package com.huawei.hms.support.hwid.p138a;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* renamed from: com.huawei.hms.support.hwid.a.b */
/* loaded from: classes8.dex */
public class C6446b extends AbstractClientBuilder<C6445a, Object> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C6445a buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C6445a(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
