package com.huawei.hicloud.cloudbackup.server.model;

/* loaded from: classes6.dex */
public class RestoreApkAgdDownloadState {
    public static final String APP_STATUS_TYPE_DOWNLOAD_FAILED = "DOWNLOADFAILED";
    public static final String APP_STATUS_TYPE_INSTALLED = "INSTALLED";
    public static final int CANCEL_DOWNLOAD = 3;
    public static final int DOWNLOAD = 2;
    public static final int DOWNLOADED = 4;
    private static final int DOWNLOAD_EXCEPTION = 8;
    public static final int DOWNLOAD_FAILED = 5;
    private static final int DOWNLOAD_MERGE = 7;
    public static final int DOWNLOAD_PAUSED = 6;
    public static final int DOWNLOAD_STATUS_TYPE = 2;
    public static final int INSTALL_LOW_VERSION = -3;
    public static final int INSTALL_SERVICE_INSTALLING = 1;
    public static final int INSTALL_SERVICE_INSTALL_FAILED = -1;
    public static final int INSTALL_SERVICE_INSTALL_SUCCESS = 2;
    public static final int INSTALL_SERVICE_SILENT_INSTALL_FAILED = -2;
    public static final int INSTALL_SERVICE_WAIT_INSTALL = 0;
    public static final int INSTALL_STATUS_TYPE = 1;
    public static final int PRE_DOWNLOAD = 1;
    public static final int REDOWNLOAD_START_IN_HTTPS = 10;
    public static final int WAIT_DOWNLOAD = 0;
    public static final int WAIT_FOR_WIFI = -1;
    private int appStatus;
    private int appStatusType;
    private String packageName;
    private int progress;

    public RestoreApkAgdDownloadState(String str, int i10, int i11, int i12) {
        this.packageName = str;
        this.appStatus = i10;
        this.progress = i11;
        this.appStatusType = i12;
    }

    public int getAppStatus() {
        return this.appStatus;
    }

    public int getAppStatusType() {
        return this.appStatusType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setAppStatus(int i10) {
        this.appStatus = i10;
    }

    public void setAppStatusType(int i10) {
        this.appStatusType = i10;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setProgress(int i10) {
        this.progress = i10;
    }

    public String toString() {
        return "RestoreApkAgdDownloadState{packageName='" + this.packageName + "', appStatus=" + this.appStatus + ", progress=" + this.progress + ", appStatusType=" + this.appStatusType + '}';
    }
}
