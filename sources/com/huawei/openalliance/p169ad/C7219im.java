package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.im */
/* loaded from: classes8.dex */
public class C7219im implements InterfaceC7316iq {

    /* renamed from: a */
    WeakReference<INativeVideoView> f33213a;

    public C7219im(INativeVideoView iNativeVideoView) {
        this.f33213a = new WeakReference<>(iNativeVideoView);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7316iq
    /* renamed from: a */
    public void mo30558a(final int i10) {
        AbstractC7185ho.m43821b("NativeVideoStreamListener", "stream error, code: %s", Integer.valueOf(i10));
        final INativeVideoView iNativeVideoView = this.f33213a.get();
        if (iNativeVideoView != null) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.im.1
                @Override // java.lang.Runnable
                public void run() {
                    iNativeVideoView.notifyStreamError(i10);
                    if (i10 == -2) {
                        iNativeVideoView.stop();
                    }
                }
            });
        }
    }
}
