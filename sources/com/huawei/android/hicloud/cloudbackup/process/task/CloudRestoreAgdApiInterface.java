package com.huawei.android.hicloud.cloudbackup.process.task;

import com.huawei.android.hicloud.agd.ads.DownloadParam;
import com.huawei.hicloud.cloudbackup.server.model.RestoreApkAgdDownloadState;
import fk.C9721b;
import java.util.function.Consumer;
import p015ak.C0217h;

/* loaded from: classes2.dex */
public interface CloudRestoreAgdApiInterface {

    public interface CloudRestoreAgdApiClientCallback {
        void downloadFail(int i10);

        void onAddTaskSuccess();

        void progressChanged(RestoreApkAgdDownloadState restoreApkAgdDownloadState);

        void startFail(int i10);
    }

    void cancelTask(String str) throws C9721b;

    void pauseTask(String str) throws C9721b;

    void queryTask(String str, C0217h<Boolean> c0217h, Consumer<Boolean> consumer) throws C9721b;

    void resumeTask(String str, C0217h<Boolean> c0217h, CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback, boolean z10) throws C9721b;

    void startTask(String str, DownloadParam downloadParam, C0217h<Boolean> c0217h, CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback, boolean z10) throws C9721b;
}
