package com.huawei.hms.ads.installreferrer.api;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes8.dex */
public interface InstallReferrerStateListener {
    @Keep
    void onInstallReferrerServiceDisconnected();

    @Keep
    void onInstallReferrerSetupFinished(int i10);
}
