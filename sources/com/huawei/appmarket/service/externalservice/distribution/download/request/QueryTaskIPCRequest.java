package com.huawei.appmarket.service.externalservice.distribution.download.request;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;

/* loaded from: classes4.dex */
public class QueryTaskIPCRequest extends BaseIPCRequest {
    public static final Parcelable.Creator<QueryTaskIPCRequest> CREATOR = new AutoParcelable.AutoCreator(QueryTaskIPCRequest.class);

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return "method.queryTasks";
    }
}
