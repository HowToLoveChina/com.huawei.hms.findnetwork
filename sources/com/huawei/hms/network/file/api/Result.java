package com.huawei.hms.network.file.api;

import com.huawei.hms.network.file.core.Constants;

/* loaded from: classes8.dex */
public class Result {
    public static final int CANCEL;
    public static final int PAUSE;
    public static final Result RESULT_STATUS_FAILED;
    public static final Result RESULT_SUCCESS;
    public static final int SUCCESS;
    private int code;
    private String message;

    public enum STATUS {
        INIT,
        PROCESS,
        PAUSE,
        INVALID
    }

    static {
        Constants.ErrorCode errorCode = Constants.ErrorCode.SUCCESS;
        RESULT_SUCCESS = new Result(errorCode);
        RESULT_STATUS_FAILED = new Result(Constants.ErrorCode.REQUEST_STATUS_ERROR);
        SUCCESS = errorCode.getErrorCode();
        PAUSE = Constants.ErrorCode.TASK_PAUSE_EXCEPTION.getErrorCode();
        CANCEL = Constants.ErrorCode.TASK_CANCEL_EXCEPTION.getErrorCode();
    }

    public Result() {
    }

    public Result(int i10) {
        this.code = i10;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "Result{code=" + this.code + ", message='" + this.message + "'}";
    }

    public Result(int i10, String str) {
        this.code = i10;
        this.message = str;
    }

    public Result(Constants.ErrorCode errorCode) {
        this.code = errorCode.getErrorCode();
        this.message = errorCode.getErrorMessage();
    }
}
