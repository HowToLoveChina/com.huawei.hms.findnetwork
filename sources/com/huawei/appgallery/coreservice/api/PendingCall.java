package com.huawei.appgallery.coreservice.api;

import android.os.RemoteException;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appmarket.framework.coreservice.InterfaceC4584a;
import com.huawei.appmarket.framework.coreservice.Status;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p257eh.C9484f;
import p257eh.C9490l;
import p257eh.InterfaceC9483e;

/* loaded from: classes4.dex */
public class PendingCall<C extends BaseIPCRequest, R extends BaseIPCResponse> {
    protected WeakReference<ApiClient> api;

    /* renamed from: c */
    public final InterfaceC9483e f20973c;
    protected final Object lock = new Object();

    /* renamed from: a */
    public final CountDownLatch f20971a = new CountDownLatch(1);
    protected Status<R> mResult = new Status<>(10);

    /* renamed from: b */
    public boolean f20972b = false;

    public interface Callback<R extends BaseIPCResponse> {
        void onReceiveStatus(Status<R> status);
    }

    public PendingCall(ApiClient apiClient, C c10) {
        this.f20973c = new C9484f(apiClient.getContext(), c10);
        this.api = new WeakReference<>(apiClient);
    }

    public Status<R> await() {
        awaitOnAnyThread();
        synchronized (this.lock) {
            if (!this.f20972b) {
                try {
                    this.f20971a.await();
                } catch (InterruptedException unused) {
                    C9490l.m59353e("PendingCall", "InterruptedException");
                }
            }
        }
        return getResult();
    }

    public void awaitOnAnyThread() {
        C9490l.m59352d("PendingCall", "awaitOnAnyThread");
        ApiClient apiClient = this.api.get();
        if (apiClient != null) {
            this.f20973c.mo59333a(apiClient, new InterfaceC4584a.a() { // from class: com.huawei.appgallery.coreservice.api.PendingCall.2
                @Override // com.huawei.appmarket.framework.coreservice.InterfaceC4584a
                public void call(Status status) throws RemoteException {
                    synchronized (PendingCall.this.lock) {
                        PendingCall.this.setResult(status);
                    }
                }
            });
            return;
        }
        C9490l.m59351c("PendingCall", "api is null");
        synchronized (this.lock) {
            this.mResult.setStatusCode(12);
        }
    }

    public Status<R> getResult() {
        Status<R> status;
        synchronized (this.lock) {
            status = this.mResult;
        }
        return status;
    }

    public void setCallback(final Callback<R> callback) {
        C9490l.m59352d("PendingCall", "setResultCallback");
        ApiClient apiClient = this.api.get();
        if (apiClient != null) {
            this.f20973c.mo59333a(apiClient, new InterfaceC4584a.a(this) { // from class: com.huawei.appgallery.coreservice.api.PendingCall.1
                @Override // com.huawei.appmarket.framework.coreservice.InterfaceC4584a
                public void call(Status status) throws RemoteException {
                    callback.onReceiveStatus(status);
                }
            });
            return;
        }
        C9490l.m59351c("PendingCall", "api is null");
        synchronized (this.lock) {
            this.mResult.setStatusCode(12);
        }
        callback.onReceiveStatus(getResult());
    }

    public void setResult(Status<R> status) {
        synchronized (this.lock) {
            this.mResult = status;
            this.f20972b = true;
        }
    }

    public Status<R> await(long j10, TimeUnit timeUnit) {
        awaitOnAnyThread();
        synchronized (this.lock) {
            if (!this.f20972b) {
                try {
                    C9490l.m59349a("PendingCall", "await:" + this.f20971a.await(j10, timeUnit));
                } catch (InterruptedException unused) {
                    C9490l.m59353e("PendingCall", "InterruptedException");
                }
            }
        }
        return getResult();
    }
}
