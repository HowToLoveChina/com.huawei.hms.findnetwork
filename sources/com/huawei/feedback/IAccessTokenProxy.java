package com.huawei.feedback;

/* loaded from: classes5.dex */
public interface IAccessTokenProxy {
    void getAccessToken(GetAccessTokenListener getAccessTokenListener);

    String getAccessTokenCache();

    String getContryCode();

    boolean isLogin();
}
