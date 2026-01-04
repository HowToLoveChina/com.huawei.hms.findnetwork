package com.huawei.openalliance.p169ad.media.listener;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface MediaBufferListener {
    void onBufferUpdate(int i10);

    void onBufferingEnd();

    void onBufferingStart();
}
