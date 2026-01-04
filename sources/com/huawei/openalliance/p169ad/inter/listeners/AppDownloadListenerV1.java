package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.download.app.AppStatusV1;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;

@OuterVisible
/* loaded from: classes2.dex */
public interface AppDownloadListenerV1 {
    void onNewAppOpen(AppInfo appInfo);

    void onNewAppOpen(String str);

    void onNewDownloadProgress(AppInfo appInfo, int i10);

    void onNewStatusChanged(AppStatusV1 appStatusV1, int i10, AppInfo appInfo);
}
