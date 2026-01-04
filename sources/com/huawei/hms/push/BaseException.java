package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* loaded from: classes8.dex */
public class BaseException extends Exception {

    /* renamed from: a */
    private final int f29602a;

    /* renamed from: b */
    private final ErrorEnum f29603b;

    public BaseException(int i10) {
        ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(i10);
        this.f29603b = errorEnumFromCode;
        this.f29602a = errorEnumFromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f29602a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f29603b.getMessage();
    }
}
