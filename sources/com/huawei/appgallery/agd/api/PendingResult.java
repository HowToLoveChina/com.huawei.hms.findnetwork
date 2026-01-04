package com.huawei.appgallery.agd.api;

import android.content.Context;
import com.huawei.appgallery.agd.internal.support.log.AgdLog;
import com.huawei.appgallery.agd.internalapi.CrossClientApi;
import com.huawei.appgallery.agd.internalapi.ICrossClient;
import com.huawei.appgallery.coreservice.api.PendingCall;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appmarket.framework.coreservice.Status;

/* loaded from: classes4.dex */
public class PendingResult<C extends BaseIPCRequest, R extends BaseIPCResponse> extends PendingCall<C, R> {
    public static final int RESOLUTION_AUTOFINISH = 1;
    public static final int RESOLUTION_DONOT_AUTOFINISH = 0;
    public static final String RESOLUTION_EXTRA_AUTOFINISH = "agd.extra.autofinish";
    public static final String RESOLUTION_EXTRA_BUNDLE = "agd.extra.bundle";
    public static final String RESOLUTION_EXTRA_BUNDLE_BINDER = "agd.extra.bundle.binder";
    public static final String RESOLUTION_EXTRA_BUNDLE_REQUESTCODE = "agd.extra.bundle.requestcode";

    /* renamed from: d */
    public boolean f20956d;

    /* renamed from: e */
    public ICrossClient f20957e;

    /* renamed from: f */
    public final Object f20958f;

    /* renamed from: g */
    public Context f20959g;

    /* renamed from: h */
    public C f20960h;

    public PendingResult(AgdApiClient agdApiClient, C c10) {
        super(agdApiClient, c10);
        this.f20958f = new Object();
        Context context = agdApiClient.getContext();
        this.f20959g = context;
        this.f20960h = c10;
        boolean zNeedCrossClient = CrossClientApi.needCrossClient(context);
        this.f20956d = zNeedCrossClient;
        if (zNeedCrossClient) {
            this.f20957e = CrossClientApi.getCrossClient();
        }
    }

    @Override // com.huawei.appgallery.coreservice.api.PendingCall
    public void awaitOnAnyThread() {
        if (!this.f20956d) {
            super.awaitOnAnyThread();
            return;
        }
        if (this.api.get() != null) {
            setResult(this.mResult);
            return;
        }
        AgdLog.LOG.m28029e("PendingResult", "api is null");
        synchronized (this.f20958f) {
            this.mResult.setStatusCode(12);
        }
    }

    public void setResultCallback(final ResultCallback<R> resultCallback) {
        AgdLog agdLog = AgdLog.LOG;
        agdLog.m28031i("PendingResult", "setResultCallback");
        if (!this.f20956d) {
            resultCallback.getClass();
            super.setCallback(new PendingCall.Callback() { // from class: dh.a
                @Override // com.huawei.appgallery.coreservice.api.PendingCall.Callback
                public final void onReceiveStatus(Status status) {
                    resultCallback.onResult(status);
                }
            });
        } else {
            agdLog.m28033w("PendingResult", "crossClientTaskProcess");
            this.mResult = this.f20957e.crossClientTaskProcess(this.f20959g, this.f20960h);
            resultCallback.onResult(getResult());
        }
    }
}
