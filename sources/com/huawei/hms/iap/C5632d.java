package com.huawei.hms.iap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseReq;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseResult;
import com.huawei.hms.iap.entity.IsEnvReadyReq;
import com.huawei.hms.iap.entity.IsEnvReadyResult;
import com.huawei.hms.iap.entity.IsSandboxActivatedReq;
import com.huawei.hms.iap.entity.IsSandboxActivatedResult;
import com.huawei.hms.iap.entity.OwnedPurchasesReq;
import com.huawei.hms.iap.entity.OwnedPurchasesResult;
import com.huawei.hms.iap.entity.ProductInfoReq;
import com.huawei.hms.iap.entity.ProductInfoResult;
import com.huawei.hms.iap.entity.PurchaseIntentReq;
import com.huawei.hms.iap.entity.PurchaseIntentResult;
import com.huawei.hms.iap.entity.PurchaseIntentWithPriceReq;
import com.huawei.hms.iap.entity.PurchaseResultInfo;
import com.huawei.hms.iap.entity.RedeemCodeResultInfo;
import com.huawei.hms.iap.entity.ScanRedeemCodeResult;
import com.huawei.hms.iap.entity.StartIapActivityReq;
import com.huawei.hms.iap.entity.StartIapActivityResult;
import com.huawei.hms.iap.task.IapFailureTask;
import com.huawei.hms.iap.util.C5659a;
import com.huawei.hms.iap.util.C5661c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.iap.d */
/* loaded from: classes8.dex */
public class C5632d implements IapClient {

    /* renamed from: a */
    private WeakReference<Context> f25373a;

    /* renamed from: b */
    private String f25374b;

    /* renamed from: c */
    private boolean f25375c;

    /* renamed from: d */
    private String f25376d;

    /* renamed from: e */
    private C5641f f25377e;

    /* renamed from: f */
    private C5633e f25378f;

    public C5632d(Activity activity) {
        this.f25373a = new WeakReference<>(activity);
    }

    /* renamed from: a */
    private C5641f m32984a() {
        C5641f c5641f;
        C5641f c5641f2 = this.f25377e;
        if (c5641f2 != null) {
            return c5641f2;
        }
        Context context = this.f25373a.get();
        if (context == null) {
            HMSLog.m36986e("IapClientEntryImpl", "getIapClientImpl context is null.");
            return null;
        }
        String strM32985b = m32985b();
        strM32985b.hashCode();
        switch (strM32985b) {
            case "MCP_MODE":
                String str = TextUtils.isEmpty(this.f25374b) ? this.f25376d : this.f25374b;
                this.f25377e = context instanceof Activity ? new C5641f((Activity) context, str) : new C5641f(context, str);
                break;
            case "GENERAL_MODE":
                c5641f = context instanceof Activity ? new C5641f((Activity) context) : new C5641f(context);
                this.f25377e = c5641f;
                break;
            case "CONSIGNMENT_MODE":
                c5641f = context instanceof Activity ? new C5641f((Activity) context, this.f25376d, this.f25375c) : new C5641f(context, this.f25376d, this.f25375c);
                this.f25377e = c5641f;
                break;
        }
        return this.f25377e;
    }

    /* renamed from: b */
    private String m32985b() {
        return this.f25375c ? !TextUtils.isEmpty(this.f25376d) ? "CONSIGNMENT_MODE" : "GENERAL_MODE" : (TextUtils.isEmpty(this.f25374b) && TextUtils.isEmpty(this.f25376d)) ? "GENERAL_MODE" : "MCP_MODE";
    }

