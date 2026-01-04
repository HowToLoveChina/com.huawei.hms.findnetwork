package com.huawei.hms.network.file.core;

import com.huawei.hms.network.file.core.Constants;

/* loaded from: classes8.dex */
public class FileManagerException extends RuntimeException {
    int errorCode;
    String errorMessage;

    public FileManagerException(int i10, String str) {
        this.errorMessage = str;
        this.errorCode = i10;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "FileManagerException{errorCode=" + this.errorCode + ", errorMessage='" + this.errorMessage + "'}";
    }

    public FileManagerException(int i10, String str, Throwable th2) {
        super(th2);
        this.errorMessage = str;
        this.errorCode = i10;
    }

    public FileManagerException(Constants.ErrorCode errorCode) {
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
    }

    public FileManagerException(Constants.ErrorCode errorCode, String str) {
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage() + ":" + str;
    }

    public FileManagerException(Constants.ErrorCode errorCode, Throwable th2) {
        super(th2);
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
    }

    public FileManagerException(String str) {
        super(str);
        this.errorMessage = str;
    }
}
