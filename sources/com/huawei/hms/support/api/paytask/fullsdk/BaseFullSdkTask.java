package com.huawei.hms.support.api.paytask.fullsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.iap.IapApiException;
import com.huawei.hms.iapfull.bean.PayRequest;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hms.support.api.entity.pay.internal.BaseReq;
import com.huawei.hms.support.api.pay.PayResult;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes8.dex */
public abstract class BaseFullSdkTask<T extends BaseReq> extends Task<PayResult> {

    /* renamed from: b */
    private boolean f29853b;
    protected Context mContext;
    protected T mRequest;
    protected Intent mIntent = getFullSdkIntent();

    /* renamed from: a */
    private PayResult f29852a = new PayResult();

    public BaseFullSdkTask(Context context, T t10) {
        this.mContext = context;
        this.mRequest = t10;
        this.f29852a.setStatus(this.mIntent == null ? new Status(PayStatusCodes.PAY_STATE_PARAM_ERROR, "param is error") : new Status(0, "success", this.mIntent));
        this.f29853b = true;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PayResult> addOnFailureListener(Activity activity, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PayResult> addOnSuccessListener(Activity activity, InterfaceC8939g<PayResult> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }

    public boolean checkFieldExist(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.getName().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract PayRequest createRequestParams();

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        return null;
    }

    public abstract Intent getFullSdkIntent();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.tasks.Task
    public PayResult getResult() {
        return this.f29852a;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.tasks.Task
    public <E extends Throwable> PayResult getResultThrowException(Class<E> cls) throws Throwable {
        return null;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        return this.f29853b;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        return this.mIntent != null;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PayResult> addOnFailureListener(InterfaceC8938f interfaceC8938f) {
        if (interfaceC8938f != null && !isSuccessful()) {
            interfaceC8938f.onFailure(new IapApiException(this.f29852a.getStatus()));
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PayResult> addOnSuccessListener(InterfaceC8939g<PayResult> interfaceC8939g) {
        if (interfaceC8939g != null && isSuccessful()) {
            interfaceC8939g.onSuccess(this.f29852a);
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PayResult> addOnFailureListener(Executor executor, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PayResult> addOnSuccessListener(Executor executor, InterfaceC8939g<PayResult> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }
}
