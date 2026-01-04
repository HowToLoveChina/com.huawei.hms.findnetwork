package com.huawei.fastsdk;

import android.view.View;

/* loaded from: classes5.dex */
public interface IFastRenderListener {
    void onException(String str, String str2);

    void onRefreshSuccess(int i10, int i11);

    void onRenderSuccess();

    void onRoute(Object... objArr);

    void onViewCreated(View view);
}
