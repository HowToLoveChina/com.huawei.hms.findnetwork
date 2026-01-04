package com.huawei.hms.findnetwork.comm.request.callback;

/* loaded from: classes8.dex */
public interface OtaCallback {
    void onError(String str, int i10, String str2);

    void onFinish();

    void onProgress(int i10);

    void onStart();

    void onUpdate(String str);
}
