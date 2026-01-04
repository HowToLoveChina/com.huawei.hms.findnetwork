package com.huawei.location.router.dispatch;

/* loaded from: classes8.dex */
public class DispatchException extends RuntimeException {
    private static final long serialVersionUID = -6632599877015588781L;
    private int exceptionCode;

    public DispatchException(int i10, String str) {
        super(str);
        setExceptionCode(i10);
    }

    private void setExceptionCode(int i10) {
        this.exceptionCode = i10;
    }

    public int getExceptionCode() {
        return this.exceptionCode;
    }

    public DispatchException(int i10, String str, Throwable th2) {
        super(str, th2);
        setExceptionCode(i10);
    }
}
