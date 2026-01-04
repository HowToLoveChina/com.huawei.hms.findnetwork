package com.huawei.android.hicloud.cloudbackup.process.task;

import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import fk.C9721b;

/* loaded from: classes2.dex */
public interface CloudBackupCreateCallback {
    void onCreateEnd();

    void onCreateError(C9721b c9721b);

    void onCreateSuccess(CBSAppInfo cBSAppInfo);
}
