package com.huawei.hms.support.api.paytask.fullsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.iap.IapApiException;
import com.huawei.hms.iapfull.IapFullAPIFactory;
import com.huawei.hms.iapfull.bean.WebPurchaseInfoRequest;
import com.huawei.hms.iapfull.webpay.callback.WebPayCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoResp;
import com.huawei.hms.support.api.pay.PurchaseInfoResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes8.dex */
public class PurchaseInfoTask extends Task<PurchaseInfoResult> {

    /* renamed from: a */
    private boolean f29868a;

    /* renamed from: b */
    private boolean f29869b;

    /* renamed from: c */
    private PurchaseInfoResult f29870c = new PurchaseInfoResult();

    /* renamed from: d */
    private InterfaceC8939g<PurchaseInfoResult> f29871d;

    /* renamed from: e */
    private InterfaceC8938f f29872e;

    public PurchaseInfoTask(Context context, PurchaseInfoRequest purchaseInfoRequest) {
        if (context != null) {
            IapFullAPIFactory.createIapFullAPI(context).getPurchaseInfo(m36697a(purchaseInfoRequest), new WebPayCallback() { // from class: com.huawei.hms.support.api.paytask.fullsdk.PurchaseInfoTask.1
                public void onFailure(int i10, String str) {
                    PurchaseInfoResp purchaseInfoResp = new PurchaseInfoResp();
                    purchaseInfoResp.setCommonStatus(new Status(i10, str));
                    PurchaseInfoTask.this.f29869b = false;
                    PurchaseInfoTask.this.f29870c = new PurchaseInfoResult(purchaseInfoResp);
                    PurchaseInfoTask.this.f29868a = true;
                    if (PurchaseInfoTask.this.f29872e != null) {
                        PurchaseInfoTask.this.f29872e.onFailure(new IapApiException(PurchaseInfoTask.this.f29870c.getStatus()));
                    }
                }

                public void onSuccess(String str) {
                    PurchaseInfoResp purchaseInfoResp = new PurchaseInfoResp();
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JsonUtil.jsonToEntity(str, purchaseInfoResp);
                        } catch (IllegalArgumentException e10) {
                            HMSLog.m36986e("ProductDetailTask", "ProductDetailResp jsonToEntity " + e10.getMessage());
                        }
                    }
                    PurchaseInfoResult purchaseInfoResult = new PurchaseInfoResult(purchaseInfoResp);
                    PurchaseInfoTask.this.f29869b = true;
                    PurchaseInfoTask.this.f29870c = purchaseInfoResult;
                    PurchaseInfoTask.this.f29868a = true;
                    if (PurchaseInfoTask.this.f29871d != null) {
                        PurchaseInfoTask.this.f29871d.onSuccess(PurchaseInfoTask.this.f29870c);
                    }
                }
            });
            return;
        }
        this.f29870c.setStatus(new Status(PayStatusCodes.PAY_STATE_PARAM_ERROR, "param is error"));
        this.f29869b = false;
        this.f29868a = true;
    }

    /* renamed from: a */
    private WebPurchaseInfoRequest m36697a(PurchaseInfoRequest purchaseInfoRequest) {
        WebPurchaseInfoRequest webPurchaseInfoRequest = new WebPurchaseInfoRequest();
        webPurchaseInfoRequest.setAppId(purchaseInfoRequest.getAppId());
        webPurchaseInfoRequest.setMerchantId(purchaseInfoRequest.getMerchantId());
        webPurchaseInfoRequest.setPageNo(purchaseInfoRequest.getPageNo());
        webPurchaseInfoRequest.setPriceType(purchaseInfoRequest.getPriceType());
        webPurchaseInfoRequest.setProductId(purchaseInfoRequest.getProductId());
        webPurchaseInfoRequest.setReservedInfor(purchaseInfoRequest.getReservedInfor());
        webPurchaseInfoRequest.setSign(purchaseInfoRequest.getSign());
        webPurchaseInfoRequest.setSignatureAlgorithm(purchaseInfoRequest.getSignatureAlgorithm());
        webPurchaseInfoRequest.setTs(purchaseInfoRequest.getTs());
        return webPurchaseInfoRequest;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PurchaseInfoResult> addOnFailureListener(Activity activity, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PurchaseInfoResult> addOnSuccessListener(Activity activity, InterfaceC8939g<PurchaseInfoResult> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.tasks.Task
    public PurchaseInfoResult getResult() {
        return this.f29870c;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.tasks.Task
    public <E extends Throwable> PurchaseInfoResult getResultThrowException(Class<E> cls) throws Throwable {
        return null;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        return this.f29868a;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        return this.f29869b;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PurchaseInfoResult> addOnFailureListener(InterfaceC8938f interfaceC8938f) {
        if (interfaceC8938f != null) {
            if (isComplete()) {
                interfaceC8938f.onFailure(new IapApiException(this.f29870c.getStatus()));
            } else {
                this.f29872e = interfaceC8938f;
            }
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PurchaseInfoResult> addOnSuccessListener(InterfaceC8939g<PurchaseInfoResult> interfaceC8939g) {
        if (interfaceC8939g != null) {
            this.f29871d = interfaceC8939g;
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PurchaseInfoResult> addOnFailureListener(Executor executor, InterfaceC8938f interfaceC8938f) {
        addOnFailureListener(interfaceC8938f);
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<PurchaseInfoResult> addOnSuccessListener(Executor executor, InterfaceC8939g<PurchaseInfoResult> interfaceC8939g) {
        addOnSuccessListener(interfaceC8939g);
        return this;
    }
}
