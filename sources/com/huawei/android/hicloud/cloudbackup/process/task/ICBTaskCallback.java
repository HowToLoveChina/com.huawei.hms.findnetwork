package com.huawei.android.hicloud.cloudbackup.process.task;

/* loaded from: classes2.dex */
public interface ICBTaskCallback {
    void onReturnSize(boolean z10);

    void onTaskAbort(Object obj);

    void onTaskBegin(Object obj);

    void onTaskFail();

    void onTaskSuccess();
}
