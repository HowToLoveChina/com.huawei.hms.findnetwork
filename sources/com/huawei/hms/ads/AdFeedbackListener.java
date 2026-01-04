package com.huawei.hms.ads;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes8.dex */
public interface AdFeedbackListener {
    void onAdDisliked();

    void onAdFeedbackShowFailed();

    void onAdLiked();
}
