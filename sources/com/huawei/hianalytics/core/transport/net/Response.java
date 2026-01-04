package com.huawei.hianalytics.core.transport.net;

/* loaded from: classes5.dex */
public class Response {
    public final String content;
    public final int httpCode;

    public interface Code {
        public static final int CONNECTION_ERROR = -103;
        public static final int HOST_ERROR = -104;
        public static final int INTERNET_PERMISSION_ERROR = -101;
        public static final int SSL_VALIDATION_ERROR = -105;
        public static final int TIMEOUT_OR_OTHER_ERROR = -102;
        public static final int UNKNOWN_ERROR = -108;
    }

    public Response(int i10, String str) {
        this.httpCode = i10;
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public int getHttpCode() {
        return this.httpCode;
    }
}
