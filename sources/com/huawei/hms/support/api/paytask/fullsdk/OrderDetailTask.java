package com.huawei.hms.support.api.paytask.fullsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.iap.IapApiException;
import com.huawei.hms.iapfull.IapFullAPIFactory;
import com.huawei.hms.iapfull.bean.WebOrderRequest;
import com.huawei.hms.iapfull.webpay.callback.WebPayCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.OrderRequest;
import com.huawei.hms.support.api.entity.pay.OrderResp;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hms.support.api.pay.OrderResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes8.dex */
public class OrderDetailTask extends Task<OrderResult> {

    /* renamed from: a */
    private boolean f29856a;

    /* renamed from: b */
    private boolean f29857b;

    /* renamed from: c */
    private OrderResult f29858c = new OrderResult();

    /* renamed from: d */
    private InterfaceC8939g<OrderResult> f29859d;

    /* renamed from: e */
    private InterfaceC8938f f29860e;

    public OrderDetailTask(Context context, OrderRequest orderRequest) {
        if (context != null) {
            IapFullAPIFactory.createIapFullAPI(context).getOrderDetail(m36683a(orderRequest), new WebPayCallback() { // from class: com.huawei.hms.support.api.paytask.fullsdk.OrderDetailTask.1
                public void onFailure(int i10, String str) {
                    OrderResp orderResp = new OrderResp();
                    orderResp.setCommonStatus(new Status(i10, str));
                    OrderDetailTask.this.f29857b = false;
                    OrderDetailTask.this.f29858c = new OrderResult(orderResp);
                    OrderDetailTask.this.f29856a = true;
                    if (OrderDetailTask.this.f29860e != null) {
                        OrderDetailTask.this.f29860e.onFailure(new IapApiException(OrderDetailTask.this.f29858c.getStatus()));
                    }
                }

                public void onSuccess(String str) {
                    OrderResp orderResp = new OrderResp();
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JsonUtil.jsonToEntity(str, orderResp);
                        } catch (IllegalArgumentException e10) {
                            HMSLog.m36986e("ProductDetailTask", "OrderResp jsonToEntity " + e10.getMessage());
                        }
                    }
                    OrderResult orderResult = new OrderResult(orderResp);
                    OrderDetailTask.this.f29857b = true;
                    OrderDetailTask.this.f29858c = orderResult;
                    OrderDetailTask.this.f29856a = true;
                    if (OrderDetailTask.this.f29859d != null) {
                        OrderDetailTask.this.f29859d.onSuccess(OrderDetailTask.this.f29858c);
                    }
                }
            });
            return;
        }
        this.f29858c.setStatus(new Status(PayStatusCodes.PAY_STATE_PARAM_ERROR, "param is error"));
        this.f29857b = false;
        this.f29856a = true;
    }

    /* renamed from: a */
    private WebOrderRequest m36683a(OrderRequest orderRequest) {
        WebOrderRequest webOrderRequest = new WebOrderRequest();
        webOrderRequest.setMerchantId(orderRequest.getMerchantId());
        webOrderRequest.setRequestId(orderRequest.getRequestId());
        webOrderRequest.setKeyType(orderRequest.getKeyType());
        webOrderRequest.setTime(orderRequest.getTime());
        webOrderRequest.setReservedInfor(orderRequest.getReservedInfor());
        webOrderRequest.setSign(orderRequest.getSign());
        webOrderRequest.setSignatureAlgorithm(orderRequest.getSignatureAlgorithm());
        return webOrderRequest;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<OrderResult> addOnFailureListener(Activity activity, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<OrderResult> addOnSuccessListener(Activity activity, InterfaceC8939g<OrderResult> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.tasks.Task
    public OrderResult getResult() {
        return this.f29858c;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.tasks.Task
    public <E extends Throwable> OrderResult getResultThrowException(Class<E> cls) throws Throwable {
        return null;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        return this.f29856a;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        return this.f29857b;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<OrderResult> addOnFailureListener(InterfaceC8938f interfaceC8938f) {
        if (interfaceC8938f != null) {
            if (isComplete()) {
                interfaceC8938f.onFailure(new IapApiException(this.f29858c.getStatus()));
            } else {
                this.f29860e = interfaceC8938f;
            }
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<OrderResult> addOnSuccessListener(InterfaceC8939g<OrderResult> interfaceC8939g) {
        if (interfaceC8939g != null) {
            this.f29859d = interfaceC8939g;
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<OrderResult> addOnFailureListener(Executor executor, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<OrderResult> addOnSuccessListener(Executor executor, InterfaceC8939g<OrderResult> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }
}
