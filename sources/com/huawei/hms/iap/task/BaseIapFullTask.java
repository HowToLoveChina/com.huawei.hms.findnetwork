package com.huawei.hms.iap.task;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.iap.IapApiException;
import com.huawei.hms.iap.entity.OrderStatusCode;
import com.huawei.hms.iapfull.IIapFullAPIVer4;
import com.huawei.hms.iapfull.IapFullAPIFactory;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes8.dex */
public abstract class BaseIapFullTask<V extends Result, E> extends Task<V> {
    protected boolean mIsCompleted;
    protected boolean mIsSuccessful;
    protected InterfaceC8938f mOnFailureListener;
    protected InterfaceC8939g<V> mOnSuccessListener;
    protected V mResult;

    public BaseIapFullTask(Context context, E e10) {
        setResult();
        if (context != null) {
            handleRequest(e10, IapFullAPIFactory.createIapFullAPIVer4(context));
            return;
        }
        HMSLog.m36986e("BaseIapFullTask", "context is null.");
        this.mResult.setStatus(new Status(OrderStatusCode.ORDER_STATE_PARAM_ERROR, "param is error"));
        this.mIsSuccessful = false;
        this.mIsCompleted = true;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<V> addOnFailureListener(Activity activity, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<V> addOnSuccessListener(Activity activity, InterfaceC8939g<V> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        return null;
    }

    @Override // com.huawei.hmf.tasks.Task
    public V getResult() {
        return this.mResult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <E extends Throwable> V getResultThrowException(Class<E> cls) throws Throwable {
        return null;
    }

    public abstract void handleRequest(E e10, IIapFullAPIVer4 iIapFullAPIVer4);

    public void handleRequestFailed(int i10, String str) {
        this.mIsSuccessful = false;
        this.mIsCompleted = true;
        InterfaceC8938f interfaceC8938f = this.mOnFailureListener;
        if (interfaceC8938f != null) {
            interfaceC8938f.onFailure(new IapApiException(new Status(i10, str)));
        }
    }

    public void handleRequestSuccess() {
        this.mIsSuccessful = true;
        this.mIsCompleted = true;
        InterfaceC8939g<V> interfaceC8939g = this.mOnSuccessListener;
        if (interfaceC8939g != null) {
            interfaceC8939g.onSuccess(this.mResult);
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        return this.mIsCompleted;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        return this.mIsSuccessful;
    }

    public abstract void setResult();

    @Override // com.huawei.hmf.tasks.Task
    public Task<V> addOnFailureListener(InterfaceC8938f interfaceC8938f) {
        if (interfaceC8938f != null) {
            if (!isComplete() || isSuccessful()) {
                this.mOnFailureListener = interfaceC8938f;
            } else {
                interfaceC8938f.onFailure(new IapApiException(this.mResult.getStatus()));
            }
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<V> addOnSuccessListener(InterfaceC8939g<V> interfaceC8939g) {
        if (interfaceC8939g != null) {
            if (isComplete() && isSuccessful()) {
                interfaceC8939g.onSuccess(this.mResult);
            } else {
                this.mOnSuccessListener = interfaceC8939g;
            }
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<V> addOnFailureListener(Executor executor, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<V> addOnSuccessListener(Executor executor, InterfaceC8939g<V> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }
}
