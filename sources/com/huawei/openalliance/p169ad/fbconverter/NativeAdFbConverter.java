package com.huawei.openalliance.p169ad.fbconverter;

import com.huawei.openalliance.p169ad.C7085ea;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;

@OuterVisible
/* loaded from: classes2.dex */
public class NativeAdFbConverter {
    /* renamed from: a */
    private static C7302e m43280a(C7302e c7302e) {
        VideoInfo videoInfo = c7302e.getVideoInfo();
        if (videoInfo != null) {
            videoInfo.m44579e(0);
            videoInfo.m44580e(videoInfo.getVideoAutoPlayWithSound());
        }
        c7302e.m44799a(videoInfo);
        return c7302e;
    }

    @OuterVisible
    public static INativeAd deserialization(byte[] bArr) {
        return m43280a(C7085ea.m42840a(bArr));
    }

    @OuterVisible
    public static byte[] serialization(INativeAd iNativeAd) {
        return C7085ea.m42841a((C7302e) iNativeAd);
    }
}
