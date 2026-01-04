package com.huawei.hwcloudjs.api;

import android.content.Context;
import android.webkit.DownloadListener;
import com.huawei.hwcloudjs.support.enables.NoProguard;

@NoProguard
/* loaded from: classes8.dex */
public interface WebviewDownloadListenner extends DownloadListener {
    void setContext(Context context);
}
