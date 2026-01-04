package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.Error;
import ni.C11707b;

/* loaded from: classes3.dex */
public class FailRecord extends C11707b {

    @InterfaceC4648p
    private Error error;

    /* renamed from: id */
    @InterfaceC4648p
    private String f13034id;

    public Error getError() {
        return this.error;
    }

    public String getId() {
        return this.f13034id;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public void setId(String str) {
        this.f13034id = str;
    }
}
