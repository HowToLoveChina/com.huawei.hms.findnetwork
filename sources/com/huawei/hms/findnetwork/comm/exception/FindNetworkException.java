package com.huawei.hms.findnetwork.comm.exception;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;

/* loaded from: classes8.dex */
public class FindNetworkException extends Exception {
    private int code;

    public FindNetworkException(ApiException apiException) {
        this(apiException.getMessage(), apiException.getStatusCode());
    }

    public static ApiException apiExceptionOf(int i10, String str) {
        return new ApiException(new Status(i10, str));
    }

    public int getCode() {
        return this.code;
    }

    public FindNetworkException(String str) {
        super(str);
        this.code = 0;
    }

    public static ApiException apiExceptionOf(Exception exc) {
        return exc instanceof ApiException ? (ApiException) exc : apiExceptionOf(exc.getMessage());
    }

    public FindNetworkException(String str, int i10) {
        super(str);
        this.code = i10;
    }

    public static ApiException apiExceptionOf(String str) {
        return apiExceptionOf(-1, str);
    }
}
