package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.AppStatusV1;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;

@DataKeep
/* loaded from: classes8.dex */
public class AppDownloadInfo {
    private String appName;
    private int code;
    private String packageName;
    private int progress;
    private int reserveStatus;
    private String reservedPkgName;
    private String status;
    private long time;
    private String uniqueId;

    public AppDownloadInfo(AppInfo appInfo, int i10) {
        m30364a(appInfo);
        this.progress = i10;
    }

    /* renamed from: a */
    private void m30364a(AppInfo appInfo) {
        if (appInfo != null) {
            this.packageName = appInfo.getPackageName();
            this.appName = appInfo.getAppName();
            this.uniqueId = appInfo.getUniqueId();
            this.time = System.currentTimeMillis();
        }
    }

    public AppDownloadInfo(AppInfo appInfo, AppStatus appStatus) {
        m30364a(appInfo);
        if (appStatus != null) {
            this.status = appStatus.toString();
        }
    }

    public AppDownloadInfo(AppInfo appInfo, AppStatusV1 appStatusV1, int i10) {
        if (appInfo != null) {
            this.packageName = appInfo.getPackageName();
            this.appName = appInfo.getAppName();
        }
        if (appStatusV1 != null) {
            this.status = appStatusV1.toString();
        }
        this.code = i10;
    }

    public AppDownloadInfo(String str, int i10) {
        this.reservedPkgName = str;
        this.reserveStatus = i10;
    }
}
