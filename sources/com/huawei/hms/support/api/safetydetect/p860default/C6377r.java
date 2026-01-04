package com.huawei.hms.support.api.safetydetect.p860default;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.r */
/* loaded from: classes8.dex */
public class C6377r extends AbstractClientBuilder<C6379t, C6380u> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C6379t buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C6379t(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
