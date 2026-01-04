package com.huawei.hms.hwid;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.support.account.request.AccountAuthParams;

/* renamed from: com.huawei.hms.hwid.d */
/* loaded from: classes8.dex */
public class C5605d extends AbstractClientBuilder<C5604c, AccountAuthParams> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C5604c buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new C5604c(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
