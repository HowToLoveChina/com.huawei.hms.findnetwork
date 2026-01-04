package com.huawei.android.hicloud.cloudbackup.process.clone;

/* loaded from: classes2.dex */
interface ILiveKeeper {
    boolean isMatched(String str);

    void keepAlive(String str);

    void keepAllAlive();

    void release(String str);

    void releaseAll();
}
