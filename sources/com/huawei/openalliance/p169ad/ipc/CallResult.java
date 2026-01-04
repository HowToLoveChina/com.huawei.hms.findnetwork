package com.huawei.openalliance.p169ad.ipc;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@DataKeep
@OuterVisible
/* loaded from: classes2.dex */
public class CallResult<T> {
    private int code = -1;
    private T data;
    private String msg;

    @OuterVisible
    public int getCode() {
        return this.code;
    }

    @OuterVisible
    public T getData() {
        return this.data;
    }

    @OuterVisible
    public String getMsg() {
        return this.msg;
    }

    @OuterVisible
    public void setCode(int i10) {
        this.code = i10;
    }

    @OuterVisible
    public void setData(T t10) {
        this.data = t10;
    }

    @OuterVisible
    public void setMsg(String str) {
        this.msg = str;
    }
}
