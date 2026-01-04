package com.huawei.hms.ads.installreferrer.api;

import android.net.Uri;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes8.dex */
public interface OnDeeplinkAcquiredListener {
    @Keep
    boolean launchDeeplink(Uri uri);
}
