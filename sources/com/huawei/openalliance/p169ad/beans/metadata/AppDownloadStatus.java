package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.download.app.AppStatus;

@DataKeep
/* loaded from: classes8.dex */
public class AppDownloadStatus {
    private static final String DOWNLOAD = "download";
    private static final String DOWNLOADING = "downloading";
    private static final String INSTALL = "install";
    private static final String INSTALLED = "installed";
    private static final String INSTALLING = "installing";
    private static final String PAUSE = "pause";
    private static final String UNKNOWN = "unknown";
    private String status = "unknown";
    private int percentage = 0;

    /* renamed from: a */
    public String m39856a() {
        return this.status;
    }

    /* renamed from: a */
    public void m39857a(int i10) {
        this.percentage = i10;
    }

    /* renamed from: a */
    public final void m39858a(AppStatus appStatus) {
        String str;
        if (AppStatus.INSTALLED == appStatus) {
            str = INSTALLED;
        } else if (AppStatus.DOWNLOAD == appStatus) {
            str = "download";
        } else if (AppStatus.DOWNLOADING == appStatus) {
            str = DOWNLOADING;
        } else if (AppStatus.PAUSE == appStatus || AppStatus.WAITING_FOR_WIFI == appStatus) {
            str = "pause";
        } else if (AppStatus.INSTALLING == appStatus) {
            str = "installing";
        } else if (AppStatus.INSTALL != appStatus) {
            return;
        } else {
            str = "install";
        }
        this.status = str;
    }
}
