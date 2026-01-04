package com.huawei.hms.iap;

import android.text.TextUtils;
import com.huawei.hms.iap.entity.PurchaseIntentReq;
import com.huawei.hms.iap.util.C5660b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.iap.n */
/* loaded from: classes8.dex */
public class C5649n extends AbstractC5630b {

    /* renamed from: a */
    private PurchaseIntentReq f25441a;

    public C5649n(String str, PurchaseIntentReq purchaseIntentReq, String str2, String str3) {
        super(str, JsonUtil.createJsonString(purchaseIntentReq), str2, str3);
        this.f25441a = purchaseIntentReq;
        m32993b();
    }

    /* renamed from: b */
    private void m32993b() {
        int i10;
        if (m32982a(this.f25441a.getReservedInfor())) {
            i10 = 11;
        } else {
            if (m32997f()) {
                m32978a(8);
                return;
            }
            if (m32996e()) {
                m32978a(8);
                return;
            }
            if (!m32998g()) {
                if (m32994c()) {
                    m32978a(4);
                    return;
                } else {
                    if (m32995d()) {
                        m32978a(4);
                        return;
                    }
                    return;
                }
            }
            i10 = 7;
        }
        m32978a(i10);
    }

    /* renamed from: c */
    private boolean m32994c() {
        PurchaseIntentReq purchaseIntentReq = this.f25441a;
        if (purchaseIntentReq == null || TextUtils.isEmpty(purchaseIntentReq.getSignatureAlgorithm())) {
            return false;
        }
        HMSLog.m36988i("PurchaseIntentTaskApiCall", "Use the SHA256WithRSA/PSS algorithm.");
        return true;
    }

    /* renamed from: d */
    private boolean m32995d() {
        PurchaseIntentReq purchaseIntentReq = this.f25441a;
        if (purchaseIntentReq == null || TextUtils.isEmpty(purchaseIntentReq.getReservedInfor())) {
            return false;
        }
        HMSLog.m36988i("PurchaseIntentTaskApiCall", "reservedInfor is not empty");
        return true;
    }

    /* renamed from: e */
    private boolean m32996e() {
        if (this.f25441a.getPriceType() != 2 && m32995d()) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(this.f25441a.getReservedInfor()).optJSONObject("orderPurchaseExtensionInformation");
                if (jSONObjectOptJSONObject == null || new JSONObject(jSONObjectOptJSONObject.optString("purchaseExtension")).optJSONObject("memberPoints") == null) {
                    return false;
                }
                HMSLog.m36988i("PurchaseIntentTaskApiCall", "isPassMemberPoints");
                return true;
            } catch (JSONException unused) {
                HMSLog.m36989w("PurchaseIntentTaskApiCall", "JSONException");
            }
        }
        return false;
    }

    /* renamed from: f */
    private boolean m32997f() {
        if (!m32995d()) {
            return false;
        }
        try {
            if (new JSONObject(this.f25441a.getReservedInfor()).has("offerCode")) {
                HMSLog.m36988i("PurchaseIntentTaskApiCall", "isSubscriptionBenefit");
                return true;
            }
        } catch (JSONException unused) {
            HMSLog.m36989w("PurchaseIntentTaskApiCall", "JSONException");
        }
        return false;
    }

    /* renamed from: g */
    private boolean m32998g() {
        if (this.f25441a.getPriceType() == 2 || !C5660b.m33023b(getRequestJson(), "enablePendingPurchases")) {
            return false;
        }
        HMSLog.m36988i("PurchaseIntentTaskApiCall", "Enable pending purchase.");
        return true;
    }

    @Override // com.huawei.hms.iap.AbstractC5629a
    /* renamed from: a */
    public int mo32976a() {
        if (m32982a(this.f25441a.getReservedInfor())) {
            return Constants.HMS_VERSION_CODE_61000000;
        }
        if (m32997f() || m32996e()) {
            return 60600000;
        }
        if (m32998g()) {
            return 60300000;
        }
        if (m32994c() || m32995d()) {
            return 50300000;
        }
        return super.mo32976a();
    }
}
