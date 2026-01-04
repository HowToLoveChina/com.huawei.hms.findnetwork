package com.huawei.openalliance.p169ad.media.listener;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface ILinkedMediaStateListener {
    void onMediaCompletion(int i10);

    void onMediaError(int i10, int i11, int i12);

    void onMediaPause(int i10);

    void onMediaProgress(int i10, int i11);

    void onMediaStart(int i10);

    void onMediaStop(int i10);
}
