package com.huawei.hms.network.file.api.exception;

/* loaded from: classes8.dex */
public class InterruptedException extends NetworkException {
    private int statusCode;

    public InterruptedException(int i10, String str, Throwable th2) {
        super(str, th2);
        this.statusCode = i10;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public InterruptedException(String str) {
        super(str);
    }

    public InterruptedException(String str, Throwable th2) {
        super(str, th2);
    }
}
