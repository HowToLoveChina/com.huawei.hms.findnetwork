package com.huawei.android.hicloud.agd.ads;

/* loaded from: classes2.dex */
public class DownLoadState {
    public static final String APP_STATUS_TYPE_DOWNLOAD_FAILED = "DOWNLOADFAILED";
    public static final String APP_STATUS_TYPE_INSTALLED = "INSTALLED";
    private static final int CANCEL_DOWNLOAD = 3;
    private static final int DOWNLOAD = 2;
    private static final int DOWNLOADED = 4;
    private static final int DOWNLOAD_EXCEPTION = 8;
    public static final int DOWNLOAD_FAILED = 5;
    private static final int DOWNLOAD_MERGE = 7;
    public static final int DOWNLOAD_PAUSED = 6;
    public static final int DOWNLOAD_STATUS_TYPE = 2;
    private static final int INSTALL_SERVICE_INSTALLING = 1;
    private static final int INSTALL_SERVICE_INSTALL_FAILED = -1;
    private static final int INSTALL_SERVICE_INSTALL_SUCCESS = 2;
    private static final int INSTALL_SERVICE_SILENT_INSTALL_FAILED = -2;
    private static final int INSTALL_SERVICE_WAIT_INSTALL = 0;
    public static final int INSTALL_STATUS_TYPE = 1;
    private static final int PRE_DOWNLOAD = 1;
    private static final int REDOWNLOAD_START_IN_HTTPS = 10;
    private static final int WAIT_DOWNLOAD = 0;
    private static final int WAIT_FOR_WIFI = -1;
    private AppDownloadInfo appDownloadInfo;
    private int appStatus;
    private int appStatusType;
    private int progress;

    public DownLoadState(AppDownloadInfo appDownloadInfo, int i10, int i11, int i12) {
        this.appDownloadInfo = appDownloadInfo;
        this.appStatus = i10;
        this.progress = i11;
        this.appStatusType = i12;
    }

    private String transAppDownloadStatus() {
        switch (this.appStatus) {
            case -1:
            case 6:
            case 8:
                return "PAUSE";
            case 0:
            case 1:
                return "WAITING";
            case 2:
            case 7:
                return "DOWNLOADING";
            case 3:
                return "CANCEL";
            case 4:
                return "DOWNLOADED";
            case 5:
            default:
                return "DOWNLOADFAILED";
        }
    }

    private String transAppInstallStatus() {
        int i10 = this.appStatus;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? "INSTALLFAILED" : "INSTALLED" : "INSTALLING" : "WAITING";
    }

    public AppDownloadInfo getAppDownloadInfo() {
        AppDownloadInfo appDownloadInfo = this.appDownloadInfo;
        return appDownloadInfo == null ? new AppDownloadInfo("", "", "", "") : appDownloadInfo;
    }

    public int getAppStatus() {
        return this.appStatus;
    }

    public int getAppStatusType() {
        return this.appStatusType;
    }

    public int getProgress() {
        return this.progress;
    }

    public boolean isDownloadStatus() {
        return this.appStatusType == 2;
    }

    public boolean isDownloadedStatus() {
        return isDownloadStatus() && this.appStatus == 4;
    }

    public boolean isTerminalType() {
        if (this.appStatusType == 1) {
            int i10 = this.appStatus;
            return i10 == -1 || i10 == -2;
        }
        int i11 = this.appStatus;
        return i11 == 6 || i11 == 8 || i11 == 3 || i11 == 5;
    }

    public void setAppDownloadInfo(AppDownloadInfo appDownloadInfo) {
        this.appDownloadInfo = appDownloadInfo;
    }

    public void setAppStatus(int i10) {
        this.appStatus = i10;
    }

    public void setAppStatusType(int i10) {
        this.appStatusType = i10;
    }

    public void setProgress(int i10) {
        this.progress = i10;
    }

    public String transAppStatus() {
        return this.appStatusType == 1 ? transAppInstallStatus() : transAppDownloadStatus();
    }

    public DownLoadState(AppDownloadInfo appDownloadInfo) {
        this.appDownloadInfo = appDownloadInfo;
    }
}
