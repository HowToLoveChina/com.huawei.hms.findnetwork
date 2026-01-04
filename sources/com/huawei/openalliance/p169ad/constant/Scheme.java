package com.huawei.openalliance.p169ad.constant;

import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;

/* loaded from: classes2.dex */
public enum Scheme {
    HTTP("http://"),
    HTTPS("https://"),
    FILE("file://"),
    CONTENT("content://"),
    RES("res://"),
    ASSET("asset://"),
    DISKCACHE("diskcache://"),
    DATAPARTITION(ICBUtil.ANDROID_DATA);

    String mScheme;

    Scheme(String str) {
        this.mScheme = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mScheme;
    }
}
