package com.huawei.phoneservice.faq.base.util;

/* loaded from: classes4.dex */
public abstract class SdkListenerPoxy implements SdkListener {
    private static final String TAG = "SdkListenerPoxy";
    private SdkListener sdkListener;

    public SdkListenerPoxy(SdkListener sdkListener) {
        this.sdkListener = sdkListener;
    }

    public SdkListener getSdkListener() {
        return this.sdkListener;
    }

    @Override // com.huawei.phoneservice.faq.base.util.SdkListener
    public boolean haveSdkErr(String str) throws Throwable {
        FaqLogger.print(TAG, "haveSdkErr: key:" + str);
        return this.sdkListener.haveSdkErr(str);
    }

    @Override // com.huawei.phoneservice.faq.base.util.SdkListener
    public void onSdkErr(String str, String str2) throws Throwable {
        FaqLogger.print(TAG, "onSdkErr: key:" + str + " value: " + str2);
        this.sdkListener.onSdkErr(str, str2);
    }

    @Override // com.huawei.phoneservice.faq.base.util.SdkListener
    public void onSdkInit(int i10, int i11, String str) {
        onSdkInitImpl(i10, i11, str);
    }

    public abstract void onSdkInitImpl(int i10, int i11, String str);
}
