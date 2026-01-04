package com.huawei.android.hicloud.album.service;

import android.os.Bundle;
import p281f8.C9674k;

/* loaded from: classes2.dex */
public interface CallbackHandler {
    boolean canStartDownloading(boolean z10, int i10);

    C9674k getSyncStrategy();

    boolean invokeEvent(int i10, Bundle bundle);

    void sendMessage(int i10, Bundle bundle);

    void stInvalid(boolean z10);
}
