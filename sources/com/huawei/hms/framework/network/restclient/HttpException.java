package com.huawei.hms.framework.network.restclient;

import com.huawei.hms.framework.common.CheckParamUtils;

/* loaded from: classes8.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final Response<?> response;

    public HttpException(Response<?> response) {
        super(getMessage(response));
        this.code = response.getCode();
        this.message = response.getMessage();
        this.response = response;
    }

    private static String getMessage(Response<?> response) {
        CheckParamUtils.checkNotNull(response, "response == null");
        return "HTTP " + response.getCode() + " " + response.getMessage();
    }

    public int getCode() {
        return this.code;
    }

    public Response<?> getResponse() {
        return this.response;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
