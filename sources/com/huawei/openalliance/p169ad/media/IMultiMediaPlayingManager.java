package com.huawei.openalliance.p169ad.media;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface IMultiMediaPlayingManager {
    void autoPlay(String str, MediaPlayerAgent mediaPlayerAgent);

    void manualPlay(String str, MediaPlayerAgent mediaPlayerAgent);

    void pause(String str, MediaPlayerAgent mediaPlayerAgent);

    void removeListenersForMediaPlayerAgent(MediaPlayerAgent mediaPlayerAgent);

    void removeMediaPlayerAgent(MediaPlayerAgent mediaPlayerAgent);

    void stop(String str, MediaPlayerAgent mediaPlayerAgent);
}
