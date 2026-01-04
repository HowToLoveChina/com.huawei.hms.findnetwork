package com.huawei.hms.iap;

import android.text.TextUtils;
import com.huawei.hms.iap.entity.PurchaseIntentWithPriceReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.hms.iap.o */
/* loaded from: classes8.dex */
public class C5650o extends AbstractC5630b {

    /* renamed from: a */
    private PurchaseIntentWithPriceReq f25442a;

    public C5650o(String str, PurchaseIntentWithPriceReq purchaseIntentWithPriceReq, String str2, String str3) {
        super(str, JsonUtil.createJsonString(purchaseIntentWithPriceReq), str2, str3);
        this.f25442a = purchaseIntentWithPriceReq;
        m32999b();
    }

    /* renamed from: b */
    private void m32999b() {
        if (m32982a(this.f25442a.getReservedInfor())) {
            m32978a(11);
        } else if (m33000c()) {
            m32978a(4);
        } else if (m33001d()) {
            m32978a(4);
        }
    }

    /* renamed from: c */
    private boolean m33000c() {
        PurchaseIntentWithPriceReq purchaseIntentWithPriceReq = this.f25442a;
        if (purchaseIntentWithPriceReq == null || TextUtils.isEmpty(purchaseIntentWithPriceReq.getSignatureAlgorithm())) {
            return false;
        }
        HMSLog.m36988i("PurchaseIntentWithPriceTaskApiCall", "Use the SHA256WithRSA/PSS algorithm.");
        return true;
    }

    /* renamed from: d */
    private boolean m33001d() {
        PurchaseIntentWithPriceReq purchaseIntentWithPriceReq = this.f25442a;
        if (purchaseIntentWithPriceReq == null || TextUtils.isEmpty(purchaseIntentWithPriceReq.getReservedInfor())) {
            return false;
        }
        HMSLog.m36988i("PurchaseIntentWithPriceTaskApiCall", "reservedInfor is not empty");
        return true;
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public int mo32976a() {
        return m32982a(this.f25442a.getReservedInfor()) ? Constants.HMS_VERSION_CODE_61000000 : (m33000c() || m33001d()) ? 50300000 : 40002000;
    }
}