    /* renamed from: c */
    private C5633e m32986c() {
        C5633e c5633e;
        C5633e c5633e2 = this.f25378f;
        if (c5633e2 != null) {
            return c5633e2;
        }
        Context context = this.f25373a.get();
        if (context == null) {
            HMSLog.m36986e("IapClientEntryImpl", "getIapClientFullImpl context is null.");
            return null;
        }
        String strM32985b = m32985b();
        strM32985b.hashCode();
        switch (strM32985b) {
            case "MCP_MODE":
                this.f25378f = new C5633e(context, TextUtils.isEmpty(this.f25374b) ? this.f25376d : this.f25374b);
                break;
            case "GENERAL_MODE":
                c5633e = new C5633e(context);
                this.f25378f = c5633e;
                break;
            case "CONSIGNMENT_MODE":
                c5633e = new C5633e(context, this.f25376d);
                this.f25378f = c5633e;
                break;
        }
        return this.f25378f;
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<ConsumeOwnedPurchaseResult> consumeOwnedPurchase(ConsumeOwnedPurchaseReq consumeOwnedPurchaseReq) {
        Checker.checkNonNull(consumeOwnedPurchaseReq);
        Context context = this.f25373a.get();
        if (context == null) {
            HMSLog.m36986e("IapClientEntryImpl", "consumeOwnedPurchase context is null.");
            return new IapFailureTask();
        }
        if (!C5659a.m33013a(context, consumeOwnedPurchaseReq.getReservedInfor())) {
            C5641f c5641fM32984a = m32984a();
            return c5641fM32984a != null ? c5641fM32984a.consumeOwnedPurchase(consumeOwnedPurchaseReq) : new IapFailureTask();
        }
        HMSLog.m36988i("IapClientEntryImpl", "consumeOwnedPurchase with Full SDK branch.");
        C5633e c5633eM32986c = m32986c();
        return c5633eM32986c != null ? c5633eM32986c.consumeOwnedPurchase(consumeOwnedPurchaseReq) : new IapFailureTask();
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<PurchaseIntentResult> createPurchaseIntent(PurchaseIntentReq purchaseIntentReq) {
        Checker.checkNonNull(purchaseIntentReq);
        Context context = this.f25373a.get();
        if (context == null) {
            HMSLog.m36986e("IapClientEntryImpl", "createPurchaseIntent context is null.");
            return new IapFailureTask();
        }
        if (!C5659a.m33013a(context, purchaseIntentReq.getReservedInfor())) {
            C5641f c5641fM32984a = m32984a();
            return c5641fM32984a != null ? c5641fM32984a.createPurchaseIntent(purchaseIntentReq) : new IapFailureTask();
        }
        HMSLog.m36988i("IapClientEntryImpl", "createPurchaseIntent with Full SDK branch.");
        C5633e c5633eM32986c = m32986c();
        return c5633eM32986c != null ? c5633eM32986c.createPurchaseIntent(purchaseIntentReq) : new IapFailureTask();
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<PurchaseIntentResult> createPurchaseIntentWithPrice(PurchaseIntentWithPriceReq purchaseIntentWithPriceReq) {
        C5641f c5641fM32984a = m32984a();
        return c5641fM32984a != null ? c5641fM32984a.createPurchaseIntentWithPrice(purchaseIntentWithPriceReq) : new IapFailureTask();
    }

    @Override // com.huawei.hms.iap.IapClient
    public void enablePendingPurchase() {
        C5641f c5641fM32984a = m32984a();
        if (c5641fM32984a != null) {
            c5641fM32984a.enablePendingPurchase();
        }
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsEnvReadyResult> isEnvReady() {
        return isEnvReady(false);
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsSandboxActivatedResult> isSandboxActivated(IsSandboxActivatedReq isSandboxActivatedReq) {
        Checker.checkNonNull(isSandboxActivatedReq);
        C5641f c5641fM32984a = m32984a();
        return c5641fM32984a != null ? c5641fM32984a.isSandboxActivated(isSandboxActivatedReq) : new IapFailureTask();
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<OwnedPurchasesResult> obtainOwnedPurchaseRecord(OwnedPurchasesReq ownedPurchasesReq) {
        Checker.checkNonNull(ownedPurchasesReq);
        Context context = this.f25373a.get();
        if (context == null) {
            HMSLog.m36986e("IapClientEntryImpl", "obtainOwnedPurchaseRecord context is null.");
            return new IapFailureTask();
        }
        if (!C5659a.m33013a(context, ownedPurchasesReq.getReservedInfor())) {
            C5641f c5641fM32984a = m32984a();
            return c5641fM32984a != null ? c5641fM32984a.obtainOwnedPurchaseRecord(ownedPurchasesReq) : new IapFailureTask();
        }
        HMSLog.m36988i("IapClientEntryImpl", "obtainOwnedPurchaseRecord with Full SDK branch.");
        C5633e c5633eM32986c = m32986c();
        return c5633eM32986c != null ? c5633eM32986c.obtainOwnedPurchaseRecord(ownedPurchasesReq) : new IapFailureTask();
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<OwnedPurchasesResult> obtainOwnedPurchases(OwnedPurchasesReq ownedPurchasesReq) {
        Checker.checkNonNull(ownedPurchasesReq);
        Context context = this.f25373a.get();
        if (context == null) {
            HMSLog.m36986e("IapClientEntryImpl", "obtainOwnedPurchases context is null.");
            return new IapFailureTask();
        }
        if (!C5659a.m33013a(context, ownedPurchasesReq.getReservedInfor())) {
            C5641f c5641fM32984a = m32984a();
            return c5641fM32984a != null ? c5641fM32984a.obtainOwnedPurchases(ownedPurchasesReq) : new IapFailureTask();
        }
        HMSLog.m36988i("IapClientEntryImpl", "obtainOwnedPurchases with Full SDK branch.");
        C5633e c5633eM32986c = m32986c();
        return c5633eM32986c != null ? c5633eM32986c.obtainOwnedPurchases(ownedPurchasesReq) : new IapFailureTask();
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<ProductInfoResult> obtainProductInfo(ProductInfoReq productInfoReq) {
        Checker.checkNonNull(productInfoReq);
        Context context = this.f25373a.get();
        if (context == null) {
            HMSLog.m36986e("IapClientEntryImpl", "obtainProductInfo context is null.");
            return new IapFailureTask();
        }
        if (!C5659a.m33013a(context, productInfoReq.getReservedInfor())) {
            C5641f c5641fM32984a = m32984a();
            return c5641fM32984a != null ? c5641fM32984a.obtainProductInfo(productInfoReq) : new IapFailureTask();
        }
        HMSLog.m36988i("IapClientEntryImpl", "obtainProductInfo with Full SDK branch.");
        C5633e c5633eM32986c = m32986c();
        return c5633eM32986c != null ? c5633eM32986c.obtainProductInfo(productInfoReq) : new IapFailureTask();
    }

    @Override // com.huawei.hms.iap.IapClient
    public PurchaseResultInfo parsePurchaseResultInfoFromIntent(Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (!C5661c.m33028a(intent, "isFullSdk", false)) {
            C5641f c5641fM32984a = m32984a();
            return c5641fM32984a != null ? c5641fM32984a.parsePurchaseResultInfoFromIntent(intent) : new PurchaseResultInfo();
        }
        HMSLog.m36988i("IapClientEntryImpl", "parsePurchaseResultInfoFromIntent with Full SDK branch.");
        C5633e c5633eM32986c = m32986c();
        return c5633eM32986c != null ? c5633eM32986c.parsePurchaseResultInfoFromIntent(intent) : new PurchaseResultInfo();
    }

    @Override // com.huawei.hms.iap.IapClient
    public RedeemCodeResultInfo parseRedeemCodeResultInfoFromIntent(Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        C5641f c5641fM32984a = m32984a();
        return c5641fM32984a != null ? c5641fM32984a.parseRedeemCodeResultInfoFromIntent(intent) : new RedeemCodeResultInfo();
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<ScanRedeemCodeResult> scanRedeemCode() {
        C5641f c5641fM32984a = m32984a();
        return c5641fM32984a != null ? c5641fM32984a.scanRedeemCode() : new IapFailureTask();
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<StartIapActivityResult> startIapActivity(StartIapActivityReq startIapActivityReq) {
        Checker.checkNonNull(startIapActivityReq);
        C5641f c5641fM32984a = m32984a();
        return c5641fM32984a != null ? c5641fM32984a.startIapActivity(startIapActivityReq) : new IapFailureTask();
    }

    public C5632d(Activity activity, String str) {
        this.f25373a = new WeakReference<>(activity);
        this.f25374b = str;
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsEnvReadyResult> isEnvReady(IsEnvReadyReq isEnvReadyReq) {
        Checker.checkNonNull(isEnvReadyReq);
        Context context = this.f25373a.get();
        if (context == null) {
            HMSLog.m36986e("IapClientEntryImpl", "isEnvReady context is null.");
            return new IapFailureTask();
        }
        if (!C5659a.m33013a(context, isEnvReadyReq.getReservedInfor())) {
            return new IapFailureTask();
        }
        HMSLog.m36988i("IapClientEntryImpl", "isEnvReady with Full SDK branch.");
        C5633e c5633eM32986c = m32986c();
        return c5633eM32986c != null ? c5633eM32986c.isEnvReady(isEnvReadyReq) : new IapFailureTask();
    }

    public C5632d(Activity activity, String str, boolean z10) {
        this.f25373a = new WeakReference<>(activity);
        this.f25376d = str;
        this.f25375c = z10;
    }

    @Override // com.huawei.hms.iap.IapClient
    public Task<IsEnvReadyResult> isEnvReady(boolean z10) {
        C5641f c5641fM32984a = m32984a();
        return c5641fM32984a != null ? c5641fM32984a.isEnvReady(z10) : new IapFailureTask();
    }

    public C5632d(Context context) {
        this.f25373a = new WeakReference<>(context);
    }

    public C5632d(Context context, String str) {
        this.f25373a = new WeakReference<>(context);
        this.f25374b = str;
    }

    public C5632d(Context context, String str, boolean z10) {
        this.f25373a = new WeakReference<>(context);
        this.f25376d = str;
        this.f25375c = z10;
    }
}
