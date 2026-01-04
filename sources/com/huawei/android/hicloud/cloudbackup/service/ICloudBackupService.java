package com.huawei.android.hicloud.cloudbackup.service;

import android.os.Handler;

/* loaded from: classes2.dex */
interface ICloudBackupService {
    void abort();

    boolean backup(boolean z10, boolean z11);

    boolean cancelRefurbish();

    void cloudbackupOpr(boolean z10);

    boolean deleteRecord(String str, boolean z10);

    boolean deleteSingleRecord(String str, int i10, String str2);

    boolean getState();

    boolean queryCurrentRecord(String str);

    boolean refreshBackupTimes(boolean z10);

    boolean register(Handler.Callback callback);

    boolean restore(String str, int i10, String str2, int i11);

    boolean restoreLast(boolean z10);

    boolean restoreRetry(boolean z10, boolean z11, boolean z12);

    boolean restoreRetryV3(boolean z10, boolean z11);

    boolean restoreV3(String str, String str2, String str3, int i10, String str4, String str5);

    boolean showRecords(boolean z10, boolean z11, String str);

    boolean showReports();

    boolean showV3RecordsDetail(String str, String str2, boolean z10, boolean z11);

    boolean spaceManager();

    void unregister(Handler.Callback callback);
}
