package com.huawei.fastengine.fastview;

import android.view.View;

/* loaded from: classes5.dex */
public interface RenderListener {
    void onException(FastViewInstance fastViewInstance, String str, String str2);

    void onRefreshSuccess(FastViewInstance fastViewInstance);

    void onRenderSuccess(FastViewInstance fastViewInstance);

    void onRoute(FastViewInstance fastViewInstance, String str);

    void onViewCreated(FastViewInstance fastViewInstance, View view);
}
