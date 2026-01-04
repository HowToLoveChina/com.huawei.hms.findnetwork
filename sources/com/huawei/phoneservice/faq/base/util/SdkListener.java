package com.huawei.phoneservice.faq.base.util;

/* loaded from: classes4.dex */
public interface SdkListener {
    boolean haveSdkErr(String str);

    void onSdkErr(String str, String str2);

    void onSdkInit(int i10, int i11, String str);
}
