package com.huawei.openalliance.p169ad.media.listener;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;

@OuterVisible
/* loaded from: classes2.dex */
public interface MediaStateListener {
    void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10);

    void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10);

    void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10);

    void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10);

    void onProgress(int i10, int i11);
}
