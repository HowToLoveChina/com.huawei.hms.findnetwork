package com.huawei.hms.support.api.paytask.fullsdk;

import android.app.Activity;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes8.dex */
public class FailureTask<T extends Result> extends Task<T> {

    /* renamed from: a */
    private int f29854a;

    /* renamed from: b */
    private String f29855b;

    public FailureTask() {
        this(-1, "context weak ref is recycled");
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<T> addOnFailureListener(Activity activity, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<T> addOnSuccessListener(Activity activity, InterfaceC8939g<T> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        return null;
    }

    @Override // com.huawei.hmf.tasks.Task
    public T getResult() {
        return null;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <E extends Throwable> T getResultThrowException(Class<E> cls) throws Throwable {
        return null;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        return true;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        return false;
    }

    public FailureTask(int i10, String str) {
        this.f29854a = i10;
        this.f29855b = str;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<T> addOnFailureListener(InterfaceC8938f interfaceC8938f) {
        if (interfaceC8938f == null) {
            return this;
        }
        interfaceC8938f.onFailure(new ApiException(new Status(this.f29854a, this.f29855b)));
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<T> addOnSuccessListener(InterfaceC8939g<T> interfaceC8939g) {
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<T> addOnFailureListener(Executor executor, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<T> addOnSuccessListener(Executor executor, InterfaceC8939g<T> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }
}
