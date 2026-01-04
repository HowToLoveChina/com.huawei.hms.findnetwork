package com.huawei.hms.findnetwork.comm.request.callback;

import com.huawei.hms.findnetwork.comm.request.bean.NearLinkNavigationResult;

/* loaded from: classes8.dex */
public interface NearLinkNavigationCallback {
    void onFail(int i10, String str);

    void onRangingResult(int i10, NearLinkNavigationResult nearLinkNavigationResult);

    void onSuccess();
}
