package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.uiengine.InterfaceC5106a;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;

/* renamed from: com.huawei.openalliance.ad.bs */
/* loaded from: classes8.dex */
public class C6975bs extends MediaPlayerAgent implements MediaErrorListener, MediaStateListener {

    /* renamed from: a */
    private InterfaceC5106a f32035a;

    /* renamed from: b */
    private MediaStateListener f32036b;

    /* renamed from: c */
    private MediaErrorListener f32037c;

    public C6975bs(Context context, InterfaceC5106a interfaceC5106a) {
        super(context);
        this.f32035a = interfaceC5106a;
    }

    @Override // com.huawei.openalliance.p169ad.media.MediaPlayerAgent
    public void addMediaErrorListener(MediaErrorListener mediaErrorListener) {
        this.f32037c = mediaErrorListener;
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder(ParamConstants.Param.LISTENER, (IBinder) ObjectWrapper.wrap(this));
            this.f32035a.mo30469b(bundle);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MediaPlayerAgentProxy", "addMediaErrorListener err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.MediaPlayerAgent
    public void addMediaStateListener(MediaStateListener mediaStateListener) {
        this.f32036b = mediaStateListener;
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder(ParamConstants.Param.LISTENER, (IBinder) ObjectWrapper.wrap(this));
            this.f32035a.mo30466a(bundle);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MediaPlayerAgentProxy", "addMediaStateListener err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
    public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
        MediaErrorListener mediaErrorListener = this.f32037c;
        if (mediaErrorListener != null) {
            mediaErrorListener.onError(this, i10, i11, i12);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
        MediaStateListener mediaStateListener = this.f32036b;
        if (mediaStateListener != null) {
            mediaStateListener.onMediaCompletion(this, i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    @OuterVisible
    public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
        MediaStateListener mediaStateListener = this.f32036b;
        if (mediaStateListener != null) {
            mediaStateListener.onMediaPause(this, i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
        MediaStateListener mediaStateListener = this.f32036b;
        if (mediaStateListener != null) {
            mediaStateListener.onMediaStart(this, i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
        MediaStateListener mediaStateListener = this.f32036b;
        if (mediaStateListener != null) {
            mediaStateListener.onMediaStop(this, i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onProgress(int i10, int i11) {
        MediaStateListener mediaStateListener = this.f32036b;
        if (mediaStateListener != null) {
            mediaStateListener.onProgress(i10, i11);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.MediaPlayerAgent
    public void pauseWhenUrlMatchs(String str) {
        try {
            this.f32035a.mo30472c(str);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MediaPlayerAgentProxy", "pauseWhenUrlMatchs er: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.MediaPlayerAgent
    public void playWhenUrlMatchs(String str) {
        try {
            this.f32035a.mo30467a(str);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MediaPlayerAgentProxy", "playWhenUrlMatchs err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.MediaPlayerAgent
    public void removeMediaErrorListener(MediaErrorListener mediaErrorListener) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder(ParamConstants.Param.LISTENER, (IBinder) ObjectWrapper.wrap(this));
            this.f32035a.mo30473d(bundle);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MediaPlayerAgentProxy", "removeMediaErrorListener err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.MediaPlayerAgent
    public void removeMediaStateListener(MediaStateListener mediaStateListener) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder(ParamConstants.Param.LISTENER, (IBinder) ObjectWrapper.wrap(this));
            this.f32035a.mo30471c(bundle);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MediaPlayerAgentProxy", "removeMediaErrorListener err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.MediaPlayerAgent
    public void stop() {
        try {
            this.f32035a.mo30468b();
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MediaPlayerAgentProxy", "stop err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.MediaPlayerAgent
    public void stopWhenUrlMatchs(String str) {
        try {
            this.f32035a.mo30470b(str);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("MediaPlayerAgentProxy", "stopWhenUrlMatchs err: %s", th2.getClass().getSimpleName());
        }
    }
}
