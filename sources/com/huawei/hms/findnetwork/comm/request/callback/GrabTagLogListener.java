package com.huawei.hms.findnetwork.comm.request.callback;

/* loaded from: classes8.dex */
public interface GrabTagLogListener {
    void onFinished();

    void onGrabFail(int i10, String str);

    void onGrabing(byte[] bArr);

    void onStartGrab();
}
