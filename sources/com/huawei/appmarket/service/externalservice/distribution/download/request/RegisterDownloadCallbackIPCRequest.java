package com.huawei.appmarket.service.externalservice.distribution.download.request;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;
import com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback;

/* loaded from: classes4.dex */
public class RegisterDownloadCallbackIPCRequest extends BaseIPCRequest {
    public static final Parcelable.Creator<RegisterDownloadCallbackIPCRequest> CREATOR = new AutoParcelable.AutoCreator(RegisterDownloadCallbackIPCRequest.class);

    @EnableAutoParcel(2)
    private IDownloadCallback mCallback;

    @EnableAutoParcel(1)
    private String mPackageName;

    public IDownloadCallback getCallback() {
        return this.mCallback;
    }

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return "method.registerDownloadCallback";
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setCallback(IDownloadCallback iDownloadCallback) {
        this.mCallback = iDownloadCallback;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }
}
