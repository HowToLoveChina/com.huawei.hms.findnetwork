package com.huawei.openalliance.p169ad;

import com.huawei.hms.ads.uiengine.common.MediaStateApi;

/* renamed from: com.huawei.openalliance.ad.jm */
/* loaded from: classes8.dex */
public class C7339jm implements MediaStateApi {

    /* renamed from: a */
    private C7344jr f34215a;

    public C7339jm(C7344jr c7344jr) {
        this.f34215a = c7344jr;
    }

    @Override // com.huawei.hms.ads.uiengine.common.MediaStateApi
    public void onMediaCompletion(int i10) {
        AbstractC7185ho.m43818a("MediaStateImpl", "onVideoEnd, playTime is %s", Integer.valueOf(i10));
    }

    @Override // com.huawei.hms.ads.uiengine.common.MediaStateApi
    public void onMediaPause(int i10) {
    }

    @Override // com.huawei.hms.ads.uiengine.common.MediaStateApi
    public void onMediaStart(int i10) {
        AbstractC7185ho.m43820b("MediaStateImpl", "onVideoStart");
        C7344jr c7344jr = this.f34215a;
        if (c7344jr != null) {
            c7344jr.m45411c();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.MediaStateApi
    public void onMediaStop(int i10) {
    }

    @Override // com.huawei.hms.ads.uiengine.common.MediaStateApi
    public void onProgress(int i10, int i11) {
        AbstractC7185ho.m43818a("MediaStateImpl", "onProgress, percentage is %s, playTime is %s", Integer.valueOf(i10), Integer.valueOf(i11));
        C7344jr c7344jr = this.f34215a;
        if (c7344jr != null) {
            c7344jr.m45410a(i10, i11);
        }
    }
}
