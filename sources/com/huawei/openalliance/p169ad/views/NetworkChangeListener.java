package com.huawei.openalliance.p169ad.views;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface NetworkChangeListener {
    void onNetworkConnectedOrChanged(boolean z10);

    void onNetworkDisconnected();
}
