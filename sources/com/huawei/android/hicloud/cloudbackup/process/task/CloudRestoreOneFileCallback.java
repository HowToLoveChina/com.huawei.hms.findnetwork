package com.huawei.android.hicloud.cloudbackup.process.task;

import fk.C9721b;
import java.util.List;

/* loaded from: classes2.dex */
public interface CloudRestoreOneFileCallback {
    void onCreateDir(String str) throws C9721b;

    void onRestoreEnd();

    void onRestoreFailed(C9721b c9721b);

    void onRestoreOneFile(String str, String str2, long j10) throws C9721b;

    void onRestoreSuccess(String str, long j10);

    void onRestoreSuccess(List<String> list);

    String tranAndroidPath(String str, String str2);
}
