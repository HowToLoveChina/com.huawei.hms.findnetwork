package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import ni.C11707b;

/* loaded from: classes3.dex */
public class SingleErrorMessage extends C11707b {

    @InterfaceC4648p
    private ErrorResp.Error error;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12224id;

    public ErrorResp.Error getError() {
        return this.error;
    }

    public String getId() {
        return this.f12224id;
    }

    public void setError(ErrorResp.Error error) {
        this.error = error;
    }

    public void setId(String str) {
        this.f12224id = str;
    }
}
