package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface IPPSWebEventCallback {
    void onWebClose(int i10);

    void onWebOpen();

    void onWebloadFinish();
}
