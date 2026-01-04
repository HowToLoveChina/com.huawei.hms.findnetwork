package com.huawei.hms.ads.uiengine.common;

import android.os.Bundle;
import android.view.View;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes8.dex */
public interface InterstitialApi {
    Bundle callMethod(String str, Bundle bundle);

    void onAnalysis(String str, Bundle bundle);

    boolean processWhyEventUnified();

    void registerBtn(View view, Bundle bundle);

    void reportEvent(String str, Bundle bundle);

    void setIsVideoCompleted(boolean z10);

    void updateShowId(long j10);
}
