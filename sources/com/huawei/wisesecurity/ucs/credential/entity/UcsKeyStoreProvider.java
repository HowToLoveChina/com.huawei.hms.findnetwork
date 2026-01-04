package com.huawei.wisesecurity.ucs.credential.entity;

/* loaded from: classes9.dex */
public enum UcsKeyStoreProvider {
    ANDROID_KEYSTORE("AndroidKeyStore"),
    HUAWEI_KEYSTORE("HwKeystore");

    private final String name;

    UcsKeyStoreProvider(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
