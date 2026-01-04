package com.huawei.hms.hwid;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;

/* renamed from: com.huawei.hms.hwid.v */
/* loaded from: classes8.dex */
public class C5624v extends AbstractClientBuilder<C5623u, HuaweiIdAuthParams> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C5623u buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C5623u(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
