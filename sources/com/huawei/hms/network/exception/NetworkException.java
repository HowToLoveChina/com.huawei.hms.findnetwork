package com.huawei.hms.network.exception;

import java.io.IOException;

/* loaded from: classes8.dex */
public abstract class NetworkException extends IOException {
    public NetworkException(String str) {
        super(str);
    }

    public NetworkException(String str, Throwable th2) {
        super(str, th2);
    }
}
