package com.huawei.openalliance.p169ad.media.listener;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface SegmentMediaStateListener {
    void onSegmentMediaCompletion(String str, String str2, int i10);

    void onSegmentMediaError(String str, String str2, int i10, int i11, int i12);

    void onSegmentMediaPause(String str, String str2, int i10);

    void onSegmentMediaStart(String str, String str2, int i10);

    void onSegmentMediaStop(String str, String str2, int i10);

    void onSegmentProgress(String str, String str2, int i10, int i11);
}
