package com.huawei.openalliance.p169ad;

import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.linked.view.LinkedAppDetailView;
import com.huawei.openalliance.p169ad.views.VideoView;

/* renamed from: com.huawei.openalliance.ad.hf */
/* loaded from: classes8.dex */
public interface InterfaceC7176hf extends InterfaceC7337jk {
    /* renamed from: a */
    void mo43793a(ImageInfo imageInfo, Drawable drawable);

    /* renamed from: a */
    void mo43794a(VideoInfo videoInfo, boolean z10);

    /* renamed from: b */
    void mo43795b(String str);

    /* renamed from: g */
    void mo43796g();

    InterfaceC7163gt getLinkedNativeAd();

    C7174hd getLinkedVideoControlBridge();

    VideoView getVideoView();

    /* renamed from: h */
    LinkedAppDetailView mo43797h();

    /* renamed from: i */
    void mo43798i();

    void setLinkedLandView(InterfaceC7175he interfaceC7175he);

    void setLinkedNativeAd(C7162gs c7162gs);

    void setVideoView(VideoView videoView);
}
