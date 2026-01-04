package com.huawei.hms.network.file.api.exception;

/* loaded from: classes8.dex */
public class ServerException extends HttpException {
    private int statusCode;

    public ServerException(int i10, String str, Throwable th2) {
        super(str, th2);
        this.statusCode = i10;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ServerException(String str) {
        super(str);
    }

    public ServerException(String str, Throwable th2) {
        super(str, th2);
    }
}
