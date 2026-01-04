package com.huawei.android.hicloud.cloudbackup.broadcast;

/* loaded from: classes2.dex */
public class BroadcastConstants {
    public static final String CLOUD_BACKUP_RESTORE_STATE_ACTION = "com.huawei.hidisk.action.cloudbackup.backupstate";
    public static final String DOWNLOAD_EVENT_ACTION = "com.huawei.hidisk.cloudbackup.downloadservice.Receiver";
    public static final String DOWNLOAD_PROGRESS_ACTION = "com.huawei.hidisk.cloudbackup.downloadservice.progress.Receiver";
    public static final int DOWNLOAD_STATUS_CANCEL = 3;
    public static final int DOWNLOAD_STATUS_DOING = 2;
    public static final int DOWNLOAD_STATUS_DONE = 4;
    public static final int DOWNLOAD_STATUS_EXCEPTION = 8;
    public static final int DOWNLOAD_STATUS_FAILED = 5;
    public static final int DOWNLOAD_STATUS_PAUSED = 6;
    public static final int DOWNLOAD_STATUS_WAIT = 0;
    public static final String INSTALL_EVENT_ACTION = "com.huawei.hidisk.cloudbackup.installerservice.Receiver";
    public static final int INSTALL_STATUS_DOING = 1;
    public static final int INSTALL_STATUS_FAILED = -1;
    public static final int INSTALL_STATUS_SUCC = 2;
    public static final int INSTALL_STATUS_WAIT = 0;
    public static final String RESTORE_CANCEL_ACTION = "com.huawei.hidisk.cloudbackup.downloadservice.cancelrestore";
    public static final String RESTORE_LAUNCHER_END_ACTION = "com.huawei.android.launcher.intent.action.cloudbackup.over";
    public static final String RESTORE_LAUNCHER_START_ACTION = "com.huawei.android.launcher.intent.action.cloudbackup.start";
}
