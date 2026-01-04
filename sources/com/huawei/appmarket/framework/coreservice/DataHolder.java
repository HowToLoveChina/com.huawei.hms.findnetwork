package com.huawei.appmarket.framework.coreservice;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequestHeader;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: classes4.dex */
public class DataHolder<R extends BaseIPCRequest> extends AutoParcelable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new AutoParcelable.AutoCreator(DataHolder.class);

    @EnableAutoParcel(1)
    private String mMethod;

    @EnableAutoParcel(2)
    private RequestHeader mHeader = null;

    @EnableAutoParcel(3)
    private R mRequest = null;

    /* renamed from: a */
    public void m28116a(R r10) {
        this.mRequest = r10;
    }

    /* renamed from: c */
    public void m28117c(RequestHeader requestHeader) {
        this.mHeader = requestHeader;
    }

    /* renamed from: d */
    public void m28118d(String str) {
        this.mMethod = str;
    }
}
