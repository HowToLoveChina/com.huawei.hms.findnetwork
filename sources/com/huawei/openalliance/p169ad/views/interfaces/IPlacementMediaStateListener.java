package com.huawei.openalliance.p169ad.views.interfaces;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface IPlacementMediaStateListener {
    void onErrorWithContentId(int i10, int i11, int i12, String str);

    void onMediaCompletion(int i10);

    void onMediaError(int i10, int i11, int i12);

    void onMediaPause(int i10);

    void onMediaProgress(int i10, int i11);

    void onMediaStart(int i10);

    void onMediaStop(int i10);
}
