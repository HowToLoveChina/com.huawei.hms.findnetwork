package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

/* loaded from: classes9.dex */
public interface CheckUpdateCallBack {
    void onMarketInstallInfo(Intent intent);

    void onMarketStoreError(int i10);

    void onUpdateInfo(Intent intent);

    void onUpdateStoreError(int i10);
}
