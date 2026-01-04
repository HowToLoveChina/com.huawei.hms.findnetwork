package com.huawei.openalliance.p169ad.download.p172ag;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;

@DataKeep
/* loaded from: classes2.dex */
public class RemoteAppDownloadTask {
    private boolean autoOpenInLandingPage;
    private String contentId;
    private long downloadedSize;
    private long fileTotalSize;
    private int pauseReason;
    private int progress;
    private String sha256;
    private String slotId;
    private int status;
    private String url;

    /* renamed from: a */
    public AppDownloadTask m42104a(AppInfo appInfo) {
        AppDownloadTask appDownloadTaskM42269a = new AppDownloadTask.C7040a().m42265a(appInfo).m42269a();
        if (appDownloadTaskM42269a == null) {
            appDownloadTaskM42269a = new AppDownloadTask();
            appDownloadTaskM42269a.m42243a(appInfo);
        }
        appDownloadTaskM42269a.m42260m(this.contentId);
        appDownloadTaskM42269a.m42059b(this.progress);
        appDownloadTaskM42269a.m42054a(EnumC7062e.m42595a(this.status));
        appDownloadTaskM42269a.m42060b(this.downloadedSize);
        appDownloadTaskM42269a.m42047a(this.fileTotalSize);
        appDownloadTaskM42269a.m42056a(this.url);
        appDownloadTaskM42269a.m42066c(this.sha256);
        appDownloadTaskM42269a.m42258k(this.slotId);
        appDownloadTaskM42269a.m42053a(DownloadTask.EnumC7031c.m42097a(this.pauseReason));
        appDownloadTaskM42269a.m42253f(this.autoOpenInLandingPage);
        return appDownloadTaskM42269a;
    }
}
