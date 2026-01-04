package com.huawei.hms.support.api.paytask.fullsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.iap.IapApiException;
import com.huawei.hms.iapfull.IapFullAPIFactory;
import com.huawei.hms.iapfull.bean.WebProductDetailRequest;
import com.huawei.hms.iapfull.webpay.callback.WebPayCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hms.support.api.entity.pay.ProductDetailRequest;
import com.huawei.hms.support.api.entity.pay.ProductDetailResp;
import com.huawei.hms.support.api.pay.ProductDetailResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes8.dex */
public class ProductDetailTask extends Task<ProductDetailResult> {

    /* renamed from: a */
    private boolean f29862a;

    /* renamed from: b */
    private boolean f29863b;

    /* renamed from: c */
    private ProductDetailResult f29864c = new ProductDetailResult();

    /* renamed from: d */
    private InterfaceC8939g<ProductDetailResult> f29865d;

    /* renamed from: e */
    private InterfaceC8938f f29866e;

    public ProductDetailTask(Context context, ProductDetailRequest productDetailRequest) {
        if (context != null) {
            IapFullAPIFactory.createIapFullAPI(context).getProductDetail(m36690a(productDetailRequest), new WebPayCallback() { // from class: com.huawei.hms.support.api.paytask.fullsdk.ProductDetailTask.1
                public void onFailure(int i10, String str) {
                    ProductDetailResult productDetailResult = new ProductDetailResult();
                    productDetailResult.setStatus(new Status(i10, str));
                    ProductDetailTask.this.f29863b = false;
                    ProductDetailTask.this.f29864c = productDetailResult;
                    ProductDetailTask.this.f29862a = true;
                    if (ProductDetailTask.this.f29866e != null) {
                        ProductDetailTask.this.f29866e.onFailure(new IapApiException(ProductDetailTask.this.f29864c.getStatus()));
                    }
                }

                public void onSuccess(String str) {
                    ProductDetailResp productDetailResp = new ProductDetailResp();
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JsonUtil.jsonToEntity(str, productDetailResp);
                        } catch (IllegalArgumentException e10) {
                            HMSLog.m36986e("ProductDetailTask", "ProductDetailResp jsonToEntity " + e10.getMessage());
                        }
                    }
                    ProductDetailResult productDetailResult = new ProductDetailResult();
                    productDetailResult.setProductList(productDetailResp.productList);
                    productDetailResult.setStatus(new Status(productDetailResp.returnCode, productDetailResp.errMsg));
                    productDetailResult.setFailList(productDetailResp.getFailList());
                    productDetailResult.setProductList(productDetailResp.getProductList());
                    productDetailResult.setRequestId(productDetailResp.getRequestId());
                    ProductDetailTask.this.f29863b = true;
                    ProductDetailTask.this.f29864c = productDetailResult;
                    ProductDetailTask.this.f29862a = true;
                    if (ProductDetailTask.this.f29865d != null) {
                        ProductDetailTask.this.f29865d.onSuccess(ProductDetailTask.this.f29864c);
                    }
                }
            });
            return;
        }
        this.f29864c.setStatus(new Status(PayStatusCodes.PAY_STATE_PARAM_ERROR, "param is error"));
        this.f29863b = false;
        this.f29862a = true;
    }

    /* renamed from: a */
    private WebProductDetailRequest m36690a(ProductDetailRequest productDetailRequest) {
        WebProductDetailRequest webProductDetailRequest = new WebProductDetailRequest();
        webProductDetailRequest.setApplicationID(productDetailRequest.getApplicationID());
        webProductDetailRequest.setMerchantId(productDetailRequest.getMerchantId());
        webProductDetailRequest.setProductNos(productDetailRequest.getProductNos());
        webProductDetailRequest.setRequestId(productDetailRequest.getRequestId());
        webProductDetailRequest.setReservedInfor(productDetailRequest.getReservedInfor());
        return webProductDetailRequest;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<ProductDetailResult> addOnFailureListener(Activity activity, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<ProductDetailResult> addOnSuccessListener(Activity activity, InterfaceC8939g<ProductDetailResult> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.tasks.Task
    public ProductDetailResult getResult() {
        return this.f29864c;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.tasks.Task
    public <E extends Throwable> ProductDetailResult getResultThrowException(Class<E> cls) throws Throwable {
        return null;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        return this.f29862a;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        return this.f29863b;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<ProductDetailResult> addOnFailureListener(InterfaceC8938f interfaceC8938f) {
        if (interfaceC8938f != null) {
            if (isComplete()) {
                interfaceC8938f.onFailure(new IapApiException(this.f29864c.getStatus()));
            } else {
                this.f29866e = interfaceC8938f;
            }
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<ProductDetailResult> addOnSuccessListener(InterfaceC8939g<ProductDetailResult> interfaceC8939g) {
        if (interfaceC8939g != null) {
            this.f29865d = interfaceC8939g;
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<ProductDetailResult> addOnFailureListener(Executor executor, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<ProductDetailResult> addOnSuccessListener(Executor executor, InterfaceC8939g<ProductDetailResult> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }
}
