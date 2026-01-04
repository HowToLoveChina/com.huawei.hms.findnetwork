package com.huawei.hms.ads;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes8.dex */
public interface AdFeedbackExtraListener extends AdFeedbackListener {
    public static final int FEEDBACK_CLICK = 1;

    void onAdFeedBackExtra(int i10, String str);
}
