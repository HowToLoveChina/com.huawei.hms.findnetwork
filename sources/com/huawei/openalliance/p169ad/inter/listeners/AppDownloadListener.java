package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;

@OuterVisible
/* loaded from: classes2.dex */
public interface AppDownloadListener {
    void onAppOpen(AppInfo appInfo);

    void onAppOpen(String str);

    void onDownloadProgress(AppInfo appInfo, int i10);

    void onStatusChanged(AppStatus appStatus, AppInfo appInfo);

    void onUserCancel(AppInfo appInfo);
}
