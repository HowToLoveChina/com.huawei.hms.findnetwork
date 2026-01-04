package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.inter.data.ILinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.views.C8076ak;

/* renamed from: com.huawei.openalliance.ad.uk */
/* loaded from: classes8.dex */
public class C7716uk {

    /* renamed from: a */
    private C8076ak f35775a;

    /* renamed from: b */
    private MediaPlayerAgent f35776b;

    /* renamed from: c */
    private boolean f35777c = false;

    /* renamed from: a */
    public void m47388a() {
        this.f35776b.play();
        m47398b(true);
    }

    /* renamed from: b */
    public void m47396b() {
        this.f35776b.prepare();
    }

    /* renamed from: c */
    public void m47399c() {
        this.f35776b.muteSound();
    }

    /* renamed from: d */
    public void m47401d() {
        this.f35776b.unmuteSound();
    }

    /* renamed from: e */
    public void m47403e() {
        if (this.f35775a != null) {
            AbstractC7185ho.m43820b("VideoPlayProxy", "onViewPhysicalShowEnd, start pause. ");
            this.f35776b.pause();
            this.f35776b.m45802b();
            m47398b(false);
        }
    }

    /* renamed from: f */
    public C8076ak m47405f() {
        return this.f35775a;
    }

    /* renamed from: g */
    public void m47406g() {
        MediaPlayerAgent mediaPlayerAgent;
        if (this.f35775a == null || (mediaPlayerAgent = this.f35776b) == null) {
            return;
        }
        mediaPlayerAgent.pause();
        this.f35776b.m45802b();
        m47398b(false);
    }

    /* renamed from: h */
    public void m47407h() {
        MediaPlayerAgent mediaPlayerAgent;
        if (this.f35775a == null || m47409j() || (mediaPlayerAgent = this.f35776b) == null) {
            return;
        }
        mediaPlayerAgent.play();
        m47398b(true);
    }

    /* renamed from: i */
    public void m47408i() {
        C8076ak c8076ak = this.f35775a;
        if (c8076ak != null) {
            c8076ak.pause();
            this.f35775a.destroyView();
        }
        m47398b(false);
    }

    /* renamed from: j */
    public boolean m47409j() {
        return this.f35777c;
    }

    /* renamed from: k */
    public MediaPlayerAgent m47410k() {
        return this.f35776b;
    }

    /* renamed from: a */
    public void m47389a(Context context, ILinkedSplashAd iLinkedSplashAd) {
        if (iLinkedSplashAd == null) {
            return;
        }
        m47393a(new C8076ak(context));
        this.f35775a.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.f35775a.setVideoScaleMode(2);
        if (iLinkedSplashAd.getVideoInfo() != null) {
            this.f35775a.setVideoRatio(iLinkedSplashAd.getVideoInfo().getVideoRatio());
        }
    }

    /* renamed from: b */
    public void m47397b(VideoInfo videoInfo) {
        MediaPlayerAgent mediaPlayerAgent;
        if (this.f35775a == null || (mediaPlayerAgent = this.f35776b) == null) {
            return;
        }
        mediaPlayerAgent.muteSound();
        this.f35776b.m45802b();
        if (videoInfo != null) {
            videoInfo.m44580e("n");
        }
    }

    /* renamed from: c */
    public void m47400c(VideoInfo videoInfo) {
        MediaPlayerAgent mediaPlayerAgent;
        if (this.f35775a == null || (mediaPlayerAgent = this.f35776b) == null) {
            return;
        }
        mediaPlayerAgent.unmuteSound();
        if (videoInfo != null) {
            videoInfo.m44580e("y");
        }
    }

    /* renamed from: d */
    public void m47402d(VideoInfo videoInfo) {
        if (this.f35775a == null || this.f35776b == null) {
            return;
        }
        AbstractC7185ho.m43820b("VideoPlayProxy", "onViewShownBetweenFullAndPartial, start mute");
        this.f35776b.muteSound();
        this.f35776b.m45802b();
        if (videoInfo != null) {
            videoInfo.m44580e("n");
        }
    }

    /* renamed from: e */
    public void m47404e(VideoInfo videoInfo) {
        if (this.f35775a == null || this.f35776b == null) {
            return;
        }
        AbstractC7185ho.m43820b("VideoPlayProxy", "onViewPartialHidden, start pause");
        this.f35776b.muteSound();
        if (videoInfo != null) {
            videoInfo.m44580e("n");
        }
        this.f35776b.pause();
        this.f35776b.m45802b();
        m47398b(false);
    }

    /* renamed from: a */
    public void m47390a(VideoInfo videoInfo) {
        if (videoInfo != null) {
            AbstractC7185ho.m43821b("VideoPlayProxy", "on progress resume %s  soundSwitch %s", Integer.valueOf(videoInfo.m44566b()), videoInfo.getSoundSwitch());
            if (this.f35775a == null || this.f35776b == null) {
                return;
            }
            boolean zEquals = "n".equals(videoInfo.getSoundSwitch());
            MediaPlayerAgent mediaPlayerAgent = this.f35776b;
            if (zEquals) {
                mediaPlayerAgent.muteSound();
            } else {
                mediaPlayerAgent.unmuteSound();
            }
        }
    }

    /* renamed from: b */
    public void m47398b(boolean z10) {
        this.f35777c = z10;
    }

    /* renamed from: a */
    public void m47391a(VideoInfo videoInfo, Integer num) {
        MediaPlayerAgent mediaPlayerAgent;
        long j10;
        if (this.f35775a == null || videoInfo == null || this.f35776b == null) {
            return;
        }
        int iM44566b = videoInfo.m44566b();
        if (m47409j()) {
            return;
        }
        AbstractC7185ho.m43821b("VideoPlayProxy", "onViewFullShown, start play, duration: %s, playProgress: %s", num, Integer.valueOf(iM44566b));
        this.f35776b.setPreferStartPlayTime(iM44566b);
        this.f35776b.play();
        m47398b(true);
        if (num == null || Math.abs(num.intValue() - iM44566b) >= 1000) {
            mediaPlayerAgent = this.f35776b;
            j10 = iM44566b;
        } else {
            AbstractC7185ho.m43820b("VideoPlayProxy", "onViewFullShown, seek to 0");
            mediaPlayerAgent = this.f35776b;
            j10 = 0;
        }
        mediaPlayerAgent.seekToMillis(j10, 3);
    }

    /* renamed from: a */
    public void m47392a(MediaPlayerAgent mediaPlayerAgent) {
        this.f35776b = mediaPlayerAgent;
    }

    /* renamed from: a */
    public void m47393a(C8076ak c8076ak) {
        this.f35775a = c8076ak;
    }

    /* renamed from: a */
    public void m47394a(String str, VideoInfo videoInfo, int i10) {
        if (TextUtils.isEmpty(str)) {
            this.f35776b.setMediaFile(videoInfo.getVideoDownloadUrl());
        } else {
            this.f35776b.setMediaFile(str);
        }
        this.f35776b.m45795a(i10);
        this.f35776b.muteSound();
        videoInfo.m44580e("n");
    }

    /* renamed from: a */
    public void m47395a(boolean z10) {
        this.f35776b.m45800a(z10);
        this.f35776b.play();
        m47398b(true);
    }
}
