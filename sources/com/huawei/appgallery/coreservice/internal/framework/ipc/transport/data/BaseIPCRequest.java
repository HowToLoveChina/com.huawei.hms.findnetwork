package com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data;

import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;

/* loaded from: classes4.dex */
public abstract class BaseIPCRequest extends AutoParcelable {
    public static final String CALL_TYPE_AGD_PRO_SDK = "AGDPROSDK";
    public static final String CALL_TYPE_AGD_SDK = "AGDSDK";

    /* renamed from: a */
    public String f20988a;

    public String getMediaPkg() {
        return this.f20988a;
    }

    public abstract String getMethod();

    public void setCallType(String str) {
    }

    public void setMediaPkg(String str) {
        this.f20988a = str;
    }
}
