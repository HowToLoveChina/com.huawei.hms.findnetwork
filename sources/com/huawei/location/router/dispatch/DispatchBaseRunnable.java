package com.huawei.location.router.dispatch;

import as.C1016d;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.entity.RouterRequest;
import es.C9540e;
import es.C9552q;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import mr.C11506a;

/* loaded from: classes8.dex */
public abstract class DispatchBaseRunnable implements IDispatchExceptionListener {
    private static final int AGC_AUTH_TIME_OUT = 3;
    private static final String TAG = "DispatchBaseRunnable";
    protected BaseRouterTaskCallImpl apiRequest;
    protected boolean isError = false;
    protected RouterRequest routerRequest;

    /* renamed from: com.huawei.location.router.dispatch.DispatchBaseRunnable$a */
    public class CallableC6808a implements Callable<Boolean> {
        public CallableC6808a() {
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() throws Exception {
            return Boolean.valueOf(DispatchBaseRunnable.this.agcAuth());
        }
    }

    public DispatchBaseRunnable(RouterRequest routerRequest) {
        this.routerRequest = routerRequest;
    }

    public boolean agcAuth() {
        if (C9552q.m59643a() != 100 || this.routerRequest.isResendFromHMS()) {
            return true;
        }
        return C11506a.m68682e().m68684b();
    }

    public boolean agcAuthDelay() {
        String str;
        try {
            FutureTask futureTask = new FutureTask(new CallableC6808a());
            C9540e.m59581d().m59583b(futureTask);
            return ((Boolean) futureTask.get(3L, TimeUnit.SECONDS)).booleanValue();
        } catch (InterruptedException unused) {
            str = "check agc future Interrupted error";
            C1016d.m6183c(TAG, str);
            return false;
        } catch (ExecutionException unused2) {
            str = "check agc future Execution error";
            C1016d.m6183c(TAG, str);
            return false;
        } catch (TimeoutException unused3) {
            str = "check agc future Timeout error";
            C1016d.m6183c(TAG, str);
            return false;
        }
    }

    public BaseRouterTaskCallImpl getApiRequest() {
        return this.apiRequest;
    }

    public RouterRequest getRouterRequest() {
        return this.routerRequest;
    }

    public void handlerErrorResult(int i10) {
        ErrorTaskCall errorTaskCall = new ErrorTaskCall();
        errorTaskCall.setRouterRequest(this.routerRequest);
        errorTaskCall.onComplete(i10);
    }

    @Override // com.huawei.location.router.dispatch.IDispatchExceptionListener
    public void onDispatchError(int i10, String str) {
        this.isError = true;
        if (i10 == 10001) {
            handlerErrorResult(LocationStatusCode.NOT_YET_SUPPORTED);
            return;
        }
        C1016d.m6183c(TAG, "other error code :" + i10 + "msg:" + str);
    }

    public void setApiRequest(BaseRouterTaskCallImpl baseRouterTaskCallImpl) {
        this.apiRequest = baseRouterTaskCallImpl;
    }
}
