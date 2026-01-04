package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView;

/* renamed from: com.huawei.openalliance.ad.nx */
/* loaded from: classes8.dex */
public interface InterfaceC7529nx<V extends INativeVideoView> extends InterfaceC7541oi<V> {
    /* renamed from: a */
    void mo46093a(int i10, int i11);

    /* renamed from: a */
    void mo46094a(int i10, int i11, long j10, IPPSNativeView iPPSNativeView, C7302e c7302e);

    @Override // com.huawei.openalliance.p169ad.InterfaceC7541oi
    /* renamed from: a */
    void mo46257a(long j10, long j11);

    /* renamed from: a */
    void mo46095a(ImageInfo imageInfo);

    /* renamed from: a */
    void mo46096a(VideoInfo videoInfo);

    /* renamed from: a */
    void mo46097a(C7302e c7302e);

    /* renamed from: a */
    void mo46098a(IPPSNativeView iPPSNativeView, C7302e c7302e);

    /* renamed from: a */
    void mo46099a(boolean z10);

    /* renamed from: a */
    boolean mo46100a(MediaPlayerAgent mediaPlayerAgent, C7302e c7302e);
}
